package me.creeper.creepermodtest.computers;

import me.creeper.creepermodtest.computers.libs.*;
import org.luaj.vm2.*;
import org.luaj.vm2.compiler.LuaC;
import org.luaj.vm2.lib.DebugLib;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.ZeroArgFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LuaSandbox {
    protected Globals  globals;

    protected LuaTable modules;

    protected LuaTable mathLib;
    protected LuaTable httpLib;
    protected LuaTable timeLib;
    protected LuaTable stringLib;
    protected LuaTable randLib;

    private final List<Consumer<String>> outputListeners = new ArrayList<>();

    public void addOutputListener(Consumer<String> listener) {
        outputListeners.add(listener);
    }
    public void removeOutputListener(Consumer<String> listener) {
        outputListeners.remove(listener);
    }

    public volatile boolean paused = false;
    public volatile long delayMs   = 50;

    public void applyDelay() {
        try {
            paused = true;
            if (delayMs > 0) Thread.sleep(delayMs);
            paused = false;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public LuaSandbox() {
        globals = new Globals();
        LuaC.install(globals);

        modules = new LuaTable();


        mathLib = MathLib.create(this);
        modules.set("math", mathLib);

        httpLib = HTTPLib.create(this);
        modules.set("http", httpLib);

        timeLib = TimeLib.create(this);
        modules.set("time", timeLib);

        stringLib = StringLib.create(this);
        modules.set("string", stringLib);

        randLib = RandLib.create(this);
        modules.set("rand", randLib);


        globals.set("require", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                applyDelay();

                String moduleName = arg1.checkjstring();

                LuaValue lib = modules.get(moduleName);
                if (lib.isnil()) {
                    return LuaValue.error("module '" + moduleName + "' not found");
                }

                return lib;
            }
        });
        globals.set("print", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                applyDelay();

                String text = arg1.tojstring() + "\n";
                for (Consumer<String> listener : outputListeners) {
                    listener.accept(text);
                }
                return LuaValue.NIL;
            }
        });

        LuaFunction hook = new ZeroArgFunction() {
            @Override
            public LuaValue call() {
                applyDelay();
                return LuaValue.NIL;
            }
        };

        globals.load(new DebugLib());
        globals.get("debug").get("sethook").call(
                hook,
                LuaValue.valueOf("c"),
                LuaValue.valueOf(1)    // every '1' instruction[s]
        );
        globals.set("debug", LuaValue.NIL);
    }

    public Result run(String code) {
        StringBuilder out = new StringBuilder();
        Consumer<String> accumulator = out::append;
        addOutputListener(accumulator);
        try {
            LuaValue chunk = globals.load(code, "sandboxed");
            chunk.call();
            return new Result(out.toString());
        } catch (LuaError e) {
            String msg = e.getMessage();
            outputListeners.forEach(l -> l.accept(msg));
            return new Result(out.toString(), true);
        } finally {
            removeOutputListener(accumulator);
        }
    }
}

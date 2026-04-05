package me.creeper.creepermodtest.computers;

import me.creeper.creepermodtest.computers.libs.HTTPLib;
import me.creeper.creepermodtest.computers.libs.MathLib;
import org.luaj.vm2.*;
import org.luaj.vm2.compiler.LuaC;
import org.luaj.vm2.lib.OneArgFunction;

public class LuaSandbox {
    protected Globals  globals;
    protected LuaTable modules;
    protected LuaTable mathLib;
    protected LuaTable httpLib;

    public String out = "";

    public LuaSandbox() {
        globals = new Globals();
        LuaC.install(globals);

        modules = new LuaTable();

        mathLib = MathLib.create();
        modules.set("math", mathLib);
        httpLib = HTTPLib.create();
        modules.set("http", httpLib);

        globals.set("require", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
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
                String text = arg1.tojstring() + "\n";

                out += text;

                return LuaValue.NIL;
            }
        });
    }

    public Result run(String code) {
        try {
            LuaValue chunk = globals.load(code, "sandboxed");
            chunk.call();

            return new Result(out);
        } catch (LuaError e) {
            out += e.getMessage();

            return new Result(out, true);
        } finally {
            out = "";
        }
    }
}

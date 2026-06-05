package me.creeper.creepermodtest.computers.libs;

import me.creeper.creepermodtest.computers.LuaSandbox;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.ZeroArgFunction;

import java.util.Random;

public class RandLib {
    public static LuaTable create(LuaSandbox sandbox) {
        LuaTable rand = new LuaTable();

        rand.set("new", new ZeroArgFunction() {
            @Override
            public LuaValue call() {
                sandbox.applyDelay();

                Random internalRandom = new Random();
                LuaTable obj = new LuaTable();

                obj.set("next", new ZeroArgFunction() {
                    @Override
                    public LuaValue call() {
                        sandbox.applyDelay();

                        double val = internalRandom.nextDouble();

                        return LuaValue.valueOf(val);
                    }
                });

                obj.set("nextInt", new OneArgFunction() {
                    @Override
                    public LuaValue call(LuaValue arg1) {
                        sandbox.applyDelay();

                        int bound = arg1.checkint();
                        if (bound <= 0) { return LuaValue.NIL; }

                        int val = internalRandom.nextInt(bound);

                        return LuaValue.valueOf(val);
                    }
                });

                obj.set("nextBool", new ZeroArgFunction() {
                    @Override
                    public LuaValue call() {
                        sandbox.applyDelay();

                        boolean val = internalRandom.nextBoolean();

                        return LuaValue.valueOf(val);
                    }
                });

                obj.set("seed", new OneArgFunction() {
                    @Override
                    public LuaValue call(LuaValue arg1) {
                        sandbox.applyDelay();

                        internalRandom.setSeed(arg1.checklong());

                        return LuaValue.NIL;
                    }
                });

                return obj;
            }
        });

        return rand;
    }
}

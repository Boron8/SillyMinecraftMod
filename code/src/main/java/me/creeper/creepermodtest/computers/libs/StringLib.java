package me.creeper.creepermodtest.computers.libs;

import me.creeper.creepermodtest.computers.LuaSandbox;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.ThreeArgFunction;

public class StringLib {
    public static LuaTable create(LuaSandbox sandbox) {
        LuaTable string = new LuaTable();

        string.set("of", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                sandbox.applyDelay();

                return arg1.checkstring();
            }
        });
        string.set("len", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                sandbox.applyDelay();

                String x = arg1.checkjstring();

                return LuaValue.valueOf(x.length());
            }
        });
        string.set("upper", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                sandbox.applyDelay();

                String x = arg1.checkjstring();

                return LuaValue.valueOf(x.toUpperCase());
            }
        });
        string.set("lower", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                sandbox.applyDelay();

                String x = arg1.checkjstring();

                return LuaValue.valueOf(x.toLowerCase());
            }
        });
        string.set("replace", new ThreeArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1, LuaValue arg2, LuaValue arg3) {
                sandbox.applyDelay();

                String original = arg1.checkjstring();
                String from     = arg2.checkjstring();
                String to       = arg3.checkjstring();

                String new_     = original.replace(from, to);

                return LuaValue.valueOf(new_);
            }
        });


        return string;
    }
}

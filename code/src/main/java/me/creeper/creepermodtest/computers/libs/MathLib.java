package me.creeper.creepermodtest.computers.libs;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;

public class MathLib {
    public static LuaTable create() {
        LuaTable math = new LuaTable();

        math.set("PI", LuaValue.valueOf(Math.PI));
        math.set("E", LuaValue.valueOf(Math.E));

        math.set("sqrt", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                double x = arg1.checkdouble();

                if (x < 0) return LuaValue.NIL;
                double out = Math.sqrt(x);

                return LuaValue.valueOf(out);
            }
        });
        math.set("pow", new TwoArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1, LuaValue arg2) {
                double x = arg1.checkdouble();
                double y = arg2.checkdouble();

                double out = Math.pow(x, y);

                return LuaValue.valueOf(out);
            }
        });
        math.set("abs", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                double x = arg1.checkdouble();

                double out = Math.abs(x);

                return LuaValue.valueOf(out);
            }
        });
        math.set("min", new TwoArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1, LuaValue arg2) {
                double x = arg1.checkdouble();
                double y = arg2.checkdouble();

                double out = Math.min(x, y);

                return LuaValue.valueOf(out);
            }
        });
        math.set("max", new TwoArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1, LuaValue arg2) {
                double x = arg1.checkdouble();
                double y = arg2.checkdouble();

                double out = Math.max(x, y);

                return LuaValue.valueOf(out);
            }
        });

        return math;
    }
}

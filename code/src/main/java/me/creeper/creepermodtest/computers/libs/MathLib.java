package me.creeper.creepermodtest.computers.libs;

import me.creeper.creepermodtest.computers.LuaSandbox;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;

public class MathLib {
    public static LuaTable create(LuaSandbox sandbox) {
        LuaTable math = new LuaTable();

        math.set("PI", LuaValue.valueOf(Math.PI));
        math.set("E", LuaValue.valueOf(Math.E));

        math.set("sqrt", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                sandbox.applyDelay();

                double x = arg1.checkdouble();

                if (x < 0) return LuaValue.NIL;
                double out = Math.sqrt(x);

                return LuaValue.valueOf(out);
            }
        });
        math.set("pow", new TwoArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1, LuaValue arg2) {
                sandbox.applyDelay();

                double x = arg1.checkdouble();
                double y = arg2.checkdouble();

                double out = Math.pow(x, y);

                return LuaValue.valueOf(out);
            }
        });
        math.set("abs", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                sandbox.applyDelay();

                double x = arg1.checkdouble();

                double out = Math.abs(x);

                return LuaValue.valueOf(out);
            }
        });
        math.set("min", new TwoArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1, LuaValue arg2) {
                sandbox.applyDelay();

                double x = arg1.checkdouble();
                double y = arg2.checkdouble();

                double out = Math.min(x, y);

                return LuaValue.valueOf(out);
            }
        });
        math.set("max", new TwoArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1, LuaValue arg2) {
                sandbox.applyDelay();

                double x = arg1.checkdouble();
                double y = arg2.checkdouble();

                double out = Math.max(x, y);

                return LuaValue.valueOf(out);
            }
        });
        math.set("floor", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                sandbox.applyDelay();

                double x = arg1.checkdouble();

                double out = Math.floor(x);

                return LuaValue.valueOf(out);
            }
        });
        math.set("ceil", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                sandbox.applyDelay();

                double x = arg1.checkdouble();

                double out = Math.ceil(x);

                return LuaValue.valueOf(out);
            }
        });
        math.set("round", new TwoArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1, LuaValue arg2) {
                sandbox.applyDelay();

                double x = arg1.checkdouble();
                int y = arg1.checkint();

                double out = Math.round(x * Math.pow(10, y)) / Math.pow(10, y);

                return LuaValue.valueOf(out);
            }
        });
        math.set("log", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                sandbox.applyDelay();

                double x = arg1.checkdouble();

                double out = Math.log(x);

                return LuaValue.valueOf(out);
            }
        });
        math.set("sin", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                sandbox.applyDelay();

                double x = arg1.checkdouble();

                double result = Math.sin(x);

                return LuaValue.valueOf(result);
            }
        });
        math.set("cos", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                sandbox.applyDelay();

                double x = arg1.checkdouble();

                double result = Math.cos(x);

                return LuaValue.valueOf(result);
            }
        });
        math.set("tan", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                sandbox.applyDelay();

                double x = arg1.checkdouble();

                double result = Math.tan(x);

                return LuaValue.valueOf(result);
            }
        });
        math.set("asin", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                sandbox.applyDelay();

                double x = arg1.checkdouble();

                double result = Math.asin(x);

                return LuaValue.valueOf(result);
            }
        });
        math.set("acos", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                sandbox.applyDelay();

                double x = arg1.checkdouble();

                double result = Math.acos(x);

                return LuaValue.valueOf(result);
            }
        });
        math.set("atan", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                sandbox.applyDelay();

                double x = arg1.checkdouble();

                double result = Math.atan(x);

                return LuaValue.valueOf(result);
            }
        });

        return math;
    }
}

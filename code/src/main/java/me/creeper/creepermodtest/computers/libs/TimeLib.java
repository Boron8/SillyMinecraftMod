package me.creeper.creepermodtest.computers.libs;

import me.creeper.creepermodtest.computers.LuaSandbox;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.ZeroArgFunction;

import java.time.Instant;

public class TimeLib {
    public static LuaTable create(LuaSandbox sandbox) {
        LuaTable time = new LuaTable();

        time.set("time", new ZeroArgFunction() {
            @Override
            public LuaValue call() {
                sandbox.applyDelay();

                long unix = Instant.now().getEpochSecond();

                return LuaValue.valueOf(unix);
            }
        });


        return time;
    }
}

package me.creeper.creepermodtest.computers.libs;

import me.creeper.creepermodtest.ExampleMod;
import me.creeper.creepermodtest.computers.LuaSandbox;
import org.apache.commons.io.Charsets;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Lib {
    public static LuaTable create(LuaSandbox sandbox) {
        LuaTable base64 = new LuaTable();

        base64.set("encode", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                sandbox.applyDelay();

                byte[] data = arg1.checkjstring().getBytes(StandardCharsets.UTF_8);

                if (data.length > ExampleMod.getMainConfig().computers_base64_encode_max_bytes) { return LuaValue.NIL; }

                String encoded = new String(Base64.getEncoder().encode(data), StandardCharsets.UTF_8);
                return LuaValue.valueOf(encoded);
            }
        });
        base64.set("decode", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                sandbox.applyDelay();

                byte[] encoded = arg1.checkjstring().getBytes(StandardCharsets.UTF_8);

                if (encoded.length > ExampleMod.getMainConfig().computers_base64_decode_max_bytes) { return LuaValue.NIL; }

                try {
                    String data = new String(Base64.getDecoder().decode(encoded), Charsets.UTF_8);
                    return LuaValue.valueOf(data);
                } catch (IllegalArgumentException e) {
                    return LuaValue.NIL;
                }
            }
        });


        return base64;
    }
}

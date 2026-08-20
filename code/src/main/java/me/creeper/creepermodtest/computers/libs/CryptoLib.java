package me.creeper.creepermodtest.computers.libs;

import me.creeper.creepermodtest.ExampleMod;
import me.creeper.creepermodtest.computers.LuaSandbox;
import me.creeper.creepermodtest.utils.Hex;
import org.apache.commons.io.Charsets;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CryptoLib {

    public static LuaTable create(LuaSandbox sandbox) {
        LuaTable crypto = new LuaTable();

        LuaTable base64 = new LuaTable();
        LuaTable hash = new LuaTable();

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
        hash.set("sha256", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                sandbox.applyDelay();

                byte[] encoded = arg1.checkjstring().getBytes(StandardCharsets.UTF_8);

                if (encoded.length > ExampleMod.getMainConfig().computers_hashing_max_bytes) { return LuaValue.NIL; }

                try {
                    MessageDigest digest = MessageDigest.getInstance("SHA-256");
                    byte[] hash = digest.digest(encoded);
                    return LuaValue.valueOf(Hex.toHex(hash));
                } catch (NoSuchAlgorithmException e) {
                    return LuaValue.NIL;
                }
            }
        });
        hash.set("sha1", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                sandbox.applyDelay();

                byte[] encoded = arg1.checkjstring().getBytes(StandardCharsets.UTF_8);

                if (encoded.length > ExampleMod.getMainConfig().computers_hashing_max_bytes) { return LuaValue.NIL; }

                try {
                    MessageDigest digest = MessageDigest.getInstance("SHA-1");
                    byte[] hash = digest.digest(encoded);
                    return LuaValue.valueOf(Hex.toHex(hash));
                } catch (NoSuchAlgorithmException e) {
                    return LuaValue.NIL;
                }
            }
        });
        hash.set("md5", new OneArgFunction() {
            @Override
            public LuaValue call(LuaValue arg1) {
                sandbox.applyDelay();

                byte[] encoded = arg1.checkjstring().getBytes(StandardCharsets.UTF_8);

                if (encoded.length > ExampleMod.getMainConfig().computers_hashing_max_bytes) { return LuaValue.NIL; }

                try {
                    MessageDigest digest = MessageDigest.getInstance("MD5");
                    byte[] hash = digest.digest(encoded);
                    return LuaValue.valueOf(Hex.toHex(hash));
                } catch (NoSuchAlgorithmException e) {
                    return LuaValue.NIL;
                }
            }
        });

        crypto.set("b64",  base64);
        crypto.set("hash", hash);

        return crypto;
    }
}

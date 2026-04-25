package me.creeper.creepermodtest.computers.libs;

import me.creeper.creepermodtest.ExampleMod;
import me.creeper.creepermodtest.computers.LuaSandbox;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Arrays;

public class HTTPLib {
    public static LuaTable create(LuaSandbox sandbox) {
        LuaTable http = new LuaTable();

        http.set("get", new OneArgFunction() {
            private long lastCall = 0;
            @Override
            public LuaValue call(LuaValue arg1) {
                sandbox.applyDelay();
                String urlString = arg1.checkjstring();

                if (!ExampleMod.getMainConfig().computer_allow_network) { return LuaValue.valueOf("disabled"); }

                long now = System.currentTimeMillis();
                if (now - lastCall < 1000) return LuaValue.valueOf("throttled");
                lastCall = now;

                try {
                    URL url = new URL(urlString);
                    InetAddress[] addresses = InetAddress.getAllByName(url.getHost());
                    for (InetAddress address : addresses) {
                        if (!PublicIPUtils.isPublicIP(address)) return LuaValue.valueOf("privateip");
                    }
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    connection.setRequestMethod("GET");

                    int code = connection.getResponseCode();
                    InputStream is = (code >= 200 && code < 400) ? connection.getInputStream() : connection.getErrorStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) sb.append(line).append("\n");
                    br.close();

                    return LuaValue.valueOf(sb.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    return LuaValue.error("jexception");
                }
            }
        });



        return http;
    }




    public static class PublicIPUtils {
        public static boolean isPublicIP(InetAddress address) {
            if (address.isAnyLocalAddress() ||
                    address.isLoopbackAddress() ||
                    address.isLinkLocalAddress() ||
                    address.isSiteLocalAddress() ||
                    address.isMulticastAddress()) {
                return false;
            }

            if (address instanceof Inet6Address) {
                byte[] addr = address.getAddress();
                // ULA
                if ((addr[0] & 0xFE) == 0xFC) return false;

                if (((Inet6Address) address).isIPv4CompatibleAddress() ||
                        (addr[0] == 0 && addr[1] == 0 && addr[2] == 0 && addr[3] == 0 &&
                                addr[4] == 0 && addr[5] == 0 && addr[6] == 0 && addr[7] == 0 &&
                                addr[8] == 0 && addr[9] == 0 &&
                                addr[10] == (byte) 0xFF && addr[11] == (byte) 0xFF)) {
                    try {
                        InetAddress ipv4 = InetAddress.getByAddress(Arrays.copyOfRange(addr, 12, 16));
                        return isPublicIP(ipv4);
                    } catch (UnknownHostException e) {
                        return false;
                    }
                }
                return true;
            }

            byte[] addr = address.getAddress();
            int ip = ((addr[0] & 0xFF) << 24) | ((addr[1] & 0xFF) << 16) |
                    ((addr[2] & 0xFF) << 8) | (addr[3] & 0xFF);

            return !isReservedIPv4(ip);
        }

        private static final int RANGE_THIS_NETWORK = 0x00000000; // 0.0.0.0/8
        private static final int RANGE_SHARED = 0x64400000; // 100.64.0.0/10
        private static final int RANGE_IETF_PROTOCOL = 0xC0000000; // 192.0.0.0/24
        private static final int RANGE_TEST_NET_1 = 0xC0000200; // 192.0.2.0/24
        private static final int RANGE_BENCHMARK = 0xC6120000; // 198.18.0.0/15
        private static final int RANGE_TEST_NET_2 = 0xC6336400; // 198.51.100.0/24
        private static final int RANGE_TEST_NET_3 = 0xCB007100; // 203.0.113.0/24
        private static final int RANGE_RESERVED = 0xF0000000; // 240.0.0.0/4

        private static boolean isReservedIPv4(int ip) {
            return inRange(ip, RANGE_THIS_NETWORK, 8) ||
                    inRange(ip, RANGE_SHARED, 10) ||
                    inRange(ip, RANGE_IETF_PROTOCOL, 24) ||
                    inRange(ip, RANGE_TEST_NET_1, 24) ||
                    inRange(ip, RANGE_BENCHMARK, 15) ||
                    inRange(ip, RANGE_TEST_NET_2, 24) ||
                    inRange(ip, RANGE_TEST_NET_3, 24) ||
                    inRange(ip, RANGE_RESERVED, 4) ||
                    (ip == 0xFFFFFFFF);
        }

        private static boolean inRange(int ip, int base, int prefixLen) {
            if (prefixLen == 0) return true;
            if (prefixLen == 32) return ip == base;

            int mask = (int) (0xFFFFFFFFL << (32 - prefixLen));
            return (ip & mask) == (base & mask);
        }
    }
}

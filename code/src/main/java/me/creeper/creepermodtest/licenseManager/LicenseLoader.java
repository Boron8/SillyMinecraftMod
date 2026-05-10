package me.creeper.creepermodtest.licenseManager;

import me.creeper.creepermodtest.ExampleMod;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class LicenseLoader {
    public static List<String> licensesFilenames = new ArrayList<>();
    public static List<String> licensesTexts = new ArrayList<>();

    public static void loadLicenses() {
        getLicenseFiles();
        System.out.println("Loaded " + licensesFilenames.size() + " licenses");
    }

    public static void getLicenseFiles() {
        try {
            URL url = LicenseLoader.class.getProtectionDomain().getCodeSource().getLocation();

            String path = url.getPath();
            String jarPath = path.substring(5, path.indexOf("!"));
            File jarFile = new File(jarPath);
            loadFromJar(jarFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadFromJar(File jarFile) throws IOException {
        try (JarFile jar = new JarFile(jarFile)) {
            Enumeration<JarEntry> entries = jar.entries();

            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                String name = entry.getName();

                if (name.startsWith("assets/" + ExampleMod.MODID + "/licenses/") && !entry.isDirectory()) {
                    String fileName = name.substring(name.lastIndexOf('/') + 1);
                    try (InputStream stream = jar.getInputStream(entry)) {
                        String fn = fileName.toLowerCase();
                        if (!fn.endsWith(".license")) { continue; }
                        fn = fn.toLowerCase().substring(0, fn.length() - 8);
                        licensesFilenames.add(fn);
                        licensesTexts.add(readStream(stream));
                    }
                }
            }
        }
    }

    private static String readStream(InputStream stream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine())!= null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }
}

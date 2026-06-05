package me.creeper.creepermodtest.unknownFont;

public class UnknownFontConverter {
    public static String stringToUnknown(String in) {
        StringBuilder out = new StringBuilder();

        for (char c : in.toCharArray()) {
            if (       c == 'a' || c == 'A' || c == '1') { // 1
                out.append('╣');
            } else if (c == 'b' || c == 'B' || c == '2') { // 2
                out.append('║');
            } else if (c == 'c' || c == 'C' || c == '3') { // 3
                out.append('╗');
            } else if (c == 'd' || c == 'D' || c == '4') { // 4
                out.append('╝');
            } else if (c == 'e' || c == 'E' || c == '5') { // 5
                out.append('┐');
            } else if (c == 'f' || c == 'F' || c == '6') { // 6
                out.append('└');
            } else if (c == 'g' || c == 'G' || c == '7') { // 7
                out.append('┴');
            } else if (c == 'h' || c == 'H' || c == '8') { // 8
                out.append('┬');
            } else {
                out.append(c);
            }
        }

        return out.toString();
    }
}

package prog.javadekom.cal;

public class BinaryOperations {

    public static String toString(byte data) {
        return String.format("%8s", Integer.toBinaryString(data & 0xFF)).replace(' ', '0');
    }

    public static int getUnusedBits(String flag) {
        char[] binaryNumberOfBits = flag.substring(3, 6).toCharArray();
        return (binaryNumberOfBits[2] - 48) + (binaryNumberOfBits[1] - 48) * 2 + (binaryNumberOfBits[0] - 48) * 4;
    }

    public static boolean checkChar(String flag) {
        return flag.charAt(7) == '1';
    }

    public static byte toByte(String data) {
        return (byte)Integer.parseInt(data, 2);
    }
}

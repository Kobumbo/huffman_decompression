package prog.javadekom.cal;

public class CheckFile {
    public static boolean checkMB(byte[] data) { return data[0] == 77 && data[1] == 66; }

    public static boolean checkContr(byte[] data) {
        byte xorP = 16;
        byte xorK = data[2];
        xorP = (byte)((xorP ^ 77) ^ 66);
        for(int i = 3; i < data.length-1; i++) {
            xorP = (byte)(xorP ^ data[i]);
        }
        return xorP == xorK;
    }
}

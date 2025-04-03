package prog.javadekom.cal;

public class PswdTry {
    private byte[] data;
    private String pswd;
    public PswdTry(byte[] data, String pswd) {
        this.data = data;
        this.pswd = pswd;
    }
    public byte[] applyPswd() {
        byte key = 'p';

        for(int i = 0; i < pswd.length(); i++) {
            key = (byte)(key ^ (pswd.charAt(i) + i));
        }

        for(int i = 0; i < data.length-1; i++) {
            data[i] = (byte)(data[i] ^ key);
        }

        return data;
    }
}

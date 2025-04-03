package prog.javadekom.cal;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import prog.javadekom.MsgChanger;
import prog.javadekom.cal.Modes.*;

public class Dekom {
    public static String bajt = "";
    public static int bitCount = 0;
    public static boolean end = true;
    public static int mode = 0;
    public static int gate = 0;
    public static String step = "";
    public static int numberOfSymbols = 0;
    public static boolean last = true;
    public static int deep = 0;
    public static boolean first = false;
    public static Leaves[] leaves = new TreeNode[256];
    public static int maxdeep = 0;

    public static byte[] solve(byte[] data, Label msg) {
        Symbols symbols = new Symbols();
        if(CheckFile.checkMB(data) && CheckFile.checkContr(data)) {
            String flag = BinaryOperations.toString(data[data.length - 2]);
            int numberOfBits = BinaryOperations.getUnusedBits(flag);
            boolean wasChar = BinaryOperations.checkChar(flag);
            for(int i = 0; i < 256; i++) {
                leaves[i] = new TreeNode();
            }
            int i;
            for(i = 3; i < data.length - 1 && end; i++) {
                bajt = BinaryOperations.toString(data[i]);
                bitCount = 0;
                while(bitCount < 8 && end) {
                    ModeAll modeAll = new ModeAll();
                    modeAll.execute();
                }
            }
            Leaves seek = leaves[0];
            Decode.decode(i, data, bitCount, numberOfBits, bajt, seek, leaves[0], symbols);
            if(wasChar) {
                symbols.addSymbol((byte)10);
            }
        }
        else {
            MsgChanger.msgWrongPswdFile(msg);
            return null;
        }

        ResetValues.reset();
        MsgChanger.msgDone(msg);
        return symbols.getAllSymbols();
    }
}

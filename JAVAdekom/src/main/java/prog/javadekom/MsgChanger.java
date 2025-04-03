package prog.javadekom;

import javafx.scene.control.Label;

public class MsgChanger extends MainViewController {
    public static void msgDone(Label msg) { msg.setText("Done"); }

    public static void msgEntryFileError(Label msg) {
        msg.setText("Cannot open:\n - Entry File");
    }

    public static void msgOutFileError(Label msg) {
        msg.setText("Cannot open:\n - Out File");
    }

    public static void msgWrongPswdFile(Label msg) { msg.setText("File or password\n is not correct"); }
}

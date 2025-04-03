package prog.javadekom;

import javafx.scene.control.Label;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadWriteFile {
    private Label msg;
    public ReadWriteFile(Label msg) {
        this.msg = msg;
    }

    public byte[] readFile(byte[] data, String path) {
        try {
            data = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            MsgChanger.msgEntryFileError(msg);
        }
        return data;
    }
    public void writeFile2(byte[] dataSolved, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(dataSolved);
        } catch (IOException e) {
            MsgChanger.msgOutFileError(msg);
        }
    }
}

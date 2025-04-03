package prog.javadekom;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileHandler {
    public File entryFile;
    public File outFile;

    public FileHandler() {}

    public void setEntryFile() {
        entryFile = chooseEntryFile();
    }

    public void setOutFile() {
        outFile = chooseOutFile();
    }

    public File getEntryFile() {
        return entryFile;
    }

    public File getOutFile() {
        return outFile;
    }

    public File chooseEntryFile(){
        FileChooser fileChooser = new FileChooser();
        Main main = new Main();
        Stage stage = main.getStage();
        File file = fileChooser.showOpenDialog(stage);
        return file;
    }

    public File chooseOutFile(){
        FileChooser fileChooser = new FileChooser();
        Main main = new Main();
        Stage stage = main.getStage();
        File file = fileChooser.showSaveDialog(stage);
        return file;
    }
}

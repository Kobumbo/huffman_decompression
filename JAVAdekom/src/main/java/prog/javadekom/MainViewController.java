package prog.javadekom;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import prog.javadekom.cal.*;

public class MainViewController {
    public Button EntryFileButton;
    public Button OutFileButton;
    public Label Message;
    public Pane HuffmanTree;
    public String pswd = "";
    public TextField Password;
    byte[] data;
    byte[] dataSolved;
    String pathEntryFile = "";
    String pathOutFile = "";

    public ScrollPane scrollPane;



    @FXML
    public void onEntryButtonClick() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setEntryFile();
        if(fileHandler.getEntryFile() != null) {
            EntryFileButton.setText(fileHandler.getEntryFile().getPath());
            pathEntryFile = fileHandler.getEntryFile().getPath();
        }
    }

    @FXML
    public void onOutButtonClick() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setOutFile();
        if(fileHandler.getOutFile() != null) {
            OutFileButton.setText(fileHandler.getOutFile().getPath());
            pathOutFile = fileHandler.getOutFile().getPath();
        }
    }

    @FXML
    public void onRunClick() throws IllegalStateException {
        MouseControl.initMouseControl(HuffmanTree);
        scrollPane.setPannable(true);
        if(!pathEntryFile.isBlank() && !pathOutFile.isBlank()) {
            ReadWriteFile readWriteFile = new ReadWriteFile(Message);
            data = readWriteFile.readFile(data, pathEntryFile);
            if(!pswd.isEmpty()) {
                PswdTry pswdTry = new PswdTry(data, pswd);
                data = pswdTry.applyPswd();
            }
            dataSolved = Dekom.solve(data, Message);
            if(dataSolved != null) {
                readWriteFile.writeFile2(dataSolved, pathOutFile);
            }
            if (dataSolved != null && HuffmanTree != null) {
                Leaves root = Dekom.leaves[0];
                HuffmanTreeDisplay.displayHuffmanTree(root, HuffmanTree);
                scrollPane.setContent(HuffmanTree);
                scrollPane.setVvalue(0.0);
                scrollPane.setHvalue(0.5);
            }
        }
        else {
            Message.setText("You have to select valid:\n - Entry File Path\n - Out File Path");
        }
    }

    @FXML
    public void onPasswordWrite() {
        pswd = Password.getText();
    }
}

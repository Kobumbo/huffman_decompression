package prog.javadekom.cal.Modes;
import prog.javadekom.cal.ConnectIndex;
import prog.javadekom.cal.TreeNode;

import static prog.javadekom.cal.Dekom.*;

public class Mode1 implements ModeInterface {
    @Override
    public void execute() {
        deep--;
        int placeToConnect1 = ConnectIndex.connect(numberOfSymbols, leaves);
        int placeToConnect2 = ConnectIndex.connect(numberOfSymbols, leaves, placeToConnect1);
        leaves = TreeNode.addLeaves(leaves,placeToConnect1, placeToConnect2);
        mode = 0;
    }
}

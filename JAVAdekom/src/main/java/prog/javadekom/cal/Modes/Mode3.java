package prog.javadekom.cal.Modes;
import prog.javadekom.cal.ConnectIndex;
import prog.javadekom.cal.TreeNode;

import static prog.javadekom.cal.Dekom.*;

public class Mode3 implements ModeInterface {
    @Override
    public void execute() {
        if(first){
            if(last) {
                if(leaves[numberOfSymbols].getZnak().length() < 8) {
                    leaves[numberOfSymbols].addToZnak(bajt.charAt(bitCount));
                    bitCount++;
                }
                else {
                    leaves[numberOfSymbols].setInuse(true);
                    numberOfSymbols++;
                    last = false;
                }
            } else {
                while(deep > 0) {
                    deep--;
                    int placeToConnect1 = ConnectIndex.connect(numberOfSymbols, leaves);
                    int placeToConnect2 = ConnectIndex.connect(numberOfSymbols, leaves, placeToConnect1);
                    leaves = TreeNode.addLeaves(leaves,placeToConnect1, placeToConnect2);
                }
                end = false;
            }
        } else {
            leaves[0].setZnak("X");
            if(leaves[1].getZnak().length() < 8) {
                leaves[1].addToZnak(bajt.charAt(bitCount));
                bitCount++;
            }
            else {
                leaves[2].setZnak("X");
                leaves[0].setRight(leaves[2]);
                leaves[0].setLeft(leaves[1]);
                end = false;
            }
        }
    }
}

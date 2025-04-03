package prog.javadekom.cal.Modes;
import static prog.javadekom.cal.Dekom.*;

public class Mode2 implements ModeInterface {
    @Override
    public void execute() {
        if(leaves[numberOfSymbols].getZnak().length() < 8) {
            leaves[numberOfSymbols].addToZnak(bajt.charAt(bitCount));
            bitCount++;
        }
        else {
            leaves[numberOfSymbols].setInuse(true);
            numberOfSymbols++;
            mode = 0;
            deep++;
        }
    }
}

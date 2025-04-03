package prog.javadekom.cal.Modes;
import static prog.javadekom.cal.Dekom.*;

public class Mode0 implements ModeInterface {
    @Override
    public void execute() {
        if(gate < 2) {
            step += bajt.charAt(bitCount);
            gate++;
            bitCount++;
        } else {
            if(step.equals("00")) {
                mode = 1;
                first = true;
            } else if(step.equals("01")) {
                mode = 2;
                first = true;
            } else {
                mode = 3;
            }
            gate = 0;
            step = "";
        }
    }
}

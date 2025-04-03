package prog.javadekom.cal.Modes;

import static prog.javadekom.cal.Dekom.*;
public class ModeAll implements ModeInterface{
    @Override
    public void execute() {
        if(mode == 0) {
            Mode0 mode0 = new Mode0();
            mode0.execute();
        } else if (mode == 1) {
            Mode1 mode1 = new Mode1();
            mode1.execute();
        } else if (mode == 2) {
            Mode2 mode2 = new Mode2();
            mode2.execute();
        } else {
            Mode3 mode3 = new Mode3();
            mode3.execute();
        }
    }
}

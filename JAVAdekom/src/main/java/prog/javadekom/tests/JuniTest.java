package prog.javadekom.tests;

import org.junit.*;
import prog.javadekom.cal.BinaryOperations;

public class JuniTest {
    @Test
    public void testToString() {
        byte data = 65;
        String binaryString = BinaryOperations.toString(data);
        Assert.assertEquals("01000001", binaryString);
    }

    @Test
    public void testCheckChar() {
        String flag1 = "11001111";
        String flag2 = "11001110";
        boolean isChar1 = BinaryOperations.checkChar(flag1);
        boolean isChar2 = BinaryOperations.checkChar(flag2);
        Assert.assertTrue(isChar1);
        Assert.assertFalse(isChar2);
    }

    @Test
    public void testToByte() {
        String binaryString = "01000001";
        byte data = BinaryOperations.toByte(binaryString);
        Assert.assertEquals(65, data);
    }
}

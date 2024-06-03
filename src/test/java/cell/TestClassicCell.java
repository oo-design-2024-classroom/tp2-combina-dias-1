package cell;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestClassicCell {

    @Test
    public void createLiveCell(){
        ClassicCell classicCell = new ClassicCell(CellType.ALIVE);
        assertTrue(classicCell.isAlive());
    }

    @Test
    public void createDeadCell(){
        ClassicCell classicCell = new ClassicCell(CellType.DEAD);
        assertFalse(classicCell.isAlive());
    }
}

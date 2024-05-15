package cell;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCell {

    @Test
    public void createLiveCell(){
        Cell cell = new Cell(CellType.ALIVE);
        assertTrue(cell.isAlive());
    }

    @Test
    public void createDeadCell(){
        Cell cell = new Cell(CellType.DEAD);
        assertFalse(cell.isAlive());
    }
}

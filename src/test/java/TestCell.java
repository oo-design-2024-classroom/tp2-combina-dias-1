import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCell {
    CellFactory cellFactory;

    @BeforeEach
    public void setUp(){
        cellFactory = new CellFactory();
    }

    @Test
    public void createLiveCell(){
        Cell cell = cellFactory.createCell(ALIVE);
        assertTrue(cell.isAlive());
    }

    @Test
    public void createLiveCell(){
        CellFactory cellFactory = new CellFactory();
        Cell cell = cellFactory.createCell(DEAD);
        assertFalse(cell.isAlive());
    }
}

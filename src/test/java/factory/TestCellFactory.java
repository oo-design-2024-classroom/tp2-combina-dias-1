package factory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import cell.*;
public class TestCellFactory {

    private final CellFactory cellFactory = new CellFactory();

    @Test
    public void testValidCellTypes() {
        assertEquals(CellType.DEAD,       cellFactory.factory('X').type());
        assertEquals(CellType.BLUE,       cellFactory.factory('B').type());
        assertEquals(CellType.RED,        cellFactory.factory('R').type());
        assertEquals(CellType.YELLOW,     cellFactory.factory('Y').type());
        assertEquals(CellType.GREEN,      cellFactory.factory('G').type());
        assertEquals(CellType.ALIVE,      cellFactory.factory('O').type());
        assertEquals(CellType.STATE2,     cellFactory.factory('2').type());
        assertEquals(CellType.ALMOST_DEAD, cellFactory.factory('3').type());
    }

    @Test
    public void testInvalidCellType() {
        assertThrows(IllegalArgumentException.class, () -> cellFactory.factory('Z'));
        assertThrows(IllegalArgumentException.class, () -> cellFactory.factory('1'));
        assertThrows(IllegalArgumentException.class, () -> cellFactory.factory('a'));
    }

}

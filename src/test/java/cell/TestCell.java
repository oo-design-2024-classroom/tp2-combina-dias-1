package cell;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestCell {

    @Test
    void testToString() {
        assertAll(
                () -> assertEquals("R", new Cell(CellType.RED).toString()),
                () -> assertEquals("B", new Cell(CellType.BLUE).toString()),
                () -> assertEquals("Y", new Cell(CellType.YELLOW).toString()),
                () -> assertEquals("G", new Cell(CellType.GREEN).toString()),
                () -> assertEquals("O", new Cell(CellType.ALIVE).toString()),
                () -> assertEquals("2", new Cell(CellType.STATE2).toString()),
                () -> assertEquals("3", new Cell(CellType.STATE3).toString()),
                () -> assertEquals("X", new Cell(CellType.DEAD).toString())
        );

    }

    @Test
    void testEquals() {
        Cell cell1 = new Cell(CellType.ALIVE);
        Cell cell2 = new Cell(CellType.ALIVE);
        Cell cell3 = new Cell(CellType.DEAD);

        assertAll(
                () -> assertTrue(cell1.equals(cell2)),
                () -> assertTrue(cell2.equals(cell1)),
                () -> assertFalse(cell1.equals(cell3)),
                () -> assertFalse(cell1.equals(null)),
                () -> assertFalse(cell1.equals("Not a Cell"))
        );
    }

    @Test
    void testType() {
        assertAll(
                () -> assertEquals(CellType.RED, new Cell(CellType.RED).type()),
                () -> assertEquals(CellType.BLUE, new Cell(CellType.BLUE).type()),
                () -> assertEquals(CellType.DEAD, new Cell(CellType.DEAD).type())
        );
    }
}

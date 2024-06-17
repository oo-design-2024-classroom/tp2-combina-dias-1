package factory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import display.*;

import java.util.List;

public class TestDisplaysFactory {

    @Test
    public void testConsoleDisplay() {
        List<GameDisplay> displays = DisplaysFactory.factory("CONSOLE");
        assertEquals(1, displays.size());
        assertTrue(displays.get(0) instanceof ConsoleOutput);
    }

    @Test
    public void testMultipleDisplays() {
        List<GameDisplay> displays = DisplaysFactory.factory("CONSOLE;FILE:test_output");
        assertEquals(2, displays.size());
        assertTrue(displays.get(0) instanceof ConsoleOutput);
        assertTrue(displays.get(1) instanceof FileOutput);
    }

    @Test
    public void testInvalidDisplayType() {
        assertThrows(IllegalArgumentException.class, () -> DisplaysFactory.factory("INVALID"));
        assertThrows(IllegalArgumentException.class, () -> DisplaysFactory.factory("FILE")); // Missing folder name
        assertThrows(IllegalArgumentException.class, () -> DisplaysFactory.factory("FILE:"));  // Empty folder name
    }

    @Test
    public void testNullDisplayType() {
        assertThrows(NullPointerException.class, () -> DisplaysFactory.factory(null));
    }
}

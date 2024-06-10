package factory;
import display.ConsoleOutput;
import display.FileOutput;
import display.GameDisplay;

import java.util.ArrayList;
import java.util.List;

/*
 * TIPOS DE DISPLAY:
 * - CONSOLE
 * - FILE:FOLDER_NAME -> folderName es un nombre de carpeta
 * Se pueden tener multiples displays para un juego, se los separa con ;
 * */
public class DisplaysFactory {
    public static List<GameDisplay> factory(String displayType) {
        List<GameDisplay> displays = new ArrayList<>();
        String[] displayTypes = displayType.split(";");
        for (String type : displayTypes) {
            if (type == null) throw new IllegalArgumentException("Invalid display type");
            if (type.equals("CONSOLE")) displays.add(new ConsoleOutput());
            else if (isFileDisplay(type)) {
                String folderName = getFolderName(displayType);
                displays.add(new FileOutput(folderName));
            } else {
                throw new IllegalArgumentException("Invalid display type");
            }
        }
        return displays;
    }

    public static String getFolderName(String displayType) {
        String[] displayTypes = displayType.split(":");
        if (displayTypes.length != 2) throw new IllegalArgumentException("Invalid display type");
        return displayTypes[1];
    }

    public static boolean isFileDisplay(String displayType) {
        return displayType.contains("FILE");
    }
}

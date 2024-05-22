import factory.*;
import rule.*;
import board.*;
import game.Game;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Debe proporcionar el nombre del archivo de configuración como argumento.");
            System.exit(1);
        }
        String configFileName = args[0];
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(configFileName)));
            String rulesString = properties.getProperty("RULES");
            if (rulesString == null) {
                throw new IllegalArgumentException("La propiedad 'RULES' no está definida en el archivo de configuración.");
            }
            String boardString = properties.getProperty("BOARD");
            if (boardString == null) {
                throw new IllegalArgumentException("La propiedad 'BOARD' no está definida en el archivo de configuración.");
            }
            String rowsString = properties.getProperty("ROWS");
            if (rowsString == null) {
                throw new IllegalArgumentException("La propiedad 'ROWS' no está definida en el archivo de configuración.");
            }
            int rows;
            try {
                rows = Integer.parseInt(rowsString);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("La propiedad 'ROWS' debe ser un número entero.", e);
            }
            String columnsString = properties.getProperty("COLUMNS");
            if (columnsString == null) {
                throw new IllegalArgumentException("La propiedad 'COLUMNS' no está definida en el archivo de configuración.");
            }
            int columns;
            try {
                columns = Integer.parseInt(columnsString);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("La propiedad 'COLUMNS' debe ser un número entero.", e);
            }
            String generationsString = properties.getProperty("GENERATIONS");
            if (generationsString == null) {
                throw new IllegalArgumentException("La propiedad 'GENERATIONS' no está definida en el archivo de configuración.");
            }
            int generations;
            try {
                generations = Integer.parseInt(generationsString);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("La propiedad 'GENERATIONS' debe ser un número entero.", e);
            }
            RulesFactory rulesFactory = new RulesFactory();
            List<Rule> rules = rulesFactory.factory(rulesString);
            BoardFactory boardFactory = new BoardFactory();
            Board board = boardFactory.factory(rows, columns, boardString, rules);
            Game game = new Game(board);
            game.play(generations);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            System.err.println("Error en la configuración: " + e.getMessage());
        }
    }
}
package factory;
import board.Board;
import display.GameDisplay;
import playbackMode.ContinuousMode;
import playbackMode.LimitedGenerationsMode;
import playbackMode.GameController;
import playbackMode.SimulationMode;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlaybackModeFactory {
    int generations;
    float speed;
    /*
     *Reglas del string de construccion:
     * "LIMITED:GENERATIONS" GENERATIONS es un entero positivo
     * "INFINITE:SPEED" SPEED es un float
     * "SIMULATION"
     */
    public GameController getPlaybackMode(String modeName, Board board, List<GameDisplay> displays) {
        if (modeName == null) {
            throw new IllegalArgumentException("Mode name cannot be null");
        }
        if (matchLimitedMode(modeName)) {
            return new LimitedGenerationsMode(board, displays, generations);
        } else if (matchContinuousMode(modeName)) {
            return new ContinuousMode(board, displays, speed);
        } else if (modeName.equals("SIMULATION")) {
            return new SimulationMode(board, displays);
        } else {
            throw new IllegalArgumentException("Invalid mode name");
        }
    }

    public boolean matchLimitedMode(String input) {
        String regex = "^LIMITED:[1-9][0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            generations = Integer.parseInt(matcher.group(1));
            return true;
        } return false;
    }

    public boolean matchContinuousMode(String input) {
        String regex = "^INFINITE:([+]?(0|[1-9][0-9]*)(\\.[0-9]+)?)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            speed = Float.parseFloat(matcher.group(1));
            return true;
        } return false;
    }
}

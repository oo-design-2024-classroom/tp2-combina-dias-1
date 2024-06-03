package display;

import board.Board;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput implements GameDisplay{
    File file;
    String folderName;
    int boardsGenerated = 0;

    public FileOutput(String folderName){
        this.folderName = folderName;
    }

    @Override
    public void update(Board board) throws IOException {
        boardsGenerated++;
        try {
            FileWriter writer = new FileWriter(new File(folderName + "/" + boardsGenerated + ".txt"));
            writer.write(board.toString());
        }  catch (IOException e) {
            throw new IOException("Error creating file");
        }
    }

    @Override
    public void show(String content) {

    }
}

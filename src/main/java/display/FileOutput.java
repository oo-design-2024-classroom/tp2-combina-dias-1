package display;

import board.IBoard;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOutput implements GameDisplay{
    String folderName;
    int boardsGenerated = 0;
    FileWriter writer;

    public FileOutput(String folderName){
        this.folderName = folderName;
        try {
            Files.createDirectories(Paths.get(folderName));
        } catch (IOException e) {
            throw new RuntimeException("Error creating folder", e);
        }
    }

    @Override
    public void update(IBoard board) throws IOException {
        boardsGenerated++;
        try {
            writer = new FileWriter(folderName + "/" + boardsGenerated + ".txt");
            show(board.toString());
        }  catch (IOException e) {
            throw new IOException("Error creating file");
        }
    }

    @Override
    public void show(String content) throws IOException {
        writer.write(content);
    }
}

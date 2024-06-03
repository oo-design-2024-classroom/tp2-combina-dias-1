package playbackMode;

import java.io.IOException;

public interface PlaybackMode {
    void reproduce() throws IOException, InterruptedException;
}

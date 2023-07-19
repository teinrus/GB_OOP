import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public interface Writable {
    void saveFile(Serializable object) throws IOException;

    Object readFile() throws ClassNotFoundException, IOException;
}

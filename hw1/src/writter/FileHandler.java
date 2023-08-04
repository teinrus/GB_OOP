package writter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Writtable {
    public FileHandler() {
    }

    public boolean save(Serializable serializable, String filePath) {
        try {
            new ObjectOutputStream(new FileOutputStream(filePath));
            return true;
        } catch (Exception var4) {
            var4.printStackTrace();
            return false;
        }
    }

    public Object read(String filePath) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));

            Object var3;
            try {
                var3 = objectInputStream.readObject();
            } catch (Throwable var6) {
                try {
                    objectInputStream.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            objectInputStream.close();
            return var3;
        } catch (Exception var7) {
            var7.printStackTrace();
            return null;
        }
    }
}

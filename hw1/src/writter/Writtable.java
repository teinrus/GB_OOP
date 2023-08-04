package writter;

import java.io.Serializable;

public interface Writtable {
    boolean save(Serializable var1, String var2);

    Object read(String var1);
}

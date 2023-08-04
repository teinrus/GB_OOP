package family_tree;

import java.time.LocalDate;
import java.util.List;

public interface FamilyItem<E> {
    LocalDate getDateOfBirth();
    String getName();
    void setId(int id);
    int getId();
    List<E> getChildren();
    boolean addParent(E human);

}

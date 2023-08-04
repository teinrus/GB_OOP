//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package family_tree;

import java.time.LocalDate;
import java.util.List;

public interface FamilyItem<E> {
    LocalDate getDateOfBirth();

    String getName();

    void setId(int var1);

    int getId();

    List<E> getChildren();

    String getSpouseInfo();

    Object getSpouse();

    List<E> getParents();

    boolean addParent(E var1);

    boolean addChild(E var1);
}

package family_tree;

import human.HumanIterator;
import human.comparator.ComparatorSortByDateOfBirth;
import human.comparator.ComparatorSortByName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyItem<E>> implements Serializable, Iterable<E> {
    private int id;
    private int humanId;
    private List<E> humanList;

    public boolean addHuman(E human) {
        if (human == null) {
            return false;
        } else if (!this.humanList.contains(human)) {
            this.humanList.add(human);
            human.setId(this.humanId++);
            this.addToParents(human);
            this.addToChildren(human);
            return true;
        } else {
            return false;
        }
    }

    public FamilyTree(int id) {
        this.id = id;
        this.humanList = new ArrayList();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(this.humanList.size());
        sb.append(" объектов: \n");
        Iterator var2 = this.humanList.iterator();

        while(var2.hasNext()) {
            FamilyItem human = (FamilyItem)var2.next();
            sb.append(human);
            sb.append("\n");
        }

        return sb.toString();
    }

    private boolean checkId(long id) {
        if (id < (long)this.humanId && id >= 0L) {
            Iterator var3 = this.humanList.iterator();

            FamilyItem human;
            do {
                if (!var3.hasNext()) {
                    return false;
                }

                human = (FamilyItem)var3.next();
            } while((long)human.getId() != id);

            return true;
        } else {
            return false;
        }
    }

    public E getById(long id) {
        Iterator var3 = this.humanList.iterator();

        FamilyItem human;
        do {
            if (!var3.hasNext()) {
                return null;
            }

            human = (FamilyItem)var3.next();
        } while((long)human.getId() != id);

        return (E) human;
    }

    public boolean setWedding(long humansId1, long humansId2) {
        if (this.checkId(humansId1) && this.checkId(humansId2)) {
            E human1 = this.getById(humansId1);
            E human2 = this.getById(humansId2);
            if (human1.getSpouse() != null || human2.getSpouse() != null) {
                return false;
            }

            human1.getSpouse();
            human2.getSpouse();
        }

        return false;
    }

    private void addToParents(E human) {
        Iterator var2 = human.getParents().iterator();

        while(var2.hasNext()) {
            E parent = (E) var2.next();
            parent.addChild(human);
        }

    }

    private void addToChildren(E human) {
        Iterator var2 = human.getChildren().iterator();

        while(var2.hasNext()) {
            E child = (E) var2.next();
            child.addParent(human);
        }

    }

    public String toString() {
        return this.getInfo();
    }

    public Iterator<E> iterator() {
        return new HumanIterator(this.humanList);
    }

    public void sortByName() {
        this.humanList.sort(new ComparatorSortByName());
    }

    public void sortByDateOfBirth() {
        this.humanList.sort(new ComparatorSortByDateOfBirth());
    }
}

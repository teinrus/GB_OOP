package presenter;

import family_tree.FamilyItem;
import family_tree.FamilyTree;
import human.Gender;
import human.Human;
import java.time.LocalDate;
import view.View;

public class Presenter<E extends FamilyItem<E>> extends Human {
    private View view;
    private FamilyTree familyTree;

    public Presenter(View view) {
        this.view = view;
        this.familyTree = new FamilyTree(100);
    }

    public void addHuman(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDead) {
        Human human = new Human(name, gender, dateOfBirth, dateOfDead);
        this.familyTree.addHuman(human);
    }
}

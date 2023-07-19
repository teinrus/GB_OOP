import java.io.IOException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree familyTree = new FamilyTree();
        FileHandler fileHandler = new FileHandler();




        Human human1 = new Human("Ivan", Gender.male, LocalDate.of(2000, 12, 17), LocalDate.of(2021, 12, 15));
        Human human2 = new Human("Sergey", Gender.male, LocalDate.of(2001, 12, 17));
        Human human3 = new Human("Misha", Gender.male, LocalDate.of(1950, 12, 17), LocalDate.of(2000, 12, 14));
        Human human4 = new Human("Anna", Gender.female, LocalDate.of(1985, 12, 17));
        Human human5 = new Human("Anton", Gender.male, LocalDate.of(2002, 12, 17));




        human1.addChildren(human3);
        human3.addParent(human1);
        human5.addChildren(human2);
        human2.addParent(human5);
        human3.addChildren(human5);
        human5.addParent(human3);

        familyTree.createTree(human1);
        fileHandler.saveFile(familyTree);
        System.out.println(familyTree.getTree());

        familyTree = (FamilyTree) fileHandler.readFile();
        System.out.println(familyTree.getTree());
    }
}
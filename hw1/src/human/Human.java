//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package human;

import family_tree.FamilyItem;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Human implements Comparable<Human>, FamilyItem<Human> {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private int age;
    private List<Human> parents;
    private List<Human> children;
    private Human spouse;

    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, Human father, Human mather) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.age = Period.between(dateOfBirth, dateOfDeath).getYears();
        this.parents = new ArrayList();
        if (father != null) {
            this.parents.add(father);
        }

        if (mather != null) {
            this.parents.add(mather);
        }

        this.children = new ArrayList();
    }

    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        this(name, gender, dateOfBirth, dateOfDeath, (Human)null, (Human)null);
    }

    public Human() {
    }

    public Human getSpouse() {
        return this.spouse;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gender getGender() {
        return this.gender;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return this.dateOfDeath;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Human> getParents() {
        return this.parents;
    }

    public List<Human> getChildren() {
        return this.children;
    }

    public boolean addParent(Human parent) {
        if (!this.parents.contains(parent)) {
            this.parents.add(parent);
            return true;
        } else {
            return false;
        }
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public String getSpouseInfo() {
        String res = "супруг(а): ";
        if (this.spouse == null) {
            res = res + "нет";
        } else {
            res = res + this.spouse.getName();
        }

        return res;
    }

    public boolean addChild(Human child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
            return true;
        } else {
            return false;
        }
    }

    public Human getFather() {
        Iterator var1 = this.parents.iterator();

        Human parent;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            parent = (Human)var1.next();
        } while(parent.getGender() != Gender.Male);

        return parent;
    }

    public Human getMather() {
        Iterator var1 = this.parents.iterator();

        Human parent;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            parent = (Human)var1.next();
        } while(parent.getGender() != Gender.Female);

        return parent;
    }

    public String getMotherInfo() {
        String res = "мать: ";
        Human mother = this.getMather();
        if (mother == null) {
            res = res + "неизвестна";
        } else {
            res = res + mother.getName();
        }

        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        Human father = this.getFather();
        if (father == null) {
            res = res + "неизвестен";
        } else {
            res = res + father.getName();
        }

        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (this.children.size() != 0) {
            res.append(((Human)this.children.get(0)).getName());

            for(int i = 1; i < this.children.size(); ++i) {
                res.append(", ");
                res.append(((Human)this.children.get(i)).getName());
            }
        } else {
            res.append("отсутствуют");
        }

        return res.toString();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(this.id);
        sb.append(", имя: ");
        sb.append(this.name);
        sb.append(", пол: ");
        sb.append(this.getGender());
        sb.append(", дата рождения: ");
        sb.append(this.getDateOfBirth());
        sb.append(", возраст: ");
        sb.append(this.getAge());
        sb.append(", ");
        sb.append(this.getSpouseInfo());
        sb.append(", ");
        sb.append(this.getMotherInfo());
        sb.append(", ");
        sb.append(this.getFatherInfo());
        sb.append(", ");
        sb.append(this.getChildrenInfo());
        return sb.toString();
    }

    public String toString() {
        return this.getInfo();
    }

    public int compareTo(Human o) {
        return this.name.compareTo(o.name);
    }
}

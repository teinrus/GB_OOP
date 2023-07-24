package People;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/** */
public class Human implements Serializable, Comparable<Human>  {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Gender gender;
    private Human mother;
    private Human father;
    private ArrayList<Human> children;
    private ArrayList<Human> parents;

    public Human(String name, String surname, LocalDate dateOfBirth, LocalDate dateOfDeath, Human mother, Human father,
                 Gender gender) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        this.gender = gender;

    }

    public Human(String name, String surname, LocalDate dateOfBirth, Human mother, Human father, Gender gender) {
        this(name, surname, dateOfBirth, null, mother, father, gender);
    }

    public Human(String name, String surname, LocalDate dateOfBirth, Gender gender) {
        this(name, surname, dateOfBirth, null, null, gender);
    }

    public Human(String name, String surname, LocalDate dateOfBirth) {
        this(name, surname, dateOfBirth, null, null, null);
    }



    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getChildren() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("дети: ");
        if (children.size() != 0) {
            stringBuilder.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                stringBuilder.append(", " + children.get(i).getName());
            }
        } else {
            stringBuilder.append("отсутствуют");
        }
        return stringBuilder.toString();
    }

    public void addChildM(Human child) {
        child.mother = this;
        children.add(child);
    }

    public void addChildF(Human child) {
        child.father = this;
        children.add(child);
    }

    // @Override
    // public String toString() {
    // return String.format("Имя, фамилия: %s %s\nДата рождения: %s\n", name,
    // surname, dateOfBirth.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    // }

    @Override
    public String toString() {
        return getInformation();
    }

    private String getInformation() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Имя: ");
        stringBuilder.append(getName() + ", ");
        stringBuilder.append("Фамилия: ");
        stringBuilder.append(getSurname() + ", ");
        stringBuilder.append("Дата рождения: ");
        stringBuilder.append(getDateOfBirth() + ", ");
        stringBuilder.append("Возраст: ");
        stringBuilder.append(getAge() + ", ");
        stringBuilder.append("Пол: ");
        stringBuilder.append(getGender() + ", ");
        stringBuilder.append(fatherInfo()+", ");
        stringBuilder.append(motherInfo() +", ");
        stringBuilder.append(getChildren());
        return stringBuilder.toString();
    }

    public Human getFather() {
        return father;
    }

    public String fatherInfo () {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Отец: ");
        Human father = getFather();
        if (father == null) {
            stringBuilder.append("неизвестен");
        } else {
            stringBuilder.append(father.getName());
        }
        return stringBuilder.toString();
    }

    public Human getMother() {
        return mother;
    }

    public String motherInfo () {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Мать: ");
        Human mother = getMother();
        if (mother == null) {
            stringBuilder.append("неизвестна");
        } else {
            stringBuilder.append(mother.getName());
        }
        return stringBuilder.toString();
    }

    public int getAge() {
        if (dateOfDeath == null) {
            return getPeriod(dateOfBirth, LocalDate.now());
        } else {
            return getPeriod(dateOfBirth, dateOfDeath);
        }
    }

    private int getPeriod(LocalDate date0, LocalDate date1) {
        Period difference = Period.between(date0, date1);
        return difference.getYears();
    }

    public ArrayList<Human> getParents() {
        parents = new ArrayList<>();
        if (mother != null) {
            parents.add(mother);
        }
        if (father != null) {
            parents.add(father);
        }
        return parents;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public int compareTo(Human human) {
        return 0;
    }
}
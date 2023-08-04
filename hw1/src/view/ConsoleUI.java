//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package view;

import human.Gender;
import java.time.LocalDate;
import java.util.Scanner;
import presenter.Presenter;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter(this);
        this.work = true;
        this.menu = new MainMenu(this);
    }

    public void printAnswer(String text) {
        System.out.println(text);
    }

    public void start() {
        this.hello();

        while(this.work) {
            this.printMenu();
            this.execute();
        }

    }

    public void finish() {
        System.out.println("Приятно было пообщаться");
        this.work = false;
    }

    private void hello() {
        System.out.println("Доброго времени суток!");
    }

    private void execute() {
        String line = this.scanner.nextLine();
        if (this.checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (this.checkCommand(numCommand)) {
                this.menu.execute(numCommand);
            }
        }

    }

    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            this.inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand < this.menu.getSize()) {
            return true;
        } else {
            this.inputError();
            return false;
        }
    }

    private void printMenu() {
        System.out.println(this.menu.menu());
    }

    private void inputError() {
        System.out.println("Вы ввели неверное значение");
    }

    public void addHuman() {
        System.out.println("Введите имя человека");
        String name = this.scanner.nextLine();
        System.out.println("Введите пол человека(Male or Female)");
        Gender gender = Gender.valueOf(this.scanner.nextLine());
        System.out.println("Введите дату рождения в формате гггг,мм,дд");
        LocalDate dateOfBirth = LocalDate.parse(this.scanner.nextLine());
        LocalDate dateOfDead = LocalDate.parse(this.scanner.nextLine());
        this.presenter.addHuman(name, gender, dateOfBirth, dateOfDead);
    }
}

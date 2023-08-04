//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package view.command;

import view.ConsoleUI;

public class AddHuman extends Command {
    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        this.description = "Добавить человека";
    }

    public void execute() {
        this.consoleUI.addHuman();
    }
}

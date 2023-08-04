//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package view;

import java.util.ArrayList;
import java.util.List;
import view.command.AddHuman;
import view.command.Command;
import view.command.Finish;

public class MainMenu {
    private List<Command> commandList = new ArrayList();

    public MainMenu(ConsoleUI consoleUI) {
        this.commandList.add(new AddHuman(consoleUI));
        this.commandList.add(new Finish(consoleUI));
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < this.commandList.size(); ++i) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(((Command)this.commandList.get(i)).getDescription());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public void execute(int choice) {
        Command command = (Command)this.commandList.get(choice - 1);
        command.execute();
    }

    public int getSize() {
        return this.commandList.size();
    }
}

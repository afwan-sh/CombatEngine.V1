package combat_engine_v1.userMenu;
import java.util.ArrayList;
import java.util.Scanner;

import combat_engine_v1.ui.Ui;
enum ExploringAction {
    EXPLORE("Explore"),
    LOOK("Look around"),
    STATUS("Check status"),
    ESCAPE("Escape");

    private String value;
    private static final ExploringAction[] ENUM= ExploringAction.values();

    ExploringAction(String value) {
        this.value = value;
    }

    public static ExploringAction fromInt(int id) {
        if (id < 1 || id > ENUM.length) {
            throw new IllegalArgumentException();
        }
        return ENUM[id - 1];
    }
    public static ArrayList<String> getStrings(){
        ArrayList<String> options=new ArrayList<>();
        for (ExploringAction option:ENUM) {
            options.add(option.value);
        }
        return options;
    }
}

public class ExploringMenu {
    Scanner sc = new Scanner(System.in);
    Ui ui=new Ui();
    public String exploring(boolean isMonsterAppeared) {
        boolean isGameRunning = true;
        String actionChoice = "";
        while (isGameRunning) {
            int action=ui.menuAnimation("Explore",ExploringAction.getStrings(),"Dungon");
            try {
                ExploringAction choice=ExploringAction.fromInt(action);
                switch (choice) {
                    case EXPLORE:
                        Explore(isMonsterAppeared);
                        actionChoice="Explore";
                        break;
                    case LOOK:
                        lookAround(isMonsterAppeared);
                        actionChoice="Look around";
                        break;
                    case STATUS:
                        actionChoice="status";
                        break;
                    case ESCAPE:
                        ui.greenMessage("You escaped the Dungeon.");
                        actionChoice="Escape";
                        break;
                }
                isGameRunning=false;
            } catch (IllegalArgumentException e) {
                ui.yellowMessage("no such option");
            }
        }
        return actionChoice;
    }

    public void Explore(boolean isMonsterAppeared) {
        ui.cyanMessage("Exploring...");
        if (isMonsterAppeared) {
            ui.redMessage("A monster appeared!");
        } else {
            ui.cyanMessage("Nothing here....");
        }
    }

    public void lookAround(boolean isMonsterAppeared) {
        if (isMonsterAppeared) {
            ui.yellowMessage("There is a monster ahead!");
        } else {
            ui.cyanMessage("Your safe no Monster ahead! for now...");
        }
    }
}

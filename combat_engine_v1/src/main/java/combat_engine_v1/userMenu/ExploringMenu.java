package combat_engine_v1.userMenu;
import java.util.Scanner;
enum ExploringAction {
    EXPLORE(1),
    LOOK(2),
    STATUS(3),
    ESCAPE(4);

    private int value;
    private static final ExploringAction[] ENUMS = ExploringAction.values();

    ExploringAction(int value) {
        this.value = value;
    }

    public static ExploringAction fromInt(int id) {
        if (id < 1 || id > ENUMS.length) {
            throw new IllegalArgumentException();
        }
        return ENUMS[id - 1];
    }
}

public class ExploringMenu {
    Scanner sc = new Scanner(System.in);
    public String exploring(boolean isMonsterAppeared) {
        boolean isGameRunning = true;
        String actionChoice = "";
        while (isGameRunning) {
            System.out.println("1.Explore");
            System.out.println("2.Look around");
            System.out.println("3.Check status");
            System.out.println("4.Escape");
            System.out.print("Choose your action index:");
            String action=sc.nextLine();
            try {
                ExploringAction choice=ExploringAction.fromInt(Integer.parseInt(action));
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
                        System.out.println("You escaped the Dungeon.");
                        actionChoice="Escape";
                        break;
                }
                isGameRunning=false;
            } catch (IllegalArgumentException e) {
                System.out.println("no such option");
            }
        }
        return actionChoice;
    }

    public void Explore(boolean isMonsterAppeared) {
        System.out.println("Exploring...");
        if (isMonsterAppeared) {
            System.out.println("A monster appeared!");
        } else {
            System.out.println("Nothing here....");
        }
    }

    public void lookAround(boolean isMonsterAppeared) {
        if (isMonsterAppeared) {
            System.out.println("There is a monster ahead!");
        } else {
            System.out.println("Your safe no Monster ahead! for now...");
        }
    }
}

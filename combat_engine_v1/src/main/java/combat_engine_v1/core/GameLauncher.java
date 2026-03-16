package combat_engine_v1.core;

import combat_engine_v1.userMenu.MainMenu;

public class GameLauncher {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.Menu();
        System.out.println("Thank for playing this game");
    }
}

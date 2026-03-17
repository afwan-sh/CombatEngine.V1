package combat_engine_v1.core;

import combat_engine_v1.ui.Ui;
import combat_engine_v1.userMenu.MainMenu;
public class GameLauncher {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        Ui ui=new Ui();
        ui.cyanMessage("Generating the world...");
        ui.cyanMessage("World loaded successfully!");
        ui.cyanMessage("Spawning monsters...");
        ui.cyanMessage("Ready to play!");
        mainMenu.Menu();
        ui.cyanMessage("Thanks for playing! Come back for more adventures.");
    }
}



package combat_engine_v1.userMenu;
import combat_engine_v1.engine.MainEngine;
import combat_engine_v1.ui.Ui;
import java.util.ArrayList;
enum MainMenuOptions{
    START("Start Game"),
    EXIT("Exit");
    private String value;
    private static final MainMenuOptions[] ENUM=MainMenuOptions.values();
    private MainMenuOptions(String value){
        this.value=value;
    }
    public static MainMenuOptions fromInt(int id){
        if(id<1||id>ENUM.length){
            throw new IllegalArgumentException();
        }
        return ENUM[id-1];
    }
    public static ArrayList<String> getStrings(){
        ArrayList<String> options=new ArrayList<>();
        for (MainMenuOptions option:ENUM) {
            options.add(option.value);
        }
        return options;
    }
}
public class MainMenu {
    boolean isRunning=true;
    
    Ui ui=new Ui();
    public void Menu(){
        while(isRunning){
            int action=ui.menuAnimation("Welcome to the Combat EngineV1",MainMenuOptions.getStrings(),"Start_Menu");  
            try{
                MainMenuOptions choice = MainMenuOptions.fromInt(action);
                    switch (choice) {
                        case START:
                            ui.message("Game is started","green");
                            MainEngine engine=new MainEngine();
                            ui.message("You have enter the dungon","cyan");
                            engine.startGame();
                            break;
                        case EXIT:
                            ui.message("Game is closing","cyan");
                            isRunning=false;
                            break;
                    }
            }catch(IllegalArgumentException e){
                ui.message("no such option","red");
            }
        }
    }
}

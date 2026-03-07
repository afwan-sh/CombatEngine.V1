package combat_engine_v1.userMenu;
import java.util.Scanner;
import combat_engine_v1.engine.MainEngine;
enum MainMenuOptions{
    START(1),
    EXIT(2);
    private int value;
    private static final MainMenuOptions[] ENUM=MainMenuOptions.values();
    private MainMenuOptions(int value){
        this.value=value;
    }
    public static MainMenuOptions fromInt(int id){
        if(id<1||id>ENUM.length){
            throw new IllegalArgumentException();
        }
        return ENUM[id-1];
    }
}
public class MainMenu {
    boolean isRunning=true;
    Scanner sc=new Scanner(System.in);
    public void Menu(){
        System.out.println("Welcome to the Combat EngineV1");
        while(isRunning){
            System.out.println("1.Start Game");
            System.out.println("2.Exit");
            System.out.print("Enter your Choice index:");
            String action=sc.nextLine();
            try{
                MainMenuOptions choice = MainMenuOptions.fromInt(Integer.parseInt(action));
                    switch (choice) {
                        case START:
                            System.out.println("Game is started");
                            MainEngine engine=new MainEngine();
                            System.out.println("You have enter the dungon");
                            engine.startGame();
                            break;
                        case EXIT:
                            System.out.println("Game is closing");
                            isRunning=false;
                            sc.close();
                            break;
                    }
            }catch(IllegalArgumentException e){
                System.out.println("no such option");
            }
        }
    }
}

package combat_engine_v1.dungeonArea;
import combat_engine_v1.character.Player;
import combat_engine_v1.ui.Ui;;
public class AncientPool {
public int poolAppeared(int num,Player player){
    Ui ui=new Ui();
    int number=num;
        if(num>=2){
            ui.cyanMessage("You discover an ancient bathing pool,\nsurrounded by glowing moss and whispering winds.\n\nSteam rises from the crystal-clear waters.\nDo you dare to soak? [y/n]");
            String action=ui.input("Ancient_pool");
            if (action.equalsIgnoreCase("y")) {
                ui.greenMessage("You slip into the warm, enchanted waters...");
                ui.cyanMessage("A soothing warmth spreads through your body.");
                ui.greenMessage("♥ All wounds healed! ♥ Health fully restored!");
            }else{
                ui.redMessage("You walk past warily. Who knows what lurks beneath...");
            }
            player.addHP(player.getMaxHP());
            player.addMP(player.getMAXMP());
            player.addEND(player.getMAXEND());
            number=0;

        }
        return number;
 }
}

package dungeonArea;
import combat_engine_v1.character.Player;
public class AncientPool {
public void poolAppeared(int num,Player player){
        if(num>=3){
            System.out.println("You found an ancient pool\nYou soak in the pool\nIt healed you fully");
            player.addHP(player.getMaxHP());
            player.addMP(player.getMAXMP());
            player.addEND(player.getMAXEND());
        }
}
}

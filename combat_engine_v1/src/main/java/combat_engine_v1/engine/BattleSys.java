package combat_engine_v1.engine;
import combat_engine_v1.character.Monster;
import combat_engine_v1.character.Player;
import combat_engine_v1.userMenu.BattleMenu;
public class BattleSys {
    public void battleStart(Player player, Monster monster) {
        boolean battleMode=true;
        int damageDone=0;
        while(battleMode){
            BattleMenu battleMenu=new BattleMenu();
            String firstTurn=(player.getDex()>monster.getDex())? "player":"monster";
            damageDone=battleMenu.fighting(firstTurn,damageDone);
            if(firstTurn.equalsIgnoreCase("player")){
                 damageDone=battleMenu.fighting("monster",damageDone);
            }else{
                damageDone=battleMenu.fighting("player",damageDone);
            }
            if(monster.getHp()<=0){ 
                System.out.println("Monster is defeated!");
            }else if(player.getHp()<=0){
                System.out.println("You have died!");
            }   
        }
    }
   
}

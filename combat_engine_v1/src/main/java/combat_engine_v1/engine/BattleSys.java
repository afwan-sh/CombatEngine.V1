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
            if(firstTurn.equalsIgnoreCase("player")){
                damageDone=battleMenu.fighting(player,monster,damageDone);
                if(damageDone==-1){
                    battleMode=false;
                    System.out.println("You have escaped the battle!");
                }
                monster.damageTaken(damageDone);
                if(monster.getHp()<=0){ 
                    System.out.println("Monster is defeated!");
                }
            }else{
                damageDone=battleMenu.fighting(monster,player,damageDone);
                if(damageDone==-1){
                   battleMode=false;
                   System.out.println("Monster have escaped the battle!");
                }
                player.damageTaken(damageDone);
                if(player.getHp()<=0){
                   System.out.println("You have died!");
                } 
            }     
        }
    }
   
}

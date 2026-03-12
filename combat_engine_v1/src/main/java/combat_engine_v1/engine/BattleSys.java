package combat_engine_v1.engine;
import combat_engine_v1.character.Monster;
import combat_engine_v1.character.Player;
import combat_engine_v1.userMenu.BattleMenu;
public class BattleSys {
    public int battleStart(Player player, Monster monster) {
        boolean battleMode=true;
        int damageDone=0;
        BattleMenu battleMenu=new BattleMenu();
        int healingPool=0;
        String firstTurn=(player.getDex()>monster.getDex())? "player":"monster";
        while(battleMode){
            if(firstTurn.equalsIgnoreCase("player")){
                damageDone=battleMenu.fighting(player,monster,damageDone);
                if(damageDone==-1){
                    battleMode=false;
                    System.out.println("You have escaped the battle!");
                }
                monster.damageTaken(damageDone);
                if(monster.getHp()<=0){ 
                    System.out.println("Monster is defeated!");
                    player.addScore();
                    player.addEXP(monster.giveEXP());
                    healingPool++;
                    battleMode=false;
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
                   battleMode=false;
                } 
            }     
        }
        return healingPool;
    }
}

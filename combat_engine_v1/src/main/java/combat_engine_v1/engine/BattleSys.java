package combat_engine_v1.engine;
import combat_engine_v1.character.Monster;
import combat_engine_v1.character.Player;
import combat_engine_v1.ui.Ui;
import combat_engine_v1.userMenu.BattleMenu;
public class BattleSys {
    public int battleStart(Player player, Monster monster) {
        boolean battleMode=true;
        int damageDone=0;
        BattleMenu battleMenu=new BattleMenu();
        Ui ui=new Ui();
        int healingPool=0;
        String firstTurn=(player.getDex()>monster.getDex())? "player":"monster";
        while(battleMode){
            if(firstTurn.equalsIgnoreCase("player")){
                damageDone=battleMenu.fighting(player,monster,damageDone,firstTurn);
                if(damageDone==-1){
                    battleMode=false;
                    ui.greenMessage("You sprint away just in time!\nWith a clever feint, you escape the battle!\nYou vanish into the shadows - the enemy is confused!\nNarrow escape! The monsters howl in frustration.\nYou break contact and flee to safety.\nDust cloud covers your retreat - successful escape!\nYou dive into nearby brush and disappear!");
                }
                monster.damageTaken(damageDone);
                if(monster.getHp()<=0){ 
                    ui.greenMessage("Monster defeated!");
                    int xpgot=monster.giveEXP();
                    ui.cyanMessage("you got "+xpgot+"XP");
                    player.addScore();
                    player.addEXP(xpgot);
                    healingPool++;
                    battleMode=false;
                }else{
                damageDone=battleMenu.fighting(monster,player,damageDone,"monster");
                player.damageTaken(damageDone);
                }
            }else{
                damageDone=battleMenu.fighting(monster,player,damageDone,firstTurn);
                if(damageDone==-1){
                   battleMode=false;
                   System.out.println("The monster shrieks and bolts!\nIt vanishes into the undergrowth before you can stop it.");
                }
                player.damageTaken(damageDone);
                if(player.getHp()<=0){
                   ui.redMessage("Your fate is sealed.\nYou have been slain.\nAll fades to darkness...\nGAME OVER.");
                   battleMode=false;
                }else{
                    damageDone=battleMenu.fighting(player,monster,damageDone,"player");
                    monster.damageTaken(damageDone);
                } 
            }     
        }
        return healingPool;
    }
}

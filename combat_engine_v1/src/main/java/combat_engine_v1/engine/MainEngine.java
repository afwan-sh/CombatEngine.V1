package combat_engine_v1.engine;
import combat_engine_v1.character.Monster;
import combat_engine_v1.character.Player;
import combat_engine_v1.dungeonArea.AncientPool;
import combat_engine_v1.ui.Ui;
import combat_engine_v1.userMenu.ExploringMenu;
public class MainEngine {
    public void startGame() {
        Player player = new Player();
        MonsterSys monsterSys = new MonsterSys();
        BattleSys BattleSys = new BattleSys();
        ExploringMenu exploringMenu = new ExploringMenu();
        AncientPool ancientPool=new AncientPool();
        Ui ui=new Ui();
        boolean isMonsterAppeared = false;
        int end=player.getEND();
        int monsterDeafedForPool=0;
        while (true) {
            Monster monster = new Monster();
            isMonsterAppeared = monsterSys.monsterAppeared(player,monster);
            String actionChoice = exploringMenu.exploring(isMonsterAppeared);
            if (actionChoice.equalsIgnoreCase("Explore") && isMonsterAppeared) {
                if(end<=0){
                    ui.yellowMessage("Low stamina!");
                }else{
                    player.subEND(1);
                    BattleSys.battleStart(player, monster);
                    if(monster.getHp()==0){
                        player.addEND(1);
                        monsterDeafedForPool++;
                        continue;
                    }
                }
            } else if (actionChoice.equalsIgnoreCase("Escape")) {
                    if(end>5){
                        player.subEND(5);
                        System.out.println("Number of monster defeated :"+player.getScore());
                    }else{
                        ui.yellowMessage("Low stamina!");
                    }
                break;
            } else if (actionChoice.equals("Explore")) {
                    if(end<=0){
                        ui.yellowMessage("Low stamina!");
                    }
                    monsterDeafedForPool=ancientPool.poolAppeared(monsterDeafedForPool, player);
            }else if(actionChoice.equalsIgnoreCase("status")){
                player.addEND(1);
                player.getStatus();
            }
            else if(actionChoice.equalsIgnoreCase("look around")){
                player.addEND(2);
                ancientPool.poolAppeared(monsterDeafedForPool, player);
            }
        }
    }
}
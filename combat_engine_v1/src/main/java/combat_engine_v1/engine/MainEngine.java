package combat_engine_v1.engine;
import combat_engine_v1.character.Monster;
import combat_engine_v1.character.Player;
public class MainEngine {
    public void startGame() {
        Player player = new Player();
        MonsterSys monsterSys = new MonsterSys();
        BattleSys BattleSys = new BattleSys();
        ExploringSys ExploringEngine = new ExploringSys();
        boolean isMonsterAppeared = false;
        int end=player.getEND();
        while (true) {
            isMonsterAppeared = monsterSys.monsterAppeared();
            Monster monster = new Monster();
            String actionChoice = ExploringEngine.exploring(isMonsterAppeared);
            if (actionChoice.equalsIgnoreCase("Explore") && isMonsterAppeared) {
                if(end<=0){
                    System.out.println("You Stamina is low");
                }else{
                    player.subEND(1);
                    BattleSys.battleStart(player, monster);
                    if(monster.getHp()==0){
                        player.addEND(1);
                        continue;
                    }
                }
            } else if (actionChoice.equalsIgnoreCase("Escape")) {
                    if(end>5){
                        player.subEND(5);
                        System.out.println("Number of monster defeated :"+player.getScore());
                    }else{
                        System.out.println("You Stamina is low");
                    }
                break;
            } else if (actionChoice.equals("Explore")) {
                    if(end<=0){
                        System.out.println("You Stamina is low");
                    }
                break;
            }else if(actionChoice.equalsIgnoreCase("status")){
                player.getStatus();
            }
            else if(actionChoice.equalsIgnoreCase("")){
                player.addEND(2);
            }
        }
    }
}
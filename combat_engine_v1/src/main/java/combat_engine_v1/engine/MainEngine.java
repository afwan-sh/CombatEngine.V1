package combat_engine_v1.engine;
import combat_engine_v1.character.Monster;
import combat_engine_v1.character.Player;
public class MainEngine {
    public void startGame() {
        Player player = new Player();
        Monster monster = new Monster();
        MonsterSys monsterSys = new MonsterSys();
        ExploringSys ExploringEngine = new ExploringSys();
        boolean isMonsterAppeared = false;
        while (true) {
            isMonsterAppeared = monsterSys.monsterAppeared();
            String actionChoice = ExploringEngine.exploring(isMonsterAppeared, player, monster);
            if (actionChoice.equalsIgnoreCase("Explore") && isMonsterAppeared) {
                 BattleSys BattleSys = new BattleSys();
                 BattleSys.battleStart(player, monster);
            } else if (actionChoice.equalsIgnoreCase("Escape")) {
                break;
            } else if (actionChoice.equals("Explore")) {
                break;
            }
        }
    }
}
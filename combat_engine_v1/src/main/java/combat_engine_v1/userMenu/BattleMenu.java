package combat_engine_v1.userMenu;
import java.util.ArrayList;
import java.util.Scanner;

import combat_engine_v1.action.ActionLogic;
import combat_engine_v1.character.Characters;
import combat_engine_v1.engine.MonsterSys;
import combat_engine_v1.ui.Ui;
enum BattleAction{
    BASIC_ATTACK("Basic Attack"),
    BLOCK("Block"),
    DOGE("Doge"),
    SKILL("Use Skills"),
    ESCAPE("Run Away");
    private String value;
    private static final BattleAction[] ENUM=BattleAction.values();
    private BattleAction(String value) {
        this.value = value;
   }
   public static BattleAction fromInt(int id){
    if(id<1||id>ENUM.length){
        throw new IllegalArgumentException();
    }
    return ENUM[id-1];
   }
    public static ArrayList<String> getStrings() {
        ArrayList<String> options = new ArrayList<>();
        for (BattleAction option : ENUM) {
            options.add(option.value);
        }
        return options;
    }
}
public class BattleMenu {
    int damage;
    Scanner sc=new Scanner(System.in);
    ActionLogic activite=new ActionLogic();
    MonsterSys monsterSys=new MonsterSys();
    Ui ui=new Ui();
    public int fighting(Characters attacker,Characters defender,int damage,String user){
        boolean loop=true;
        while(loop){
        int action;
        if(user.equalsIgnoreCase("player")){
            action=ui.menuAnimation("Combat is start", BattleAction.getStrings(), "Battle");
        }else{
            action=monsterSys.monsterAttackPattren(attacker);
        }
         try{
                BattleAction action1 = BattleAction.fromInt(action);
                    switch (action1) {
                        case BASIC_ATTACK:
                            damage=activite.basicAttack(attacker,defender);
                            break;  
                        case BLOCK:
                            damage=activite.block(attacker,defender,damage);
                            break;
                        case DOGE:
                            damage=activite.doge(attacker,defender,damage);
                            break;
                        case SKILL:
                            ui.yellowMessage("used skill");
                            break;
                        case ESCAPE:
                            damage=-1;
                            ui.cyanMessage(attacker.getClass().getSimpleName()+" Used runway");
                            break;
                    }
                    loop=false;    
            }catch(IllegalArgumentException e){
                ui.cyanMessage("Enter a valid action number");
            }   
        }
     return damage;  
    }
}

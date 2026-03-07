package combat_engine_v1.userMenu;
import java.util.Scanner;
import combat_engine_v1.action.ActionLogic;
import combat_engine_v1.character.Characters;
enum BattleAction{
    BASIC_ATTACK(1),
    BLOCK(2),
    DOGE(3),
    SKILL(4),
    ESCAPE(5);
    private int value;
    private static final BattleAction[] ENUMS=BattleAction.values();
    private BattleAction(int value) {
        this.value = value;
   }
   public static BattleAction fromInt(int id){
    if(id<1||id>ENUMS.length){
        throw new IllegalArgumentException();
    }
    return ENUMS[id-1];
   }
}
public class BattleMenu {
    int damage;
    Scanner sc=new Scanner(System.in);
    ActionLogic activite=new ActionLogic();
    public int fighting(Characters attacker,Characters defender,int damage){
        boolean loop=true;
        while(loop){
        System.out.println("1.Basic Attack");
        System.out.println("2.Block");
        System.out.println("3.Doge");
        System.out.println("4.Use Skills");
        System.out.println("5.Run Away");
        System.out.print("Choose your action index:");
        String action=sc.nextLine();
         try{
                BattleAction action1 = BattleAction.fromInt(Integer.parseInt(action));
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
                            System.out.println("used skill");
                            break;
                        case ESCAPE:
                            damage=-1;
                            System.out.println(attacker.getClass().getSimpleName()+" Used runway");
                            break;
                    }
                    loop=false;    
            }catch(IllegalArgumentException e){
                System.out.println("Enter a valid action number");
            }   
        }
     return damage;  
    }
}

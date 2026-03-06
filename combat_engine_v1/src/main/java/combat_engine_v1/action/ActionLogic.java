package combat_engine_v1.action;
import combat_engine_v1.character.Characters;
public class ActionLogic {
    public int basicAttack(Characters attacker,Characters defender){
        int damage=(((attacker.getAtk()+(int)(Math.random()*10))-(defender.getDef()/2)));
                if(damage<=0){
                 damage=1;
                }
                System.out.printf("%s has done %d of damage\n",attacker.getClass().getSimpleName(),damage);
                return damage;
    }
    public int doge(Characters attacker,Characters defender,int damage){
                int doneDamage;
                if(attacker.getDex()>defender.getDex()){
                    System.out.println(attacker.getClass().getSimpleName()+"'s block failed!");
                    doneDamage=damage;
                }else if(attacker.getDex()>defender.getDex() && attacker.getDef()>defender.getAtk()){
                    System.out.println(attacker+" took 50% reduced damage!");
                    doneDamage=damage/2;
                }else{
                    System.out.println(attacker.getClass().getSimpleName()+" successfully blocked the attack!");
                    doneDamage=0;
                 }
        return doneDamage;
    }
    public int block(Characters attacker,Characters defender,int damage){
        int doneDamage=0;
        if(attacker.getDef()>defender.getAtk()){
            System.out.println("");
            doneDamage=damage/2;
        }else{
            System.out.println(attacker.getClass().getSimpleName()+" failed to block the attack!");
            doneDamage=damage;
        }
    return doneDamage;
    }
}

package combat_engine_v1.action;
import combat_engine_v1.character.Characters;
public class ActionLogic {
    public int basicAttack(Characters user,Characters oppenent){
        int damage=0;
        int end=user.getEND();
        if(end>0){
            damage=(((user.getAtk()+(int)(Math.random()*10))-(oppenent.getDef()/2)));
            if(damage<=0){
            damage=1;
            }
            System.out.printf("%s has done %d of damage\n",user.getClass().getSimpleName(),damage);
        }else{
            System.out.println("low Stamina");
        }
        user.subEND(1);
        return damage;  
    }
    public int doge(Characters user,Characters oppenent,int damage){
            int doneDamage=0,usedEND=0;
            int end=user.getEND();
            if(end>0){
            if(user.getDex()<oppenent.getDex()){
                System.out.println(user.getClass().getSimpleName()+"'s block failed!");
                doneDamage=damage;
                usedEND=1;
            }else if(user.getDex()>oppenent.getDex() && user.getDef()>oppenent.getAtk()){
                System.out.println(user.getClass().getSimpleName()+" took 50% reduced damage!");
                doneDamage=damage/2;
                usedEND=1;
            }else{
                System.out.println(user.getClass().getSimpleName()+" successfully blocked the attack!");
                doneDamage=0;
                usedEND=2;
             }
             user.subEND(usedEND);
            }
        return doneDamage;
    }
    public int block(Characters user,Characters opponent,int damage){
        int doneDamage=0,usedEND=0;
        int end=user.getEND();
        if(end>0){
        if(user.getDef()>opponent.getAtk()){
            System.out.println("");
            doneDamage=damage/2;
        }else{
            System.out.println(user.getClass().getSimpleName()+" failed to block the attack!");
            doneDamage=damage;
        }
        user.subEND(usedEND);
    }
    return doneDamage;
    }
}

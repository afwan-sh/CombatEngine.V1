package combat_engine_v1.action;
import combat_engine_v1.character.Characters;
import combat_engine_v1.character.Monster;
import combat_engine_v1.character.Player;
public class ActionLogic {
    Characters user=new Player();
    Characters opponent=new Monster();
    public void perfomer(String User){
        if(User.equalsIgnoreCase("player")){
            user=new Player();
            opponent=new Monster();
        }else{
            user = new Monster();
            opponent=new Player();
        }
    }
    public int basicAttack(String User){
        perfomer(User);
        int damage=((user.getAtk()+((int)(Math.random()*10)))-(opponent.getDef()/2));
                if(damage<=0){
                 damage=1;
                }
                System.out.printf("%s has done %d of damage\n",User,damage);
                return damage;
    }
    public int doge(String User,int damage){
                perfomer(User);
                int doneDamage;
                if(user.getDex()>opponent.getDex()){
                    System.out.println(User+"'s block failed!");
                    doneDamage=damage;
                }else if(user.getDex()>opponent.getDex() && user.getDef()>opponent.getAtk()){
                    System.out.println(User+" took 50% reduced damage!");
                    doneDamage=damage/2;
                }else{
                    System.out.println(User+" successfully blocked the attack!");
                    doneDamage=0;
                 }
        return doneDamage;
    }
    public int block(String User,int damage){
        int doneDamage=0;
        perfomer(User);
        if(user.getDef()>opponent.getAtk()){
            System.out.println("");
            doneDamage=damage/2;
        }else{
            System.out.println(User+" failed to block the attack!");
            doneDamage=damage;
        }
    return doneDamage;
    }
}

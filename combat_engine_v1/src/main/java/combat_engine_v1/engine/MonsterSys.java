package combat_engine_v1.engine;
import combat_engine_v1.character.Characters;
import combat_engine_v1.character.Monster;
import combat_engine_v1.character.Player;
public class MonsterSys {
    boolean isMonsterAppeared=false;
    public boolean monsterAppeared(Player player,Monster monster){
        if((int)(Math.random()*100)<50){
            isMonsterAppeared=true;
			int monsterLevel=(int)(Math.random()*100);
			if(monsterLevel<=20){
				monster.makeLevel(player.getLevel()-1);
			}else if(monsterLevel<=70){
				monster.makeLevel(player.getLevel());
			}else{
				monster.makeLevel(player.getLevel()+1);
			}
        }
        return isMonsterAppeared;
    }
    public int monsterAttackPattren(Characters monster){
        double hpPercentage=((double)monster.getMaxHP()/monster.getHp())*100;
        int randomAction=(int)(Math.random()*100);
        int attack=0;  
        if(hpPercentage<=5){
	        if(randomAction<=50){
	           attack=5;
	        }else{
	           attack=1;
	        }   
	    }else if(hpPercentage<=20){
			attack=1;
	    }else if(hpPercentage<=50){
			if(randomAction<=30){
				attack=3;
	        }else{
	            attack=1;
	        }
	    }else{
			if(randomAction<=10){
				attack=3;
	        }else if(randomAction<=30){
	            attack=2;
	        }else if(randomAction<=50){
	            attack=1;
	        }else{
	            attack=1;
	        }
	    }
        return attack;
    }

}

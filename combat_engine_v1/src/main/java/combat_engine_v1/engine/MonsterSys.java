package combat_engine_v1.engine;

public class MonsterSys {
    boolean isMonsterAppeared=false;
    String monsterState;
    public boolean monsterAppeared(){
        if((int)(Math.random()*10)>5){
            isMonsterAppeared=true; 
        }
        return isMonsterAppeared;
    }
    
}

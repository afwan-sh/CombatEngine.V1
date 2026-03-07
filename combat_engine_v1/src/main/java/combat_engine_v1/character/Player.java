package combat_engine_v1.character;

public class Player extends Characters{
    private int MAXHP;
    private int MAXMP;
    private int MAXEND;
    private int totalScore;
    private int EXP;
    private int MAXEXP;
    public Player(){
        super(100,50,30,15,10,12);
        MAXHP=HP;
        MAXMP=MP;
        MAXEND=END;
    }
    public void getStatus(){
        System.out.printf("Player Status:\nLevel:%d/%d\nHp:%d/%d\nMp:%d/%d\nAtk:%d\nDef:%d\nDex:%d\nEnd:%d/%d\n",EXP,MAXEXP,HP,MAXHP,MP,MAXMP,ATK,DEF,DEX,END,MAXEND);
    }  
    public int getDex(){
        return DEX;
    }
    public int getHp(){
        return HP;
    }
    public int getDef(){
        return DEF;
    }
    public int getAtk(){
        return ATK;
    }
    public int getEXP(){
        return EXP;
    }
    public int getMAXEXP(){
        return MAXEXP;
    }
    public int getEND(){
        return END;
    }
    public int getMAXEND(){
    return MAXEND;
    }
    public void damageTaken(int damage){
        if(damage>0){
            HP-=damage;
        if(HP<0){
            HP=0;
        }
        } 
    }
    public void addScore(){
        totalScore++;
    }
    public int getScore(){
        return totalScore;
    }
    public void subEND(int num){
        if(num>0){
            END-=num;
        }
    }
    public void addEND(int num){
        if(END<MAXEND && num>0){
            END+=num;
        }
    }
}

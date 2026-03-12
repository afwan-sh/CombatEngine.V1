package combat_engine_v1.character;

public class Player extends Characters{
    private int MAXHP;
    private int MAXMP;
    private int MAXEND;
    private int totalScore;
    private int EXP;
    public Player(){
        super(150,50,20,20,15,20,1);
        MAXHP=HP;
        MAXMP=MP;
        MAXEND=END;
    }
    public void getStatus(){
        System.out.printf("Player Status:\nLevel:%d\nEXp:%d/%d\nHp:%d/%d\nMp:%d/%d\nAtk:%d\nDef:%d\nDex:%d\nEnd:%d/%d\n",Level,EXP,getMAXEXP(),HP,MAXHP,MP,MAXMP,ATK,DEF,DEX,END,MAXEND);
    }
    public int getMaxHP(){
        return MAXHP;
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
    public int getEND(){
        return END;
    }
    public int getMAXEND(){
    return MAXEND;
    }
    public int getMAXMP(){
        return MAXMP;
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
        if(num>0&&END>0){
            END-=num;
        }
    }
    public void addEND(int num){
        if(num>0){
            END+=num;
            if(END>MAXEND){
                END=MAXEND;
            }
        }
    }
    public void addHP(int num){
        if(num>0){
            HP+=num;
            if(HP>MAXHP){
                HP=MAXHP;
            }
        }
    }
    public void addMP(int num){
        if(num>0){
            MP+=num;
            if(MP>MAXMP){
                MP=MAXMP;
            }
        }
    }
    public int getMAXEXP(){
        return (int)(Math.pow(Level, 2) * 50 + 100);
    }
    public void addEXP(int num){
        if(num>0){
           EXP+=num;
           while(EXP>getMAXEXP()){
            levelUp(EXP);
           }
        }
    }
    public void levelUp(int remaningXp){
        Level++;
        MAXHP+=(MAXHP*0.10);
        MAXMP+=(MAXMP*0.10);
        ATK+=(ATK*0.10);
        DEF+=(DEF*0.10);
        DEX+=(DEX*0.10);
        MAXEND+=(MAXEND*0.10);
        EXP=remaningXp;
        fullHeal();
    }
    public void fullHeal(){
        HP=MAXHP;
        MP=MAXMP;
        END=MAXEND;
    }
}





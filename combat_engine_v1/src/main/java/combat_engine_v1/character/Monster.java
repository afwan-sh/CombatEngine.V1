package combat_engine_v1.character;
import combat_engine_v1.ui.Ui;
public class Monster extends Characters{
    private int MAXHP;
    private int MAXMP;
    private int MAXEND;
    public Monster(){
        super(80,50,12,8,14,10,1);
        MAXHP=HP;
        MAXMP=MP;
        MAXEND=END;
    }
    public void getStatus(){
        String message=String.format("Monster Status:\nLevel:%d\nHp:%d/%d\nMp:%d/%d\nAtk:%d\nDef:%d\nDex:%d\nEnd:%d/%d\n",Level,HP,MAXHP,MP,MAXMP,ATK,DEF,DEX,END,MAXEND);
        Ui ui=new Ui();
        ui.cyanMessage(message);
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
    public void damageTaken(int damage){
        if(damage>0){
            HP-=damage;
        if(HP<0){
            HP=0;
        }
        } 
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
    public int giveEXP(){
        double monsterXp=Math.pow(Level,2)*50+100;
        double baseXp=monsterXp/12;
        return (int)(baseXp*(0.9+(Math.random()*0.2)));
    }
    public int getMaxHP(){
        return MAXHP;
    }
    public void makeLevel(int level){
        Level=level;
        HP=HP*(int)(1.1*Math.pow(level,1));
        MP=MP*(int)(1.1*Math.pow(level,1));
        ATK=ATK*(int)(1.1*Math.pow(level,1));
        DEF=DEF*(int)(1.1*Math.pow(level,1));
        DEX=DEX*(int)(1.1*Math.pow(level,1));
        END=END*(int)(1.1*Math.pow(level,1));
    }
}





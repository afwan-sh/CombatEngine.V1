package combat_engine_v1.character;
public class Monster extends Characters{
    private int MAXHP;
    private int MAXMP;
    private int MAXEND;
    public Monster(){
        super(250,50,30,20,10,20,2);
        MAXHP=HP;
        MAXMP=MP;
        MAXEND=END;
    }
    public void getStatus(){
        System.out.printf("Monster Status:\nLevel:%d\nHp:%d/%d\nMp:%d/%d\nAtk:%d\nDef:%d\nDex:%d\nEnd:%d/%d\n",Level,HP,MAXHP,MP,MAXMP,ATK,DEF,DEX,END,MAXEND);
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
        return (int)(Level*1.5)+(int)(Math.random()*5);
    }
}






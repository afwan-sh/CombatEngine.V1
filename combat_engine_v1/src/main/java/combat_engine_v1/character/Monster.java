package combat_engine_v1.character;
public class Monster extends Characters{
    private int MAXHP;
    private int MAXMP;
    private int MAXEND;
    public Monster(){
        super(12000,5,30,1,15,12);
        MAXHP=HP;
        MAXMP=MP;
        MAXEND=END;
    }
    public void getStatus(){
        System.out.printf("Monster Status:\nHp:%d/%d\nMp:%d/%d\nAtk:%d\nDef:%d\nDex:%d\nEnd:%d/%d\n",HP,MAXHP,MP,MAXMP,ATK,DEF,DEX,END,MAXEND);
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
    public void damageTaken(int damage){
        if(damage>0){
            HP-=damage;
        if(HP<0){
            HP=0;
        }
        } 
    }
}

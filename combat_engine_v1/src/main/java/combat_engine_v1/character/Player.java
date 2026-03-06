package combat_engine_v1.character;

public class Player extends Characters{
    private int MAXHP;
    private int MAXMP;
    private int MAXEND;
    public Player(){
        super(100,50,30,15,10,12);
        MAXHP=HP;
        MAXMP=MP;
        MAXEND=END;
    }
    public void getStatus(){
        System.out.printf("Player Status:\nHp:%d/%d\nMp:%d/%d\nAtk:%d\nDef:%d\nDex:%d\nEnd:%d/%d\n",HP,MAXHP,MP,MAXMP,ATK,DEF,DEX,END,MAXEND);
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

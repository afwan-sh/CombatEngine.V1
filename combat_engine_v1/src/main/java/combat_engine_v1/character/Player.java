package combat_engine_v1.character;

public class Player extends Characters{
    private int MAXHP=HP;
    private int MAXMP=MP;
    private int MAXEND=END;
    public Player(){
        super(100,50,30,15,10,12);
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
}

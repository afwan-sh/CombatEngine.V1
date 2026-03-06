package combat_engine_v1.character;
public class Monster extends Characters{
    private int MAXHP=HP;
    private int MAXMP=MP;
    private int MAXEND=END;
   public Monster(){
        super(1200,500,300,150,100,120);
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

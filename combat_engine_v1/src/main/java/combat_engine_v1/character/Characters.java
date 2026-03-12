package combat_engine_v1.character;

public abstract class Characters {
    protected int HP;
    protected int MP;
    protected int ATK;
    protected int DEF;
    protected int DEX;
    protected int END;
    protected int Level;
     public Characters(int hp,int mp,int atk,int def,int dex,int end,int Level){
          this.HP=hp;
          this.MP=mp;
          this.ATK=atk;
          this.DEF=def;
          this.DEX=dex;
          this.END=end;
     }
     public boolean isCrit(){
        boolean isCrit=false;
        if((Math.random()*10)<=(DEX/10)){
            isCrit=true;
        } 
       return isCrit;
    }
    public abstract void getStatus();
    public abstract void damageTaken(int damage);
    public abstract int getDex();
    public abstract int getHp();
    public abstract int getDef();
    public abstract int getAtk();
    public abstract int getEND();
    public abstract int getMAXEND();
    public abstract void subEND(int num);
    public abstract void addEND(int num);
}


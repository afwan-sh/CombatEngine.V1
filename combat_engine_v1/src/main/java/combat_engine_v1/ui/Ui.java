package combat_engine_v1.ui;
import java.util.Scanner;
import java.util.ArrayList;
public class Ui {
    int length=50;
    int remain;
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m"; //for danger/damage
    public static final String GREEN = "\u001B[32m"; //for good thing healing xp 
    public static final String YELLOW = "\u001B[33m"; //warrning important info
    public static final String CYAN = "\u001B[36m"; // bodder player input
    public static final String BOLD = "\u001B[1m";
    public static final String PURPLE = "\u001B[35m"; //magic and skill
    public static final String BLUE = "\u001B[34m";
    Scanner sc=new Scanner(System.in);
    public void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();      
    }
    public void top(){
        System.out.println("╔"+"═".repeat(length)+"╗");
    }
    public void bottom(){
        System.out.println("╚"+"═".repeat(length)+"╝");
    }
    public void message(String name,String color){
        remain=length-name.length();
        top();
        System.out.println("║"+name+" ".repeat(remain)+"║");
        bottom();
    }
    public String input(String word){
        System.out.printf("[player@%s]w⤒/s⤓:",word);
        String output=sc.nextLine();
        clear();
        return output;
    }
    public void menu(String title,ArrayList<String> options,int selected){
        remain=length-(title.length()+2);
        String word=BOLD+GREEN+"["+title+"]"+RESET;
        top();
        if(remain%2!=0){
        System.out.println("║"+" ".repeat(remain/2)+word+" "+" ".repeat(remain/2)+"║");
        }else{
          System.out.println("║"+" ".repeat(remain/2)+word+" ".repeat(remain/2)+"║");
        }
        System.out.println("╠"+"═".repeat(length)+"╣");
        for(int i=0;i<options.size();i++){
        String option=options.get(i);
        remain = length-(option.length()+2);
        if(i==selected){
            option=YELLOW+BOLD+"> "+options.get(i)+RESET;
        }else{
            option="  "+options.get(i);
        }
        System.out.println("║"+option+" ".repeat(remain)+"║");
    }
        bottom();
    }
    public int menuAnimation(String title,ArrayList<String> options,String name){
        int selected=0;
        int action=1;
        while(true){
            menu(title,options,selected);
           String input=input(name);
            if(input.equalsIgnoreCase("w") && selected>0){
                selected--;
            }
            else if(input.equalsIgnoreCase("s") && selected<options.size()-1){
                selected++;
            }
            else if(input.equalsIgnoreCase("")){
                action=selected+1;
                break;
            }
            clear();
        }
        return action;
    }
}

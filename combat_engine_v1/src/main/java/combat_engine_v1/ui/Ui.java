package combat_engine_v1.ui;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    int length = 50;
    int remain;
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m"; // for danger/damage
    public static final String GREEN = "\u001B[32m"; // for good thing healing xp
    public static final String YELLOW = "\u001B[33m"; // warrning important info
    public static final String CYAN = "\u001B[36m"; // bodder player input
    public static final String BOLD = "\u001B[1m";
    public static final String PURPLE = "\u001B[35m"; // magic and skill
    public static final String BLUE = "\u001B[34m";
    public static final String leftUp = BLUE + "╔" + RESET;
    public static final String leftDown = BLUE + "╚" + RESET;
    public static final String rightUp = BLUE + "╗" + RESET;
    public static final String rigthDown = BLUE + "╝" + RESET;
    public static final String dash = BLUE + "═" + RESET;
    public static final String wall = BLUE + "║" + RESET;
    public static final String rightWall = BLUE + "╣" + RESET;
    public static final String leftWall = BLUE + "╠" + RESET;
    Scanner sc = new Scanner(System.in);

    public void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[3J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println();
        }
    }

    public void top() {
        System.out.println(leftUp + dash.repeat(length) + rightUp);
    }

    public void bottom() {
        System.out.println(leftDown + dash.repeat(length) + rigthDown);
    }

    public void greenMessage(String name) {
        remain = length - name.length();
        top();
        System.out.println(wall + GREEN + name + RESET + " ".repeat(remain) + wall);
        bottom();
        sc.nextLine();
        clear();
    }

    public void redMessage(String name) {
        remain = length - name.length();
        top();
        System.out.println(wall + RED + name + RESET + " ".repeat(remain) + wall);
        bottom();
        sc.nextLine();
        clear();
    }

    public void yellowMessage(String name) {
        remain = length - name.length();
        top();
        System.out.println(wall + YELLOW + name + RESET + " ".repeat(remain) + wall);
        bottom();
        sc.nextLine();
        clear();
    }

    public void purpleMessage(String name) {
        remain = length - name.length();
        top();
        System.out.println(wall + PURPLE + name + RESET + " ".repeat(remain) + wall);
        bottom();
        sc.nextLine();
        clear();
    }

    public void cyanMessage(String name) {
        remain = length - name.length();
        top();
        System.out.println(wall + CYAN + name + RESET + " ".repeat(remain) + wall);
        bottom();
        sc.nextLine();
        clear();
    }

    public String input(String word) {
        String print = CYAN+"[Player@"+RESET+ YELLOW+word+RESET+CYAN+"]w↑/s↓:"+RESET;
        typeEffect(print);
        String output = sc.nextLine();  
        clear();
        return output;
    }

    public void menu(String title, ArrayList<String> options, int selected) {
        remain = length - (title.length() + 2);
        String word = BOLD + GREEN + "[" + title + "]" + RESET;
        top();
        if (remain % 2 != 0) {
            System.out.println(wall + " ".repeat(remain / 2) + word + " " + " ".repeat(remain / 2) + wall);
        } else {
            System.out.println(wall + " ".repeat(remain / 2) + word + " ".repeat(remain / 2) + wall);
        }
        System.out.println(leftWall + dash.repeat(length) + rightWall);
        for (int i = 0; i < options.size(); i++) {
            String option = options.get(i);
            remain = length - (option.length() + 2);
            if (i == selected) {
                option = YELLOW + BOLD + "> " + options.get(i) + RESET;
            } else {
                option = "  " + options.get(i);
            }
            System.out.print(wall); 
            typeEffect(option);
            System.out.println(" ".repeat(remain) + wall);
        }
        bottom();
    }

    public int menuAnimation(String title, ArrayList<String> options, String name) {
        int selected = 0;
        int action = 1;

        while (true) {
            menu(title, options, selected);
            String key = input("menu");
            if ((key.equals("w")) && selected > 0) {
                selected--;
            } else if ((key.equals("s")) && selected < options.size() - 1) {
                selected++;
            } else if (key.equals("")) {
                action = selected + 1;
                clear();
                break;
            }
            clear();
        }
        return action;
    }
    public void typeEffect(String word){
        try{
        for(int i=0;i<word.length();i++){
		     System.out.print(word.charAt(i));
		     Thread.sleep(10);
		 }
        }catch(InterruptedException e){

        }
    }
}

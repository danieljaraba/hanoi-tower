import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Integer> main;
    private static ArrayList<Integer> intermediate;
    private static ArrayList<Integer> destiny;
    private static String output;
    private static Scanner sc;

    public static void main(String[] args) {
        main = new ArrayList<>();
        intermediate = new ArrayList<>();
        destiny = new ArrayList<>();
        output = "";
        sc = new Scanner(System.in);
        int times = sc.nextInt();
        sc.nextLine();
        read(times);
        System.out.print(output);
    }

    public static void hanoi(int heigth, ArrayList<Integer> main, ArrayList<Integer> intermediate, ArrayList<Integer> destiny){
        if(heigth == 1){
            move(main, destiny);
        } else{
            hanoi(heigth-1, main, destiny, intermediate);
            move(main, destiny);
            hanoi(heigth-1, intermediate, main, destiny);
        }
    }

    public static void move(ArrayList<Integer> from, ArrayList<Integer> to){
        output += main.size() + " " + intermediate.size() + " " + destiny.size() + "\n";
        to.add(from.get(from.size()-1));
        from.remove(from.size()-1);
    }

    public static void read(int times){
        if(times == 1){
            int size = sc.nextInt();
            sc.nextLine();
            main.clear();
            intermediate.clear();
            destiny.clear();
            fillArrays(size);
            hanoi(size, main, intermediate, destiny);
            output += main.size() + " " + intermediate.size() + " " + destiny.size() + "\n\n";
        } else{
            int size = sc.nextInt();
            sc.nextLine();
            main.clear();
            intermediate.clear();
            destiny.clear();
            fillArrays(size);
            hanoi(size, main, intermediate, destiny);
            output += main.size() + " " + intermediate.size() + " " + destiny.size() + "\n\n";
            read(times - 1);
        }
    }

    public static void fillArrays(int size){
        if(size == 1){
            main.add(size);
        } else{
            main.add(size);
            fillArrays(size - 1);
        }
    }
}

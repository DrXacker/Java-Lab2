import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String example = in.nextLine();
        char[] var = new ReplacerExpression().checkRE(example);

        Сalculator calc = new Сalculator(example);
        if(var[1] == '-')
            System.out.println("Ответ: "+calc.mainCalc());
        else{
            for(int i = 0; i < var.length; i++){
                System.out.println(var[i]+"= ");
                example.replaceAll(String.valueOf(var[i]), in.next());
            }
            System.out.println("Ответ: "+calc.mainCalc());
        }

    }
}

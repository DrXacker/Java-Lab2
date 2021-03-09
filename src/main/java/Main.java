import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String example = in.nextLine();
        char[] var = new ReplacerExpression().checkRE(example);

        if(var[0] == '-') {
            Сalculator calc = new Сalculator(example);
            double a = calc.mainCalc();
            System.out.println("Ответ: " + a);
        }
        else{
            for(int i = 0; i < new ReplacerExpression().sizeRE(var); i++){
                System.out.println(var[i]+"= ");
                example = example.replaceAll(String.valueOf(var[i]), in.next());
            }
            Сalculator calc = new Сalculator(example);
            System.out.println("Ответ: "+calc.mainCalc());
        }

    }
}

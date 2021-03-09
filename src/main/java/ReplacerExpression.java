import java.util.Arrays;

public class ReplacerExpression {

    public char[] checkRE(String expression){
        char[] variables = new char[expression.length()/2+1];
        Arrays.fill(variables, '-');

        boolean flag = true;
        int indVar = 0;
        char buff;
        for(int i = 0; i < expression.length(); i++){
            buff = expression.charAt(i);
            if(buff == 'P') continue;

            if(i+4 <= expression.length() && (buff == 's' && expression.substring(i, i+3).equals("sin")||
                    buff == 'c' && expression.substring(i, i+4).equals("cos(")||
                    buff == 't' && expression.substring(i, i+4).equals("tan(")||
                    buff == 'c' && expression.substring(i, i+4).equals("ctg(")||
                    buff == 'e' && expression.substring(i, i+4).equals("exp(")))
            {i+=3; continue;}

            if(buff >= 'A' && buff <= 'Z' || buff >= 'a' && buff <= 'z'){
                for(int j = 0; j < indVar; j++){
                    if(buff == variables[j])
                        flag = false;
                        break;
                    }
                if(flag){
                    variables[indVar] = buff;
                    ++indVar;
                }
                flag = true;
            }
        }
        return variables;
    }

    public int sizeRE(char[] c){
        int i = 0;
        for(; i < c.length; i++)
            if(c[i] == '-')
                break;
        return i;
    }
}

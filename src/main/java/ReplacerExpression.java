public class ReplacerExpression {
//    /**
//     * Строка с логическим выражением
//     */
//    private final String expression;
//
//    public ReplacerExpression(String expression){
//        this.expression = expression;
//    }

    public char[] checkRE(String expression){
        char[] variables = new char[expression.length()/2+1];
        for(int i = 0; i < variables.length; i++)
            variables[i] = '-';

        boolean flag = true;
        int indVar = 0;
        char buff;
        for(int i = 0; i < expression.length(); i++){
            buff = expression.charAt(i);
            if((buff >= 'A' && buff <= 'Z' || buff >= 'a' && buff <= 'z') && buff != 'P'){
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

}

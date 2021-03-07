import java.util.Stack;

public class Сalculator {
    /**
     * Строка с логическим выражением
     */
    private String expression;

    public Сalculator(String expression) {
        this.expression = expression;
    }

    /**
     * Стек с числами
     */
    private Stack<Leksema> stack_n = new Stack<Leksema>();
    /**
     * Стек с операциями
     */
    private Stack<Leksema> stack_o = new Stack<Leksema>();
    /**
     * Объект типа Leksema
     */
    private Leksema item;

    /**
     * Основной метод вычисления логического выражения
     * @return - выводится значение выражения либо ошибка, из-за того что выражение написано неправильно
     */
    public double mainCalc(){
        double value = 0d;
        boolean flag = true;
        for(int i = 0; i < expression.length(); i++){
            item = new Leksema();
            char buff = expression.charAt(i);
            if (buff == ' ') continue;
            if(buff >= '0' && buff <= '9' || buff == '-' && flag){
                if(buff == '-') {
                    ++i;
                    buff = expression.charAt(i);
                    value = stringGetNumb(i);
                    item.type = '0';
                    item.value = -value;
                    stack_n.push(item);
                }
                else{
                    value = stringGetNumb(i);
                    item.type = '0';
                    item.value = value;
                    stack_n.push(item);
                }
                i = stringGetLastIndNumb(i)-1;
                flag = false;
                continue;
            }
            else if (buff == '+' || buff == '-' && !flag|| buff == '*' || buff == '/' || buff == '^') { //Если прочитана операция
                if(stack_o.size() == 0) {
                    item.type = buff;
                    item.value = 0;
                    stack_o.push(item); //Операция кладется в стек с операциями
                    continue;
                }
                if(stack_o.size() != 0 && getRang(buff) > getRang(stack_o.peek().type)){
                    item.type = buff;
                    item.value = 0;
                    stack_o.push(item);
                    continue;
                }
                if(stack_o.size() != 0 && getRang(buff) <= getRang(stack_o.peek().type)){
                    if (!Maths()) { //Если функция вернет "false", то прекращаем работу
                        //
                        //надо это прекращать
                        //
                    }
                    item = new Leksema();
                    item.type = buff;
                    item.value = 0;
                    stack_o.push(item);
                    continue;
                }
            }
            if (buff == '('){
                item.type = buff;
                item.value = 0;
                stack_o.push(item);
                continue;
            }
            else if (buff == ')'){
                while (stack_o.peek().type != '('){
                    if (!Maths()) { //Если функция вернет "false", то прекращаем работу
                        //
                        //надо это прекращать
                        //
                    }
                    else continue;
                }
                stack_o.pop();
                continue;
            }

            if(buff == 's' || buff == 'c' || buff == 't' || buff == 'e'){
                i += 2;
                char buffTrigonam = expression.charAt(i);
                if (buffTrigonam == 'g')
                    item.type = buffTrigonam;
                else item.type = buff;
                item.value = 0;
                stack_o.push(item);
                continue;
            }
            if(buff == 'P') {
                item.type = '0';
                item.value = Math.PI;
                stack_n.push(item);
                continue;
            }
        }

        while (stack_o.size() != 0){
            if (!Maths()) { //Если функция вернет "false", то прекращаем работу
                //
                //надо это прекращать
                //
            }
        }
        return stack_n.pop().value;
    }

    /**
     * Математический метод, который производит расчеты
     * @return: true - если все вычислилось; false - если допущена ошибка в написании выражения
     */
    private boolean Maths(){
        item = new Leksema();
        double a, b, c;
        a = stack_n.pop().value; //Берется верхнее число из стека с числами
        switch (stack_o.peek().type) {  //Проверяется тип верхней операции из стека с операциями
            case '+': //Если тип верхней операции из стека с операциями сложение
                b = stack_n.pop().value;
                c = a + b;
                item.type = '0';
                item.value = c;
                stack_n.push(item); //Результат операции кладется обратно в стек с числами
                stack_o.pop();
                break;

            case '-':
                b = stack_n.pop().value;
                c = b - a;
                item.type = '0';
                item.value = c;
                stack_n.push(item);
                stack_o.pop();
                break;

            case '*':
                b = stack_n.pop().value;
                c = a * b;
                item.type = '0';
                item.value = c;
                stack_n.push(item);
                stack_o.pop();
                break;

            case '/':
                b = stack_n.pop().value;
                if (a == 0) {
                    return false;
                }
                else {
                    c = b / a;
                    item.type = '0';
                    item.value = c;
                    stack_n.push(item);
                    stack_o.pop();
                }
                break;

            case '^': //Если тип верхней операции из стека с операциями сложение
                b = stack_n.pop().value;
                c = Math.pow(b, a);
                item.type = '0';
                item.value = c;
                stack_n.push(item); //Результат операции кладется обратно в стек с числами
                stack_o.pop();
                break;

            case 's':
                c = Math.sin(a);
                item.type = '0';
                item.value = c;
                stack_n.push(item);
                stack_o.pop();
                break;

            case 'c':
                c = Math.cos(a);
                item.type = '0';
                item.value = c;
                stack_n.push(item);
                stack_o.pop();
                break;

            case 't':
                c = Math.tan(a);
                item.type = '0';
                item.value = c;
                stack_n.push(item);
                stack_o.pop();
                break;

            case 'g':
                c = Math.atan(a);
                item.type = '0';
                item.value = c;
                stack_n.push(item);
                stack_o.pop();
                break;

            case 'e':
                c = Math.exp(a);
                item.type = '0';
                item.value = c;
                stack_n.push(item);
                stack_o.pop();
                break;

            default:
                break;
        }
        return true;
    }

    /**
     * Метод для получение числа из строки
     * @param index - индекс начала числа в строке
     * @return - число из строки
     */
    private double stringGetNumb(int index){
        char[] numberChar = new char[5];
        for(int i = index; i < expression.length(); i++){
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/' || expression.charAt(i) == '(' || expression.charAt(i) == ')')
                break;
            numberChar[i-index] = expression.charAt(i);
        }
        double number = Double.parseDouble(new String(numberChar));
        return number;
    }

    /**
     * Метод для получение последнего индекса числа в строке
     * @param index - индекс начала числа в строке
     * @return - последний индекс числа в строке
     */
    private int stringGetLastIndNumb(int index){
        for(index = index; index < expression.length(); index++){
            if (expression.charAt(index) == '+' || expression.charAt(index) == '-' || expression.charAt(index) == '*' || expression.charAt(index) == '/' || expression.charAt(index) == '(' || expression.charAt(index) == ')')
                break;
        }
        return index;
    }

    /**
     * Метод для определения приоритетности операции
     * @param c - операция
     * @return - номер приоритетности операции
     */
    private int getRang(char c){
        if(c == '+' || c == '-')
            return 1;
        if (c == '*' || c == '/')
            return 2;
        if(c == '^')
            return 3;
        if(c == 's' || c == 'c' || c == 't' || c == 'e' || c == 'g')
            return 4;
        return 0;
    }



}

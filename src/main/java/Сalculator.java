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


    public double mainCalc(){
        double value = 0d;
        for(int i = 0; i < expression.length(); i++){
            item = new Leksema();
            if (expression.charAt(i) == '|') break;
            if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9'){
                value = stringGetNumb(i);
                item.type = '0';
                item.value = value;
                stack_n.push(item);
                i = stringGetLastIndNumb(i)-1;
            }
            else if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/') { //Если прочитана операция
                item.type = expression.charAt(i);
                item.value = 0;
                stack_o.push(item); //Операция кладется в стек с операциями
            }
        }

        boolean indicator = Maths();
        double answer;
        if (!indicator) { //Если функция вернет "false", то прекращаем работу
            //
            //надо это прекращать
            //
        }
        else{ //Если все хорошо, выдаем ответ
            return stack_n.pop().value;
        }
        return -1d;
    }

    /**
     * Математический метод, который производит расчеты
     * @return: true - если все вычислилось; false - если допущена ошибка в написании выражения
     */
    private boolean Maths(){
        item = new Leksema();
        double a, b, c;
        a = stack_n.pop().value; //Берется верхнее число из стека с числами
        char character = stack_o.pop().type;
        switch (character) {  //Проверяется тип верхней операции из стека с операциями
            case '+': //Если тип верхней операции из стека с операциями сложение
                b = stack_n.pop().value;
                c = a + b;
                item.type = '0';
                item.value = c;
                stack_n.push(item); //Результат операции кладется обратно в стек с числами
                break;

            case '-':
                b = stack_n.pop().value;
                c = b - a;
                item.type = '0';
                item.value = c;
                stack_n.push(item);
                break;

            case '*':
                b = stack_n.pop().value;
                c = a * b;
                item.type = '0';
                item.value = c;
                stack_n.push(item);
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
                }
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


}

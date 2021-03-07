/**
 * Класс, описывающая любое число или операцию
 */
public class Leksema{
    /**
     * Поле для определения типа
     * 0 для чисел, "+" для операции сложения и т.д.
     */
    public char type;

    /**
     * Значение (только для чисел). У операций значение всегда "0"
     */
    public double value;

    /**
     * Конструктор
     * @param type - тип
     * @param value - значение
     */
    public void Leksema(char type, double value){
        this.type = type;
        this.value = value;
    }
}

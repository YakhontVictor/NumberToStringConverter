package number_to_string_converter.converter;

import java.math.BigInteger;

/**
 *
 * @author Yakhont Victor
 */
public class Converter {

    private BigInteger THOUSAND = new BigInteger("1000");
    private String transformedNumber;
    private String tempNumber;
    private int currentPart;
    private int hundreds;
    private int tens;

    /**
     * Метод возвращающий число в текстовом виде
     *
     * @param number исходное число, которое требуется перевести в текст
     * @result число в текстовом виде
     */
    public String getConvertedNumber(BigInteger number) {
        try {
            function(0, number, " ", false);
            return transformedNumber;
        }
        catch (NullPointerException exc) {
            return "Неверный ввод";
        }
    }

    /**
     * Рекурсивный метод посимвольно переводящий число в текст
     *
     * @param scale обрабатываемый класс числа от 0 до 21 (0 - единицы, 1 -
     * тысячи, 2 - миллионы и т.д.)
     * @param number часть исходного числа или первоначальное число для
     * перевода в текст
     * @param transformedNumber часть исходного числа переведённая в текст
     * @param isNegative положительное или отрицательное число
     */
    public void function(int scale, BigInteger number, String transformedNumber, boolean isNegative) {
        this.transformedNumber = transformedNumber.replaceAll("[\\s]{2,}", " ");
        try {
            if (number.compareTo(BigInteger.ZERO) == -1) {
                function(scale, number.negate(), transformedNumber, true);
            } else if (number.compareTo(BigInteger.ZERO) == 1) {
                BigInteger nextNumber = number.divide(THOUSAND);
                this.currentPart = number.mod(THOUSAND).intValue();
                this.hundreds = this.currentPart / 100; //число сотен
                this.tens = this.currentPart % 100; //число десятков и единиц
                this.tempNumber = NumberDictionary.getNumberName(this.currentPart, this.hundreds, this.tens, scale)
                        + ScaleDictionary.getScaleName(scale, this.tens) + transformedNumber;
                function(scale + 1, nextNumber, this.tempNumber, isNegative);
            } else if (number.compareTo(BigInteger.ZERO) == 0 && scale == 0) {
                this.transformedNumber = "ноль";
            } else {
                if (isNegative == true) {
                    this.transformedNumber = "минус " + this.transformedNumber.trim();
                } else {
                    this.transformedNumber = this.transformedNumber.trim();
                }
            }
        } catch (NumberFormatException exc) {
            this.transformedNumber = ("Неверный ввод\n");
        }
    }
}

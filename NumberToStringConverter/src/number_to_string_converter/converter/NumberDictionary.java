/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_to_string_converter.converter;

/**
 *
 * @author Yakhont Victor
 */
public class NumberDictionary {

    /**
     * Метод возвращает число сотен в текстовом виде
     *
     * @param number число сотен
     * @result число сотен в текстовом виде
     */
    static private String getHundreds(int number) {
        switch (number) {
            case 1:
                return "сто ";
            case 2:
                return "двести ";
            case 3:
                return "триста ";
            case 4:
                return "четыреста ";
            case 5:
                return "пятьсот ";
            case 6:
                return "шестьсот ";
            case 7:
                return "семьсот ";
            case 8:
                return "восемьсот ";
            case 9:
                return "девятьсот ";
            default:
                return "";
        }
    }

    /**
     * Метод возвращает число от одного до девятнадцати текущего класса числа в
     * текстовом виде
     *
     * @param number число от одного до девятнадцати
     * @result число от одного до девятнадцати в текстовом виде
     */
    static private String getNumberFromOneToNineteen(int number) {
        switch ((int) Math.floor(number)) {
            case 0:
                return "";
            case 1:
                return "один ";
            case 2:
                return "два ";
            case 3:
                return "три ";
            case 4:
                return "четыре ";
            case 5:
                return "пять ";
            case 6:
                return "шесть ";
            case 7:
                return "семь ";
            case 8:
                return "восемь ";
            case 9:
                return "девять ";
            case 10:
                return "десять ";
            case 11:
                return "одиннадцать ";
            case 12:
                return "двенадцать ";
            case 13:
                return "тринадцать ";
            case 14:
                return "четырнадцать ";
            case 15:
                return "пятнадцать ";
            case 16:
                return "шестнадцать ";
            case 17:
                return "семнадцать ";
            case 18:
                return "восемнадцать ";
            case 19:
                return "девятнадцать ";
            default:
                return "";
        }
    }

    /**
     * Метод возвращает число от двадцати до девяносто девяти в текстовом виде
     *
     * @param number число от двадцати до девяносто девяти
     * @result число от двадцати до девяносто девяти в текстовом виде
     */
    static private String getNumberFromTwentyToNinetyNine(int number) {
        String tens, units;
        switch ((int) Math.floor(number / 10)) {
            case 2:
                tens = "двадцать";
                break;
            case 3:
                tens = "тридцать";
                break;
            case 4:
                tens = "сорок";
                break;
            case 5:
                tens = "пятьдесят";
                break;
            case 6:
                tens = "шестьдесят";
                break;
            case 7:
                tens = "семдесят";
                break;
            case 8:
                tens = "восемдесят";
                break;
            case 9:
                tens = "девяносто";
                break;
            default:
                tens = "";
        }
        switch (number % 10) {
            case 1:
                units = "один";
                break;
            case 2:
                units = "два";
                break;
            case 3:
                units = "три";
                break;
            case 4:
                units = "четыре";
                break;
            case 5:
                units = "пять";
                break;
            case 6:
                units = "шесть";
                break;
            case 7:
                units = "семь";
                break;
            case 8:
                units = "восемь";
                break;
            case 9:
                units = "девять";
                break;
            default:
                units = "";
        }
        return tens + " " + units + " ";
    }

    /**
     * Метод возвращает окончание имени класса тысяч в текстовом виде
     *
     * @param number число десятков класса тысяч
     * @result окончание имени класса тысяч в текстовом виде
     */
    static private String getNumberBiggerThanOneHundred(int hundreds, int tens) {
        String tempNumber = getHundreds(hundreds);
        if ((tens) < 20) {
            tempNumber += getNumberFromOneToNineteen(tens);
        } else {
            tempNumber += getNumberFromTwentyToNinetyNine(tens);
        }
        return tempNumber;
    }

    /**
     * Метод возвращает число текущего класса в текстовом виде
     *
     * @param currentPart обрабатываемый класс числа от 0 до 21 (0 -
     * единицы, 1 - тысячи, 2 - миллионы и т.д.)
     * @param hundreds число сотен текущего класса числа
     * @param tens число десятков и единиц текущего класса числа
     * @param scale обрабатываемый класс числа от 0 до 21 (0 - единицы, 1 -
     * тысячи, 2 - миллионы и т.д.)
     *
     * @result число сотен текущего класса числа
     */
    static public String getNumberName(int currentPart, int hundreds, int tens, int scale) {
        String temp = "";
        if (currentPart > 99) {
            temp = getNumberBiggerThanOneHundred(hundreds, tens);
        } else if (Math.floor(currentPart) < 100 && Math.floor(currentPart) > 19) {
            temp = getNumberFromTwentyToNinetyNine(tens);
        } else {
            temp = getNumberFromOneToNineteen(tens);
        }
        if (scale == 1) {
            if (tens == 1) {
                temp = temp.replace("один", "одна");
            } else if (tens == 2) {
                temp = temp.replace("два", "две");
            }
        }
        return temp;
    }
}

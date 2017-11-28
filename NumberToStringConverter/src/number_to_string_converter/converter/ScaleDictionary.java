/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_to_string_converter.converter;

/**
 *
 * @author Head
 */
public class ScaleDictionary {

    /**
     * Метод возвращает имя класса числа в текстовом виде
     *
     * @param number класс числа
     * @result имя класса числа в текстовом виде
     */
    static private String getScale(int number) {
        switch (number) {
            case 1:
                return "тысяч";
            case 2:
                return "миллион";
            case 3:
                return "миллиард";
            case 4:
                return "триллион";
            case 5:
                return "квадриллион";
            case 6:
                return "квинтиллион";
            case 7:
                return "секстиллион";
            case 8:
                return "септиллион";
            case 9:
                return "октиллион";
            case 10:
                return "нониллион";
            case 11:
                return "дециллион";
            case 12:
                return "андециллион";
            case 13:
                return "дуодециллион";
            case 14:
                return "тредециллион";
            case 15:
                return "кваттордециллион";
            case 16:
                return "квиндециллион";
            case 17:
                return "сексдециллион";
            case 18:
                return "септемдециллион";
            case 19:
                return "октодециллион";
            case 20:
                return "новемдециллион";
            case 21:
                return "вигинтиллион";
            default:
                return "";
        }
    }

    /**
     * Метод возвращает окончание имени класса числа в текстовом виде
     *
     * @param number класс числа
     * @result окончание имени класса числа в текстовом виде
     */
    static private String getEnding(int number) {
        if (number > 20) {
            int units = number % 10;
            if (units == 0 || units > 4) {
                return "ов ";
            } else if ((units > 1 && units < 5)) {
                return "а ";
            } else {
                return " ";
            }
        } else {
            if (number == 0 || number > 4) {
                return "ов ";
            } else if ((number > 1 && number < 5)) {
                return "а ";
            } else {
                return " ";
            }
        }
    }

    /**
     * Метод возвращает окончание имени класса тысяч в текстовом виде
     *
     * @param number число десятков класса тысяч
     * @result окончание имени класса тысяч в текстовом виде
     */
    static private String getThousandEnding(int number) {
        if (number > 19) {
            int units = number % 10;
            if (units == 0 || units > 4) {
                return " ";
            } else if ((units > 1 && units < 5)) {
                return "и ";
            } else if ((units == 1)) {
                return "а ";
            } else {
                return " ";
            }
        } else {
            if (number == 0 || number > 4) {
                return " ";
            } else if ((number > 1 && number < 5)) {
                return "и ";
            } else if ((number == 1)) {
                return "а ";
            } else {
                return " ";
            }
        }
    }

    /**
     * Метод возвращает имя класса числа в текстовом виде
     *
     * @param scale обрабатываемый класс числа от 0 до 21 (0 - единицы, 1 -
     * тысячи, 2 - миллионы и т.д.)
     * @param tens число десятков и единиц текущего класса числа
     * @result имя класса числа в текстовом виде
     */
    static public String getScaleName(int scale, int tens) {
        if (scale > 1) {
            return getScale(scale) + getEnding(tens);
        } else if (scale == 1) {
            if (tens % 10 == 1 && tens != 11) {
                return getScale(scale) + getThousandEnding(tens);
            } else if (tens % 10 == 2 && tens != 12) {
                return getScale(scale) + getThousandEnding(tens);
            } else {
                return getScale(scale) + getThousandEnding(tens);
            }
        } else {
            return getScale(scale);
        }
    }
}

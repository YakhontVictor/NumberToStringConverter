package number_to_string_converter;

import number_to_string_converter.converter.Converter;
import java.math.BigInteger;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Yakhont Victor
 */

public class MainClass {

    static final Logger LOG = LoggerFactory.getLogger(MainClass.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Converter converter = new Converter();
        BigInteger number;
        while (true) {
            try {
                LOG.trace("Исходное число: \n");
                number = new BigInteger(scan.nextLine());
                LOG.info(converter.getConvertedNumber(number)); // запуск рекурсии
            } catch (NumberFormatException exc) {
                LOG.warn("Неверный ввод\n");
            }
        }
    }
}

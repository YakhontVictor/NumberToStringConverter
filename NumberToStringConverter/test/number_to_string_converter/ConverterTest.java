/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package number_to_string_converter;

import number_to_string_converter.handler.ExcelFileHandler;
import number_to_string_converter.converter.Converter;
import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author Yakhont Victor
 */
public class ConverterTest {
    
    private static final Logger LOG = LoggerFactory.getLogger(ConverterTest.class);   
    private static final String INCORRECT_INPUT_STRING = "asdasd";
    private static final String WRONG_INPUT = "Неверный ввод";
    public ConverterTest() {
    }
    
    /**
     * Test of ConvertedNumber, of class Converter.
     * @throws java.io.IOException
     */
    @Test
    public void testConvertedNumber() throws IOException {
        Converter instance = new Converter();
        ExcelFileHandler excelFileHandler = new ExcelFileHandler();
        excelFileHandler.read("testData/CorrectData.xls");
        Map<BigInteger, String> map = excelFileHandler.getMap();
        String result;
        for (BigInteger value : map.keySet()) {
            assertEquals("Ошибка в числе: " + value, String.valueOf(map.get(value)), result = instance.getConvertedNumber(value));                        
            LOG.info("Введено значение: " + value + ", получено значение: " + result);
        }
    }     
    /**
     * Test of ConvertedNumber, of class Converter.
     */    
    @Test
    public void testInputNull() {
        Converter instance = new Converter();       
        String result;        
        assertEquals(WRONG_INPUT, result = instance.getConvertedNumber(null));
        LOG.info("Введено значение: null, получено значение: " + result);
    }     
    
    /**
     * Test of ConvertedNumber, of class Converter.
     */    
    @Test
    public void testIncorrectInputString() {        
        Converter instance = new Converter();                  
        try {
            instance.getConvertedNumber(new BigInteger(INCORRECT_INPUT_STRING));
        }
        catch (NumberFormatException exc){        
         LOG.info("Введено значение: " + INCORRECT_INPUT_STRING + ", получено исключение: " + exc.getClass().getName());   
        }        
    }     
}

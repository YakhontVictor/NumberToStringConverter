/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_to_string_converter.handler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author Head
 */
public class ExcelFileHandler {

    private Map<BigInteger, String> map = new LinkedHashMap<>();

    public ExcelFileHandler() {

    }

    public void read(String path) throws IOException {
        InputStream in = new FileInputStream(path);
        HSSFWorkbook wb = new HSSFWorkbook(in);

        BigInteger inNumber = BigInteger.ZERO;
        String inString = null;

        Sheet sheet = wb.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                int cellType = cell.getCellType();

                switch (cellType) {
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print((inNumber = BigInteger.valueOf((long) cell.getNumericCellValue())) + " = ");
                        break;

                    case Cell.CELL_TYPE_STRING:
                        System.out.print((inString = cell.getStringCellValue()));
                        break;

                    default:
                        break;
                }
            }
            map.put(inNumber, inString);
        }
    }

    public Map<BigInteger, String> getMap() {
        return map;
    }
}

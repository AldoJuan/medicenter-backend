package com.lvl.medicenter.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.function.BiConsumer;


public class ExcelUtil {

    public static <T> byte[] generar(String nombreHoja, String[] encabezados, List<T> datos, BiConsumer<Row, T> llenarFila) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet(nombreHoja);

            Row filaEncabezado = sheet.createRow(0);
            for (int i = 0; i < encabezados.length; i++) {
                filaEncabezado.createCell(i).setCellValue(encabezados[i]);
            }

            int indiceFila = 1;
            for (T dato : datos) {
                Row fila = sheet.createRow(indiceFila++);
                llenarFila.accept(fila, dato);
            }

            for (int i = 0; i < encabezados.length; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(out);
            return out.toByteArray();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}

package com.unicauca.tramites.util.reportes;
import com.unicauca.tramites.dto.ListaTramiteResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TramiteExporterExcel {

    private XSSFWorkbook libro;
    private XSSFSheet hoja;

    private List<ListaTramiteResponse> tramites;
    public TramiteExporterExcel(List<ListaTramiteResponse>tramites){

        this.tramites = tramites;
        libro = new XSSFWorkbook();
        hoja = libro.createSheet("Tramites");

    }
    private void escribirCabeceraDeTabla(){
        Row fila = hoja.createRow(0);
        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setBold(true);
        fuente.setFontHeight(16);
        estilo.setFont(fuente);

        Cell celda = fila.createCell(0);
        celda.setCellValue("Numero VU");
        celda.setCellStyle(estilo);

        celda = fila.createCell(1);
        celda.setCellValue("Asunto");
        celda.setCellStyle(estilo);

        celda = fila.createCell(2);
        celda.setCellValue("Fecha de recepción");
        celda.setCellStyle(estilo);

        celda = fila.createCell(3);
        celda.setCellValue("Fecha de vencimiento");
        celda.setCellStyle(estilo);

        celda = fila.createCell(4);
        celda.setCellValue("Descripcion");
        celda.setCellStyle(estilo);
    }

    private void escribirDatosTabla(){
        int numeroFilas = 1;
        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setFontHeight(14);
        estilo.setFont(fuente);

        for(ListaTramiteResponse tramite: tramites){
            Row fila = hoja.createRow(numeroFilas ++);
            Cell celda = fila.createCell(0);
            celda.setCellValue(tramite.getNumeroVU());
            hoja.autoSizeColumn(0);
            celda.setCellStyle(estilo);

            celda = fila.createCell(1);
            celda.setCellValue(tramite.getAsunto());
            hoja.autoSizeColumn(1);
            celda.setCellStyle(estilo);

            celda = fila.createCell(2);
            celda.setCellValue(tramite.getFechaRecepcion());
            hoja.autoSizeColumn(2);
            celda.setCellStyle(estilo);

            celda = fila.createCell(3);
            celda.setCellValue(tramite.getFechaVencimiento());
            hoja.autoSizeColumn(3);
            celda.setCellStyle(estilo);

            celda = fila.createCell(4);
            celda.setCellValue(tramite.getDescripcionTipoTramite());
            hoja.autoSizeColumn(4);
            celda.setCellStyle(estilo);

        }

    }
    public void exportar(HttpServletResponse response ) throws IOException{
        escribirCabeceraDeTabla();
        escribirDatosTabla();

        ServletOutputStream outputStream = response.getOutputStream();
        libro.write(outputStream);
        libro.close();
        outputStream.close();

    }


}

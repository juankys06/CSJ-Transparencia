package com.co.csj.administracion;

import java.awt.image.IndexColorModel;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.co.csj.registro.consultas;
import com.co.csj.registro.modeloBasico;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;


public enum ExporterUtil {
    INSTANCE;
    

    public Workbook exportReporteDespachosSinFuncionarios(JSONObject reporte) {
    	HSSFWorkbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("Despachos Sin Funcionarios");
        
        CellStyle styleC = wb.createCellStyle();
        Font font = wb.createFont();
        font.setBoldweight((short)700);
        styleC.setFont(font);
        
        CellStyle styleCc = wb.createCellStyle();
        styleCc.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        styleCc.setBorderTop(HSSFCellStyle.BORDER_THIN);
        styleCc.setBorderRight(HSSFCellStyle.BORDER_THIN);
        styleCc.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        
        this.addHeaders((Object)sheet,reporte,styleC);
        this.generateTableRecords((Object)sheet, reporte,styleCc);
        for (int columnNumber = 0; columnNumber <= 6; ++columnNumber) {
            sheet.autoSizeColumn(columnNumber);
        }
        
        return wb;
    }

    private void addHeaders(Object element,JSONObject reporte, CellStyle sty) {
    	if (element instanceof Sheet) {
    		
    		String dep = "";
			String mun = "";
			String ent = "";
			String esp = "";
			
			List<modeloBasico> depa = consultas.getDepartamentos();
			List<modeloBasico> enti = consultas.getEntidad();
			List<modeloBasico> espe = consultas.getEspecialidad();
			
			if(!reporte.getString("departamento").isEmpty()){
				for(modeloBasico d : depa){
					if(d.getCodigo().equals(reporte.getString("departamento")))
						dep = d.getNombre();
				}
			}
			if(!reporte.getString("municipio").isEmpty()){
				List<modeloBasico> muni = consultas.getMunicipiosR(reporte.getString("departamento"));
				for(modeloBasico d : muni){
					if(d.getCodigo().equals(reporte.getString("municipio")))
						mun = d.getNombre();
				}
			}
			if(!reporte.getString("entidad").isEmpty()){
				for(modeloBasico d : enti){
					if(d.getCodigo().equals(reporte.getString("entidad")))
						ent = d.getNombre();
				}
			}
			if(!reporte.getString("especialidad").isEmpty()){
				for(modeloBasico d : espe){
					if(d.getCodigo().equals(reporte.getString("especialidad")))
						esp = d.getNombre();
				}
			}
    		
            Row headerRow = ((Sheet)element).createRow(0);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Filtros Utilizados"));
            ((Sheet) element).addMergedRegion(new CellRangeAddress(0, 0, 0, 6));
            headerRow.getCell(0).setCellStyle(sty);
            
            headerRow = ((Sheet)element).createRow(1);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Departamento: "+dep));
            ((Sheet) element).addMergedRegion(new CellRangeAddress(1, 1, 0, 6));
            
            headerRow = ((Sheet)element).createRow(2);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Municipio: "+mun));
            ((Sheet) element).addMergedRegion(new CellRangeAddress(2, 2, 0, 6));
            
            headerRow = ((Sheet)element).createRow(3);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Entidad: "+ent));
            ((Sheet) element).addMergedRegion(new CellRangeAddress(3, 3, 0, 6));
            
            headerRow = ((Sheet)element).createRow(4);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Especialidad: "+esp));
            ((Sheet) element).addMergedRegion(new CellRangeAddress(4, 4, 0, 6));
            
            headerRow = ((Sheet)element).createRow(5);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Año de Vigencia: "+reporte.getString("ano")));
            ((Sheet) element).addMergedRegion(new CellRangeAddress(5, 5, 0, 6));
            
        }
    }

    private void generateTableRecords(Object element, JSONObject reporte, CellStyle sty) {
    	if (element instanceof Sheet) {
        	int i = 0,total=0;
        	
            Sheet sheet = (Sheet)element;
            
            Row headerRow = ((Sheet)element).createRow(7);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Codigo Despacho"));
            headerRow.createCell(1).setCellValue((RichTextString)new HSSFRichTextString("Nombre Despacho"));
            headerRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString("Departamento"));
            headerRow.createCell(3).setCellValue((RichTextString)new HSSFRichTextString("Municipio"));
            headerRow.createCell(4).setCellValue((RichTextString)new HSSFRichTextString("Entidad"));
            headerRow.createCell(5).setCellValue((RichTextString)new HSSFRichTextString("Especialidad"));
            headerRow.createCell(6).setCellValue((RichTextString)new HSSFRichTextString("Distrito"));
            headerRow.getCell(0).setCellStyle(sty);
            headerRow.getCell(1).setCellStyle(sty);
            headerRow.getCell(2).setCellStyle(sty);
            headerRow.getCell(3).setCellStyle(sty);
            headerRow.getCell(4).setCellStyle(sty);
            headerRow.getCell(5).setCellStyle(sty);
            headerRow.getCell(6).setCellStyle(sty);
            
            JSONArray data = reporte.getJSONArray("data");
            
            int cantidad = data.length();
            
            for (i = 0; i < cantidad; ++i) {
            	JSONObject datos = data.getJSONObject(i);
            	
                Row contentRow = sheet.createRow(i + 8);
                contentRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(datos.getString("codigo"))));
                contentRow.createCell(1).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(datos.getString("nombre"))));
                contentRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(datos.getString("departamento"))));
                contentRow.createCell(3).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(datos.getString("municipio"))));
                contentRow.createCell(4).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(datos.getString("entidad"))));
                contentRow.createCell(5).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(datos.getString("especialidad"))));
                contentRow.createCell(6).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(datos.getString("distrito"))));
                contentRow.getCell(0).setCellStyle(sty);
                contentRow.getCell(1).setCellStyle(sty);
                contentRow.getCell(2).setCellStyle(sty);
                contentRow.getCell(3).setCellStyle(sty);
                contentRow.getCell(4).setCellStyle(sty);
                contentRow.getCell(5).setCellStyle(sty);
                contentRow.getCell(6).setCellStyle(sty);
            }
        }
    }

    public Workbook exportReportePublicaciones(JSONObject reporte) {
    	HSSFWorkbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("Publicaciones Activas");
        
        CellStyle styleC = wb.createCellStyle();
        Font font = wb.createFont();
        font.setBoldweight((short)700);
        styleC.setFont(font);
        
        CellStyle styleCc = wb.createCellStyle();
        styleCc.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        styleCc.setBorderTop(HSSFCellStyle.BORDER_THIN);
        styleCc.setBorderRight(HSSFCellStyle.BORDER_THIN);
        styleCc.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        
        this.addHeadersPublicaciones((Object)sheet,reporte,styleC);
        this.generateTableRecordsPublicaciones((Object)sheet, reporte,styleCc);
        for (int columnNumber = 0; columnNumber <= 9; ++columnNumber) {
            sheet.autoSizeColumn(columnNumber);
        }
        
        return wb;
    }

    private void addHeadersPublicaciones(Object element,JSONObject reporte, CellStyle sty) {
    	if (element instanceof Sheet) {
    		
    		String dep = "";
			String mun = "";
			String ent = "";
			String esp = "";
			
			List<modeloBasico> depa = consultas.getDepartamentos();
			List<modeloBasico> enti = consultas.getEntidad();
			List<modeloBasico> espe = consultas.getEspecialidad();
			
			if(!reporte.getString("departamento").isEmpty()){
				for(modeloBasico d : depa){
					if(d.getCodigo().equals(reporte.getString("departamento")))
						dep = d.getNombre();
				}
			}
			if(!reporte.getString("municipio").isEmpty()){
				List<modeloBasico> muni = consultas.getMunicipiosR(reporte.getString("departamento"));
				for(modeloBasico d : muni){
					if(d.getCodigo().equals(reporte.getString("municipio")))
						mun = d.getNombre();
				}
			}
			if(!reporte.getString("entidad").isEmpty()){
				for(modeloBasico d : enti){
					if(d.getCodigo().equals(reporte.getString("entidad")))
						ent = d.getNombre();
				}
			}
			if(!reporte.getString("especialidad").isEmpty()){
				for(modeloBasico d : espe){
					if(d.getCodigo().equals(reporte.getString("especialidad")))
						esp = d.getNombre();
				}
			}
    		
            Row headerRow = ((Sheet)element).createRow(0);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Filtros Utilizados"));
            ((Sheet) element).addMergedRegion(new CellRangeAddress(0, 0, 0, 9));
            headerRow.getCell(0).setCellStyle(sty);
            
            headerRow = ((Sheet)element).createRow(1);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Departamento: "+dep));
            ((Sheet) element).addMergedRegion(new CellRangeAddress(1, 1, 0, 9));
            
            headerRow = ((Sheet)element).createRow(2);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Municipio: "+mun));
            ((Sheet) element).addMergedRegion(new CellRangeAddress(2, 2, 0, 9));
            
            headerRow = ((Sheet)element).createRow(3);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Entidad: "+ent));
            ((Sheet) element).addMergedRegion(new CellRangeAddress(3, 3, 0, 9));
            
            headerRow = ((Sheet)element).createRow(4);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Especialidad: "+esp));
            ((Sheet) element).addMergedRegion(new CellRangeAddress(4, 4, 0, 9));
            
            headerRow = ((Sheet)element).createRow(5);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Año de Vigencia: "+reporte.getString("ano")));
            ((Sheet) element).addMergedRegion(new CellRangeAddress(5, 5, 0, 9));
            
        }
    }

    private void generateTableRecordsPublicaciones(Object element, JSONObject reporte, CellStyle sty) {
    	if (element instanceof Sheet) {
        	int i = 0,total=0;
        	
            Sheet sheet = (Sheet)element;
            
            Row headerRow = ((Sheet)element).createRow(7);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Cedula Funcionario"));
            headerRow.createCell(1).setCellValue((RichTextString)new HSSFRichTextString("Nombre Funcionario"));
            headerRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString("Cargo Funcionario"));
            headerRow.createCell(3).setCellValue((RichTextString)new HSSFRichTextString("Codigo Despacho"));
            headerRow.createCell(4).setCellValue((RichTextString)new HSSFRichTextString("Nombre Despacho"));
            headerRow.createCell(5).setCellValue((RichTextString)new HSSFRichTextString("Departamento"));
            headerRow.createCell(6).setCellValue((RichTextString)new HSSFRichTextString("Municipio"));
            headerRow.createCell(7).setCellValue((RichTextString)new HSSFRichTextString("Entidad"));
            headerRow.createCell(8).setCellValue((RichTextString)new HSSFRichTextString("Especialidad"));
            headerRow.createCell(9).setCellValue((RichTextString)new HSSFRichTextString("Distrito"));
            headerRow.getCell(0).setCellStyle(sty);
            headerRow.getCell(1).setCellStyle(sty);
            headerRow.getCell(2).setCellStyle(sty);
            headerRow.getCell(3).setCellStyle(sty);
            headerRow.getCell(4).setCellStyle(sty);
            headerRow.getCell(5).setCellStyle(sty);
            headerRow.getCell(6).setCellStyle(sty);
            headerRow.getCell(7).setCellStyle(sty);
            headerRow.getCell(8).setCellStyle(sty);
            headerRow.getCell(9).setCellStyle(sty);
            
            JSONArray data = reporte.getJSONArray("data");
            
            int cantidad = data.length();
            
            for (i = 0; i < cantidad; ++i) {
            	JSONObject datos = data.getJSONObject(i);
            	
                Row contentRow = sheet.createRow(i + 8);
                contentRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(datos.getString("cedula"))));
                contentRow.createCell(1).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(datos.getString("nombre"))));
                contentRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(datos.getString("cargo"))));
                contentRow.createCell(3).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(datos.getString("codigo_despacho"))));
                contentRow.createCell(4).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(datos.getString("nombre_despacho"))));
                contentRow.createCell(5).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(datos.getString("departamento"))));
                contentRow.createCell(6).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(datos.getString("municipio"))));
                contentRow.createCell(7).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(datos.getString("entidad"))));
                contentRow.createCell(8).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(datos.getString("especialidad"))));
                contentRow.createCell(9).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(datos.getString("distrito"))));
                contentRow.getCell(0).setCellStyle(sty);
                contentRow.getCell(1).setCellStyle(sty);
                contentRow.getCell(2).setCellStyle(sty);
                contentRow.getCell(3).setCellStyle(sty);
                contentRow.getCell(4).setCellStyle(sty);
                contentRow.getCell(5).setCellStyle(sty);
                contentRow.getCell(6).setCellStyle(sty);
                contentRow.getCell(7).setCellStyle(sty);
                contentRow.getCell(8).setCellStyle(sty);
                contentRow.getCell(9).setCellStyle(sty);
            }
        }
    }

}
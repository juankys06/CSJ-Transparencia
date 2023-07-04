package com.co.csj.registro;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;

import com.co.csj.service.model.usuario_data;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class UtilidadesPdf {
	
	public static SimpleDateFormat formatoS = new SimpleDateFormat("dd/MM/yyyy");
	public static SimpleDateFormat formatoE = new SimpleDateFormat("yyy-MM-dd");

	public static boolean generarQR(String rutaQr,String rutaHuja, String servidor){
		int alto = 300;
		BitMatrix matrix = new BitMatrix(alto, alto);
        Writer escritor = new QRCodeWriter();
        String url = servidor+"/ley-de-transparencia?p_p_id=ley_transparencia_WAR_ley_transparenciaportlet&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_cacheability=cacheLevelPage&p_p_col_id=column-1&p_p_col_count=1&pagina=verificarArchivo&ruta="+rutaHuja;
        try {
			matrix = escritor.encode(url, BarcodeFormat.QR_CODE, alto, alto);
		} catch (WriterException e) {}
        
        BufferedImage imagen = new BufferedImage(alto, alto, BufferedImage.TYPE_INT_RGB);
        
        for(int y = 0; y < alto; y++) {
            for(int x = 0; x < alto; x++) {
                int grayValue = (matrix.get(x, y) ? 0 : 1) & 0xff;
                imagen.setRGB(x, y, (grayValue == 0 ? 0 : 0xFFFFFF));
            }
        }
        File qrFile = new File(rutaQr);
        try {
			ImageIO.write(imagen, "png", qrFile);
			return true;
		} catch (IOException e) {
			return false;
		}
		
	}
	
	public static void eliminarQr(String rutaQr){
		File qr = new File(rutaQr);
		qr.delete();
	}

	public static Table getTablaDatosPersonales(usuario_data usuario){
		JSONObject datos_personales = JSONFactoryUtil.createJSONObject();
		try {
			datos_personales = JSONFactoryUtil.createJSONObject(usuario.getDatos_personales());
		} catch (JSONException e) {}
		
		Style encabezado = new Style().setFontSize(12f).setBold().setBorder(Border.NO_BORDER);
		Style titulos = new Style().setFontSize(8f).setBold().setTextAlignment(TextAlignment.LEFT);
		Style contenidos = new Style().setFontSize(8f).setTextAlignment(TextAlignment.LEFT);
		
		float [] cellWidth = {16.6f,16.6f,16.6f,16.6f,16.6f,16.6f};
		Table tabla = new Table(UnitValue.createPercentArray(cellWidth)).useAllAvailableWidth();
		
		Cell cell = new Cell(1, 6).add(new Paragraph("DATOS PERSONALES")).addStyle(encabezado);
		tabla.addCell(cell);
		
		cell = new Cell(1,3).add(new Paragraph("APELLIDOS\n").addStyle(titulos))
				.add(new Paragraph(usuario.getApellidos()).addStyle(contenidos));
		tabla.addCell(cell);
//		cell = new Cell(1,2).add(new Paragraph("SEGUNDO APELLIDO ( O DE CASADA )\n").addStyle(titulos))
//				.add(new Paragraph(datos_personales.getString("segundoApellido")).addStyle(contenidos));
//		tabla.addCell(cell);
		cell = new Cell(1,3).add(new Paragraph("NOMBRES\n").addStyle(titulos))
				.add(new Paragraph(usuario.getNombres()).addStyle(contenidos));
		tabla.addCell(cell);
		
		String identificacion = consultas.getTipoDocumentoDiminutivo(usuario.getTipoDocumento())+": "+usuario.getNumeroDocumento();
		cell = new Cell(1,2).add(new Paragraph("DOCUMENTO DE IDENTIFICACIÓN\n").addStyle(titulos))
				.add(new Paragraph(identificacion).addStyle(contenidos));
		tabla.addCell(cell);
		cell = new Cell(1,1).add(new Paragraph("SEXO\n").addStyle(titulos))
				.add(new Paragraph(datos_personales.getString("sexo")).addStyle(contenidos));
		tabla.addCell(cell);
		if(datos_personales.getString("nacionalidad").equals("COLOMBIANO")){
			cell = new Cell(1,3).add(new Paragraph("NACIONALIDAD\n").addStyle(titulos))
					.add(new Paragraph(datos_personales.getString("nacionalidad")).addStyle(contenidos));
			tabla.addCell(cell);
		}else{
			cell = new Cell(1,1).add(new Paragraph("NACIONALIDAD\n").addStyle(titulos))
					.add(new Paragraph(datos_personales.getString("nacionalidad")).addStyle(contenidos));
			tabla.addCell(cell);
			cell = new Cell(1,2).add(new Paragraph("PAIS\n").addStyle(titulos))
					.add(new Paragraph(datos_personales.getString("pais")).addStyle(contenidos));
			tabla.addCell(cell);
		}
		
		
		Table _tabla = new Table(UnitValue.createPercentArray(cellWidth)).useAllAvailableWidth();
		
		if(datos_personales.getString("sexo").equals("MASCULINO")){
			String tipo = "";
			
			if(datos_personales.getString("tipoLibretaMilitar").equals("primeraclase"))
				tipo = "PRIMERA CLASE";
			if(datos_personales.getString("tipoLibretaMilitar").equals("segundaclase"))
				tipo = "SEGUNDA CLASE";
			
			cell = new Cell(1, 2).add(new Paragraph(tipo))
				.setBorder(Border.NO_BORDER)
				.addStyle(contenidos);
			_tabla.addCell(cell);
			cell = new Cell(1, 2).add(new Paragraph("NÚMERO: "+datos_personales.getString("numeroLibretaMilitar")))
					.setBorder(Border.NO_BORDER)
					.addStyle(contenidos);
			_tabla.addCell(cell);
			cell = new Cell(1, 2).add(new Paragraph("D.M: "+datos_personales.getString("dmLibretaMilitar")))
					.setBorder(Border.NO_BORDER)
					.addStyle(contenidos);
			_tabla.addCell(cell);
			
			cell = new Cell(1,6).add(new Paragraph("LIBRETA MILITAR\n").addStyle(titulos))
					.add(_tabla);
			tabla.addCell(cell);
		}
		
		float [] cellWidth1 = {40f,60f};
		_tabla = new Table(UnitValue.createPercentArray(cellWidth1)).useAllAvailableWidth();
		cell = new Cell().add(new Paragraph("FECHA:"))
				.setBorder(Border.NO_BORDER)
				.addStyle(contenidos);
		_tabla.addCell(cell);
		String fecha = "";
		if(!datos_personales.getString("fechaNacimiento").isEmpty()){
			try {
				fecha = formatoS.format(formatoE.parse(datos_personales.getString("fechaNacimiento")));
			} catch (ParseException e) {}
		}
		cell = new Cell().add(new Paragraph(fecha))
				.setBorder(Border.NO_BORDER)
				.addStyle(contenidos);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("PAÍS:"))
				.setBorder(Border.NO_BORDER)
				.addStyle(contenidos);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(datos_personales.getString("paisNacimiento")))
				.setBorder(Border.NO_BORDER)
				.addStyle(contenidos);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("DEPARTAMENTO:"))
				.setBorder(Border.NO_BORDER)
				.addStyle(contenidos);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(datos_personales.getString("departamentoNacimiento")))
				.setBorder(Border.NO_BORDER)
				.addStyle(contenidos);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("MUNICIPIO:"))
				.setBorder(Border.NO_BORDER)
				.addStyle(contenidos);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(datos_personales.getString("municipioNacimiento")))
				.setBorder(Border.NO_BORDER)
				.addStyle(contenidos);
		_tabla.addCell(cell);
		
		cell = new Cell(1,3).add(new Paragraph("FECHA Y LUGAR DE NACIMIENTO\n").addStyle(titulos))
				.add(_tabla);
		tabla.addCell(cell);
		
		float [] cellWidth2 = {20f,30f,20f,30f};
		_tabla = new Table(UnitValue.createPercentArray(cellWidth2)).useAllAvailableWidth();
		cell = new Cell(1,4).add(new Paragraph(datos_personales.getString("direccionCorrespondencia")))
				.setBorder(Border.NO_BORDER)
				.addStyle(contenidos);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("PAÍS:"))
				.setBorder(Border.NO_BORDER)
				.addStyle(contenidos);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(datos_personales.getString("paisCorrespondencia")))
				.setBorder(Border.NO_BORDER)
				.addStyle(contenidos);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("DEPARTAMENTO:"))
				.setBorder(Border.NO_BORDER)
				.addStyle(contenidos);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(datos_personales.getString("departamentoCorrespondencia")))
				.setBorder(Border.NO_BORDER)
				.addStyle(contenidos);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("MUNICIPIO:"))
				.setBorder(Border.NO_BORDER)
				.addStyle(contenidos);
		_tabla.addCell(cell);
		cell = new Cell(1,3).add(new Paragraph(datos_personales.getString("municipioCorrespondencia")))
				.setBorder(Border.NO_BORDER)
				.addStyle(contenidos);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("TELÉFONO:"))
				.setBorder(Border.NO_BORDER)
				.addStyle(contenidos);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(datos_personales.getString("telefonoCorrespondencia")))
				.setBorder(Border.NO_BORDER)
				.addStyle(contenidos);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("EMAIL:"))
				.setBorder(Border.NO_BORDER)
				.addStyle(contenidos);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(datos_personales.getString("emailCorrespondencia")))
				.setBorder(Border.NO_BORDER)
				.addStyle(contenidos);
		_tabla.addCell(cell);
		
		cell = new Cell(1,3).add(new Paragraph("DIRECCIÓN DE CORRESPONDENCIA\n").addStyle(titulos))
				.add(_tabla);
		tabla.addCell(cell);
		
		
		return tabla;
	}

	public static Table getTablaFormacionAcademica(usuario_data usuario){
		JSONObject formacion_academica = JSONFactoryUtil.createJSONObject();
		try {
			formacion_academica = JSONFactoryUtil.createJSONObject(usuario.getFormacion_academica());
		} catch (JSONException e) {}

		Style encabezado = new Style().setFontSize(12f).setBold().setBorder(Border.NO_BORDER);
		Style titulos = new Style().setFontSize(10f).setBold().setTextAlignment(TextAlignment.LEFT);
		Style subTitulos = new Style().setFontSize(8f).setBold().setTextAlignment(TextAlignment.LEFT);
		Style contenidos = new Style().setFontSize(8f).setTextAlignment(TextAlignment.LEFT);
		
		Table tabla = new Table(1).useAllAvailableWidth();
		
		Cell cell = new Cell().add(new Paragraph("FORMACIÓN ACADÉMICA")).addStyle(encabezado);
		tabla.addCell(cell);

		float [] cellWidth = {10f,15f,30f,15f,10f};
		Table _tabla = new Table(UnitValue.createPercentArray(cellWidth)).useAllAvailableWidth();
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("EDUCACIÓN BÁSICA").addStyle(subTitulos));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("TÍTULO OBTENIDO").addStyle(subTitulos));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("FECHA DE GRADO").addStyle(subTitulos));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(formacion_academica.getString("educacionMedia")).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(formacion_academica.getString("tituloEducacionMedia")).addStyle(contenidos));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(formacion_academica.getString("mesEducacionMedia")+"/"+formacion_academica.getString("anhioEducacionMedia")).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		
		
		cell = new Cell().add(new Paragraph("EDUCACIÓN BÁSICA Y MEDIA\n").addStyle(titulos))
				.add(new Paragraph("ÚLTIMO GRADO APROBADO ( LOS GRADOS DE 1o. A 6o. DE BACHILLERATO EQUIVALEN A LOS GRADOS 6o. A 11o. DE EDUCACIÓN BÁSICA SECUNDARIA Y MEDIA )\n\n").setFontSize(6f))
				.add(_tabla)
				.add(new Paragraph("\n"));
		tabla.addCell(cell);
		
		float [] cellWidth1 = {2.5f,10f,10f,10f,45f,10f,10f,2.5f};
		_tabla = new Table(UnitValue.createPercentArray(cellWidth1)).useAllAvailableWidth();
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
		cell = new Cell().add(new Paragraph("MODALIDAD ACADÉMICA").addStyle(subTitulos).setFontSize(7f).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
		cell = new Cell().add(new Paragraph("No.SEMESTRES APROBADOS").addStyle(subTitulos).setFontSize(7f).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
		cell = new Cell().add(new Paragraph("GRADUADO").addStyle(subTitulos).setFontSize(7f).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
		cell = new Cell().add(new Paragraph("NOMBRE DE LOS ESTUDIOS O TÍTULO OBTENIDO").addStyle(subTitulos).setFontSize(7f).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
		cell = new Cell().add(new Paragraph("TERMINACIÓN").addStyle(subTitulos).setFontSize(7f).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
		cell = new Cell().add(new Paragraph("No. DE TARJETA PROFESIONAL").addStyle(subTitulos).setFontSize(7f).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		
		JSONArray esArray = JSONFactoryUtil.createJSONArray();
		if(!formacion_academica.getString("formacion").equals("")){
			try {
				esArray = JSONFactoryUtil.createJSONArray(formacion_academica.getString("formacion"));
			} catch (JSONException e) {}
		}
		int cuenta = esArray.length();
		if(cuenta==0)
			cuenta=1;
		for(int i=1 ; i<=cuenta ; i++){
			JSONObject es = JSONFactoryUtil.createJSONObject();
			if(esArray.getJSONObject(i-1)!=null)
				es = esArray.getJSONObject(i-1);
		
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
			cell = new Cell().add(new Paragraph(es.getString("modalidadEducacionSuperior")).addStyle(contenidos));
			_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
			cell = new Cell().add(new Paragraph(es.getString("semestresEducacionSuperior")).addStyle(contenidos));
			_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
			cell = new Cell().add(new Paragraph(es.getString("graduadoEducacionSuperior")).addStyle(contenidos));
			_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
			cell = new Cell().add(new Paragraph(es.getString("tituloEducacionSuperior")).addStyle(contenidos));
			_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
			cell = new Cell().add(new Paragraph(es.getString("mesEducacionSuperior")+"/"+es.getString("anhioEducacionSuperior")).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
			_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
			cell = new Cell().add(new Paragraph(es.getString("tarjetaEducacionSuperior")).addStyle(contenidos));
			_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
		
		}
		
		cell = new Cell().add(new Paragraph("EDUCACION SUPERIOR (PREGRADO Y POSTGRADO)\n\n").addStyle(titulos))
				.add(_tabla)
				.add(new Paragraph("\n"));
		tabla.addCell(cell);
		
		float [] cellWidth2 = {25f,20f,10f,10f,10f,25f};
		_tabla = new Table(UnitValue.createPercentArray(cellWidth2)).useAllAvailableWidth();
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
		cell = new Cell().add(new Paragraph("IDIOMA").addStyle(subTitulos).setFontSize(7f).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
		cell = new Cell().add(new Paragraph("LO HABLA").addStyle(subTitulos).setFontSize(7f).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
		cell = new Cell().add(new Paragraph("LO LEE").addStyle(subTitulos).setFontSize(7f).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
		cell = new Cell().add(new Paragraph("LO ESCRIBE").addStyle(subTitulos).setFontSize(7f).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		
		esArray = JSONFactoryUtil.createJSONArray();
		if(!formacion_academica.getString("idiomas").equals("")){
			try {
				esArray = JSONFactoryUtil.createJSONArray(formacion_academica.getString("idiomas"));
			} catch (JSONException e) {}
		}
		cuenta = esArray.length();
		if(cuenta==0)
			cuenta=1;
		for(int i=1 ; i<=cuenta ; i++){
			JSONObject es = JSONFactoryUtil.createJSONObject();
			if(esArray.getJSONObject(i-1)!=null)
				es = esArray.getJSONObject(i-1);
		
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
			String idioma = es.getString("idioma");
			if(idioma.isEmpty())
				idioma="/";
			cell = new Cell().add(new Paragraph(idioma).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
			_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
			cell = new Cell().add(new Paragraph(es.getString("habla")).addStyle(contenidos));
			_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
			cell = new Cell().add(new Paragraph(es.getString("lee")).addStyle(contenidos));
			_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
			cell = new Cell().add(new Paragraph(es.getString("escribe")).addStyle(contenidos));
			_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
		
		}
		
		cell = new Cell().add(new Paragraph("ESPECIFIQUE LOS IDIOMAS DIFERENTES AL ESPAÑOL QUE HABLA, LEE, ESCRIBE\n\n").addStyle(titulos))
				.add(_tabla)
				.add(new Paragraph("\n"));
		tabla.addCell(cell);
		
		
		return tabla;
	}

	public static Table getTablaExperienciaLaboral(usuario_data usuario){
		JSONObject experiencia_laboral = JSONFactoryUtil.createJSONObject();
		try {
			experiencia_laboral = JSONFactoryUtil.createJSONObject(usuario.getExperiencia_laboral());
		} catch (JSONException e) {}

		Style encabezado = new Style().setFontSize(12f).setBold().setBorder(Border.NO_BORDER);
		Style titulos = new Style().setFontSize(8f).setBold().setTextAlignment(TextAlignment.LEFT);
		Style contenidos = new Style().setFontSize(8f).setTextAlignment(TextAlignment.LEFT);
		
		Table tabla = new Table(1).useAllAvailableWidth();
		
		Cell cell = new Cell().add(new Paragraph("EXPERIENCIA LABORAL")).addStyle(encabezado);
		tabla.addCell(cell);

		float [] cellWidth = {16.6f,16.6f,16.6f,16.6f,16.6f,16.6f};
		Table _tabla = new Table(UnitValue.createPercentArray(cellWidth)).useAllAvailableWidth();
		
		JSONArray elArray = JSONFactoryUtil.createJSONArray();
		if(!experiencia_laboral.getString("experiencia").equals("")){
			try {
				elArray = JSONFactoryUtil.createJSONArray(experiencia_laboral.getString("experiencia"));
			} catch (JSONException e) {}
		}
		int cuenta = elArray.length();
		if(cuenta==0)
			cuenta=1;
		for(int i=1 ; i<=cuenta ; i++){
			JSONObject el = JSONFactoryUtil.createJSONObject();
			if(elArray.getJSONObject(i-1)!=null)
				el = elArray.getJSONObject(i-1);
			
			if(i==1){
				cell = new Cell(1,6).add(new Paragraph("EMPLEO ACTUAL O CONTRATO VIGENTE").addStyle(titulos).setTextAlignment(TextAlignment.CENTER));
			}else{
				cell = new Cell(1,6).add(new Paragraph("EMPLEO O CONTRATO ANTERIOR").addStyle(titulos).setTextAlignment(TextAlignment.CENTER));
			}
			_tabla.addCell(cell);
			cell = new Cell(1,3).add(new Paragraph("EMPRESA O ENTIDAD").addStyle(titulos))
					.add(new Paragraph(el.getString("empresa")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell(1,1).add(new Paragraph("SECTOR").addStyle(titulos))
					.add(new Paragraph(el.getString("sector")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell(1,2).add(new Paragraph("PAÍS").addStyle(titulos))
					.add(new Paragraph(el.getString("pais")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell(1,2).add(new Paragraph("DEPARTAMENTO").addStyle(titulos))
					.add(new Paragraph(el.getString("departamento")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell(1,2).add(new Paragraph("MUNICIPIO").addStyle(titulos))
					.add(new Paragraph(el.getString("municipio")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell(1,2).add(new Paragraph("CORREO ELECTRÓNICO ENTIDAD").addStyle(titulos))
					.add(new Paragraph(el.getString("correo")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell(1,2).add(new Paragraph("TELÉFONOS").addStyle(titulos))
					.add(new Paragraph(el.getString("departamento")).addStyle(contenidos));
			_tabla.addCell(cell);
			String fecha = "";
			if(!el.getString("fechaIngreso").isEmpty()){
				try {
					fecha = formatoS.format(formatoE.parse(el.getString("fechaIngreso")));
				} catch (ParseException e) {}
			}
			cell = new Cell(1,2).add(new Paragraph("FECHA DE INGRESO").addStyle(titulos))
					.add(new Paragraph(fecha).addStyle(contenidos));
			_tabla.addCell(cell);
			String fecha1 = "";
			if(!el.getString("fechaRetiro").isEmpty()){
				try {
					fecha1 = formatoS.format(formatoE.parse(el.getString("fechaRetiro")));
				} catch (ParseException e) {}
			}
			cell = new Cell(1,2).add(new Paragraph("FECHA DE RETIRO").addStyle(titulos))
					.add(new Paragraph(fecha1).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell(1,2).add(new Paragraph("CARGO O CONTRATO  ACTUAL").addStyle(titulos))
					.add(new Paragraph(el.getString("cargo")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell(1,2).add(new Paragraph("DEPENDENCIA").addStyle(titulos))
					.add(new Paragraph(el.getString("dependencia")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell(1,2).add(new Paragraph("DIRECCIÓN").addStyle(titulos))
					.add(new Paragraph(el.getString("direccion")).addStyle(contenidos));
			_tabla.addCell(cell);
		
		}
		cell = new Cell().add(_tabla).setBorder(Border.NO_BORDER);
		tabla.addCell(cell);
		
		return tabla;
	}

	public static Table getTablaTiempoTotal(usuario_data usuario){
		JSONObject tiempo_experiencia = JSONFactoryUtil.createJSONObject();
		try {
			tiempo_experiencia = JSONFactoryUtil.createJSONObject(usuario.getTiempo_experiencia());
		} catch (JSONException e) {}

		Style encabezado = new Style().setFontSize(12f).setBold().setBorder(Border.NO_BORDER);
		Style titulos = new Style().setFontSize(8f).setBold().setTextAlignment(TextAlignment.LEFT);
		Style contenidos = new Style().setFontSize(8f).setTextAlignment(TextAlignment.LEFT);
		
		Table tabla = new Table(1).useAllAvailableWidth();
		
		Cell cell = new Cell().add(new Paragraph("TIEMPO TOTAL DE EXPERIENCIA")).addStyle(encabezado);
		tabla.addCell(cell);

		float [] cellWidth = {25f,30f,10f,10f,25f};
		Table _tabla = new Table(UnitValue.createPercentArray(cellWidth)).useAllAvailableWidth();
		
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell(2,1).add(new Paragraph("OCUPACIÓN").addStyle(titulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell.setVerticalAlignment(VerticalAlignment.MIDDLE));
		cell = new Cell(1,2).add(new Paragraph("TIEMPO DE EXPERIENCIA").addStyle(titulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("AÑOS").addStyle(titulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("MESES").addStyle(titulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("SERVIDOR PÚBLICO").addStyle(contenidos));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(tiempo_experiencia.getString("anosServidorPublico")).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(tiempo_experiencia.getString("mesesServidorPublico")).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("EMPLEADO DEL SECTOR PRIVADO").addStyle(contenidos));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(tiempo_experiencia.getString("anosSectorPrivado")).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(tiempo_experiencia.getString("mesesSectorPrivado")).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("TRABAJADOR INDEPENDIENTE").addStyle(contenidos));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(tiempo_experiencia.getString("anosTrabajadorIndependiente")).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(tiempo_experiencia.getString("mesesTrabajadorIndependiente")).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("TOTAL TIEMPO EXPERIENCIA").addStyle(titulos));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(tiempo_experiencia.getString("anosTotales")).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(tiempo_experiencia.getString("mesesTotales")).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		
		cell = new Cell().add(_tabla).setBorder(Border.NO_BORDER);
		tabla.addCell(cell);
		
		return tabla;
	}
	
	public static Table getBienesRentas(usuario_data usuario){
		JSONObject bienes_rentas = JSONFactoryUtil.createJSONObject();
		try {
			bienes_rentas = JSONFactoryUtil.createJSONObject(usuario.getBienes_y_rentas());
		} catch (JSONException e) {}

		Style encabezado = new Style().setFontSize(12f).setBold().setBorder(Border.NO_BORDER);
		Style titulos = new Style().setFontSize(10f).setBold().setTextAlignment(TextAlignment.LEFT);
		Style subTitulos = new Style().setFontSize(8f).setBold().setTextAlignment(TextAlignment.LEFT);
		Style contenidos = new Style().setFontSize(8f).setTextAlignment(TextAlignment.LEFT);
		
		Table tabla = new Table(1).useAllAvailableWidth();
		
		Cell cell = new Cell().add(new Paragraph("INFORMACIÓN DE BIENES Y RENTAS")).addStyle(encabezado)
				.add(new Paragraph("DECLARO, EN CUMPLIMIENTO DE LO DISPUESTO EN EL ARTICULO 122, INCISO 3°, DE LA CONSTITUCIÓN POLÍTICA DE COLOMBIA Y EN LOS ARTÍCULOS 13 Y 14 DE LA LEY 190 DE 1995 QUE,  LOS ÚNICOS BIENES Y RENTAS QUE POSEO A LA FECHA, EN FORMA PERSONAL O POR INTERPUESTA PERSONA, SON LOS QUE RELACIONO A CONTINUACIÓN:\n\n").setFontSize(7f).setTextAlignment(TextAlignment.JUSTIFIED));
		tabla.addCell(cell);
		
		float [] cellWidth = {2.5f,17.5f,60f,17.5f,2.5f};
		Table _tabla = new Table(UnitValue.createPercentArray(cellWidth)).useAllAvailableWidth();
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("TIPO DE BIEN").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("DESCRIPCION DEL BIEN").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("VALOR").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		
		JSONArray bArray = JSONFactoryUtil.createJSONArray();
		if(!bienes_rentas.getString("bienes").equals("")){
			try {
				bArray = JSONFactoryUtil.createJSONArray(bienes_rentas.getString("bienes"));
			} catch (JSONException e) {}
		}
		int cuentab = bArray.length();
		if(cuentab==0)
			cuentab=1;
		for(int i=1 ; i<=cuentab ; i++){
			
			JSONObject bp = JSONFactoryUtil.createJSONObject();
			if(bArray.getJSONObject(i-1)!=null)
				bp = bArray.getJSONObject(i-1);
		
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(bp.getString("tipo_bien")).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(bp.getString("descripcionBien")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(bp.getString("valorBien")).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
			_tabla.addCell(cell);
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			
		}
		
		cell = new Cell().add(new Paragraph("BIENES PATRIMONIALES\n\n").addStyle(titulos))
				.add(_tabla)
				.add(new Paragraph("\n"));
		tabla.addCell(cell);
		
		float [] cellWidth1 = {2.5f,77.5f,17.5f,2.5f};
		_tabla = new Table(UnitValue.createPercentArray(cellWidth1)).useAllAvailableWidth();
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("TIPO DE OBLIGACIONES ").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("VALOR").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		
		JSONArray oArray = JSONFactoryUtil.createJSONArray();
		if(!bienes_rentas.getString("obligaciones").equals("")){
			try {
				oArray = JSONFactoryUtil.createJSONArray(bienes_rentas.getString("obligaciones"));
			} catch (JSONException e) {}
		}
		int cuentao = oArray.length();
		if(cuentao==0)
			cuentao=1;
		for(int i=1 ; i<=cuentao ; i++){
			
			JSONObject o = JSONFactoryUtil.createJSONObject();
			if(oArray.getJSONObject(i-1)!=null)
				o = oArray.getJSONObject(i-1);
		
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(o.getString("tipoObligacion")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(o.getString("valorObligacion")).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
			_tabla.addCell(cell);
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			
		}
		
		
		cell = new Cell().add(new Paragraph("OBLIGACIONES\n\n").addStyle(titulos))
				.add(_tabla)
				.add(new Paragraph("\n"));
		tabla.addCell(cell);
		
		
		
		return tabla;
	}
	
	public static Table getInformacionComplementaria(usuario_data usuario){
		JSONObject informacion_complementaria = JSONFactoryUtil.createJSONObject();
		try {
			informacion_complementaria = JSONFactoryUtil.createJSONObject(usuario.getInformacion_complementaria());
		} catch (JSONException e) {}

		Style encabezado = new Style().setFontSize(12f).setBold().setBorder(Border.NO_BORDER);
		Style titulos = new Style().setFontSize(10f).setBold().setTextAlignment(TextAlignment.LEFT);
		Style subTitulos = new Style().setFontSize(8f).setBold().setTextAlignment(TextAlignment.LEFT);
		Style contenidos = new Style().setFontSize(8f).setTextAlignment(TextAlignment.LEFT);
		
		Table tabla = new Table(1).useAllAvailableWidth();
		
		Cell cell = new Cell().add(new Paragraph("INFORMACIÓN COMPLEMENTARIA")).addStyle(encabezado);
		tabla.addCell(cell);
		
		float [] cellWidth = {2.5f,23.75f,23.75f,23.75f,23.75f,2.5f};
		Table _tabla = new Table(UnitValue.createPercentArray(cellWidth)).useAllAvailableWidth();
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("QUIEN RECUSA").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("CAUSAL").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("RECUSADO").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(" DECISIÓN TOMADA").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		
		JSONArray rrArray = JSONFactoryUtil.createJSONArray();
		if(!informacion_complementaria.getString("relacion_recusaciones").equals("")){
			try {
				rrArray = JSONFactoryUtil.createJSONArray(informacion_complementaria.getString("relacion_recusaciones"));
			} catch (JSONException e) {}
		}
		int cuentarr = rrArray.length();
		if(cuentarr==0)
			cuentarr=1;
		for(int i=1 ; i<=cuentarr ; i++){
			
			JSONObject rr = JSONFactoryUtil.createJSONObject();
			if(rrArray.getJSONObject(i-1)!=null)
				rr = rrArray.getJSONObject(i-1);
		
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(rr.getString("quien_recusa")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(rr.getString("causal")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(rr.getString("recusado")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(rr.getString("decision_tomada")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			
		}
		
		cell = new Cell().add(new Paragraph("RELACIÓN DE RECUSACIONES\n\n").addStyle(titulos))
				.add(_tabla)
				.add(new Paragraph("\n"));
		tabla.addCell(cell);
		
		float [] cellWidth1 = {2.5f,23.75f,11.75f,35.75f,23.75f,2.5f};
		_tabla = new Table(UnitValue.createPercentArray(cellWidth1)).useAllAvailableWidth();
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("QUIEN SE DECLARA IMPEDIDO").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("FECHA").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("CAUSAL").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(" DECISIÓN TOMADA").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		
		JSONArray riArray = JSONFactoryUtil.createJSONArray();
		if(!informacion_complementaria.getString("relacion_impedimentos").equals("")){
			try {
				riArray = JSONFactoryUtil.createJSONArray(informacion_complementaria.getString("relacion_impedimentos"));
			} catch (JSONException e) {}
		}
		int cuentari = riArray.length();
		if(cuentari==0)
			cuentari=1;
		for(int i=1 ; i<=cuentari ; i++){
			
			JSONObject ri = JSONFactoryUtil.createJSONObject();
			if(riArray.getJSONObject(i-1)!=null)
				ri = riArray.getJSONObject(i-1);
		
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ri.getString("quien_impedido")).addStyle(contenidos));
			_tabla.addCell(cell);
			String fecha = "";
			if(!ri.getString("fecha").isEmpty()){
				try {
					fecha = formatoS.format(formatoE.parse(ri.getString("fecha")));
				} catch (ParseException e) {}
			}
			cell = new Cell().add(new Paragraph(fecha).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ri.getString("causal")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ri.getString("decision_tomada")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			
		}
		
		
		cell = new Cell().add(new Paragraph("RELACIÓN DE IMPEDIMENTOS\n\n").addStyle(titulos))
				.add(_tabla)
				.add(new Paragraph("\n"));
		tabla.addCell(cell);
		
		float [] cellWidth2 = {2.5f,11.875f,11.875f,23.75f,6f,6f,17.75f,17.75f,2.5f};
		_tabla = new Table(UnitValue.createPercentArray(cellWidth2)).useAllAvailableWidth();
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("Nº RESOLUCIÓN").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("DESTINO").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("OBJETO DE LA COMISIÓN").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("VIÁTICOS").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("Nº DÍAS").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("ENTIDAD QUE ASUME COSTOS").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("OBSERVACIONES").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		
		JSONArray ipArray = JSONFactoryUtil.createJSONArray();
		if(!informacion_complementaria.getString("comision_interior").equals("")){
			try {
				ipArray = JSONFactoryUtil.createJSONArray(informacion_complementaria.getString("comision_interior"));
			} catch (JSONException e) {}
		}
		int cuentaip = ipArray.length();
		if(cuentaip==0)
			cuentaip=1;
		for(int i=1 ; i<=cuentaip ; i++){
			
			JSONObject ip = JSONFactoryUtil.createJSONObject();
			if(ipArray.getJSONObject(i-1)!=null)
				ip = ipArray.getJSONObject(i-1);
		
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ip.getString("numero_resolucion")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ip.getString("destino")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ip.getString("objeto_comision")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ip.getString("viaticos")).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ip.getString("dias")).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ip.getString("entidad")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ip.getString("observaciones")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			
		}
		
		
		cell = new Cell().add(new Paragraph("COMISIÓN DE SERVICIOS AL INTERIOR DEL PAÍS\n\n").addStyle(titulos))
				.add(_tabla)
				.add(new Paragraph("\n"));
		tabla.addCell(cell);
		
		
		_tabla = new Table(UnitValue.createPercentArray(cellWidth2)).useAllAvailableWidth();
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("Nº RESOLUCIÓN").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("DESTINO").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("OBJETO DE LA COMISIÓN").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("VIÁTICOS").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("Nº DÍAS").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("ENTIDAD QUE ASUME COSTOS").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("OBSERVACIONES").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		
		JSONArray epArray = JSONFactoryUtil.createJSONArray();
		if(!informacion_complementaria.getString("comision_exterior").equals("")){
			try {
				epArray = JSONFactoryUtil.createJSONArray(informacion_complementaria.getString("comision_exterior"));
			} catch (JSONException e) {}
		}
		int cuentaep = epArray.length();
		if(cuentaep==0)
			cuentaep=1;
		for(int i=1 ; i<=cuentaep ; i++){
			
			JSONObject ep = JSONFactoryUtil.createJSONObject();
			if(epArray.getJSONObject(i-1)!=null)
				ep = epArray.getJSONObject(i-1);
		
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ep.getString("numero_resolucion")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ep.getString("destino")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ep.getString("objeto_comision")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ep.getString("viaticos")).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ep.getString("dias")).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ep.getString("entidad")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ep.getString("observaciones")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			
		}
		
		
		cell = new Cell().add(new Paragraph("COMISIÓN DE SERVICIOS AL EXTERIOR DEL PAÍS\n\n").addStyle(titulos))
				.add(_tabla)
				.add(new Paragraph("\n"));
		tabla.addCell(cell);
		
		float [] cellWidth3 = {2.5f,77.5f,17.5f,2.5f};
		_tabla = new Table(UnitValue.createPercentArray(cellWidth3)).useAllAvailableWidth();
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("INASISTENCIA").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("CAUSA").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		
		JSONArray isArray = JSONFactoryUtil.createJSONArray();
		if(!informacion_complementaria.getString("inasistencia_sesiones_ordinarias").equals("")){
			try {
				isArray = JSONFactoryUtil.createJSONArray(informacion_complementaria.getString("inasistencia_sesiones_ordinarias"));
			} catch (JSONException e) {}
		}
		int cuentais = isArray.length();
		if(cuentais==0)
			cuentais=1;
		for(int i=1 ; i<=cuentais ; i++){
			
			JSONObject is = JSONFactoryUtil.createJSONObject();
			if(isArray.getJSONObject(i-1)!=null)
				is = isArray.getJSONObject(i-1);
		
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(is.getString("inasistencia")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(is.getString("causa")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			
		}
		
		
		cell = new Cell().add(new Paragraph("INASISTENCIA A SESIONES ORDINARIAS\n\n").addStyle(titulos))
				.add(_tabla)
				.add(new Paragraph("\n"));
		tabla.addCell(cell);
		
		float [] cellWidth4  = {2.5f,11f,30f,12.5f,12.5f,19f,10f,2.5f};
		_tabla = new Table(UnitValue.createPercentArray(cellWidth4)).useAllAvailableWidth();
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("SEMESTRE O AÑO").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("UNIVERSIDAD").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("FACULTAD").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("CÁTEDRA").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("HORARIO Y DÍA").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("HORAS SEMANALES").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		
		JSONArray duArray = JSONFactoryUtil.createJSONArray();
		if(!informacion_complementaria.getString("docencia_universitarias").equals("")){
			try {
				duArray = JSONFactoryUtil.createJSONArray(informacion_complementaria.getString("docencia_universitarias"));
			} catch (JSONException e) {}
		}
		int cuentadu = duArray.length();
		if(cuentadu==0)
			cuentadu=1;
		for(int i=1 ; i<=cuentadu ; i++){
			
			JSONObject du = JSONFactoryUtil.createJSONObject();
			if(duArray.getJSONObject(i-1)!=null)
				du = duArray.getJSONObject(i-1);
		
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(du.getString("semestre")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(du.getString("universidad")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(du.getString("facultad")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(du.getString("catedra")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(du.getString("horario")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(du.getString("horas")).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
			_tabla.addCell(cell);
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			
		}
		
		
		cell = new Cell().add(new Paragraph("DOCENCIAS UNIVERSITARIAS\n\n").addStyle(titulos))
				.add(_tabla)
				.add(new Paragraph("\n"));
		tabla.addCell(cell);
		
		
		return tabla;
	}
	
	public static Table getConflictoIntereses(usuario_data usuario){
		JSONObject conflicto_intereses = JSONFactoryUtil.createJSONObject();
		try {
			conflicto_intereses = JSONFactoryUtil.createJSONObject(usuario.getConflicto_intereses());
		} catch (JSONException e) {}

		Style encabezado = new Style().setFontSize(12f).setBold().setBorder(Border.NO_BORDER);
		Style titulos = new Style().setFontSize(10f).setBold().setTextAlignment(TextAlignment.LEFT);
		Style subTitulos = new Style().setFontSize(8f).setBold().setTextAlignment(TextAlignment.LEFT);
		Style contenidos = new Style().setFontSize(8f).setTextAlignment(TextAlignment.LEFT);
		
		Table tabla = new Table(1).useAllAvailableWidth();
		
		Cell cell = new Cell().add(new Paragraph("CONFLICTO DE INTERESES")).addStyle(encabezado);
		tabla.addCell(cell);
		
		float [] cellWidth = {2.5f,50f,25f,20f,2.5f};
		Table _tabla = new Table(UnitValue.createPercentArray(cellWidth)).useAllAvailableWidth();
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("NOMBRE COMPLETO (nombres y apellidos)").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("TIPO DE SOCIEDAD").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("DOCUMENTO DE IDENTIDAD").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		
		JSONArray informacion_coyuge = JSONFactoryUtil.createJSONArray();
		if(!conflicto_intereses.getString("informacion_coyuge").equals("")){
			try {
				informacion_coyuge = JSONFactoryUtil.createJSONArray(conflicto_intereses.getString("informacion_coyuge"));
			} catch (JSONException e) {}
		}
		int cuentaConyuge = informacion_coyuge.length();
		if(cuentaConyuge==0)
			cuentaConyuge=1;
		for(int i=1 ; i<=cuentaConyuge ; i++){
			
			JSONObject rr = JSONFactoryUtil.createJSONObject();
			if(informacion_coyuge.getJSONObject(i-1)!=null)
				rr = informacion_coyuge.getJSONObject(i-1);
		
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(rr.getString("nombreConyuge")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(rr.getString("tipoSociedad")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(rr.getString("numeroDocumentoConyuge")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			
		}
		String respuesta = conflicto_intereses.getString("respuesta");
		if(respuesta.equals("si")){
			cell = new Cell().add(new Paragraph("INFORMACIÓN DE CÓNYUGE Y/O COMPAÑERO(A) PERMANENTE\n").addStyle(titulos))
					.add(new Paragraph("En la actualidad tengo sociedad conyugal o de hecho vigente: "+respuesta.toUpperCase()+"\n").setFontSize(6f))
					.add(_tabla)
					.add(new Paragraph("\n"));
		}else{
			cell = new Cell().add(new Paragraph("INFORMACIÓN DE CÓNYUGE Y/O COMPAÑERO(A) PERMANENTE\n").addStyle(titulos))
					.add(new Paragraph("En la actualidad tengo sociedad conyugal o de hecho vigente: "+respuesta.toUpperCase()+"\n").setFontSize(6f))
					.add(new Paragraph("\n"));
		}
		tabla.addCell(cell);
		
		float [] cellWidth1 = {2.5f,15.83f,15.83f,15.83f,15.83f,15.83f,15.83f,2.5f};
		_tabla = new Table(UnitValue.createPercentArray(cellWidth1)).useAllAvailableWidth();
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell(1,6).add(new Paragraph("PARIENTES HASTA EL CUARTO GRADO DE CONSANGUINIDAD, SEGUNDO GRADO DE AFINIDAD Y PRIMERO CIVIL").setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell(2,1).add(new Paragraph("PARENTESCO").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell(1,4).add(new Paragraph("NOMBRE COMPLETO(nombres y apellidos)").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell(2,1).add(new Paragraph(" DOCUMENTO DE IDENTIDAD").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("Primer Nombre").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("Segundo Nombre").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(" Primer Apellido").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph(" Segundo Apellido").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		
		JSONArray informacion_parientes = JSONFactoryUtil.createJSONArray();
		if(!conflicto_intereses.getString("informacion_parientes").equals("")){
			try {
				informacion_parientes = JSONFactoryUtil.createJSONArray(conflicto_intereses.getString("informacion_parientes"));
			} catch (JSONException e) {}
		}
		int cuentaParientes = informacion_parientes.length();
		if(cuentaParientes==0)
			cuentaParientes=1;
		for(int i=1 ; i<=cuentaParientes ; i++){
			
			JSONObject parientes = JSONFactoryUtil.createJSONObject();
			if(informacion_parientes.getJSONObject(i-1)!=null)
				parientes = informacion_parientes.getJSONObject(i-1);
		
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(parientes.getString("parentesco")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(parientes.getString("primerNombre")).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(parientes.getString("segundoNombre")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(parientes.getString("primerApellido")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(parientes.getString("segundoApellido")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(parientes.getString("numeroDocumentoParentesco")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			
		}
		
		
		cell = new Cell().add(new Paragraph("INFORMACIÓN DE PARIENTES DE CONSANGUINIDAD, AFINIDAD Y PRIMERO CIVIL\n").addStyle(titulos))
				.add(new Paragraph("A continuación, se solicitará información de los parientes hasta el cuarto grado de consanguinidad, segundo de afinidad y primero civil que sea susceptible de generar conflicto de interés frente a la labor o actividad que desempeña\n").setFontSize(6f))
				.add(_tabla)
				.add(new Paragraph("\n"));
		tabla.addCell(cell);
		
		float [] cellWidth2 = {2.5f,50f,25f,20f,2.5f};
		_tabla = new Table(UnitValue.createPercentArray(cellWidth2)).useAllAvailableWidth();
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("GREMIO, SINDICATO, GRUPO SOCIAL O ECONÓMICO U ORGANIZACIÓN").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("CALIDAD DE MIEMBRO").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("PAÍS").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		
		JSONArray gremios = JSONFactoryUtil.createJSONArray();
		if(!conflicto_intereses.getString("participacion_gremios").equals("")){
			try {
				gremios = JSONFactoryUtil.createJSONArray(conflicto_intereses.getString("participacion_gremios"));
			} catch (JSONException e) {}
		}
		int cuentaGremios = gremios.length();
		if(cuentaGremios==0)
			cuentaGremios=1;
		for(int i=1 ; i<=cuentaGremios ; i++){
			
			JSONObject ip = JSONFactoryUtil.createJSONObject();
			if(gremios.getJSONObject(i-1)!=null)
				ip = gremios.getJSONObject(i-1);
		
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ip.getString("gremio")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ip.getString("calidadMiembro")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ip.getString("paisGremio")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			
		}
		
		
		cell = new Cell().add(new Paragraph("DE PARTICIPACIÓN EN GREMIOS, SINDICATOS, GRUPOS SOCIALES O ECONÓMICOS U ORGANIZACIONES CON ÁNIMO Y SIN ÁNIMO DE LUCRO\n").addStyle(titulos))
				.add(new Paragraph("Participación en gremios, sindicatos, grupos sociales o económicos u organizaciones con ánimo o sin ánimo de lucro (nacional o extranjera):\n").setFontSize(6f))
				.add(_tabla)
				.add(new Paragraph("\n"));
		tabla.addCell(cell);
		
		
		float [] cellWidth3 = {2.5f,40f,20f,15f,20f,2.5f};
		_tabla = new Table(UnitValue.createPercentArray(cellWidth3)).useAllAvailableWidth();
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("NOMBRE DEL FIDEICOMISO O ENCARGO FIDUCIARIO").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("CALIDAD").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("VALOR").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("PAÍS").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		
		JSONArray fideicomiso = JSONFactoryUtil.createJSONArray();
		if(!conflicto_intereses.getString("otras_inversiones_fideicomiso").equals("")){
			try {
				fideicomiso = JSONFactoryUtil.createJSONArray(conflicto_intereses.getString("otras_inversiones_fideicomiso"));
			} catch (JSONException e) {}
		}
		int cuentaFideicomiso = fideicomiso.length();
		if(cuentaFideicomiso==0)
			cuentaFideicomiso=1;
		for(int i=1 ; i<=cuentaFideicomiso ; i++){
			
			JSONObject ep = JSONFactoryUtil.createJSONObject();
			if(fideicomiso.getJSONObject(i-1)!=null)
				ep = fideicomiso.getJSONObject(i-1);
		
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ep.getString("nombreFideicomiso")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ep.getString("calidadFideicomiso")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ep.getString("valorFideicomiso")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(ep.getString("paisFideicomiso")).addStyle(contenidos).setTextAlignment(TextAlignment.CENTER));
			_tabla.addCell(cell);
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			
		}
		
		float [] cellWidth4 = {2.5f,60f,15f,20f,2.5f};
		Table _tabla1 = new Table(UnitValue.createPercentArray(cellWidth4)).useAllAvailableWidth();
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla1.addCell(cell);
		cell = new Cell().add(new Paragraph("TIPO DE INVERSIÓN").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla1.addCell(cell);
		cell = new Cell().add(new Paragraph("VALOR").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla1.addCell(cell);
		cell = new Cell().add(new Paragraph("PAÍS").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla1.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla1.addCell(cell);
		
		JSONArray inversion = JSONFactoryUtil.createJSONArray();
		if(!conflicto_intereses.getString("otras_inversiones_inversiones").equals("")){
			try {
				inversion = JSONFactoryUtil.createJSONArray(conflicto_intereses.getString("otras_inversiones_inversiones"));
			} catch (JSONException e) {}
		}
		int cuentaInversion = inversion.length();
		if(cuentaInversion==0)
			cuentaInversion=1;
		for(int i=1 ; i<=cuentaInversion ; i++){
			
			JSONObject ep = JSONFactoryUtil.createJSONObject();
			if(inversion.getJSONObject(i-1)!=null)
				ep = inversion.getJSONObject(i-1);
		
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla1.addCell(cell);
			cell = new Cell().add(new Paragraph(ep.getString("tipoInversion")).addStyle(contenidos));
			_tabla1.addCell(cell);
			cell = new Cell().add(new Paragraph(ep.getString("valorInversion")).addStyle(contenidos));
			_tabla1.addCell(cell);
			cell = new Cell().add(new Paragraph(ep.getString("paisInversion")).addStyle(contenidos));
			_tabla1.addCell(cell);
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla1.addCell(cell);
			
		}
		
		
		cell = new Cell().add(new Paragraph("OTRAS INVERSIONES\n").addStyle(titulos))
				.add(new Paragraph("Los fideicomisos y encargos fiduciarios de los cuales soy constituyente o beneficiario en Colombia y en el exterior son\n").setFontSize(6f))
				.add(_tabla)
				.add(new Paragraph("\n"))
				.add(new Paragraph("Las inversiones en bonos, fondos de inversión, fondos de ahorro voluntario en Colombia y en el exterior u otros son\n").setFontSize(6f))
				.add(_tabla1)
				.add(new Paragraph("\n"));
		tabla.addCell(cell);
		
		float [] cellWidth5 = {2.5f,65f,30f,2.5f};
		_tabla = new Table(UnitValue.createPercentArray(cellWidth5)).useAllAvailableWidth();
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("NOMBRE").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("VALOR DE LA DONACIÓN").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		
		JSONArray donaciones = JSONFactoryUtil.createJSONArray();
		if(!conflicto_intereses.getString("donaciones").equals("")){
			try {
				donaciones = JSONFactoryUtil.createJSONArray(conflicto_intereses.getString("donaciones"));
			} catch (JSONException e) {}
		}
		int cuentaDonaciones = donaciones.length();
		if(cuentaDonaciones==0)
			cuentaDonaciones=1;
		for(int i=1 ; i<=cuentaDonaciones ; i++){
			
			JSONObject is = JSONFactoryUtil.createJSONObject();
			if(donaciones.getJSONObject(i-1)!=null)
				is = donaciones.getJSONObject(i-1);
		
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(is.getString("nombreDonacion")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(is.getString("valorDonacion")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			
		}
		
		
		cell = new Cell().add(new Paragraph("DONACIONES QUE REPRESENTARON REDUCCIONES EN LA DECLARACIÓN DE RENTA\n\n").addStyle(titulos))
				.add(_tabla)
				.add(new Paragraph("\n"));
		tabla.addCell(cell);
		
		float [] cellWidth6  = {2.5f,95f,2.5f};
		_tabla = new Table(UnitValue.createPercentArray(cellWidth6)).useAllAvailableWidth();
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		cell = new Cell().add(new Paragraph("DESCRIPCIÓN DEL POTENCIAL CONFLICTO DE INTERESES").addStyle(subTitulos).setTextAlignment(TextAlignment.CENTER));
		_tabla.addCell(cell);
		cell = new Cell().setBorder(Border.NO_BORDER);
		_tabla.addCell(cell);
		
		JSONArray potenciales = JSONFactoryUtil.createJSONArray();
		if(!conflicto_intereses.getString("potenciales").equals("")){
			try {
				potenciales = JSONFactoryUtil.createJSONArray(conflicto_intereses.getString("potenciales"));
			} catch (JSONException e) {}
		}
		int cuentaPotenciales = potenciales.length();
		if(cuentaPotenciales==0)
			cuentaPotenciales=1;
		for(int i=1 ; i<=cuentaPotenciales ; i++){
			
			JSONObject du = JSONFactoryUtil.createJSONObject();
			if(potenciales.getJSONObject(i-1)!=null)
				du = potenciales.getJSONObject(i-1);
		
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			cell = new Cell().add(new Paragraph(du.getString("descripcionPotenciales")).addStyle(contenidos));
			_tabla.addCell(cell);
			cell = new Cell().setBorder(Border.NO_BORDER);
			_tabla.addCell(cell);
			
		}
		
		
		cell = new Cell().add(new Paragraph("POTENCIALES CONFLICTOS DE INTERÉS\n").addStyle(titulos))
				.add(new Paragraph("Escriba otros intereses personales que podrían constituir una posible situación de conflicto de intereses, por ejemplo: - Actividades que desempeño, negocios, establecimientos que poseo etc. - Actividades o negocios de mi cónyuge o compañero(a) permanente y parientes hasta el cuarto grado de consanguinidad, segundo de afinidad y primero civil, de acuerdo con lo descrito en el numeral 2.2 - Actividades o negocios de mi socio de derecho o hecho\n").setFontSize(6f))
				.add(_tabla)
				.add(new Paragraph("\n"));
		tabla.addCell(cell);
		
		
		return tabla;
	}
	
}



package com.co.csj.registro;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.co.csj.registro.modeloBasico;
import com.co.csj.service.model.auditoria;
import com.co.csj.service.model.correos;
import com.co.csj.service.model.editores;
import com.co.csj.service.service.auditoriaLocalServiceUtil;
import com.co.csj.service.service.correosLocalServiceUtil;
import com.co.csj.service.service.editoresLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class consultas {
	private static String DATA_SOURCE_APPS = "java:comp/env/jdbc/base_datos_csj";
	private static String DATA_SOURCE_DESPACHOS = "java:comp/env/jdbc/despachos-judiciales";
	private static String DATA_SOURCE_PORTAL = "java:comp/env/jdbc/csjDB";
	static String _SQL = "";
	
	public static List<modeloBasico> getTipoDocumento(){
		List<modeloBasico> lista = new ArrayList<modeloBasico>();
		
		_SQL = "select id,nombre_documento from ley_trans_tipo_documento";
		
		Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_APPS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                    modeloBasico aux = new modeloBasico(result.getString(1), result.getString(2));
                    lista.add(aux);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_APPS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_APPS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}		
		
		return lista;
	}
	
	public static String getTipoDocumentoDiminutivo(String cod){
		String respuesta = "";
		
		_SQL = "select diminutivo from ley_trans_tipo_documento where id = '"+cod+"'";
		
		Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_APPS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                    respuesta=result.getString(1);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_APPS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_APPS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}		
		
		return respuesta;
	}

	public static List<modeloBasico> getDepartamentos(){
		List<modeloBasico> lista = new ArrayList<modeloBasico>();
		
		_SQL =	"select NOMBRE,COD_DANE from ADM_LOCALIZACION where COD_DANE=COD_DANE_DEPARTAMENTO and ESTADO = 1 order by NOMBRE asc";
		
		Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_DESPACHOS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                    modeloBasico mun = new modeloBasico(result.getString(2), result.getString(1));
                    lista.add(mun);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_DESPACHOS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_DESPACHOS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}		
		
		return lista;
	}
	
	public static List<modeloBasico> getMunicipios(String cod){
		List<modeloBasico> lista = new ArrayList<modeloBasico>();
		
		_SQL =	"select NOMBRE,COD_DANE_DEPARTAMENTO+COD_DANE from ADM_LOCALIZACION where COD_DANE!=COD_DANE_DEPARTAMENTO and NOMBRE!='' and ESTADO = 1 and COD_DANE_DEPARTAMENTO = '"+cod+"' order by NOMBRE asc";
		
		Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_DESPACHOS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                    modeloBasico mun = new modeloBasico(result.getString(2), result.getString(1));
                    lista.add(mun);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_DESPACHOS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_DESPACHOS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}		
		
		return lista;
	}

	public static List<modeloBasico> getMunicipiosR(String cod){
		List<modeloBasico> lista = new ArrayList<modeloBasico>();
		
		_SQL =	"select NOMBRE,COD_DANE from ADM_LOCALIZACION where COD_DANE!=COD_DANE_DEPARTAMENTO and NOMBRE!='' and ESTADO = 1 and COD_DANE_DEPARTAMENTO = '"+cod+"' order by NOMBRE asc";
		
		Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_DESPACHOS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                    modeloBasico mun = new modeloBasico(result.getString(2), result.getString(1));
                    lista.add(mun);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_DESPACHOS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_DESPACHOS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}		
		
		return lista;
	}
	
	public static List<modeloBasico> getEntidad(){
		List<modeloBasico> lista = new ArrayList<modeloBasico>();
		
		_SQL =	"select codigo,nombre from ADM_ENTIDAD where estado = 1 order by nombre asc";
		
		Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_DESPACHOS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                	String cod = result.getString(1);
                	if(cod.length()==1)
                		cod="0"+cod;
                	
                    modeloBasico mun = new modeloBasico(cod , result.getString(2));
                    lista.add(mun);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_DESPACHOS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_DESPACHOS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}	
		
		return lista;
	}
	
	public static List<modeloBasico> getEspecialidad(){
		List<modeloBasico> lista = new ArrayList<modeloBasico>();
		
		_SQL =	"select codigo,nombre from ADM_ESPECIALIDAD where estado = 1 order by nombre asc";
		
		Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_DESPACHOS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                	String cod = result.getString(1);
                	if(cod.length()==1)
                		cod="0"+cod;
                	
                    modeloBasico mun = new modeloBasico(cod , result.getString(2));
                    lista.add(mun);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_DESPACHOS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_DESPACHOS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}		
		
		return lista;
	}
	
	public static List<modeloBasico> getDespachos(String municipio, String entidad, String especialidad){
		List<modeloBasico> lista = new ArrayList<modeloBasico>();
		
		_SQL =	"select codigo,nombre from DIRECTORIO_PORTAL where 1=1 ";
		if(!municipio.isEmpty())
			_SQL+=" AND SUBSTRING(codigo,1,5) = '"+municipio+"'";
		if(!entidad.isEmpty())
			_SQL+=" AND SUBSTRING(codigo,6,2) = '"+entidad+"'";
		if(!especialidad.isEmpty())
			_SQL+=" AND SUBSTRING(codigo,8,2) = '"+especialidad+"'";
		
		Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_APPS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                    modeloBasico mun = new modeloBasico(result.getString(1) , result.getString(2));
                    lista.add(mun);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_APPS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_APPS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}		
		
		return lista;
	}

	public static List<modeloBasico> getMeses(){
		List<modeloBasico> respuesta = new ArrayList<modeloBasico>();
		
		modeloBasico  m = new modeloBasico("1", "ENERO");
		respuesta.add(m);
		m = new modeloBasico("2", "FEBRERO");
		respuesta.add(m);
		m = new modeloBasico("3", "MARZO");
		respuesta.add(m);
		m = new modeloBasico("4", "ABRIL");
		respuesta.add(m);
		m = new modeloBasico("5", "MAYO");
		respuesta.add(m);
		m = new modeloBasico("6", "JUNIO");
		respuesta.add(m);
		m = new modeloBasico("7", "JULIO");
		respuesta.add(m);
		m = new modeloBasico("8", "AGOSTO");
		respuesta.add(m);
		m = new modeloBasico("9", "SEPTIEMBRE");
		respuesta.add(m);
		m = new modeloBasico("10", "OCTUBRE");
		respuesta.add(m);
		m = new modeloBasico("11", "NOVIEMBRE");
		respuesta.add(m);
		m = new modeloBasico("12", "DICIEMBRE");
		respuesta.add(m);
		
		return respuesta;
	}
	
	public static List<modeloBasico> getAnios(){
		List<modeloBasico> respuesta = new ArrayList<modeloBasico>();
		
		Date hoy = new Date();
		int anhio = hoy.getYear()+1900;

		for(int i = anhio ; i>=1950 ; i--){
			modeloBasico  m = new modeloBasico(String.valueOf(i), String.valueOf(i));
		respuesta.add(m);
		}
				
		return respuesta;
	}
	
	public static List<modeloBasico> getEducacionMedia(){
		List<modeloBasico> respuesta = new ArrayList<modeloBasico>();
		
		modeloBasico  m = new modeloBasico("1o.", "1o.");
		respuesta.add(m);
		m = new modeloBasico("2o.", "2o.");
		respuesta.add(m);
		m = new modeloBasico("3o.", "3o.");
		respuesta.add(m);
		m = new modeloBasico("4o.", "4o.");
		respuesta.add(m);
		m = new modeloBasico("5o.", "5o.");
		respuesta.add(m);
		m = new modeloBasico("6o.", "6o.");
		respuesta.add(m);
		m = new modeloBasico("7o.", "7o.");
		respuesta.add(m);
		m = new modeloBasico("8o.", "8o.");
		respuesta.add(m);
		m = new modeloBasico("9o.", "9o.");
		respuesta.add(m);
		m = new modeloBasico("10", "10");
		respuesta.add(m);
		m = new modeloBasico("11", "11");
		respuesta.add(m);
		
		return respuesta;
	}
	
	public static List<modeloBasico> getModalidadEducacionSuperior(){
		List<modeloBasico> respuesta = new ArrayList<modeloBasico>();
		
		modeloBasico  m = new modeloBasico("TÉCNICA", "TÉCNICA");
		respuesta.add(m);
		m = new modeloBasico("TECNOLÓGICA", "TECNOLÓGICA");
		respuesta.add(m);
		m = new modeloBasico("TECNOLÓGICA ESPECIALIZADA", "TECNOLÓGICA ESPECIALIZADA");
		respuesta.add(m);
		m = new modeloBasico("UNIVERSITARIA", "UNIVERSITARIA");
		respuesta.add(m);
		m = new modeloBasico("ESPECIALIZACIÓN", "ESPECIALIZACIÓN");
		respuesta.add(m);
		m = new modeloBasico("MAESTRÍA O MAGISTER", "MAESTRÍA O MAGISTER");
		respuesta.add(m);
		m = new modeloBasico("DOCTORADO O PHD", "DOCTORADO O PHD");
		respuesta.add(m);
		m = new modeloBasico("DIPLOMADO", "DIPLOMADO");
		respuesta.add(m);
		
		return respuesta;
	}
	
	public static List<modeloBasico> getDominioIdioma(){
		List<modeloBasico> respuesta = new ArrayList<modeloBasico>();
		
		modeloBasico  m = new modeloBasico("REGULAR", "REGULAR");
		respuesta.add(m);
		m = new modeloBasico("BIEN", "BIEN");
		respuesta.add(m);
		m = new modeloBasico("MUY BIEN", "MUY BIEN");
		respuesta.add(m);
		
		return respuesta;
	}
	
	public static List<modeloBasico> getTipoBien(){
		List<modeloBasico> respuesta = new ArrayList<modeloBasico>();
		
		modeloBasico  m = new modeloBasico("MUEBLES", "MUEBLES");
		respuesta.add(m);
		m = new modeloBasico("INMUEBLES", "INMUEBLES");
		respuesta.add(m);
		m = new modeloBasico("OTROS", "OTROS");
		respuesta.add(m);
		
		return respuesta;
	}
	
	public static List<modeloBasico> getDecision(){
		List<modeloBasico> respuesta = new ArrayList<modeloBasico>();
		
		modeloBasico  m = new modeloBasico("NO", "NO");
		respuesta.add(m);
		m = new modeloBasico("SI", "SI");
		respuesta.add(m);
		
		return respuesta;
	}

	public static long getValidarSolicitud(String usuario ,String ano){
		long valor = 0L;
		
		_SQL = "SELECT id FROM ley_trans_publicaciones where fk_usuario = '"+usuario+"' and anhio_publicacion = '"+ano+"' and estatus='PUBLICADO'";
		
		Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_APPS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                    valor = result.getLong(1);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_APPS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_APPS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}		
		
		return valor;
	}
	
	public static List<modeloBasico> getDepartamentosNombre(){
		List<modeloBasico> lista = new ArrayList<modeloBasico>();
		
		_SQL =	"select NOMBRE from ADM_LOCALIZACION where COD_DANE=COD_DANE_DEPARTAMENTO and ESTADO = 1 order by NOMBRE asc";
		
		Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_DESPACHOS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                    modeloBasico mun = new modeloBasico(result.getString(1), result.getString(1));
                    lista.add(mun);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_DESPACHOS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_DESPACHOS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}	
		
		return lista;
	}
	
	public static List<modeloBasico> getMunicipiosNombre(String nombre){
		List<modeloBasico> lista = new ArrayList<modeloBasico>();
		
		_SQL =	"select NOMBRE "+
				"from ADM_LOCALIZACION "+
				"where COD_DANE!=COD_DANE_DEPARTAMENTO "+
				"and NOMBRE!='' "+
				"and ESTADO = 1 "+
				"and COD_DANE_DEPARTAMENTO = (select COD_DANE from ADM_LOCALIZACION where COD_DANE=COD_DANE_DEPARTAMENTO and ESTADO = 1 and NOMBRE='"+nombre+"') "+
				"and NOMBRE != 'BOGOTÁ - ALTAS CORTES' "+
				"order by NOMBRE asc";
		
		Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_DESPACHOS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                    modeloBasico mun = new modeloBasico(result.getString(1), result.getString(1));
                    lista.add(mun);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_DESPACHOS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_DESPACHOS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}		
		
		return lista;
	}

	public static List<modeloBasico> getAcciones(){
		List<modeloBasico> lista = new ArrayList<modeloBasico>();
		
		_SQL = "SELECT distinct(accion) FROM ley_trans_auditoria";
		
		Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_APPS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                    modeloBasico m = new modeloBasico(result.getString(1), result.getString(1));
                    lista.add(m);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_APPS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_APPS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}		
		
		return lista;
	}
	
	public static List<modeloBasico> getCampos(){
		List<modeloBasico> lista = new ArrayList<modeloBasico>();
		
		_SQL = "SELECT distinct(campo_modifico) FROM ley_trans_auditoria WHERE campo_modifico !=''";
		
		Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_APPS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                	modeloBasico m = new modeloBasico(result.getString(1), result.getString(1));
                    lista.add(m);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_APPS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_APPS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}	
		
		return lista;
	}
	
	public static List<modeloBasico> getAnosVigencia(){
		List<modeloBasico> lista = new ArrayList<modeloBasico>();
		
		_SQL = "SELECT anhio FROM ley_trans_planificacion_anio order by 1 desc";
		
		Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_APPS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                	modeloBasico m = new modeloBasico(result.getString(1), result.getString(1));
                    lista.add(m);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_APPS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_APPS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}	
		
		return lista;
	}
	
	public static List<auditoria> getAuditoria(String accion, String campo, String fi, String ff, String cedula, String ano) throws ParseException, PortalException, SystemException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        ArrayList<auditoria> lista = new ArrayList<auditoria>();
        
        _SQL = "SELECT id from ley_trans_auditoria where 1=1 ";
        
        if (!accion.isEmpty()) {
        	_SQL+= " and accion = '" + accion + "'";
        }
        if (!campo.isEmpty()) {
        	_SQL+= " and campo_modifico = '" + campo + "'";
        }
        if (!fi.isEmpty()) {
            fi = String.valueOf(fi) + " 00:00";
            java.util.Date fechaInicial = formato.parse(fi);
            _SQL+= " and fecha >= '" + formato.format(fechaInicial) + "'";
        }
        if (!ff.isEmpty()) {
            ff = String.valueOf(ff) + " 23:59";
            java.util.Date fechaFinal = formato.parse(ff);
            _SQL+= " and fecha <= '" + formato.format(fechaFinal) + "'";
        }
        if (!cedula.isEmpty()) {
        	_SQL+= " and cedula_funcionario = '" + cedula + "'";
        }
        if (!ano.isEmpty()) {
        	_SQL+= " and ano_vigencia = " + ano + " ";
        }
        _SQL+= " order by fecha desc";
        
        
        Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_APPS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                	auditoria aud = auditoriaLocalServiceUtil.getauditoria(result.getLong(1));
                    lista.add(aud);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_APPS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_APPS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}	
        return lista;
    }

	public static String getNombreDespacho(String cod){
		String nombre = "";
		
		_SQL =	"select nombre from DIRECTORIO_PORTAL where codigo='"+cod+"' ";
		
		Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_APPS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                    nombre = result.getString(1);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_APPS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_APPS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}		
		
		return nombre;
	}
	
	public static JSONObject getReporteDespachos(String departamento, String municipio, String entidad, String especialidad, String ano) throws ParseException, PortalException, SystemException {
        
        JSONObject lista = JSONFactoryUtil.createJSONObject();
        lista.put("departamento", departamento);
        lista.put("municipio", municipio);
        lista.put("entidad", entidad);
        lista.put("especialidad", especialidad);
        lista.put("ano", ano);
        
        _SQL = 	"select dp.codigo,dp.NOMBRE,depa.NOMBRE,muni.nombre,ent.nombre,esp.nombre,dist.nombre "+
        		"from DIRECTORIO_PORTAL dp "+
        		"join DESPACHO_PRU.dbo.ADM_LOCALIZACION depa on (depa.cod_dane = SUBSTRING(dp.codigo, 1, 2) )  "+
        		"join DESPACHO_PRU.dbo.ADM_LOCALIZACION muni on (muni.cod_dane_departamento = SUBSTRING(dp.codigo, 1, 2)and muni.cod_dane = SUBSTRING(dp.codigo, 3, 3))  "+
        		"join DESPACHO_PRU.dbo.ADM_ENTIDAD ent on (SUBSTRING(dp.codigo, 6, 2)=ent.CODIGO)  "+
        		"join DESPACHO_PRU.dbo.ADM_ESPECIALIDAD esp on (SUBSTRING(dp.codigo, 8, 2)=esp.CODIGO)  "+
        		"join DESPACHO_PRU.dbo.ADM_JURISDICCION jur on (jur.ID=ent.FK_ENTIDAD_TO_JURIDICCION)  "+
        		"left join DESPACHO_PRU.dbo.ADM_MAPA_JUDICIAL mj on (mj.FK_DANEDEPAR_TO_MAPA=depa.COD_DANE_DEPARTAMENTO and mj.FK_DANEMUNI_TO_MAPA=muni.COD_DANE and mj.FK_JURIDICCION_TO_MAPA=jur.ID)  "+
        		"left join DESPACHO_PRU.dbo.ADM_CIRCUITO circuito on (circuito.ID=mj.FK_CIRCUITO_TO_MAPA)  "+
        		"left join DESPACHO_PRU.dbo.ADM_DISTRITO dist on (dist.ID=circuito.FK_DISTRITO_TO_CIRCUITO) "+
        		"where not exists( select * from ley_trans_publicaciones where despacho_usuario = dp.CODIGO and anhio_publicacion = "+ano+" and estatus='PUBLICADO' )";
        
        if(!departamento.isEmpty())
			_SQL+=" AND SUBSTRING(dp.codigo,1,2) = '"+departamento+"'";
        if(!municipio.isEmpty())
			_SQL+=" AND SUBSTRING(dp.codigo,3,3) = '"+municipio+"'";
		if(!entidad.isEmpty())
			_SQL+=" AND SUBSTRING(dp.codigo,6,2) = '"+entidad+"'";
		if(!especialidad.isEmpty())
			_SQL+=" AND SUBSTRING(dp.codigo,8,2) = '"+especialidad+"'";
		
		_SQL+=" order by dp.NOMBRE asc";
		
        JSONArray data = JSONFactoryUtil.createJSONArray();
        
        Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_APPS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                	JSONObject d = JSONFactoryUtil.createJSONObject();
                	d.put("codigo", result.getString(1));
                	d.put("nombre", result.getString(2));
                	d.put("departamento", result.getString(3));
                	d.put("municipio", result.getString(4));
                	d.put("entidad", result.getString(5));
                	d.put("especialidad", result.getString(6));
                	d.put("distrito", result.getString(7));
                	data.put(d);
                	
                }
                lista.put("data", data);
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_APPS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_APPS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}	
        return lista;
    }
	
	public static JSONObject getReportePublicados(String departamento, String municipio, String entidad, String especialidad, String ano) throws ParseException, PortalException, SystemException {
        
        JSONObject lista = JSONFactoryUtil.createJSONObject();
        lista.put("departamento", departamento);
        lista.put("municipio", municipio);
        lista.put("entidad", entidad);
        lista.put("especialidad", especialidad);
        lista.put("ano", ano);
        
        _SQL = 	"select ltp.id 'id',ltp.fk_usuario 'CEDULA',ltfd.nombres+' '+ltfd.apellidos 'NOMBRE',ltp.cargo 'CARGO',dp.codigo 'CODIGO DESPACHO',dp.NOMBRE 'NOMBRE DESPACHO',depa.NOMBRE 'DEPARTAMENTO',muni.nombre 'MUNICIPIO'  "+
        		",ent.nombre 'ENTIDAD',esp.nombre 'ESPECIALIDAD',dist.nombre 'DISTRITO' "+
        		"from ley_trans_funcionario_data ltfd join ley_trans_publicaciones ltp on(ltfd.numero_documento = ltp.fk_usuario) "+
        		"join DIRECTORIO_PORTAL dp on(ltp.despacho_usuario = dp.CODIGO) "+
        		"join DESPACHO_PRU.dbo.ADM_LOCALIZACION depa on (depa.cod_dane = SUBSTRING(dp.codigo, 1, 2) )   "+
        		"join DESPACHO_PRU.dbo.ADM_LOCALIZACION muni on (muni.cod_dane_departamento = SUBSTRING(dp.codigo, 1, 2)and muni.cod_dane = SUBSTRING(dp.codigo, 3, 3))   "+
        		"join DESPACHO_PRU.dbo.ADM_ENTIDAD ent on (SUBSTRING(dp.codigo, 6, 2)=ent.CODIGO)   "+
        		"join DESPACHO_PRU.dbo.ADM_ESPECIALIDAD esp on (SUBSTRING(dp.codigo, 8, 2)=esp.CODIGO)   "+
        		"join DESPACHO_PRU.dbo.ADM_JURISDICCION jur on (jur.ID=ent.FK_ENTIDAD_TO_JURIDICCION)   "+
        		"left join DESPACHO_PRU.dbo.ADM_MAPA_JUDICIAL mj on (mj.FK_DANEDEPAR_TO_MAPA=depa.COD_DANE_DEPARTAMENTO and mj.FK_DANEMUNI_TO_MAPA=muni.COD_DANE and mj.FK_JURIDICCION_TO_MAPA=jur.ID)   "+
        		"left join DESPACHO_PRU.dbo.ADM_CIRCUITO circuito on (circuito.ID=mj.FK_CIRCUITO_TO_MAPA)   "+
        		"left join DESPACHO_PRU.dbo.ADM_DISTRITO dist on (dist.ID=circuito.FK_DISTRITO_TO_CIRCUITO)  "+
        		"where ltp.estatus = 'PUBLICADO' and ltp.anhio_publicacion="+ano+" ";
        
        if(!departamento.isEmpty())
			_SQL+=" AND SUBSTRING(dp.codigo,1,2) = '"+departamento+"'";
        if(!municipio.isEmpty())
			_SQL+=" AND SUBSTRING(dp.codigo,3,3) = '"+municipio+"'";
		if(!entidad.isEmpty())
			_SQL+=" AND SUBSTRING(dp.codigo,6,2) = '"+entidad+"'";
		if(!especialidad.isEmpty())
			_SQL+=" AND SUBSTRING(dp.codigo,8,2) = '"+especialidad+"'";
		
		_SQL+=" order by dp.NOMBRE asc";
		
        JSONArray data = JSONFactoryUtil.createJSONArray();
        
        Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_APPS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);

            if (result != null) {
                while (result.next()) {
                	JSONObject d = JSONFactoryUtil.createJSONObject();
                	d.put("id", result.getString(1));
                	d.put("cedula", result.getString(2));
                	d.put("nombre", result.getString(3));
                	d.put("cargo", result.getString(4));
                	d.put("codigo_despacho", result.getString(5));
                	d.put("nombre_despacho", result.getString(6));
                	d.put("departamento", result.getString(7));
                	d.put("municipio", result.getString(8));
                	d.put("entidad", result.getString(9));
                	d.put("especialidad", result.getString(10));
                	d.put("distrito", result.getString(11));
                	data.put(d);
                	
                }
                lista.put("data", data);
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
        }
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_APPS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_APPS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}	
        return lista;
    }
	
	public static boolean validarDespacho(String cod){
		boolean esta = false;
		
		_SQL =	"select nombre from DIRECTORIO_PORTAL where codigo='"+cod+"' ";
		
		Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_APPS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);

            if (result != null) {
            	while (result.next()) {
                    esta = true;
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_APPS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_APPS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}		
		
		return esta;
	}
	
	public static boolean validarNumeroDocumento(String numero){
		boolean esta = false;		
		_SQL = 	"select numero_documento_edita from ley_trans_usuarios where numero_documento_edita = '"+numero+"' "+
				"union "+
				"select cedulaResponsable from ley_trans_correos_depurado where cedulaResponsable = '"+numero+"'";
		
		Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_APPS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                    esta = true;
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_APPS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_APPS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}		
		
		return esta;
	}
	
	public String getScreeName(String screenName){
		String respuesta = "";
		
		_SQL = "select screenName from user_ where screenName = '"+screenName+"'";
		
		Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_PORTAL);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                    respuesta = result.getString(1);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_PORTAL+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_PORTAL);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}		
		
		return respuesta;
	}
	
	public static List<correos> getBusquedaFuncionarios(String correo, String cedula){
		List<correos> respuesta = new ArrayList<correos>();
		
		_SQL = "select ltc.* from ley_trans_correos_depurado ltc left join (select ltu.id,ltu.numero_documento_edita,u.emailAddress 'correo' from ley_trans_usuarios ltu join lportalramaprod.dbo.User_ u on ltu.userid=u.userId) ltu  on ltc.cuentacorreo=ltu.correo and ltc.cedularesponsable=ltu.numero_documento_edita where ltu.id is null";
		
		if(!correo.isEmpty())
			_SQL+=" AND ltc.cuentacorreo like '%"+correo+"%'";
        if(!cedula.isEmpty())
			_SQL+=" AND ltc.cedularesponsable = '"+cedula+"'";
		
        Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_APPS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                    correos cc = correosLocalServiceUtil.createcorreos(result.getLong(1));
                    cc.setCuentaCorreo(result.getString(2));
                    cc.setNombre1(result.getString(3));
                    cc.setApellido(result.getString(4));
                    cc.setCargo(result.getString(5));
                    cc.setCodigoDespacho(result.getString(6));
                    cc.setCedulaResponsable(result.getString(7));
                    respuesta.add(cc);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_APPS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_APPS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}		
		
		return respuesta;
	}

	public static List<editores> getBusquedaEditores(String correo, String cedula, String nombre){
		List<editores> respuesta = new ArrayList<editores>();
		
		_SQL = 	"select id,case when u.emailAddress is null then 'Usuario eliminado del portal' else u.emailAddress end,nombres_edita,apellidos_edita,numero_documento_edita,cargo_edita,despacho_edita "+ 
				"from ley_trans_usuarios ltu left join lportalramaprod.dbo.User_ u on (ltu.userid = u.userId) where 1=1 ";
//				"from ley_trans_usuarios ltu join lramajudicialpru.dbo.User_ u on (ltu.userid = u.userId) join ley_trans_funcionario_data ltf on (ltu.numero_documento_edita = ltf.numero_documento) where 1=1 ";
		
		if(!correo.isEmpty())
			_SQL+=" AND u.emailAddress like '%"+correo+"%'";
        if(!cedula.isEmpty())
			_SQL+=" AND numero_documento_edita = '"+cedula+"'";
        if(!nombre.isEmpty())
			_SQL+=" AND nombres_edita+' '+apellidos_edita like '%"+nombre+"%'";
		
        Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_APPS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                	editores cc = editoresLocalServiceUtil.createeditores(result.getLong(1));
                    cc.setCorreo(result.getString(2));
                    cc.setNombres_edita(result.getString(3));
                    cc.setApellidos_edita(result.getString(4));
                    cc.setNumero_documento_edita(result.getString(5));
                    cc.setCargo_edita(result.getString(6));
                    cc.setDespacho_edita(result.getString(7));
                    respuesta.add(cc);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_APPS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_APPS);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}	
		
		return respuesta;
	}

	public static void actualizarDespacho(String cedula, String despacho){
		_SQL = 	"update ley_trans_usuarios set despacho_edita = '"+despacho+"' where numero_documento_edita ='"+cedula+"';"+
				"update ley_trans_funcionario_data set despacho = '"+despacho+"' where numero_documento ='"+cedula+"';"+
				"update ley_trans_publicaciones set despacho_usuario = '"+despacho+"' where fk_usuario ='"+cedula+"' and estatus ='PUBLICADO';";
		
		Context c = null;
		DataSource ds = null;
		Connection conection = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_APPS);
			conection = ds.getConnection();
			statement = conection.createStatement();
			statement.executeUpdate(_SQL);           
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_APPS+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_APPS);
		}finally{
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}		
	}

	public static List<modeloBasico> getUsuariosDisponiblesCambio(){
		List<modeloBasico> lista = new ArrayList<modeloBasico>();
		
		_SQL = 	"select u.userId,u.emailAddress "+
				"from user_ u join Users_Roles ur on u.userId=ur.userId and ur.roleId=65035228 "+
				"left join APPsPortal.dbo.ley_trans_usuarios ltu on u.userId = ltu.userid "+
				"where ltu.userid is null";
		
		Context c = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try 
		{			
			c = new InitialContext();
			ds = (DataSource) c.lookup(DATA_SOURCE_PORTAL);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(_SQL);
            if (result != null) {
                while (result.next()) {
                    modeloBasico aux = new modeloBasico(result.getString(1), result.getString(2));
                    lista.add(aux);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
		}
		catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY_TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_PORTAL+" Exeption:" + ex.getMessage() +" SQL: "+_SQL);
        } catch (NamingException e) {
        	System.out.println("Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_PORTAL);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}		
		
		return lista;
	}
	
}
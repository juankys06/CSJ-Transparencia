package com.co.csj.api;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.co.csj.persistence.PersistenceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

public class ConsultasApi {
	
	static String SQL = "";
	
	public static JSONArray getDepartamentos(){
		JSONArray respuesta = JSONFactoryUtil.createJSONArray();
		
		SQL =	"select NOMBRE,COD_DANE from ADM_LOCALIZACION where COD_DANE=COD_DANE_DEPARTAMENTO and ESTADO = 1 order by NOMBRE asc";
		
		try {
            ResultSet result = PersistenceUtil.realizaConsultaDespachos(SQL);
            if (result != null) {
                while (result.next()) {
                    JSONObject d = JSONFactoryUtil.createJSONObject();
                    d.put("nombre", result.getString(1));
                    d.put("codigo_departamento", result.getString(2));
                    respuesta.put(d);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error de conexion a la bd  " + ex.getMessage());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error  excepcion  " + ex);
        }	
		
		return respuesta;
	}
	
	public static JSONArray getMunicipios(String cod){
		JSONArray respuesta = JSONFactoryUtil.createJSONArray();
		
		SQL =	"select NOMBRE,COD_DANE_DEPARTAMENTO,COD_DANE from ADM_LOCALIZACION where COD_DANE!=COD_DANE_DEPARTAMENTO and NOMBRE!='' and ESTADO = 1 and COD_DANE_DEPARTAMENTO = '"+cod+"' order by NOMBRE asc";
		
		try {
            ResultSet result = PersistenceUtil.realizaConsultaDespachos(SQL);
            if (result != null) {
                while (result.next()) {
                    JSONObject d = JSONFactoryUtil.createJSONObject();
                    d.put("nombre", result.getString(1));
                    d.put("codigo_departamento", result.getString(2));
                    d.put("codigo_municipio", result.getString(3));
                    respuesta.put(d);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error de conexion a la bd  " + ex.getMessage());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error  excepcion  " + ex);
        }	
		
		return respuesta;
	}

	public static JSONArray getEntidadDepartametno(String cod){
		JSONArray respuesta = JSONFactoryUtil.createJSONArray();
		
		SQL = 	"select CODIGO,NOMBRE "+
				"from DESPACHO_PRU.dbo.ADM_ENTIDAD enti join  "+
				"( "+
				"select distinct(SUBSTRING(CODIGO,6,2)) col "+
				"from directorio_portal  "+
				"where SUBSTRING(CODIGO,1,2)='"+cod+"' "+
				") cod on enti.CODIGO = cod.col "+
				"ORDER BY NOMBRE ASC";
		
		try {
            ResultSet result = PersistenceUtil.realizaConsultaApps(SQL);
            if (result != null) {
                while (result.next()) {
                	String codi = result.getString(1);
                	if(result.getString(1).length()<2){
                		codi = "0"+result.getString(1);
                	}
                    JSONObject d = JSONFactoryUtil.createJSONObject();
                    d.put("codigo", codi);
                    d.put("nombre", result.getString(2));
                    respuesta.put(d);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error de conexion a la bd  " + ex.getMessage());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error  excepcion  " + ex);
        }
		
		return respuesta;
	}

	public static JSONArray getDespachosFiltro(String anhio,String dep, String mun, String enti, String espe){
		JSONArray respuesta = JSONFactoryUtil.createJSONArray();
		
		SQL = 	"select distinct(dp.codigo),dp.nombre,espe.nombre "+
				"from DIRECTORIO_PORTAL dp join ley_trans_publicaciones ltp on (dp.codigo = ltp.despacho_usuario and ltp.estatus = 'PUBLICADO') "+
				"join ley_trans_planificacion_anio ltpa on (ltp.anhio_publicacion = ltpa.anhio) "+
				"join DESPACHO_PRU.dbo.adm_especialidad espe on (substring(dp.codigo,8,2) = espe.CODIGO) "+
				"where 1=1 ";
		if(dep!=null)
			if(!dep.isEmpty() || !dep.equalsIgnoreCase("") || dep!=null)
				SQL += "and SUBSTRING(dp.CODIGO,1,2) = '"+dep+"' ";
		if(mun!=null)
			if(!mun.isEmpty() || !mun.equalsIgnoreCase("") || mun!=null)
				SQL += "and SUBSTRING(dp.CODIGO,3,3) = '"+mun+"' ";
		if(enti!=null)
			if(!enti.isEmpty() || !enti.equalsIgnoreCase("") || enti!=null)
				SQL += "and SUBSTRING(dp.CODIGO,6,2) in ("+enti+") ";
		if(espe!=null)
			if(!espe.isEmpty() || !espe.equalsIgnoreCase("") || espe!=null)
				SQL += "and SUBSTRING(dp.CODIGO,8,2) in ("+espe+") ";
		if(anhio!=null)
			if(!anhio.isEmpty() || !anhio.equalsIgnoreCase("") || anhio!=null)
				SQL += "and ltpa.anhio = '"+anhio+"' ";
		
		SQL+=" order by dp.nombre asc";
		
		try {
            ResultSet result = PersistenceUtil.realizaConsultaApps(SQL);
            if (result != null) {
                while (result.next()) {
                	JSONObject d = JSONFactoryUtil.createJSONObject();
                    d.put("codigo_despacho", result.getString(1));
                    d.put("nombre", result.getString(2));
                    d.put("especialidad", result.getString(3));
                    respuesta.put(d);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error de conexion a la bd  " + ex.getMessage());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error  excepcion  " + ex);
        }
		
		return respuesta;
	}

	public static JSONArray getFuncionariosDespacho(String anhio,String codigo){
		JSONArray respuesta = JSONFactoryUtil.createJSONArray();
		
		SQL = 	"select ltp.id "+
				"from ley_trans_publicaciones ltp join ley_trans_planificacion_anio ltpa on (ltp.anhio_publicacion=ltpa.anhio)"+
				"where ltp.estatus = 'PUBLICADO' ";
		
		if(!codigo.isEmpty() || !codigo.equalsIgnoreCase(""))
			SQL += "and ltp.despacho_usuario = '"+codigo+"' ";
		if(anhio!=null)
			if(!anhio.isEmpty() || !anhio.equalsIgnoreCase("") || anhio!=null)
				SQL += "and ltpa.anhio = '"+anhio+"' ";
		
		try {
            ResultSet result = PersistenceUtil.realizaConsultaApps(SQL);
            if (result != null) {
                while (result.next()) {
                	respuesta.put(result.getString(1));
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error de conexion a la bd  " + ex.getMessage());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error  excepcion  " + ex);
        }
		
		return respuesta;
	}
	
	public static JSONArray getAnhio(){
		JSONArray respuesta = JSONFactoryUtil.createJSONArray();
		
		SQL = 	"select anhio "+
				"from ley_trans_planificacion_anio "+
				"order by anhio desc ";
		
		try {
            ResultSet result = PersistenceUtil.realizaConsultaApps(SQL);
            if (result != null) {
                while (result.next()) {
                	JSONObject d = JSONFactoryUtil.createJSONObject();
                    d.put("anhio", result.getString(1));
                    respuesta.put(d);
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error de conexion a la bd  " + ex.getMessage());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error  excepcion  " + ex);
        }
		
		return respuesta;
	}
	
	
	
}
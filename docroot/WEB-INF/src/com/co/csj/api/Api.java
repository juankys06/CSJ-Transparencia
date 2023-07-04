package com.co.csj.api;

import com.co.csj.service.model.publicaciones;
import com.co.csj.service.model.usuario_data;
import com.co.csj.service.service.publicacionesLocalServiceUtil;
import com.co.csj.service.service.usuario_dataLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class Api {
	
	public static JSONArray getFuncionariosDespacho(String anhio,String cod){
		JSONArray respuesta = JSONFactoryUtil.createJSONArray();
		
		JSONArray ids = ConsultasApi.getFuncionariosDespacho(anhio,cod);
		
		for(int i=0; i<ids.length() ;i++){
			long id = ids.getLong(i);
			try {
				publicaciones publicacion = publicacionesLocalServiceUtil.getpublicaciones(id);
				usuario_data usuario = usuario_dataLocalServiceUtil.getusuario_data(publicacion.getFk_usuario());
//				JSONObject datosPersonales = JSONFactoryUtil.createJSONObject(usuario.getDatos_personales());
				String nombre = usuario.getNombres()+" "+usuario.getApellidos();
				nombre = nombre.replace("  ", " ");
				String retirado ="false";
				if(publicacion.getRetirado().equals("true"))
					retirado = "true";
				JSONObject p = JSONFactoryUtil.createJSONObject();
				p.put("nombre_funcionario", nombre.toUpperCase());
				p.put("id", id);
				p.put("cargo", publicacion.getCargo());
				p.put("retirado", retirado);
				respuesta.put(p);
			} catch (PortalException | SystemException e) {}
		}
		
		return respuesta;
	}
	
}

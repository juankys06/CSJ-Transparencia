package com.co.csj.registro;

import java.util.List;

import com.co.csj.service.model.usuario_data;
import com.co.csj.service.service.usuario_dataLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

public class validaciones {

	public boolean validarUsuario(String numero_documento) throws SystemException{
		boolean bandera = false;
			for(usuario_data u : usuario_dataLocalServiceUtil.getusuario_datas(-1, -1)){
				if(u.getNumeroDocumento().equalsIgnoreCase(numero_documento)){
					bandera = true;
				}
			}
		return bandera;
	}
	
	public static String generarClave(){
		String clave = "";
		

	    for (int i = 0; i < 7; i++)
	    {
	        if(i < 4)
	        {
	        	clave += (int) Math.floor(Math.random() * 10);
	        }
	        else
	        {
	        	clave += (char)((int) Math.floor(Math.random() * 26 + 65));
	        }
	    }
		
		return clave;
	}

	public static String generarletras(){
		String clave = "";
		

	    for (int i = 0; i < 3; i++)
	    {
	        clave += (char)((int) Math.floor(Math.random() * 26 + 97));
	    }
		
		return clave;
	}
}

/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.co.csj.service.service.impl;

import sun.security.krb5.internal.APOptions;

import com.co.csj.api.Api;
import com.co.csj.api.ConsultasApi;
import com.co.csj.service.service.base.servicioapileytransServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

/**
 * The implementation of the servicioapileytrans remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.co.csj.service.service.servicioapileytransService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Equipo
 * @see com.co.csj.service.service.base.servicioapileytransServiceBaseImpl
 * @see com.co.csj.service.service.servicioapileytransServiceUtil
 */
public class servicioapileytransServiceImpl
	extends servicioapileytransServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.co.csj.service.service.servicioapileytransServiceUtil} to access the servicioapileytrans remote service.
	 */
	@JSONWebService
	public JSONArray getDepartamentos() throws PortalException, SystemException{
		return ConsultasApi.getDepartamentos();
	}
	
	@JSONWebService
	public JSONArray getMunicipios(String codigo_departamento) throws PortalException, SystemException{
		return ConsultasApi.getMunicipios(codigo_departamento);
	}
	
	@JSONWebService
	public JSONArray getEntidadDepartamento(String codigo_departamento) throws PortalException, SystemException{
		return ConsultasApi.getEntidadDepartametno(codigo_departamento);
	}
	
	@JSONWebService
	public JSONArray getDespachosFiltro(String anhio,String departamento,String municipio,String entidad, String especialidad) throws PortalException, SystemException{
		return ConsultasApi.getDespachosFiltro(anhio,departamento, municipio, entidad, especialidad);
	}
	
	@JSONWebService
	public JSONArray getFuncionariosDespacho(String anhio,String codigo_despacho) throws PortalException, SystemException{
		return Api.getFuncionariosDespacho(anhio,codigo_despacho);
	}
	
	@JSONWebService
	public JSONArray getAnhios() throws PortalException, SystemException{
		return ConsultasApi.getAnhio();
	}
}
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

package com.co.csj.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link servicioapileytransService}.
 * </p>
 *
 * @author    Equipo
 * @see       servicioapileytransService
 * @generated
 */
public class servicioapileytransServiceWrapper
	implements servicioapileytransService,
		ServiceWrapper<servicioapileytransService> {
	public servicioapileytransServiceWrapper(
		servicioapileytransService servicioapileytransService) {
		_servicioapileytransService = servicioapileytransService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _servicioapileytransService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_servicioapileytransService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _servicioapileytransService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public com.liferay.portal.kernel.json.JSONArray getDepartamentos()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _servicioapileytransService.getDepartamentos();
	}

	public com.liferay.portal.kernel.json.JSONArray getMunicipios(
		java.lang.String codigo_departamento)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _servicioapileytransService.getMunicipios(codigo_departamento);
	}

	public com.liferay.portal.kernel.json.JSONArray getEntidadDepartamento(
		java.lang.String codigo_departamento)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _servicioapileytransService.getEntidadDepartamento(codigo_departamento);
	}

	public com.liferay.portal.kernel.json.JSONArray getDespachosFiltro(
		java.lang.String anhio, java.lang.String departamento,
		java.lang.String municipio, java.lang.String entidad,
		java.lang.String especialidad)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _servicioapileytransService.getDespachosFiltro(anhio,
			departamento, municipio, entidad, especialidad);
	}

	public com.liferay.portal.kernel.json.JSONArray getFuncionariosDespacho(
		java.lang.String anhio, java.lang.String codigo_despacho)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _servicioapileytransService.getFuncionariosDespacho(anhio,
			codigo_despacho);
	}

	public com.liferay.portal.kernel.json.JSONArray getAnhios()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _servicioapileytransService.getAnhios();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public servicioapileytransService getWrappedservicioapileytransService() {
		return _servicioapileytransService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedservicioapileytransService(
		servicioapileytransService servicioapileytransService) {
		_servicioapileytransService = servicioapileytransService;
	}

	public servicioapileytransService getWrappedService() {
		return _servicioapileytransService;
	}

	public void setWrappedService(
		servicioapileytransService servicioapileytransService) {
		_servicioapileytransService = servicioapileytransService;
	}

	private servicioapileytransService _servicioapileytransService;
}
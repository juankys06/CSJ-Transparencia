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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * The utility for the servicioapileytrans remote service. This utility wraps {@link com.co.csj.service.service.impl.servicioapileytransServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Equipo
 * @see servicioapileytransService
 * @see com.co.csj.service.service.base.servicioapileytransServiceBaseImpl
 * @see com.co.csj.service.service.impl.servicioapileytransServiceImpl
 * @generated
 */
public class servicioapileytransServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.co.csj.service.service.impl.servicioapileytransServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.portal.kernel.json.JSONArray getDepartamentos()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDepartamentos();
	}

	public static com.liferay.portal.kernel.json.JSONArray getMunicipios(
		java.lang.String codigo_departamento)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMunicipios(codigo_departamento);
	}

	public static com.liferay.portal.kernel.json.JSONArray getEntidadDepartamento(
		java.lang.String codigo_departamento)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEntidadDepartamento(codigo_departamento);
	}

	public static com.liferay.portal.kernel.json.JSONArray getDespachosFiltro(
		java.lang.String anhio, java.lang.String departamento,
		java.lang.String municipio, java.lang.String entidad,
		java.lang.String especialidad)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getDespachosFiltro(anhio, departamento, municipio, entidad,
			especialidad);
	}

	public static com.liferay.portal.kernel.json.JSONArray getFuncionariosDespacho(
		java.lang.String anhio, java.lang.String codigo_despacho)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFuncionariosDespacho(anhio, codigo_despacho);
	}

	public static com.liferay.portal.kernel.json.JSONArray getAnhios()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAnhios();
	}

	public static void clearService() {
		_service = null;
	}

	public static servicioapileytransService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					servicioapileytransService.class.getName());

			if (invokableService instanceof servicioapileytransService) {
				_service = (servicioapileytransService)invokableService;
			}
			else {
				_service = new servicioapileytransServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(servicioapileytransServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(servicioapileytransService service) {
	}

	private static servicioapileytransService _service;
}
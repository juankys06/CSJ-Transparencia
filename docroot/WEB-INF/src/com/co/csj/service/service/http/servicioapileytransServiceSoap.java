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

package com.co.csj.service.service.http;

import com.co.csj.service.service.servicioapileytransServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.co.csj.service.service.servicioapileytransServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    Equipo
 * @see       servicioapileytransServiceHttp
 * @see       com.co.csj.service.service.servicioapileytransServiceUtil
 * @generated
 */
public class servicioapileytransServiceSoap {
	public static java.lang.String getDepartamentos() throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = servicioapileytransServiceUtil.getDepartamentos();

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getMunicipios(
		java.lang.String codigo_departamento) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = servicioapileytransServiceUtil.getMunicipios(codigo_departamento);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getEntidadDepartamento(
		java.lang.String codigo_departamento) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = servicioapileytransServiceUtil.getEntidadDepartamento(codigo_departamento);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getDespachosFiltro(java.lang.String anhio,
		java.lang.String departamento, java.lang.String municipio,
		java.lang.String entidad, java.lang.String especialidad)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = servicioapileytransServiceUtil.getDespachosFiltro(anhio,
					departamento, municipio, entidad, especialidad);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getFuncionariosDespacho(
		java.lang.String anhio, java.lang.String codigo_despacho)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = servicioapileytransServiceUtil.getFuncionariosDespacho(anhio,
					codigo_despacho);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getAnhios() throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = servicioapileytransServiceUtil.getAnhios();

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(servicioapileytransServiceSoap.class);
}
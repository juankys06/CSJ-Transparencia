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
 * This class is a wrapper for {@link usuario_dataService}.
 * </p>
 *
 * @author    Equipo
 * @see       usuario_dataService
 * @generated
 */
public class usuario_dataServiceWrapper implements usuario_dataService,
	ServiceWrapper<usuario_dataService> {
	public usuario_dataServiceWrapper(usuario_dataService usuario_dataService) {
		_usuario_dataService = usuario_dataService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _usuario_dataService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_usuario_dataService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _usuario_dataService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public usuario_dataService getWrappedusuario_dataService() {
		return _usuario_dataService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedusuario_dataService(
		usuario_dataService usuario_dataService) {
		_usuario_dataService = usuario_dataService;
	}

	public usuario_dataService getWrappedService() {
		return _usuario_dataService;
	}

	public void setWrappedService(usuario_dataService usuario_dataService) {
		_usuario_dataService = usuario_dataService;
	}

	private usuario_dataService _usuario_dataService;
}
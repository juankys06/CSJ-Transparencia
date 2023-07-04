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


import com.co.csj.service.NoSuchcorreosException;
import com.co.csj.service.model.correos;
import com.co.csj.service.service.base.correosLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the correos local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.co.csj.service.service.correosLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Equipo
 * @see com.co.csj.service.service.base.correosLocalServiceBaseImpl
 * @see com.co.csj.service.service.correosLocalServiceUtil
 */
public class correosLocalServiceImpl extends correosLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.co.csj.service.service.correosLocalServiceUtil} to access the correos local service.
	 */
	
	public correos PorCorreoCedula(String correo, String cedula) throws NoSuchcorreosException, SystemException{
		return correosPersistence.findByPorCorreoCedula(correo, cedula);
	}
	public correos PorCorreo(String correo) throws NoSuchcorreosException, SystemException{
		return correosPersistence.findByPorCorreo(correo);
	}
}
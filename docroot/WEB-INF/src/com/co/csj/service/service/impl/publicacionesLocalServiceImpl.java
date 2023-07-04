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

import java.util.List;

import com.co.csj.service.model.publicaciones;
import com.co.csj.service.service.base.publicacionesLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the publicaciones local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.co.csj.service.service.publicacionesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Equipo
 * @see com.co.csj.service.service.base.publicacionesLocalServiceBaseImpl
 * @see com.co.csj.service.service.publicacionesLocalServiceUtil
 */
public class publicacionesLocalServiceImpl
	extends publicacionesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.co.csj.service.service.publicacionesLocalServiceUtil} to access the publicaciones local service.
	 */
	
	public publicaciones getPorEstadoUsuario(String cedula,int ano, String estado) throws SystemException{
		return publicacionesPersistence.fetchByPorEstadoUsuario(cedula,ano,estado);
	}
	
	public List<publicaciones> getPorEstadoSolicitudes(String estado, int anhio) throws SystemException{
		return publicacionesPersistence.findByPorEstadoSolicitudes(estado, anhio);
	}
}
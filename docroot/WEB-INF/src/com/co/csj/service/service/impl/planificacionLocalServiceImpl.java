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

import com.co.csj.service.model.planificacion;
import com.co.csj.service.service.base.planificacionLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the planificacion local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.co.csj.service.service.planificacionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Equipo
 * @see com.co.csj.service.service.base.planificacionLocalServiceBaseImpl
 * @see com.co.csj.service.service.planificacionLocalServiceUtil
 */
public class planificacionLocalServiceImpl
	extends planificacionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.co.csj.service.service.planificacionLocalServiceUtil} to access the planificacion local service.
	 */
	
	public planificacion PorEstado(String estado) throws SystemException{
		return planificacionPersistence.fetchByPorEstado(estado);
	}
}
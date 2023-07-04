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

package com.co.csj.service.model.impl;

import com.co.csj.service.model.publicaciones;
import com.co.csj.service.service.publicacionesLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the publicaciones service. Represents a row in the &quot;ley_trans_publicaciones&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link publicacionesImpl}.
 * </p>
 *
 * @author Equipo
 * @see publicacionesImpl
 * @see com.co.csj.service.model.publicaciones
 * @generated
 */
public abstract class publicacionesBaseImpl extends publicacionesModelImpl
	implements publicaciones {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a publicaciones model instance should use the {@link publicaciones} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			publicacionesLocalServiceUtil.addpublicaciones(this);
		}
		else {
			publicacionesLocalServiceUtil.updatepublicaciones(this);
		}
	}
}
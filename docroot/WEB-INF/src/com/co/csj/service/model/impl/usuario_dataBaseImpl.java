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

import com.co.csj.service.model.usuario_data;
import com.co.csj.service.service.usuario_dataLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the usuario_data service. Represents a row in the &quot;ley_trans_funcionario_data&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link usuario_dataImpl}.
 * </p>
 *
 * @author Equipo
 * @see usuario_dataImpl
 * @see com.co.csj.service.model.usuario_data
 * @generated
 */
public abstract class usuario_dataBaseImpl extends usuario_dataModelImpl
	implements usuario_data {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a usuario_data model instance should use the {@link usuario_data} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			usuario_dataLocalServiceUtil.addusuario_data(this);
		}
		else {
			usuario_dataLocalServiceUtil.updateusuario_data(this);
		}
	}
}
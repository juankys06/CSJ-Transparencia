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

package com.co.csj.service.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the correos service. Represents a row in the &quot;ley_trans_correos_depurado&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.co.csj.service.model.impl.correosModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.co.csj.service.model.impl.correosImpl}.
 * </p>
 *
 * @author Equipo
 * @see correos
 * @see com.co.csj.service.model.impl.correosImpl
 * @see com.co.csj.service.model.impl.correosModelImpl
 * @generated
 */
public interface correosModel extends BaseModel<correos> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a correos model instance should use the {@link correos} interface instead.
	 */

	/**
	 * Returns the primary key of this correos.
	 *
	 * @return the primary key of this correos
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this correos.
	 *
	 * @param primaryKey the primary key of this correos
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this correos.
	 *
	 * @return the ID of this correos
	 */
	public long getId();

	/**
	 * Sets the ID of this correos.
	 *
	 * @param id the ID of this correos
	 */
	public void setId(long id);

	/**
	 * Returns the cuenta correo of this correos.
	 *
	 * @return the cuenta correo of this correos
	 */
	@AutoEscape
	public String getCuentaCorreo();

	/**
	 * Sets the cuenta correo of this correos.
	 *
	 * @param cuentaCorreo the cuenta correo of this correos
	 */
	public void setCuentaCorreo(String cuentaCorreo);

	/**
	 * Returns the nombre1 of this correos.
	 *
	 * @return the nombre1 of this correos
	 */
	@AutoEscape
	public String getNombre1();

	/**
	 * Sets the nombre1 of this correos.
	 *
	 * @param nombre1 the nombre1 of this correos
	 */
	public void setNombre1(String nombre1);

	/**
	 * Returns the apellido of this correos.
	 *
	 * @return the apellido of this correos
	 */
	@AutoEscape
	public String getApellido();

	/**
	 * Sets the apellido of this correos.
	 *
	 * @param apellido the apellido of this correos
	 */
	public void setApellido(String apellido);

	/**
	 * Returns the cargo of this correos.
	 *
	 * @return the cargo of this correos
	 */
	@AutoEscape
	public String getCargo();

	/**
	 * Sets the cargo of this correos.
	 *
	 * @param cargo the cargo of this correos
	 */
	public void setCargo(String cargo);

	/**
	 * Returns the cedula responsable of this correos.
	 *
	 * @return the cedula responsable of this correos
	 */
	@AutoEscape
	public String getCedulaResponsable();

	/**
	 * Sets the cedula responsable of this correos.
	 *
	 * @param cedulaResponsable the cedula responsable of this correos
	 */
	public void setCedulaResponsable(String cedulaResponsable);

	/**
	 * Returns the codigo despacho of this correos.
	 *
	 * @return the codigo despacho of this correos
	 */
	@AutoEscape
	public String getCodigoDespacho();

	/**
	 * Sets the codigo despacho of this correos.
	 *
	 * @param codigoDespacho the codigo despacho of this correos
	 */
	public void setCodigoDespacho(String codigoDespacho);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(correos correos);

	public int hashCode();

	public CacheModel<correos> toCacheModel();

	public correos toEscapedModel();

	public String toString();

	public String toXmlString();
}
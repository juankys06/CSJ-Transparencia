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

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link correos}.
 * </p>
 *
 * @author    Equipo
 * @see       correos
 * @generated
 */
public class correosWrapper implements correos, ModelWrapper<correos> {
	public correosWrapper(correos correos) {
		_correos = correos;
	}

	public Class<?> getModelClass() {
		return correos.class;
	}

	public String getModelClassName() {
		return correos.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("cuentaCorreo", getCuentaCorreo());
		attributes.put("nombre1", getNombre1());
		attributes.put("apellido", getApellido());
		attributes.put("cargo", getCargo());
		attributes.put("cedulaResponsable", getCedulaResponsable());
		attributes.put("codigoDespacho", getCodigoDespacho());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String cuentaCorreo = (String)attributes.get("cuentaCorreo");

		if (cuentaCorreo != null) {
			setCuentaCorreo(cuentaCorreo);
		}

		String nombre1 = (String)attributes.get("nombre1");

		if (nombre1 != null) {
			setNombre1(nombre1);
		}

		String apellido = (String)attributes.get("apellido");

		if (apellido != null) {
			setApellido(apellido);
		}

		String cargo = (String)attributes.get("cargo");

		if (cargo != null) {
			setCargo(cargo);
		}

		String cedulaResponsable = (String)attributes.get("cedulaResponsable");

		if (cedulaResponsable != null) {
			setCedulaResponsable(cedulaResponsable);
		}

		String codigoDespacho = (String)attributes.get("codigoDespacho");

		if (codigoDespacho != null) {
			setCodigoDespacho(codigoDespacho);
		}
	}

	/**
	* Returns the primary key of this correos.
	*
	* @return the primary key of this correos
	*/
	public long getPrimaryKey() {
		return _correos.getPrimaryKey();
	}

	/**
	* Sets the primary key of this correos.
	*
	* @param primaryKey the primary key of this correos
	*/
	public void setPrimaryKey(long primaryKey) {
		_correos.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this correos.
	*
	* @return the ID of this correos
	*/
	public long getId() {
		return _correos.getId();
	}

	/**
	* Sets the ID of this correos.
	*
	* @param id the ID of this correos
	*/
	public void setId(long id) {
		_correos.setId(id);
	}

	/**
	* Returns the cuenta correo of this correos.
	*
	* @return the cuenta correo of this correos
	*/
	public java.lang.String getCuentaCorreo() {
		return _correos.getCuentaCorreo();
	}

	/**
	* Sets the cuenta correo of this correos.
	*
	* @param cuentaCorreo the cuenta correo of this correos
	*/
	public void setCuentaCorreo(java.lang.String cuentaCorreo) {
		_correos.setCuentaCorreo(cuentaCorreo);
	}

	/**
	* Returns the nombre1 of this correos.
	*
	* @return the nombre1 of this correos
	*/
	public java.lang.String getNombre1() {
		return _correos.getNombre1();
	}

	/**
	* Sets the nombre1 of this correos.
	*
	* @param nombre1 the nombre1 of this correos
	*/
	public void setNombre1(java.lang.String nombre1) {
		_correos.setNombre1(nombre1);
	}

	/**
	* Returns the apellido of this correos.
	*
	* @return the apellido of this correos
	*/
	public java.lang.String getApellido() {
		return _correos.getApellido();
	}

	/**
	* Sets the apellido of this correos.
	*
	* @param apellido the apellido of this correos
	*/
	public void setApellido(java.lang.String apellido) {
		_correos.setApellido(apellido);
	}

	/**
	* Returns the cargo of this correos.
	*
	* @return the cargo of this correos
	*/
	public java.lang.String getCargo() {
		return _correos.getCargo();
	}

	/**
	* Sets the cargo of this correos.
	*
	* @param cargo the cargo of this correos
	*/
	public void setCargo(java.lang.String cargo) {
		_correos.setCargo(cargo);
	}

	/**
	* Returns the cedula responsable of this correos.
	*
	* @return the cedula responsable of this correos
	*/
	public java.lang.String getCedulaResponsable() {
		return _correos.getCedulaResponsable();
	}

	/**
	* Sets the cedula responsable of this correos.
	*
	* @param cedulaResponsable the cedula responsable of this correos
	*/
	public void setCedulaResponsable(java.lang.String cedulaResponsable) {
		_correos.setCedulaResponsable(cedulaResponsable);
	}

	/**
	* Returns the codigo despacho of this correos.
	*
	* @return the codigo despacho of this correos
	*/
	public java.lang.String getCodigoDespacho() {
		return _correos.getCodigoDespacho();
	}

	/**
	* Sets the codigo despacho of this correos.
	*
	* @param codigoDespacho the codigo despacho of this correos
	*/
	public void setCodigoDespacho(java.lang.String codigoDespacho) {
		_correos.setCodigoDespacho(codigoDespacho);
	}

	public boolean isNew() {
		return _correos.isNew();
	}

	public void setNew(boolean n) {
		_correos.setNew(n);
	}

	public boolean isCachedModel() {
		return _correos.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_correos.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _correos.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _correos.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_correos.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _correos.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_correos.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new correosWrapper((correos)_correos.clone());
	}

	public int compareTo(com.co.csj.service.model.correos correos) {
		return _correos.compareTo(correos);
	}

	@Override
	public int hashCode() {
		return _correos.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.co.csj.service.model.correos> toCacheModel() {
		return _correos.toCacheModel();
	}

	public com.co.csj.service.model.correos toEscapedModel() {
		return new correosWrapper(_correos.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _correos.toString();
	}

	public java.lang.String toXmlString() {
		return _correos.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_correos.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public correos getWrappedcorreos() {
		return _correos;
	}

	public correos getWrappedModel() {
		return _correos;
	}

	public void resetOriginalValues() {
		_correos.resetOriginalValues();
	}

	private correos _correos;
}
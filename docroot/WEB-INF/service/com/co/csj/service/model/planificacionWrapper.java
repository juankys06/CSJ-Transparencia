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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link planificacion}.
 * </p>
 *
 * @author    Equipo
 * @see       planificacion
 * @generated
 */
public class planificacionWrapper implements planificacion,
	ModelWrapper<planificacion> {
	public planificacionWrapper(planificacion planificacion) {
		_planificacion = planificacion;
	}

	public Class<?> getModelClass() {
		return planificacion.class;
	}

	public String getModelClassName() {
		return planificacion.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("anhio", getAnhio());
		attributes.put("fecha_inicio", getFecha_inicio());
		attributes.put("fecha_fin", getFecha_fin());
		attributes.put("usuario_finalizo", getUsuario_finalizo());
		attributes.put("estado", getEstado());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Integer anhio = (Integer)attributes.get("anhio");

		if (anhio != null) {
			setAnhio(anhio);
		}

		Date fecha_inicio = (Date)attributes.get("fecha_inicio");

		if (fecha_inicio != null) {
			setFecha_inicio(fecha_inicio);
		}

		Date fecha_fin = (Date)attributes.get("fecha_fin");

		if (fecha_fin != null) {
			setFecha_fin(fecha_fin);
		}

		String usuario_finalizo = (String)attributes.get("usuario_finalizo");

		if (usuario_finalizo != null) {
			setUsuario_finalizo(usuario_finalizo);
		}

		String estado = (String)attributes.get("estado");

		if (estado != null) {
			setEstado(estado);
		}
	}

	/**
	* Returns the primary key of this planificacion.
	*
	* @return the primary key of this planificacion
	*/
	public long getPrimaryKey() {
		return _planificacion.getPrimaryKey();
	}

	/**
	* Sets the primary key of this planificacion.
	*
	* @param primaryKey the primary key of this planificacion
	*/
	public void setPrimaryKey(long primaryKey) {
		_planificacion.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this planificacion.
	*
	* @return the ID of this planificacion
	*/
	public long getId() {
		return _planificacion.getId();
	}

	/**
	* Sets the ID of this planificacion.
	*
	* @param id the ID of this planificacion
	*/
	public void setId(long id) {
		_planificacion.setId(id);
	}

	/**
	* Returns the anhio of this planificacion.
	*
	* @return the anhio of this planificacion
	*/
	public int getAnhio() {
		return _planificacion.getAnhio();
	}

	/**
	* Sets the anhio of this planificacion.
	*
	* @param anhio the anhio of this planificacion
	*/
	public void setAnhio(int anhio) {
		_planificacion.setAnhio(anhio);
	}

	/**
	* Returns the fecha_inicio of this planificacion.
	*
	* @return the fecha_inicio of this planificacion
	*/
	public java.util.Date getFecha_inicio() {
		return _planificacion.getFecha_inicio();
	}

	/**
	* Sets the fecha_inicio of this planificacion.
	*
	* @param fecha_inicio the fecha_inicio of this planificacion
	*/
	public void setFecha_inicio(java.util.Date fecha_inicio) {
		_planificacion.setFecha_inicio(fecha_inicio);
	}

	/**
	* Returns the fecha_fin of this planificacion.
	*
	* @return the fecha_fin of this planificacion
	*/
	public java.util.Date getFecha_fin() {
		return _planificacion.getFecha_fin();
	}

	/**
	* Sets the fecha_fin of this planificacion.
	*
	* @param fecha_fin the fecha_fin of this planificacion
	*/
	public void setFecha_fin(java.util.Date fecha_fin) {
		_planificacion.setFecha_fin(fecha_fin);
	}

	/**
	* Returns the usuario_finalizo of this planificacion.
	*
	* @return the usuario_finalizo of this planificacion
	*/
	public java.lang.String getUsuario_finalizo() {
		return _planificacion.getUsuario_finalizo();
	}

	/**
	* Sets the usuario_finalizo of this planificacion.
	*
	* @param usuario_finalizo the usuario_finalizo of this planificacion
	*/
	public void setUsuario_finalizo(java.lang.String usuario_finalizo) {
		_planificacion.setUsuario_finalizo(usuario_finalizo);
	}

	/**
	* Returns the estado of this planificacion.
	*
	* @return the estado of this planificacion
	*/
	public java.lang.String getEstado() {
		return _planificacion.getEstado();
	}

	/**
	* Sets the estado of this planificacion.
	*
	* @param estado the estado of this planificacion
	*/
	public void setEstado(java.lang.String estado) {
		_planificacion.setEstado(estado);
	}

	public boolean isNew() {
		return _planificacion.isNew();
	}

	public void setNew(boolean n) {
		_planificacion.setNew(n);
	}

	public boolean isCachedModel() {
		return _planificacion.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_planificacion.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _planificacion.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _planificacion.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_planificacion.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _planificacion.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_planificacion.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new planificacionWrapper((planificacion)_planificacion.clone());
	}

	public int compareTo(com.co.csj.service.model.planificacion planificacion) {
		return _planificacion.compareTo(planificacion);
	}

	@Override
	public int hashCode() {
		return _planificacion.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.co.csj.service.model.planificacion> toCacheModel() {
		return _planificacion.toCacheModel();
	}

	public com.co.csj.service.model.planificacion toEscapedModel() {
		return new planificacionWrapper(_planificacion.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _planificacion.toString();
	}

	public java.lang.String toXmlString() {
		return _planificacion.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_planificacion.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public planificacion getWrappedplanificacion() {
		return _planificacion;
	}

	public planificacion getWrappedModel() {
		return _planificacion;
	}

	public void resetOriginalValues() {
		_planificacion.resetOriginalValues();
	}

	private planificacion _planificacion;
}
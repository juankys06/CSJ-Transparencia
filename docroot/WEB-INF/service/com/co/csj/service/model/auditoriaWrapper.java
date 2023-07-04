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
 * This class is a wrapper for {@link auditoria}.
 * </p>
 *
 * @author    Equipo
 * @see       auditoria
 * @generated
 */
public class auditoriaWrapper implements auditoria, ModelWrapper<auditoria> {
	public auditoriaWrapper(auditoria auditoria) {
		_auditoria = auditoria;
	}

	public Class<?> getModelClass() {
		return auditoria.class;
	}

	public String getModelClassName() {
		return auditoria.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("modificado_por", getModificado_por());
		attributes.put("accion", getAccion());
		attributes.put("campo_modifico", getCampo_modifico());
		attributes.put("fecha", getFecha());
		attributes.put("ano_vigencia", getAno_vigencia());
		attributes.put("cedula_funcionario", getCedula_funcionario());
		attributes.put("log_anterior", getLog_anterior());
		attributes.put("log_nuevo", getLog_nuevo());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String modificado_por = (String)attributes.get("modificado_por");

		if (modificado_por != null) {
			setModificado_por(modificado_por);
		}

		String accion = (String)attributes.get("accion");

		if (accion != null) {
			setAccion(accion);
		}

		String campo_modifico = (String)attributes.get("campo_modifico");

		if (campo_modifico != null) {
			setCampo_modifico(campo_modifico);
		}

		Date fecha = (Date)attributes.get("fecha");

		if (fecha != null) {
			setFecha(fecha);
		}

		Integer ano_vigencia = (Integer)attributes.get("ano_vigencia");

		if (ano_vigencia != null) {
			setAno_vigencia(ano_vigencia);
		}

		String cedula_funcionario = (String)attributes.get("cedula_funcionario");

		if (cedula_funcionario != null) {
			setCedula_funcionario(cedula_funcionario);
		}

		String log_anterior = (String)attributes.get("log_anterior");

		if (log_anterior != null) {
			setLog_anterior(log_anterior);
		}

		String log_nuevo = (String)attributes.get("log_nuevo");

		if (log_nuevo != null) {
			setLog_nuevo(log_nuevo);
		}
	}

	/**
	* Returns the primary key of this auditoria.
	*
	* @return the primary key of this auditoria
	*/
	public long getPrimaryKey() {
		return _auditoria.getPrimaryKey();
	}

	/**
	* Sets the primary key of this auditoria.
	*
	* @param primaryKey the primary key of this auditoria
	*/
	public void setPrimaryKey(long primaryKey) {
		_auditoria.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this auditoria.
	*
	* @return the ID of this auditoria
	*/
	public long getId() {
		return _auditoria.getId();
	}

	/**
	* Sets the ID of this auditoria.
	*
	* @param id the ID of this auditoria
	*/
	public void setId(long id) {
		_auditoria.setId(id);
	}

	/**
	* Returns the modificado_por of this auditoria.
	*
	* @return the modificado_por of this auditoria
	*/
	public java.lang.String getModificado_por() {
		return _auditoria.getModificado_por();
	}

	/**
	* Sets the modificado_por of this auditoria.
	*
	* @param modificado_por the modificado_por of this auditoria
	*/
	public void setModificado_por(java.lang.String modificado_por) {
		_auditoria.setModificado_por(modificado_por);
	}

	/**
	* Returns the accion of this auditoria.
	*
	* @return the accion of this auditoria
	*/
	public java.lang.String getAccion() {
		return _auditoria.getAccion();
	}

	/**
	* Sets the accion of this auditoria.
	*
	* @param accion the accion of this auditoria
	*/
	public void setAccion(java.lang.String accion) {
		_auditoria.setAccion(accion);
	}

	/**
	* Returns the campo_modifico of this auditoria.
	*
	* @return the campo_modifico of this auditoria
	*/
	public java.lang.String getCampo_modifico() {
		return _auditoria.getCampo_modifico();
	}

	/**
	* Sets the campo_modifico of this auditoria.
	*
	* @param campo_modifico the campo_modifico of this auditoria
	*/
	public void setCampo_modifico(java.lang.String campo_modifico) {
		_auditoria.setCampo_modifico(campo_modifico);
	}

	/**
	* Returns the fecha of this auditoria.
	*
	* @return the fecha of this auditoria
	*/
	public java.util.Date getFecha() {
		return _auditoria.getFecha();
	}

	/**
	* Sets the fecha of this auditoria.
	*
	* @param fecha the fecha of this auditoria
	*/
	public void setFecha(java.util.Date fecha) {
		_auditoria.setFecha(fecha);
	}

	/**
	* Returns the ano_vigencia of this auditoria.
	*
	* @return the ano_vigencia of this auditoria
	*/
	public int getAno_vigencia() {
		return _auditoria.getAno_vigencia();
	}

	/**
	* Sets the ano_vigencia of this auditoria.
	*
	* @param ano_vigencia the ano_vigencia of this auditoria
	*/
	public void setAno_vigencia(int ano_vigencia) {
		_auditoria.setAno_vigencia(ano_vigencia);
	}

	/**
	* Returns the cedula_funcionario of this auditoria.
	*
	* @return the cedula_funcionario of this auditoria
	*/
	public java.lang.String getCedula_funcionario() {
		return _auditoria.getCedula_funcionario();
	}

	/**
	* Sets the cedula_funcionario of this auditoria.
	*
	* @param cedula_funcionario the cedula_funcionario of this auditoria
	*/
	public void setCedula_funcionario(java.lang.String cedula_funcionario) {
		_auditoria.setCedula_funcionario(cedula_funcionario);
	}

	/**
	* Returns the log_anterior of this auditoria.
	*
	* @return the log_anterior of this auditoria
	*/
	public java.lang.String getLog_anterior() {
		return _auditoria.getLog_anterior();
	}

	/**
	* Sets the log_anterior of this auditoria.
	*
	* @param log_anterior the log_anterior of this auditoria
	*/
	public void setLog_anterior(java.lang.String log_anterior) {
		_auditoria.setLog_anterior(log_anterior);
	}

	/**
	* Returns the log_nuevo of this auditoria.
	*
	* @return the log_nuevo of this auditoria
	*/
	public java.lang.String getLog_nuevo() {
		return _auditoria.getLog_nuevo();
	}

	/**
	* Sets the log_nuevo of this auditoria.
	*
	* @param log_nuevo the log_nuevo of this auditoria
	*/
	public void setLog_nuevo(java.lang.String log_nuevo) {
		_auditoria.setLog_nuevo(log_nuevo);
	}

	public boolean isNew() {
		return _auditoria.isNew();
	}

	public void setNew(boolean n) {
		_auditoria.setNew(n);
	}

	public boolean isCachedModel() {
		return _auditoria.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_auditoria.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _auditoria.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _auditoria.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_auditoria.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _auditoria.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_auditoria.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new auditoriaWrapper((auditoria)_auditoria.clone());
	}

	public int compareTo(com.co.csj.service.model.auditoria auditoria) {
		return _auditoria.compareTo(auditoria);
	}

	@Override
	public int hashCode() {
		return _auditoria.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.co.csj.service.model.auditoria> toCacheModel() {
		return _auditoria.toCacheModel();
	}

	public com.co.csj.service.model.auditoria toEscapedModel() {
		return new auditoriaWrapper(_auditoria.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _auditoria.toString();
	}

	public java.lang.String toXmlString() {
		return _auditoria.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_auditoria.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public auditoria getWrappedauditoria() {
		return _auditoria;
	}

	public auditoria getWrappedModel() {
		return _auditoria;
	}

	public void resetOriginalValues() {
		_auditoria.resetOriginalValues();
	}

	private auditoria _auditoria;
}
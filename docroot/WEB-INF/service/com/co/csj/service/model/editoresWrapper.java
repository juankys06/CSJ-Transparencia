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
 * This class is a wrapper for {@link editores}.
 * </p>
 *
 * @author    Equipo
 * @see       editores
 * @generated
 */
public class editoresWrapper implements editores, ModelWrapper<editores> {
	public editoresWrapper(editores editores) {
		_editores = editores;
	}

	public Class<?> getModelClass() {
		return editores.class;
	}

	public String getModelClassName() {
		return editores.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("correo", getCorreo());
		attributes.put("codigo", getCodigo());
		attributes.put("fecha_creado", getFecha_creado());
		attributes.put("fecha_modificado", getFecha_modificado());
		attributes.put("ultimo_inicio", getUltimo_inicio());
		attributes.put("nombres_edita", getNombres_edita());
		attributes.put("apellidos_edita", getApellidos_edita());
		attributes.put("numero_documento_edita", getNumero_documento_edita());
		attributes.put("tipo_documento_edita", getTipo_documento_edita());
		attributes.put("cargo_edita", getCargo_edita());
		attributes.put("despacho_edita", getDespacho_edita());
		attributes.put("userid", getUserid());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String correo = (String)attributes.get("correo");

		if (correo != null) {
			setCorreo(correo);
		}

		String codigo = (String)attributes.get("codigo");

		if (codigo != null) {
			setCodigo(codigo);
		}

		Date fecha_creado = (Date)attributes.get("fecha_creado");

		if (fecha_creado != null) {
			setFecha_creado(fecha_creado);
		}

		Date fecha_modificado = (Date)attributes.get("fecha_modificado");

		if (fecha_modificado != null) {
			setFecha_modificado(fecha_modificado);
		}

		Date ultimo_inicio = (Date)attributes.get("ultimo_inicio");

		if (ultimo_inicio != null) {
			setUltimo_inicio(ultimo_inicio);
		}

		String nombres_edita = (String)attributes.get("nombres_edita");

		if (nombres_edita != null) {
			setNombres_edita(nombres_edita);
		}

		String apellidos_edita = (String)attributes.get("apellidos_edita");

		if (apellidos_edita != null) {
			setApellidos_edita(apellidos_edita);
		}

		String numero_documento_edita = (String)attributes.get(
				"numero_documento_edita");

		if (numero_documento_edita != null) {
			setNumero_documento_edita(numero_documento_edita);
		}

		String tipo_documento_edita = (String)attributes.get(
				"tipo_documento_edita");

		if (tipo_documento_edita != null) {
			setTipo_documento_edita(tipo_documento_edita);
		}

		String cargo_edita = (String)attributes.get("cargo_edita");

		if (cargo_edita != null) {
			setCargo_edita(cargo_edita);
		}

		String despacho_edita = (String)attributes.get("despacho_edita");

		if (despacho_edita != null) {
			setDespacho_edita(despacho_edita);
		}

		String userid = (String)attributes.get("userid");

		if (userid != null) {
			setUserid(userid);
		}
	}

	/**
	* Returns the primary key of this editores.
	*
	* @return the primary key of this editores
	*/
	public long getPrimaryKey() {
		return _editores.getPrimaryKey();
	}

	/**
	* Sets the primary key of this editores.
	*
	* @param primaryKey the primary key of this editores
	*/
	public void setPrimaryKey(long primaryKey) {
		_editores.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this editores.
	*
	* @return the ID of this editores
	*/
	public long getId() {
		return _editores.getId();
	}

	/**
	* Sets the ID of this editores.
	*
	* @param id the ID of this editores
	*/
	public void setId(long id) {
		_editores.setId(id);
	}

	/**
	* Returns the correo of this editores.
	*
	* @return the correo of this editores
	*/
	public java.lang.String getCorreo() {
		return _editores.getCorreo();
	}

	/**
	* Sets the correo of this editores.
	*
	* @param correo the correo of this editores
	*/
	public void setCorreo(java.lang.String correo) {
		_editores.setCorreo(correo);
	}

	/**
	* Returns the codigo of this editores.
	*
	* @return the codigo of this editores
	*/
	public java.lang.String getCodigo() {
		return _editores.getCodigo();
	}

	/**
	* Sets the codigo of this editores.
	*
	* @param codigo the codigo of this editores
	*/
	public void setCodigo(java.lang.String codigo) {
		_editores.setCodigo(codigo);
	}

	/**
	* Returns the fecha_creado of this editores.
	*
	* @return the fecha_creado of this editores
	*/
	public java.util.Date getFecha_creado() {
		return _editores.getFecha_creado();
	}

	/**
	* Sets the fecha_creado of this editores.
	*
	* @param fecha_creado the fecha_creado of this editores
	*/
	public void setFecha_creado(java.util.Date fecha_creado) {
		_editores.setFecha_creado(fecha_creado);
	}

	/**
	* Returns the fecha_modificado of this editores.
	*
	* @return the fecha_modificado of this editores
	*/
	public java.util.Date getFecha_modificado() {
		return _editores.getFecha_modificado();
	}

	/**
	* Sets the fecha_modificado of this editores.
	*
	* @param fecha_modificado the fecha_modificado of this editores
	*/
	public void setFecha_modificado(java.util.Date fecha_modificado) {
		_editores.setFecha_modificado(fecha_modificado);
	}

	/**
	* Returns the ultimo_inicio of this editores.
	*
	* @return the ultimo_inicio of this editores
	*/
	public java.util.Date getUltimo_inicio() {
		return _editores.getUltimo_inicio();
	}

	/**
	* Sets the ultimo_inicio of this editores.
	*
	* @param ultimo_inicio the ultimo_inicio of this editores
	*/
	public void setUltimo_inicio(java.util.Date ultimo_inicio) {
		_editores.setUltimo_inicio(ultimo_inicio);
	}

	/**
	* Returns the nombres_edita of this editores.
	*
	* @return the nombres_edita of this editores
	*/
	public java.lang.String getNombres_edita() {
		return _editores.getNombres_edita();
	}

	/**
	* Sets the nombres_edita of this editores.
	*
	* @param nombres_edita the nombres_edita of this editores
	*/
	public void setNombres_edita(java.lang.String nombres_edita) {
		_editores.setNombres_edita(nombres_edita);
	}

	/**
	* Returns the apellidos_edita of this editores.
	*
	* @return the apellidos_edita of this editores
	*/
	public java.lang.String getApellidos_edita() {
		return _editores.getApellidos_edita();
	}

	/**
	* Sets the apellidos_edita of this editores.
	*
	* @param apellidos_edita the apellidos_edita of this editores
	*/
	public void setApellidos_edita(java.lang.String apellidos_edita) {
		_editores.setApellidos_edita(apellidos_edita);
	}

	/**
	* Returns the numero_documento_edita of this editores.
	*
	* @return the numero_documento_edita of this editores
	*/
	public java.lang.String getNumero_documento_edita() {
		return _editores.getNumero_documento_edita();
	}

	/**
	* Sets the numero_documento_edita of this editores.
	*
	* @param numero_documento_edita the numero_documento_edita of this editores
	*/
	public void setNumero_documento_edita(
		java.lang.String numero_documento_edita) {
		_editores.setNumero_documento_edita(numero_documento_edita);
	}

	/**
	* Returns the tipo_documento_edita of this editores.
	*
	* @return the tipo_documento_edita of this editores
	*/
	public java.lang.String getTipo_documento_edita() {
		return _editores.getTipo_documento_edita();
	}

	/**
	* Sets the tipo_documento_edita of this editores.
	*
	* @param tipo_documento_edita the tipo_documento_edita of this editores
	*/
	public void setTipo_documento_edita(java.lang.String tipo_documento_edita) {
		_editores.setTipo_documento_edita(tipo_documento_edita);
	}

	/**
	* Returns the cargo_edita of this editores.
	*
	* @return the cargo_edita of this editores
	*/
	public java.lang.String getCargo_edita() {
		return _editores.getCargo_edita();
	}

	/**
	* Sets the cargo_edita of this editores.
	*
	* @param cargo_edita the cargo_edita of this editores
	*/
	public void setCargo_edita(java.lang.String cargo_edita) {
		_editores.setCargo_edita(cargo_edita);
	}

	/**
	* Returns the despacho_edita of this editores.
	*
	* @return the despacho_edita of this editores
	*/
	public java.lang.String getDespacho_edita() {
		return _editores.getDespacho_edita();
	}

	/**
	* Sets the despacho_edita of this editores.
	*
	* @param despacho_edita the despacho_edita of this editores
	*/
	public void setDespacho_edita(java.lang.String despacho_edita) {
		_editores.setDespacho_edita(despacho_edita);
	}

	/**
	* Returns the userid of this editores.
	*
	* @return the userid of this editores
	*/
	public java.lang.String getUserid() {
		return _editores.getUserid();
	}

	/**
	* Sets the userid of this editores.
	*
	* @param userid the userid of this editores
	*/
	public void setUserid(java.lang.String userid) {
		_editores.setUserid(userid);
	}

	public boolean isNew() {
		return _editores.isNew();
	}

	public void setNew(boolean n) {
		_editores.setNew(n);
	}

	public boolean isCachedModel() {
		return _editores.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_editores.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _editores.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _editores.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_editores.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _editores.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_editores.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new editoresWrapper((editores)_editores.clone());
	}

	public int compareTo(com.co.csj.service.model.editores editores) {
		return _editores.compareTo(editores);
	}

	@Override
	public int hashCode() {
		return _editores.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.co.csj.service.model.editores> toCacheModel() {
		return _editores.toCacheModel();
	}

	public com.co.csj.service.model.editores toEscapedModel() {
		return new editoresWrapper(_editores.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _editores.toString();
	}

	public java.lang.String toXmlString() {
		return _editores.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_editores.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public editores getWrappededitores() {
		return _editores;
	}

	public editores getWrappedModel() {
		return _editores;
	}

	public void resetOriginalValues() {
		_editores.resetOriginalValues();
	}

	private editores _editores;
}
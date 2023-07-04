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
 * This class is a wrapper for {@link publicaciones}.
 * </p>
 *
 * @author    Equipo
 * @see       publicaciones
 * @generated
 */
public class publicacionesWrapper implements publicaciones,
	ModelWrapper<publicaciones> {
	public publicacionesWrapper(publicaciones publicaciones) {
		_publicaciones = publicaciones;
	}

	public Class<?> getModelClass() {
		return publicaciones.class;
	}

	public String getModelClassName() {
		return publicaciones.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("fk_usuario", getFk_usuario());
		attributes.put("despacho_usuario", getDespacho_usuario());
		attributes.put("archivo_hoja_vida", getArchivo_hoja_vida());
		attributes.put("archivo_declaracion_renta",
			getArchivo_declaracion_renta());
		attributes.put("archivo_formulario_bienes",
			getArchivo_formulario_bienes());
		attributes.put("fecha_solicitud", getFecha_solicitud());
		attributes.put("fecha_publicacion", getFecha_publicacion());
		attributes.put("aprobado_por", getAprobado_por());
		attributes.put("fecha_negado", getFecha_negado());
		attributes.put("negado_por", getNegado_por());
		attributes.put("anhio_publicacion", getAnhio_publicacion());
		attributes.put("fecha_modificado", getFecha_modificado());
		attributes.put("estatus", getEstatus());
		attributes.put("causa_negado", getCausa_negado());
		attributes.put("cargo", getCargo());
		attributes.put("retirado", getRetirado());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String fk_usuario = (String)attributes.get("fk_usuario");

		if (fk_usuario != null) {
			setFk_usuario(fk_usuario);
		}

		String despacho_usuario = (String)attributes.get("despacho_usuario");

		if (despacho_usuario != null) {
			setDespacho_usuario(despacho_usuario);
		}

		String archivo_hoja_vida = (String)attributes.get("archivo_hoja_vida");

		if (archivo_hoja_vida != null) {
			setArchivo_hoja_vida(archivo_hoja_vida);
		}

		String archivo_declaracion_renta = (String)attributes.get(
				"archivo_declaracion_renta");

		if (archivo_declaracion_renta != null) {
			setArchivo_declaracion_renta(archivo_declaracion_renta);
		}

		String archivo_formulario_bienes = (String)attributes.get(
				"archivo_formulario_bienes");

		if (archivo_formulario_bienes != null) {
			setArchivo_formulario_bienes(archivo_formulario_bienes);
		}

		Date fecha_solicitud = (Date)attributes.get("fecha_solicitud");

		if (fecha_solicitud != null) {
			setFecha_solicitud(fecha_solicitud);
		}

		Date fecha_publicacion = (Date)attributes.get("fecha_publicacion");

		if (fecha_publicacion != null) {
			setFecha_publicacion(fecha_publicacion);
		}

		String aprobado_por = (String)attributes.get("aprobado_por");

		if (aprobado_por != null) {
			setAprobado_por(aprobado_por);
		}

		Date fecha_negado = (Date)attributes.get("fecha_negado");

		if (fecha_negado != null) {
			setFecha_negado(fecha_negado);
		}

		String negado_por = (String)attributes.get("negado_por");

		if (negado_por != null) {
			setNegado_por(negado_por);
		}

		Integer anhio_publicacion = (Integer)attributes.get("anhio_publicacion");

		if (anhio_publicacion != null) {
			setAnhio_publicacion(anhio_publicacion);
		}

		Date fecha_modificado = (Date)attributes.get("fecha_modificado");

		if (fecha_modificado != null) {
			setFecha_modificado(fecha_modificado);
		}

		String estatus = (String)attributes.get("estatus");

		if (estatus != null) {
			setEstatus(estatus);
		}

		String causa_negado = (String)attributes.get("causa_negado");

		if (causa_negado != null) {
			setCausa_negado(causa_negado);
		}

		String cargo = (String)attributes.get("cargo");

		if (cargo != null) {
			setCargo(cargo);
		}

		String retirado = (String)attributes.get("retirado");

		if (retirado != null) {
			setRetirado(retirado);
		}
	}

	/**
	* Returns the primary key of this publicaciones.
	*
	* @return the primary key of this publicaciones
	*/
	public long getPrimaryKey() {
		return _publicaciones.getPrimaryKey();
	}

	/**
	* Sets the primary key of this publicaciones.
	*
	* @param primaryKey the primary key of this publicaciones
	*/
	public void setPrimaryKey(long primaryKey) {
		_publicaciones.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this publicaciones.
	*
	* @return the ID of this publicaciones
	*/
	public long getId() {
		return _publicaciones.getId();
	}

	/**
	* Sets the ID of this publicaciones.
	*
	* @param id the ID of this publicaciones
	*/
	public void setId(long id) {
		_publicaciones.setId(id);
	}

	/**
	* Returns the fk_usuario of this publicaciones.
	*
	* @return the fk_usuario of this publicaciones
	*/
	public java.lang.String getFk_usuario() {
		return _publicaciones.getFk_usuario();
	}

	/**
	* Sets the fk_usuario of this publicaciones.
	*
	* @param fk_usuario the fk_usuario of this publicaciones
	*/
	public void setFk_usuario(java.lang.String fk_usuario) {
		_publicaciones.setFk_usuario(fk_usuario);
	}

	/**
	* Returns the despacho_usuario of this publicaciones.
	*
	* @return the despacho_usuario of this publicaciones
	*/
	public java.lang.String getDespacho_usuario() {
		return _publicaciones.getDespacho_usuario();
	}

	/**
	* Sets the despacho_usuario of this publicaciones.
	*
	* @param despacho_usuario the despacho_usuario of this publicaciones
	*/
	public void setDespacho_usuario(java.lang.String despacho_usuario) {
		_publicaciones.setDespacho_usuario(despacho_usuario);
	}

	/**
	* Returns the archivo_hoja_vida of this publicaciones.
	*
	* @return the archivo_hoja_vida of this publicaciones
	*/
	public java.lang.String getArchivo_hoja_vida() {
		return _publicaciones.getArchivo_hoja_vida();
	}

	/**
	* Sets the archivo_hoja_vida of this publicaciones.
	*
	* @param archivo_hoja_vida the archivo_hoja_vida of this publicaciones
	*/
	public void setArchivo_hoja_vida(java.lang.String archivo_hoja_vida) {
		_publicaciones.setArchivo_hoja_vida(archivo_hoja_vida);
	}

	/**
	* Returns the archivo_declaracion_renta of this publicaciones.
	*
	* @return the archivo_declaracion_renta of this publicaciones
	*/
	public java.lang.String getArchivo_declaracion_renta() {
		return _publicaciones.getArchivo_declaracion_renta();
	}

	/**
	* Sets the archivo_declaracion_renta of this publicaciones.
	*
	* @param archivo_declaracion_renta the archivo_declaracion_renta of this publicaciones
	*/
	public void setArchivo_declaracion_renta(
		java.lang.String archivo_declaracion_renta) {
		_publicaciones.setArchivo_declaracion_renta(archivo_declaracion_renta);
	}

	/**
	* Returns the archivo_formulario_bienes of this publicaciones.
	*
	* @return the archivo_formulario_bienes of this publicaciones
	*/
	public java.lang.String getArchivo_formulario_bienes() {
		return _publicaciones.getArchivo_formulario_bienes();
	}

	/**
	* Sets the archivo_formulario_bienes of this publicaciones.
	*
	* @param archivo_formulario_bienes the archivo_formulario_bienes of this publicaciones
	*/
	public void setArchivo_formulario_bienes(
		java.lang.String archivo_formulario_bienes) {
		_publicaciones.setArchivo_formulario_bienes(archivo_formulario_bienes);
	}

	/**
	* Returns the fecha_solicitud of this publicaciones.
	*
	* @return the fecha_solicitud of this publicaciones
	*/
	public java.util.Date getFecha_solicitud() {
		return _publicaciones.getFecha_solicitud();
	}

	/**
	* Sets the fecha_solicitud of this publicaciones.
	*
	* @param fecha_solicitud the fecha_solicitud of this publicaciones
	*/
	public void setFecha_solicitud(java.util.Date fecha_solicitud) {
		_publicaciones.setFecha_solicitud(fecha_solicitud);
	}

	/**
	* Returns the fecha_publicacion of this publicaciones.
	*
	* @return the fecha_publicacion of this publicaciones
	*/
	public java.util.Date getFecha_publicacion() {
		return _publicaciones.getFecha_publicacion();
	}

	/**
	* Sets the fecha_publicacion of this publicaciones.
	*
	* @param fecha_publicacion the fecha_publicacion of this publicaciones
	*/
	public void setFecha_publicacion(java.util.Date fecha_publicacion) {
		_publicaciones.setFecha_publicacion(fecha_publicacion);
	}

	/**
	* Returns the aprobado_por of this publicaciones.
	*
	* @return the aprobado_por of this publicaciones
	*/
	public java.lang.String getAprobado_por() {
		return _publicaciones.getAprobado_por();
	}

	/**
	* Sets the aprobado_por of this publicaciones.
	*
	* @param aprobado_por the aprobado_por of this publicaciones
	*/
	public void setAprobado_por(java.lang.String aprobado_por) {
		_publicaciones.setAprobado_por(aprobado_por);
	}

	/**
	* Returns the fecha_negado of this publicaciones.
	*
	* @return the fecha_negado of this publicaciones
	*/
	public java.util.Date getFecha_negado() {
		return _publicaciones.getFecha_negado();
	}

	/**
	* Sets the fecha_negado of this publicaciones.
	*
	* @param fecha_negado the fecha_negado of this publicaciones
	*/
	public void setFecha_negado(java.util.Date fecha_negado) {
		_publicaciones.setFecha_negado(fecha_negado);
	}

	/**
	* Returns the negado_por of this publicaciones.
	*
	* @return the negado_por of this publicaciones
	*/
	public java.lang.String getNegado_por() {
		return _publicaciones.getNegado_por();
	}

	/**
	* Sets the negado_por of this publicaciones.
	*
	* @param negado_por the negado_por of this publicaciones
	*/
	public void setNegado_por(java.lang.String negado_por) {
		_publicaciones.setNegado_por(negado_por);
	}

	/**
	* Returns the anhio_publicacion of this publicaciones.
	*
	* @return the anhio_publicacion of this publicaciones
	*/
	public int getAnhio_publicacion() {
		return _publicaciones.getAnhio_publicacion();
	}

	/**
	* Sets the anhio_publicacion of this publicaciones.
	*
	* @param anhio_publicacion the anhio_publicacion of this publicaciones
	*/
	public void setAnhio_publicacion(int anhio_publicacion) {
		_publicaciones.setAnhio_publicacion(anhio_publicacion);
	}

	/**
	* Returns the fecha_modificado of this publicaciones.
	*
	* @return the fecha_modificado of this publicaciones
	*/
	public java.util.Date getFecha_modificado() {
		return _publicaciones.getFecha_modificado();
	}

	/**
	* Sets the fecha_modificado of this publicaciones.
	*
	* @param fecha_modificado the fecha_modificado of this publicaciones
	*/
	public void setFecha_modificado(java.util.Date fecha_modificado) {
		_publicaciones.setFecha_modificado(fecha_modificado);
	}

	/**
	* Returns the estatus of this publicaciones.
	*
	* @return the estatus of this publicaciones
	*/
	public java.lang.String getEstatus() {
		return _publicaciones.getEstatus();
	}

	/**
	* Sets the estatus of this publicaciones.
	*
	* @param estatus the estatus of this publicaciones
	*/
	public void setEstatus(java.lang.String estatus) {
		_publicaciones.setEstatus(estatus);
	}

	/**
	* Returns the causa_negado of this publicaciones.
	*
	* @return the causa_negado of this publicaciones
	*/
	public java.lang.String getCausa_negado() {
		return _publicaciones.getCausa_negado();
	}

	/**
	* Sets the causa_negado of this publicaciones.
	*
	* @param causa_negado the causa_negado of this publicaciones
	*/
	public void setCausa_negado(java.lang.String causa_negado) {
		_publicaciones.setCausa_negado(causa_negado);
	}

	/**
	* Returns the cargo of this publicaciones.
	*
	* @return the cargo of this publicaciones
	*/
	public java.lang.String getCargo() {
		return _publicaciones.getCargo();
	}

	/**
	* Sets the cargo of this publicaciones.
	*
	* @param cargo the cargo of this publicaciones
	*/
	public void setCargo(java.lang.String cargo) {
		_publicaciones.setCargo(cargo);
	}

	/**
	* Returns the retirado of this publicaciones.
	*
	* @return the retirado of this publicaciones
	*/
	public java.lang.String getRetirado() {
		return _publicaciones.getRetirado();
	}

	/**
	* Sets the retirado of this publicaciones.
	*
	* @param retirado the retirado of this publicaciones
	*/
	public void setRetirado(java.lang.String retirado) {
		_publicaciones.setRetirado(retirado);
	}

	public boolean isNew() {
		return _publicaciones.isNew();
	}

	public void setNew(boolean n) {
		_publicaciones.setNew(n);
	}

	public boolean isCachedModel() {
		return _publicaciones.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_publicaciones.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _publicaciones.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _publicaciones.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_publicaciones.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _publicaciones.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_publicaciones.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new publicacionesWrapper((publicaciones)_publicaciones.clone());
	}

	public int compareTo(com.co.csj.service.model.publicaciones publicaciones) {
		return _publicaciones.compareTo(publicaciones);
	}

	@Override
	public int hashCode() {
		return _publicaciones.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.co.csj.service.model.publicaciones> toCacheModel() {
		return _publicaciones.toCacheModel();
	}

	public com.co.csj.service.model.publicaciones toEscapedModel() {
		return new publicacionesWrapper(_publicaciones.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _publicaciones.toString();
	}

	public java.lang.String toXmlString() {
		return _publicaciones.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_publicaciones.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public publicaciones getWrappedpublicaciones() {
		return _publicaciones;
	}

	public publicaciones getWrappedModel() {
		return _publicaciones;
	}

	public void resetOriginalValues() {
		_publicaciones.resetOriginalValues();
	}

	private publicaciones _publicaciones;
}
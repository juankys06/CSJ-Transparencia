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
 * This class is a wrapper for {@link usuario_data}.
 * </p>
 *
 * @author    Equipo
 * @see       usuario_data
 * @generated
 */
public class usuario_dataWrapper implements usuario_data,
	ModelWrapper<usuario_data> {
	public usuario_dataWrapper(usuario_data usuario_data) {
		_usuario_data = usuario_data;
	}

	public Class<?> getModelClass() {
		return usuario_data.class;
	}

	public String getModelClassName() {
		return usuario_data.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("numeroDocumento", getNumeroDocumento());
		attributes.put("tipoDocumento", getTipoDocumento());
		attributes.put("nombres", getNombres());
		attributes.put("apellidos", getApellidos());
		attributes.put("cargo", getCargo());
		attributes.put("fechaRegistro", getFechaRegistro());
		attributes.put("fechaModificacion", getFechaModificacion());
		attributes.put("datos_personales", getDatos_personales());
		attributes.put("despacho", getDespacho());
		attributes.put("formacion_academica", getFormacion_academica());
		attributes.put("experiencia_laboral", getExperiencia_laboral());
		attributes.put("tiempo_experiencia", getTiempo_experiencia());
		attributes.put("bienes_y_rentas", getBienes_y_rentas());
		attributes.put("informacion_complementaria",
			getInformacion_complementaria());
		attributes.put("conflicto_intereses", getConflicto_intereses());
		attributes.put("archivo_declaracion_renta",
			getArchivo_declaracion_renta());
		attributes.put("archivo_formulario_bienes",
			getArchivo_formulario_bienes());
		attributes.put("archivo_hoja_vida", getArchivo_hoja_vida());
		attributes.put("porcentaje_dp", getPorcentaje_dp());
		attributes.put("porcentaje_fa", getPorcentaje_fa());
		attributes.put("porcentaje_el", getPorcentaje_el());
		attributes.put("porcentaje_te", getPorcentaje_te());
		attributes.put("porcentaje_br", getPorcentaje_br());
		attributes.put("porcentaje_ic", getPorcentaje_ic());
		attributes.put("porcentaje_ci", getPorcentaje_ci());
		attributes.put("retirado", getRetirado());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String numeroDocumento = (String)attributes.get("numeroDocumento");

		if (numeroDocumento != null) {
			setNumeroDocumento(numeroDocumento);
		}

		String tipoDocumento = (String)attributes.get("tipoDocumento");

		if (tipoDocumento != null) {
			setTipoDocumento(tipoDocumento);
		}

		String nombres = (String)attributes.get("nombres");

		if (nombres != null) {
			setNombres(nombres);
		}

		String apellidos = (String)attributes.get("apellidos");

		if (apellidos != null) {
			setApellidos(apellidos);
		}

		String cargo = (String)attributes.get("cargo");

		if (cargo != null) {
			setCargo(cargo);
		}

		Date fechaRegistro = (Date)attributes.get("fechaRegistro");

		if (fechaRegistro != null) {
			setFechaRegistro(fechaRegistro);
		}

		Date fechaModificacion = (Date)attributes.get("fechaModificacion");

		if (fechaModificacion != null) {
			setFechaModificacion(fechaModificacion);
		}

		String datos_personales = (String)attributes.get("datos_personales");

		if (datos_personales != null) {
			setDatos_personales(datos_personales);
		}

		String despacho = (String)attributes.get("despacho");

		if (despacho != null) {
			setDespacho(despacho);
		}

		String formacion_academica = (String)attributes.get(
				"formacion_academica");

		if (formacion_academica != null) {
			setFormacion_academica(formacion_academica);
		}

		String experiencia_laboral = (String)attributes.get(
				"experiencia_laboral");

		if (experiencia_laboral != null) {
			setExperiencia_laboral(experiencia_laboral);
		}

		String tiempo_experiencia = (String)attributes.get("tiempo_experiencia");

		if (tiempo_experiencia != null) {
			setTiempo_experiencia(tiempo_experiencia);
		}

		String bienes_y_rentas = (String)attributes.get("bienes_y_rentas");

		if (bienes_y_rentas != null) {
			setBienes_y_rentas(bienes_y_rentas);
		}

		String informacion_complementaria = (String)attributes.get(
				"informacion_complementaria");

		if (informacion_complementaria != null) {
			setInformacion_complementaria(informacion_complementaria);
		}

		String conflicto_intereses = (String)attributes.get(
				"conflicto_intereses");

		if (conflicto_intereses != null) {
			setConflicto_intereses(conflicto_intereses);
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

		String archivo_hoja_vida = (String)attributes.get("archivo_hoja_vida");

		if (archivo_hoja_vida != null) {
			setArchivo_hoja_vida(archivo_hoja_vida);
		}

		Double porcentaje_dp = (Double)attributes.get("porcentaje_dp");

		if (porcentaje_dp != null) {
			setPorcentaje_dp(porcentaje_dp);
		}

		Double porcentaje_fa = (Double)attributes.get("porcentaje_fa");

		if (porcentaje_fa != null) {
			setPorcentaje_fa(porcentaje_fa);
		}

		Double porcentaje_el = (Double)attributes.get("porcentaje_el");

		if (porcentaje_el != null) {
			setPorcentaje_el(porcentaje_el);
		}

		Double porcentaje_te = (Double)attributes.get("porcentaje_te");

		if (porcentaje_te != null) {
			setPorcentaje_te(porcentaje_te);
		}

		Double porcentaje_br = (Double)attributes.get("porcentaje_br");

		if (porcentaje_br != null) {
			setPorcentaje_br(porcentaje_br);
		}

		Double porcentaje_ic = (Double)attributes.get("porcentaje_ic");

		if (porcentaje_ic != null) {
			setPorcentaje_ic(porcentaje_ic);
		}

		Double porcentaje_ci = (Double)attributes.get("porcentaje_ci");

		if (porcentaje_ci != null) {
			setPorcentaje_ci(porcentaje_ci);
		}

		String retirado = (String)attributes.get("retirado");

		if (retirado != null) {
			setRetirado(retirado);
		}
	}

	/**
	* Returns the primary key of this usuario_data.
	*
	* @return the primary key of this usuario_data
	*/
	public java.lang.String getPrimaryKey() {
		return _usuario_data.getPrimaryKey();
	}

	/**
	* Sets the primary key of this usuario_data.
	*
	* @param primaryKey the primary key of this usuario_data
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_usuario_data.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the numero documento of this usuario_data.
	*
	* @return the numero documento of this usuario_data
	*/
	public java.lang.String getNumeroDocumento() {
		return _usuario_data.getNumeroDocumento();
	}

	/**
	* Sets the numero documento of this usuario_data.
	*
	* @param numeroDocumento the numero documento of this usuario_data
	*/
	public void setNumeroDocumento(java.lang.String numeroDocumento) {
		_usuario_data.setNumeroDocumento(numeroDocumento);
	}

	/**
	* Returns the tipo documento of this usuario_data.
	*
	* @return the tipo documento of this usuario_data
	*/
	public java.lang.String getTipoDocumento() {
		return _usuario_data.getTipoDocumento();
	}

	/**
	* Sets the tipo documento of this usuario_data.
	*
	* @param tipoDocumento the tipo documento of this usuario_data
	*/
	public void setTipoDocumento(java.lang.String tipoDocumento) {
		_usuario_data.setTipoDocumento(tipoDocumento);
	}

	/**
	* Returns the nombres of this usuario_data.
	*
	* @return the nombres of this usuario_data
	*/
	public java.lang.String getNombres() {
		return _usuario_data.getNombres();
	}

	/**
	* Sets the nombres of this usuario_data.
	*
	* @param nombres the nombres of this usuario_data
	*/
	public void setNombres(java.lang.String nombres) {
		_usuario_data.setNombres(nombres);
	}

	/**
	* Returns the apellidos of this usuario_data.
	*
	* @return the apellidos of this usuario_data
	*/
	public java.lang.String getApellidos() {
		return _usuario_data.getApellidos();
	}

	/**
	* Sets the apellidos of this usuario_data.
	*
	* @param apellidos the apellidos of this usuario_data
	*/
	public void setApellidos(java.lang.String apellidos) {
		_usuario_data.setApellidos(apellidos);
	}

	/**
	* Returns the cargo of this usuario_data.
	*
	* @return the cargo of this usuario_data
	*/
	public java.lang.String getCargo() {
		return _usuario_data.getCargo();
	}

	/**
	* Sets the cargo of this usuario_data.
	*
	* @param cargo the cargo of this usuario_data
	*/
	public void setCargo(java.lang.String cargo) {
		_usuario_data.setCargo(cargo);
	}

	/**
	* Returns the fecha registro of this usuario_data.
	*
	* @return the fecha registro of this usuario_data
	*/
	public java.util.Date getFechaRegistro() {
		return _usuario_data.getFechaRegistro();
	}

	/**
	* Sets the fecha registro of this usuario_data.
	*
	* @param fechaRegistro the fecha registro of this usuario_data
	*/
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		_usuario_data.setFechaRegistro(fechaRegistro);
	}

	/**
	* Returns the fecha modificacion of this usuario_data.
	*
	* @return the fecha modificacion of this usuario_data
	*/
	public java.util.Date getFechaModificacion() {
		return _usuario_data.getFechaModificacion();
	}

	/**
	* Sets the fecha modificacion of this usuario_data.
	*
	* @param fechaModificacion the fecha modificacion of this usuario_data
	*/
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		_usuario_data.setFechaModificacion(fechaModificacion);
	}

	/**
	* Returns the datos_personales of this usuario_data.
	*
	* @return the datos_personales of this usuario_data
	*/
	public java.lang.String getDatos_personales() {
		return _usuario_data.getDatos_personales();
	}

	/**
	* Sets the datos_personales of this usuario_data.
	*
	* @param datos_personales the datos_personales of this usuario_data
	*/
	public void setDatos_personales(java.lang.String datos_personales) {
		_usuario_data.setDatos_personales(datos_personales);
	}

	/**
	* Returns the despacho of this usuario_data.
	*
	* @return the despacho of this usuario_data
	*/
	public java.lang.String getDespacho() {
		return _usuario_data.getDespacho();
	}

	/**
	* Sets the despacho of this usuario_data.
	*
	* @param despacho the despacho of this usuario_data
	*/
	public void setDespacho(java.lang.String despacho) {
		_usuario_data.setDespacho(despacho);
	}

	/**
	* Returns the formacion_academica of this usuario_data.
	*
	* @return the formacion_academica of this usuario_data
	*/
	public java.lang.String getFormacion_academica() {
		return _usuario_data.getFormacion_academica();
	}

	/**
	* Sets the formacion_academica of this usuario_data.
	*
	* @param formacion_academica the formacion_academica of this usuario_data
	*/
	public void setFormacion_academica(java.lang.String formacion_academica) {
		_usuario_data.setFormacion_academica(formacion_academica);
	}

	/**
	* Returns the experiencia_laboral of this usuario_data.
	*
	* @return the experiencia_laboral of this usuario_data
	*/
	public java.lang.String getExperiencia_laboral() {
		return _usuario_data.getExperiencia_laboral();
	}

	/**
	* Sets the experiencia_laboral of this usuario_data.
	*
	* @param experiencia_laboral the experiencia_laboral of this usuario_data
	*/
	public void setExperiencia_laboral(java.lang.String experiencia_laboral) {
		_usuario_data.setExperiencia_laboral(experiencia_laboral);
	}

	/**
	* Returns the tiempo_experiencia of this usuario_data.
	*
	* @return the tiempo_experiencia of this usuario_data
	*/
	public java.lang.String getTiempo_experiencia() {
		return _usuario_data.getTiempo_experiencia();
	}

	/**
	* Sets the tiempo_experiencia of this usuario_data.
	*
	* @param tiempo_experiencia the tiempo_experiencia of this usuario_data
	*/
	public void setTiempo_experiencia(java.lang.String tiempo_experiencia) {
		_usuario_data.setTiempo_experiencia(tiempo_experiencia);
	}

	/**
	* Returns the bienes_y_rentas of this usuario_data.
	*
	* @return the bienes_y_rentas of this usuario_data
	*/
	public java.lang.String getBienes_y_rentas() {
		return _usuario_data.getBienes_y_rentas();
	}

	/**
	* Sets the bienes_y_rentas of this usuario_data.
	*
	* @param bienes_y_rentas the bienes_y_rentas of this usuario_data
	*/
	public void setBienes_y_rentas(java.lang.String bienes_y_rentas) {
		_usuario_data.setBienes_y_rentas(bienes_y_rentas);
	}

	/**
	* Returns the informacion_complementaria of this usuario_data.
	*
	* @return the informacion_complementaria of this usuario_data
	*/
	public java.lang.String getInformacion_complementaria() {
		return _usuario_data.getInformacion_complementaria();
	}

	/**
	* Sets the informacion_complementaria of this usuario_data.
	*
	* @param informacion_complementaria the informacion_complementaria of this usuario_data
	*/
	public void setInformacion_complementaria(
		java.lang.String informacion_complementaria) {
		_usuario_data.setInformacion_complementaria(informacion_complementaria);
	}

	/**
	* Returns the conflicto_intereses of this usuario_data.
	*
	* @return the conflicto_intereses of this usuario_data
	*/
	public java.lang.String getConflicto_intereses() {
		return _usuario_data.getConflicto_intereses();
	}

	/**
	* Sets the conflicto_intereses of this usuario_data.
	*
	* @param conflicto_intereses the conflicto_intereses of this usuario_data
	*/
	public void setConflicto_intereses(java.lang.String conflicto_intereses) {
		_usuario_data.setConflicto_intereses(conflicto_intereses);
	}

	/**
	* Returns the archivo_declaracion_renta of this usuario_data.
	*
	* @return the archivo_declaracion_renta of this usuario_data
	*/
	public java.lang.String getArchivo_declaracion_renta() {
		return _usuario_data.getArchivo_declaracion_renta();
	}

	/**
	* Sets the archivo_declaracion_renta of this usuario_data.
	*
	* @param archivo_declaracion_renta the archivo_declaracion_renta of this usuario_data
	*/
	public void setArchivo_declaracion_renta(
		java.lang.String archivo_declaracion_renta) {
		_usuario_data.setArchivo_declaracion_renta(archivo_declaracion_renta);
	}

	/**
	* Returns the archivo_formulario_bienes of this usuario_data.
	*
	* @return the archivo_formulario_bienes of this usuario_data
	*/
	public java.lang.String getArchivo_formulario_bienes() {
		return _usuario_data.getArchivo_formulario_bienes();
	}

	/**
	* Sets the archivo_formulario_bienes of this usuario_data.
	*
	* @param archivo_formulario_bienes the archivo_formulario_bienes of this usuario_data
	*/
	public void setArchivo_formulario_bienes(
		java.lang.String archivo_formulario_bienes) {
		_usuario_data.setArchivo_formulario_bienes(archivo_formulario_bienes);
	}

	/**
	* Returns the archivo_hoja_vida of this usuario_data.
	*
	* @return the archivo_hoja_vida of this usuario_data
	*/
	public java.lang.String getArchivo_hoja_vida() {
		return _usuario_data.getArchivo_hoja_vida();
	}

	/**
	* Sets the archivo_hoja_vida of this usuario_data.
	*
	* @param archivo_hoja_vida the archivo_hoja_vida of this usuario_data
	*/
	public void setArchivo_hoja_vida(java.lang.String archivo_hoja_vida) {
		_usuario_data.setArchivo_hoja_vida(archivo_hoja_vida);
	}

	/**
	* Returns the porcentaje_dp of this usuario_data.
	*
	* @return the porcentaje_dp of this usuario_data
	*/
	public double getPorcentaje_dp() {
		return _usuario_data.getPorcentaje_dp();
	}

	/**
	* Sets the porcentaje_dp of this usuario_data.
	*
	* @param porcentaje_dp the porcentaje_dp of this usuario_data
	*/
	public void setPorcentaje_dp(double porcentaje_dp) {
		_usuario_data.setPorcentaje_dp(porcentaje_dp);
	}

	/**
	* Returns the porcentaje_fa of this usuario_data.
	*
	* @return the porcentaje_fa of this usuario_data
	*/
	public double getPorcentaje_fa() {
		return _usuario_data.getPorcentaje_fa();
	}

	/**
	* Sets the porcentaje_fa of this usuario_data.
	*
	* @param porcentaje_fa the porcentaje_fa of this usuario_data
	*/
	public void setPorcentaje_fa(double porcentaje_fa) {
		_usuario_data.setPorcentaje_fa(porcentaje_fa);
	}

	/**
	* Returns the porcentaje_el of this usuario_data.
	*
	* @return the porcentaje_el of this usuario_data
	*/
	public double getPorcentaje_el() {
		return _usuario_data.getPorcentaje_el();
	}

	/**
	* Sets the porcentaje_el of this usuario_data.
	*
	* @param porcentaje_el the porcentaje_el of this usuario_data
	*/
	public void setPorcentaje_el(double porcentaje_el) {
		_usuario_data.setPorcentaje_el(porcentaje_el);
	}

	/**
	* Returns the porcentaje_te of this usuario_data.
	*
	* @return the porcentaje_te of this usuario_data
	*/
	public double getPorcentaje_te() {
		return _usuario_data.getPorcentaje_te();
	}

	/**
	* Sets the porcentaje_te of this usuario_data.
	*
	* @param porcentaje_te the porcentaje_te of this usuario_data
	*/
	public void setPorcentaje_te(double porcentaje_te) {
		_usuario_data.setPorcentaje_te(porcentaje_te);
	}

	/**
	* Returns the porcentaje_br of this usuario_data.
	*
	* @return the porcentaje_br of this usuario_data
	*/
	public double getPorcentaje_br() {
		return _usuario_data.getPorcentaje_br();
	}

	/**
	* Sets the porcentaje_br of this usuario_data.
	*
	* @param porcentaje_br the porcentaje_br of this usuario_data
	*/
	public void setPorcentaje_br(double porcentaje_br) {
		_usuario_data.setPorcentaje_br(porcentaje_br);
	}

	/**
	* Returns the porcentaje_ic of this usuario_data.
	*
	* @return the porcentaje_ic of this usuario_data
	*/
	public double getPorcentaje_ic() {
		return _usuario_data.getPorcentaje_ic();
	}

	/**
	* Sets the porcentaje_ic of this usuario_data.
	*
	* @param porcentaje_ic the porcentaje_ic of this usuario_data
	*/
	public void setPorcentaje_ic(double porcentaje_ic) {
		_usuario_data.setPorcentaje_ic(porcentaje_ic);
	}

	/**
	* Returns the porcentaje_ci of this usuario_data.
	*
	* @return the porcentaje_ci of this usuario_data
	*/
	public double getPorcentaje_ci() {
		return _usuario_data.getPorcentaje_ci();
	}

	/**
	* Sets the porcentaje_ci of this usuario_data.
	*
	* @param porcentaje_ci the porcentaje_ci of this usuario_data
	*/
	public void setPorcentaje_ci(double porcentaje_ci) {
		_usuario_data.setPorcentaje_ci(porcentaje_ci);
	}

	/**
	* Returns the retirado of this usuario_data.
	*
	* @return the retirado of this usuario_data
	*/
	public java.lang.String getRetirado() {
		return _usuario_data.getRetirado();
	}

	/**
	* Sets the retirado of this usuario_data.
	*
	* @param retirado the retirado of this usuario_data
	*/
	public void setRetirado(java.lang.String retirado) {
		_usuario_data.setRetirado(retirado);
	}

	public boolean isNew() {
		return _usuario_data.isNew();
	}

	public void setNew(boolean n) {
		_usuario_data.setNew(n);
	}

	public boolean isCachedModel() {
		return _usuario_data.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_usuario_data.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _usuario_data.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _usuario_data.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_usuario_data.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _usuario_data.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_usuario_data.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new usuario_dataWrapper((usuario_data)_usuario_data.clone());
	}

	public int compareTo(com.co.csj.service.model.usuario_data usuario_data) {
		return _usuario_data.compareTo(usuario_data);
	}

	@Override
	public int hashCode() {
		return _usuario_data.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.co.csj.service.model.usuario_data> toCacheModel() {
		return _usuario_data.toCacheModel();
	}

	public com.co.csj.service.model.usuario_data toEscapedModel() {
		return new usuario_dataWrapper(_usuario_data.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _usuario_data.toString();
	}

	public java.lang.String toXmlString() {
		return _usuario_data.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_usuario_data.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public usuario_data getWrappedusuario_data() {
		return _usuario_data;
	}

	public usuario_data getWrappedModel() {
		return _usuario_data;
	}

	public void resetOriginalValues() {
		_usuario_data.resetOriginalValues();
	}

	private usuario_data _usuario_data;
}
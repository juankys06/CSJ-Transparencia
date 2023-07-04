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

import com.co.csj.service.service.usuario_dataLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Equipo
 */
public class usuario_dataClp extends BaseModelImpl<usuario_data>
	implements usuario_data {
	public usuario_dataClp() {
	}

	public Class<?> getModelClass() {
		return usuario_data.class;
	}

	public String getModelClassName() {
		return usuario_data.class.getName();
	}

	public String getPrimaryKey() {
		return _numeroDocumento;
	}

	public void setPrimaryKey(String primaryKey) {
		setNumeroDocumento(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _numeroDocumento;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
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

	@Override
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

	public String getNumeroDocumento() {
		return _numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		_numeroDocumento = numeroDocumento;
	}

	public String getTipoDocumento() {
		return _tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		_tipoDocumento = tipoDocumento;
	}

	public String getNombres() {
		return _nombres;
	}

	public void setNombres(String nombres) {
		_nombres = nombres;
	}

	public String getApellidos() {
		return _apellidos;
	}

	public void setApellidos(String apellidos) {
		_apellidos = apellidos;
	}

	public String getCargo() {
		return _cargo;
	}

	public void setCargo(String cargo) {
		_cargo = cargo;
	}

	public Date getFechaRegistro() {
		return _fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		_fechaRegistro = fechaRegistro;
	}

	public Date getFechaModificacion() {
		return _fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		_fechaModificacion = fechaModificacion;
	}

	public String getDatos_personales() {
		return _datos_personales;
	}

	public void setDatos_personales(String datos_personales) {
		_datos_personales = datos_personales;
	}

	public String getDespacho() {
		return _despacho;
	}

	public void setDespacho(String despacho) {
		_despacho = despacho;
	}

	public String getFormacion_academica() {
		return _formacion_academica;
	}

	public void setFormacion_academica(String formacion_academica) {
		_formacion_academica = formacion_academica;
	}

	public String getExperiencia_laboral() {
		return _experiencia_laboral;
	}

	public void setExperiencia_laboral(String experiencia_laboral) {
		_experiencia_laboral = experiencia_laboral;
	}

	public String getTiempo_experiencia() {
		return _tiempo_experiencia;
	}

	public void setTiempo_experiencia(String tiempo_experiencia) {
		_tiempo_experiencia = tiempo_experiencia;
	}

	public String getBienes_y_rentas() {
		return _bienes_y_rentas;
	}

	public void setBienes_y_rentas(String bienes_y_rentas) {
		_bienes_y_rentas = bienes_y_rentas;
	}

	public String getInformacion_complementaria() {
		return _informacion_complementaria;
	}

	public void setInformacion_complementaria(String informacion_complementaria) {
		_informacion_complementaria = informacion_complementaria;
	}

	public String getConflicto_intereses() {
		return _conflicto_intereses;
	}

	public void setConflicto_intereses(String conflicto_intereses) {
		_conflicto_intereses = conflicto_intereses;
	}

	public String getArchivo_declaracion_renta() {
		return _archivo_declaracion_renta;
	}

	public void setArchivo_declaracion_renta(String archivo_declaracion_renta) {
		_archivo_declaracion_renta = archivo_declaracion_renta;
	}

	public String getArchivo_formulario_bienes() {
		return _archivo_formulario_bienes;
	}

	public void setArchivo_formulario_bienes(String archivo_formulario_bienes) {
		_archivo_formulario_bienes = archivo_formulario_bienes;
	}

	public String getArchivo_hoja_vida() {
		return _archivo_hoja_vida;
	}

	public void setArchivo_hoja_vida(String archivo_hoja_vida) {
		_archivo_hoja_vida = archivo_hoja_vida;
	}

	public double getPorcentaje_dp() {
		return _porcentaje_dp;
	}

	public void setPorcentaje_dp(double porcentaje_dp) {
		_porcentaje_dp = porcentaje_dp;
	}

	public double getPorcentaje_fa() {
		return _porcentaje_fa;
	}

	public void setPorcentaje_fa(double porcentaje_fa) {
		_porcentaje_fa = porcentaje_fa;
	}

	public double getPorcentaje_el() {
		return _porcentaje_el;
	}

	public void setPorcentaje_el(double porcentaje_el) {
		_porcentaje_el = porcentaje_el;
	}

	public double getPorcentaje_te() {
		return _porcentaje_te;
	}

	public void setPorcentaje_te(double porcentaje_te) {
		_porcentaje_te = porcentaje_te;
	}

	public double getPorcentaje_br() {
		return _porcentaje_br;
	}

	public void setPorcentaje_br(double porcentaje_br) {
		_porcentaje_br = porcentaje_br;
	}

	public double getPorcentaje_ic() {
		return _porcentaje_ic;
	}

	public void setPorcentaje_ic(double porcentaje_ic) {
		_porcentaje_ic = porcentaje_ic;
	}

	public double getPorcentaje_ci() {
		return _porcentaje_ci;
	}

	public void setPorcentaje_ci(double porcentaje_ci) {
		_porcentaje_ci = porcentaje_ci;
	}

	public String getRetirado() {
		return _retirado;
	}

	public void setRetirado(String retirado) {
		_retirado = retirado;
	}

	public BaseModel<?> getusuario_dataRemoteModel() {
		return _usuario_dataRemoteModel;
	}

	public void setusuario_dataRemoteModel(BaseModel<?> usuario_dataRemoteModel) {
		_usuario_dataRemoteModel = usuario_dataRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			usuario_dataLocalServiceUtil.addusuario_data(this);
		}
		else {
			usuario_dataLocalServiceUtil.updateusuario_data(this);
		}
	}

	@Override
	public usuario_data toEscapedModel() {
		return (usuario_data)Proxy.newProxyInstance(usuario_data.class.getClassLoader(),
			new Class[] { usuario_data.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		usuario_dataClp clone = new usuario_dataClp();

		clone.setNumeroDocumento(getNumeroDocumento());
		clone.setTipoDocumento(getTipoDocumento());
		clone.setNombres(getNombres());
		clone.setApellidos(getApellidos());
		clone.setCargo(getCargo());
		clone.setFechaRegistro(getFechaRegistro());
		clone.setFechaModificacion(getFechaModificacion());
		clone.setDatos_personales(getDatos_personales());
		clone.setDespacho(getDespacho());
		clone.setFormacion_academica(getFormacion_academica());
		clone.setExperiencia_laboral(getExperiencia_laboral());
		clone.setTiempo_experiencia(getTiempo_experiencia());
		clone.setBienes_y_rentas(getBienes_y_rentas());
		clone.setInformacion_complementaria(getInformacion_complementaria());
		clone.setConflicto_intereses(getConflicto_intereses());
		clone.setArchivo_declaracion_renta(getArchivo_declaracion_renta());
		clone.setArchivo_formulario_bienes(getArchivo_formulario_bienes());
		clone.setArchivo_hoja_vida(getArchivo_hoja_vida());
		clone.setPorcentaje_dp(getPorcentaje_dp());
		clone.setPorcentaje_fa(getPorcentaje_fa());
		clone.setPorcentaje_el(getPorcentaje_el());
		clone.setPorcentaje_te(getPorcentaje_te());
		clone.setPorcentaje_br(getPorcentaje_br());
		clone.setPorcentaje_ic(getPorcentaje_ic());
		clone.setPorcentaje_ci(getPorcentaje_ci());
		clone.setRetirado(getRetirado());

		return clone;
	}

	public int compareTo(usuario_data usuario_data) {
		String primaryKey = usuario_data.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		usuario_dataClp usuario_data = null;

		try {
			usuario_data = (usuario_dataClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = usuario_data.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{numeroDocumento=");
		sb.append(getNumeroDocumento());
		sb.append(", tipoDocumento=");
		sb.append(getTipoDocumento());
		sb.append(", nombres=");
		sb.append(getNombres());
		sb.append(", apellidos=");
		sb.append(getApellidos());
		sb.append(", cargo=");
		sb.append(getCargo());
		sb.append(", fechaRegistro=");
		sb.append(getFechaRegistro());
		sb.append(", fechaModificacion=");
		sb.append(getFechaModificacion());
		sb.append(", datos_personales=");
		sb.append(getDatos_personales());
		sb.append(", despacho=");
		sb.append(getDespacho());
		sb.append(", formacion_academica=");
		sb.append(getFormacion_academica());
		sb.append(", experiencia_laboral=");
		sb.append(getExperiencia_laboral());
		sb.append(", tiempo_experiencia=");
		sb.append(getTiempo_experiencia());
		sb.append(", bienes_y_rentas=");
		sb.append(getBienes_y_rentas());
		sb.append(", informacion_complementaria=");
		sb.append(getInformacion_complementaria());
		sb.append(", conflicto_intereses=");
		sb.append(getConflicto_intereses());
		sb.append(", archivo_declaracion_renta=");
		sb.append(getArchivo_declaracion_renta());
		sb.append(", archivo_formulario_bienes=");
		sb.append(getArchivo_formulario_bienes());
		sb.append(", archivo_hoja_vida=");
		sb.append(getArchivo_hoja_vida());
		sb.append(", porcentaje_dp=");
		sb.append(getPorcentaje_dp());
		sb.append(", porcentaje_fa=");
		sb.append(getPorcentaje_fa());
		sb.append(", porcentaje_el=");
		sb.append(getPorcentaje_el());
		sb.append(", porcentaje_te=");
		sb.append(getPorcentaje_te());
		sb.append(", porcentaje_br=");
		sb.append(getPorcentaje_br());
		sb.append(", porcentaje_ic=");
		sb.append(getPorcentaje_ic());
		sb.append(", porcentaje_ci=");
		sb.append(getPorcentaje_ci());
		sb.append(", retirado=");
		sb.append(getRetirado());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(82);

		sb.append("<model><model-name>");
		sb.append("com.co.csj.service.model.usuario_data");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>numeroDocumento</column-name><column-value><![CDATA[");
		sb.append(getNumeroDocumento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoDocumento</column-name><column-value><![CDATA[");
		sb.append(getTipoDocumento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombres</column-name><column-value><![CDATA[");
		sb.append(getNombres());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>apellidos</column-name><column-value><![CDATA[");
		sb.append(getApellidos());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cargo</column-name><column-value><![CDATA[");
		sb.append(getCargo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fechaRegistro</column-name><column-value><![CDATA[");
		sb.append(getFechaRegistro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fechaModificacion</column-name><column-value><![CDATA[");
		sb.append(getFechaModificacion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>datos_personales</column-name><column-value><![CDATA[");
		sb.append(getDatos_personales());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>despacho</column-name><column-value><![CDATA[");
		sb.append(getDespacho());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>formacion_academica</column-name><column-value><![CDATA[");
		sb.append(getFormacion_academica());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>experiencia_laboral</column-name><column-value><![CDATA[");
		sb.append(getExperiencia_laboral());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tiempo_experiencia</column-name><column-value><![CDATA[");
		sb.append(getTiempo_experiencia());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bienes_y_rentas</column-name><column-value><![CDATA[");
		sb.append(getBienes_y_rentas());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>informacion_complementaria</column-name><column-value><![CDATA[");
		sb.append(getInformacion_complementaria());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>conflicto_intereses</column-name><column-value><![CDATA[");
		sb.append(getConflicto_intereses());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>archivo_declaracion_renta</column-name><column-value><![CDATA[");
		sb.append(getArchivo_declaracion_renta());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>archivo_formulario_bienes</column-name><column-value><![CDATA[");
		sb.append(getArchivo_formulario_bienes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>archivo_hoja_vida</column-name><column-value><![CDATA[");
		sb.append(getArchivo_hoja_vida());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>porcentaje_dp</column-name><column-value><![CDATA[");
		sb.append(getPorcentaje_dp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>porcentaje_fa</column-name><column-value><![CDATA[");
		sb.append(getPorcentaje_fa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>porcentaje_el</column-name><column-value><![CDATA[");
		sb.append(getPorcentaje_el());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>porcentaje_te</column-name><column-value><![CDATA[");
		sb.append(getPorcentaje_te());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>porcentaje_br</column-name><column-value><![CDATA[");
		sb.append(getPorcentaje_br());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>porcentaje_ic</column-name><column-value><![CDATA[");
		sb.append(getPorcentaje_ic());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>porcentaje_ci</column-name><column-value><![CDATA[");
		sb.append(getPorcentaje_ci());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>retirado</column-name><column-value><![CDATA[");
		sb.append(getRetirado());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _numeroDocumento;
	private String _tipoDocumento;
	private String _nombres;
	private String _apellidos;
	private String _cargo;
	private Date _fechaRegistro;
	private Date _fechaModificacion;
	private String _datos_personales;
	private String _despacho;
	private String _formacion_academica;
	private String _experiencia_laboral;
	private String _tiempo_experiencia;
	private String _bienes_y_rentas;
	private String _informacion_complementaria;
	private String _conflicto_intereses;
	private String _archivo_declaracion_renta;
	private String _archivo_formulario_bienes;
	private String _archivo_hoja_vida;
	private double _porcentaje_dp;
	private double _porcentaje_fa;
	private double _porcentaje_el;
	private double _porcentaje_te;
	private double _porcentaje_br;
	private double _porcentaje_ic;
	private double _porcentaje_ci;
	private String _retirado;
	private BaseModel<?> _usuario_dataRemoteModel;
}
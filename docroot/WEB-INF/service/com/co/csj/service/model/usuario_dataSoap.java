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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Equipo
 * @generated
 */
public class usuario_dataSoap implements Serializable {
	public static usuario_dataSoap toSoapModel(usuario_data model) {
		usuario_dataSoap soapModel = new usuario_dataSoap();

		soapModel.setNumeroDocumento(model.getNumeroDocumento());
		soapModel.setTipoDocumento(model.getTipoDocumento());
		soapModel.setNombres(model.getNombres());
		soapModel.setApellidos(model.getApellidos());
		soapModel.setCargo(model.getCargo());
		soapModel.setFechaRegistro(model.getFechaRegistro());
		soapModel.setFechaModificacion(model.getFechaModificacion());
		soapModel.setDatos_personales(model.getDatos_personales());
		soapModel.setDespacho(model.getDespacho());
		soapModel.setFormacion_academica(model.getFormacion_academica());
		soapModel.setExperiencia_laboral(model.getExperiencia_laboral());
		soapModel.setTiempo_experiencia(model.getTiempo_experiencia());
		soapModel.setBienes_y_rentas(model.getBienes_y_rentas());
		soapModel.setInformacion_complementaria(model.getInformacion_complementaria());
		soapModel.setConflicto_intereses(model.getConflicto_intereses());
		soapModel.setArchivo_declaracion_renta(model.getArchivo_declaracion_renta());
		soapModel.setArchivo_formulario_bienes(model.getArchivo_formulario_bienes());
		soapModel.setArchivo_hoja_vida(model.getArchivo_hoja_vida());
		soapModel.setPorcentaje_dp(model.getPorcentaje_dp());
		soapModel.setPorcentaje_fa(model.getPorcentaje_fa());
		soapModel.setPorcentaje_el(model.getPorcentaje_el());
		soapModel.setPorcentaje_te(model.getPorcentaje_te());
		soapModel.setPorcentaje_br(model.getPorcentaje_br());
		soapModel.setPorcentaje_ic(model.getPorcentaje_ic());
		soapModel.setPorcentaje_ci(model.getPorcentaje_ci());
		soapModel.setRetirado(model.getRetirado());

		return soapModel;
	}

	public static usuario_dataSoap[] toSoapModels(usuario_data[] models) {
		usuario_dataSoap[] soapModels = new usuario_dataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static usuario_dataSoap[][] toSoapModels(usuario_data[][] models) {
		usuario_dataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new usuario_dataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new usuario_dataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static usuario_dataSoap[] toSoapModels(List<usuario_data> models) {
		List<usuario_dataSoap> soapModels = new ArrayList<usuario_dataSoap>(models.size());

		for (usuario_data model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new usuario_dataSoap[soapModels.size()]);
	}

	public usuario_dataSoap() {
	}

	public String getPrimaryKey() {
		return _numeroDocumento;
	}

	public void setPrimaryKey(String pk) {
		setNumeroDocumento(pk);
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
}
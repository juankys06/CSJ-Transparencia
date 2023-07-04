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
public class editoresSoap implements Serializable {
	public static editoresSoap toSoapModel(editores model) {
		editoresSoap soapModel = new editoresSoap();

		soapModel.setId(model.getId());
		soapModel.setCorreo(model.getCorreo());
		soapModel.setCodigo(model.getCodigo());
		soapModel.setFecha_creado(model.getFecha_creado());
		soapModel.setFecha_modificado(model.getFecha_modificado());
		soapModel.setUltimo_inicio(model.getUltimo_inicio());
		soapModel.setNombres_edita(model.getNombres_edita());
		soapModel.setApellidos_edita(model.getApellidos_edita());
		soapModel.setNumero_documento_edita(model.getNumero_documento_edita());
		soapModel.setTipo_documento_edita(model.getTipo_documento_edita());
		soapModel.setCargo_edita(model.getCargo_edita());
		soapModel.setDespacho_edita(model.getDespacho_edita());
		soapModel.setUserid(model.getUserid());

		return soapModel;
	}

	public static editoresSoap[] toSoapModels(editores[] models) {
		editoresSoap[] soapModels = new editoresSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static editoresSoap[][] toSoapModels(editores[][] models) {
		editoresSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new editoresSoap[models.length][models[0].length];
		}
		else {
			soapModels = new editoresSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static editoresSoap[] toSoapModels(List<editores> models) {
		List<editoresSoap> soapModels = new ArrayList<editoresSoap>(models.size());

		for (editores model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new editoresSoap[soapModels.size()]);
	}

	public editoresSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getCorreo() {
		return _correo;
	}

	public void setCorreo(String correo) {
		_correo = correo;
	}

	public String getCodigo() {
		return _codigo;
	}

	public void setCodigo(String codigo) {
		_codigo = codigo;
	}

	public Date getFecha_creado() {
		return _fecha_creado;
	}

	public void setFecha_creado(Date fecha_creado) {
		_fecha_creado = fecha_creado;
	}

	public Date getFecha_modificado() {
		return _fecha_modificado;
	}

	public void setFecha_modificado(Date fecha_modificado) {
		_fecha_modificado = fecha_modificado;
	}

	public Date getUltimo_inicio() {
		return _ultimo_inicio;
	}

	public void setUltimo_inicio(Date ultimo_inicio) {
		_ultimo_inicio = ultimo_inicio;
	}

	public String getNombres_edita() {
		return _nombres_edita;
	}

	public void setNombres_edita(String nombres_edita) {
		_nombres_edita = nombres_edita;
	}

	public String getApellidos_edita() {
		return _apellidos_edita;
	}

	public void setApellidos_edita(String apellidos_edita) {
		_apellidos_edita = apellidos_edita;
	}

	public String getNumero_documento_edita() {
		return _numero_documento_edita;
	}

	public void setNumero_documento_edita(String numero_documento_edita) {
		_numero_documento_edita = numero_documento_edita;
	}

	public String getTipo_documento_edita() {
		return _tipo_documento_edita;
	}

	public void setTipo_documento_edita(String tipo_documento_edita) {
		_tipo_documento_edita = tipo_documento_edita;
	}

	public String getCargo_edita() {
		return _cargo_edita;
	}

	public void setCargo_edita(String cargo_edita) {
		_cargo_edita = cargo_edita;
	}

	public String getDespacho_edita() {
		return _despacho_edita;
	}

	public void setDespacho_edita(String despacho_edita) {
		_despacho_edita = despacho_edita;
	}

	public String getUserid() {
		return _userid;
	}

	public void setUserid(String userid) {
		_userid = userid;
	}

	private long _id;
	private String _correo;
	private String _codigo;
	private Date _fecha_creado;
	private Date _fecha_modificado;
	private Date _ultimo_inicio;
	private String _nombres_edita;
	private String _apellidos_edita;
	private String _numero_documento_edita;
	private String _tipo_documento_edita;
	private String _cargo_edita;
	private String _despacho_edita;
	private String _userid;
}
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
public class auditoriaSoap implements Serializable {
	public static auditoriaSoap toSoapModel(auditoria model) {
		auditoriaSoap soapModel = new auditoriaSoap();

		soapModel.setId(model.getId());
		soapModel.setModificado_por(model.getModificado_por());
		soapModel.setAccion(model.getAccion());
		soapModel.setCampo_modifico(model.getCampo_modifico());
		soapModel.setFecha(model.getFecha());
		soapModel.setAno_vigencia(model.getAno_vigencia());
		soapModel.setCedula_funcionario(model.getCedula_funcionario());
		soapModel.setLog_anterior(model.getLog_anterior());
		soapModel.setLog_nuevo(model.getLog_nuevo());

		return soapModel;
	}

	public static auditoriaSoap[] toSoapModels(auditoria[] models) {
		auditoriaSoap[] soapModels = new auditoriaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static auditoriaSoap[][] toSoapModels(auditoria[][] models) {
		auditoriaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new auditoriaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new auditoriaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static auditoriaSoap[] toSoapModels(List<auditoria> models) {
		List<auditoriaSoap> soapModels = new ArrayList<auditoriaSoap>(models.size());

		for (auditoria model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new auditoriaSoap[soapModels.size()]);
	}

	public auditoriaSoap() {
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

	public String getModificado_por() {
		return _modificado_por;
	}

	public void setModificado_por(String modificado_por) {
		_modificado_por = modificado_por;
	}

	public String getAccion() {
		return _accion;
	}

	public void setAccion(String accion) {
		_accion = accion;
	}

	public String getCampo_modifico() {
		return _campo_modifico;
	}

	public void setCampo_modifico(String campo_modifico) {
		_campo_modifico = campo_modifico;
	}

	public Date getFecha() {
		return _fecha;
	}

	public void setFecha(Date fecha) {
		_fecha = fecha;
	}

	public int getAno_vigencia() {
		return _ano_vigencia;
	}

	public void setAno_vigencia(int ano_vigencia) {
		_ano_vigencia = ano_vigencia;
	}

	public String getCedula_funcionario() {
		return _cedula_funcionario;
	}

	public void setCedula_funcionario(String cedula_funcionario) {
		_cedula_funcionario = cedula_funcionario;
	}

	public String getLog_anterior() {
		return _log_anterior;
	}

	public void setLog_anterior(String log_anterior) {
		_log_anterior = log_anterior;
	}

	public String getLog_nuevo() {
		return _log_nuevo;
	}

	public void setLog_nuevo(String log_nuevo) {
		_log_nuevo = log_nuevo;
	}

	private long _id;
	private String _modificado_por;
	private String _accion;
	private String _campo_modifico;
	private Date _fecha;
	private int _ano_vigencia;
	private String _cedula_funcionario;
	private String _log_anterior;
	private String _log_nuevo;
}
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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Equipo
 * @generated
 */
public class correosSoap implements Serializable {
	public static correosSoap toSoapModel(correos model) {
		correosSoap soapModel = new correosSoap();

		soapModel.setId(model.getId());
		soapModel.setCuentaCorreo(model.getCuentaCorreo());
		soapModel.setNombre1(model.getNombre1());
		soapModel.setApellido(model.getApellido());
		soapModel.setCargo(model.getCargo());
		soapModel.setCedulaResponsable(model.getCedulaResponsable());
		soapModel.setCodigoDespacho(model.getCodigoDespacho());

		return soapModel;
	}

	public static correosSoap[] toSoapModels(correos[] models) {
		correosSoap[] soapModels = new correosSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static correosSoap[][] toSoapModels(correos[][] models) {
		correosSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new correosSoap[models.length][models[0].length];
		}
		else {
			soapModels = new correosSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static correosSoap[] toSoapModels(List<correos> models) {
		List<correosSoap> soapModels = new ArrayList<correosSoap>(models.size());

		for (correos model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new correosSoap[soapModels.size()]);
	}

	public correosSoap() {
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

	public String getCuentaCorreo() {
		return _cuentaCorreo;
	}

	public void setCuentaCorreo(String cuentaCorreo) {
		_cuentaCorreo = cuentaCorreo;
	}

	public String getNombre1() {
		return _nombre1;
	}

	public void setNombre1(String nombre1) {
		_nombre1 = nombre1;
	}

	public String getApellido() {
		return _apellido;
	}

	public void setApellido(String apellido) {
		_apellido = apellido;
	}

	public String getCargo() {
		return _cargo;
	}

	public void setCargo(String cargo) {
		_cargo = cargo;
	}

	public String getCedulaResponsable() {
		return _cedulaResponsable;
	}

	public void setCedulaResponsable(String cedulaResponsable) {
		_cedulaResponsable = cedulaResponsable;
	}

	public String getCodigoDespacho() {
		return _codigoDespacho;
	}

	public void setCodigoDespacho(String codigoDespacho) {
		_codigoDespacho = codigoDespacho;
	}

	private long _id;
	private String _cuentaCorreo;
	private String _nombre1;
	private String _apellido;
	private String _cargo;
	private String _cedulaResponsable;
	private String _codigoDespacho;
}
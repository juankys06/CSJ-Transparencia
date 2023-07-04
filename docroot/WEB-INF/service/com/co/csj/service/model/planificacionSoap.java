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
public class planificacionSoap implements Serializable {
	public static planificacionSoap toSoapModel(planificacion model) {
		planificacionSoap soapModel = new planificacionSoap();

		soapModel.setId(model.getId());
		soapModel.setAnhio(model.getAnhio());
		soapModel.setFecha_inicio(model.getFecha_inicio());
		soapModel.setFecha_fin(model.getFecha_fin());
		soapModel.setUsuario_finalizo(model.getUsuario_finalizo());
		soapModel.setEstado(model.getEstado());

		return soapModel;
	}

	public static planificacionSoap[] toSoapModels(planificacion[] models) {
		planificacionSoap[] soapModels = new planificacionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static planificacionSoap[][] toSoapModels(planificacion[][] models) {
		planificacionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new planificacionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new planificacionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static planificacionSoap[] toSoapModels(List<planificacion> models) {
		List<planificacionSoap> soapModels = new ArrayList<planificacionSoap>(models.size());

		for (planificacion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new planificacionSoap[soapModels.size()]);
	}

	public planificacionSoap() {
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

	public int getAnhio() {
		return _anhio;
	}

	public void setAnhio(int anhio) {
		_anhio = anhio;
	}

	public Date getFecha_inicio() {
		return _fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		_fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return _fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		_fecha_fin = fecha_fin;
	}

	public String getUsuario_finalizo() {
		return _usuario_finalizo;
	}

	public void setUsuario_finalizo(String usuario_finalizo) {
		_usuario_finalizo = usuario_finalizo;
	}

	public String getEstado() {
		return _estado;
	}

	public void setEstado(String estado) {
		_estado = estado;
	}

	private long _id;
	private int _anhio;
	private Date _fecha_inicio;
	private Date _fecha_fin;
	private String _usuario_finalizo;
	private String _estado;
}
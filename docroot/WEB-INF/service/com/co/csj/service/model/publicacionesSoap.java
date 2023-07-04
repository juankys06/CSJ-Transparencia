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
public class publicacionesSoap implements Serializable {
	public static publicacionesSoap toSoapModel(publicaciones model) {
		publicacionesSoap soapModel = new publicacionesSoap();

		soapModel.setId(model.getId());
		soapModel.setFk_usuario(model.getFk_usuario());
		soapModel.setDespacho_usuario(model.getDespacho_usuario());
		soapModel.setArchivo_hoja_vida(model.getArchivo_hoja_vida());
		soapModel.setArchivo_declaracion_renta(model.getArchivo_declaracion_renta());
		soapModel.setArchivo_formulario_bienes(model.getArchivo_formulario_bienes());
		soapModel.setFecha_solicitud(model.getFecha_solicitud());
		soapModel.setFecha_publicacion(model.getFecha_publicacion());
		soapModel.setAprobado_por(model.getAprobado_por());
		soapModel.setFecha_negado(model.getFecha_negado());
		soapModel.setNegado_por(model.getNegado_por());
		soapModel.setAnhio_publicacion(model.getAnhio_publicacion());
		soapModel.setFecha_modificado(model.getFecha_modificado());
		soapModel.setEstatus(model.getEstatus());
		soapModel.setCausa_negado(model.getCausa_negado());
		soapModel.setCargo(model.getCargo());
		soapModel.setRetirado(model.getRetirado());

		return soapModel;
	}

	public static publicacionesSoap[] toSoapModels(publicaciones[] models) {
		publicacionesSoap[] soapModels = new publicacionesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static publicacionesSoap[][] toSoapModels(publicaciones[][] models) {
		publicacionesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new publicacionesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new publicacionesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static publicacionesSoap[] toSoapModels(List<publicaciones> models) {
		List<publicacionesSoap> soapModels = new ArrayList<publicacionesSoap>(models.size());

		for (publicaciones model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new publicacionesSoap[soapModels.size()]);
	}

	public publicacionesSoap() {
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

	public String getFk_usuario() {
		return _fk_usuario;
	}

	public void setFk_usuario(String fk_usuario) {
		_fk_usuario = fk_usuario;
	}

	public String getDespacho_usuario() {
		return _despacho_usuario;
	}

	public void setDespacho_usuario(String despacho_usuario) {
		_despacho_usuario = despacho_usuario;
	}

	public String getArchivo_hoja_vida() {
		return _archivo_hoja_vida;
	}

	public void setArchivo_hoja_vida(String archivo_hoja_vida) {
		_archivo_hoja_vida = archivo_hoja_vida;
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

	public Date getFecha_solicitud() {
		return _fecha_solicitud;
	}

	public void setFecha_solicitud(Date fecha_solicitud) {
		_fecha_solicitud = fecha_solicitud;
	}

	public Date getFecha_publicacion() {
		return _fecha_publicacion;
	}

	public void setFecha_publicacion(Date fecha_publicacion) {
		_fecha_publicacion = fecha_publicacion;
	}

	public String getAprobado_por() {
		return _aprobado_por;
	}

	public void setAprobado_por(String aprobado_por) {
		_aprobado_por = aprobado_por;
	}

	public Date getFecha_negado() {
		return _fecha_negado;
	}

	public void setFecha_negado(Date fecha_negado) {
		_fecha_negado = fecha_negado;
	}

	public String getNegado_por() {
		return _negado_por;
	}

	public void setNegado_por(String negado_por) {
		_negado_por = negado_por;
	}

	public int getAnhio_publicacion() {
		return _anhio_publicacion;
	}

	public void setAnhio_publicacion(int anhio_publicacion) {
		_anhio_publicacion = anhio_publicacion;
	}

	public Date getFecha_modificado() {
		return _fecha_modificado;
	}

	public void setFecha_modificado(Date fecha_modificado) {
		_fecha_modificado = fecha_modificado;
	}

	public String getEstatus() {
		return _estatus;
	}

	public void setEstatus(String estatus) {
		_estatus = estatus;
	}

	public String getCausa_negado() {
		return _causa_negado;
	}

	public void setCausa_negado(String causa_negado) {
		_causa_negado = causa_negado;
	}

	public String getCargo() {
		return _cargo;
	}

	public void setCargo(String cargo) {
		_cargo = cargo;
	}

	public String getRetirado() {
		return _retirado;
	}

	public void setRetirado(String retirado) {
		_retirado = retirado;
	}

	private long _id;
	private String _fk_usuario;
	private String _despacho_usuario;
	private String _archivo_hoja_vida;
	private String _archivo_declaracion_renta;
	private String _archivo_formulario_bienes;
	private Date _fecha_solicitud;
	private Date _fecha_publicacion;
	private String _aprobado_por;
	private Date _fecha_negado;
	private String _negado_por;
	private int _anhio_publicacion;
	private Date _fecha_modificado;
	private String _estatus;
	private String _causa_negado;
	private String _cargo;
	private String _retirado;
}
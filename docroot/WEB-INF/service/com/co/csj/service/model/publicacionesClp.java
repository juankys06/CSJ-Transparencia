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

import com.co.csj.service.service.publicacionesLocalServiceUtil;

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
public class publicacionesClp extends BaseModelImpl<publicaciones>
	implements publicaciones {
	public publicacionesClp() {
	}

	public Class<?> getModelClass() {
		return publicaciones.class;
	}

	public String getModelClassName() {
		return publicaciones.class.getName();
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public BaseModel<?> getpublicacionesRemoteModel() {
		return _publicacionesRemoteModel;
	}

	public void setpublicacionesRemoteModel(
		BaseModel<?> publicacionesRemoteModel) {
		_publicacionesRemoteModel = publicacionesRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			publicacionesLocalServiceUtil.addpublicaciones(this);
		}
		else {
			publicacionesLocalServiceUtil.updatepublicaciones(this);
		}
	}

	@Override
	public publicaciones toEscapedModel() {
		return (publicaciones)Proxy.newProxyInstance(publicaciones.class.getClassLoader(),
			new Class[] { publicaciones.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		publicacionesClp clone = new publicacionesClp();

		clone.setId(getId());
		clone.setFk_usuario(getFk_usuario());
		clone.setDespacho_usuario(getDespacho_usuario());
		clone.setArchivo_hoja_vida(getArchivo_hoja_vida());
		clone.setArchivo_declaracion_renta(getArchivo_declaracion_renta());
		clone.setArchivo_formulario_bienes(getArchivo_formulario_bienes());
		clone.setFecha_solicitud(getFecha_solicitud());
		clone.setFecha_publicacion(getFecha_publicacion());
		clone.setAprobado_por(getAprobado_por());
		clone.setFecha_negado(getFecha_negado());
		clone.setNegado_por(getNegado_por());
		clone.setAnhio_publicacion(getAnhio_publicacion());
		clone.setFecha_modificado(getFecha_modificado());
		clone.setEstatus(getEstatus());
		clone.setCausa_negado(getCausa_negado());
		clone.setCargo(getCargo());
		clone.setRetirado(getRetirado());

		return clone;
	}

	public int compareTo(publicaciones publicaciones) {
		long primaryKey = publicaciones.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		publicacionesClp publicaciones = null;

		try {
			publicaciones = (publicacionesClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = publicaciones.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", fk_usuario=");
		sb.append(getFk_usuario());
		sb.append(", despacho_usuario=");
		sb.append(getDespacho_usuario());
		sb.append(", archivo_hoja_vida=");
		sb.append(getArchivo_hoja_vida());
		sb.append(", archivo_declaracion_renta=");
		sb.append(getArchivo_declaracion_renta());
		sb.append(", archivo_formulario_bienes=");
		sb.append(getArchivo_formulario_bienes());
		sb.append(", fecha_solicitud=");
		sb.append(getFecha_solicitud());
		sb.append(", fecha_publicacion=");
		sb.append(getFecha_publicacion());
		sb.append(", aprobado_por=");
		sb.append(getAprobado_por());
		sb.append(", fecha_negado=");
		sb.append(getFecha_negado());
		sb.append(", negado_por=");
		sb.append(getNegado_por());
		sb.append(", anhio_publicacion=");
		sb.append(getAnhio_publicacion());
		sb.append(", fecha_modificado=");
		sb.append(getFecha_modificado());
		sb.append(", estatus=");
		sb.append(getEstatus());
		sb.append(", causa_negado=");
		sb.append(getCausa_negado());
		sb.append(", cargo=");
		sb.append(getCargo());
		sb.append(", retirado=");
		sb.append(getRetirado());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.co.csj.service.model.publicaciones");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fk_usuario</column-name><column-value><![CDATA[");
		sb.append(getFk_usuario());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>despacho_usuario</column-name><column-value><![CDATA[");
		sb.append(getDespacho_usuario());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>archivo_hoja_vida</column-name><column-value><![CDATA[");
		sb.append(getArchivo_hoja_vida());
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
			"<column><column-name>fecha_solicitud</column-name><column-value><![CDATA[");
		sb.append(getFecha_solicitud());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fecha_publicacion</column-name><column-value><![CDATA[");
		sb.append(getFecha_publicacion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>aprobado_por</column-name><column-value><![CDATA[");
		sb.append(getAprobado_por());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fecha_negado</column-name><column-value><![CDATA[");
		sb.append(getFecha_negado());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>negado_por</column-name><column-value><![CDATA[");
		sb.append(getNegado_por());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>anhio_publicacion</column-name><column-value><![CDATA[");
		sb.append(getAnhio_publicacion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fecha_modificado</column-name><column-value><![CDATA[");
		sb.append(getFecha_modificado());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>estatus</column-name><column-value><![CDATA[");
		sb.append(getEstatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>causa_negado</column-name><column-value><![CDATA[");
		sb.append(getCausa_negado());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cargo</column-name><column-value><![CDATA[");
		sb.append(getCargo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>retirado</column-name><column-value><![CDATA[");
		sb.append(getRetirado());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _publicacionesRemoteModel;
}
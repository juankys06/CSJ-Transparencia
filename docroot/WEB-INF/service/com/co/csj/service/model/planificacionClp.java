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

import com.co.csj.service.service.planificacionLocalServiceUtil;

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
public class planificacionClp extends BaseModelImpl<planificacion>
	implements planificacion {
	public planificacionClp() {
	}

	public Class<?> getModelClass() {
		return planificacion.class;
	}

	public String getModelClassName() {
		return planificacion.class.getName();
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
		attributes.put("anhio", getAnhio());
		attributes.put("fecha_inicio", getFecha_inicio());
		attributes.put("fecha_fin", getFecha_fin());
		attributes.put("usuario_finalizo", getUsuario_finalizo());
		attributes.put("estado", getEstado());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Integer anhio = (Integer)attributes.get("anhio");

		if (anhio != null) {
			setAnhio(anhio);
		}

		Date fecha_inicio = (Date)attributes.get("fecha_inicio");

		if (fecha_inicio != null) {
			setFecha_inicio(fecha_inicio);
		}

		Date fecha_fin = (Date)attributes.get("fecha_fin");

		if (fecha_fin != null) {
			setFecha_fin(fecha_fin);
		}

		String usuario_finalizo = (String)attributes.get("usuario_finalizo");

		if (usuario_finalizo != null) {
			setUsuario_finalizo(usuario_finalizo);
		}

		String estado = (String)attributes.get("estado");

		if (estado != null) {
			setEstado(estado);
		}
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

	public BaseModel<?> getplanificacionRemoteModel() {
		return _planificacionRemoteModel;
	}

	public void setplanificacionRemoteModel(
		BaseModel<?> planificacionRemoteModel) {
		_planificacionRemoteModel = planificacionRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			planificacionLocalServiceUtil.addplanificacion(this);
		}
		else {
			planificacionLocalServiceUtil.updateplanificacion(this);
		}
	}

	@Override
	public planificacion toEscapedModel() {
		return (planificacion)Proxy.newProxyInstance(planificacion.class.getClassLoader(),
			new Class[] { planificacion.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		planificacionClp clone = new planificacionClp();

		clone.setId(getId());
		clone.setAnhio(getAnhio());
		clone.setFecha_inicio(getFecha_inicio());
		clone.setFecha_fin(getFecha_fin());
		clone.setUsuario_finalizo(getUsuario_finalizo());
		clone.setEstado(getEstado());

		return clone;
	}

	public int compareTo(planificacion planificacion) {
		long primaryKey = planificacion.getPrimaryKey();

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

		planificacionClp planificacion = null;

		try {
			planificacion = (planificacionClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = planificacion.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", anhio=");
		sb.append(getAnhio());
		sb.append(", fecha_inicio=");
		sb.append(getFecha_inicio());
		sb.append(", fecha_fin=");
		sb.append(getFecha_fin());
		sb.append(", usuario_finalizo=");
		sb.append(getUsuario_finalizo());
		sb.append(", estado=");
		sb.append(getEstado());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.co.csj.service.model.planificacion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>anhio</column-name><column-value><![CDATA[");
		sb.append(getAnhio());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fecha_inicio</column-name><column-value><![CDATA[");
		sb.append(getFecha_inicio());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fecha_fin</column-name><column-value><![CDATA[");
		sb.append(getFecha_fin());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>usuario_finalizo</column-name><column-value><![CDATA[");
		sb.append(getUsuario_finalizo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>estado</column-name><column-value><![CDATA[");
		sb.append(getEstado());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private int _anhio;
	private Date _fecha_inicio;
	private Date _fecha_fin;
	private String _usuario_finalizo;
	private String _estado;
	private BaseModel<?> _planificacionRemoteModel;
}
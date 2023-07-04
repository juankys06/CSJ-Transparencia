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

import com.co.csj.service.service.auditoriaLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
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
public class auditoriaClp extends BaseModelImpl<auditoria> implements auditoria {
	public auditoriaClp() {
	}

	public Class<?> getModelClass() {
		return auditoria.class;
	}

	public String getModelClassName() {
		return auditoria.class.getName();
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
		attributes.put("modificado_por", getModificado_por());
		attributes.put("accion", getAccion());
		attributes.put("campo_modifico", getCampo_modifico());
		attributes.put("fecha", getFecha());
		attributes.put("ano_vigencia", getAno_vigencia());
		attributes.put("cedula_funcionario", getCedula_funcionario());
		attributes.put("log_anterior", getLog_anterior());
		attributes.put("log_nuevo", getLog_nuevo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String modificado_por = (String)attributes.get("modificado_por");

		if (modificado_por != null) {
			setModificado_por(modificado_por);
		}

		String accion = (String)attributes.get("accion");

		if (accion != null) {
			setAccion(accion);
		}

		String campo_modifico = (String)attributes.get("campo_modifico");

		if (campo_modifico != null) {
			setCampo_modifico(campo_modifico);
		}

		Date fecha = (Date)attributes.get("fecha");

		if (fecha != null) {
			setFecha(fecha);
		}

		Integer ano_vigencia = (Integer)attributes.get("ano_vigencia");

		if (ano_vigencia != null) {
			setAno_vigencia(ano_vigencia);
		}

		String cedula_funcionario = (String)attributes.get("cedula_funcionario");

		if (cedula_funcionario != null) {
			setCedula_funcionario(cedula_funcionario);
		}

		String log_anterior = (String)attributes.get("log_anterior");

		if (log_anterior != null) {
			setLog_anterior(log_anterior);
		}

		String log_nuevo = (String)attributes.get("log_nuevo");

		if (log_nuevo != null) {
			setLog_nuevo(log_nuevo);
		}
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

	public BaseModel<?> getauditoriaRemoteModel() {
		return _auditoriaRemoteModel;
	}

	public void setauditoriaRemoteModel(BaseModel<?> auditoriaRemoteModel) {
		_auditoriaRemoteModel = auditoriaRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			auditoriaLocalServiceUtil.addauditoria(this);
		}
		else {
			auditoriaLocalServiceUtil.updateauditoria(this);
		}
	}

	@Override
	public auditoria toEscapedModel() {
		return (auditoria)Proxy.newProxyInstance(auditoria.class.getClassLoader(),
			new Class[] { auditoria.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		auditoriaClp clone = new auditoriaClp();

		clone.setId(getId());
		clone.setModificado_por(getModificado_por());
		clone.setAccion(getAccion());
		clone.setCampo_modifico(getCampo_modifico());
		clone.setFecha(getFecha());
		clone.setAno_vigencia(getAno_vigencia());
		clone.setCedula_funcionario(getCedula_funcionario());
		clone.setLog_anterior(getLog_anterior());
		clone.setLog_nuevo(getLog_nuevo());

		return clone;
	}

	public int compareTo(auditoria auditoria) {
		int value = 0;

		value = DateUtil.compareTo(getFecha(), auditoria.getFecha());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		auditoriaClp auditoria = null;

		try {
			auditoria = (auditoriaClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = auditoria.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", modificado_por=");
		sb.append(getModificado_por());
		sb.append(", accion=");
		sb.append(getAccion());
		sb.append(", campo_modifico=");
		sb.append(getCampo_modifico());
		sb.append(", fecha=");
		sb.append(getFecha());
		sb.append(", ano_vigencia=");
		sb.append(getAno_vigencia());
		sb.append(", cedula_funcionario=");
		sb.append(getCedula_funcionario());
		sb.append(", log_anterior=");
		sb.append(getLog_anterior());
		sb.append(", log_nuevo=");
		sb.append(getLog_nuevo());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.co.csj.service.model.auditoria");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modificado_por</column-name><column-value><![CDATA[");
		sb.append(getModificado_por());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accion</column-name><column-value><![CDATA[");
		sb.append(getAccion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campo_modifico</column-name><column-value><![CDATA[");
		sb.append(getCampo_modifico());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fecha</column-name><column-value><![CDATA[");
		sb.append(getFecha());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ano_vigencia</column-name><column-value><![CDATA[");
		sb.append(getAno_vigencia());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cedula_funcionario</column-name><column-value><![CDATA[");
		sb.append(getCedula_funcionario());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>log_anterior</column-name><column-value><![CDATA[");
		sb.append(getLog_anterior());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>log_nuevo</column-name><column-value><![CDATA[");
		sb.append(getLog_nuevo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _auditoriaRemoteModel;
}
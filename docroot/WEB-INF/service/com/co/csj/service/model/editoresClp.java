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

import com.co.csj.service.service.editoresLocalServiceUtil;

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
public class editoresClp extends BaseModelImpl<editores> implements editores {
	public editoresClp() {
	}

	public Class<?> getModelClass() {
		return editores.class;
	}

	public String getModelClassName() {
		return editores.class.getName();
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
		attributes.put("correo", getCorreo());
		attributes.put("codigo", getCodigo());
		attributes.put("fecha_creado", getFecha_creado());
		attributes.put("fecha_modificado", getFecha_modificado());
		attributes.put("ultimo_inicio", getUltimo_inicio());
		attributes.put("nombres_edita", getNombres_edita());
		attributes.put("apellidos_edita", getApellidos_edita());
		attributes.put("numero_documento_edita", getNumero_documento_edita());
		attributes.put("tipo_documento_edita", getTipo_documento_edita());
		attributes.put("cargo_edita", getCargo_edita());
		attributes.put("despacho_edita", getDespacho_edita());
		attributes.put("userid", getUserid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String correo = (String)attributes.get("correo");

		if (correo != null) {
			setCorreo(correo);
		}

		String codigo = (String)attributes.get("codigo");

		if (codigo != null) {
			setCodigo(codigo);
		}

		Date fecha_creado = (Date)attributes.get("fecha_creado");

		if (fecha_creado != null) {
			setFecha_creado(fecha_creado);
		}

		Date fecha_modificado = (Date)attributes.get("fecha_modificado");

		if (fecha_modificado != null) {
			setFecha_modificado(fecha_modificado);
		}

		Date ultimo_inicio = (Date)attributes.get("ultimo_inicio");

		if (ultimo_inicio != null) {
			setUltimo_inicio(ultimo_inicio);
		}

		String nombres_edita = (String)attributes.get("nombres_edita");

		if (nombres_edita != null) {
			setNombres_edita(nombres_edita);
		}

		String apellidos_edita = (String)attributes.get("apellidos_edita");

		if (apellidos_edita != null) {
			setApellidos_edita(apellidos_edita);
		}

		String numero_documento_edita = (String)attributes.get(
				"numero_documento_edita");

		if (numero_documento_edita != null) {
			setNumero_documento_edita(numero_documento_edita);
		}

		String tipo_documento_edita = (String)attributes.get(
				"tipo_documento_edita");

		if (tipo_documento_edita != null) {
			setTipo_documento_edita(tipo_documento_edita);
		}

		String cargo_edita = (String)attributes.get("cargo_edita");

		if (cargo_edita != null) {
			setCargo_edita(cargo_edita);
		}

		String despacho_edita = (String)attributes.get("despacho_edita");

		if (despacho_edita != null) {
			setDespacho_edita(despacho_edita);
		}

		String userid = (String)attributes.get("userid");

		if (userid != null) {
			setUserid(userid);
		}
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

	public BaseModel<?> geteditoresRemoteModel() {
		return _editoresRemoteModel;
	}

	public void seteditoresRemoteModel(BaseModel<?> editoresRemoteModel) {
		_editoresRemoteModel = editoresRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			editoresLocalServiceUtil.addeditores(this);
		}
		else {
			editoresLocalServiceUtil.updateeditores(this);
		}
	}

	@Override
	public editores toEscapedModel() {
		return (editores)Proxy.newProxyInstance(editores.class.getClassLoader(),
			new Class[] { editores.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		editoresClp clone = new editoresClp();

		clone.setId(getId());
		clone.setCorreo(getCorreo());
		clone.setCodigo(getCodigo());
		clone.setFecha_creado(getFecha_creado());
		clone.setFecha_modificado(getFecha_modificado());
		clone.setUltimo_inicio(getUltimo_inicio());
		clone.setNombres_edita(getNombres_edita());
		clone.setApellidos_edita(getApellidos_edita());
		clone.setNumero_documento_edita(getNumero_documento_edita());
		clone.setTipo_documento_edita(getTipo_documento_edita());
		clone.setCargo_edita(getCargo_edita());
		clone.setDespacho_edita(getDespacho_edita());
		clone.setUserid(getUserid());

		return clone;
	}

	public int compareTo(editores editores) {
		long primaryKey = editores.getPrimaryKey();

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

		editoresClp editores = null;

		try {
			editores = (editoresClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = editores.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", correo=");
		sb.append(getCorreo());
		sb.append(", codigo=");
		sb.append(getCodigo());
		sb.append(", fecha_creado=");
		sb.append(getFecha_creado());
		sb.append(", fecha_modificado=");
		sb.append(getFecha_modificado());
		sb.append(", ultimo_inicio=");
		sb.append(getUltimo_inicio());
		sb.append(", nombres_edita=");
		sb.append(getNombres_edita());
		sb.append(", apellidos_edita=");
		sb.append(getApellidos_edita());
		sb.append(", numero_documento_edita=");
		sb.append(getNumero_documento_edita());
		sb.append(", tipo_documento_edita=");
		sb.append(getTipo_documento_edita());
		sb.append(", cargo_edita=");
		sb.append(getCargo_edita());
		sb.append(", despacho_edita=");
		sb.append(getDespacho_edita());
		sb.append(", userid=");
		sb.append(getUserid());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.co.csj.service.model.editores");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>correo</column-name><column-value><![CDATA[");
		sb.append(getCorreo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codigo</column-name><column-value><![CDATA[");
		sb.append(getCodigo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fecha_creado</column-name><column-value><![CDATA[");
		sb.append(getFecha_creado());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fecha_modificado</column-name><column-value><![CDATA[");
		sb.append(getFecha_modificado());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ultimo_inicio</column-name><column-value><![CDATA[");
		sb.append(getUltimo_inicio());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombres_edita</column-name><column-value><![CDATA[");
		sb.append(getNombres_edita());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>apellidos_edita</column-name><column-value><![CDATA[");
		sb.append(getApellidos_edita());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numero_documento_edita</column-name><column-value><![CDATA[");
		sb.append(getNumero_documento_edita());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipo_documento_edita</column-name><column-value><![CDATA[");
		sb.append(getTipo_documento_edita());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cargo_edita</column-name><column-value><![CDATA[");
		sb.append(getCargo_edita());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>despacho_edita</column-name><column-value><![CDATA[");
		sb.append(getDespacho_edita());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userid</column-name><column-value><![CDATA[");
		sb.append(getUserid());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _editoresRemoteModel;
}
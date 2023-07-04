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

import com.co.csj.service.service.correosLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Equipo
 */
public class correosClp extends BaseModelImpl<correos> implements correos {
	public correosClp() {
	}

	public Class<?> getModelClass() {
		return correos.class;
	}

	public String getModelClassName() {
		return correos.class.getName();
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
		attributes.put("cuentaCorreo", getCuentaCorreo());
		attributes.put("nombre1", getNombre1());
		attributes.put("apellido", getApellido());
		attributes.put("cargo", getCargo());
		attributes.put("cedulaResponsable", getCedulaResponsable());
		attributes.put("codigoDespacho", getCodigoDespacho());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String cuentaCorreo = (String)attributes.get("cuentaCorreo");

		if (cuentaCorreo != null) {
			setCuentaCorreo(cuentaCorreo);
		}

		String nombre1 = (String)attributes.get("nombre1");

		if (nombre1 != null) {
			setNombre1(nombre1);
		}

		String apellido = (String)attributes.get("apellido");

		if (apellido != null) {
			setApellido(apellido);
		}

		String cargo = (String)attributes.get("cargo");

		if (cargo != null) {
			setCargo(cargo);
		}

		String cedulaResponsable = (String)attributes.get("cedulaResponsable");

		if (cedulaResponsable != null) {
			setCedulaResponsable(cedulaResponsable);
		}

		String codigoDespacho = (String)attributes.get("codigoDespacho");

		if (codigoDespacho != null) {
			setCodigoDespacho(codigoDespacho);
		}
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

	public BaseModel<?> getcorreosRemoteModel() {
		return _correosRemoteModel;
	}

	public void setcorreosRemoteModel(BaseModel<?> correosRemoteModel) {
		_correosRemoteModel = correosRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			correosLocalServiceUtil.addcorreos(this);
		}
		else {
			correosLocalServiceUtil.updatecorreos(this);
		}
	}

	@Override
	public correos toEscapedModel() {
		return (correos)Proxy.newProxyInstance(correos.class.getClassLoader(),
			new Class[] { correos.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		correosClp clone = new correosClp();

		clone.setId(getId());
		clone.setCuentaCorreo(getCuentaCorreo());
		clone.setNombre1(getNombre1());
		clone.setApellido(getApellido());
		clone.setCargo(getCargo());
		clone.setCedulaResponsable(getCedulaResponsable());
		clone.setCodigoDespacho(getCodigoDespacho());

		return clone;
	}

	public int compareTo(correos correos) {
		long primaryKey = correos.getPrimaryKey();

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

		correosClp correos = null;

		try {
			correos = (correosClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = correos.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", cuentaCorreo=");
		sb.append(getCuentaCorreo());
		sb.append(", nombre1=");
		sb.append(getNombre1());
		sb.append(", apellido=");
		sb.append(getApellido());
		sb.append(", cargo=");
		sb.append(getCargo());
		sb.append(", cedulaResponsable=");
		sb.append(getCedulaResponsable());
		sb.append(", codigoDespacho=");
		sb.append(getCodigoDespacho());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.co.csj.service.model.correos");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cuentaCorreo</column-name><column-value><![CDATA[");
		sb.append(getCuentaCorreo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombre1</column-name><column-value><![CDATA[");
		sb.append(getNombre1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>apellido</column-name><column-value><![CDATA[");
		sb.append(getApellido());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cargo</column-name><column-value><![CDATA[");
		sb.append(getCargo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cedulaResponsable</column-name><column-value><![CDATA[");
		sb.append(getCedulaResponsable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codigoDespacho</column-name><column-value><![CDATA[");
		sb.append(getCodigoDespacho());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _cuentaCorreo;
	private String _nombre1;
	private String _apellido;
	private String _cargo;
	private String _cedulaResponsable;
	private String _codigoDespacho;
	private BaseModel<?> _correosRemoteModel;
}
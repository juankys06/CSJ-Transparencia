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

package com.co.csj.service.model.impl;

import com.co.csj.service.model.editores;
import com.co.csj.service.model.editoresModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the editores service. Represents a row in the &quot;ley_trans_usuarios&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.co.csj.service.model.editoresModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link editoresImpl}.
 * </p>
 *
 * @author Equipo
 * @see editoresImpl
 * @see com.co.csj.service.model.editores
 * @see com.co.csj.service.model.editoresModel
 * @generated
 */
public class editoresModelImpl extends BaseModelImpl<editores>
	implements editoresModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a editores model instance should use the {@link com.co.csj.service.model.editores} interface instead.
	 */
	public static final String TABLE_NAME = "ley_trans_usuarios";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "correo", Types.VARCHAR },
			{ "codigo", Types.VARCHAR },
			{ "fecha_creado", Types.TIMESTAMP },
			{ "fecha_modificado", Types.TIMESTAMP },
			{ "ultimo_inicio", Types.TIMESTAMP },
			{ "nombres_edita", Types.VARCHAR },
			{ "apellidos_edita", Types.VARCHAR },
			{ "numero_documento_edita", Types.VARCHAR },
			{ "tipo_documento_edita", Types.VARCHAR },
			{ "cargo_edita", Types.VARCHAR },
			{ "despacho_edita", Types.VARCHAR },
			{ "userid", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ley_trans_usuarios (id LONG not null primary key IDENTITY,correo VARCHAR(75) null,codigo VARCHAR(75) null,fecha_creado DATE null,fecha_modificado DATE null,ultimo_inicio DATE null,nombres_edita VARCHAR(75) null,apellidos_edita VARCHAR(75) null,numero_documento_edita VARCHAR(75) null,tipo_documento_edita VARCHAR(75) null,cargo_edita VARCHAR(75) null,despacho_edita VARCHAR(75) null,userid VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ley_trans_usuarios";
	public static final String DATA_SOURCE = "appsportal";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.co.csj.service.model.editores"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.co.csj.service.model.editores"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.co.csj.service.model.editores"),
			true);
	public static long CORREO_COLUMN_BITMASK = 1L;
	public static long USERID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.co.csj.service.model.editores"));

	public editoresModelImpl() {
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

	public Class<?> getModelClass() {
		return editores.class;
	}

	public String getModelClassName() {
		return editores.class.getName();
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
		if (_correo == null) {
			return StringPool.BLANK;
		}
		else {
			return _correo;
		}
	}

	public void setCorreo(String correo) {
		_columnBitmask |= CORREO_COLUMN_BITMASK;

		if (_originalCorreo == null) {
			_originalCorreo = _correo;
		}

		_correo = correo;
	}

	public String getOriginalCorreo() {
		return GetterUtil.getString(_originalCorreo);
	}

	public String getCodigo() {
		if (_codigo == null) {
			return StringPool.BLANK;
		}
		else {
			return _codigo;
		}
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
		if (_nombres_edita == null) {
			return StringPool.BLANK;
		}
		else {
			return _nombres_edita;
		}
	}

	public void setNombres_edita(String nombres_edita) {
		_nombres_edita = nombres_edita;
	}

	public String getApellidos_edita() {
		if (_apellidos_edita == null) {
			return StringPool.BLANK;
		}
		else {
			return _apellidos_edita;
		}
	}

	public void setApellidos_edita(String apellidos_edita) {
		_apellidos_edita = apellidos_edita;
	}

	public String getNumero_documento_edita() {
		if (_numero_documento_edita == null) {
			return StringPool.BLANK;
		}
		else {
			return _numero_documento_edita;
		}
	}

	public void setNumero_documento_edita(String numero_documento_edita) {
		_numero_documento_edita = numero_documento_edita;
	}

	public String getTipo_documento_edita() {
		if (_tipo_documento_edita == null) {
			return StringPool.BLANK;
		}
		else {
			return _tipo_documento_edita;
		}
	}

	public void setTipo_documento_edita(String tipo_documento_edita) {
		_tipo_documento_edita = tipo_documento_edita;
	}

	public String getCargo_edita() {
		if (_cargo_edita == null) {
			return StringPool.BLANK;
		}
		else {
			return _cargo_edita;
		}
	}

	public void setCargo_edita(String cargo_edita) {
		_cargo_edita = cargo_edita;
	}

	public String getDespacho_edita() {
		if (_despacho_edita == null) {
			return StringPool.BLANK;
		}
		else {
			return _despacho_edita;
		}
	}

	public void setDespacho_edita(String despacho_edita) {
		_despacho_edita = despacho_edita;
	}

	public String getUserid() {
		if (_userid == null) {
			return StringPool.BLANK;
		}
		else {
			return _userid;
		}
	}

	public void setUserid(String userid) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (_originalUserid == null) {
			_originalUserid = _userid;
		}

		_userid = userid;
	}

	public String getOriginalUserid() {
		return GetterUtil.getString(_originalUserid);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			editores.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public editores toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (editores)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		editoresImpl editoresImpl = new editoresImpl();

		editoresImpl.setId(getId());
		editoresImpl.setCorreo(getCorreo());
		editoresImpl.setCodigo(getCodigo());
		editoresImpl.setFecha_creado(getFecha_creado());
		editoresImpl.setFecha_modificado(getFecha_modificado());
		editoresImpl.setUltimo_inicio(getUltimo_inicio());
		editoresImpl.setNombres_edita(getNombres_edita());
		editoresImpl.setApellidos_edita(getApellidos_edita());
		editoresImpl.setNumero_documento_edita(getNumero_documento_edita());
		editoresImpl.setTipo_documento_edita(getTipo_documento_edita());
		editoresImpl.setCargo_edita(getCargo_edita());
		editoresImpl.setDespacho_edita(getDespacho_edita());
		editoresImpl.setUserid(getUserid());

		editoresImpl.resetOriginalValues();

		return editoresImpl;
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

		editores editores = null;

		try {
			editores = (editores)obj;
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
	public void resetOriginalValues() {
		editoresModelImpl editoresModelImpl = this;

		editoresModelImpl._originalCorreo = editoresModelImpl._correo;

		editoresModelImpl._originalUserid = editoresModelImpl._userid;

		editoresModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<editores> toCacheModel() {
		editoresCacheModel editoresCacheModel = new editoresCacheModel();

		editoresCacheModel.id = getId();

		editoresCacheModel.correo = getCorreo();

		String correo = editoresCacheModel.correo;

		if ((correo != null) && (correo.length() == 0)) {
			editoresCacheModel.correo = null;
		}

		editoresCacheModel.codigo = getCodigo();

		String codigo = editoresCacheModel.codigo;

		if ((codigo != null) && (codigo.length() == 0)) {
			editoresCacheModel.codigo = null;
		}

		Date fecha_creado = getFecha_creado();

		if (fecha_creado != null) {
			editoresCacheModel.fecha_creado = fecha_creado.getTime();
		}
		else {
			editoresCacheModel.fecha_creado = Long.MIN_VALUE;
		}

		Date fecha_modificado = getFecha_modificado();

		if (fecha_modificado != null) {
			editoresCacheModel.fecha_modificado = fecha_modificado.getTime();
		}
		else {
			editoresCacheModel.fecha_modificado = Long.MIN_VALUE;
		}

		Date ultimo_inicio = getUltimo_inicio();

		if (ultimo_inicio != null) {
			editoresCacheModel.ultimo_inicio = ultimo_inicio.getTime();
		}
		else {
			editoresCacheModel.ultimo_inicio = Long.MIN_VALUE;
		}

		editoresCacheModel.nombres_edita = getNombres_edita();

		String nombres_edita = editoresCacheModel.nombres_edita;

		if ((nombres_edita != null) && (nombres_edita.length() == 0)) {
			editoresCacheModel.nombres_edita = null;
		}

		editoresCacheModel.apellidos_edita = getApellidos_edita();

		String apellidos_edita = editoresCacheModel.apellidos_edita;

		if ((apellidos_edita != null) && (apellidos_edita.length() == 0)) {
			editoresCacheModel.apellidos_edita = null;
		}

		editoresCacheModel.numero_documento_edita = getNumero_documento_edita();

		String numero_documento_edita = editoresCacheModel.numero_documento_edita;

		if ((numero_documento_edita != null) &&
				(numero_documento_edita.length() == 0)) {
			editoresCacheModel.numero_documento_edita = null;
		}

		editoresCacheModel.tipo_documento_edita = getTipo_documento_edita();

		String tipo_documento_edita = editoresCacheModel.tipo_documento_edita;

		if ((tipo_documento_edita != null) &&
				(tipo_documento_edita.length() == 0)) {
			editoresCacheModel.tipo_documento_edita = null;
		}

		editoresCacheModel.cargo_edita = getCargo_edita();

		String cargo_edita = editoresCacheModel.cargo_edita;

		if ((cargo_edita != null) && (cargo_edita.length() == 0)) {
			editoresCacheModel.cargo_edita = null;
		}

		editoresCacheModel.despacho_edita = getDespacho_edita();

		String despacho_edita = editoresCacheModel.despacho_edita;

		if ((despacho_edita != null) && (despacho_edita.length() == 0)) {
			editoresCacheModel.despacho_edita = null;
		}

		editoresCacheModel.userid = getUserid();

		String userid = editoresCacheModel.userid;

		if ((userid != null) && (userid.length() == 0)) {
			editoresCacheModel.userid = null;
		}

		return editoresCacheModel;
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

	private static ClassLoader _classLoader = editores.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			editores.class
		};
	private long _id;
	private String _correo;
	private String _originalCorreo;
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
	private String _originalUserid;
	private long _columnBitmask;
	private editores _escapedModelProxy;
}
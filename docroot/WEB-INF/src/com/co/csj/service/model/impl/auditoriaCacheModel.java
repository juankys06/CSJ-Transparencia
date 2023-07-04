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

import com.co.csj.service.model.auditoria;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing auditoria in entity cache.
 *
 * @author Equipo
 * @see auditoria
 * @generated
 */
public class auditoriaCacheModel implements CacheModel<auditoria>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", modificado_por=");
		sb.append(modificado_por);
		sb.append(", accion=");
		sb.append(accion);
		sb.append(", campo_modifico=");
		sb.append(campo_modifico);
		sb.append(", fecha=");
		sb.append(fecha);
		sb.append(", ano_vigencia=");
		sb.append(ano_vigencia);
		sb.append(", cedula_funcionario=");
		sb.append(cedula_funcionario);
		sb.append(", log_anterior=");
		sb.append(log_anterior);
		sb.append(", log_nuevo=");
		sb.append(log_nuevo);
		sb.append("}");

		return sb.toString();
	}

	public auditoria toEntityModel() {
		auditoriaImpl auditoriaImpl = new auditoriaImpl();

		auditoriaImpl.setId(id);

		if (modificado_por == null) {
			auditoriaImpl.setModificado_por(StringPool.BLANK);
		}
		else {
			auditoriaImpl.setModificado_por(modificado_por);
		}

		if (accion == null) {
			auditoriaImpl.setAccion(StringPool.BLANK);
		}
		else {
			auditoriaImpl.setAccion(accion);
		}

		if (campo_modifico == null) {
			auditoriaImpl.setCampo_modifico(StringPool.BLANK);
		}
		else {
			auditoriaImpl.setCampo_modifico(campo_modifico);
		}

		if (fecha == Long.MIN_VALUE) {
			auditoriaImpl.setFecha(null);
		}
		else {
			auditoriaImpl.setFecha(new Date(fecha));
		}

		auditoriaImpl.setAno_vigencia(ano_vigencia);

		if (cedula_funcionario == null) {
			auditoriaImpl.setCedula_funcionario(StringPool.BLANK);
		}
		else {
			auditoriaImpl.setCedula_funcionario(cedula_funcionario);
		}

		if (log_anterior == null) {
			auditoriaImpl.setLog_anterior(StringPool.BLANK);
		}
		else {
			auditoriaImpl.setLog_anterior(log_anterior);
		}

		if (log_nuevo == null) {
			auditoriaImpl.setLog_nuevo(StringPool.BLANK);
		}
		else {
			auditoriaImpl.setLog_nuevo(log_nuevo);
		}

		auditoriaImpl.resetOriginalValues();

		return auditoriaImpl;
	}

	public long id;
	public String modificado_por;
	public String accion;
	public String campo_modifico;
	public long fecha;
	public int ano_vigencia;
	public String cedula_funcionario;
	public String log_anterior;
	public String log_nuevo;
}
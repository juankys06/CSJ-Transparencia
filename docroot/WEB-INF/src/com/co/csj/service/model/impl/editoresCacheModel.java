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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing editores in entity cache.
 *
 * @author Equipo
 * @see editores
 * @generated
 */
public class editoresCacheModel implements CacheModel<editores>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{id=");
		sb.append(id);
		sb.append(", correo=");
		sb.append(correo);
		sb.append(", codigo=");
		sb.append(codigo);
		sb.append(", fecha_creado=");
		sb.append(fecha_creado);
		sb.append(", fecha_modificado=");
		sb.append(fecha_modificado);
		sb.append(", ultimo_inicio=");
		sb.append(ultimo_inicio);
		sb.append(", nombres_edita=");
		sb.append(nombres_edita);
		sb.append(", apellidos_edita=");
		sb.append(apellidos_edita);
		sb.append(", numero_documento_edita=");
		sb.append(numero_documento_edita);
		sb.append(", tipo_documento_edita=");
		sb.append(tipo_documento_edita);
		sb.append(", cargo_edita=");
		sb.append(cargo_edita);
		sb.append(", despacho_edita=");
		sb.append(despacho_edita);
		sb.append(", userid=");
		sb.append(userid);
		sb.append("}");

		return sb.toString();
	}

	public editores toEntityModel() {
		editoresImpl editoresImpl = new editoresImpl();

		editoresImpl.setId(id);

		if (correo == null) {
			editoresImpl.setCorreo(StringPool.BLANK);
		}
		else {
			editoresImpl.setCorreo(correo);
		}

		if (codigo == null) {
			editoresImpl.setCodigo(StringPool.BLANK);
		}
		else {
			editoresImpl.setCodigo(codigo);
		}

		if (fecha_creado == Long.MIN_VALUE) {
			editoresImpl.setFecha_creado(null);
		}
		else {
			editoresImpl.setFecha_creado(new Date(fecha_creado));
		}

		if (fecha_modificado == Long.MIN_VALUE) {
			editoresImpl.setFecha_modificado(null);
		}
		else {
			editoresImpl.setFecha_modificado(new Date(fecha_modificado));
		}

		if (ultimo_inicio == Long.MIN_VALUE) {
			editoresImpl.setUltimo_inicio(null);
		}
		else {
			editoresImpl.setUltimo_inicio(new Date(ultimo_inicio));
		}

		if (nombres_edita == null) {
			editoresImpl.setNombres_edita(StringPool.BLANK);
		}
		else {
			editoresImpl.setNombres_edita(nombres_edita);
		}

		if (apellidos_edita == null) {
			editoresImpl.setApellidos_edita(StringPool.BLANK);
		}
		else {
			editoresImpl.setApellidos_edita(apellidos_edita);
		}

		if (numero_documento_edita == null) {
			editoresImpl.setNumero_documento_edita(StringPool.BLANK);
		}
		else {
			editoresImpl.setNumero_documento_edita(numero_documento_edita);
		}

		if (tipo_documento_edita == null) {
			editoresImpl.setTipo_documento_edita(StringPool.BLANK);
		}
		else {
			editoresImpl.setTipo_documento_edita(tipo_documento_edita);
		}

		if (cargo_edita == null) {
			editoresImpl.setCargo_edita(StringPool.BLANK);
		}
		else {
			editoresImpl.setCargo_edita(cargo_edita);
		}

		if (despacho_edita == null) {
			editoresImpl.setDespacho_edita(StringPool.BLANK);
		}
		else {
			editoresImpl.setDespacho_edita(despacho_edita);
		}

		if (userid == null) {
			editoresImpl.setUserid(StringPool.BLANK);
		}
		else {
			editoresImpl.setUserid(userid);
		}

		editoresImpl.resetOriginalValues();

		return editoresImpl;
	}

	public long id;
	public String correo;
	public String codigo;
	public long fecha_creado;
	public long fecha_modificado;
	public long ultimo_inicio;
	public String nombres_edita;
	public String apellidos_edita;
	public String numero_documento_edita;
	public String tipo_documento_edita;
	public String cargo_edita;
	public String despacho_edita;
	public String userid;
}
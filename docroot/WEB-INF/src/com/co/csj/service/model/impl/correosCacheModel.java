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

import com.co.csj.service.model.correos;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing correos in entity cache.
 *
 * @author Equipo
 * @see correos
 * @generated
 */
public class correosCacheModel implements CacheModel<correos>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", cuentaCorreo=");
		sb.append(cuentaCorreo);
		sb.append(", nombre1=");
		sb.append(nombre1);
		sb.append(", apellido=");
		sb.append(apellido);
		sb.append(", cargo=");
		sb.append(cargo);
		sb.append(", cedulaResponsable=");
		sb.append(cedulaResponsable);
		sb.append(", codigoDespacho=");
		sb.append(codigoDespacho);
		sb.append("}");

		return sb.toString();
	}

	public correos toEntityModel() {
		correosImpl correosImpl = new correosImpl();

		correosImpl.setId(id);

		if (cuentaCorreo == null) {
			correosImpl.setCuentaCorreo(StringPool.BLANK);
		}
		else {
			correosImpl.setCuentaCorreo(cuentaCorreo);
		}

		if (nombre1 == null) {
			correosImpl.setNombre1(StringPool.BLANK);
		}
		else {
			correosImpl.setNombre1(nombre1);
		}

		if (apellido == null) {
			correosImpl.setApellido(StringPool.BLANK);
		}
		else {
			correosImpl.setApellido(apellido);
		}

		if (cargo == null) {
			correosImpl.setCargo(StringPool.BLANK);
		}
		else {
			correosImpl.setCargo(cargo);
		}

		if (cedulaResponsable == null) {
			correosImpl.setCedulaResponsable(StringPool.BLANK);
		}
		else {
			correosImpl.setCedulaResponsable(cedulaResponsable);
		}

		if (codigoDespacho == null) {
			correosImpl.setCodigoDespacho(StringPool.BLANK);
		}
		else {
			correosImpl.setCodigoDespacho(codigoDespacho);
		}

		correosImpl.resetOriginalValues();

		return correosImpl;
	}

	public long id;
	public String cuentaCorreo;
	public String nombre1;
	public String apellido;
	public String cargo;
	public String cedulaResponsable;
	public String codigoDespacho;
}
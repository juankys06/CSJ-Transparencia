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

import com.co.csj.service.model.planificacion;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing planificacion in entity cache.
 *
 * @author Equipo
 * @see planificacion
 * @generated
 */
public class planificacionCacheModel implements CacheModel<planificacion>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", anhio=");
		sb.append(anhio);
		sb.append(", fecha_inicio=");
		sb.append(fecha_inicio);
		sb.append(", fecha_fin=");
		sb.append(fecha_fin);
		sb.append(", usuario_finalizo=");
		sb.append(usuario_finalizo);
		sb.append(", estado=");
		sb.append(estado);
		sb.append("}");

		return sb.toString();
	}

	public planificacion toEntityModel() {
		planificacionImpl planificacionImpl = new planificacionImpl();

		planificacionImpl.setId(id);
		planificacionImpl.setAnhio(anhio);

		if (fecha_inicio == Long.MIN_VALUE) {
			planificacionImpl.setFecha_inicio(null);
		}
		else {
			planificacionImpl.setFecha_inicio(new Date(fecha_inicio));
		}

		if (fecha_fin == Long.MIN_VALUE) {
			planificacionImpl.setFecha_fin(null);
		}
		else {
			planificacionImpl.setFecha_fin(new Date(fecha_fin));
		}

		if (usuario_finalizo == null) {
			planificacionImpl.setUsuario_finalizo(StringPool.BLANK);
		}
		else {
			planificacionImpl.setUsuario_finalizo(usuario_finalizo);
		}

		if (estado == null) {
			planificacionImpl.setEstado(StringPool.BLANK);
		}
		else {
			planificacionImpl.setEstado(estado);
		}

		planificacionImpl.resetOriginalValues();

		return planificacionImpl;
	}

	public long id;
	public int anhio;
	public long fecha_inicio;
	public long fecha_fin;
	public String usuario_finalizo;
	public String estado;
}
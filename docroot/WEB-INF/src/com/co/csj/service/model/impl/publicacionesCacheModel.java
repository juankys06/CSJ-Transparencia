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

import com.co.csj.service.model.publicaciones;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing publicaciones in entity cache.
 *
 * @author Equipo
 * @see publicaciones
 * @generated
 */
public class publicacionesCacheModel implements CacheModel<publicaciones>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{id=");
		sb.append(id);
		sb.append(", fk_usuario=");
		sb.append(fk_usuario);
		sb.append(", despacho_usuario=");
		sb.append(despacho_usuario);
		sb.append(", archivo_hoja_vida=");
		sb.append(archivo_hoja_vida);
		sb.append(", archivo_declaracion_renta=");
		sb.append(archivo_declaracion_renta);
		sb.append(", archivo_formulario_bienes=");
		sb.append(archivo_formulario_bienes);
		sb.append(", fecha_solicitud=");
		sb.append(fecha_solicitud);
		sb.append(", fecha_publicacion=");
		sb.append(fecha_publicacion);
		sb.append(", aprobado_por=");
		sb.append(aprobado_por);
		sb.append(", fecha_negado=");
		sb.append(fecha_negado);
		sb.append(", negado_por=");
		sb.append(negado_por);
		sb.append(", anhio_publicacion=");
		sb.append(anhio_publicacion);
		sb.append(", fecha_modificado=");
		sb.append(fecha_modificado);
		sb.append(", estatus=");
		sb.append(estatus);
		sb.append(", causa_negado=");
		sb.append(causa_negado);
		sb.append(", cargo=");
		sb.append(cargo);
		sb.append(", retirado=");
		sb.append(retirado);
		sb.append("}");

		return sb.toString();
	}

	public publicaciones toEntityModel() {
		publicacionesImpl publicacionesImpl = new publicacionesImpl();

		publicacionesImpl.setId(id);

		if (fk_usuario == null) {
			publicacionesImpl.setFk_usuario(StringPool.BLANK);
		}
		else {
			publicacionesImpl.setFk_usuario(fk_usuario);
		}

		if (despacho_usuario == null) {
			publicacionesImpl.setDespacho_usuario(StringPool.BLANK);
		}
		else {
			publicacionesImpl.setDespacho_usuario(despacho_usuario);
		}

		if (archivo_hoja_vida == null) {
			publicacionesImpl.setArchivo_hoja_vida(StringPool.BLANK);
		}
		else {
			publicacionesImpl.setArchivo_hoja_vida(archivo_hoja_vida);
		}

		if (archivo_declaracion_renta == null) {
			publicacionesImpl.setArchivo_declaracion_renta(StringPool.BLANK);
		}
		else {
			publicacionesImpl.setArchivo_declaracion_renta(archivo_declaracion_renta);
		}

		if (archivo_formulario_bienes == null) {
			publicacionesImpl.setArchivo_formulario_bienes(StringPool.BLANK);
		}
		else {
			publicacionesImpl.setArchivo_formulario_bienes(archivo_formulario_bienes);
		}

		if (fecha_solicitud == Long.MIN_VALUE) {
			publicacionesImpl.setFecha_solicitud(null);
		}
		else {
			publicacionesImpl.setFecha_solicitud(new Date(fecha_solicitud));
		}

		if (fecha_publicacion == Long.MIN_VALUE) {
			publicacionesImpl.setFecha_publicacion(null);
		}
		else {
			publicacionesImpl.setFecha_publicacion(new Date(fecha_publicacion));
		}

		if (aprobado_por == null) {
			publicacionesImpl.setAprobado_por(StringPool.BLANK);
		}
		else {
			publicacionesImpl.setAprobado_por(aprobado_por);
		}

		if (fecha_negado == Long.MIN_VALUE) {
			publicacionesImpl.setFecha_negado(null);
		}
		else {
			publicacionesImpl.setFecha_negado(new Date(fecha_negado));
		}

		if (negado_por == null) {
			publicacionesImpl.setNegado_por(StringPool.BLANK);
		}
		else {
			publicacionesImpl.setNegado_por(negado_por);
		}

		publicacionesImpl.setAnhio_publicacion(anhio_publicacion);

		if (fecha_modificado == Long.MIN_VALUE) {
			publicacionesImpl.setFecha_modificado(null);
		}
		else {
			publicacionesImpl.setFecha_modificado(new Date(fecha_modificado));
		}

		if (estatus == null) {
			publicacionesImpl.setEstatus(StringPool.BLANK);
		}
		else {
			publicacionesImpl.setEstatus(estatus);
		}

		if (causa_negado == null) {
			publicacionesImpl.setCausa_negado(StringPool.BLANK);
		}
		else {
			publicacionesImpl.setCausa_negado(causa_negado);
		}

		if (cargo == null) {
			publicacionesImpl.setCargo(StringPool.BLANK);
		}
		else {
			publicacionesImpl.setCargo(cargo);
		}

		if (retirado == null) {
			publicacionesImpl.setRetirado(StringPool.BLANK);
		}
		else {
			publicacionesImpl.setRetirado(retirado);
		}

		publicacionesImpl.resetOriginalValues();

		return publicacionesImpl;
	}

	public long id;
	public String fk_usuario;
	public String despacho_usuario;
	public String archivo_hoja_vida;
	public String archivo_declaracion_renta;
	public String archivo_formulario_bienes;
	public long fecha_solicitud;
	public long fecha_publicacion;
	public String aprobado_por;
	public long fecha_negado;
	public String negado_por;
	public int anhio_publicacion;
	public long fecha_modificado;
	public String estatus;
	public String causa_negado;
	public String cargo;
	public String retirado;
}
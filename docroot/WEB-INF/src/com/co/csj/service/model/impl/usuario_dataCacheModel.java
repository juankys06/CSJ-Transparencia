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

import com.co.csj.service.model.usuario_data;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing usuario_data in entity cache.
 *
 * @author Equipo
 * @see usuario_data
 * @generated
 */
public class usuario_dataCacheModel implements CacheModel<usuario_data>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{numeroDocumento=");
		sb.append(numeroDocumento);
		sb.append(", tipoDocumento=");
		sb.append(tipoDocumento);
		sb.append(", nombres=");
		sb.append(nombres);
		sb.append(", apellidos=");
		sb.append(apellidos);
		sb.append(", cargo=");
		sb.append(cargo);
		sb.append(", fechaRegistro=");
		sb.append(fechaRegistro);
		sb.append(", fechaModificacion=");
		sb.append(fechaModificacion);
		sb.append(", datos_personales=");
		sb.append(datos_personales);
		sb.append(", despacho=");
		sb.append(despacho);
		sb.append(", formacion_academica=");
		sb.append(formacion_academica);
		sb.append(", experiencia_laboral=");
		sb.append(experiencia_laboral);
		sb.append(", tiempo_experiencia=");
		sb.append(tiempo_experiencia);
		sb.append(", bienes_y_rentas=");
		sb.append(bienes_y_rentas);
		sb.append(", informacion_complementaria=");
		sb.append(informacion_complementaria);
		sb.append(", conflicto_intereses=");
		sb.append(conflicto_intereses);
		sb.append(", archivo_declaracion_renta=");
		sb.append(archivo_declaracion_renta);
		sb.append(", archivo_formulario_bienes=");
		sb.append(archivo_formulario_bienes);
		sb.append(", archivo_hoja_vida=");
		sb.append(archivo_hoja_vida);
		sb.append(", porcentaje_dp=");
		sb.append(porcentaje_dp);
		sb.append(", porcentaje_fa=");
		sb.append(porcentaje_fa);
		sb.append(", porcentaje_el=");
		sb.append(porcentaje_el);
		sb.append(", porcentaje_te=");
		sb.append(porcentaje_te);
		sb.append(", porcentaje_br=");
		sb.append(porcentaje_br);
		sb.append(", porcentaje_ic=");
		sb.append(porcentaje_ic);
		sb.append(", porcentaje_ci=");
		sb.append(porcentaje_ci);
		sb.append(", retirado=");
		sb.append(retirado);
		sb.append("}");

		return sb.toString();
	}

	public usuario_data toEntityModel() {
		usuario_dataImpl usuario_dataImpl = new usuario_dataImpl();

		if (numeroDocumento == null) {
			usuario_dataImpl.setNumeroDocumento(StringPool.BLANK);
		}
		else {
			usuario_dataImpl.setNumeroDocumento(numeroDocumento);
		}

		if (tipoDocumento == null) {
			usuario_dataImpl.setTipoDocumento(StringPool.BLANK);
		}
		else {
			usuario_dataImpl.setTipoDocumento(tipoDocumento);
		}

		if (nombres == null) {
			usuario_dataImpl.setNombres(StringPool.BLANK);
		}
		else {
			usuario_dataImpl.setNombres(nombres);
		}

		if (apellidos == null) {
			usuario_dataImpl.setApellidos(StringPool.BLANK);
		}
		else {
			usuario_dataImpl.setApellidos(apellidos);
		}

		if (cargo == null) {
			usuario_dataImpl.setCargo(StringPool.BLANK);
		}
		else {
			usuario_dataImpl.setCargo(cargo);
		}

		if (fechaRegistro == Long.MIN_VALUE) {
			usuario_dataImpl.setFechaRegistro(null);
		}
		else {
			usuario_dataImpl.setFechaRegistro(new Date(fechaRegistro));
		}

		if (fechaModificacion == Long.MIN_VALUE) {
			usuario_dataImpl.setFechaModificacion(null);
		}
		else {
			usuario_dataImpl.setFechaModificacion(new Date(fechaModificacion));
		}

		if (datos_personales == null) {
			usuario_dataImpl.setDatos_personales(StringPool.BLANK);
		}
		else {
			usuario_dataImpl.setDatos_personales(datos_personales);
		}

		if (despacho == null) {
			usuario_dataImpl.setDespacho(StringPool.BLANK);
		}
		else {
			usuario_dataImpl.setDespacho(despacho);
		}

		if (formacion_academica == null) {
			usuario_dataImpl.setFormacion_academica(StringPool.BLANK);
		}
		else {
			usuario_dataImpl.setFormacion_academica(formacion_academica);
		}

		if (experiencia_laboral == null) {
			usuario_dataImpl.setExperiencia_laboral(StringPool.BLANK);
		}
		else {
			usuario_dataImpl.setExperiencia_laboral(experiencia_laboral);
		}

		if (tiempo_experiencia == null) {
			usuario_dataImpl.setTiempo_experiencia(StringPool.BLANK);
		}
		else {
			usuario_dataImpl.setTiempo_experiencia(tiempo_experiencia);
		}

		if (bienes_y_rentas == null) {
			usuario_dataImpl.setBienes_y_rentas(StringPool.BLANK);
		}
		else {
			usuario_dataImpl.setBienes_y_rentas(bienes_y_rentas);
		}

		if (informacion_complementaria == null) {
			usuario_dataImpl.setInformacion_complementaria(StringPool.BLANK);
		}
		else {
			usuario_dataImpl.setInformacion_complementaria(informacion_complementaria);
		}

		if (conflicto_intereses == null) {
			usuario_dataImpl.setConflicto_intereses(StringPool.BLANK);
		}
		else {
			usuario_dataImpl.setConflicto_intereses(conflicto_intereses);
		}

		if (archivo_declaracion_renta == null) {
			usuario_dataImpl.setArchivo_declaracion_renta(StringPool.BLANK);
		}
		else {
			usuario_dataImpl.setArchivo_declaracion_renta(archivo_declaracion_renta);
		}

		if (archivo_formulario_bienes == null) {
			usuario_dataImpl.setArchivo_formulario_bienes(StringPool.BLANK);
		}
		else {
			usuario_dataImpl.setArchivo_formulario_bienes(archivo_formulario_bienes);
		}

		if (archivo_hoja_vida == null) {
			usuario_dataImpl.setArchivo_hoja_vida(StringPool.BLANK);
		}
		else {
			usuario_dataImpl.setArchivo_hoja_vida(archivo_hoja_vida);
		}

		usuario_dataImpl.setPorcentaje_dp(porcentaje_dp);
		usuario_dataImpl.setPorcentaje_fa(porcentaje_fa);
		usuario_dataImpl.setPorcentaje_el(porcentaje_el);
		usuario_dataImpl.setPorcentaje_te(porcentaje_te);
		usuario_dataImpl.setPorcentaje_br(porcentaje_br);
		usuario_dataImpl.setPorcentaje_ic(porcentaje_ic);
		usuario_dataImpl.setPorcentaje_ci(porcentaje_ci);

		if (retirado == null) {
			usuario_dataImpl.setRetirado(StringPool.BLANK);
		}
		else {
			usuario_dataImpl.setRetirado(retirado);
		}

		usuario_dataImpl.resetOriginalValues();

		return usuario_dataImpl;
	}

	public String numeroDocumento;
	public String tipoDocumento;
	public String nombres;
	public String apellidos;
	public String cargo;
	public long fechaRegistro;
	public long fechaModificacion;
	public String datos_personales;
	public String despacho;
	public String formacion_academica;
	public String experiencia_laboral;
	public String tiempo_experiencia;
	public String bienes_y_rentas;
	public String informacion_complementaria;
	public String conflicto_intereses;
	public String archivo_declaracion_renta;
	public String archivo_formulario_bienes;
	public String archivo_hoja_vida;
	public double porcentaje_dp;
	public double porcentaje_fa;
	public double porcentaje_el;
	public double porcentaje_te;
	public double porcentaje_br;
	public double porcentaje_ic;
	public double porcentaje_ci;
	public String retirado;
}
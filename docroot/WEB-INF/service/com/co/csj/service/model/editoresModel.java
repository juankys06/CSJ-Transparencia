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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the editores service. Represents a row in the &quot;ley_trans_usuarios&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.co.csj.service.model.impl.editoresModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.co.csj.service.model.impl.editoresImpl}.
 * </p>
 *
 * @author Equipo
 * @see editores
 * @see com.co.csj.service.model.impl.editoresImpl
 * @see com.co.csj.service.model.impl.editoresModelImpl
 * @generated
 */
public interface editoresModel extends BaseModel<editores> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a editores model instance should use the {@link editores} interface instead.
	 */

	/**
	 * Returns the primary key of this editores.
	 *
	 * @return the primary key of this editores
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this editores.
	 *
	 * @param primaryKey the primary key of this editores
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this editores.
	 *
	 * @return the ID of this editores
	 */
	public long getId();

	/**
	 * Sets the ID of this editores.
	 *
	 * @param id the ID of this editores
	 */
	public void setId(long id);

	/**
	 * Returns the correo of this editores.
	 *
	 * @return the correo of this editores
	 */
	@AutoEscape
	public String getCorreo();

	/**
	 * Sets the correo of this editores.
	 *
	 * @param correo the correo of this editores
	 */
	public void setCorreo(String correo);

	/**
	 * Returns the codigo of this editores.
	 *
	 * @return the codigo of this editores
	 */
	@AutoEscape
	public String getCodigo();

	/**
	 * Sets the codigo of this editores.
	 *
	 * @param codigo the codigo of this editores
	 */
	public void setCodigo(String codigo);

	/**
	 * Returns the fecha_creado of this editores.
	 *
	 * @return the fecha_creado of this editores
	 */
	public Date getFecha_creado();

	/**
	 * Sets the fecha_creado of this editores.
	 *
	 * @param fecha_creado the fecha_creado of this editores
	 */
	public void setFecha_creado(Date fecha_creado);

	/**
	 * Returns the fecha_modificado of this editores.
	 *
	 * @return the fecha_modificado of this editores
	 */
	public Date getFecha_modificado();

	/**
	 * Sets the fecha_modificado of this editores.
	 *
	 * @param fecha_modificado the fecha_modificado of this editores
	 */
	public void setFecha_modificado(Date fecha_modificado);

	/**
	 * Returns the ultimo_inicio of this editores.
	 *
	 * @return the ultimo_inicio of this editores
	 */
	public Date getUltimo_inicio();

	/**
	 * Sets the ultimo_inicio of this editores.
	 *
	 * @param ultimo_inicio the ultimo_inicio of this editores
	 */
	public void setUltimo_inicio(Date ultimo_inicio);

	/**
	 * Returns the nombres_edita of this editores.
	 *
	 * @return the nombres_edita of this editores
	 */
	@AutoEscape
	public String getNombres_edita();

	/**
	 * Sets the nombres_edita of this editores.
	 *
	 * @param nombres_edita the nombres_edita of this editores
	 */
	public void setNombres_edita(String nombres_edita);

	/**
	 * Returns the apellidos_edita of this editores.
	 *
	 * @return the apellidos_edita of this editores
	 */
	@AutoEscape
	public String getApellidos_edita();

	/**
	 * Sets the apellidos_edita of this editores.
	 *
	 * @param apellidos_edita the apellidos_edita of this editores
	 */
	public void setApellidos_edita(String apellidos_edita);

	/**
	 * Returns the numero_documento_edita of this editores.
	 *
	 * @return the numero_documento_edita of this editores
	 */
	@AutoEscape
	public String getNumero_documento_edita();

	/**
	 * Sets the numero_documento_edita of this editores.
	 *
	 * @param numero_documento_edita the numero_documento_edita of this editores
	 */
	public void setNumero_documento_edita(String numero_documento_edita);

	/**
	 * Returns the tipo_documento_edita of this editores.
	 *
	 * @return the tipo_documento_edita of this editores
	 */
	@AutoEscape
	public String getTipo_documento_edita();

	/**
	 * Sets the tipo_documento_edita of this editores.
	 *
	 * @param tipo_documento_edita the tipo_documento_edita of this editores
	 */
	public void setTipo_documento_edita(String tipo_documento_edita);

	/**
	 * Returns the cargo_edita of this editores.
	 *
	 * @return the cargo_edita of this editores
	 */
	@AutoEscape
	public String getCargo_edita();

	/**
	 * Sets the cargo_edita of this editores.
	 *
	 * @param cargo_edita the cargo_edita of this editores
	 */
	public void setCargo_edita(String cargo_edita);

	/**
	 * Returns the despacho_edita of this editores.
	 *
	 * @return the despacho_edita of this editores
	 */
	@AutoEscape
	public String getDespacho_edita();

	/**
	 * Sets the despacho_edita of this editores.
	 *
	 * @param despacho_edita the despacho_edita of this editores
	 */
	public void setDespacho_edita(String despacho_edita);

	/**
	 * Returns the userid of this editores.
	 *
	 * @return the userid of this editores
	 */
	@AutoEscape
	public String getUserid();

	/**
	 * Sets the userid of this editores.
	 *
	 * @param userid the userid of this editores
	 */
	public void setUserid(String userid);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(editores editores);

	public int hashCode();

	public CacheModel<editores> toCacheModel();

	public editores toEscapedModel();

	public String toString();

	public String toXmlString();
}
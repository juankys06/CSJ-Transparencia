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

package com.co.csj.service.service.persistence;

import com.co.csj.service.model.planificacion;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the planificacion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Equipo
 * @see planificacionPersistenceImpl
 * @see planificacionUtil
 * @generated
 */
public interface planificacionPersistence extends BasePersistence<planificacion> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link planificacionUtil} to access the planificacion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the planificacion in the entity cache if it is enabled.
	*
	* @param planificacion the planificacion
	*/
	public void cacheResult(
		com.co.csj.service.model.planificacion planificacion);

	/**
	* Caches the planificacions in the entity cache if it is enabled.
	*
	* @param planificacions the planificacions
	*/
	public void cacheResult(
		java.util.List<com.co.csj.service.model.planificacion> planificacions);

	/**
	* Creates a new planificacion with the primary key. Does not add the planificacion to the database.
	*
	* @param id the primary key for the new planificacion
	* @return the new planificacion
	*/
	public com.co.csj.service.model.planificacion create(long id);

	/**
	* Removes the planificacion with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the planificacion
	* @return the planificacion that was removed
	* @throws com.co.csj.service.NoSuchplanificacionException if a planificacion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.planificacion remove(long id)
		throws com.co.csj.service.NoSuchplanificacionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.co.csj.service.model.planificacion updateImpl(
		com.co.csj.service.model.planificacion planificacion, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the planificacion with the primary key or throws a {@link com.co.csj.service.NoSuchplanificacionException} if it could not be found.
	*
	* @param id the primary key of the planificacion
	* @return the planificacion
	* @throws com.co.csj.service.NoSuchplanificacionException if a planificacion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.planificacion findByPrimaryKey(long id)
		throws com.co.csj.service.NoSuchplanificacionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the planificacion with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the planificacion
	* @return the planificacion, or <code>null</code> if a planificacion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.planificacion fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the planificacion where estado = &#63; or throws a {@link com.co.csj.service.NoSuchplanificacionException} if it could not be found.
	*
	* @param estado the estado
	* @return the matching planificacion
	* @throws com.co.csj.service.NoSuchplanificacionException if a matching planificacion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.planificacion findByPorEstado(
		java.lang.String estado)
		throws com.co.csj.service.NoSuchplanificacionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the planificacion where estado = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param estado the estado
	* @return the matching planificacion, or <code>null</code> if a matching planificacion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.planificacion fetchByPorEstado(
		java.lang.String estado)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the planificacion where estado = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param estado the estado
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching planificacion, or <code>null</code> if a matching planificacion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.planificacion fetchByPorEstado(
		java.lang.String estado, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the planificacions.
	*
	* @return the planificacions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.co.csj.service.model.planificacion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the planificacions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of planificacions
	* @param end the upper bound of the range of planificacions (not inclusive)
	* @return the range of planificacions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.co.csj.service.model.planificacion> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the planificacions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of planificacions
	* @param end the upper bound of the range of planificacions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of planificacions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.co.csj.service.model.planificacion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the planificacion where estado = &#63; from the database.
	*
	* @param estado the estado
	* @return the planificacion that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.planificacion removeByPorEstado(
		java.lang.String estado)
		throws com.co.csj.service.NoSuchplanificacionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the planificacions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of planificacions where estado = &#63;.
	*
	* @param estado the estado
	* @return the number of matching planificacions
	* @throws SystemException if a system exception occurred
	*/
	public int countByPorEstado(java.lang.String estado)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of planificacions.
	*
	* @return the number of planificacions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
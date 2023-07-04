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

import com.co.csj.service.model.usuario_data;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the usuario_data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Equipo
 * @see usuario_dataPersistenceImpl
 * @see usuario_dataUtil
 * @generated
 */
public interface usuario_dataPersistence extends BasePersistence<usuario_data> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link usuario_dataUtil} to access the usuario_data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the usuario_data in the entity cache if it is enabled.
	*
	* @param usuario_data the usuario_data
	*/
	public void cacheResult(com.co.csj.service.model.usuario_data usuario_data);

	/**
	* Caches the usuario_datas in the entity cache if it is enabled.
	*
	* @param usuario_datas the usuario_datas
	*/
	public void cacheResult(
		java.util.List<com.co.csj.service.model.usuario_data> usuario_datas);

	/**
	* Creates a new usuario_data with the primary key. Does not add the usuario_data to the database.
	*
	* @param numeroDocumento the primary key for the new usuario_data
	* @return the new usuario_data
	*/
	public com.co.csj.service.model.usuario_data create(
		java.lang.String numeroDocumento);

	/**
	* Removes the usuario_data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param numeroDocumento the primary key of the usuario_data
	* @return the usuario_data that was removed
	* @throws com.co.csj.service.NoSuchusuario_dataException if a usuario_data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.usuario_data remove(
		java.lang.String numeroDocumento)
		throws com.co.csj.service.NoSuchusuario_dataException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.co.csj.service.model.usuario_data updateImpl(
		com.co.csj.service.model.usuario_data usuario_data, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the usuario_data with the primary key or throws a {@link com.co.csj.service.NoSuchusuario_dataException} if it could not be found.
	*
	* @param numeroDocumento the primary key of the usuario_data
	* @return the usuario_data
	* @throws com.co.csj.service.NoSuchusuario_dataException if a usuario_data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.usuario_data findByPrimaryKey(
		java.lang.String numeroDocumento)
		throws com.co.csj.service.NoSuchusuario_dataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the usuario_data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param numeroDocumento the primary key of the usuario_data
	* @return the usuario_data, or <code>null</code> if a usuario_data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.usuario_data fetchByPrimaryKey(
		java.lang.String numeroDocumento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the usuario_datas.
	*
	* @return the usuario_datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.co.csj.service.model.usuario_data> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the usuario_datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of usuario_datas
	* @param end the upper bound of the range of usuario_datas (not inclusive)
	* @return the range of usuario_datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.co.csj.service.model.usuario_data> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the usuario_datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of usuario_datas
	* @param end the upper bound of the range of usuario_datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of usuario_datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.co.csj.service.model.usuario_data> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the usuario_datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of usuario_datas.
	*
	* @return the number of usuario_datas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
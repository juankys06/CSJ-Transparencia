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

import com.co.csj.service.model.editores;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the editores service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Equipo
 * @see editoresPersistenceImpl
 * @see editoresUtil
 * @generated
 */
public interface editoresPersistence extends BasePersistence<editores> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link editoresUtil} to access the editores persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the editores in the entity cache if it is enabled.
	*
	* @param editores the editores
	*/
	public void cacheResult(com.co.csj.service.model.editores editores);

	/**
	* Caches the editoreses in the entity cache if it is enabled.
	*
	* @param editoreses the editoreses
	*/
	public void cacheResult(
		java.util.List<com.co.csj.service.model.editores> editoreses);

	/**
	* Creates a new editores with the primary key. Does not add the editores to the database.
	*
	* @param id the primary key for the new editores
	* @return the new editores
	*/
	public com.co.csj.service.model.editores create(long id);

	/**
	* Removes the editores with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the editores
	* @return the editores that was removed
	* @throws com.co.csj.service.NoSucheditoresException if a editores with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.editores remove(long id)
		throws com.co.csj.service.NoSucheditoresException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.co.csj.service.model.editores updateImpl(
		com.co.csj.service.model.editores editores, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the editores with the primary key or throws a {@link com.co.csj.service.NoSucheditoresException} if it could not be found.
	*
	* @param id the primary key of the editores
	* @return the editores
	* @throws com.co.csj.service.NoSucheditoresException if a editores with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.editores findByPrimaryKey(long id)
		throws com.co.csj.service.NoSucheditoresException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the editores with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the editores
	* @return the editores, or <code>null</code> if a editores with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.editores fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the editores where correo = &#63; or throws a {@link com.co.csj.service.NoSucheditoresException} if it could not be found.
	*
	* @param correo the correo
	* @return the matching editores
	* @throws com.co.csj.service.NoSucheditoresException if a matching editores could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.editores findByPorCorreo(
		java.lang.String correo)
		throws com.co.csj.service.NoSucheditoresException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the editores where correo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param correo the correo
	* @return the matching editores, or <code>null</code> if a matching editores could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.editores fetchByPorCorreo(
		java.lang.String correo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the editores where correo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param correo the correo
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching editores, or <code>null</code> if a matching editores could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.editores fetchByPorCorreo(
		java.lang.String correo, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the editores where userid = &#63; or throws a {@link com.co.csj.service.NoSucheditoresException} if it could not be found.
	*
	* @param userid the userid
	* @return the matching editores
	* @throws com.co.csj.service.NoSucheditoresException if a matching editores could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.editores findByPorUserid(
		java.lang.String userid)
		throws com.co.csj.service.NoSucheditoresException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the editores where userid = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userid the userid
	* @return the matching editores, or <code>null</code> if a matching editores could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.editores fetchByPorUserid(
		java.lang.String userid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the editores where userid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userid the userid
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching editores, or <code>null</code> if a matching editores could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.editores fetchByPorUserid(
		java.lang.String userid, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the editoreses.
	*
	* @return the editoreses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.co.csj.service.model.editores> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the editoreses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of editoreses
	* @param end the upper bound of the range of editoreses (not inclusive)
	* @return the range of editoreses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.co.csj.service.model.editores> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the editoreses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of editoreses
	* @param end the upper bound of the range of editoreses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of editoreses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.co.csj.service.model.editores> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the editores where correo = &#63; from the database.
	*
	* @param correo the correo
	* @return the editores that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.editores removeByPorCorreo(
		java.lang.String correo)
		throws com.co.csj.service.NoSucheditoresException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the editores where userid = &#63; from the database.
	*
	* @param userid the userid
	* @return the editores that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.editores removeByPorUserid(
		java.lang.String userid)
		throws com.co.csj.service.NoSucheditoresException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the editoreses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of editoreses where correo = &#63;.
	*
	* @param correo the correo
	* @return the number of matching editoreses
	* @throws SystemException if a system exception occurred
	*/
	public int countByPorCorreo(java.lang.String correo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of editoreses where userid = &#63;.
	*
	* @param userid the userid
	* @return the number of matching editoreses
	* @throws SystemException if a system exception occurred
	*/
	public int countByPorUserid(java.lang.String userid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of editoreses.
	*
	* @return the number of editoreses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
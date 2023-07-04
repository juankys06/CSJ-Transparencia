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

import com.co.csj.service.model.auditoria;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the auditoria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Equipo
 * @see auditoriaPersistenceImpl
 * @see auditoriaUtil
 * @generated
 */
public interface auditoriaPersistence extends BasePersistence<auditoria> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link auditoriaUtil} to access the auditoria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the auditoria in the entity cache if it is enabled.
	*
	* @param auditoria the auditoria
	*/
	public void cacheResult(com.co.csj.service.model.auditoria auditoria);

	/**
	* Caches the auditorias in the entity cache if it is enabled.
	*
	* @param auditorias the auditorias
	*/
	public void cacheResult(
		java.util.List<com.co.csj.service.model.auditoria> auditorias);

	/**
	* Creates a new auditoria with the primary key. Does not add the auditoria to the database.
	*
	* @param id the primary key for the new auditoria
	* @return the new auditoria
	*/
	public com.co.csj.service.model.auditoria create(long id);

	/**
	* Removes the auditoria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the auditoria
	* @return the auditoria that was removed
	* @throws com.co.csj.service.NoSuchauditoriaException if a auditoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.auditoria remove(long id)
		throws com.co.csj.service.NoSuchauditoriaException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.co.csj.service.model.auditoria updateImpl(
		com.co.csj.service.model.auditoria auditoria, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the auditoria with the primary key or throws a {@link com.co.csj.service.NoSuchauditoriaException} if it could not be found.
	*
	* @param id the primary key of the auditoria
	* @return the auditoria
	* @throws com.co.csj.service.NoSuchauditoriaException if a auditoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.auditoria findByPrimaryKey(long id)
		throws com.co.csj.service.NoSuchauditoriaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the auditoria with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the auditoria
	* @return the auditoria, or <code>null</code> if a auditoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.auditoria fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the auditorias.
	*
	* @return the auditorias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.co.csj.service.model.auditoria> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the auditorias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of auditorias
	* @param end the upper bound of the range of auditorias (not inclusive)
	* @return the range of auditorias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.co.csj.service.model.auditoria> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the auditorias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of auditorias
	* @param end the upper bound of the range of auditorias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of auditorias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.co.csj.service.model.auditoria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the auditorias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of auditorias.
	*
	* @return the number of auditorias
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
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

import com.co.csj.service.model.correos;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the correos service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Equipo
 * @see correosPersistenceImpl
 * @see correosUtil
 * @generated
 */
public interface correosPersistence extends BasePersistence<correos> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link correosUtil} to access the correos persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the correos in the entity cache if it is enabled.
	*
	* @param correos the correos
	*/
	public void cacheResult(com.co.csj.service.model.correos correos);

	/**
	* Caches the correoses in the entity cache if it is enabled.
	*
	* @param correoses the correoses
	*/
	public void cacheResult(
		java.util.List<com.co.csj.service.model.correos> correoses);

	/**
	* Creates a new correos with the primary key. Does not add the correos to the database.
	*
	* @param id the primary key for the new correos
	* @return the new correos
	*/
	public com.co.csj.service.model.correos create(long id);

	/**
	* Removes the correos with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the correos
	* @return the correos that was removed
	* @throws com.co.csj.service.NoSuchcorreosException if a correos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.correos remove(long id)
		throws com.co.csj.service.NoSuchcorreosException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.co.csj.service.model.correos updateImpl(
		com.co.csj.service.model.correos correos, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the correos with the primary key or throws a {@link com.co.csj.service.NoSuchcorreosException} if it could not be found.
	*
	* @param id the primary key of the correos
	* @return the correos
	* @throws com.co.csj.service.NoSuchcorreosException if a correos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.correos findByPrimaryKey(long id)
		throws com.co.csj.service.NoSuchcorreosException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the correos with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the correos
	* @return the correos, or <code>null</code> if a correos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.correos fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the correos where cuentaCorreo = &#63; or throws a {@link com.co.csj.service.NoSuchcorreosException} if it could not be found.
	*
	* @param cuentaCorreo the cuenta correo
	* @return the matching correos
	* @throws com.co.csj.service.NoSuchcorreosException if a matching correos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.correos findByPorCorreo(
		java.lang.String cuentaCorreo)
		throws com.co.csj.service.NoSuchcorreosException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the correos where cuentaCorreo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cuentaCorreo the cuenta correo
	* @return the matching correos, or <code>null</code> if a matching correos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.correos fetchByPorCorreo(
		java.lang.String cuentaCorreo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the correos where cuentaCorreo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cuentaCorreo the cuenta correo
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching correos, or <code>null</code> if a matching correos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.correos fetchByPorCorreo(
		java.lang.String cuentaCorreo, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the correos where cuentaCorreo = &#63; and cedulaResponsable = &#63; or throws a {@link com.co.csj.service.NoSuchcorreosException} if it could not be found.
	*
	* @param cuentaCorreo the cuenta correo
	* @param cedulaResponsable the cedula responsable
	* @return the matching correos
	* @throws com.co.csj.service.NoSuchcorreosException if a matching correos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.correos findByPorCorreoCedula(
		java.lang.String cuentaCorreo, java.lang.String cedulaResponsable)
		throws com.co.csj.service.NoSuchcorreosException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the correos where cuentaCorreo = &#63; and cedulaResponsable = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cuentaCorreo the cuenta correo
	* @param cedulaResponsable the cedula responsable
	* @return the matching correos, or <code>null</code> if a matching correos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.correos fetchByPorCorreoCedula(
		java.lang.String cuentaCorreo, java.lang.String cedulaResponsable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the correos where cuentaCorreo = &#63; and cedulaResponsable = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cuentaCorreo the cuenta correo
	* @param cedulaResponsable the cedula responsable
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching correos, or <code>null</code> if a matching correos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.correos fetchByPorCorreoCedula(
		java.lang.String cuentaCorreo, java.lang.String cedulaResponsable,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the correoses.
	*
	* @return the correoses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.co.csj.service.model.correos> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the correoses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of correoses
	* @param end the upper bound of the range of correoses (not inclusive)
	* @return the range of correoses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.co.csj.service.model.correos> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the correoses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of correoses
	* @param end the upper bound of the range of correoses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of correoses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.co.csj.service.model.correos> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the correos where cuentaCorreo = &#63; from the database.
	*
	* @param cuentaCorreo the cuenta correo
	* @return the correos that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.correos removeByPorCorreo(
		java.lang.String cuentaCorreo)
		throws com.co.csj.service.NoSuchcorreosException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the correos where cuentaCorreo = &#63; and cedulaResponsable = &#63; from the database.
	*
	* @param cuentaCorreo the cuenta correo
	* @param cedulaResponsable the cedula responsable
	* @return the correos that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.correos removeByPorCorreoCedula(
		java.lang.String cuentaCorreo, java.lang.String cedulaResponsable)
		throws com.co.csj.service.NoSuchcorreosException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the correoses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of correoses where cuentaCorreo = &#63;.
	*
	* @param cuentaCorreo the cuenta correo
	* @return the number of matching correoses
	* @throws SystemException if a system exception occurred
	*/
	public int countByPorCorreo(java.lang.String cuentaCorreo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of correoses where cuentaCorreo = &#63; and cedulaResponsable = &#63;.
	*
	* @param cuentaCorreo the cuenta correo
	* @param cedulaResponsable the cedula responsable
	* @return the number of matching correoses
	* @throws SystemException if a system exception occurred
	*/
	public int countByPorCorreoCedula(java.lang.String cuentaCorreo,
		java.lang.String cedulaResponsable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of correoses.
	*
	* @return the number of correoses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
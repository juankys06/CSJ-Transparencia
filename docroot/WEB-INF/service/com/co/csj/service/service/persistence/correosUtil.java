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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the correos service. This utility wraps {@link correosPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Equipo
 * @see correosPersistence
 * @see correosPersistenceImpl
 * @generated
 */
public class correosUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(correos correos) {
		getPersistence().clearCache(correos);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<correos> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<correos> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<correos> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static correos update(correos correos, boolean merge)
		throws SystemException {
		return getPersistence().update(correos, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static correos update(correos correos, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(correos, merge, serviceContext);
	}

	/**
	* Caches the correos in the entity cache if it is enabled.
	*
	* @param correos the correos
	*/
	public static void cacheResult(com.co.csj.service.model.correos correos) {
		getPersistence().cacheResult(correos);
	}

	/**
	* Caches the correoses in the entity cache if it is enabled.
	*
	* @param correoses the correoses
	*/
	public static void cacheResult(
		java.util.List<com.co.csj.service.model.correos> correoses) {
		getPersistence().cacheResult(correoses);
	}

	/**
	* Creates a new correos with the primary key. Does not add the correos to the database.
	*
	* @param id the primary key for the new correos
	* @return the new correos
	*/
	public static com.co.csj.service.model.correos create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the correos with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the correos
	* @return the correos that was removed
	* @throws com.co.csj.service.NoSuchcorreosException if a correos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.correos remove(long id)
		throws com.co.csj.service.NoSuchcorreosException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.co.csj.service.model.correos updateImpl(
		com.co.csj.service.model.correos correos, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(correos, merge);
	}

	/**
	* Returns the correos with the primary key or throws a {@link com.co.csj.service.NoSuchcorreosException} if it could not be found.
	*
	* @param id the primary key of the correos
	* @return the correos
	* @throws com.co.csj.service.NoSuchcorreosException if a correos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.correos findByPrimaryKey(long id)
		throws com.co.csj.service.NoSuchcorreosException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the correos with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the correos
	* @return the correos, or <code>null</code> if a correos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.correos fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns the correos where cuentaCorreo = &#63; or throws a {@link com.co.csj.service.NoSuchcorreosException} if it could not be found.
	*
	* @param cuentaCorreo the cuenta correo
	* @return the matching correos
	* @throws com.co.csj.service.NoSuchcorreosException if a matching correos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.correos findByPorCorreo(
		java.lang.String cuentaCorreo)
		throws com.co.csj.service.NoSuchcorreosException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPorCorreo(cuentaCorreo);
	}

	/**
	* Returns the correos where cuentaCorreo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cuentaCorreo the cuenta correo
	* @return the matching correos, or <code>null</code> if a matching correos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.correos fetchByPorCorreo(
		java.lang.String cuentaCorreo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPorCorreo(cuentaCorreo);
	}

	/**
	* Returns the correos where cuentaCorreo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cuentaCorreo the cuenta correo
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching correos, or <code>null</code> if a matching correos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.correos fetchByPorCorreo(
		java.lang.String cuentaCorreo, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPorCorreo(cuentaCorreo, retrieveFromCache);
	}

	/**
	* Returns the correos where cuentaCorreo = &#63; and cedulaResponsable = &#63; or throws a {@link com.co.csj.service.NoSuchcorreosException} if it could not be found.
	*
	* @param cuentaCorreo the cuenta correo
	* @param cedulaResponsable the cedula responsable
	* @return the matching correos
	* @throws com.co.csj.service.NoSuchcorreosException if a matching correos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.correos findByPorCorreoCedula(
		java.lang.String cuentaCorreo, java.lang.String cedulaResponsable)
		throws com.co.csj.service.NoSuchcorreosException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPorCorreoCedula(cuentaCorreo, cedulaResponsable);
	}

	/**
	* Returns the correos where cuentaCorreo = &#63; and cedulaResponsable = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cuentaCorreo the cuenta correo
	* @param cedulaResponsable the cedula responsable
	* @return the matching correos, or <code>null</code> if a matching correos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.correos fetchByPorCorreoCedula(
		java.lang.String cuentaCorreo, java.lang.String cedulaResponsable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPorCorreoCedula(cuentaCorreo, cedulaResponsable);
	}

	/**
	* Returns the correos where cuentaCorreo = &#63; and cedulaResponsable = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cuentaCorreo the cuenta correo
	* @param cedulaResponsable the cedula responsable
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching correos, or <code>null</code> if a matching correos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.correos fetchByPorCorreoCedula(
		java.lang.String cuentaCorreo, java.lang.String cedulaResponsable,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPorCorreoCedula(cuentaCorreo, cedulaResponsable,
			retrieveFromCache);
	}

	/**
	* Returns all the correoses.
	*
	* @return the correoses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.co.csj.service.model.correos> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.co.csj.service.model.correos> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.co.csj.service.model.correos> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the correos where cuentaCorreo = &#63; from the database.
	*
	* @param cuentaCorreo the cuenta correo
	* @return the correos that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.correos removeByPorCorreo(
		java.lang.String cuentaCorreo)
		throws com.co.csj.service.NoSuchcorreosException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByPorCorreo(cuentaCorreo);
	}

	/**
	* Removes the correos where cuentaCorreo = &#63; and cedulaResponsable = &#63; from the database.
	*
	* @param cuentaCorreo the cuenta correo
	* @param cedulaResponsable the cedula responsable
	* @return the correos that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.correos removeByPorCorreoCedula(
		java.lang.String cuentaCorreo, java.lang.String cedulaResponsable)
		throws com.co.csj.service.NoSuchcorreosException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByPorCorreoCedula(cuentaCorreo, cedulaResponsable);
	}

	/**
	* Removes all the correoses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of correoses where cuentaCorreo = &#63;.
	*
	* @param cuentaCorreo the cuenta correo
	* @return the number of matching correoses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPorCorreo(java.lang.String cuentaCorreo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPorCorreo(cuentaCorreo);
	}

	/**
	* Returns the number of correoses where cuentaCorreo = &#63; and cedulaResponsable = &#63;.
	*
	* @param cuentaCorreo the cuenta correo
	* @param cedulaResponsable the cedula responsable
	* @return the number of matching correoses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPorCorreoCedula(java.lang.String cuentaCorreo,
		java.lang.String cedulaResponsable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPorCorreoCedula(cuentaCorreo, cedulaResponsable);
	}

	/**
	* Returns the number of correoses.
	*
	* @return the number of correoses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static correosPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (correosPersistence)PortletBeanLocatorUtil.locate(com.co.csj.service.service.ClpSerializer.getServletContextName(),
					correosPersistence.class.getName());

			ReferenceRegistry.registerReference(correosUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(correosPersistence persistence) {
	}

	private static correosPersistence _persistence;
}
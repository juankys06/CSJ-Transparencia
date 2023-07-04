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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the auditoria service. This utility wraps {@link auditoriaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Equipo
 * @see auditoriaPersistence
 * @see auditoriaPersistenceImpl
 * @generated
 */
public class auditoriaUtil {
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
	public static void clearCache(auditoria auditoria) {
		getPersistence().clearCache(auditoria);
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
	public static List<auditoria> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<auditoria> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<auditoria> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static auditoria update(auditoria auditoria, boolean merge)
		throws SystemException {
		return getPersistence().update(auditoria, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static auditoria update(auditoria auditoria, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(auditoria, merge, serviceContext);
	}

	/**
	* Caches the auditoria in the entity cache if it is enabled.
	*
	* @param auditoria the auditoria
	*/
	public static void cacheResult(com.co.csj.service.model.auditoria auditoria) {
		getPersistence().cacheResult(auditoria);
	}

	/**
	* Caches the auditorias in the entity cache if it is enabled.
	*
	* @param auditorias the auditorias
	*/
	public static void cacheResult(
		java.util.List<com.co.csj.service.model.auditoria> auditorias) {
		getPersistence().cacheResult(auditorias);
	}

	/**
	* Creates a new auditoria with the primary key. Does not add the auditoria to the database.
	*
	* @param id the primary key for the new auditoria
	* @return the new auditoria
	*/
	public static com.co.csj.service.model.auditoria create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the auditoria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the auditoria
	* @return the auditoria that was removed
	* @throws com.co.csj.service.NoSuchauditoriaException if a auditoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.auditoria remove(long id)
		throws com.co.csj.service.NoSuchauditoriaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.co.csj.service.model.auditoria updateImpl(
		com.co.csj.service.model.auditoria auditoria, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(auditoria, merge);
	}

	/**
	* Returns the auditoria with the primary key or throws a {@link com.co.csj.service.NoSuchauditoriaException} if it could not be found.
	*
	* @param id the primary key of the auditoria
	* @return the auditoria
	* @throws com.co.csj.service.NoSuchauditoriaException if a auditoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.auditoria findByPrimaryKey(long id)
		throws com.co.csj.service.NoSuchauditoriaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the auditoria with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the auditoria
	* @return the auditoria, or <code>null</code> if a auditoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.auditoria fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the auditorias.
	*
	* @return the auditorias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.co.csj.service.model.auditoria> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.co.csj.service.model.auditoria> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.co.csj.service.model.auditoria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the auditorias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of auditorias.
	*
	* @return the number of auditorias
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static auditoriaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (auditoriaPersistence)PortletBeanLocatorUtil.locate(com.co.csj.service.service.ClpSerializer.getServletContextName(),
					auditoriaPersistence.class.getName());

			ReferenceRegistry.registerReference(auditoriaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(auditoriaPersistence persistence) {
	}

	private static auditoriaPersistence _persistence;
}
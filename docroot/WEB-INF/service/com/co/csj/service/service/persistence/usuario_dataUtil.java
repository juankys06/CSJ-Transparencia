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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the usuario_data service. This utility wraps {@link usuario_dataPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Equipo
 * @see usuario_dataPersistence
 * @see usuario_dataPersistenceImpl
 * @generated
 */
public class usuario_dataUtil {
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
	public static void clearCache(usuario_data usuario_data) {
		getPersistence().clearCache(usuario_data);
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
	public static List<usuario_data> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<usuario_data> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<usuario_data> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static usuario_data update(usuario_data usuario_data, boolean merge)
		throws SystemException {
		return getPersistence().update(usuario_data, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static usuario_data update(usuario_data usuario_data, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(usuario_data, merge, serviceContext);
	}

	/**
	* Caches the usuario_data in the entity cache if it is enabled.
	*
	* @param usuario_data the usuario_data
	*/
	public static void cacheResult(
		com.co.csj.service.model.usuario_data usuario_data) {
		getPersistence().cacheResult(usuario_data);
	}

	/**
	* Caches the usuario_datas in the entity cache if it is enabled.
	*
	* @param usuario_datas the usuario_datas
	*/
	public static void cacheResult(
		java.util.List<com.co.csj.service.model.usuario_data> usuario_datas) {
		getPersistence().cacheResult(usuario_datas);
	}

	/**
	* Creates a new usuario_data with the primary key. Does not add the usuario_data to the database.
	*
	* @param numeroDocumento the primary key for the new usuario_data
	* @return the new usuario_data
	*/
	public static com.co.csj.service.model.usuario_data create(
		java.lang.String numeroDocumento) {
		return getPersistence().create(numeroDocumento);
	}

	/**
	* Removes the usuario_data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param numeroDocumento the primary key of the usuario_data
	* @return the usuario_data that was removed
	* @throws com.co.csj.service.NoSuchusuario_dataException if a usuario_data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.usuario_data remove(
		java.lang.String numeroDocumento)
		throws com.co.csj.service.NoSuchusuario_dataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(numeroDocumento);
	}

	public static com.co.csj.service.model.usuario_data updateImpl(
		com.co.csj.service.model.usuario_data usuario_data, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(usuario_data, merge);
	}

	/**
	* Returns the usuario_data with the primary key or throws a {@link com.co.csj.service.NoSuchusuario_dataException} if it could not be found.
	*
	* @param numeroDocumento the primary key of the usuario_data
	* @return the usuario_data
	* @throws com.co.csj.service.NoSuchusuario_dataException if a usuario_data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.usuario_data findByPrimaryKey(
		java.lang.String numeroDocumento)
		throws com.co.csj.service.NoSuchusuario_dataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(numeroDocumento);
	}

	/**
	* Returns the usuario_data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param numeroDocumento the primary key of the usuario_data
	* @return the usuario_data, or <code>null</code> if a usuario_data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.usuario_data fetchByPrimaryKey(
		java.lang.String numeroDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(numeroDocumento);
	}

	/**
	* Returns all the usuario_datas.
	*
	* @return the usuario_datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.co.csj.service.model.usuario_data> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.co.csj.service.model.usuario_data> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.co.csj.service.model.usuario_data> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the usuario_datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of usuario_datas.
	*
	* @return the number of usuario_datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static usuario_dataPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (usuario_dataPersistence)PortletBeanLocatorUtil.locate(com.co.csj.service.service.ClpSerializer.getServletContextName(),
					usuario_dataPersistence.class.getName());

			ReferenceRegistry.registerReference(usuario_dataUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(usuario_dataPersistence persistence) {
	}

	private static usuario_dataPersistence _persistence;
}
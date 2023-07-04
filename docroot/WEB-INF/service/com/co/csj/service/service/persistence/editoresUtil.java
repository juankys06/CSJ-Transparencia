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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the editores service. This utility wraps {@link editoresPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Equipo
 * @see editoresPersistence
 * @see editoresPersistenceImpl
 * @generated
 */
public class editoresUtil {
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
	public static void clearCache(editores editores) {
		getPersistence().clearCache(editores);
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
	public static List<editores> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<editores> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<editores> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static editores update(editores editores, boolean merge)
		throws SystemException {
		return getPersistence().update(editores, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static editores update(editores editores, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(editores, merge, serviceContext);
	}

	/**
	* Caches the editores in the entity cache if it is enabled.
	*
	* @param editores the editores
	*/
	public static void cacheResult(com.co.csj.service.model.editores editores) {
		getPersistence().cacheResult(editores);
	}

	/**
	* Caches the editoreses in the entity cache if it is enabled.
	*
	* @param editoreses the editoreses
	*/
	public static void cacheResult(
		java.util.List<com.co.csj.service.model.editores> editoreses) {
		getPersistence().cacheResult(editoreses);
	}

	/**
	* Creates a new editores with the primary key. Does not add the editores to the database.
	*
	* @param id the primary key for the new editores
	* @return the new editores
	*/
	public static com.co.csj.service.model.editores create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the editores with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the editores
	* @return the editores that was removed
	* @throws com.co.csj.service.NoSucheditoresException if a editores with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.editores remove(long id)
		throws com.co.csj.service.NoSucheditoresException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.co.csj.service.model.editores updateImpl(
		com.co.csj.service.model.editores editores, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(editores, merge);
	}

	/**
	* Returns the editores with the primary key or throws a {@link com.co.csj.service.NoSucheditoresException} if it could not be found.
	*
	* @param id the primary key of the editores
	* @return the editores
	* @throws com.co.csj.service.NoSucheditoresException if a editores with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.editores findByPrimaryKey(long id)
		throws com.co.csj.service.NoSucheditoresException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the editores with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the editores
	* @return the editores, or <code>null</code> if a editores with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.editores fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns the editores where correo = &#63; or throws a {@link com.co.csj.service.NoSucheditoresException} if it could not be found.
	*
	* @param correo the correo
	* @return the matching editores
	* @throws com.co.csj.service.NoSucheditoresException if a matching editores could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.editores findByPorCorreo(
		java.lang.String correo)
		throws com.co.csj.service.NoSucheditoresException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPorCorreo(correo);
	}

	/**
	* Returns the editores where correo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param correo the correo
	* @return the matching editores, or <code>null</code> if a matching editores could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.editores fetchByPorCorreo(
		java.lang.String correo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPorCorreo(correo);
	}

	/**
	* Returns the editores where correo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param correo the correo
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching editores, or <code>null</code> if a matching editores could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.editores fetchByPorCorreo(
		java.lang.String correo, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPorCorreo(correo, retrieveFromCache);
	}

	/**
	* Returns the editores where userid = &#63; or throws a {@link com.co.csj.service.NoSucheditoresException} if it could not be found.
	*
	* @param userid the userid
	* @return the matching editores
	* @throws com.co.csj.service.NoSucheditoresException if a matching editores could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.editores findByPorUserid(
		java.lang.String userid)
		throws com.co.csj.service.NoSucheditoresException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPorUserid(userid);
	}

	/**
	* Returns the editores where userid = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userid the userid
	* @return the matching editores, or <code>null</code> if a matching editores could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.editores fetchByPorUserid(
		java.lang.String userid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPorUserid(userid);
	}

	/**
	* Returns the editores where userid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userid the userid
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching editores, or <code>null</code> if a matching editores could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.editores fetchByPorUserid(
		java.lang.String userid, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPorUserid(userid, retrieveFromCache);
	}

	/**
	* Returns all the editoreses.
	*
	* @return the editoreses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.co.csj.service.model.editores> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.co.csj.service.model.editores> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.co.csj.service.model.editores> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the editores where correo = &#63; from the database.
	*
	* @param correo the correo
	* @return the editores that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.editores removeByPorCorreo(
		java.lang.String correo)
		throws com.co.csj.service.NoSucheditoresException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByPorCorreo(correo);
	}

	/**
	* Removes the editores where userid = &#63; from the database.
	*
	* @param userid the userid
	* @return the editores that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.editores removeByPorUserid(
		java.lang.String userid)
		throws com.co.csj.service.NoSucheditoresException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByPorUserid(userid);
	}

	/**
	* Removes all the editoreses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of editoreses where correo = &#63;.
	*
	* @param correo the correo
	* @return the number of matching editoreses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPorCorreo(java.lang.String correo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPorCorreo(correo);
	}

	/**
	* Returns the number of editoreses where userid = &#63;.
	*
	* @param userid the userid
	* @return the number of matching editoreses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPorUserid(java.lang.String userid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPorUserid(userid);
	}

	/**
	* Returns the number of editoreses.
	*
	* @return the number of editoreses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static editoresPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (editoresPersistence)PortletBeanLocatorUtil.locate(com.co.csj.service.service.ClpSerializer.getServletContextName(),
					editoresPersistence.class.getName());

			ReferenceRegistry.registerReference(editoresUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(editoresPersistence persistence) {
	}

	private static editoresPersistence _persistence;
}
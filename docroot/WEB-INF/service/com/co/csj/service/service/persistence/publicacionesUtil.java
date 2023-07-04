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

import com.co.csj.service.model.publicaciones;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the publicaciones service. This utility wraps {@link publicacionesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Equipo
 * @see publicacionesPersistence
 * @see publicacionesPersistenceImpl
 * @generated
 */
public class publicacionesUtil {
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
	public static void clearCache(publicaciones publicaciones) {
		getPersistence().clearCache(publicaciones);
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
	public static List<publicaciones> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<publicaciones> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<publicaciones> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static publicaciones update(publicaciones publicaciones,
		boolean merge) throws SystemException {
		return getPersistence().update(publicaciones, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static publicaciones update(publicaciones publicaciones,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(publicaciones, merge, serviceContext);
	}

	/**
	* Caches the publicaciones in the entity cache if it is enabled.
	*
	* @param publicaciones the publicaciones
	*/
	public static void cacheResult(
		com.co.csj.service.model.publicaciones publicaciones) {
		getPersistence().cacheResult(publicaciones);
	}

	/**
	* Caches the publicacioneses in the entity cache if it is enabled.
	*
	* @param publicacioneses the publicacioneses
	*/
	public static void cacheResult(
		java.util.List<com.co.csj.service.model.publicaciones> publicacioneses) {
		getPersistence().cacheResult(publicacioneses);
	}

	/**
	* Creates a new publicaciones with the primary key. Does not add the publicaciones to the database.
	*
	* @param id the primary key for the new publicaciones
	* @return the new publicaciones
	*/
	public static com.co.csj.service.model.publicaciones create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the publicaciones with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the publicaciones
	* @return the publicaciones that was removed
	* @throws com.co.csj.service.NoSuchpublicacionesException if a publicaciones with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.publicaciones remove(long id)
		throws com.co.csj.service.NoSuchpublicacionesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.co.csj.service.model.publicaciones updateImpl(
		com.co.csj.service.model.publicaciones publicaciones, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(publicaciones, merge);
	}

	/**
	* Returns the publicaciones with the primary key or throws a {@link com.co.csj.service.NoSuchpublicacionesException} if it could not be found.
	*
	* @param id the primary key of the publicaciones
	* @return the publicaciones
	* @throws com.co.csj.service.NoSuchpublicacionesException if a publicaciones with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.publicaciones findByPrimaryKey(
		long id)
		throws com.co.csj.service.NoSuchpublicacionesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the publicaciones with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the publicaciones
	* @return the publicaciones, or <code>null</code> if a publicaciones with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.publicaciones fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns the publicaciones where fk_usuario = &#63; and anhio_publicacion = &#63; and estatus = &#63; or throws a {@link com.co.csj.service.NoSuchpublicacionesException} if it could not be found.
	*
	* @param fk_usuario the fk_usuario
	* @param anhio_publicacion the anhio_publicacion
	* @param estatus the estatus
	* @return the matching publicaciones
	* @throws com.co.csj.service.NoSuchpublicacionesException if a matching publicaciones could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.publicaciones findByPorEstadoUsuario(
		java.lang.String fk_usuario, int anhio_publicacion,
		java.lang.String estatus)
		throws com.co.csj.service.NoSuchpublicacionesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPorEstadoUsuario(fk_usuario, anhio_publicacion,
			estatus);
	}

	/**
	* Returns the publicaciones where fk_usuario = &#63; and anhio_publicacion = &#63; and estatus = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param fk_usuario the fk_usuario
	* @param anhio_publicacion the anhio_publicacion
	* @param estatus the estatus
	* @return the matching publicaciones, or <code>null</code> if a matching publicaciones could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.publicaciones fetchByPorEstadoUsuario(
		java.lang.String fk_usuario, int anhio_publicacion,
		java.lang.String estatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPorEstadoUsuario(fk_usuario, anhio_publicacion,
			estatus);
	}

	/**
	* Returns the publicaciones where fk_usuario = &#63; and anhio_publicacion = &#63; and estatus = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param fk_usuario the fk_usuario
	* @param anhio_publicacion the anhio_publicacion
	* @param estatus the estatus
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching publicaciones, or <code>null</code> if a matching publicaciones could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.publicaciones fetchByPorEstadoUsuario(
		java.lang.String fk_usuario, int anhio_publicacion,
		java.lang.String estatus, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPorEstadoUsuario(fk_usuario, anhio_publicacion,
			estatus, retrieveFromCache);
	}

	/**
	* Returns all the publicacioneses where estatus = &#63; and anhio_publicacion = &#63;.
	*
	* @param estatus the estatus
	* @param anhio_publicacion the anhio_publicacion
	* @return the matching publicacioneses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.co.csj.service.model.publicaciones> findByPorEstadoSolicitudes(
		java.lang.String estatus, int anhio_publicacion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPorEstadoSolicitudes(estatus, anhio_publicacion);
	}

	/**
	* Returns a range of all the publicacioneses where estatus = &#63; and anhio_publicacion = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param estatus the estatus
	* @param anhio_publicacion the anhio_publicacion
	* @param start the lower bound of the range of publicacioneses
	* @param end the upper bound of the range of publicacioneses (not inclusive)
	* @return the range of matching publicacioneses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.co.csj.service.model.publicaciones> findByPorEstadoSolicitudes(
		java.lang.String estatus, int anhio_publicacion, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPorEstadoSolicitudes(estatus, anhio_publicacion,
			start, end);
	}

	/**
	* Returns an ordered range of all the publicacioneses where estatus = &#63; and anhio_publicacion = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param estatus the estatus
	* @param anhio_publicacion the anhio_publicacion
	* @param start the lower bound of the range of publicacioneses
	* @param end the upper bound of the range of publicacioneses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching publicacioneses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.co.csj.service.model.publicaciones> findByPorEstadoSolicitudes(
		java.lang.String estatus, int anhio_publicacion, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPorEstadoSolicitudes(estatus, anhio_publicacion,
			start, end, orderByComparator);
	}

	/**
	* Returns the first publicaciones in the ordered set where estatus = &#63; and anhio_publicacion = &#63;.
	*
	* @param estatus the estatus
	* @param anhio_publicacion the anhio_publicacion
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publicaciones
	* @throws com.co.csj.service.NoSuchpublicacionesException if a matching publicaciones could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.publicaciones findByPorEstadoSolicitudes_First(
		java.lang.String estatus, int anhio_publicacion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.co.csj.service.NoSuchpublicacionesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPorEstadoSolicitudes_First(estatus,
			anhio_publicacion, orderByComparator);
	}

	/**
	* Returns the first publicaciones in the ordered set where estatus = &#63; and anhio_publicacion = &#63;.
	*
	* @param estatus the estatus
	* @param anhio_publicacion the anhio_publicacion
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publicaciones, or <code>null</code> if a matching publicaciones could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.publicaciones fetchByPorEstadoSolicitudes_First(
		java.lang.String estatus, int anhio_publicacion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPorEstadoSolicitudes_First(estatus,
			anhio_publicacion, orderByComparator);
	}

	/**
	* Returns the last publicaciones in the ordered set where estatus = &#63; and anhio_publicacion = &#63;.
	*
	* @param estatus the estatus
	* @param anhio_publicacion the anhio_publicacion
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publicaciones
	* @throws com.co.csj.service.NoSuchpublicacionesException if a matching publicaciones could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.publicaciones findByPorEstadoSolicitudes_Last(
		java.lang.String estatus, int anhio_publicacion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.co.csj.service.NoSuchpublicacionesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPorEstadoSolicitudes_Last(estatus, anhio_publicacion,
			orderByComparator);
	}

	/**
	* Returns the last publicaciones in the ordered set where estatus = &#63; and anhio_publicacion = &#63;.
	*
	* @param estatus the estatus
	* @param anhio_publicacion the anhio_publicacion
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publicaciones, or <code>null</code> if a matching publicaciones could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.publicaciones fetchByPorEstadoSolicitudes_Last(
		java.lang.String estatus, int anhio_publicacion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPorEstadoSolicitudes_Last(estatus,
			anhio_publicacion, orderByComparator);
	}

	/**
	* Returns the publicacioneses before and after the current publicaciones in the ordered set where estatus = &#63; and anhio_publicacion = &#63;.
	*
	* @param id the primary key of the current publicaciones
	* @param estatus the estatus
	* @param anhio_publicacion the anhio_publicacion
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next publicaciones
	* @throws com.co.csj.service.NoSuchpublicacionesException if a publicaciones with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.publicaciones[] findByPorEstadoSolicitudes_PrevAndNext(
		long id, java.lang.String estatus, int anhio_publicacion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.co.csj.service.NoSuchpublicacionesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPorEstadoSolicitudes_PrevAndNext(id, estatus,
			anhio_publicacion, orderByComparator);
	}

	/**
	* Returns all the publicacioneses.
	*
	* @return the publicacioneses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.co.csj.service.model.publicaciones> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the publicacioneses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of publicacioneses
	* @param end the upper bound of the range of publicacioneses (not inclusive)
	* @return the range of publicacioneses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.co.csj.service.model.publicaciones> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the publicacioneses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of publicacioneses
	* @param end the upper bound of the range of publicacioneses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of publicacioneses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.co.csj.service.model.publicaciones> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the publicaciones where fk_usuario = &#63; and anhio_publicacion = &#63; and estatus = &#63; from the database.
	*
	* @param fk_usuario the fk_usuario
	* @param anhio_publicacion the anhio_publicacion
	* @param estatus the estatus
	* @return the publicaciones that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.publicaciones removeByPorEstadoUsuario(
		java.lang.String fk_usuario, int anhio_publicacion,
		java.lang.String estatus)
		throws com.co.csj.service.NoSuchpublicacionesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByPorEstadoUsuario(fk_usuario, anhio_publicacion,
			estatus);
	}

	/**
	* Removes all the publicacioneses where estatus = &#63; and anhio_publicacion = &#63; from the database.
	*
	* @param estatus the estatus
	* @param anhio_publicacion the anhio_publicacion
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPorEstadoSolicitudes(java.lang.String estatus,
		int anhio_publicacion)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPorEstadoSolicitudes(estatus, anhio_publicacion);
	}

	/**
	* Removes all the publicacioneses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of publicacioneses where fk_usuario = &#63; and anhio_publicacion = &#63; and estatus = &#63;.
	*
	* @param fk_usuario the fk_usuario
	* @param anhio_publicacion the anhio_publicacion
	* @param estatus the estatus
	* @return the number of matching publicacioneses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPorEstadoUsuario(java.lang.String fk_usuario,
		int anhio_publicacion, java.lang.String estatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPorEstadoUsuario(fk_usuario, anhio_publicacion,
			estatus);
	}

	/**
	* Returns the number of publicacioneses where estatus = &#63; and anhio_publicacion = &#63;.
	*
	* @param estatus the estatus
	* @param anhio_publicacion the anhio_publicacion
	* @return the number of matching publicacioneses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPorEstadoSolicitudes(java.lang.String estatus,
		int anhio_publicacion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPorEstadoSolicitudes(estatus, anhio_publicacion);
	}

	/**
	* Returns the number of publicacioneses.
	*
	* @return the number of publicacioneses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static publicacionesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (publicacionesPersistence)PortletBeanLocatorUtil.locate(com.co.csj.service.service.ClpSerializer.getServletContextName(),
					publicacionesPersistence.class.getName());

			ReferenceRegistry.registerReference(publicacionesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(publicacionesPersistence persistence) {
	}

	private static publicacionesPersistence _persistence;
}
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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the publicaciones service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Equipo
 * @see publicacionesPersistenceImpl
 * @see publicacionesUtil
 * @generated
 */
public interface publicacionesPersistence extends BasePersistence<publicaciones> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link publicacionesUtil} to access the publicaciones persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the publicaciones in the entity cache if it is enabled.
	*
	* @param publicaciones the publicaciones
	*/
	public void cacheResult(
		com.co.csj.service.model.publicaciones publicaciones);

	/**
	* Caches the publicacioneses in the entity cache if it is enabled.
	*
	* @param publicacioneses the publicacioneses
	*/
	public void cacheResult(
		java.util.List<com.co.csj.service.model.publicaciones> publicacioneses);

	/**
	* Creates a new publicaciones with the primary key. Does not add the publicaciones to the database.
	*
	* @param id the primary key for the new publicaciones
	* @return the new publicaciones
	*/
	public com.co.csj.service.model.publicaciones create(long id);

	/**
	* Removes the publicaciones with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the publicaciones
	* @return the publicaciones that was removed
	* @throws com.co.csj.service.NoSuchpublicacionesException if a publicaciones with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.publicaciones remove(long id)
		throws com.co.csj.service.NoSuchpublicacionesException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.co.csj.service.model.publicaciones updateImpl(
		com.co.csj.service.model.publicaciones publicaciones, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publicaciones with the primary key or throws a {@link com.co.csj.service.NoSuchpublicacionesException} if it could not be found.
	*
	* @param id the primary key of the publicaciones
	* @return the publicaciones
	* @throws com.co.csj.service.NoSuchpublicacionesException if a publicaciones with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.publicaciones findByPrimaryKey(long id)
		throws com.co.csj.service.NoSuchpublicacionesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publicaciones with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the publicaciones
	* @return the publicaciones, or <code>null</code> if a publicaciones with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.publicaciones fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.co.csj.service.model.publicaciones findByPorEstadoUsuario(
		java.lang.String fk_usuario, int anhio_publicacion,
		java.lang.String estatus)
		throws com.co.csj.service.NoSuchpublicacionesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publicaciones where fk_usuario = &#63; and anhio_publicacion = &#63; and estatus = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param fk_usuario the fk_usuario
	* @param anhio_publicacion the anhio_publicacion
	* @param estatus the estatus
	* @return the matching publicaciones, or <code>null</code> if a matching publicaciones could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.publicaciones fetchByPorEstadoUsuario(
		java.lang.String fk_usuario, int anhio_publicacion,
		java.lang.String estatus)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.co.csj.service.model.publicaciones fetchByPorEstadoUsuario(
		java.lang.String fk_usuario, int anhio_publicacion,
		java.lang.String estatus, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the publicacioneses where estatus = &#63; and anhio_publicacion = &#63;.
	*
	* @param estatus the estatus
	* @param anhio_publicacion the anhio_publicacion
	* @return the matching publicacioneses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.co.csj.service.model.publicaciones> findByPorEstadoSolicitudes(
		java.lang.String estatus, int anhio_publicacion)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.co.csj.service.model.publicaciones> findByPorEstadoSolicitudes(
		java.lang.String estatus, int anhio_publicacion, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.co.csj.service.model.publicaciones> findByPorEstadoSolicitudes(
		java.lang.String estatus, int anhio_publicacion, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.co.csj.service.model.publicaciones findByPorEstadoSolicitudes_First(
		java.lang.String estatus, int anhio_publicacion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.co.csj.service.NoSuchpublicacionesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first publicaciones in the ordered set where estatus = &#63; and anhio_publicacion = &#63;.
	*
	* @param estatus the estatus
	* @param anhio_publicacion the anhio_publicacion
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publicaciones, or <code>null</code> if a matching publicaciones could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.publicaciones fetchByPorEstadoSolicitudes_First(
		java.lang.String estatus, int anhio_publicacion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.co.csj.service.model.publicaciones findByPorEstadoSolicitudes_Last(
		java.lang.String estatus, int anhio_publicacion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.co.csj.service.NoSuchpublicacionesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last publicaciones in the ordered set where estatus = &#63; and anhio_publicacion = &#63;.
	*
	* @param estatus the estatus
	* @param anhio_publicacion the anhio_publicacion
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publicaciones, or <code>null</code> if a matching publicaciones could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.publicaciones fetchByPorEstadoSolicitudes_Last(
		java.lang.String estatus, int anhio_publicacion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.co.csj.service.model.publicaciones[] findByPorEstadoSolicitudes_PrevAndNext(
		long id, java.lang.String estatus, int anhio_publicacion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.co.csj.service.NoSuchpublicacionesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the publicacioneses.
	*
	* @return the publicacioneses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.co.csj.service.model.publicaciones> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.co.csj.service.model.publicaciones> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.co.csj.service.model.publicaciones> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the publicaciones where fk_usuario = &#63; and anhio_publicacion = &#63; and estatus = &#63; from the database.
	*
	* @param fk_usuario the fk_usuario
	* @param anhio_publicacion the anhio_publicacion
	* @param estatus the estatus
	* @return the publicaciones that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.publicaciones removeByPorEstadoUsuario(
		java.lang.String fk_usuario, int anhio_publicacion,
		java.lang.String estatus)
		throws com.co.csj.service.NoSuchpublicacionesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the publicacioneses where estatus = &#63; and anhio_publicacion = &#63; from the database.
	*
	* @param estatus the estatus
	* @param anhio_publicacion the anhio_publicacion
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPorEstadoSolicitudes(java.lang.String estatus,
		int anhio_publicacion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the publicacioneses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publicacioneses where fk_usuario = &#63; and anhio_publicacion = &#63; and estatus = &#63;.
	*
	* @param fk_usuario the fk_usuario
	* @param anhio_publicacion the anhio_publicacion
	* @param estatus the estatus
	* @return the number of matching publicacioneses
	* @throws SystemException if a system exception occurred
	*/
	public int countByPorEstadoUsuario(java.lang.String fk_usuario,
		int anhio_publicacion, java.lang.String estatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publicacioneses where estatus = &#63; and anhio_publicacion = &#63;.
	*
	* @param estatus the estatus
	* @param anhio_publicacion the anhio_publicacion
	* @return the number of matching publicacioneses
	* @throws SystemException if a system exception occurred
	*/
	public int countByPorEstadoSolicitudes(java.lang.String estatus,
		int anhio_publicacion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publicacioneses.
	*
	* @return the number of publicacioneses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
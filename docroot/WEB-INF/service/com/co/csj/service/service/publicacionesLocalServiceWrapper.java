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

package com.co.csj.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link publicacionesLocalService}.
 * </p>
 *
 * @author    Equipo
 * @see       publicacionesLocalService
 * @generated
 */
public class publicacionesLocalServiceWrapper
	implements publicacionesLocalService,
		ServiceWrapper<publicacionesLocalService> {
	public publicacionesLocalServiceWrapper(
		publicacionesLocalService publicacionesLocalService) {
		_publicacionesLocalService = publicacionesLocalService;
	}

	/**
	* Adds the publicaciones to the database. Also notifies the appropriate model listeners.
	*
	* @param publicaciones the publicaciones
	* @return the publicaciones that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.publicaciones addpublicaciones(
		com.co.csj.service.model.publicaciones publicaciones)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publicacionesLocalService.addpublicaciones(publicaciones);
	}

	/**
	* Creates a new publicaciones with the primary key. Does not add the publicaciones to the database.
	*
	* @param id the primary key for the new publicaciones
	* @return the new publicaciones
	*/
	public com.co.csj.service.model.publicaciones createpublicaciones(long id) {
		return _publicacionesLocalService.createpublicaciones(id);
	}

	/**
	* Deletes the publicaciones with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the publicaciones
	* @return the publicaciones that was removed
	* @throws PortalException if a publicaciones with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.publicaciones deletepublicaciones(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publicacionesLocalService.deletepublicaciones(id);
	}

	/**
	* Deletes the publicaciones from the database. Also notifies the appropriate model listeners.
	*
	* @param publicaciones the publicaciones
	* @return the publicaciones that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.publicaciones deletepublicaciones(
		com.co.csj.service.model.publicaciones publicaciones)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publicacionesLocalService.deletepublicaciones(publicaciones);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _publicacionesLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publicacionesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _publicacionesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publicacionesLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publicacionesLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.co.csj.service.model.publicaciones fetchpublicaciones(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publicacionesLocalService.fetchpublicaciones(id);
	}

	/**
	* Returns the publicaciones with the primary key.
	*
	* @param id the primary key of the publicaciones
	* @return the publicaciones
	* @throws PortalException if a publicaciones with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.publicaciones getpublicaciones(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publicacionesLocalService.getpublicaciones(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publicacionesLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.co.csj.service.model.publicaciones> getpublicacioneses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publicacionesLocalService.getpublicacioneses(start, end);
	}

	/**
	* Returns the number of publicacioneses.
	*
	* @return the number of publicacioneses
	* @throws SystemException if a system exception occurred
	*/
	public int getpublicacionesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publicacionesLocalService.getpublicacionesesCount();
	}

	/**
	* Updates the publicaciones in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param publicaciones the publicaciones
	* @return the publicaciones that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.publicaciones updatepublicaciones(
		com.co.csj.service.model.publicaciones publicaciones)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publicacionesLocalService.updatepublicaciones(publicaciones);
	}

	/**
	* Updates the publicaciones in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param publicaciones the publicaciones
	* @param merge whether to merge the publicaciones with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the publicaciones that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.publicaciones updatepublicaciones(
		com.co.csj.service.model.publicaciones publicaciones, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publicacionesLocalService.updatepublicaciones(publicaciones,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _publicacionesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_publicacionesLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _publicacionesLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public com.co.csj.service.model.publicaciones getPorEstadoUsuario(
		java.lang.String cedula, int ano, java.lang.String estado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publicacionesLocalService.getPorEstadoUsuario(cedula, ano,
			estado);
	}

	public java.util.List<com.co.csj.service.model.publicaciones> getPorEstadoSolicitudes(
		java.lang.String estado, int anhio)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publicacionesLocalService.getPorEstadoSolicitudes(estado, anhio);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public publicacionesLocalService getWrappedpublicacionesLocalService() {
		return _publicacionesLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedpublicacionesLocalService(
		publicacionesLocalService publicacionesLocalService) {
		_publicacionesLocalService = publicacionesLocalService;
	}

	public publicacionesLocalService getWrappedService() {
		return _publicacionesLocalService;
	}

	public void setWrappedService(
		publicacionesLocalService publicacionesLocalService) {
		_publicacionesLocalService = publicacionesLocalService;
	}

	private publicacionesLocalService _publicacionesLocalService;
}
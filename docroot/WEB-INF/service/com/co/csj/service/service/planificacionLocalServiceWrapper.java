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
 * This class is a wrapper for {@link planificacionLocalService}.
 * </p>
 *
 * @author    Equipo
 * @see       planificacionLocalService
 * @generated
 */
public class planificacionLocalServiceWrapper
	implements planificacionLocalService,
		ServiceWrapper<planificacionLocalService> {
	public planificacionLocalServiceWrapper(
		planificacionLocalService planificacionLocalService) {
		_planificacionLocalService = planificacionLocalService;
	}

	/**
	* Adds the planificacion to the database. Also notifies the appropriate model listeners.
	*
	* @param planificacion the planificacion
	* @return the planificacion that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.planificacion addplanificacion(
		com.co.csj.service.model.planificacion planificacion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _planificacionLocalService.addplanificacion(planificacion);
	}

	/**
	* Creates a new planificacion with the primary key. Does not add the planificacion to the database.
	*
	* @param id the primary key for the new planificacion
	* @return the new planificacion
	*/
	public com.co.csj.service.model.planificacion createplanificacion(long id) {
		return _planificacionLocalService.createplanificacion(id);
	}

	/**
	* Deletes the planificacion with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the planificacion
	* @return the planificacion that was removed
	* @throws PortalException if a planificacion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.planificacion deleteplanificacion(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _planificacionLocalService.deleteplanificacion(id);
	}

	/**
	* Deletes the planificacion from the database. Also notifies the appropriate model listeners.
	*
	* @param planificacion the planificacion
	* @return the planificacion that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.planificacion deleteplanificacion(
		com.co.csj.service.model.planificacion planificacion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _planificacionLocalService.deleteplanificacion(planificacion);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _planificacionLocalService.dynamicQuery();
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
		return _planificacionLocalService.dynamicQuery(dynamicQuery);
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
		return _planificacionLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _planificacionLocalService.dynamicQuery(dynamicQuery, start,
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
		return _planificacionLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.co.csj.service.model.planificacion fetchplanificacion(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _planificacionLocalService.fetchplanificacion(id);
	}

	/**
	* Returns the planificacion with the primary key.
	*
	* @param id the primary key of the planificacion
	* @return the planificacion
	* @throws PortalException if a planificacion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.planificacion getplanificacion(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _planificacionLocalService.getplanificacion(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _planificacionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the planificacions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of planificacions
	* @param end the upper bound of the range of planificacions (not inclusive)
	* @return the range of planificacions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.co.csj.service.model.planificacion> getplanificacions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _planificacionLocalService.getplanificacions(start, end);
	}

	/**
	* Returns the number of planificacions.
	*
	* @return the number of planificacions
	* @throws SystemException if a system exception occurred
	*/
	public int getplanificacionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _planificacionLocalService.getplanificacionsCount();
	}

	/**
	* Updates the planificacion in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param planificacion the planificacion
	* @return the planificacion that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.planificacion updateplanificacion(
		com.co.csj.service.model.planificacion planificacion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _planificacionLocalService.updateplanificacion(planificacion);
	}

	/**
	* Updates the planificacion in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param planificacion the planificacion
	* @param merge whether to merge the planificacion with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the planificacion that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.planificacion updateplanificacion(
		com.co.csj.service.model.planificacion planificacion, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _planificacionLocalService.updateplanificacion(planificacion,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _planificacionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_planificacionLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _planificacionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public com.co.csj.service.model.planificacion PorEstado(
		java.lang.String estado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _planificacionLocalService.PorEstado(estado);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public planificacionLocalService getWrappedplanificacionLocalService() {
		return _planificacionLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedplanificacionLocalService(
		planificacionLocalService planificacionLocalService) {
		_planificacionLocalService = planificacionLocalService;
	}

	public planificacionLocalService getWrappedService() {
		return _planificacionLocalService;
	}

	public void setWrappedService(
		planificacionLocalService planificacionLocalService) {
		_planificacionLocalService = planificacionLocalService;
	}

	private planificacionLocalService _planificacionLocalService;
}
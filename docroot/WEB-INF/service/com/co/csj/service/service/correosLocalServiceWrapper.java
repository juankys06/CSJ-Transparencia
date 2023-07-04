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
 * This class is a wrapper for {@link correosLocalService}.
 * </p>
 *
 * @author    Equipo
 * @see       correosLocalService
 * @generated
 */
public class correosLocalServiceWrapper implements correosLocalService,
	ServiceWrapper<correosLocalService> {
	public correosLocalServiceWrapper(correosLocalService correosLocalService) {
		_correosLocalService = correosLocalService;
	}

	/**
	* Adds the correos to the database. Also notifies the appropriate model listeners.
	*
	* @param correos the correos
	* @return the correos that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.correos addcorreos(
		com.co.csj.service.model.correos correos)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _correosLocalService.addcorreos(correos);
	}

	/**
	* Creates a new correos with the primary key. Does not add the correos to the database.
	*
	* @param id the primary key for the new correos
	* @return the new correos
	*/
	public com.co.csj.service.model.correos createcorreos(long id) {
		return _correosLocalService.createcorreos(id);
	}

	/**
	* Deletes the correos with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the correos
	* @return the correos that was removed
	* @throws PortalException if a correos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.correos deletecorreos(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _correosLocalService.deletecorreos(id);
	}

	/**
	* Deletes the correos from the database. Also notifies the appropriate model listeners.
	*
	* @param correos the correos
	* @return the correos that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.correos deletecorreos(
		com.co.csj.service.model.correos correos)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _correosLocalService.deletecorreos(correos);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _correosLocalService.dynamicQuery();
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
		return _correosLocalService.dynamicQuery(dynamicQuery);
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
		return _correosLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _correosLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _correosLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.co.csj.service.model.correos fetchcorreos(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _correosLocalService.fetchcorreos(id);
	}

	/**
	* Returns the correos with the primary key.
	*
	* @param id the primary key of the correos
	* @return the correos
	* @throws PortalException if a correos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.correos getcorreos(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _correosLocalService.getcorreos(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _correosLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.co.csj.service.model.correos> getcorreoses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _correosLocalService.getcorreoses(start, end);
	}

	/**
	* Returns the number of correoses.
	*
	* @return the number of correoses
	* @throws SystemException if a system exception occurred
	*/
	public int getcorreosesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _correosLocalService.getcorreosesCount();
	}

	/**
	* Updates the correos in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param correos the correos
	* @return the correos that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.correos updatecorreos(
		com.co.csj.service.model.correos correos)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _correosLocalService.updatecorreos(correos);
	}

	/**
	* Updates the correos in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param correos the correos
	* @param merge whether to merge the correos with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the correos that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.correos updatecorreos(
		com.co.csj.service.model.correos correos, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _correosLocalService.updatecorreos(correos, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _correosLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_correosLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _correosLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public com.co.csj.service.model.correos PorCorreoCedula(
		java.lang.String correo, java.lang.String cedula)
		throws com.co.csj.service.NoSuchcorreosException,
			com.liferay.portal.kernel.exception.SystemException {
		return _correosLocalService.PorCorreoCedula(correo, cedula);
	}

	public com.co.csj.service.model.correos PorCorreo(java.lang.String correo)
		throws com.co.csj.service.NoSuchcorreosException,
			com.liferay.portal.kernel.exception.SystemException {
		return _correosLocalService.PorCorreo(correo);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public correosLocalService getWrappedcorreosLocalService() {
		return _correosLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedcorreosLocalService(
		correosLocalService correosLocalService) {
		_correosLocalService = correosLocalService;
	}

	public correosLocalService getWrappedService() {
		return _correosLocalService;
	}

	public void setWrappedService(correosLocalService correosLocalService) {
		_correosLocalService = correosLocalService;
	}

	private correosLocalService _correosLocalService;
}
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
 * This class is a wrapper for {@link usuario_dataLocalService}.
 * </p>
 *
 * @author    Equipo
 * @see       usuario_dataLocalService
 * @generated
 */
public class usuario_dataLocalServiceWrapper implements usuario_dataLocalService,
	ServiceWrapper<usuario_dataLocalService> {
	public usuario_dataLocalServiceWrapper(
		usuario_dataLocalService usuario_dataLocalService) {
		_usuario_dataLocalService = usuario_dataLocalService;
	}

	/**
	* Adds the usuario_data to the database. Also notifies the appropriate model listeners.
	*
	* @param usuario_data the usuario_data
	* @return the usuario_data that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.usuario_data addusuario_data(
		com.co.csj.service.model.usuario_data usuario_data)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usuario_dataLocalService.addusuario_data(usuario_data);
	}

	/**
	* Creates a new usuario_data with the primary key. Does not add the usuario_data to the database.
	*
	* @param numeroDocumento the primary key for the new usuario_data
	* @return the new usuario_data
	*/
	public com.co.csj.service.model.usuario_data createusuario_data(
		java.lang.String numeroDocumento) {
		return _usuario_dataLocalService.createusuario_data(numeroDocumento);
	}

	/**
	* Deletes the usuario_data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param numeroDocumento the primary key of the usuario_data
	* @return the usuario_data that was removed
	* @throws PortalException if a usuario_data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.usuario_data deleteusuario_data(
		java.lang.String numeroDocumento)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _usuario_dataLocalService.deleteusuario_data(numeroDocumento);
	}

	/**
	* Deletes the usuario_data from the database. Also notifies the appropriate model listeners.
	*
	* @param usuario_data the usuario_data
	* @return the usuario_data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.usuario_data deleteusuario_data(
		com.co.csj.service.model.usuario_data usuario_data)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usuario_dataLocalService.deleteusuario_data(usuario_data);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _usuario_dataLocalService.dynamicQuery();
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
		return _usuario_dataLocalService.dynamicQuery(dynamicQuery);
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
		return _usuario_dataLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _usuario_dataLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _usuario_dataLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.co.csj.service.model.usuario_data fetchusuario_data(
		java.lang.String numeroDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usuario_dataLocalService.fetchusuario_data(numeroDocumento);
	}

	/**
	* Returns the usuario_data with the primary key.
	*
	* @param numeroDocumento the primary key of the usuario_data
	* @return the usuario_data
	* @throws PortalException if a usuario_data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.usuario_data getusuario_data(
		java.lang.String numeroDocumento)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _usuario_dataLocalService.getusuario_data(numeroDocumento);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _usuario_dataLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.co.csj.service.model.usuario_data> getusuario_datas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usuario_dataLocalService.getusuario_datas(start, end);
	}

	/**
	* Returns the number of usuario_datas.
	*
	* @return the number of usuario_datas
	* @throws SystemException if a system exception occurred
	*/
	public int getusuario_datasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usuario_dataLocalService.getusuario_datasCount();
	}

	/**
	* Updates the usuario_data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param usuario_data the usuario_data
	* @return the usuario_data that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.usuario_data updateusuario_data(
		com.co.csj.service.model.usuario_data usuario_data)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usuario_dataLocalService.updateusuario_data(usuario_data);
	}

	/**
	* Updates the usuario_data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param usuario_data the usuario_data
	* @param merge whether to merge the usuario_data with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the usuario_data that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.usuario_data updateusuario_data(
		com.co.csj.service.model.usuario_data usuario_data, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usuario_dataLocalService.updateusuario_data(usuario_data, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _usuario_dataLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_usuario_dataLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _usuario_dataLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public usuario_dataLocalService getWrappedusuario_dataLocalService() {
		return _usuario_dataLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedusuario_dataLocalService(
		usuario_dataLocalService usuario_dataLocalService) {
		_usuario_dataLocalService = usuario_dataLocalService;
	}

	public usuario_dataLocalService getWrappedService() {
		return _usuario_dataLocalService;
	}

	public void setWrappedService(
		usuario_dataLocalService usuario_dataLocalService) {
		_usuario_dataLocalService = usuario_dataLocalService;
	}

	private usuario_dataLocalService _usuario_dataLocalService;
}
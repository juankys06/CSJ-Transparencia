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
 * This class is a wrapper for {@link editoresLocalService}.
 * </p>
 *
 * @author    Equipo
 * @see       editoresLocalService
 * @generated
 */
public class editoresLocalServiceWrapper implements editoresLocalService,
	ServiceWrapper<editoresLocalService> {
	public editoresLocalServiceWrapper(
		editoresLocalService editoresLocalService) {
		_editoresLocalService = editoresLocalService;
	}

	/**
	* Adds the editores to the database. Also notifies the appropriate model listeners.
	*
	* @param editores the editores
	* @return the editores that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.editores addeditores(
		com.co.csj.service.model.editores editores)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _editoresLocalService.addeditores(editores);
	}

	/**
	* Creates a new editores with the primary key. Does not add the editores to the database.
	*
	* @param id the primary key for the new editores
	* @return the new editores
	*/
	public com.co.csj.service.model.editores createeditores(long id) {
		return _editoresLocalService.createeditores(id);
	}

	/**
	* Deletes the editores with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the editores
	* @return the editores that was removed
	* @throws PortalException if a editores with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.editores deleteeditores(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _editoresLocalService.deleteeditores(id);
	}

	/**
	* Deletes the editores from the database. Also notifies the appropriate model listeners.
	*
	* @param editores the editores
	* @return the editores that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.editores deleteeditores(
		com.co.csj.service.model.editores editores)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _editoresLocalService.deleteeditores(editores);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _editoresLocalService.dynamicQuery();
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
		return _editoresLocalService.dynamicQuery(dynamicQuery);
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
		return _editoresLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _editoresLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _editoresLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.co.csj.service.model.editores fetcheditores(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _editoresLocalService.fetcheditores(id);
	}

	/**
	* Returns the editores with the primary key.
	*
	* @param id the primary key of the editores
	* @return the editores
	* @throws PortalException if a editores with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.editores geteditores(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _editoresLocalService.geteditores(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _editoresLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.co.csj.service.model.editores> geteditoreses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _editoresLocalService.geteditoreses(start, end);
	}

	/**
	* Returns the number of editoreses.
	*
	* @return the number of editoreses
	* @throws SystemException if a system exception occurred
	*/
	public int geteditoresesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _editoresLocalService.geteditoresesCount();
	}

	/**
	* Updates the editores in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param editores the editores
	* @return the editores that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.editores updateeditores(
		com.co.csj.service.model.editores editores)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _editoresLocalService.updateeditores(editores);
	}

	/**
	* Updates the editores in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param editores the editores
	* @param merge whether to merge the editores with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the editores that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.co.csj.service.model.editores updateeditores(
		com.co.csj.service.model.editores editores, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _editoresLocalService.updateeditores(editores, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _editoresLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_editoresLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _editoresLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public com.co.csj.service.model.editores getPorCorreo(
		java.lang.String correo)
		throws com.co.csj.service.NoSucheditoresException,
			com.liferay.portal.kernel.exception.SystemException {
		return _editoresLocalService.getPorCorreo(correo);
	}

	public com.co.csj.service.model.editores getPorUserid(
		java.lang.String userId)
		throws com.co.csj.service.NoSucheditoresException,
			com.liferay.portal.kernel.exception.SystemException {
		return _editoresLocalService.getPorUserid(userId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public editoresLocalService getWrappededitoresLocalService() {
		return _editoresLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappededitoresLocalService(
		editoresLocalService editoresLocalService) {
		_editoresLocalService = editoresLocalService;
	}

	public editoresLocalService getWrappedService() {
		return _editoresLocalService;
	}

	public void setWrappedService(editoresLocalService editoresLocalService) {
		_editoresLocalService = editoresLocalService;
	}

	private editoresLocalService _editoresLocalService;
}
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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the usuario_data local service. This utility wraps {@link com.co.csj.service.service.impl.usuario_dataLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Equipo
 * @see usuario_dataLocalService
 * @see com.co.csj.service.service.base.usuario_dataLocalServiceBaseImpl
 * @see com.co.csj.service.service.impl.usuario_dataLocalServiceImpl
 * @generated
 */
public class usuario_dataLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.co.csj.service.service.impl.usuario_dataLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the usuario_data to the database. Also notifies the appropriate model listeners.
	*
	* @param usuario_data the usuario_data
	* @return the usuario_data that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.usuario_data addusuario_data(
		com.co.csj.service.model.usuario_data usuario_data)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addusuario_data(usuario_data);
	}

	/**
	* Creates a new usuario_data with the primary key. Does not add the usuario_data to the database.
	*
	* @param numeroDocumento the primary key for the new usuario_data
	* @return the new usuario_data
	*/
	public static com.co.csj.service.model.usuario_data createusuario_data(
		java.lang.String numeroDocumento) {
		return getService().createusuario_data(numeroDocumento);
	}

	/**
	* Deletes the usuario_data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param numeroDocumento the primary key of the usuario_data
	* @return the usuario_data that was removed
	* @throws PortalException if a usuario_data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.usuario_data deleteusuario_data(
		java.lang.String numeroDocumento)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteusuario_data(numeroDocumento);
	}

	/**
	* Deletes the usuario_data from the database. Also notifies the appropriate model listeners.
	*
	* @param usuario_data the usuario_data
	* @return the usuario_data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.usuario_data deleteusuario_data(
		com.co.csj.service.model.usuario_data usuario_data)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteusuario_data(usuario_data);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.co.csj.service.model.usuario_data fetchusuario_data(
		java.lang.String numeroDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchusuario_data(numeroDocumento);
	}

	/**
	* Returns the usuario_data with the primary key.
	*
	* @param numeroDocumento the primary key of the usuario_data
	* @return the usuario_data
	* @throws PortalException if a usuario_data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.usuario_data getusuario_data(
		java.lang.String numeroDocumento)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getusuario_data(numeroDocumento);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.co.csj.service.model.usuario_data> getusuario_datas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getusuario_datas(start, end);
	}

	/**
	* Returns the number of usuario_datas.
	*
	* @return the number of usuario_datas
	* @throws SystemException if a system exception occurred
	*/
	public static int getusuario_datasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getusuario_datasCount();
	}

	/**
	* Updates the usuario_data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param usuario_data the usuario_data
	* @return the usuario_data that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.usuario_data updateusuario_data(
		com.co.csj.service.model.usuario_data usuario_data)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateusuario_data(usuario_data);
	}

	/**
	* Updates the usuario_data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param usuario_data the usuario_data
	* @param merge whether to merge the usuario_data with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the usuario_data that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.usuario_data updateusuario_data(
		com.co.csj.service.model.usuario_data usuario_data, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateusuario_data(usuario_data, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static usuario_dataLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					usuario_dataLocalService.class.getName());

			if (invokableLocalService instanceof usuario_dataLocalService) {
				_service = (usuario_dataLocalService)invokableLocalService;
			}
			else {
				_service = new usuario_dataLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(usuario_dataLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(usuario_dataLocalService service) {
	}

	private static usuario_dataLocalService _service;
}
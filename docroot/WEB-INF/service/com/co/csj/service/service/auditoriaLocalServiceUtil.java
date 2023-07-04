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
 * The utility for the auditoria local service. This utility wraps {@link com.co.csj.service.service.impl.auditoriaLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Equipo
 * @see auditoriaLocalService
 * @see com.co.csj.service.service.base.auditoriaLocalServiceBaseImpl
 * @see com.co.csj.service.service.impl.auditoriaLocalServiceImpl
 * @generated
 */
public class auditoriaLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.co.csj.service.service.impl.auditoriaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the auditoria to the database. Also notifies the appropriate model listeners.
	*
	* @param auditoria the auditoria
	* @return the auditoria that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.auditoria addauditoria(
		com.co.csj.service.model.auditoria auditoria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addauditoria(auditoria);
	}

	/**
	* Creates a new auditoria with the primary key. Does not add the auditoria to the database.
	*
	* @param id the primary key for the new auditoria
	* @return the new auditoria
	*/
	public static com.co.csj.service.model.auditoria createauditoria(long id) {
		return getService().createauditoria(id);
	}

	/**
	* Deletes the auditoria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the auditoria
	* @return the auditoria that was removed
	* @throws PortalException if a auditoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.auditoria deleteauditoria(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteauditoria(id);
	}

	/**
	* Deletes the auditoria from the database. Also notifies the appropriate model listeners.
	*
	* @param auditoria the auditoria
	* @return the auditoria that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.auditoria deleteauditoria(
		com.co.csj.service.model.auditoria auditoria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteauditoria(auditoria);
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

	public static com.co.csj.service.model.auditoria fetchauditoria(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchauditoria(id);
	}

	/**
	* Returns the auditoria with the primary key.
	*
	* @param id the primary key of the auditoria
	* @return the auditoria
	* @throws PortalException if a auditoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.auditoria getauditoria(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getauditoria(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the auditorias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of auditorias
	* @param end the upper bound of the range of auditorias (not inclusive)
	* @return the range of auditorias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.co.csj.service.model.auditoria> getauditorias(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getauditorias(start, end);
	}

	/**
	* Returns the number of auditorias.
	*
	* @return the number of auditorias
	* @throws SystemException if a system exception occurred
	*/
	public static int getauditoriasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getauditoriasCount();
	}

	/**
	* Updates the auditoria in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param auditoria the auditoria
	* @return the auditoria that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.auditoria updateauditoria(
		com.co.csj.service.model.auditoria auditoria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateauditoria(auditoria);
	}

	/**
	* Updates the auditoria in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param auditoria the auditoria
	* @param merge whether to merge the auditoria with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the auditoria that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.auditoria updateauditoria(
		com.co.csj.service.model.auditoria auditoria, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateauditoria(auditoria, merge);
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

	public static auditoriaLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					auditoriaLocalService.class.getName());

			if (invokableLocalService instanceof auditoriaLocalService) {
				_service = (auditoriaLocalService)invokableLocalService;
			}
			else {
				_service = new auditoriaLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(auditoriaLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(auditoriaLocalService service) {
	}

	private static auditoriaLocalService _service;
}
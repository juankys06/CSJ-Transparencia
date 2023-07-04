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
 * The utility for the correos local service. This utility wraps {@link com.co.csj.service.service.impl.correosLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Equipo
 * @see correosLocalService
 * @see com.co.csj.service.service.base.correosLocalServiceBaseImpl
 * @see com.co.csj.service.service.impl.correosLocalServiceImpl
 * @generated
 */
public class correosLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.co.csj.service.service.impl.correosLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the correos to the database. Also notifies the appropriate model listeners.
	*
	* @param correos the correos
	* @return the correos that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.correos addcorreos(
		com.co.csj.service.model.correos correos)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addcorreos(correos);
	}

	/**
	* Creates a new correos with the primary key. Does not add the correos to the database.
	*
	* @param id the primary key for the new correos
	* @return the new correos
	*/
	public static com.co.csj.service.model.correos createcorreos(long id) {
		return getService().createcorreos(id);
	}

	/**
	* Deletes the correos with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the correos
	* @return the correos that was removed
	* @throws PortalException if a correos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.correos deletecorreos(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletecorreos(id);
	}

	/**
	* Deletes the correos from the database. Also notifies the appropriate model listeners.
	*
	* @param correos the correos
	* @return the correos that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.correos deletecorreos(
		com.co.csj.service.model.correos correos)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletecorreos(correos);
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

	public static com.co.csj.service.model.correos fetchcorreos(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchcorreos(id);
	}

	/**
	* Returns the correos with the primary key.
	*
	* @param id the primary key of the correos
	* @return the correos
	* @throws PortalException if a correos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.correos getcorreos(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getcorreos(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.co.csj.service.model.correos> getcorreoses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getcorreoses(start, end);
	}

	/**
	* Returns the number of correoses.
	*
	* @return the number of correoses
	* @throws SystemException if a system exception occurred
	*/
	public static int getcorreosesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getcorreosesCount();
	}

	/**
	* Updates the correos in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param correos the correos
	* @return the correos that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.correos updatecorreos(
		com.co.csj.service.model.correos correos)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatecorreos(correos);
	}

	/**
	* Updates the correos in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param correos the correos
	* @param merge whether to merge the correos with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the correos that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.correos updatecorreos(
		com.co.csj.service.model.correos correos, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatecorreos(correos, merge);
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

	public static com.co.csj.service.model.correos PorCorreoCedula(
		java.lang.String correo, java.lang.String cedula)
		throws com.co.csj.service.NoSuchcorreosException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().PorCorreoCedula(correo, cedula);
	}

	public static com.co.csj.service.model.correos PorCorreo(
		java.lang.String correo)
		throws com.co.csj.service.NoSuchcorreosException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().PorCorreo(correo);
	}

	public static void clearService() {
		_service = null;
	}

	public static correosLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					correosLocalService.class.getName());

			if (invokableLocalService instanceof correosLocalService) {
				_service = (correosLocalService)invokableLocalService;
			}
			else {
				_service = new correosLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(correosLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(correosLocalService service) {
	}

	private static correosLocalService _service;
}
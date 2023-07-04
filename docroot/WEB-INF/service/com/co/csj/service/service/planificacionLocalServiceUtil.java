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
 * The utility for the planificacion local service. This utility wraps {@link com.co.csj.service.service.impl.planificacionLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Equipo
 * @see planificacionLocalService
 * @see com.co.csj.service.service.base.planificacionLocalServiceBaseImpl
 * @see com.co.csj.service.service.impl.planificacionLocalServiceImpl
 * @generated
 */
public class planificacionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.co.csj.service.service.impl.planificacionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the planificacion to the database. Also notifies the appropriate model listeners.
	*
	* @param planificacion the planificacion
	* @return the planificacion that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.planificacion addplanificacion(
		com.co.csj.service.model.planificacion planificacion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addplanificacion(planificacion);
	}

	/**
	* Creates a new planificacion with the primary key. Does not add the planificacion to the database.
	*
	* @param id the primary key for the new planificacion
	* @return the new planificacion
	*/
	public static com.co.csj.service.model.planificacion createplanificacion(
		long id) {
		return getService().createplanificacion(id);
	}

	/**
	* Deletes the planificacion with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the planificacion
	* @return the planificacion that was removed
	* @throws PortalException if a planificacion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.planificacion deleteplanificacion(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteplanificacion(id);
	}

	/**
	* Deletes the planificacion from the database. Also notifies the appropriate model listeners.
	*
	* @param planificacion the planificacion
	* @return the planificacion that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.planificacion deleteplanificacion(
		com.co.csj.service.model.planificacion planificacion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteplanificacion(planificacion);
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

	public static com.co.csj.service.model.planificacion fetchplanificacion(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchplanificacion(id);
	}

	/**
	* Returns the planificacion with the primary key.
	*
	* @param id the primary key of the planificacion
	* @return the planificacion
	* @throws PortalException if a planificacion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.planificacion getplanificacion(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getplanificacion(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.co.csj.service.model.planificacion> getplanificacions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getplanificacions(start, end);
	}

	/**
	* Returns the number of planificacions.
	*
	* @return the number of planificacions
	* @throws SystemException if a system exception occurred
	*/
	public static int getplanificacionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getplanificacionsCount();
	}

	/**
	* Updates the planificacion in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param planificacion the planificacion
	* @return the planificacion that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.planificacion updateplanificacion(
		com.co.csj.service.model.planificacion planificacion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateplanificacion(planificacion);
	}

	/**
	* Updates the planificacion in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param planificacion the planificacion
	* @param merge whether to merge the planificacion with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the planificacion that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.co.csj.service.model.planificacion updateplanificacion(
		com.co.csj.service.model.planificacion planificacion, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateplanificacion(planificacion, merge);
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

	public static com.co.csj.service.model.planificacion PorEstado(
		java.lang.String estado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().PorEstado(estado);
	}

	public static void clearService() {
		_service = null;
	}

	public static planificacionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					planificacionLocalService.class.getName());

			if (invokableLocalService instanceof planificacionLocalService) {
				_service = (planificacionLocalService)invokableLocalService;
			}
			else {
				_service = new planificacionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(planificacionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(planificacionLocalService service) {
	}

	private static planificacionLocalService _service;
}
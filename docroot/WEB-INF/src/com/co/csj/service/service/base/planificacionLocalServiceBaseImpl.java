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

package com.co.csj.service.service.base;

import com.co.csj.service.model.planificacion;
import com.co.csj.service.service.auditoriaLocalService;
import com.co.csj.service.service.correosLocalService;
import com.co.csj.service.service.editoresLocalService;
import com.co.csj.service.service.persistence.auditoriaPersistence;
import com.co.csj.service.service.persistence.correosPersistence;
import com.co.csj.service.service.persistence.editoresPersistence;
import com.co.csj.service.service.persistence.planificacionPersistence;
import com.co.csj.service.service.persistence.publicacionesPersistence;
import com.co.csj.service.service.persistence.usuario_dataPersistence;
import com.co.csj.service.service.planificacionLocalService;
import com.co.csj.service.service.publicacionesLocalService;
import com.co.csj.service.service.servicioapileytransService;
import com.co.csj.service.service.usuario_dataLocalService;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the planificacion local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.co.csj.service.service.impl.planificacionLocalServiceImpl}.
 * </p>
 *
 * @author Equipo
 * @see com.co.csj.service.service.impl.planificacionLocalServiceImpl
 * @see com.co.csj.service.service.planificacionLocalServiceUtil
 * @generated
 */
public abstract class planificacionLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements planificacionLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.co.csj.service.service.planificacionLocalServiceUtil} to access the planificacion local service.
	 */

	/**
	 * Adds the planificacion to the database. Also notifies the appropriate model listeners.
	 *
	 * @param planificacion the planificacion
	 * @return the planificacion that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public planificacion addplanificacion(planificacion planificacion)
		throws SystemException {
		planificacion.setNew(true);

		return planificacionPersistence.update(planificacion, false);
	}

	/**
	 * Creates a new planificacion with the primary key. Does not add the planificacion to the database.
	 *
	 * @param id the primary key for the new planificacion
	 * @return the new planificacion
	 */
	public planificacion createplanificacion(long id) {
		return planificacionPersistence.create(id);
	}

	/**
	 * Deletes the planificacion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the planificacion
	 * @return the planificacion that was removed
	 * @throws PortalException if a planificacion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public planificacion deleteplanificacion(long id)
		throws PortalException, SystemException {
		return planificacionPersistence.remove(id);
	}

	/**
	 * Deletes the planificacion from the database. Also notifies the appropriate model listeners.
	 *
	 * @param planificacion the planificacion
	 * @return the planificacion that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public planificacion deleteplanificacion(planificacion planificacion)
		throws SystemException {
		return planificacionPersistence.remove(planificacion);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(planificacion.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return planificacionPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return planificacionPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return planificacionPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return planificacionPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public planificacion fetchplanificacion(long id) throws SystemException {
		return planificacionPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the planificacion with the primary key.
	 *
	 * @param id the primary key of the planificacion
	 * @return the planificacion
	 * @throws PortalException if a planificacion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public planificacion getplanificacion(long id)
		throws PortalException, SystemException {
		return planificacionPersistence.findByPrimaryKey(id);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return planificacionPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<planificacion> getplanificacions(int start, int end)
		throws SystemException {
		return planificacionPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of planificacions.
	 *
	 * @return the number of planificacions
	 * @throws SystemException if a system exception occurred
	 */
	public int getplanificacionsCount() throws SystemException {
		return planificacionPersistence.countAll();
	}

	/**
	 * Updates the planificacion in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param planificacion the planificacion
	 * @return the planificacion that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public planificacion updateplanificacion(planificacion planificacion)
		throws SystemException {
		return updateplanificacion(planificacion, true);
	}

	/**
	 * Updates the planificacion in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param planificacion the planificacion
	 * @param merge whether to merge the planificacion with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the planificacion that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public planificacion updateplanificacion(planificacion planificacion,
		boolean merge) throws SystemException {
		planificacion.setNew(false);

		return planificacionPersistence.update(planificacion, merge);
	}

	/**
	 * Returns the auditoria local service.
	 *
	 * @return the auditoria local service
	 */
	public auditoriaLocalService getauditoriaLocalService() {
		return auditoriaLocalService;
	}

	/**
	 * Sets the auditoria local service.
	 *
	 * @param auditoriaLocalService the auditoria local service
	 */
	public void setauditoriaLocalService(
		auditoriaLocalService auditoriaLocalService) {
		this.auditoriaLocalService = auditoriaLocalService;
	}

	/**
	 * Returns the auditoria persistence.
	 *
	 * @return the auditoria persistence
	 */
	public auditoriaPersistence getauditoriaPersistence() {
		return auditoriaPersistence;
	}

	/**
	 * Sets the auditoria persistence.
	 *
	 * @param auditoriaPersistence the auditoria persistence
	 */
	public void setauditoriaPersistence(
		auditoriaPersistence auditoriaPersistence) {
		this.auditoriaPersistence = auditoriaPersistence;
	}

	/**
	 * Returns the correos local service.
	 *
	 * @return the correos local service
	 */
	public correosLocalService getcorreosLocalService() {
		return correosLocalService;
	}

	/**
	 * Sets the correos local service.
	 *
	 * @param correosLocalService the correos local service
	 */
	public void setcorreosLocalService(correosLocalService correosLocalService) {
		this.correosLocalService = correosLocalService;
	}

	/**
	 * Returns the correos persistence.
	 *
	 * @return the correos persistence
	 */
	public correosPersistence getcorreosPersistence() {
		return correosPersistence;
	}

	/**
	 * Sets the correos persistence.
	 *
	 * @param correosPersistence the correos persistence
	 */
	public void setcorreosPersistence(correosPersistence correosPersistence) {
		this.correosPersistence = correosPersistence;
	}

	/**
	 * Returns the editores local service.
	 *
	 * @return the editores local service
	 */
	public editoresLocalService geteditoresLocalService() {
		return editoresLocalService;
	}

	/**
	 * Sets the editores local service.
	 *
	 * @param editoresLocalService the editores local service
	 */
	public void seteditoresLocalService(
		editoresLocalService editoresLocalService) {
		this.editoresLocalService = editoresLocalService;
	}

	/**
	 * Returns the editores persistence.
	 *
	 * @return the editores persistence
	 */
	public editoresPersistence geteditoresPersistence() {
		return editoresPersistence;
	}

	/**
	 * Sets the editores persistence.
	 *
	 * @param editoresPersistence the editores persistence
	 */
	public void seteditoresPersistence(editoresPersistence editoresPersistence) {
		this.editoresPersistence = editoresPersistence;
	}

	/**
	 * Returns the planificacion local service.
	 *
	 * @return the planificacion local service
	 */
	public planificacionLocalService getplanificacionLocalService() {
		return planificacionLocalService;
	}

	/**
	 * Sets the planificacion local service.
	 *
	 * @param planificacionLocalService the planificacion local service
	 */
	public void setplanificacionLocalService(
		planificacionLocalService planificacionLocalService) {
		this.planificacionLocalService = planificacionLocalService;
	}

	/**
	 * Returns the planificacion persistence.
	 *
	 * @return the planificacion persistence
	 */
	public planificacionPersistence getplanificacionPersistence() {
		return planificacionPersistence;
	}

	/**
	 * Sets the planificacion persistence.
	 *
	 * @param planificacionPersistence the planificacion persistence
	 */
	public void setplanificacionPersistence(
		planificacionPersistence planificacionPersistence) {
		this.planificacionPersistence = planificacionPersistence;
	}

	/**
	 * Returns the publicaciones local service.
	 *
	 * @return the publicaciones local service
	 */
	public publicacionesLocalService getpublicacionesLocalService() {
		return publicacionesLocalService;
	}

	/**
	 * Sets the publicaciones local service.
	 *
	 * @param publicacionesLocalService the publicaciones local service
	 */
	public void setpublicacionesLocalService(
		publicacionesLocalService publicacionesLocalService) {
		this.publicacionesLocalService = publicacionesLocalService;
	}

	/**
	 * Returns the publicaciones persistence.
	 *
	 * @return the publicaciones persistence
	 */
	public publicacionesPersistence getpublicacionesPersistence() {
		return publicacionesPersistence;
	}

	/**
	 * Sets the publicaciones persistence.
	 *
	 * @param publicacionesPersistence the publicaciones persistence
	 */
	public void setpublicacionesPersistence(
		publicacionesPersistence publicacionesPersistence) {
		this.publicacionesPersistence = publicacionesPersistence;
	}

	/**
	 * Returns the servicioapileytrans remote service.
	 *
	 * @return the servicioapileytrans remote service
	 */
	public servicioapileytransService getservicioapileytransService() {
		return servicioapileytransService;
	}

	/**
	 * Sets the servicioapileytrans remote service.
	 *
	 * @param servicioapileytransService the servicioapileytrans remote service
	 */
	public void setservicioapileytransService(
		servicioapileytransService servicioapileytransService) {
		this.servicioapileytransService = servicioapileytransService;
	}

	/**
	 * Returns the usuario_data local service.
	 *
	 * @return the usuario_data local service
	 */
	public usuario_dataLocalService getusuario_dataLocalService() {
		return usuario_dataLocalService;
	}

	/**
	 * Sets the usuario_data local service.
	 *
	 * @param usuario_dataLocalService the usuario_data local service
	 */
	public void setusuario_dataLocalService(
		usuario_dataLocalService usuario_dataLocalService) {
		this.usuario_dataLocalService = usuario_dataLocalService;
	}

	/**
	 * Returns the usuario_data persistence.
	 *
	 * @return the usuario_data persistence
	 */
	public usuario_dataPersistence getusuario_dataPersistence() {
		return usuario_dataPersistence;
	}

	/**
	 * Sets the usuario_data persistence.
	 *
	 * @param usuario_dataPersistence the usuario_data persistence
	 */
	public void setusuario_dataPersistence(
		usuario_dataPersistence usuario_dataPersistence) {
		this.usuario_dataPersistence = usuario_dataPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("com.co.csj.service.model.planificacion",
			planificacionLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.co.csj.service.model.planificacion");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return planificacion.class;
	}

	protected String getModelClassName() {
		return planificacion.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = planificacionPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = auditoriaLocalService.class)
	protected auditoriaLocalService auditoriaLocalService;
	@BeanReference(type = auditoriaPersistence.class)
	protected auditoriaPersistence auditoriaPersistence;
	@BeanReference(type = correosLocalService.class)
	protected correosLocalService correosLocalService;
	@BeanReference(type = correosPersistence.class)
	protected correosPersistence correosPersistence;
	@BeanReference(type = editoresLocalService.class)
	protected editoresLocalService editoresLocalService;
	@BeanReference(type = editoresPersistence.class)
	protected editoresPersistence editoresPersistence;
	@BeanReference(type = planificacionLocalService.class)
	protected planificacionLocalService planificacionLocalService;
	@BeanReference(type = planificacionPersistence.class)
	protected planificacionPersistence planificacionPersistence;
	@BeanReference(type = publicacionesLocalService.class)
	protected publicacionesLocalService publicacionesLocalService;
	@BeanReference(type = publicacionesPersistence.class)
	protected publicacionesPersistence publicacionesPersistence;
	@BeanReference(type = servicioapileytransService.class)
	protected servicioapileytransService servicioapileytransService;
	@BeanReference(type = usuario_dataLocalService.class)
	protected usuario_dataLocalService usuario_dataLocalService;
	@BeanReference(type = usuario_dataPersistence.class)
	protected usuario_dataPersistence usuario_dataPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private planificacionLocalServiceClpInvoker _clpInvoker = new planificacionLocalServiceClpInvoker();
}
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

package com.co.csj.service.service.persistence;

import com.co.csj.service.NoSuchusuario_dataException;
import com.co.csj.service.model.impl.usuario_dataImpl;
import com.co.csj.service.model.impl.usuario_dataModelImpl;
import com.co.csj.service.model.usuario_data;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the usuario_data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Equipo
 * @see usuario_dataPersistence
 * @see usuario_dataUtil
 * @generated
 */
public class usuario_dataPersistenceImpl extends BasePersistenceImpl<usuario_data>
	implements usuario_dataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link usuario_dataUtil} to access the usuario_data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = usuario_dataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(usuario_dataModelImpl.ENTITY_CACHE_ENABLED,
			usuario_dataModelImpl.FINDER_CACHE_ENABLED, usuario_dataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(usuario_dataModelImpl.ENTITY_CACHE_ENABLED,
			usuario_dataModelImpl.FINDER_CACHE_ENABLED, usuario_dataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(usuario_dataModelImpl.ENTITY_CACHE_ENABLED,
			usuario_dataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the usuario_data in the entity cache if it is enabled.
	 *
	 * @param usuario_data the usuario_data
	 */
	public void cacheResult(usuario_data usuario_data) {
		EntityCacheUtil.putResult(usuario_dataModelImpl.ENTITY_CACHE_ENABLED,
			usuario_dataImpl.class, usuario_data.getPrimaryKey(), usuario_data);

		usuario_data.resetOriginalValues();
	}

	/**
	 * Caches the usuario_datas in the entity cache if it is enabled.
	 *
	 * @param usuario_datas the usuario_datas
	 */
	public void cacheResult(List<usuario_data> usuario_datas) {
		for (usuario_data usuario_data : usuario_datas) {
			if (EntityCacheUtil.getResult(
						usuario_dataModelImpl.ENTITY_CACHE_ENABLED,
						usuario_dataImpl.class, usuario_data.getPrimaryKey()) == null) {
				cacheResult(usuario_data);
			}
			else {
				usuario_data.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all usuario_datas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(usuario_dataImpl.class.getName());
		}

		EntityCacheUtil.clearCache(usuario_dataImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the usuario_data.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(usuario_data usuario_data) {
		EntityCacheUtil.removeResult(usuario_dataModelImpl.ENTITY_CACHE_ENABLED,
			usuario_dataImpl.class, usuario_data.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<usuario_data> usuario_datas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (usuario_data usuario_data : usuario_datas) {
			EntityCacheUtil.removeResult(usuario_dataModelImpl.ENTITY_CACHE_ENABLED,
				usuario_dataImpl.class, usuario_data.getPrimaryKey());
		}
	}

	/**
	 * Creates a new usuario_data with the primary key. Does not add the usuario_data to the database.
	 *
	 * @param numeroDocumento the primary key for the new usuario_data
	 * @return the new usuario_data
	 */
	public usuario_data create(String numeroDocumento) {
		usuario_data usuario_data = new usuario_dataImpl();

		usuario_data.setNew(true);
		usuario_data.setPrimaryKey(numeroDocumento);

		return usuario_data;
	}

	/**
	 * Removes the usuario_data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param numeroDocumento the primary key of the usuario_data
	 * @return the usuario_data that was removed
	 * @throws com.co.csj.service.NoSuchusuario_dataException if a usuario_data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public usuario_data remove(String numeroDocumento)
		throws NoSuchusuario_dataException, SystemException {
		return remove((Serializable)numeroDocumento);
	}

	/**
	 * Removes the usuario_data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the usuario_data
	 * @return the usuario_data that was removed
	 * @throws com.co.csj.service.NoSuchusuario_dataException if a usuario_data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public usuario_data remove(Serializable primaryKey)
		throws NoSuchusuario_dataException, SystemException {
		Session session = null;

		try {
			session = openSession();

			usuario_data usuario_data = (usuario_data)session.get(usuario_dataImpl.class,
					primaryKey);

			if (usuario_data == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchusuario_dataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(usuario_data);
		}
		catch (NoSuchusuario_dataException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected usuario_data removeImpl(usuario_data usuario_data)
		throws SystemException {
		usuario_data = toUnwrappedModel(usuario_data);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, usuario_data);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(usuario_data);

		return usuario_data;
	}

	@Override
	public usuario_data updateImpl(
		com.co.csj.service.model.usuario_data usuario_data, boolean merge)
		throws SystemException {
		usuario_data = toUnwrappedModel(usuario_data);

		boolean isNew = usuario_data.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, usuario_data, merge);

			usuario_data.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(usuario_dataModelImpl.ENTITY_CACHE_ENABLED,
			usuario_dataImpl.class, usuario_data.getPrimaryKey(), usuario_data);

		return usuario_data;
	}

	protected usuario_data toUnwrappedModel(usuario_data usuario_data) {
		if (usuario_data instanceof usuario_dataImpl) {
			return usuario_data;
		}

		usuario_dataImpl usuario_dataImpl = new usuario_dataImpl();

		usuario_dataImpl.setNew(usuario_data.isNew());
		usuario_dataImpl.setPrimaryKey(usuario_data.getPrimaryKey());

		usuario_dataImpl.setNumeroDocumento(usuario_data.getNumeroDocumento());
		usuario_dataImpl.setTipoDocumento(usuario_data.getTipoDocumento());
		usuario_dataImpl.setNombres(usuario_data.getNombres());
		usuario_dataImpl.setApellidos(usuario_data.getApellidos());
		usuario_dataImpl.setCargo(usuario_data.getCargo());
		usuario_dataImpl.setFechaRegistro(usuario_data.getFechaRegistro());
		usuario_dataImpl.setFechaModificacion(usuario_data.getFechaModificacion());
		usuario_dataImpl.setDatos_personales(usuario_data.getDatos_personales());
		usuario_dataImpl.setDespacho(usuario_data.getDespacho());
		usuario_dataImpl.setFormacion_academica(usuario_data.getFormacion_academica());
		usuario_dataImpl.setExperiencia_laboral(usuario_data.getExperiencia_laboral());
		usuario_dataImpl.setTiempo_experiencia(usuario_data.getTiempo_experiencia());
		usuario_dataImpl.setBienes_y_rentas(usuario_data.getBienes_y_rentas());
		usuario_dataImpl.setInformacion_complementaria(usuario_data.getInformacion_complementaria());
		usuario_dataImpl.setConflicto_intereses(usuario_data.getConflicto_intereses());
		usuario_dataImpl.setArchivo_declaracion_renta(usuario_data.getArchivo_declaracion_renta());
		usuario_dataImpl.setArchivo_formulario_bienes(usuario_data.getArchivo_formulario_bienes());
		usuario_dataImpl.setArchivo_hoja_vida(usuario_data.getArchivo_hoja_vida());
		usuario_dataImpl.setPorcentaje_dp(usuario_data.getPorcentaje_dp());
		usuario_dataImpl.setPorcentaje_fa(usuario_data.getPorcentaje_fa());
		usuario_dataImpl.setPorcentaje_el(usuario_data.getPorcentaje_el());
		usuario_dataImpl.setPorcentaje_te(usuario_data.getPorcentaje_te());
		usuario_dataImpl.setPorcentaje_br(usuario_data.getPorcentaje_br());
		usuario_dataImpl.setPorcentaje_ic(usuario_data.getPorcentaje_ic());
		usuario_dataImpl.setPorcentaje_ci(usuario_data.getPorcentaje_ci());
		usuario_dataImpl.setRetirado(usuario_data.getRetirado());

		return usuario_dataImpl;
	}

	/**
	 * Returns the usuario_data with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the usuario_data
	 * @return the usuario_data
	 * @throws com.liferay.portal.NoSuchModelException if a usuario_data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public usuario_data findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the usuario_data with the primary key or throws a {@link com.co.csj.service.NoSuchusuario_dataException} if it could not be found.
	 *
	 * @param numeroDocumento the primary key of the usuario_data
	 * @return the usuario_data
	 * @throws com.co.csj.service.NoSuchusuario_dataException if a usuario_data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public usuario_data findByPrimaryKey(String numeroDocumento)
		throws NoSuchusuario_dataException, SystemException {
		usuario_data usuario_data = fetchByPrimaryKey(numeroDocumento);

		if (usuario_data == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + numeroDocumento);
			}

			throw new NoSuchusuario_dataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				numeroDocumento);
		}

		return usuario_data;
	}

	/**
	 * Returns the usuario_data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the usuario_data
	 * @return the usuario_data, or <code>null</code> if a usuario_data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public usuario_data fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the usuario_data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param numeroDocumento the primary key of the usuario_data
	 * @return the usuario_data, or <code>null</code> if a usuario_data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public usuario_data fetchByPrimaryKey(String numeroDocumento)
		throws SystemException {
		usuario_data usuario_data = (usuario_data)EntityCacheUtil.getResult(usuario_dataModelImpl.ENTITY_CACHE_ENABLED,
				usuario_dataImpl.class, numeroDocumento);

		if (usuario_data == _nullusuario_data) {
			return null;
		}

		if (usuario_data == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				usuario_data = (usuario_data)session.get(usuario_dataImpl.class,
						numeroDocumento);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (usuario_data != null) {
					cacheResult(usuario_data);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(usuario_dataModelImpl.ENTITY_CACHE_ENABLED,
						usuario_dataImpl.class, numeroDocumento,
						_nullusuario_data);
				}

				closeSession(session);
			}
		}

		return usuario_data;
	}

	/**
	 * Returns all the usuario_datas.
	 *
	 * @return the usuario_datas
	 * @throws SystemException if a system exception occurred
	 */
	public List<usuario_data> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<usuario_data> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the usuario_datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of usuario_datas
	 * @param end the upper bound of the range of usuario_datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of usuario_datas
	 * @throws SystemException if a system exception occurred
	 */
	public List<usuario_data> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<usuario_data> list = (List<usuario_data>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USUARIO_DATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USUARIO_DATA;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<usuario_data>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<usuario_data>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the usuario_datas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (usuario_data usuario_data : findAll()) {
			remove(usuario_data);
		}
	}

	/**
	 * Returns the number of usuario_datas.
	 *
	 * @return the number of usuario_datas
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USUARIO_DATA);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the usuario_data persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.co.csj.service.model.usuario_data")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<usuario_data>> listenersList = new ArrayList<ModelListener<usuario_data>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<usuario_data>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(usuario_dataImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = auditoriaPersistence.class)
	protected auditoriaPersistence auditoriaPersistence;
	@BeanReference(type = correosPersistence.class)
	protected correosPersistence correosPersistence;
	@BeanReference(type = editoresPersistence.class)
	protected editoresPersistence editoresPersistence;
	@BeanReference(type = planificacionPersistence.class)
	protected planificacionPersistence planificacionPersistence;
	@BeanReference(type = publicacionesPersistence.class)
	protected publicacionesPersistence publicacionesPersistence;
	@BeanReference(type = usuario_dataPersistence.class)
	protected usuario_dataPersistence usuario_dataPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_USUARIO_DATA = "SELECT usuario_data FROM usuario_data usuario_data";
	private static final String _SQL_COUNT_USUARIO_DATA = "SELECT COUNT(usuario_data) FROM usuario_data usuario_data";
	private static final String _ORDER_BY_ENTITY_ALIAS = "usuario_data.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No usuario_data exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(usuario_dataPersistenceImpl.class);
	private static usuario_data _nullusuario_data = new usuario_dataImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<usuario_data> toCacheModel() {
				return _nullusuario_dataCacheModel;
			}
		};

	private static CacheModel<usuario_data> _nullusuario_dataCacheModel = new CacheModel<usuario_data>() {
			public usuario_data toEntityModel() {
				return _nullusuario_data;
			}
		};
}
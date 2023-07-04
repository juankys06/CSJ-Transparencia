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

import com.co.csj.service.NoSuchauditoriaException;
import com.co.csj.service.model.auditoria;
import com.co.csj.service.model.impl.auditoriaImpl;
import com.co.csj.service.model.impl.auditoriaModelImpl;

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
 * The persistence implementation for the auditoria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Equipo
 * @see auditoriaPersistence
 * @see auditoriaUtil
 * @generated
 */
public class auditoriaPersistenceImpl extends BasePersistenceImpl<auditoria>
	implements auditoriaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link auditoriaUtil} to access the auditoria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = auditoriaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(auditoriaModelImpl.ENTITY_CACHE_ENABLED,
			auditoriaModelImpl.FINDER_CACHE_ENABLED, auditoriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(auditoriaModelImpl.ENTITY_CACHE_ENABLED,
			auditoriaModelImpl.FINDER_CACHE_ENABLED, auditoriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(auditoriaModelImpl.ENTITY_CACHE_ENABLED,
			auditoriaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the auditoria in the entity cache if it is enabled.
	 *
	 * @param auditoria the auditoria
	 */
	public void cacheResult(auditoria auditoria) {
		EntityCacheUtil.putResult(auditoriaModelImpl.ENTITY_CACHE_ENABLED,
			auditoriaImpl.class, auditoria.getPrimaryKey(), auditoria);

		auditoria.resetOriginalValues();
	}

	/**
	 * Caches the auditorias in the entity cache if it is enabled.
	 *
	 * @param auditorias the auditorias
	 */
	public void cacheResult(List<auditoria> auditorias) {
		for (auditoria auditoria : auditorias) {
			if (EntityCacheUtil.getResult(
						auditoriaModelImpl.ENTITY_CACHE_ENABLED,
						auditoriaImpl.class, auditoria.getPrimaryKey()) == null) {
				cacheResult(auditoria);
			}
			else {
				auditoria.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all auditorias.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(auditoriaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(auditoriaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the auditoria.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(auditoria auditoria) {
		EntityCacheUtil.removeResult(auditoriaModelImpl.ENTITY_CACHE_ENABLED,
			auditoriaImpl.class, auditoria.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<auditoria> auditorias) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (auditoria auditoria : auditorias) {
			EntityCacheUtil.removeResult(auditoriaModelImpl.ENTITY_CACHE_ENABLED,
				auditoriaImpl.class, auditoria.getPrimaryKey());
		}
	}

	/**
	 * Creates a new auditoria with the primary key. Does not add the auditoria to the database.
	 *
	 * @param id the primary key for the new auditoria
	 * @return the new auditoria
	 */
	public auditoria create(long id) {
		auditoria auditoria = new auditoriaImpl();

		auditoria.setNew(true);
		auditoria.setPrimaryKey(id);

		return auditoria;
	}

	/**
	 * Removes the auditoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the auditoria
	 * @return the auditoria that was removed
	 * @throws com.co.csj.service.NoSuchauditoriaException if a auditoria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public auditoria remove(long id)
		throws NoSuchauditoriaException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the auditoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the auditoria
	 * @return the auditoria that was removed
	 * @throws com.co.csj.service.NoSuchauditoriaException if a auditoria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public auditoria remove(Serializable primaryKey)
		throws NoSuchauditoriaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			auditoria auditoria = (auditoria)session.get(auditoriaImpl.class,
					primaryKey);

			if (auditoria == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchauditoriaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(auditoria);
		}
		catch (NoSuchauditoriaException nsee) {
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
	protected auditoria removeImpl(auditoria auditoria)
		throws SystemException {
		auditoria = toUnwrappedModel(auditoria);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, auditoria);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(auditoria);

		return auditoria;
	}

	@Override
	public auditoria updateImpl(com.co.csj.service.model.auditoria auditoria,
		boolean merge) throws SystemException {
		auditoria = toUnwrappedModel(auditoria);

		boolean isNew = auditoria.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, auditoria, merge);

			auditoria.setNew(false);
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

		EntityCacheUtil.putResult(auditoriaModelImpl.ENTITY_CACHE_ENABLED,
			auditoriaImpl.class, auditoria.getPrimaryKey(), auditoria);

		return auditoria;
	}

	protected auditoria toUnwrappedModel(auditoria auditoria) {
		if (auditoria instanceof auditoriaImpl) {
			return auditoria;
		}

		auditoriaImpl auditoriaImpl = new auditoriaImpl();

		auditoriaImpl.setNew(auditoria.isNew());
		auditoriaImpl.setPrimaryKey(auditoria.getPrimaryKey());

		auditoriaImpl.setId(auditoria.getId());
		auditoriaImpl.setModificado_por(auditoria.getModificado_por());
		auditoriaImpl.setAccion(auditoria.getAccion());
		auditoriaImpl.setCampo_modifico(auditoria.getCampo_modifico());
		auditoriaImpl.setFecha(auditoria.getFecha());
		auditoriaImpl.setAno_vigencia(auditoria.getAno_vigencia());
		auditoriaImpl.setCedula_funcionario(auditoria.getCedula_funcionario());
		auditoriaImpl.setLog_anterior(auditoria.getLog_anterior());
		auditoriaImpl.setLog_nuevo(auditoria.getLog_nuevo());

		return auditoriaImpl;
	}

	/**
	 * Returns the auditoria with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the auditoria
	 * @return the auditoria
	 * @throws com.liferay.portal.NoSuchModelException if a auditoria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public auditoria findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the auditoria with the primary key or throws a {@link com.co.csj.service.NoSuchauditoriaException} if it could not be found.
	 *
	 * @param id the primary key of the auditoria
	 * @return the auditoria
	 * @throws com.co.csj.service.NoSuchauditoriaException if a auditoria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public auditoria findByPrimaryKey(long id)
		throws NoSuchauditoriaException, SystemException {
		auditoria auditoria = fetchByPrimaryKey(id);

		if (auditoria == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchauditoriaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return auditoria;
	}

	/**
	 * Returns the auditoria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the auditoria
	 * @return the auditoria, or <code>null</code> if a auditoria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public auditoria fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the auditoria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the auditoria
	 * @return the auditoria, or <code>null</code> if a auditoria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public auditoria fetchByPrimaryKey(long id) throws SystemException {
		auditoria auditoria = (auditoria)EntityCacheUtil.getResult(auditoriaModelImpl.ENTITY_CACHE_ENABLED,
				auditoriaImpl.class, id);

		if (auditoria == _nullauditoria) {
			return null;
		}

		if (auditoria == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				auditoria = (auditoria)session.get(auditoriaImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (auditoria != null) {
					cacheResult(auditoria);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(auditoriaModelImpl.ENTITY_CACHE_ENABLED,
						auditoriaImpl.class, id, _nullauditoria);
				}

				closeSession(session);
			}
		}

		return auditoria;
	}

	/**
	 * Returns all the auditorias.
	 *
	 * @return the auditorias
	 * @throws SystemException if a system exception occurred
	 */
	public List<auditoria> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<auditoria> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the auditorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditorias
	 * @param end the upper bound of the range of auditorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of auditorias
	 * @throws SystemException if a system exception occurred
	 */
	public List<auditoria> findAll(int start, int end,
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

		List<auditoria> list = (List<auditoria>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_AUDITORIA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AUDITORIA.concat(auditoriaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<auditoria>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<auditoria>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the auditorias from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (auditoria auditoria : findAll()) {
			remove(auditoria);
		}
	}

	/**
	 * Returns the number of auditorias.
	 *
	 * @return the number of auditorias
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AUDITORIA);

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
	 * Initializes the auditoria persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.co.csj.service.model.auditoria")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<auditoria>> listenersList = new ArrayList<ModelListener<auditoria>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<auditoria>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(auditoriaImpl.class.getName());
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
	private static final String _SQL_SELECT_AUDITORIA = "SELECT auditoria FROM auditoria auditoria";
	private static final String _SQL_COUNT_AUDITORIA = "SELECT COUNT(auditoria) FROM auditoria auditoria";
	private static final String _ORDER_BY_ENTITY_ALIAS = "auditoria.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No auditoria exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(auditoriaPersistenceImpl.class);
	private static auditoria _nullauditoria = new auditoriaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<auditoria> toCacheModel() {
				return _nullauditoriaCacheModel;
			}
		};

	private static CacheModel<auditoria> _nullauditoriaCacheModel = new CacheModel<auditoria>() {
			public auditoria toEntityModel() {
				return _nullauditoria;
			}
		};
}
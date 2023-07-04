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

import com.co.csj.service.NoSuchplanificacionException;
import com.co.csj.service.model.impl.planificacionImpl;
import com.co.csj.service.model.impl.planificacionModelImpl;
import com.co.csj.service.model.planificacion;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
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
 * The persistence implementation for the planificacion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Equipo
 * @see planificacionPersistence
 * @see planificacionUtil
 * @generated
 */
public class planificacionPersistenceImpl extends BasePersistenceImpl<planificacion>
	implements planificacionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link planificacionUtil} to access the planificacion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = planificacionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_PORESTADO = new FinderPath(planificacionModelImpl.ENTITY_CACHE_ENABLED,
			planificacionModelImpl.FINDER_CACHE_ENABLED,
			planificacionImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPorEstado", new String[] { String.class.getName() },
			planificacionModelImpl.ESTADO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PORESTADO = new FinderPath(planificacionModelImpl.ENTITY_CACHE_ENABLED,
			planificacionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPorEstado",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(planificacionModelImpl.ENTITY_CACHE_ENABLED,
			planificacionModelImpl.FINDER_CACHE_ENABLED,
			planificacionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(planificacionModelImpl.ENTITY_CACHE_ENABLED,
			planificacionModelImpl.FINDER_CACHE_ENABLED,
			planificacionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(planificacionModelImpl.ENTITY_CACHE_ENABLED,
			planificacionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the planificacion in the entity cache if it is enabled.
	 *
	 * @param planificacion the planificacion
	 */
	public void cacheResult(planificacion planificacion) {
		EntityCacheUtil.putResult(planificacionModelImpl.ENTITY_CACHE_ENABLED,
			planificacionImpl.class, planificacion.getPrimaryKey(),
			planificacion);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORESTADO,
			new Object[] { planificacion.getEstado() }, planificacion);

		planificacion.resetOriginalValues();
	}

	/**
	 * Caches the planificacions in the entity cache if it is enabled.
	 *
	 * @param planificacions the planificacions
	 */
	public void cacheResult(List<planificacion> planificacions) {
		for (planificacion planificacion : planificacions) {
			if (EntityCacheUtil.getResult(
						planificacionModelImpl.ENTITY_CACHE_ENABLED,
						planificacionImpl.class, planificacion.getPrimaryKey()) == null) {
				cacheResult(planificacion);
			}
			else {
				planificacion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all planificacions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(planificacionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(planificacionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the planificacion.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(planificacion planificacion) {
		EntityCacheUtil.removeResult(planificacionModelImpl.ENTITY_CACHE_ENABLED,
			planificacionImpl.class, planificacion.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(planificacion);
	}

	@Override
	public void clearCache(List<planificacion> planificacions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (planificacion planificacion : planificacions) {
			EntityCacheUtil.removeResult(planificacionModelImpl.ENTITY_CACHE_ENABLED,
				planificacionImpl.class, planificacion.getPrimaryKey());

			clearUniqueFindersCache(planificacion);
		}
	}

	protected void clearUniqueFindersCache(planificacion planificacion) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORESTADO,
			new Object[] { planificacion.getEstado() });
	}

	/**
	 * Creates a new planificacion with the primary key. Does not add the planificacion to the database.
	 *
	 * @param id the primary key for the new planificacion
	 * @return the new planificacion
	 */
	public planificacion create(long id) {
		planificacion planificacion = new planificacionImpl();

		planificacion.setNew(true);
		planificacion.setPrimaryKey(id);

		return planificacion;
	}

	/**
	 * Removes the planificacion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the planificacion
	 * @return the planificacion that was removed
	 * @throws com.co.csj.service.NoSuchplanificacionException if a planificacion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public planificacion remove(long id)
		throws NoSuchplanificacionException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the planificacion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the planificacion
	 * @return the planificacion that was removed
	 * @throws com.co.csj.service.NoSuchplanificacionException if a planificacion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public planificacion remove(Serializable primaryKey)
		throws NoSuchplanificacionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			planificacion planificacion = (planificacion)session.get(planificacionImpl.class,
					primaryKey);

			if (planificacion == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchplanificacionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(planificacion);
		}
		catch (NoSuchplanificacionException nsee) {
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
	protected planificacion removeImpl(planificacion planificacion)
		throws SystemException {
		planificacion = toUnwrappedModel(planificacion);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, planificacion);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(planificacion);

		return planificacion;
	}

	@Override
	public planificacion updateImpl(
		com.co.csj.service.model.planificacion planificacion, boolean merge)
		throws SystemException {
		planificacion = toUnwrappedModel(planificacion);

		boolean isNew = planificacion.isNew();

		planificacionModelImpl planificacionModelImpl = (planificacionModelImpl)planificacion;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, planificacion, merge);

			planificacion.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !planificacionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(planificacionModelImpl.ENTITY_CACHE_ENABLED,
			planificacionImpl.class, planificacion.getPrimaryKey(),
			planificacion);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORESTADO,
				new Object[] { planificacion.getEstado() }, planificacion);
		}
		else {
			if ((planificacionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PORESTADO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						planificacionModelImpl.getOriginalEstado()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORESTADO,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORESTADO,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORESTADO,
					new Object[] { planificacion.getEstado() }, planificacion);
			}
		}

		return planificacion;
	}

	protected planificacion toUnwrappedModel(planificacion planificacion) {
		if (planificacion instanceof planificacionImpl) {
			return planificacion;
		}

		planificacionImpl planificacionImpl = new planificacionImpl();

		planificacionImpl.setNew(planificacion.isNew());
		planificacionImpl.setPrimaryKey(planificacion.getPrimaryKey());

		planificacionImpl.setId(planificacion.getId());
		planificacionImpl.setAnhio(planificacion.getAnhio());
		planificacionImpl.setFecha_inicio(planificacion.getFecha_inicio());
		planificacionImpl.setFecha_fin(planificacion.getFecha_fin());
		planificacionImpl.setUsuario_finalizo(planificacion.getUsuario_finalizo());
		planificacionImpl.setEstado(planificacion.getEstado());

		return planificacionImpl;
	}

	/**
	 * Returns the planificacion with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the planificacion
	 * @return the planificacion
	 * @throws com.liferay.portal.NoSuchModelException if a planificacion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public planificacion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the planificacion with the primary key or throws a {@link com.co.csj.service.NoSuchplanificacionException} if it could not be found.
	 *
	 * @param id the primary key of the planificacion
	 * @return the planificacion
	 * @throws com.co.csj.service.NoSuchplanificacionException if a planificacion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public planificacion findByPrimaryKey(long id)
		throws NoSuchplanificacionException, SystemException {
		planificacion planificacion = fetchByPrimaryKey(id);

		if (planificacion == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchplanificacionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return planificacion;
	}

	/**
	 * Returns the planificacion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the planificacion
	 * @return the planificacion, or <code>null</code> if a planificacion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public planificacion fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the planificacion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the planificacion
	 * @return the planificacion, or <code>null</code> if a planificacion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public planificacion fetchByPrimaryKey(long id) throws SystemException {
		planificacion planificacion = (planificacion)EntityCacheUtil.getResult(planificacionModelImpl.ENTITY_CACHE_ENABLED,
				planificacionImpl.class, id);

		if (planificacion == _nullplanificacion) {
			return null;
		}

		if (planificacion == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				planificacion = (planificacion)session.get(planificacionImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (planificacion != null) {
					cacheResult(planificacion);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(planificacionModelImpl.ENTITY_CACHE_ENABLED,
						planificacionImpl.class, id, _nullplanificacion);
				}

				closeSession(session);
			}
		}

		return planificacion;
	}

	/**
	 * Returns the planificacion where estado = &#63; or throws a {@link com.co.csj.service.NoSuchplanificacionException} if it could not be found.
	 *
	 * @param estado the estado
	 * @return the matching planificacion
	 * @throws com.co.csj.service.NoSuchplanificacionException if a matching planificacion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public planificacion findByPorEstado(String estado)
		throws NoSuchplanificacionException, SystemException {
		planificacion planificacion = fetchByPorEstado(estado);

		if (planificacion == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("estado=");
			msg.append(estado);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchplanificacionException(msg.toString());
		}

		return planificacion;
	}

	/**
	 * Returns the planificacion where estado = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param estado the estado
	 * @return the matching planificacion, or <code>null</code> if a matching planificacion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public planificacion fetchByPorEstado(String estado)
		throws SystemException {
		return fetchByPorEstado(estado, true);
	}

	/**
	 * Returns the planificacion where estado = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param estado the estado
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching planificacion, or <code>null</code> if a matching planificacion could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public planificacion fetchByPorEstado(String estado,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { estado };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PORESTADO,
					finderArgs, this);
		}

		if (result instanceof planificacion) {
			planificacion planificacion = (planificacion)result;

			if (!Validator.equals(estado, planificacion.getEstado())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_PLANIFICACION_WHERE);

			if (estado == null) {
				query.append(_FINDER_COLUMN_PORESTADO_ESTADO_1);
			}
			else {
				if (estado.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORESTADO_ESTADO_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORESTADO_ESTADO_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (estado != null) {
					qPos.add(estado);
				}

				List<planificacion> list = q.list();

				result = list;

				planificacion planificacion = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORESTADO,
						finderArgs, list);
				}
				else {
					planificacion = list.get(0);

					cacheResult(planificacion);

					if ((planificacion.getEstado() == null) ||
							!planificacion.getEstado().equals(estado)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORESTADO,
							finderArgs, planificacion);
					}
				}

				return planificacion;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORESTADO,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (planificacion)result;
			}
		}
	}

	/**
	 * Returns all the planificacions.
	 *
	 * @return the planificacions
	 * @throws SystemException if a system exception occurred
	 */
	public List<planificacion> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<planificacion> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the planificacions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of planificacions
	 * @param end the upper bound of the range of planificacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of planificacions
	 * @throws SystemException if a system exception occurred
	 */
	public List<planificacion> findAll(int start, int end,
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

		List<planificacion> list = (List<planificacion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PLANIFICACION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PLANIFICACION;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<planificacion>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<planificacion>)QueryUtil.list(q, getDialect(),
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
	 * Removes the planificacion where estado = &#63; from the database.
	 *
	 * @param estado the estado
	 * @return the planificacion that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public planificacion removeByPorEstado(String estado)
		throws NoSuchplanificacionException, SystemException {
		planificacion planificacion = findByPorEstado(estado);

		return remove(planificacion);
	}

	/**
	 * Removes all the planificacions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (planificacion planificacion : findAll()) {
			remove(planificacion);
		}
	}

	/**
	 * Returns the number of planificacions where estado = &#63;.
	 *
	 * @param estado the estado
	 * @return the number of matching planificacions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPorEstado(String estado) throws SystemException {
		Object[] finderArgs = new Object[] { estado };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PORESTADO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PLANIFICACION_WHERE);

			if (estado == null) {
				query.append(_FINDER_COLUMN_PORESTADO_ESTADO_1);
			}
			else {
				if (estado.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORESTADO_ESTADO_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORESTADO_ESTADO_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (estado != null) {
					qPos.add(estado);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PORESTADO,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of planificacions.
	 *
	 * @return the number of planificacions
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PLANIFICACION);

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
	 * Initializes the planificacion persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.co.csj.service.model.planificacion")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<planificacion>> listenersList = new ArrayList<ModelListener<planificacion>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<planificacion>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(planificacionImpl.class.getName());
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
	private static final String _SQL_SELECT_PLANIFICACION = "SELECT planificacion FROM planificacion planificacion";
	private static final String _SQL_SELECT_PLANIFICACION_WHERE = "SELECT planificacion FROM planificacion planificacion WHERE ";
	private static final String _SQL_COUNT_PLANIFICACION = "SELECT COUNT(planificacion) FROM planificacion planificacion";
	private static final String _SQL_COUNT_PLANIFICACION_WHERE = "SELECT COUNT(planificacion) FROM planificacion planificacion WHERE ";
	private static final String _FINDER_COLUMN_PORESTADO_ESTADO_1 = "planificacion.estado IS NULL";
	private static final String _FINDER_COLUMN_PORESTADO_ESTADO_2 = "planificacion.estado = ?";
	private static final String _FINDER_COLUMN_PORESTADO_ESTADO_3 = "(planificacion.estado IS NULL OR planificacion.estado = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "planificacion.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No planificacion exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No planificacion exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(planificacionPersistenceImpl.class);
	private static planificacion _nullplanificacion = new planificacionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<planificacion> toCacheModel() {
				return _nullplanificacionCacheModel;
			}
		};

	private static CacheModel<planificacion> _nullplanificacionCacheModel = new CacheModel<planificacion>() {
			public planificacion toEntityModel() {
				return _nullplanificacion;
			}
		};
}
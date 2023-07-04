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

import com.co.csj.service.NoSucheditoresException;
import com.co.csj.service.model.editores;
import com.co.csj.service.model.impl.editoresImpl;
import com.co.csj.service.model.impl.editoresModelImpl;

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
 * The persistence implementation for the editores service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Equipo
 * @see editoresPersistence
 * @see editoresUtil
 * @generated
 */
public class editoresPersistenceImpl extends BasePersistenceImpl<editores>
	implements editoresPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link editoresUtil} to access the editores persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = editoresImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_PORCORREO = new FinderPath(editoresModelImpl.ENTITY_CACHE_ENABLED,
			editoresModelImpl.FINDER_CACHE_ENABLED, editoresImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPorCorreo",
			new String[] { String.class.getName() },
			editoresModelImpl.CORREO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PORCORREO = new FinderPath(editoresModelImpl.ENTITY_CACHE_ENABLED,
			editoresModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPorCorreo",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_PORUSERID = new FinderPath(editoresModelImpl.ENTITY_CACHE_ENABLED,
			editoresModelImpl.FINDER_CACHE_ENABLED, editoresImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPorUserid",
			new String[] { String.class.getName() },
			editoresModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PORUSERID = new FinderPath(editoresModelImpl.ENTITY_CACHE_ENABLED,
			editoresModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPorUserid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(editoresModelImpl.ENTITY_CACHE_ENABLED,
			editoresModelImpl.FINDER_CACHE_ENABLED, editoresImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(editoresModelImpl.ENTITY_CACHE_ENABLED,
			editoresModelImpl.FINDER_CACHE_ENABLED, editoresImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(editoresModelImpl.ENTITY_CACHE_ENABLED,
			editoresModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the editores in the entity cache if it is enabled.
	 *
	 * @param editores the editores
	 */
	public void cacheResult(editores editores) {
		EntityCacheUtil.putResult(editoresModelImpl.ENTITY_CACHE_ENABLED,
			editoresImpl.class, editores.getPrimaryKey(), editores);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORCORREO,
			new Object[] { editores.getCorreo() }, editores);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORUSERID,
			new Object[] { editores.getUserid() }, editores);

		editores.resetOriginalValues();
	}

	/**
	 * Caches the editoreses in the entity cache if it is enabled.
	 *
	 * @param editoreses the editoreses
	 */
	public void cacheResult(List<editores> editoreses) {
		for (editores editores : editoreses) {
			if (EntityCacheUtil.getResult(
						editoresModelImpl.ENTITY_CACHE_ENABLED,
						editoresImpl.class, editores.getPrimaryKey()) == null) {
				cacheResult(editores);
			}
			else {
				editores.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all editoreses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(editoresImpl.class.getName());
		}

		EntityCacheUtil.clearCache(editoresImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the editores.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(editores editores) {
		EntityCacheUtil.removeResult(editoresModelImpl.ENTITY_CACHE_ENABLED,
			editoresImpl.class, editores.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(editores);
	}

	@Override
	public void clearCache(List<editores> editoreses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (editores editores : editoreses) {
			EntityCacheUtil.removeResult(editoresModelImpl.ENTITY_CACHE_ENABLED,
				editoresImpl.class, editores.getPrimaryKey());

			clearUniqueFindersCache(editores);
		}
	}

	protected void clearUniqueFindersCache(editores editores) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORCORREO,
			new Object[] { editores.getCorreo() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORUSERID,
			new Object[] { editores.getUserid() });
	}

	/**
	 * Creates a new editores with the primary key. Does not add the editores to the database.
	 *
	 * @param id the primary key for the new editores
	 * @return the new editores
	 */
	public editores create(long id) {
		editores editores = new editoresImpl();

		editores.setNew(true);
		editores.setPrimaryKey(id);

		return editores;
	}

	/**
	 * Removes the editores with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the editores
	 * @return the editores that was removed
	 * @throws com.co.csj.service.NoSucheditoresException if a editores with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public editores remove(long id)
		throws NoSucheditoresException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the editores with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the editores
	 * @return the editores that was removed
	 * @throws com.co.csj.service.NoSucheditoresException if a editores with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public editores remove(Serializable primaryKey)
		throws NoSucheditoresException, SystemException {
		Session session = null;

		try {
			session = openSession();

			editores editores = (editores)session.get(editoresImpl.class,
					primaryKey);

			if (editores == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSucheditoresException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(editores);
		}
		catch (NoSucheditoresException nsee) {
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
	protected editores removeImpl(editores editores) throws SystemException {
		editores = toUnwrappedModel(editores);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, editores);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(editores);

		return editores;
	}

	@Override
	public editores updateImpl(com.co.csj.service.model.editores editores,
		boolean merge) throws SystemException {
		editores = toUnwrappedModel(editores);

		boolean isNew = editores.isNew();

		editoresModelImpl editoresModelImpl = (editoresModelImpl)editores;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, editores, merge);

			editores.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !editoresModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(editoresModelImpl.ENTITY_CACHE_ENABLED,
			editoresImpl.class, editores.getPrimaryKey(), editores);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORCORREO,
				new Object[] { editores.getCorreo() }, editores);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORUSERID,
				new Object[] { editores.getUserid() }, editores);
		}
		else {
			if ((editoresModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PORCORREO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						editoresModelImpl.getOriginalCorreo()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORCORREO,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORCORREO,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORCORREO,
					new Object[] { editores.getCorreo() }, editores);
			}

			if ((editoresModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PORUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						editoresModelImpl.getOriginalUserid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORUSERID,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORUSERID,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORUSERID,
					new Object[] { editores.getUserid() }, editores);
			}
		}

		return editores;
	}

	protected editores toUnwrappedModel(editores editores) {
		if (editores instanceof editoresImpl) {
			return editores;
		}

		editoresImpl editoresImpl = new editoresImpl();

		editoresImpl.setNew(editores.isNew());
		editoresImpl.setPrimaryKey(editores.getPrimaryKey());

		editoresImpl.setId(editores.getId());
		editoresImpl.setCorreo(editores.getCorreo());
		editoresImpl.setCodigo(editores.getCodigo());
		editoresImpl.setFecha_creado(editores.getFecha_creado());
		editoresImpl.setFecha_modificado(editores.getFecha_modificado());
		editoresImpl.setUltimo_inicio(editores.getUltimo_inicio());
		editoresImpl.setNombres_edita(editores.getNombres_edita());
		editoresImpl.setApellidos_edita(editores.getApellidos_edita());
		editoresImpl.setNumero_documento_edita(editores.getNumero_documento_edita());
		editoresImpl.setTipo_documento_edita(editores.getTipo_documento_edita());
		editoresImpl.setCargo_edita(editores.getCargo_edita());
		editoresImpl.setDespacho_edita(editores.getDespacho_edita());
		editoresImpl.setUserid(editores.getUserid());

		return editoresImpl;
	}

	/**
	 * Returns the editores with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the editores
	 * @return the editores
	 * @throws com.liferay.portal.NoSuchModelException if a editores with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public editores findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the editores with the primary key or throws a {@link com.co.csj.service.NoSucheditoresException} if it could not be found.
	 *
	 * @param id the primary key of the editores
	 * @return the editores
	 * @throws com.co.csj.service.NoSucheditoresException if a editores with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public editores findByPrimaryKey(long id)
		throws NoSucheditoresException, SystemException {
		editores editores = fetchByPrimaryKey(id);

		if (editores == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSucheditoresException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return editores;
	}

	/**
	 * Returns the editores with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the editores
	 * @return the editores, or <code>null</code> if a editores with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public editores fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the editores with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the editores
	 * @return the editores, or <code>null</code> if a editores with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public editores fetchByPrimaryKey(long id) throws SystemException {
		editores editores = (editores)EntityCacheUtil.getResult(editoresModelImpl.ENTITY_CACHE_ENABLED,
				editoresImpl.class, id);

		if (editores == _nulleditores) {
			return null;
		}

		if (editores == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				editores = (editores)session.get(editoresImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (editores != null) {
					cacheResult(editores);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(editoresModelImpl.ENTITY_CACHE_ENABLED,
						editoresImpl.class, id, _nulleditores);
				}

				closeSession(session);
			}
		}

		return editores;
	}

	/**
	 * Returns the editores where correo = &#63; or throws a {@link com.co.csj.service.NoSucheditoresException} if it could not be found.
	 *
	 * @param correo the correo
	 * @return the matching editores
	 * @throws com.co.csj.service.NoSucheditoresException if a matching editores could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public editores findByPorCorreo(String correo)
		throws NoSucheditoresException, SystemException {
		editores editores = fetchByPorCorreo(correo);

		if (editores == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("correo=");
			msg.append(correo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSucheditoresException(msg.toString());
		}

		return editores;
	}

	/**
	 * Returns the editores where correo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param correo the correo
	 * @return the matching editores, or <code>null</code> if a matching editores could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public editores fetchByPorCorreo(String correo) throws SystemException {
		return fetchByPorCorreo(correo, true);
	}

	/**
	 * Returns the editores where correo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param correo the correo
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching editores, or <code>null</code> if a matching editores could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public editores fetchByPorCorreo(String correo, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { correo };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PORCORREO,
					finderArgs, this);
		}

		if (result instanceof editores) {
			editores editores = (editores)result;

			if (!Validator.equals(correo, editores.getCorreo())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_EDITORES_WHERE);

			if (correo == null) {
				query.append(_FINDER_COLUMN_PORCORREO_CORREO_1);
			}
			else {
				if (correo.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORCORREO_CORREO_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORCORREO_CORREO_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (correo != null) {
					qPos.add(correo);
				}

				List<editores> list = q.list();

				result = list;

				editores editores = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORCORREO,
						finderArgs, list);
				}
				else {
					editores = list.get(0);

					cacheResult(editores);

					if ((editores.getCorreo() == null) ||
							!editores.getCorreo().equals(correo)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORCORREO,
							finderArgs, editores);
					}
				}

				return editores;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORCORREO,
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
				return (editores)result;
			}
		}
	}

	/**
	 * Returns the editores where userid = &#63; or throws a {@link com.co.csj.service.NoSucheditoresException} if it could not be found.
	 *
	 * @param userid the userid
	 * @return the matching editores
	 * @throws com.co.csj.service.NoSucheditoresException if a matching editores could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public editores findByPorUserid(String userid)
		throws NoSucheditoresException, SystemException {
		editores editores = fetchByPorUserid(userid);

		if (editores == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userid=");
			msg.append(userid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSucheditoresException(msg.toString());
		}

		return editores;
	}

	/**
	 * Returns the editores where userid = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userid the userid
	 * @return the matching editores, or <code>null</code> if a matching editores could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public editores fetchByPorUserid(String userid) throws SystemException {
		return fetchByPorUserid(userid, true);
	}

	/**
	 * Returns the editores where userid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userid the userid
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching editores, or <code>null</code> if a matching editores could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public editores fetchByPorUserid(String userid, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userid };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PORUSERID,
					finderArgs, this);
		}

		if (result instanceof editores) {
			editores editores = (editores)result;

			if (!Validator.equals(userid, editores.getUserid())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_EDITORES_WHERE);

			if (userid == null) {
				query.append(_FINDER_COLUMN_PORUSERID_USERID_1);
			}
			else {
				if (userid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORUSERID_USERID_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORUSERID_USERID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (userid != null) {
					qPos.add(userid);
				}

				List<editores> list = q.list();

				result = list;

				editores editores = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORUSERID,
						finderArgs, list);
				}
				else {
					editores = list.get(0);

					cacheResult(editores);

					if ((editores.getUserid() == null) ||
							!editores.getUserid().equals(userid)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORUSERID,
							finderArgs, editores);
					}
				}

				return editores;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORUSERID,
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
				return (editores)result;
			}
		}
	}

	/**
	 * Returns all the editoreses.
	 *
	 * @return the editoreses
	 * @throws SystemException if a system exception occurred
	 */
	public List<editores> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<editores> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the editoreses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of editoreses
	 * @param end the upper bound of the range of editoreses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of editoreses
	 * @throws SystemException if a system exception occurred
	 */
	public List<editores> findAll(int start, int end,
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

		List<editores> list = (List<editores>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EDITORES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EDITORES;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<editores>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<editores>)QueryUtil.list(q, getDialect(),
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
	 * Removes the editores where correo = &#63; from the database.
	 *
	 * @param correo the correo
	 * @return the editores that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public editores removeByPorCorreo(String correo)
		throws NoSucheditoresException, SystemException {
		editores editores = findByPorCorreo(correo);

		return remove(editores);
	}

	/**
	 * Removes the editores where userid = &#63; from the database.
	 *
	 * @param userid the userid
	 * @return the editores that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public editores removeByPorUserid(String userid)
		throws NoSucheditoresException, SystemException {
		editores editores = findByPorUserid(userid);

		return remove(editores);
	}

	/**
	 * Removes all the editoreses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (editores editores : findAll()) {
			remove(editores);
		}
	}

	/**
	 * Returns the number of editoreses where correo = &#63;.
	 *
	 * @param correo the correo
	 * @return the number of matching editoreses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPorCorreo(String correo) throws SystemException {
		Object[] finderArgs = new Object[] { correo };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PORCORREO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EDITORES_WHERE);

			if (correo == null) {
				query.append(_FINDER_COLUMN_PORCORREO_CORREO_1);
			}
			else {
				if (correo.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORCORREO_CORREO_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORCORREO_CORREO_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (correo != null) {
					qPos.add(correo);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PORCORREO,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of editoreses where userid = &#63;.
	 *
	 * @param userid the userid
	 * @return the number of matching editoreses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPorUserid(String userid) throws SystemException {
		Object[] finderArgs = new Object[] { userid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PORUSERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EDITORES_WHERE);

			if (userid == null) {
				query.append(_FINDER_COLUMN_PORUSERID_USERID_1);
			}
			else {
				if (userid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORUSERID_USERID_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORUSERID_USERID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (userid != null) {
					qPos.add(userid);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PORUSERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of editoreses.
	 *
	 * @return the number of editoreses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EDITORES);

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
	 * Initializes the editores persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.co.csj.service.model.editores")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<editores>> listenersList = new ArrayList<ModelListener<editores>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<editores>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(editoresImpl.class.getName());
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
	private static final String _SQL_SELECT_EDITORES = "SELECT editores FROM editores editores";
	private static final String _SQL_SELECT_EDITORES_WHERE = "SELECT editores FROM editores editores WHERE ";
	private static final String _SQL_COUNT_EDITORES = "SELECT COUNT(editores) FROM editores editores";
	private static final String _SQL_COUNT_EDITORES_WHERE = "SELECT COUNT(editores) FROM editores editores WHERE ";
	private static final String _FINDER_COLUMN_PORCORREO_CORREO_1 = "editores.correo IS NULL";
	private static final String _FINDER_COLUMN_PORCORREO_CORREO_2 = "editores.correo = ?";
	private static final String _FINDER_COLUMN_PORCORREO_CORREO_3 = "(editores.correo IS NULL OR editores.correo = ?)";
	private static final String _FINDER_COLUMN_PORUSERID_USERID_1 = "editores.userid IS NULL";
	private static final String _FINDER_COLUMN_PORUSERID_USERID_2 = "editores.userid = ?";
	private static final String _FINDER_COLUMN_PORUSERID_USERID_3 = "(editores.userid IS NULL OR editores.userid = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "editores.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No editores exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No editores exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(editoresPersistenceImpl.class);
	private static editores _nulleditores = new editoresImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<editores> toCacheModel() {
				return _nulleditoresCacheModel;
			}
		};

	private static CacheModel<editores> _nulleditoresCacheModel = new CacheModel<editores>() {
			public editores toEntityModel() {
				return _nulleditores;
			}
		};
}
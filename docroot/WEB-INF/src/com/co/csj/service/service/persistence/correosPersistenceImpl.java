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

import com.co.csj.service.NoSuchcorreosException;
import com.co.csj.service.model.correos;
import com.co.csj.service.model.impl.correosImpl;
import com.co.csj.service.model.impl.correosModelImpl;

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
 * The persistence implementation for the correos service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Equipo
 * @see correosPersistence
 * @see correosUtil
 * @generated
 */
public class correosPersistenceImpl extends BasePersistenceImpl<correos>
	implements correosPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link correosUtil} to access the correos persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = correosImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_PORCORREO = new FinderPath(correosModelImpl.ENTITY_CACHE_ENABLED,
			correosModelImpl.FINDER_CACHE_ENABLED, correosImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPorCorreo",
			new String[] { String.class.getName() },
			correosModelImpl.CUENTACORREO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PORCORREO = new FinderPath(correosModelImpl.ENTITY_CACHE_ENABLED,
			correosModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPorCorreo",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_PORCORREOCEDULA = new FinderPath(correosModelImpl.ENTITY_CACHE_ENABLED,
			correosModelImpl.FINDER_CACHE_ENABLED, correosImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPorCorreoCedula",
			new String[] { String.class.getName(), String.class.getName() },
			correosModelImpl.CUENTACORREO_COLUMN_BITMASK |
			correosModelImpl.CEDULARESPONSABLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PORCORREOCEDULA = new FinderPath(correosModelImpl.ENTITY_CACHE_ENABLED,
			correosModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPorCorreoCedula",
			new String[] { String.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(correosModelImpl.ENTITY_CACHE_ENABLED,
			correosModelImpl.FINDER_CACHE_ENABLED, correosImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(correosModelImpl.ENTITY_CACHE_ENABLED,
			correosModelImpl.FINDER_CACHE_ENABLED, correosImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(correosModelImpl.ENTITY_CACHE_ENABLED,
			correosModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the correos in the entity cache if it is enabled.
	 *
	 * @param correos the correos
	 */
	public void cacheResult(correos correos) {
		EntityCacheUtil.putResult(correosModelImpl.ENTITY_CACHE_ENABLED,
			correosImpl.class, correos.getPrimaryKey(), correos);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORCORREO,
			new Object[] { correos.getCuentaCorreo() }, correos);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORCORREOCEDULA,
			new Object[] {
				correos.getCuentaCorreo(),
				
			correos.getCedulaResponsable()
			}, correos);

		correos.resetOriginalValues();
	}

	/**
	 * Caches the correoses in the entity cache if it is enabled.
	 *
	 * @param correoses the correoses
	 */
	public void cacheResult(List<correos> correoses) {
		for (correos correos : correoses) {
			if (EntityCacheUtil.getResult(
						correosModelImpl.ENTITY_CACHE_ENABLED,
						correosImpl.class, correos.getPrimaryKey()) == null) {
				cacheResult(correos);
			}
			else {
				correos.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all correoses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(correosImpl.class.getName());
		}

		EntityCacheUtil.clearCache(correosImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the correos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(correos correos) {
		EntityCacheUtil.removeResult(correosModelImpl.ENTITY_CACHE_ENABLED,
			correosImpl.class, correos.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(correos);
	}

	@Override
	public void clearCache(List<correos> correoses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (correos correos : correoses) {
			EntityCacheUtil.removeResult(correosModelImpl.ENTITY_CACHE_ENABLED,
				correosImpl.class, correos.getPrimaryKey());

			clearUniqueFindersCache(correos);
		}
	}

	protected void clearUniqueFindersCache(correos correos) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORCORREO,
			new Object[] { correos.getCuentaCorreo() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORCORREOCEDULA,
			new Object[] {
				correos.getCuentaCorreo(),
				
			correos.getCedulaResponsable()
			});
	}

	/**
	 * Creates a new correos with the primary key. Does not add the correos to the database.
	 *
	 * @param id the primary key for the new correos
	 * @return the new correos
	 */
	public correos create(long id) {
		correos correos = new correosImpl();

		correos.setNew(true);
		correos.setPrimaryKey(id);

		return correos;
	}

	/**
	 * Removes the correos with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the correos
	 * @return the correos that was removed
	 * @throws com.co.csj.service.NoSuchcorreosException if a correos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public correos remove(long id)
		throws NoSuchcorreosException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the correos with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the correos
	 * @return the correos that was removed
	 * @throws com.co.csj.service.NoSuchcorreosException if a correos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public correos remove(Serializable primaryKey)
		throws NoSuchcorreosException, SystemException {
		Session session = null;

		try {
			session = openSession();

			correos correos = (correos)session.get(correosImpl.class, primaryKey);

			if (correos == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchcorreosException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(correos);
		}
		catch (NoSuchcorreosException nsee) {
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
	protected correos removeImpl(correos correos) throws SystemException {
		correos = toUnwrappedModel(correos);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, correos);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(correos);

		return correos;
	}

	@Override
	public correos updateImpl(com.co.csj.service.model.correos correos,
		boolean merge) throws SystemException {
		correos = toUnwrappedModel(correos);

		boolean isNew = correos.isNew();

		correosModelImpl correosModelImpl = (correosModelImpl)correos;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, correos, merge);

			correos.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !correosModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(correosModelImpl.ENTITY_CACHE_ENABLED,
			correosImpl.class, correos.getPrimaryKey(), correos);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORCORREO,
				new Object[] { correos.getCuentaCorreo() }, correos);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORCORREOCEDULA,
				new Object[] {
					correos.getCuentaCorreo(),
					
				correos.getCedulaResponsable()
				}, correos);
		}
		else {
			if ((correosModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PORCORREO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						correosModelImpl.getOriginalCuentaCorreo()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORCORREO,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORCORREO,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORCORREO,
					new Object[] { correos.getCuentaCorreo() }, correos);
			}

			if ((correosModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PORCORREOCEDULA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						correosModelImpl.getOriginalCuentaCorreo(),
						
						correosModelImpl.getOriginalCedulaResponsable()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORCORREOCEDULA,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORCORREOCEDULA,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORCORREOCEDULA,
					new Object[] {
						correos.getCuentaCorreo(),
						
					correos.getCedulaResponsable()
					}, correos);
			}
		}

		return correos;
	}

	protected correos toUnwrappedModel(correos correos) {
		if (correos instanceof correosImpl) {
			return correos;
		}

		correosImpl correosImpl = new correosImpl();

		correosImpl.setNew(correos.isNew());
		correosImpl.setPrimaryKey(correos.getPrimaryKey());

		correosImpl.setId(correos.getId());
		correosImpl.setCuentaCorreo(correos.getCuentaCorreo());
		correosImpl.setNombre1(correos.getNombre1());
		correosImpl.setApellido(correos.getApellido());
		correosImpl.setCargo(correos.getCargo());
		correosImpl.setCedulaResponsable(correos.getCedulaResponsable());
		correosImpl.setCodigoDespacho(correos.getCodigoDespacho());

		return correosImpl;
	}

	/**
	 * Returns the correos with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the correos
	 * @return the correos
	 * @throws com.liferay.portal.NoSuchModelException if a correos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public correos findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the correos with the primary key or throws a {@link com.co.csj.service.NoSuchcorreosException} if it could not be found.
	 *
	 * @param id the primary key of the correos
	 * @return the correos
	 * @throws com.co.csj.service.NoSuchcorreosException if a correos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public correos findByPrimaryKey(long id)
		throws NoSuchcorreosException, SystemException {
		correos correos = fetchByPrimaryKey(id);

		if (correos == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchcorreosException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return correos;
	}

	/**
	 * Returns the correos with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the correos
	 * @return the correos, or <code>null</code> if a correos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public correos fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the correos with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the correos
	 * @return the correos, or <code>null</code> if a correos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public correos fetchByPrimaryKey(long id) throws SystemException {
		correos correos = (correos)EntityCacheUtil.getResult(correosModelImpl.ENTITY_CACHE_ENABLED,
				correosImpl.class, id);

		if (correos == _nullcorreos) {
			return null;
		}

		if (correos == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				correos = (correos)session.get(correosImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (correos != null) {
					cacheResult(correos);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(correosModelImpl.ENTITY_CACHE_ENABLED,
						correosImpl.class, id, _nullcorreos);
				}

				closeSession(session);
			}
		}

		return correos;
	}

	/**
	 * Returns the correos where cuentaCorreo = &#63; or throws a {@link com.co.csj.service.NoSuchcorreosException} if it could not be found.
	 *
	 * @param cuentaCorreo the cuenta correo
	 * @return the matching correos
	 * @throws com.co.csj.service.NoSuchcorreosException if a matching correos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public correos findByPorCorreo(String cuentaCorreo)
		throws NoSuchcorreosException, SystemException {
		correos correos = fetchByPorCorreo(cuentaCorreo);

		if (correos == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cuentaCorreo=");
			msg.append(cuentaCorreo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchcorreosException(msg.toString());
		}

		return correos;
	}

	/**
	 * Returns the correos where cuentaCorreo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cuentaCorreo the cuenta correo
	 * @return the matching correos, or <code>null</code> if a matching correos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public correos fetchByPorCorreo(String cuentaCorreo)
		throws SystemException {
		return fetchByPorCorreo(cuentaCorreo, true);
	}

	/**
	 * Returns the correos where cuentaCorreo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cuentaCorreo the cuenta correo
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching correos, or <code>null</code> if a matching correos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public correos fetchByPorCorreo(String cuentaCorreo,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { cuentaCorreo };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PORCORREO,
					finderArgs, this);
		}

		if (result instanceof correos) {
			correos correos = (correos)result;

			if (!Validator.equals(cuentaCorreo, correos.getCuentaCorreo())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_CORREOS_WHERE);

			if (cuentaCorreo == null) {
				query.append(_FINDER_COLUMN_PORCORREO_CUENTACORREO_1);
			}
			else {
				if (cuentaCorreo.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORCORREO_CUENTACORREO_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORCORREO_CUENTACORREO_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (cuentaCorreo != null) {
					qPos.add(cuentaCorreo);
				}

				List<correos> list = q.list();

				result = list;

				correos correos = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORCORREO,
						finderArgs, list);
				}
				else {
					correos = list.get(0);

					cacheResult(correos);

					if ((correos.getCuentaCorreo() == null) ||
							!correos.getCuentaCorreo().equals(cuentaCorreo)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORCORREO,
							finderArgs, correos);
					}
				}

				return correos;
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
				return (correos)result;
			}
		}
	}

	/**
	 * Returns the correos where cuentaCorreo = &#63; and cedulaResponsable = &#63; or throws a {@link com.co.csj.service.NoSuchcorreosException} if it could not be found.
	 *
	 * @param cuentaCorreo the cuenta correo
	 * @param cedulaResponsable the cedula responsable
	 * @return the matching correos
	 * @throws com.co.csj.service.NoSuchcorreosException if a matching correos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public correos findByPorCorreoCedula(String cuentaCorreo,
		String cedulaResponsable)
		throws NoSuchcorreosException, SystemException {
		correos correos = fetchByPorCorreoCedula(cuentaCorreo, cedulaResponsable);

		if (correos == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cuentaCorreo=");
			msg.append(cuentaCorreo);

			msg.append(", cedulaResponsable=");
			msg.append(cedulaResponsable);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchcorreosException(msg.toString());
		}

		return correos;
	}

	/**
	 * Returns the correos where cuentaCorreo = &#63; and cedulaResponsable = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cuentaCorreo the cuenta correo
	 * @param cedulaResponsable the cedula responsable
	 * @return the matching correos, or <code>null</code> if a matching correos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public correos fetchByPorCorreoCedula(String cuentaCorreo,
		String cedulaResponsable) throws SystemException {
		return fetchByPorCorreoCedula(cuentaCorreo, cedulaResponsable, true);
	}

	/**
	 * Returns the correos where cuentaCorreo = &#63; and cedulaResponsable = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cuentaCorreo the cuenta correo
	 * @param cedulaResponsable the cedula responsable
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching correos, or <code>null</code> if a matching correos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public correos fetchByPorCorreoCedula(String cuentaCorreo,
		String cedulaResponsable, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { cuentaCorreo, cedulaResponsable };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PORCORREOCEDULA,
					finderArgs, this);
		}

		if (result instanceof correos) {
			correos correos = (correos)result;

			if (!Validator.equals(cuentaCorreo, correos.getCuentaCorreo()) ||
					!Validator.equals(cedulaResponsable,
						correos.getCedulaResponsable())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CORREOS_WHERE);

			if (cuentaCorreo == null) {
				query.append(_FINDER_COLUMN_PORCORREOCEDULA_CUENTACORREO_1);
			}
			else {
				if (cuentaCorreo.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORCORREOCEDULA_CUENTACORREO_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORCORREOCEDULA_CUENTACORREO_2);
				}
			}

			if (cedulaResponsable == null) {
				query.append(_FINDER_COLUMN_PORCORREOCEDULA_CEDULARESPONSABLE_1);
			}
			else {
				if (cedulaResponsable.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORCORREOCEDULA_CEDULARESPONSABLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORCORREOCEDULA_CEDULARESPONSABLE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (cuentaCorreo != null) {
					qPos.add(cuentaCorreo);
				}

				if (cedulaResponsable != null) {
					qPos.add(cedulaResponsable);
				}

				List<correos> list = q.list();

				result = list;

				correos correos = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORCORREOCEDULA,
						finderArgs, list);
				}
				else {
					correos = list.get(0);

					cacheResult(correos);

					if ((correos.getCuentaCorreo() == null) ||
							!correos.getCuentaCorreo().equals(cuentaCorreo) ||
							(correos.getCedulaResponsable() == null) ||
							!correos.getCedulaResponsable()
										.equals(cedulaResponsable)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORCORREOCEDULA,
							finderArgs, correos);
					}
				}

				return correos;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORCORREOCEDULA,
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
				return (correos)result;
			}
		}
	}

	/**
	 * Returns all the correoses.
	 *
	 * @return the correoses
	 * @throws SystemException if a system exception occurred
	 */
	public List<correos> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<correos> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the correoses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of correoses
	 * @param end the upper bound of the range of correoses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of correoses
	 * @throws SystemException if a system exception occurred
	 */
	public List<correos> findAll(int start, int end,
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

		List<correos> list = (List<correos>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CORREOS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CORREOS;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<correos>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<correos>)QueryUtil.list(q, getDialect(),
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
	 * Removes the correos where cuentaCorreo = &#63; from the database.
	 *
	 * @param cuentaCorreo the cuenta correo
	 * @return the correos that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public correos removeByPorCorreo(String cuentaCorreo)
		throws NoSuchcorreosException, SystemException {
		correos correos = findByPorCorreo(cuentaCorreo);

		return remove(correos);
	}

	/**
	 * Removes the correos where cuentaCorreo = &#63; and cedulaResponsable = &#63; from the database.
	 *
	 * @param cuentaCorreo the cuenta correo
	 * @param cedulaResponsable the cedula responsable
	 * @return the correos that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public correos removeByPorCorreoCedula(String cuentaCorreo,
		String cedulaResponsable)
		throws NoSuchcorreosException, SystemException {
		correos correos = findByPorCorreoCedula(cuentaCorreo, cedulaResponsable);

		return remove(correos);
	}

	/**
	 * Removes all the correoses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (correos correos : findAll()) {
			remove(correos);
		}
	}

	/**
	 * Returns the number of correoses where cuentaCorreo = &#63;.
	 *
	 * @param cuentaCorreo the cuenta correo
	 * @return the number of matching correoses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPorCorreo(String cuentaCorreo) throws SystemException {
		Object[] finderArgs = new Object[] { cuentaCorreo };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PORCORREO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CORREOS_WHERE);

			if (cuentaCorreo == null) {
				query.append(_FINDER_COLUMN_PORCORREO_CUENTACORREO_1);
			}
			else {
				if (cuentaCorreo.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORCORREO_CUENTACORREO_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORCORREO_CUENTACORREO_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (cuentaCorreo != null) {
					qPos.add(cuentaCorreo);
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
	 * Returns the number of correoses where cuentaCorreo = &#63; and cedulaResponsable = &#63;.
	 *
	 * @param cuentaCorreo the cuenta correo
	 * @param cedulaResponsable the cedula responsable
	 * @return the number of matching correoses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPorCorreoCedula(String cuentaCorreo,
		String cedulaResponsable) throws SystemException {
		Object[] finderArgs = new Object[] { cuentaCorreo, cedulaResponsable };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PORCORREOCEDULA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CORREOS_WHERE);

			if (cuentaCorreo == null) {
				query.append(_FINDER_COLUMN_PORCORREOCEDULA_CUENTACORREO_1);
			}
			else {
				if (cuentaCorreo.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORCORREOCEDULA_CUENTACORREO_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORCORREOCEDULA_CUENTACORREO_2);
				}
			}

			if (cedulaResponsable == null) {
				query.append(_FINDER_COLUMN_PORCORREOCEDULA_CEDULARESPONSABLE_1);
			}
			else {
				if (cedulaResponsable.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORCORREOCEDULA_CEDULARESPONSABLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORCORREOCEDULA_CEDULARESPONSABLE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (cuentaCorreo != null) {
					qPos.add(cuentaCorreo);
				}

				if (cedulaResponsable != null) {
					qPos.add(cedulaResponsable);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PORCORREOCEDULA,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of correoses.
	 *
	 * @return the number of correoses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CORREOS);

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
	 * Initializes the correos persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.co.csj.service.model.correos")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<correos>> listenersList = new ArrayList<ModelListener<correos>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<correos>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(correosImpl.class.getName());
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
	private static final String _SQL_SELECT_CORREOS = "SELECT correos FROM correos correos";
	private static final String _SQL_SELECT_CORREOS_WHERE = "SELECT correos FROM correos correos WHERE ";
	private static final String _SQL_COUNT_CORREOS = "SELECT COUNT(correos) FROM correos correos";
	private static final String _SQL_COUNT_CORREOS_WHERE = "SELECT COUNT(correos) FROM correos correos WHERE ";
	private static final String _FINDER_COLUMN_PORCORREO_CUENTACORREO_1 = "correos.cuentaCorreo IS NULL";
	private static final String _FINDER_COLUMN_PORCORREO_CUENTACORREO_2 = "correos.cuentaCorreo = ?";
	private static final String _FINDER_COLUMN_PORCORREO_CUENTACORREO_3 = "(correos.cuentaCorreo IS NULL OR correos.cuentaCorreo = ?)";
	private static final String _FINDER_COLUMN_PORCORREOCEDULA_CUENTACORREO_1 = "correos.cuentaCorreo IS NULL AND ";
	private static final String _FINDER_COLUMN_PORCORREOCEDULA_CUENTACORREO_2 = "correos.cuentaCorreo = ? AND ";
	private static final String _FINDER_COLUMN_PORCORREOCEDULA_CUENTACORREO_3 = "(correos.cuentaCorreo IS NULL OR correos.cuentaCorreo = ?) AND ";
	private static final String _FINDER_COLUMN_PORCORREOCEDULA_CEDULARESPONSABLE_1 =
		"correos.cedulaResponsable IS NULL";
	private static final String _FINDER_COLUMN_PORCORREOCEDULA_CEDULARESPONSABLE_2 =
		"correos.cedulaResponsable = ?";
	private static final String _FINDER_COLUMN_PORCORREOCEDULA_CEDULARESPONSABLE_3 =
		"(correos.cedulaResponsable IS NULL OR correos.cedulaResponsable = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "correos.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No correos exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No correos exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(correosPersistenceImpl.class);
	private static correos _nullcorreos = new correosImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<correos> toCacheModel() {
				return _nullcorreosCacheModel;
			}
		};

	private static CacheModel<correos> _nullcorreosCacheModel = new CacheModel<correos>() {
			public correos toEntityModel() {
				return _nullcorreos;
			}
		};
}
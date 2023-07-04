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

import com.co.csj.service.NoSuchpublicacionesException;
import com.co.csj.service.model.impl.publicacionesImpl;
import com.co.csj.service.model.impl.publicacionesModelImpl;
import com.co.csj.service.model.publicaciones;

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
 * The persistence implementation for the publicaciones service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Equipo
 * @see publicacionesPersistence
 * @see publicacionesUtil
 * @generated
 */
public class publicacionesPersistenceImpl extends BasePersistenceImpl<publicaciones>
	implements publicacionesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link publicacionesUtil} to access the publicaciones persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = publicacionesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_PORESTADOUSUARIO = new FinderPath(publicacionesModelImpl.ENTITY_CACHE_ENABLED,
			publicacionesModelImpl.FINDER_CACHE_ENABLED,
			publicacionesImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPorEstadoUsuario",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				String.class.getName()
			},
			publicacionesModelImpl.FK_USUARIO_COLUMN_BITMASK |
			publicacionesModelImpl.ANHIO_PUBLICACION_COLUMN_BITMASK |
			publicacionesModelImpl.ESTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PORESTADOUSUARIO = new FinderPath(publicacionesModelImpl.ENTITY_CACHE_ENABLED,
			publicacionesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPorEstadoUsuario",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PORESTADOSOLICITUDES =
		new FinderPath(publicacionesModelImpl.ENTITY_CACHE_ENABLED,
			publicacionesModelImpl.FINDER_CACHE_ENABLED,
			publicacionesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPorEstadoSolicitudes",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORESTADOSOLICITUDES =
		new FinderPath(publicacionesModelImpl.ENTITY_CACHE_ENABLED,
			publicacionesModelImpl.FINDER_CACHE_ENABLED,
			publicacionesImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPorEstadoSolicitudes",
			new String[] { String.class.getName(), Integer.class.getName() },
			publicacionesModelImpl.ESTATUS_COLUMN_BITMASK |
			publicacionesModelImpl.ANHIO_PUBLICACION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PORESTADOSOLICITUDES = new FinderPath(publicacionesModelImpl.ENTITY_CACHE_ENABLED,
			publicacionesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPorEstadoSolicitudes",
			new String[] { String.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(publicacionesModelImpl.ENTITY_CACHE_ENABLED,
			publicacionesModelImpl.FINDER_CACHE_ENABLED,
			publicacionesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(publicacionesModelImpl.ENTITY_CACHE_ENABLED,
			publicacionesModelImpl.FINDER_CACHE_ENABLED,
			publicacionesImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(publicacionesModelImpl.ENTITY_CACHE_ENABLED,
			publicacionesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the publicaciones in the entity cache if it is enabled.
	 *
	 * @param publicaciones the publicaciones
	 */
	public void cacheResult(publicaciones publicaciones) {
		EntityCacheUtil.putResult(publicacionesModelImpl.ENTITY_CACHE_ENABLED,
			publicacionesImpl.class, publicaciones.getPrimaryKey(),
			publicaciones);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORESTADOUSUARIO,
			new Object[] {
				publicaciones.getFk_usuario(),
				Integer.valueOf(publicaciones.getAnhio_publicacion()),
				
			publicaciones.getEstatus()
			}, publicaciones);

		publicaciones.resetOriginalValues();
	}

	/**
	 * Caches the publicacioneses in the entity cache if it is enabled.
	 *
	 * @param publicacioneses the publicacioneses
	 */
	public void cacheResult(List<publicaciones> publicacioneses) {
		for (publicaciones publicaciones : publicacioneses) {
			if (EntityCacheUtil.getResult(
						publicacionesModelImpl.ENTITY_CACHE_ENABLED,
						publicacionesImpl.class, publicaciones.getPrimaryKey()) == null) {
				cacheResult(publicaciones);
			}
			else {
				publicaciones.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all publicacioneses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(publicacionesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(publicacionesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the publicaciones.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(publicaciones publicaciones) {
		EntityCacheUtil.removeResult(publicacionesModelImpl.ENTITY_CACHE_ENABLED,
			publicacionesImpl.class, publicaciones.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(publicaciones);
	}

	@Override
	public void clearCache(List<publicaciones> publicacioneses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (publicaciones publicaciones : publicacioneses) {
			EntityCacheUtil.removeResult(publicacionesModelImpl.ENTITY_CACHE_ENABLED,
				publicacionesImpl.class, publicaciones.getPrimaryKey());

			clearUniqueFindersCache(publicaciones);
		}
	}

	protected void clearUniqueFindersCache(publicaciones publicaciones) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORESTADOUSUARIO,
			new Object[] {
				publicaciones.getFk_usuario(),
				Integer.valueOf(publicaciones.getAnhio_publicacion()),
				
			publicaciones.getEstatus()
			});
	}

	/**
	 * Creates a new publicaciones with the primary key. Does not add the publicaciones to the database.
	 *
	 * @param id the primary key for the new publicaciones
	 * @return the new publicaciones
	 */
	public publicaciones create(long id) {
		publicaciones publicaciones = new publicacionesImpl();

		publicaciones.setNew(true);
		publicaciones.setPrimaryKey(id);

		return publicaciones;
	}

	/**
	 * Removes the publicaciones with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the publicaciones
	 * @return the publicaciones that was removed
	 * @throws com.co.csj.service.NoSuchpublicacionesException if a publicaciones with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public publicaciones remove(long id)
		throws NoSuchpublicacionesException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the publicaciones with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the publicaciones
	 * @return the publicaciones that was removed
	 * @throws com.co.csj.service.NoSuchpublicacionesException if a publicaciones with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public publicaciones remove(Serializable primaryKey)
		throws NoSuchpublicacionesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			publicaciones publicaciones = (publicaciones)session.get(publicacionesImpl.class,
					primaryKey);

			if (publicaciones == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchpublicacionesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(publicaciones);
		}
		catch (NoSuchpublicacionesException nsee) {
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
	protected publicaciones removeImpl(publicaciones publicaciones)
		throws SystemException {
		publicaciones = toUnwrappedModel(publicaciones);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, publicaciones);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(publicaciones);

		return publicaciones;
	}

	@Override
	public publicaciones updateImpl(
		com.co.csj.service.model.publicaciones publicaciones, boolean merge)
		throws SystemException {
		publicaciones = toUnwrappedModel(publicaciones);

		boolean isNew = publicaciones.isNew();

		publicacionesModelImpl publicacionesModelImpl = (publicacionesModelImpl)publicaciones;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, publicaciones, merge);

			publicaciones.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !publicacionesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((publicacionesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORESTADOSOLICITUDES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publicacionesModelImpl.getOriginalEstatus(),
						Integer.valueOf(publicacionesModelImpl.getOriginalAnhio_publicacion())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORESTADOSOLICITUDES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORESTADOSOLICITUDES,
					args);

				args = new Object[] {
						publicacionesModelImpl.getEstatus(),
						Integer.valueOf(publicacionesModelImpl.getAnhio_publicacion())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORESTADOSOLICITUDES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORESTADOSOLICITUDES,
					args);
			}
		}

		EntityCacheUtil.putResult(publicacionesModelImpl.ENTITY_CACHE_ENABLED,
			publicacionesImpl.class, publicaciones.getPrimaryKey(),
			publicaciones);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORESTADOUSUARIO,
				new Object[] {
					publicaciones.getFk_usuario(),
					Integer.valueOf(publicaciones.getAnhio_publicacion()),
					
				publicaciones.getEstatus()
				}, publicaciones);
		}
		else {
			if ((publicacionesModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PORESTADOUSUARIO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publicacionesModelImpl.getOriginalFk_usuario(),
						Integer.valueOf(publicacionesModelImpl.getOriginalAnhio_publicacion()),
						
						publicacionesModelImpl.getOriginalEstatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORESTADOUSUARIO,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORESTADOUSUARIO,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORESTADOUSUARIO,
					new Object[] {
						publicaciones.getFk_usuario(),
						Integer.valueOf(publicaciones.getAnhio_publicacion()),
						
					publicaciones.getEstatus()
					}, publicaciones);
			}
		}

		return publicaciones;
	}

	protected publicaciones toUnwrappedModel(publicaciones publicaciones) {
		if (publicaciones instanceof publicacionesImpl) {
			return publicaciones;
		}

		publicacionesImpl publicacionesImpl = new publicacionesImpl();

		publicacionesImpl.setNew(publicaciones.isNew());
		publicacionesImpl.setPrimaryKey(publicaciones.getPrimaryKey());

		publicacionesImpl.setId(publicaciones.getId());
		publicacionesImpl.setFk_usuario(publicaciones.getFk_usuario());
		publicacionesImpl.setDespacho_usuario(publicaciones.getDespacho_usuario());
		publicacionesImpl.setArchivo_hoja_vida(publicaciones.getArchivo_hoja_vida());
		publicacionesImpl.setArchivo_declaracion_renta(publicaciones.getArchivo_declaracion_renta());
		publicacionesImpl.setArchivo_formulario_bienes(publicaciones.getArchivo_formulario_bienes());
		publicacionesImpl.setFecha_solicitud(publicaciones.getFecha_solicitud());
		publicacionesImpl.setFecha_publicacion(publicaciones.getFecha_publicacion());
		publicacionesImpl.setAprobado_por(publicaciones.getAprobado_por());
		publicacionesImpl.setFecha_negado(publicaciones.getFecha_negado());
		publicacionesImpl.setNegado_por(publicaciones.getNegado_por());
		publicacionesImpl.setAnhio_publicacion(publicaciones.getAnhio_publicacion());
		publicacionesImpl.setFecha_modificado(publicaciones.getFecha_modificado());
		publicacionesImpl.setEstatus(publicaciones.getEstatus());
		publicacionesImpl.setCausa_negado(publicaciones.getCausa_negado());
		publicacionesImpl.setCargo(publicaciones.getCargo());
		publicacionesImpl.setRetirado(publicaciones.getRetirado());

		return publicacionesImpl;
	}

	/**
	 * Returns the publicaciones with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the publicaciones
	 * @return the publicaciones
	 * @throws com.liferay.portal.NoSuchModelException if a publicaciones with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public publicaciones findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the publicaciones with the primary key or throws a {@link com.co.csj.service.NoSuchpublicacionesException} if it could not be found.
	 *
	 * @param id the primary key of the publicaciones
	 * @return the publicaciones
	 * @throws com.co.csj.service.NoSuchpublicacionesException if a publicaciones with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public publicaciones findByPrimaryKey(long id)
		throws NoSuchpublicacionesException, SystemException {
		publicaciones publicaciones = fetchByPrimaryKey(id);

		if (publicaciones == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchpublicacionesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return publicaciones;
	}

	/**
	 * Returns the publicaciones with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the publicaciones
	 * @return the publicaciones, or <code>null</code> if a publicaciones with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public publicaciones fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the publicaciones with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the publicaciones
	 * @return the publicaciones, or <code>null</code> if a publicaciones with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public publicaciones fetchByPrimaryKey(long id) throws SystemException {
		publicaciones publicaciones = (publicaciones)EntityCacheUtil.getResult(publicacionesModelImpl.ENTITY_CACHE_ENABLED,
				publicacionesImpl.class, id);

		if (publicaciones == _nullpublicaciones) {
			return null;
		}

		if (publicaciones == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				publicaciones = (publicaciones)session.get(publicacionesImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (publicaciones != null) {
					cacheResult(publicaciones);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(publicacionesModelImpl.ENTITY_CACHE_ENABLED,
						publicacionesImpl.class, id, _nullpublicaciones);
				}

				closeSession(session);
			}
		}

		return publicaciones;
	}

	/**
	 * Returns the publicaciones where fk_usuario = &#63; and anhio_publicacion = &#63; and estatus = &#63; or throws a {@link com.co.csj.service.NoSuchpublicacionesException} if it could not be found.
	 *
	 * @param fk_usuario the fk_usuario
	 * @param anhio_publicacion the anhio_publicacion
	 * @param estatus the estatus
	 * @return the matching publicaciones
	 * @throws com.co.csj.service.NoSuchpublicacionesException if a matching publicaciones could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public publicaciones findByPorEstadoUsuario(String fk_usuario,
		int anhio_publicacion, String estatus)
		throws NoSuchpublicacionesException, SystemException {
		publicaciones publicaciones = fetchByPorEstadoUsuario(fk_usuario,
				anhio_publicacion, estatus);

		if (publicaciones == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("fk_usuario=");
			msg.append(fk_usuario);

			msg.append(", anhio_publicacion=");
			msg.append(anhio_publicacion);

			msg.append(", estatus=");
			msg.append(estatus);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchpublicacionesException(msg.toString());
		}

		return publicaciones;
	}

	/**
	 * Returns the publicaciones where fk_usuario = &#63; and anhio_publicacion = &#63; and estatus = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fk_usuario the fk_usuario
	 * @param anhio_publicacion the anhio_publicacion
	 * @param estatus the estatus
	 * @return the matching publicaciones, or <code>null</code> if a matching publicaciones could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public publicaciones fetchByPorEstadoUsuario(String fk_usuario,
		int anhio_publicacion, String estatus) throws SystemException {
		return fetchByPorEstadoUsuario(fk_usuario, anhio_publicacion, estatus,
			true);
	}

	/**
	 * Returns the publicaciones where fk_usuario = &#63; and anhio_publicacion = &#63; and estatus = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fk_usuario the fk_usuario
	 * @param anhio_publicacion the anhio_publicacion
	 * @param estatus the estatus
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching publicaciones, or <code>null</code> if a matching publicaciones could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public publicaciones fetchByPorEstadoUsuario(String fk_usuario,
		int anhio_publicacion, String estatus, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				fk_usuario, anhio_publicacion, estatus
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PORESTADOUSUARIO,
					finderArgs, this);
		}

		if (result instanceof publicaciones) {
			publicaciones publicaciones = (publicaciones)result;

			if (!Validator.equals(fk_usuario, publicaciones.getFk_usuario()) ||
					(anhio_publicacion != publicaciones.getAnhio_publicacion()) ||
					!Validator.equals(estatus, publicaciones.getEstatus())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PUBLICACIONES_WHERE);

			if (fk_usuario == null) {
				query.append(_FINDER_COLUMN_PORESTADOUSUARIO_FK_USUARIO_1);
			}
			else {
				if (fk_usuario.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORESTADOUSUARIO_FK_USUARIO_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORESTADOUSUARIO_FK_USUARIO_2);
				}
			}

			query.append(_FINDER_COLUMN_PORESTADOUSUARIO_ANHIO_PUBLICACION_2);

			if (estatus == null) {
				query.append(_FINDER_COLUMN_PORESTADOUSUARIO_ESTATUS_1);
			}
			else {
				if (estatus.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORESTADOUSUARIO_ESTATUS_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORESTADOUSUARIO_ESTATUS_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (fk_usuario != null) {
					qPos.add(fk_usuario);
				}

				qPos.add(anhio_publicacion);

				if (estatus != null) {
					qPos.add(estatus);
				}

				List<publicaciones> list = q.list();

				result = list;

				publicaciones publicaciones = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORESTADOUSUARIO,
						finderArgs, list);
				}
				else {
					publicaciones = list.get(0);

					cacheResult(publicaciones);

					if ((publicaciones.getFk_usuario() == null) ||
							!publicaciones.getFk_usuario().equals(fk_usuario) ||
							(publicaciones.getAnhio_publicacion() != anhio_publicacion) ||
							(publicaciones.getEstatus() == null) ||
							!publicaciones.getEstatus().equals(estatus)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PORESTADOUSUARIO,
							finderArgs, publicaciones);
					}
				}

				return publicaciones;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PORESTADOUSUARIO,
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
				return (publicaciones)result;
			}
		}
	}

	/**
	 * Returns all the publicacioneses where estatus = &#63; and anhio_publicacion = &#63;.
	 *
	 * @param estatus the estatus
	 * @param anhio_publicacion the anhio_publicacion
	 * @return the matching publicacioneses
	 * @throws SystemException if a system exception occurred
	 */
	public List<publicaciones> findByPorEstadoSolicitudes(String estatus,
		int anhio_publicacion) throws SystemException {
		return findByPorEstadoSolicitudes(estatus, anhio_publicacion,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the publicacioneses where estatus = &#63; and anhio_publicacion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param estatus the estatus
	 * @param anhio_publicacion the anhio_publicacion
	 * @param start the lower bound of the range of publicacioneses
	 * @param end the upper bound of the range of publicacioneses (not inclusive)
	 * @return the range of matching publicacioneses
	 * @throws SystemException if a system exception occurred
	 */
	public List<publicaciones> findByPorEstadoSolicitudes(String estatus,
		int anhio_publicacion, int start, int end) throws SystemException {
		return findByPorEstadoSolicitudes(estatus, anhio_publicacion, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the publicacioneses where estatus = &#63; and anhio_publicacion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param estatus the estatus
	 * @param anhio_publicacion the anhio_publicacion
	 * @param start the lower bound of the range of publicacioneses
	 * @param end the upper bound of the range of publicacioneses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching publicacioneses
	 * @throws SystemException if a system exception occurred
	 */
	public List<publicaciones> findByPorEstadoSolicitudes(String estatus,
		int anhio_publicacion, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORESTADOSOLICITUDES;
			finderArgs = new Object[] { estatus, anhio_publicacion };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PORESTADOSOLICITUDES;
			finderArgs = new Object[] {
					estatus, anhio_publicacion,
					
					start, end, orderByComparator
				};
		}

		List<publicaciones> list = (List<publicaciones>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (publicaciones publicaciones : list) {
				if (!Validator.equals(estatus, publicaciones.getEstatus()) ||
						(anhio_publicacion != publicaciones.getAnhio_publicacion())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PUBLICACIONES_WHERE);

			if (estatus == null) {
				query.append(_FINDER_COLUMN_PORESTADOSOLICITUDES_ESTATUS_1);
			}
			else {
				if (estatus.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORESTADOSOLICITUDES_ESTATUS_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORESTADOSOLICITUDES_ESTATUS_2);
				}
			}

			query.append(_FINDER_COLUMN_PORESTADOSOLICITUDES_ANHIO_PUBLICACION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (estatus != null) {
					qPos.add(estatus);
				}

				qPos.add(anhio_publicacion);

				list = (List<publicaciones>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first publicaciones in the ordered set where estatus = &#63; and anhio_publicacion = &#63;.
	 *
	 * @param estatus the estatus
	 * @param anhio_publicacion the anhio_publicacion
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publicaciones
	 * @throws com.co.csj.service.NoSuchpublicacionesException if a matching publicaciones could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public publicaciones findByPorEstadoSolicitudes_First(String estatus,
		int anhio_publicacion, OrderByComparator orderByComparator)
		throws NoSuchpublicacionesException, SystemException {
		publicaciones publicaciones = fetchByPorEstadoSolicitudes_First(estatus,
				anhio_publicacion, orderByComparator);

		if (publicaciones != null) {
			return publicaciones;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("estatus=");
		msg.append(estatus);

		msg.append(", anhio_publicacion=");
		msg.append(anhio_publicacion);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchpublicacionesException(msg.toString());
	}

	/**
	 * Returns the first publicaciones in the ordered set where estatus = &#63; and anhio_publicacion = &#63;.
	 *
	 * @param estatus the estatus
	 * @param anhio_publicacion the anhio_publicacion
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publicaciones, or <code>null</code> if a matching publicaciones could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public publicaciones fetchByPorEstadoSolicitudes_First(String estatus,
		int anhio_publicacion, OrderByComparator orderByComparator)
		throws SystemException {
		List<publicaciones> list = findByPorEstadoSolicitudes(estatus,
				anhio_publicacion, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last publicaciones in the ordered set where estatus = &#63; and anhio_publicacion = &#63;.
	 *
	 * @param estatus the estatus
	 * @param anhio_publicacion the anhio_publicacion
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publicaciones
	 * @throws com.co.csj.service.NoSuchpublicacionesException if a matching publicaciones could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public publicaciones findByPorEstadoSolicitudes_Last(String estatus,
		int anhio_publicacion, OrderByComparator orderByComparator)
		throws NoSuchpublicacionesException, SystemException {
		publicaciones publicaciones = fetchByPorEstadoSolicitudes_Last(estatus,
				anhio_publicacion, orderByComparator);

		if (publicaciones != null) {
			return publicaciones;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("estatus=");
		msg.append(estatus);

		msg.append(", anhio_publicacion=");
		msg.append(anhio_publicacion);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchpublicacionesException(msg.toString());
	}

	/**
	 * Returns the last publicaciones in the ordered set where estatus = &#63; and anhio_publicacion = &#63;.
	 *
	 * @param estatus the estatus
	 * @param anhio_publicacion the anhio_publicacion
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publicaciones, or <code>null</code> if a matching publicaciones could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public publicaciones fetchByPorEstadoSolicitudes_Last(String estatus,
		int anhio_publicacion, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPorEstadoSolicitudes(estatus, anhio_publicacion);

		List<publicaciones> list = findByPorEstadoSolicitudes(estatus,
				anhio_publicacion, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the publicacioneses before and after the current publicaciones in the ordered set where estatus = &#63; and anhio_publicacion = &#63;.
	 *
	 * @param id the primary key of the current publicaciones
	 * @param estatus the estatus
	 * @param anhio_publicacion the anhio_publicacion
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next publicaciones
	 * @throws com.co.csj.service.NoSuchpublicacionesException if a publicaciones with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public publicaciones[] findByPorEstadoSolicitudes_PrevAndNext(long id,
		String estatus, int anhio_publicacion,
		OrderByComparator orderByComparator)
		throws NoSuchpublicacionesException, SystemException {
		publicaciones publicaciones = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			publicaciones[] array = new publicacionesImpl[3];

			array[0] = getByPorEstadoSolicitudes_PrevAndNext(session,
					publicaciones, estatus, anhio_publicacion,
					orderByComparator, true);

			array[1] = publicaciones;

			array[2] = getByPorEstadoSolicitudes_PrevAndNext(session,
					publicaciones, estatus, anhio_publicacion,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected publicaciones getByPorEstadoSolicitudes_PrevAndNext(
		Session session, publicaciones publicaciones, String estatus,
		int anhio_publicacion, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PUBLICACIONES_WHERE);

		if (estatus == null) {
			query.append(_FINDER_COLUMN_PORESTADOSOLICITUDES_ESTATUS_1);
		}
		else {
			if (estatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PORESTADOSOLICITUDES_ESTATUS_3);
			}
			else {
				query.append(_FINDER_COLUMN_PORESTADOSOLICITUDES_ESTATUS_2);
			}
		}

		query.append(_FINDER_COLUMN_PORESTADOSOLICITUDES_ANHIO_PUBLICACION_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (estatus != null) {
			qPos.add(estatus);
		}

		qPos.add(anhio_publicacion);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(publicaciones);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<publicaciones> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the publicacioneses.
	 *
	 * @return the publicacioneses
	 * @throws SystemException if a system exception occurred
	 */
	public List<publicaciones> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the publicacioneses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of publicacioneses
	 * @param end the upper bound of the range of publicacioneses (not inclusive)
	 * @return the range of publicacioneses
	 * @throws SystemException if a system exception occurred
	 */
	public List<publicaciones> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the publicacioneses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of publicacioneses
	 * @param end the upper bound of the range of publicacioneses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of publicacioneses
	 * @throws SystemException if a system exception occurred
	 */
	public List<publicaciones> findAll(int start, int end,
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

		List<publicaciones> list = (List<publicaciones>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PUBLICACIONES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PUBLICACIONES;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<publicaciones>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<publicaciones>)QueryUtil.list(q, getDialect(),
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
	 * Removes the publicaciones where fk_usuario = &#63; and anhio_publicacion = &#63; and estatus = &#63; from the database.
	 *
	 * @param fk_usuario the fk_usuario
	 * @param anhio_publicacion the anhio_publicacion
	 * @param estatus the estatus
	 * @return the publicaciones that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public publicaciones removeByPorEstadoUsuario(String fk_usuario,
		int anhio_publicacion, String estatus)
		throws NoSuchpublicacionesException, SystemException {
		publicaciones publicaciones = findByPorEstadoUsuario(fk_usuario,
				anhio_publicacion, estatus);

		return remove(publicaciones);
	}

	/**
	 * Removes all the publicacioneses where estatus = &#63; and anhio_publicacion = &#63; from the database.
	 *
	 * @param estatus the estatus
	 * @param anhio_publicacion the anhio_publicacion
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPorEstadoSolicitudes(String estatus,
		int anhio_publicacion) throws SystemException {
		for (publicaciones publicaciones : findByPorEstadoSolicitudes(estatus,
				anhio_publicacion)) {
			remove(publicaciones);
		}
	}

	/**
	 * Removes all the publicacioneses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (publicaciones publicaciones : findAll()) {
			remove(publicaciones);
		}
	}

	/**
	 * Returns the number of publicacioneses where fk_usuario = &#63; and anhio_publicacion = &#63; and estatus = &#63;.
	 *
	 * @param fk_usuario the fk_usuario
	 * @param anhio_publicacion the anhio_publicacion
	 * @param estatus the estatus
	 * @return the number of matching publicacioneses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPorEstadoUsuario(String fk_usuario,
		int anhio_publicacion, String estatus) throws SystemException {
		Object[] finderArgs = new Object[] {
				fk_usuario, anhio_publicacion, estatus
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PORESTADOUSUARIO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PUBLICACIONES_WHERE);

			if (fk_usuario == null) {
				query.append(_FINDER_COLUMN_PORESTADOUSUARIO_FK_USUARIO_1);
			}
			else {
				if (fk_usuario.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORESTADOUSUARIO_FK_USUARIO_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORESTADOUSUARIO_FK_USUARIO_2);
				}
			}

			query.append(_FINDER_COLUMN_PORESTADOUSUARIO_ANHIO_PUBLICACION_2);

			if (estatus == null) {
				query.append(_FINDER_COLUMN_PORESTADOUSUARIO_ESTATUS_1);
			}
			else {
				if (estatus.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORESTADOUSUARIO_ESTATUS_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORESTADOUSUARIO_ESTATUS_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (fk_usuario != null) {
					qPos.add(fk_usuario);
				}

				qPos.add(anhio_publicacion);

				if (estatus != null) {
					qPos.add(estatus);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PORESTADOUSUARIO,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of publicacioneses where estatus = &#63; and anhio_publicacion = &#63;.
	 *
	 * @param estatus the estatus
	 * @param anhio_publicacion the anhio_publicacion
	 * @return the number of matching publicacioneses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPorEstadoSolicitudes(String estatus, int anhio_publicacion)
		throws SystemException {
		Object[] finderArgs = new Object[] { estatus, anhio_publicacion };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PORESTADOSOLICITUDES,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PUBLICACIONES_WHERE);

			if (estatus == null) {
				query.append(_FINDER_COLUMN_PORESTADOSOLICITUDES_ESTATUS_1);
			}
			else {
				if (estatus.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PORESTADOSOLICITUDES_ESTATUS_3);
				}
				else {
					query.append(_FINDER_COLUMN_PORESTADOSOLICITUDES_ESTATUS_2);
				}
			}

			query.append(_FINDER_COLUMN_PORESTADOSOLICITUDES_ANHIO_PUBLICACION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (estatus != null) {
					qPos.add(estatus);
				}

				qPos.add(anhio_publicacion);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PORESTADOSOLICITUDES,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of publicacioneses.
	 *
	 * @return the number of publicacioneses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PUBLICACIONES);

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
	 * Initializes the publicaciones persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.co.csj.service.model.publicaciones")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<publicaciones>> listenersList = new ArrayList<ModelListener<publicaciones>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<publicaciones>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(publicacionesImpl.class.getName());
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
	private static final String _SQL_SELECT_PUBLICACIONES = "SELECT publicaciones FROM publicaciones publicaciones";
	private static final String _SQL_SELECT_PUBLICACIONES_WHERE = "SELECT publicaciones FROM publicaciones publicaciones WHERE ";
	private static final String _SQL_COUNT_PUBLICACIONES = "SELECT COUNT(publicaciones) FROM publicaciones publicaciones";
	private static final String _SQL_COUNT_PUBLICACIONES_WHERE = "SELECT COUNT(publicaciones) FROM publicaciones publicaciones WHERE ";
	private static final String _FINDER_COLUMN_PORESTADOUSUARIO_FK_USUARIO_1 = "publicaciones.fk_usuario IS NULL AND ";
	private static final String _FINDER_COLUMN_PORESTADOUSUARIO_FK_USUARIO_2 = "publicaciones.fk_usuario = ? AND ";
	private static final String _FINDER_COLUMN_PORESTADOUSUARIO_FK_USUARIO_3 = "(publicaciones.fk_usuario IS NULL OR publicaciones.fk_usuario = ?) AND ";
	private static final String _FINDER_COLUMN_PORESTADOUSUARIO_ANHIO_PUBLICACION_2 =
		"publicaciones.anhio_publicacion = ? AND ";
	private static final String _FINDER_COLUMN_PORESTADOUSUARIO_ESTATUS_1 = "publicaciones.estatus IS NULL";
	private static final String _FINDER_COLUMN_PORESTADOUSUARIO_ESTATUS_2 = "publicaciones.estatus = ?";
	private static final String _FINDER_COLUMN_PORESTADOUSUARIO_ESTATUS_3 = "(publicaciones.estatus IS NULL OR publicaciones.estatus = ?)";
	private static final String _FINDER_COLUMN_PORESTADOSOLICITUDES_ESTATUS_1 = "publicaciones.estatus IS NULL AND ";
	private static final String _FINDER_COLUMN_PORESTADOSOLICITUDES_ESTATUS_2 = "publicaciones.estatus = ? AND ";
	private static final String _FINDER_COLUMN_PORESTADOSOLICITUDES_ESTATUS_3 = "(publicaciones.estatus IS NULL OR publicaciones.estatus = ?) AND ";
	private static final String _FINDER_COLUMN_PORESTADOSOLICITUDES_ANHIO_PUBLICACION_2 =
		"publicaciones.anhio_publicacion = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "publicaciones.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No publicaciones exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No publicaciones exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(publicacionesPersistenceImpl.class);
	private static publicaciones _nullpublicaciones = new publicacionesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<publicaciones> toCacheModel() {
				return _nullpublicacionesCacheModel;
			}
		};

	private static CacheModel<publicaciones> _nullpublicacionesCacheModel = new CacheModel<publicaciones>() {
			public publicaciones toEntityModel() {
				return _nullpublicaciones;
			}
		};
}
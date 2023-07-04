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

import com.co.csj.service.model.auditoriaClp;
import com.co.csj.service.model.correosClp;
import com.co.csj.service.model.editoresClp;
import com.co.csj.service.model.planificacionClp;
import com.co.csj.service.model.publicacionesClp;
import com.co.csj.service.model.usuario_dataClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"ley_transparencia-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"ley_transparencia-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "ley_transparencia-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(auditoriaClp.class.getName())) {
			return translateInputauditoria(oldModel);
		}

		if (oldModelClassName.equals(correosClp.class.getName())) {
			return translateInputcorreos(oldModel);
		}

		if (oldModelClassName.equals(editoresClp.class.getName())) {
			return translateInputeditores(oldModel);
		}

		if (oldModelClassName.equals(planificacionClp.class.getName())) {
			return translateInputplanificacion(oldModel);
		}

		if (oldModelClassName.equals(publicacionesClp.class.getName())) {
			return translateInputpublicaciones(oldModel);
		}

		if (oldModelClassName.equals(usuario_dataClp.class.getName())) {
			return translateInputusuario_data(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputauditoria(BaseModel<?> oldModel) {
		auditoriaClp oldClpModel = (auditoriaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getauditoriaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputcorreos(BaseModel<?> oldModel) {
		correosClp oldClpModel = (correosClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getcorreosRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputeditores(BaseModel<?> oldModel) {
		editoresClp oldClpModel = (editoresClp)oldModel;

		BaseModel<?> newModel = oldClpModel.geteditoresRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputplanificacion(BaseModel<?> oldModel) {
		planificacionClp oldClpModel = (planificacionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getplanificacionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputpublicaciones(BaseModel<?> oldModel) {
		publicacionesClp oldClpModel = (publicacionesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getpublicacionesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputusuario_data(BaseModel<?> oldModel) {
		usuario_dataClp oldClpModel = (usuario_dataClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getusuario_dataRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.co.csj.service.model.impl.auditoriaImpl")) {
			return translateOutputauditoria(oldModel);
		}

		if (oldModelClassName.equals(
					"com.co.csj.service.model.impl.correosImpl")) {
			return translateOutputcorreos(oldModel);
		}

		if (oldModelClassName.equals(
					"com.co.csj.service.model.impl.editoresImpl")) {
			return translateOutputeditores(oldModel);
		}

		if (oldModelClassName.equals(
					"com.co.csj.service.model.impl.planificacionImpl")) {
			return translateOutputplanificacion(oldModel);
		}

		if (oldModelClassName.equals(
					"com.co.csj.service.model.impl.publicacionesImpl")) {
			return translateOutputpublicaciones(oldModel);
		}

		if (oldModelClassName.equals(
					"com.co.csj.service.model.impl.usuario_dataImpl")) {
			return translateOutputusuario_data(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.co.csj.service.NoSuchauditoriaException")) {
			return new com.co.csj.service.NoSuchauditoriaException();
		}

		if (className.equals("com.co.csj.service.NoSuchcorreosException")) {
			return new com.co.csj.service.NoSuchcorreosException();
		}

		if (className.equals("com.co.csj.service.NoSucheditoresException")) {
			return new com.co.csj.service.NoSucheditoresException();
		}

		if (className.equals("com.co.csj.service.NoSuchplanificacionException")) {
			return new com.co.csj.service.NoSuchplanificacionException();
		}

		if (className.equals("com.co.csj.service.NoSuchpublicacionesException")) {
			return new com.co.csj.service.NoSuchpublicacionesException();
		}

		if (className.equals("com.co.csj.service.NoSuchusuario_dataException")) {
			return new com.co.csj.service.NoSuchusuario_dataException();
		}

		return throwable;
	}

	public static Object translateOutputauditoria(BaseModel<?> oldModel) {
		auditoriaClp newModel = new auditoriaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setauditoriaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputcorreos(BaseModel<?> oldModel) {
		correosClp newModel = new correosClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setcorreosRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputeditores(BaseModel<?> oldModel) {
		editoresClp newModel = new editoresClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.seteditoresRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputplanificacion(BaseModel<?> oldModel) {
		planificacionClp newModel = new planificacionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setplanificacionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputpublicaciones(BaseModel<?> oldModel) {
		publicacionesClp newModel = new publicacionesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setpublicacionesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputusuario_data(BaseModel<?> oldModel) {
		usuario_dataClp newModel = new usuario_dataClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setusuario_dataRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}
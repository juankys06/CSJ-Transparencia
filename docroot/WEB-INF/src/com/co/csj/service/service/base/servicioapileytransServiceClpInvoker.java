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

import com.co.csj.service.service.servicioapileytransServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class servicioapileytransServiceClpInvoker {
	public servicioapileytransServiceClpInvoker() {
		_methodName42 = "getBeanIdentifier";

		_methodParameterTypes42 = new String[] {  };

		_methodName43 = "setBeanIdentifier";

		_methodParameterTypes43 = new String[] { "java.lang.String" };

		_methodName46 = "getDepartamentos";

		_methodParameterTypes46 = new String[] {  };

		_methodName47 = "getMunicipios";

		_methodParameterTypes47 = new String[] { "java.lang.String" };

		_methodName48 = "getEntidadDepartamento";

		_methodParameterTypes48 = new String[] { "java.lang.String" };

		_methodName49 = "getDespachosFiltro";

		_methodParameterTypes49 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName50 = "getFuncionariosDespacho";

		_methodParameterTypes50 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName51 = "getAnhios";

		_methodParameterTypes51 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return servicioapileytransServiceUtil.getBeanIdentifier();
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			servicioapileytransServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return servicioapileytransServiceUtil.getDepartamentos();
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			return servicioapileytransServiceUtil.getMunicipios((java.lang.String)arguments[0]);
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return servicioapileytransServiceUtil.getEntidadDepartamento((java.lang.String)arguments[0]);
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			return servicioapileytransServiceUtil.getDespachosFiltro((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4]);
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return servicioapileytransServiceUtil.getFuncionariosDespacho((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			return servicioapileytransServiceUtil.getAnhios();
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
}
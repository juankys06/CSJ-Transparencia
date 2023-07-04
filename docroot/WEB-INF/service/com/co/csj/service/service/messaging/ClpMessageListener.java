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

package com.co.csj.service.service.messaging;

import com.co.csj.service.service.ClpSerializer;
import com.co.csj.service.service.auditoriaLocalServiceUtil;
import com.co.csj.service.service.correosLocalServiceUtil;
import com.co.csj.service.service.editoresLocalServiceUtil;
import com.co.csj.service.service.planificacionLocalServiceUtil;
import com.co.csj.service.service.publicacionesLocalServiceUtil;
import com.co.csj.service.service.servicioapileytransServiceUtil;
import com.co.csj.service.service.usuario_dataLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			auditoriaLocalServiceUtil.clearService();

			correosLocalServiceUtil.clearService();

			editoresLocalServiceUtil.clearService();

			planificacionLocalServiceUtil.clearService();

			publicacionesLocalServiceUtil.clearService();

			servicioapileytransServiceUtil.clearService();
			usuario_dataLocalServiceUtil.clearService();
		}
	}
}
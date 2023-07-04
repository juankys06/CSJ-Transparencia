package com.co.csj.administracion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Workbook;

import com.co.csj.registro.consultas;
import com.co.csj.registro.modeloBasico;
import com.co.csj.service.model.auditoria;
import com.co.csj.service.model.correos;
import com.co.csj.service.model.editores;
import com.co.csj.service.model.planificacion;
import com.co.csj.service.model.publicaciones;
import com.co.csj.service.service.auditoriaLocalServiceUtil;
import com.co.csj.service.service.correosLocalServiceUtil;
import com.co.csj.service.service.editoresLocalServiceUtil;
import com.co.csj.service.service.planificacionLocalServiceUtil;
import com.co.csj.service.service.publicacionesLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Administracion
 */
public class Administracion extends MVCPortlet {
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,PortletException  {
        HttpServletRequest request = PortalUtil.getOriginalServletRequest((HttpServletRequest)PortalUtil.getHttpServletRequest((PortletRequest)resourceRequest));
        HttpServletResponse response = PortalUtil.getHttpServletResponse((PortletResponse)resourceResponse);
        String cmd = ParamUtil.getString((PortletRequest)resourceRequest, (String)"pagina");
        
        if (cmd.equals("obtenerArchivo")) {
        	long id = ParamUtil.getLong(resourceRequest, "id");
        	String archivo_solicitado = ParamUtil.getString(resourceRequest, "archivo_solicitado");
        	try {
				publicaciones p = publicacionesLocalServiceUtil.getpublicaciones(id);
				
	        	String ruta = "";
	        	
	        	if(archivo_solicitado.equalsIgnoreCase("hoja_vida"))
	        		ruta = p.getArchivo_hoja_vida();
	        	if(archivo_solicitado.equalsIgnoreCase("declaracion_renta"))
	        		ruta = p.getArchivo_declaracion_renta();
	        	if(archivo_solicitado.equalsIgnoreCase("formulario_bienes"))
	        		ruta = p.getArchivo_formulario_bienes();
	        	
				resourceResponse.setContentType("application/pdf");
				OutputStream out = resourceResponse.getPortletOutputStream();
				InputStream in = new FileInputStream(new File(ruta));
				IOUtils.copy(in, out);
				HttpServletResponse res = PortalUtil.getHttpServletResponse(resourceResponse);
				if(archivo_solicitado.equalsIgnoreCase("hoja_vida"))
					res.setHeader("Content-disposition","attachment; filename=hoja_vida.pdf");
	        	if(archivo_solicitado.equalsIgnoreCase("declaracion_renta"))
	        		res.setHeader("Content-disposition","attachment; filename=declaracion_renta.pdf");
	        	if(archivo_solicitado.equalsIgnoreCase("formulario_bienes"))
	        		res.setHeader("Content-disposition","attachment; filename=formulario_bienes.pdf");
				out.flush();
				in.close();
				out.close();
			} catch (PortalException | SystemException e) {}
        }
        if (cmd.equals("descargarArchivo")) {
        	String archivo_solicitado = ParamUtil.getString(resourceRequest, "archivo_solicitado");
        	String ruta = ParamUtil.getString(resourceRequest, "ruta");
        	resourceResponse.setContentType("application/pdf");
			OutputStream out = resourceResponse.getPortletOutputStream();
			InputStream in = new FileInputStream(new File(ruta));
			IOUtils.copy(in, out);
			HttpServletResponse res = PortalUtil.getHttpServletResponse(resourceResponse);
			if(archivo_solicitado.equalsIgnoreCase("hoja_vida"))
				res.setHeader("Content-disposition","attachment; filename=hoja_vida.pdf");
			if(archivo_solicitado.equalsIgnoreCase("declaracion_renta"))
				res.setHeader("Content-disposition","attachment; filename=declaracion_renta.pdf");
			if(archivo_solicitado.equalsIgnoreCase("formulario_bienes"))
				res.setHeader("Content-disposition","attachment; filename=formulario_bienes.pdf");
			out.flush();
			in.close();
			out.close();
        }
        if (cmd.equals("fitroMuni")) {
            int tipo_sol = ParamUtil.getInteger((HttpServletRequest)request, (String)"tipo_sol");
            if (tipo_sol == 1) {
                String departamento = ParamUtil.getString((HttpServletRequest)request, (String)"departamento");
                List<modeloBasico> despacho = consultas.getMunicipiosR(departamento);
                JSONArray arra2 = JSONFactoryUtil.createJSONArray();
                for (modeloBasico d : despacho) {
                    JSONObject json = JSONFactoryUtil.createJSONObject();
                    json.put("id", d.getCodigo());
                    json.put("nombre", d.getNombre());
                    arra2.put(json);
                }
                try {
					response.getWriter().println(arra2.toString());
				} catch (IOException e) {}
            }
        }
        if (cmd.equals("1")) {
            if (resourceRequest.getPortletSession().getAttribute("resultadoRDSF") != null) {
            	Workbook wb;
                FileOutputStream fichero;
                HttpServletResponse res;
                FileInputStream in;
                OutputStream out;
                JSONObject reporteDSF = (JSONObject)resourceRequest.getPortletSession().getAttribute("resultadoRDSF");
//                fichero = new FileOutputStream("C:\\ley_transparencia\\reporteDespachosSinFuncionarios.xls");
                fichero = new FileOutputStream("//csjportalrep01/portal_repository/ley-transparencia/reporteDespachosSinFuncionarios.xls");
//                fichero = new FileOutputStream("//172.28.146.22/h/portal_repository_pruebas/ley-transparencia/reporteDespachosSinFuncionarios.xls");
                wb = ExporterUtil.INSTANCE.exportReporteDespachosSinFuncionarios(reporteDSF);
                wb.write((OutputStream)fichero);
                resourceResponse.setContentType("application/vnd.ms-excel");
                res = PortalUtil.getHttpServletResponse((PortletResponse)resourceResponse);
                res.setHeader("Content-Disposition", "attachment; filename=reporteDespachosSinFuncionarios.xls");
                out = resourceResponse.getPortletOutputStream();
//                in = new FileInputStream(new File("C:\\ley_transparencia\\reporteDespachosSinFuncionarios.xls"));
                in = new FileInputStream(new File("//csjportalrep01/portal_repository/ley-transparencia/reporteDespachosSinFuncionarios.xls"));
//                in = new FileInputStream(new File("//172.28.146.22/h/portal_repository_pruebas/ley-transparencia/reporteDespachosSinFuncionarios.xls"));
                IOUtils.copy((InputStream)in, (OutputStream)out);
                out.flush();
                ((InputStream)in).close();
                out.close();
            } else {
                System.out.println("no hay reportes a imprimir");
            }
        }
        if (cmd.equals("2")) {
            if (resourceRequest.getPortletSession().getAttribute("resultadoRPA") != null) {
            	Workbook wb;
                FileOutputStream fichero;
                HttpServletResponse res;
                FileInputStream in;
                OutputStream out;
                JSONObject reportePA = (JSONObject)resourceRequest.getPortletSession().getAttribute("resultadoRPA");
//                fichero = new FileOutputStream("C:\\ley_transparencia\\reportePublicaciones.xls");
                fichero = new FileOutputStream("//csjportalrep01/portal_repository/ley-transparencia/reportePublicaciones.xls");
//                fichero = new FileOutputStream("//172.28.146.22/h/portal_repository_pruebas/ley-transparencia/reportePublicaciones.xls");
                wb = ExporterUtil.INSTANCE.exportReportePublicaciones(reportePA);
                wb.write((OutputStream)fichero);
                resourceResponse.setContentType("application/vnd.ms-excel");
                res = PortalUtil.getHttpServletResponse((PortletResponse)resourceResponse);
                res.setHeader("Content-Disposition", "attachment; filename=reportePublicaciones.xls");
                out = resourceResponse.getPortletOutputStream();
//                in = new FileInputStream(new File("C:\\ley_transparencia\\reportePublicaciones.xls"));
                in = new FileInputStream(new File("//csjportalrep01/portal_repository/ley-transparencia/reportePublicaciones.xls"));
//                in = new FileInputStream(new File("//172.28.146.22/h/portal_repository_pruebas/ley-transparencia/reportePublicaciones.xls"));
                IOUtils.copy((InputStream)in, (OutputStream)out);
                out.flush();
                ((InputStream)in).close();
                out.close();
            } else {
                System.out.println("no hay reportes a imprimir");
            }
        }
        
        if (cmd.equals("despachoAsignado")) {
            int tipo_sol = ParamUtil.getInteger((HttpServletRequest)request, (String)"tipo_sol");
            if (tipo_sol == 1) {
                String municipio = ParamUtil.getString((HttpServletRequest)request, (String)"municipio");
                String entidad = ParamUtil.getString((HttpServletRequest)request, (String)"entidad");
                String especialidad = ParamUtil.getString((HttpServletRequest)request, (String)"especialidad");
                List<modeloBasico> despacho = consultas.getDespachos(municipio, entidad, especialidad);
                JSONArray arra2 = JSONFactoryUtil.createJSONArray();
                for (modeloBasico d : despacho) {
                    JSONObject json = JSONFactoryUtil.createJSONObject();
                    json.put("id", d.getCodigo());
                    json.put("nombre", d.getNombre());
                    arra2.put(json);
                }
                try {
					response.getWriter().println(arra2.toString());
				} catch (IOException e) {}
            }
            if (tipo_sol == 2) {
                String departamento = ParamUtil.getString((HttpServletRequest)request, (String)"departamento");
                List<modeloBasico> despacho = consultas.getMunicipios(departamento);
                JSONArray arra2 = JSONFactoryUtil.createJSONArray();
                for (modeloBasico d : despacho) {
                    JSONObject json = JSONFactoryUtil.createJSONObject();
                    json.put("id", d.getCodigo());
                    json.put("nombre", d.getNombre());
                    arra2.put(json);
                }
                try {
					response.getWriter().println(arra2.toString());
				} catch (IOException e) {}
            }
        }
	}
	
	public void aprobarSolicitud(ActionRequest actionRequest, ActionResponse actionResponse){
		long id = ParamUtil.getLong(actionRequest, "id");
		
		try {
			planificacion ano = planificacionLocalServiceUtil.PorEstado("ACTIVO");
			
			publicaciones solicitud = publicacionesLocalServiceUtil.getpublicaciones(id);
			
			publicaciones solicitudAnterior = publicacionesLocalServiceUtil.getPorEstadoUsuario(solicitud.getFk_usuario(), ano.getAnhio(), "APROBADO");
			
			if(solicitudAnterior!=null){
				solicitudAnterior.setEstatus("MODIFICADO");
				publicacionesLocalServiceUtil.updatepublicaciones(solicitudAnterior);
			}
			
			solicitud.setAprobado_por(actionRequest.getRemoteUser());
			solicitud.setFecha_publicacion(new Date());
			solicitud.setEstatus("APROBADO");
			publicacionesLocalServiceUtil.updatepublicaciones(solicitud);
			SessionMessages.add(actionRequest, "solicitudAprobada");
			actionResponse.setRenderParameter("mvcPath", "/html/administracion/solicitudes.jsp");
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, "errorAprobando");
			actionResponse.setRenderParameter("mvcPath", "/html/administracion/solicitudes.jsp");
		}
	}

	public void irDenegarSolicitud(ActionRequest actionRequest, ActionResponse actionResponse){
		String id = ParamUtil.getString(actionRequest, "id");

		actionRequest.setAttribute("id", id);
		SessionMessages.add(actionRequest, "noMensaje");
		actionResponse.setRenderParameter("mvcPath", "/html/administracion/denegarSolicitud.jsp");
	}
	
	public void denegarSolicitud(ActionRequest actionRequest, ActionResponse actionResponse){
		long id = ParamUtil.getLong(actionRequest, "id");
		String causa = ParamUtil.getString(actionRequest, "causa");
		
		try {
			publicaciones solicitud = publicacionesLocalServiceUtil.getpublicaciones(id);
			solicitud.setNegado_por(actionRequest.getRemoteUser());
			solicitud.setFecha_negado(new Date());
			solicitud.setEstatus("NEGADA");
			solicitud.setCausa_negado(causa);
			publicacionesLocalServiceUtil.updatepublicaciones(solicitud);
			SessionMessages.add(actionRequest, "solicitudNegada");
			actionResponse.setRenderParameter("mvcPath", "/html/administracion/solicitudesPendientes.jsp");
		} catch (PortalException | SystemException e) {
			SessionErrors.add(actionRequest, "errorNegando");
			actionResponse.setRenderParameter("mvcPath", "/html/administracion/solicitudesPendientes.jsp");
		}
	}

	public void siguienteAno(ActionRequest actionRequest, ActionResponse actionResponse){
		try {
			long userid = Long.parseLong(actionRequest.getRemoteUser());
			User us = UserLocalServiceUtil.getUser(userid);
			
			auditoria audi = auditoriaLocalServiceUtil.createauditoria(0L);
			audi.setAccion("Modificación");
			audi.setCampo_modifico("Año de Vigencia");
			audi.setFecha(new Date());
			audi.setModificado_por(us.getEmailAddress());
			
			planificacion anoVigencia = planificacionLocalServiceUtil.PorEstado("ACTIVO");
			
			planificacion nuevoAnoVigencia = planificacionLocalServiceUtil.createplanificacion(0L);
			nuevoAnoVigencia.setAnhio(anoVigencia.getAnhio()+1);
			nuevoAnoVigencia.setFecha_inicio(new Date());
			nuevoAnoVigencia.setEstado("ACTIVO");
			
			anoVigencia.setFecha_fin(new Date());
			anoVigencia.setEstado("INACTIVO");
			anoVigencia.setUsuario_finalizo(actionRequest.getRemoteUser());
			
			audi.setLog_anterior(String.valueOf(anoVigencia.getAnhio()));
			audi.setLog_nuevo(String.valueOf(nuevoAnoVigencia.getAnhio()));
			
			planificacionLocalServiceUtil.updateplanificacion(anoVigencia);
			planificacionLocalServiceUtil.addplanificacion(nuevoAnoVigencia);
			auditoriaLocalServiceUtil.addauditoria(audi);
			
			
			SessionMessages.add(actionRequest, "okPlanificacion");
			actionResponse.setRenderParameter("mvcPath", "/html/administracion/anoVigencia.jsp");
			
		} catch (SystemException | PortalException e) {
			SessionErrors.add(actionRequest, "errorPlanificacion");
			actionResponse.setRenderParameter("mvcPath", "/html/administracion/anoVigencia.jsp");
		}
	}
	
	public void buscarAuditoria(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException, ParseException{
		String accion = ParamUtil.getString(actionRequest, "accion");
		String campo = ParamUtil.getString(actionRequest, "campo");
		String fechaI = ParamUtil.getString(actionRequest, "fechaI");
		String fechaF = ParamUtil.getString(actionRequest, "fechaF");
		String cedula = ParamUtil.getString(actionRequest, "cedula");
		String ano = ParamUtil.getString(actionRequest, "ano");
		
		List<auditoria> audi = consultas.getAuditoria(accion, campo, fechaI, fechaF, cedula, ano);
		
		actionRequest.getPortletSession().setAttribute("auditoria", audi);
		actionResponse.setRenderParameter("mvcPath", "/html/administracion/auditoria.jsp");
		
	}
	
	public void irDetalle(ActionRequest actionRequest, ActionResponse actionResponse){
		String id = ParamUtil.getString(actionRequest, "id");
		
		actionRequest.setAttribute("id", id);
		SessionMessages.add(actionRequest, "no");
		actionResponse.setRenderParameter("mvcPath", "/html/administracion/detalle.jsp");
		
	}
	
	public void generarReporteDSF(ActionRequest actionRequest, ActionResponse actionResponse){
		String departamento = ParamUtil.getString(actionRequest, "departamento");
		String municipio = ParamUtil.getString(actionRequest, "municipio");
		String entidad = ParamUtil.getString(actionRequest, "entidad");
		String especialidad = ParamUtil.getString(actionRequest, "especialidad");
		String ano = ParamUtil.getString(actionRequest, "ano");
		
		try {
			JSONObject reporteDSF = consultas.getReporteDespachos(departamento, municipio, entidad, especialidad, ano);
			actionRequest.getPortletSession().setAttribute("resultadoRDSF", reporteDSF);
			SessionMessages.add(actionRequest, "genero");
			actionResponse.setRenderParameter("mvcPath", "/html/administracion/reporteDespachoSF.jsp");
		} catch (PortalException | SystemException | ParseException e) {
			SessionErrors.add(actionRequest, "noGenero");
			actionResponse.setRenderParameter("mvcPath", "/html/administracion/reporteDespachoSF.jsp");
		}
		
		
	}
	
	public void generarReportePA(ActionRequest actionRequest, ActionResponse actionResponse){
		String departamento = ParamUtil.getString(actionRequest, "departamento");
		String municipio = ParamUtil.getString(actionRequest, "municipio");
		String entidad = ParamUtil.getString(actionRequest, "entidad");
		String especialidad = ParamUtil.getString(actionRequest, "especialidad");
		String ano = ParamUtil.getString(actionRequest, "ano");
		
		try {
			JSONObject reportePA = consultas.getReportePublicados(departamento, municipio, entidad, especialidad, ano);
			actionRequest.getPortletSession().setAttribute("resultadoRPA", reportePA);
			SessionMessages.add(actionRequest, "genero");
			actionResponse.setRenderParameter("mvcPath", "/html/administracion/reportePublicaciones.jsp");
		} catch (PortalException | SystemException | ParseException e) {
			SessionErrors.add(actionRequest, "noGenero");
			actionResponse.setRenderParameter("mvcPath", "/html/administracion/reportePublicaciones.jsp");
		}
		
		
	}
	
	public void buscarFuncionario(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException, ParseException{
		String correo = ParamUtil.getString(actionRequest, "correo");
		String cedula = ParamUtil.getString(actionRequest, "cedula");
				
		actionRequest.getPortletSession().setAttribute("correo", correo);
		actionRequest.getPortletSession().setAttribute("cedula", cedula);
		actionResponse.setRenderParameter("mvcPath", "/html/administracion/funcionarios.jsp");
		
	}
	
	public void buscarFuncionarioR(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException, ParseException{
		String correo = ParamUtil.getString(actionRequest, "correo");
		String cedula = ParamUtil.getString(actionRequest, "cedula");
		String nombres = ParamUtil.getString(actionRequest, "nombres");
				
		actionRequest.getPortletSession().setAttribute("correoR", correo);
		actionRequest.getPortletSession().setAttribute("cedulaR", cedula);
		actionRequest.getPortletSession().setAttribute("nombresR", nombres);
		actionResponse.setRenderParameter("mvcPath", "/html/administracion/funcionariosRegistrados.jsp");
		
	}
	
	public void irModificarFuncionario(ActionRequest actionRequest, ActionResponse actionResponse){
		String id = ParamUtil.getString(actionRequest, "id");
		
		actionRequest.setAttribute("id", id);
		SessionMessages.add(actionRequest, "no");
		actionResponse.setRenderParameter("mvcPath", "/html/administracion/nuevoFuncionario.jsp");
		
	}
	
	public void irModificarFuncionarioR(ActionRequest actionRequest, ActionResponse actionResponse){
		String id = ParamUtil.getString(actionRequest, "id");
		
		actionRequest.setAttribute("id", id);
		SessionMessages.add(actionRequest, "no");
		actionResponse.setRenderParameter("mvcPath", "/html/administracion/editarFuncionarioR.jsp");
		
	}
	
	public void agregarFuncionario(ActionRequest actionRequest, ActionResponse actionResponse){
		String id = ParamUtil.getString(actionRequest, "id");
		String correo = ParamUtil.getString(actionRequest, "correo");
		String cedula = ParamUtil.getString(actionRequest, "cedula");
		String cargo = ParamUtil.getString(actionRequest, "cargo");
		String nombres = ParamUtil.getString(actionRequest, "nombres");
		String apellidos = ParamUtil.getString(actionRequest, "apellidos");
		String codigoDespacho = ParamUtil.getString(actionRequest, "codigoDespacho");
		
		long userid = Long.parseLong(actionRequest.getRemoteUser());
		User us = null;
		try {
			us = UserLocalServiceUtil.getUser(userid);
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
		}
		
		JSONObject logAnterior = JSONFactoryUtil.createJSONObject();
		JSONObject logNuevo = JSONFactoryUtil.createJSONObject();
		
		logNuevo.put("correo", correo);
		logNuevo.put("numero_documento", cedula);
		logNuevo.put("nombres", nombres);
		logNuevo.put("apellidos", apellidos);
		logNuevo.put("cargo", cargo);
		logNuevo.put("despacho", codigoDespacho);
		
		if(id.equals("null")){
			correos funcionario = correosLocalServiceUtil.createcorreos(0L);
			funcionario.setCuentaCorreo(correo);
			funcionario.setNombre1(nombres);
			funcionario.setApellido(apellidos);
			funcionario.setCargo(cargo);
			funcionario.setCedulaResponsable(cedula);
			funcionario.setCodigoDespacho(codigoDespacho);
			
			auditoria audi = auditoriaLocalServiceUtil.createauditoria(0L);
			audi.setAccion("Creación");
			audi.setCampo_modifico("Funcionario sin registrar");
			audi.setFecha(new Date());
			audi.setModificado_por(us.getEmailAddress());
			audi.setLog_nuevo(logNuevo.toString());
			
			try {
				correosLocalServiceUtil.addcorreos(funcionario);
				auditoriaLocalServiceUtil.addauditoria(audi);
				SessionMessages.add(actionRequest, "okCrearFuncionario");
				actionResponse.setRenderParameter("mvcPath", "/html/administracion/funcionarios.jsp");
			} catch (SystemException e) {
				e.printStackTrace();
				SessionErrors.add(actionRequest, "errorCrearFuncionario");
				actionResponse.setRenderParameter("mvcPath", "/html/administracion/funcionarios.jsp");
			}
			
			
		}else{
			try {
				correos funcionario = correosLocalServiceUtil.getcorreos(Long.parseLong(id));
				
				logAnterior.put("correo", funcionario.getCuentaCorreo());
				logAnterior.put("numero_documento", funcionario.getCedulaResponsable());
				logAnterior.put("nombres", funcionario.getNombre1());
				logAnterior.put("apellidos", funcionario.getApellido());
				logAnterior.put("cargo", funcionario.getCargo());
				logAnterior.put("despacho", funcionario.getCodigoDespacho());
				
				funcionario.setCuentaCorreo(correo);
				funcionario.setNombre1(nombres);
				funcionario.setApellido(apellidos);
				funcionario.setCargo(cargo);
				funcionario.setCedulaResponsable(cedula);
				funcionario.setCodigoDespacho(codigoDespacho);
				
				auditoria audi = auditoriaLocalServiceUtil.createauditoria(0L);
				audi.setAccion("Modificación");
				audi.setCampo_modifico("Funcionario sin registrar");
				audi.setFecha(new Date());
				audi.setModificado_por(us.getEmailAddress());
				audi.setLog_nuevo(logNuevo.toString());
				audi.setLog_anterior(logAnterior.toString());
				
				
				correosLocalServiceUtil.updatecorreos(funcionario);
				auditoriaLocalServiceUtil.addauditoria(audi);
				SessionMessages.add(actionRequest, "okModificarFuncionario");
			actionResponse.setRenderParameter("mvcPath", "/html/administracion/funcionarios.jsp");
				
				
			} catch (NumberFormatException | PortalException | SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				SessionErrors.add(actionRequest, "errorModificarFuncionario");
				actionResponse.setRenderParameter("mvcPath", "/html/administracion/funcionarios.jsp");
			}
			
		}
	}

	public void editarFuncionarioR(ActionRequest actionRequest, ActionResponse actionResponse){
		String id = ParamUtil.getString(actionRequest, "id");
		String codigoDespacho = ParamUtil.getString(actionRequest, "codigoDespacho");
//		long userid = Long.parseLong(actionRequest.getRemoteUser());
//		User us = null;
//		try {
//			us = UserLocalServiceUtil.getUser(userid);
//		} catch (PortalException | SystemException e) {
//			e.printStackTrace();
//		}
//		
//		JSONObject logAnterior = JSONFactoryUtil.createJSONObject();
//		JSONObject logNuevo = JSONFactoryUtil.createJSONObject();
		
//		logNuevo.put("correo", correo);
//		logNuevo.put("numero_documento", cedula);
//		logNuevo.put("nombres", nombres);
//		logNuevo.put("apellidos", apellidos);
//		logNuevo.put("cargo", cargo);
//		logNuevo.put("despacho", codigoDespacho);

		try {
			editores funcionario = editoresLocalServiceUtil.geteditores(Long.parseLong(id));
			
			consultas.actualizarDespacho(funcionario.getNumero_documento_edita(), codigoDespacho);
			
//			logAnterior.put("correo", funcionario.getCuentaCorreo());
//			logAnterior.put("numero_documento", funcionario.getCedulaResponsable());
//			logAnterior.put("nombres", funcionario.getNombre1());
//			logAnterior.put("apellidos", funcionario.getApellido());
//			logAnterior.put("cargo", funcionario.getCargo());
//			logAnterior.put("despacho", funcionario.getCodigoDespacho());
			
//			funcionario.setCuentaCorreo(correo);
//			funcionario.setNombre1(nombres);
//			funcionario.setApellido(apellidos);
//			funcionario.setCargo(cargo);
//			funcionario.setCedulaResponsable(cedula);
//			funcionario.setCodigoDespacho(codigoDespacho);
			
//			auditoria audi = auditoriaLocalServiceUtil.createauditoria(0L);
//			audi.setAccion("Modificación");
//			audi.setCampo_modifico("Funcionario sin registrar");
//			audi.setFecha(new Date());
//			audi.setModificado_por(us.getEmailAddress());
//			audi.setLog_nuevo(logNuevo.toString());
//			audi.setLog_anterior(logAnterior.toString());
			
			
//			correosLocalServiceUtil.updatecorreos(funcionario);
//			auditoriaLocalServiceUtil.addauditoria(audi);
			SessionMessages.add(actionRequest, "okModificarFuncionarioR");
			actionResponse.setRenderParameter("mvcPath", "/html/administracion/funcionariosRegistrados.jsp");
			
			
		} catch (NumberFormatException | PortalException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			SessionErrors.add(actionRequest, "errorModificarFuncionarioR");
			actionResponse.setRenderParameter("mvcPath", "/html/administracion/funcionariosRegistrados.jsp");
		}
			
		
	}
	
	public void editarUsuarioFuncionarioR(ActionRequest actionRequest, ActionResponse actionResponse){
		String id = ParamUtil.getString(actionRequest, "id");
		String userId = ParamUtil.getString(actionRequest, "userId");
		
		long userid = Long.parseLong(userId);
		User us = null;
		try {
			us = UserLocalServiceUtil.getUser(userid);
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
		}

		try {
			editores funcionario = editoresLocalServiceUtil.geteditores(Long.parseLong(id));
			
			funcionario.setCorreo(us.getEmailAddress());
			funcionario.setUserid( String.valueOf(us.getUserId()) );
			
			editoresLocalServiceUtil.updateeditores(funcionario);
			
			SessionMessages.add(actionRequest, "okModificarFuncionarioR");
			actionResponse.setRenderParameter("mvcPath", "/html/administracion/funcionariosRegistrados.jsp");
			
			
		} catch (NumberFormatException | PortalException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			SessionErrors.add(actionRequest, "errorModificarFuncionarioR");
			actionResponse.setRenderParameter("mvcPath", "/html/administracion/funcionariosRegistrados.jsp");
		}
			
		
	}
	
}

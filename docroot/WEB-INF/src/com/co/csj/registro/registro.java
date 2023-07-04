package com.co.csj.registro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.net.ssl.SSLContext;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.portlet.PortletFileUpload;
import org.apache.commons.io.IOUtils;

import com.co.csj.registro.ConfiguracionCorreo;
import com.co.csj.service.NoSucheditoresException;
import com.co.csj.service.model.auditoria;
import com.co.csj.service.model.correos;
import com.co.csj.service.model.editores;
import com.co.csj.service.model.planificacion;
import com.co.csj.service.model.planificacionClp;
import com.co.csj.service.model.publicaciones;
import com.co.csj.service.model.usuario_data;
import com.co.csj.service.service.auditoriaLocalServiceUtil;
import com.co.csj.service.service.correosLocalServiceUtil;
import com.co.csj.service.service.editoresLocalServiceUtil;
import com.co.csj.service.service.planificacionLocalServiceUtil;
import com.co.csj.service.service.publicacionesLocalServiceUtil;
import com.co.csj.service.service.usuario_dataLocalServiceUtil;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;



public class registro extends MVCPortlet {
	
	private static String DATA_SOURCE_APPSPORTAL = "java:comp/env/jdbc/base_datos_csj";
	
	SimpleDateFormat formatoNombreArchivos = new SimpleDateFormat("yyyyMMddhhmmss");
	
	validaciones validar = new validaciones();
	
	public void registrarUsuario(ActionRequest actionRequest, ActionResponse actionResponse){
		
		ConfiguracionCorreo correo = new ConfiguracionCorreo();
		String SQL = "select * from Envio_correos_cuenta_configuracion where id = 1";
		
		Context ct = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try {
			ct = new InitialContext();
			ds = (DataSource) ct.lookup(DATA_SOURCE_APPSPORTAL);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(SQL);
            if (result != null) {
                while (result.next()) {
                    correo =  new ConfiguracionCorreo(result.getString(2), result.getString(3), result.getString(4), result.getString(5));
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY-TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_APPSPORTAL+" Exeption:" + ex.getMessage() +" SQL: "+SQL);
        } catch (NamingException e) {
        	System.out.println(">>>LEY-TRANSPARENCIA<<<<Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_APPSPORTAL);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}
		
		ServiceContext serviceContext = null;
		try {
			serviceContext = ServiceContextFactory.getInstance (Group.class.getName (), actionRequest);
		} catch (PortalException | SystemException e) {}
		
		String correoR = ParamUtil.getString(actionRequest, "correo");
		String numeroDocumento = ParamUtil.getString(actionRequest, "numeroDocumento");
		String tipoDocumento = ParamUtil.getString(actionRequest, "tipoDocumento");
		
		Properties props = new Properties();
		// Nombre del host de correo, es smtp.gmail.com
		props.setProperty("mail.smtp.host", correo.getHost());
		// TLS si está disponible
		props.setProperty("mail.smtp.starttls.enable", "true");
		// Puerto de gmail para envio de correos
		props.setProperty("mail.smtp.port",correo.getPuerto());
		// Nombre del usuario
		props.setProperty("mail.smtp.user", correo.getCorreo());
		// Si requiere o no usuario y password para conectarse.
		props.setProperty("mail.smtp.auth", "true");
		
		try {
	        SSLContext ctx = SSLContext.getInstance("TLSv1.2");
	        ctx.init(null, null, null);
	        SSLContext.setDefault(ctx);
		} catch (Exception e) {
		        System.out.println(e.getMessage());
		}
		
		Session session = Session.getDefaultInstance(props);

		try {
			editoresLocalServiceUtil.getPorCorreo(correoR);
			SessionErrors.add(actionRequest, "yaRegistrado");
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/registrar.jsp");
		} catch (NoSucheditoresException | SystemException e) {
			
			try {
				System.out.println(">T1");
				correos validarDatos = correosLocalServiceUtil.PorCorreo(correoR);
				System.out.println(">T2");
				System.out.println(validarDatos.getCedulaResponsable());
				if(validarDatos.getCedulaResponsable().equals(numeroDocumento)){
//				if(true){
					editores editorNuevo = editoresLocalServiceUtil.createeditores(0L);
					editorNuevo.setCorreo(correoR);
//					editorNuevo.setCodigo(codigo);
					editorNuevo.setFecha_creado(new Date());
					editorNuevo.setApellidos_edita(validarDatos.getApellido());
					editorNuevo.setNombres_edita(validarDatos.getNombre1());
					editorNuevo.setNumero_documento_edita(numeroDocumento);
					editorNuevo.setCargo_edita(validarDatos.getCargo());
					editorNuevo.setTipo_documento_edita(tipoDocumento);
					editorNuevo.setDespacho_edita(validarDatos.getCodigoDespacho());
					
					User usuario = null;
					
					String clave = validaciones.generarClave();
					
					try {
						usuario = UserLocalServiceUtil.getUserByEmailAddress(serviceContext.getCompanyId(), correoR);
						System.out.println(">U1");
					} catch (PortalException | SystemException e1) {
						
						System.out.println(">>>>>>>>>>>>>>>>>>>>TRANSPARENCIA<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
						System.out.println(">U2");
						e1.printStackTrace();
						System.out.println(e1.getMessage());
						System.out.println(">>>>>>>>>>>>>>>>>>>>TRANSPARENCIA<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
						
					}
					
					MimeMessage mensaje = new MimeMessage(session);
//					MailMessage mensaje = new MailMessage();
					
					Role rol = RoleLocalServiceUtil.getRole(serviceContext.getCompanyId(), "ley de transparencia");
					long []id = {rol.getRoleId()};
						
					if(usuario!=null){						
						
						try {
							mensaje.setFrom(new InternetAddress(correo.getCorreo(), "Soporte Pagina Web"));
							mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoR));
							String cuerpoMensaje = 	"Señor(a) <br><br>"+
									"Se le han otorgado permisos a su usuario del portal <strong>"+correoR+"</strong><br>"+
									"Estos le permitirán el ingreso al aplicativo del formulario público de ley de transparencia<br><br>"+
									"Cordialmente<br/>"+
					    		    "<strong>Soporte Portal Web Rama Judicial</strong><br/>"+
					    		    "<strong>Centro de Documentación Judicial CENDOJ</strong><br/>"+
					    		    "<strong>"+correo.getCorreo()+"</strong><br/>"+
					    		    "<strong>+57 5658500 ext. 7566-7568</strong>";
							
							mensaje.setSubject("Usuario Formulario Publico Ley de Transparencia");
							mensaje.setText(cuerpoMensaje,"ISO-8859-1","html");
							Transport t = session.getTransport("smtp");
							t.connect(correo.getCorreo(), correo.getClave());
							t.sendMessage(mensaje, mensaje.getAllRecipients());
							t.close();
	//						mensaje.setBody(cuerpoMensaje);
	//						mensaje.setHTMLFormat(true);
	//						MailServiceUtil.sendEmail(mensaje);
							
							auditoria audi = auditoriaLocalServiceUtil.createauditoria(0L);
							audi.setFecha(new Date());
							audi.setAccion("Registro de Correo Electrónico");
							audi.setLog_anterior(correoR);
							
							RoleLocalServiceUtil.addUserRoles(usuario.getUserId(), id);
							usuario.setStatus(0);
							UserLocalServiceUtil.updateUser(usuario);
							editorNuevo.setUserid(String.valueOf(usuario.getUserId()));
							
							editoresLocalServiceUtil.addeditores(editorNuevo);
							auditoriaLocalServiceUtil.addauditoria(audi);
							
							SessionMessages.add(actionRequest, "registro");
							actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
							
						} catch (UnsupportedEncodingException | SystemException | MessagingException e1) {
							System.out.println(">>>>>>>>>>>>>>>>>>>>TRANSPARENCIA<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
							e1.printStackTrace();
							System.out.println(e1.getMessage());
							System.out.println(">>>>>>>>>>>>>>>>>>>>TRANSPARENCIA<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
							SessionErrors.add(actionRequest, "noRegistro");
							actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
						}
					}else{

						try {
							mensaje.setFrom(new InternetAddress(correo.getCorreo(), "Soporte Pagina Web"));
							mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoR));
							String cuerpoMensaje = 	"Señor(a) <br><br>"+
									"Se le han creado un usuario en el portal web <a href='https://www.ramajudicial.gov.co'>www.ramajudicial.gov.co</a> con los siguientes datos:<br><br>"+
									"<strong>Correo:</strong> "+correoR+"<br>"+
									"<strong>Clave:</strong> "+clave+"<br><br>"+
									"Este le permitirá el ingreso al aplicativo del formulario público de ley de transparencia<br><br>"+
									"Cordialmente<br/>"+
					    		    "<strong>Soporte Portal Web Rama Judicial</strong><br/>"+
					    		    "<strong>Centro de Documentación Judicial CENDOJ</strong><br/>"+
					    		    "<strong>"+correo.getCorreo()+"</strong><br/>"+
					    		    "<strong>+57 5658500 ext. 7566-7568</strong>";
							
							mensaje.setSubject("Usuario Formulario Publico Ley de Transparencia");
							mensaje.setText(cuerpoMensaje,"ISO-8859-1","html");
							Transport t = session.getTransport("smtp");
							t.connect(correo.getCorreo(), correo.getClave());
							t.sendMessage(mensaje, mensaje.getAllRecipients());
							t.close();
	//						mensaje.setBody(cuerpoMensaje);
	//						mensaje.setHTMLFormat(true);
	//						MailServiceUtil.sendEmail(mensaje);
							
							auditoria audi = auditoriaLocalServiceUtil.createauditoria(0L);
							audi.setFecha(new Date());
							audi.setAccion("Registro de Correo Electrónico");
							audi.setLog_anterior(correoR);
							
							consultas c = new consultas();
							
							String screen = cleanString(editorNuevo.getApellidos_edita().substring(0, 1))+editorNuevo.getNumero_documento_edita();
							
							if(c.getScreeName(screen).equals("")){
								
							}else{
								screen+=validaciones.generarletras();
							}
							
							usuario = UserLocalServiceUtil.addUser(0L, serviceContext.getCompanyId(), false,
						          clave, clave, false, screen, correoR, 0, "", serviceContext.getLocale(), editorNuevo.getNombres_edita(), "", editorNuevo.getApellidos_edita(),
						          0, 0, false, 1, 1, 1900, "", 
						          null, null, id, null, false, serviceContext);

//							RoleLocalServiceUtil.addUserRoles(usuario.getUserId(), id);

							editorNuevo.setUserid(String.valueOf(usuario.getUserId()));
							
							editoresLocalServiceUtil.addeditores(editorNuevo);
							auditoriaLocalServiceUtil.addauditoria(audi);
							
							SessionMessages.add(actionRequest, "registro");
							actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
							
						} catch (UnsupportedEncodingException | SystemException | MessagingException e1) {
							System.out.println(">>>>>>>>>>>>>>>>>>>>TRANSPARENCIA<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
							e1.printStackTrace();
							System.out.println(e1.getMessage());
							System.out.println(">>>>>>>>>>>>>>>>>>>>TRANSPARENCIA<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
							SessionErrors.add(actionRequest, "noRegistro");
							actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
						}
						
						
					}
					
					
					
				}else{
					System.out.println(">>>>>>>>>>>>>>>>>>>>TRANSPARENCIA<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
					System.out.println("no coinciden");
					System.out.println(">>>>>>>>>>>>>>>>>>>>TRANSPARENCIA<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
					
					SessionErrors.add(actionRequest, "noCoinciden");
					actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/registrar.jsp");
				}
			} catch (SystemException | PortalException e1) {
				System.out.println(">>>>>>>>>>>>>>>>>>>>TRANSPARENCIA<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				System.out.println("no registrado");
				System.out.println(e1.getMessage());
				System.out.println(">>>>>>>>>>>>>>>>>>>>TRANSPARENCIA<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				
				actionRequest.setAttribute("tipoDocumento", tipoDocumento);
				actionRequest.setAttribute("correo", correoR);
				actionRequest.setAttribute("numeroDocumento", numeroDocumento);
				SessionErrors.add(actionRequest, "noCorreo");
				actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/noRegistrado.jsp");
			}			
		} 
	}

	public void registrarUsuarioNoRegistrado(ActionRequest actionRequest, ActionResponse actionResponse){
		
		ConfiguracionCorreo correo = new ConfiguracionCorreo();
		String SQL = "select * from Envio_correos_cuenta_configuracion where id = 1";
		
		Context ct = null;
		DataSource ds = null;
		Connection conection = null;
		ResultSet result = null;
		Statement statement = null;
		try {
			ct = new InitialContext();
			ds = (DataSource) ct.lookup(DATA_SOURCE_APPSPORTAL);
			conection = ds.getConnection();
			statement = conection.createStatement();
			result = statement.executeQuery(SQL);
            if (result != null) {
                while (result.next()) {
                    correo =  new ConfiguracionCorreo(result.getString(2), result.getString(3), result.getString(4), result.getString(5));
                }
            } else {
                System.out.println("No hay  registro cargadas en la base de datos ");
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(">>>LEY-TRANSPARENCIA<<<< Error de conexion a la bd: "+DATA_SOURCE_APPSPORTAL+" Exeption:" + ex.getMessage() +" SQL: "+SQL);
        } catch (NamingException e) {
        	System.out.println(">>>LEY-TRANSPARENCIA<<<<Error obteniendo el DataSource de la conexion:"+DATA_SOURCE_APPSPORTAL);
		}finally{
			if (result != null) 
	        {
	            try { 
	            	result.close(); 
	            }catch(Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (statement != null) 
	        {
	            try { 
	            	statement.close(); 
	            }catch(Exception ex) 
	            {
	                ex.printStackTrace();
	            }
	        }
	            
	        if (conection != null) 
	        {
	            try { 
	            	conection.close(); 
	            } catch(Exception ex) {
	                ex.printStackTrace();                    
	            }
	        }
		}
		
		ServiceContext serviceContext = null;
		try {
			serviceContext = ServiceContextFactory.getInstance (Group.class.getName (), actionRequest);
		} catch (PortalException | SystemException e) {}
		
		String correoR = ParamUtil.getString(actionRequest, "correo");
		String numeroDocumento = ParamUtil.getString(actionRequest, "numeroDocumento");
		String tipoDocumento = ParamUtil.getString(actionRequest, "tipoDocumento");
		String nombres = ParamUtil.getString(actionRequest, "nombres");
		String apellidos = ParamUtil.getString(actionRequest, "apellidos");
		String cargo = ParamUtil.getString(actionRequest, "cargo");
		
		Properties props = new Properties();
		// Nombre del host de correo, es smtp.gmail.com
		props.setProperty("mail.smtp.host", correo.getHost());
		// TLS si está disponible
		props.setProperty("mail.smtp.starttls.enable", "true");
		// Puerto de gmail para envio de correos
		props.setProperty("mail.smtp.port",correo.getPuerto());
		// Nombre del usuario
		props.setProperty("mail.smtp.user", correo.getCorreo());
		// Si requiere o no usuario y password para conectarse.
		props.setProperty("mail.smtp.auth", "true");
		
		try {
	        SSLContext ctx = SSLContext.getInstance("TLSv1.2");
	        ctx.init(null, null, null);
	        SSLContext.setDefault(ctx);
		} catch (Exception e) {
		        System.out.println(e.getMessage());
		}
		
		Session session = Session.getDefaultInstance(props);
		
		
			if(!consultas.validarNumeroDocumento(numeroDocumento)){
				editores editorNuevo = editoresLocalServiceUtil.createeditores(0L);
				editorNuevo.setCorreo(correoR);
				String clave = validaciones.generarClave();
//				editorNuevo.setCodigo(codigo);
				editorNuevo.setFecha_creado(new Date());
				editorNuevo.setApellidos_edita(apellidos);
				editorNuevo.setNombres_edita(nombres);
				editorNuevo.setNumero_documento_edita(numeroDocumento);
				editorNuevo.setCargo_edita(cargo);
				editorNuevo.setTipo_documento_edita(tipoDocumento);
				
				User usuario = null;
				
				try {
					usuario = UserServiceUtil.getUserByEmailAddress(serviceContext.getCompanyId(), correoR);
				} catch (PortalException | SystemException e1) {}
				
				MimeMessage mensaje = new MimeMessage(session);
//				MailMessage mensaje = new MailMessage();
				
				
					
				if(usuario!=null){						
					
					try {
						Role rol = RoleLocalServiceUtil.getRole(serviceContext.getCompanyId(), "ley de transparencia");
						long []id = {rol.getRoleId()};
						mensaje.setFrom(new InternetAddress(correo.getCorreo(), "Soporte Pagina Web"));
						mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoR));
						String cuerpoMensaje = 	"Señor(a) <br><br>"+
								"Se le han otorgado permisos a su usuario del portal <strong>"+correoR+"</strong><br>"+
								"Estos le permitirán el ingreso al aplicativo del formulario público de ley de transparencia<br><br>"+
								"Cordialmente<br/>"+
				    		    "<strong>Soporte Portal Web Rama Judicial</strong><br/>"+
				    		    "<strong>Centro de Documentación Judicial CENDOJ</strong><br/>"+
				    		    "<strong>"+correo.getCorreo()+"</strong><br/>"+
				    		    "<strong>+57 5658500 ext. 7566-7568</strong>";
						
						mensaje.setSubject("Usuario Formulario Publico Ley de Transparencia");
						mensaje.setText(cuerpoMensaje,"ISO-8859-1","html");
						Transport t = session.getTransport("smtp");
						t.connect(correo.getCorreo(), correo.getClave());
						t.sendMessage(mensaje, mensaje.getAllRecipients());
						t.close();
//						mensaje.setBody(cuerpoMensaje);
//						mensaje.setHTMLFormat(true);
//						MailServiceUtil.sendEmail(mensaje);
						
						auditoria audi = auditoriaLocalServiceUtil.createauditoria(0L);
						audi.setFecha(new Date());
						audi.setAccion("Registro de Correo Electrónico");
						audi.setLog_anterior(correoR);
						
						RoleLocalServiceUtil.addUserRoles(usuario.getUserId(), id);
						usuario.setStatus(0);
						UserLocalServiceUtil.updateUser(usuario);
						editorNuevo.setUserid(String.valueOf(usuario.getUserId()));
						
						editoresLocalServiceUtil.addeditores(editorNuevo);
						auditoriaLocalServiceUtil.addauditoria(audi);
						
						SessionMessages.add(actionRequest, "registro");
						actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
						
					} catch (UnsupportedEncodingException | SystemException | MessagingException | PortalException e1) {
						System.out.println(">>>>>>>>>>>>>>>>>>>>TRANSPARENCIA<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
						e1.printStackTrace();
						System.out.println(e1.getMessage());
						System.out.println(">>>>>>>>>>>>>>>>>>>>TRANSPARENCIA<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
						SessionErrors.add(actionRequest, "noRegistro");
						actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
					}
				}else{

					try {
						Role rol = RoleLocalServiceUtil.getRole(serviceContext.getCompanyId(), "ley de transparencia");
						long []id = {rol.getRoleId()};
						mensaje.setFrom(new InternetAddress(correo.getCorreo(), "Soporte Pagina Web"));
						mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoR));
						String cuerpoMensaje = 	"Señor(a) <br><br>"+
								"Se le han creado un usuario en el portal web <a href='https://www.ramajudicial.gov.co'>www.ramajudicial.gov.co</a> con los siguientes datos:<br><br>"+
								"<strong>Correo:</strong> "+correoR+"<br>"+
								"<strong>Clave:</strong> "+clave+"<br><br>"+
								"Este le permitirá el ingreso al aplicativo del formulario público de ley de transparencia<br><br>"+
								"Cordialmente<br/>"+
				    		    "<strong>Soporte Portal Web Rama Judicial</strong><br/>"+
				    		    "<strong>Centro de Documentación Judicial CENDOJ</strong><br/>"+
				    		    "<strong>"+correo.getCorreo()+"</strong><br/>"+
				    		    "<strong>+57 5658500 ext. 7566-7568</strong>";
						
						mensaje.setSubject("Usuario Formulario Publico Ley de Transparencia");
						mensaje.setText(cuerpoMensaje,"ISO-8859-1","html");
						Transport t = session.getTransport("smtp");
						t.connect(correo.getCorreo(), correo.getClave());
						t.sendMessage(mensaje, mensaje.getAllRecipients());
						t.close();
//						mensaje.setBody(cuerpoMensaje);
//						mensaje.setHTMLFormat(true);
//						MailServiceUtil.sendEmail(mensaje);
						
						auditoria audi = auditoriaLocalServiceUtil.createauditoria(0L);
						audi.setFecha(new Date());
						audi.setAccion("Registro de Correo Electrónico");
						audi.setLog_anterior(correoR);
						
						consultas c = new consultas();
						
						String screen = cleanString(editorNuevo.getApellidos_edita().substring(0, 1))+editorNuevo.getNumero_documento_edita();
						
						if(c.getScreeName(screen).equals("")){
							
						}else{
							screen+=validaciones.generarletras();
						}
						
						usuario = UserLocalServiceUtil.addUser(0L, serviceContext.getCompanyId(), false,
					          clave, clave, false, screen, correoR, 0, "", serviceContext.getLocale(), editorNuevo.getNombres_edita(), "", editorNuevo.getApellidos_edita(),
					          0, 0, false, 1, 1, 1900, "", 
					          null, null, id, null, false, serviceContext);

//						RoleLocalServiceUtil.addUserRoles(usuario.getUserId(), id);

						editorNuevo.setUserid(String.valueOf(usuario.getUserId()));
						
						editoresLocalServiceUtil.addeditores(editorNuevo);
						auditoriaLocalServiceUtil.addauditoria(audi);
						
						SessionMessages.add(actionRequest, "registro");
						actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
						
					} catch (UnsupportedEncodingException | SystemException | MessagingException | PortalException e1) {
						System.out.println(">>>>>>>>>>>>>>>>>>>>TRANSPARENCIA<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
						e1.printStackTrace();
						System.out.println(e1.getMessage());
						System.out.println(">>>>>>>>>>>>>>>>>>>>TRANSPARENCIA<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
						SessionErrors.add(actionRequest, "noRegistro");
						actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
					}
					
					
				}
			}else{
				SessionErrors.add(actionRequest, "numeroDocumentoInvalido");
				actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/noRegistrado.jsp");
			}	
		}
	
	public void acceder(ActionRequest request, ActionResponse response){
		String numeroDocumento = ParamUtil.getString(request, "numeroDocumento");
		String tipoDocumento = ParamUtil.getString(request, "tipoDocumento");
		editores editor = null;
		try {
			editor = editoresLocalServiceUtil.getPorUserid(request.getRemoteUser());
		} catch (PortalException | SystemException e1) {
//			SessionErrors.add(request, "datosInvalidosUsuario");
//			response.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
		}
		if(editor==null){
			SessionErrors.add(request, "noRegistroEditor");
			response.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
		}else if(editor.getNumero_documento_edita().equals(numeroDocumento) && editor.getTipo_documento_edita().equals(tipoDocumento)){
			try {
				
				if(!validar.validarUsuario(numeroDocumento)){
					usuario_data user = usuario_dataLocalServiceUtil.createusuario_data(numeroDocumento);
					user.setTipoDocumento(tipoDocumento);
					user.setApellidos(editor.getApellidos_edita());
					user.setNombres(editor.getNombres_edita());
					user.setCargo(editor.getCargo_edita());
					if(consultas.validarDespacho(editor.getDespacho_edita()))
						user.setDespacho(editor.getDespacho_edita());
					user.setFechaRegistro(new Date());
					usuario_dataLocalServiceUtil.addusuario_data(user);
				}
//					usuario_data usuario = usuario_dataLocalServiceUtil.getusuario_data(numeroDocumento);
//					usuario.setApellidos(editor.getApellidos_edita());
//					usuario.setNombres(editor.getNombres_edita());
//					usuario.setCargo(editor.getCargo_edita());
//					usuario = usuario_dataLocalServiceUtil.updateusuario_data(usuario);
//					request.getPortletSession().setAttribute("usuarioId", usuario.getNumeroDocumento());
					editor.setUltimo_inicio(new Date());
					editoresLocalServiceUtil.updateeditores(editor);
					System.out.println("acceder >>>>>> "+editor.getCorreo());
					response.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
			        SessionMessages.add(request, "no_tiene");
				
				
			} catch (SystemException e) {}
			
		}else{
			SessionErrors.add(request, "datosInvalidos");
			response.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
		}
	}
	
	public void salir(ActionRequest actionRequest, ActionResponse actionResponse){
		actionRequest.getPortletSession().removeAttribute("usuarioId");
		actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
        SessionMessages.add(actionRequest, "no_tiene");
	}

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,PortletException  {
        HttpServletRequest request = PortalUtil.getOriginalServletRequest((HttpServletRequest)PortalUtil.getHttpServletRequest((PortletRequest)resourceRequest));
        HttpServletResponse response = PortalUtil.getHttpServletResponse((PortletResponse)resourceResponse);
        String cmd = ParamUtil.getString((PortletRequest)resourceRequest, (String)"pagina");
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
        if (cmd.equals("declaracionRenta")) {
        	String ruta = ParamUtil.getString(resourceRequest, "ruta");
			System.out.println(ruta);
			resourceResponse.setContentType("application/pdf");
			OutputStream out = resourceResponse.getPortletOutputStream();
			InputStream in = new FileInputStream(new File(ruta));
			IOUtils.copy(in, out);
			HttpServletResponse res = PortalUtil.getHttpServletResponse(resourceResponse);
			res.setHeader("Content-disposition","attachment; filename=declaracion_renta.pdf");
			out.flush();
			in.close();
			out.close();
        }
        if (cmd.equals("formularioBienes")) {
        	String ruta = ParamUtil.getString(resourceRequest, "ruta");
			System.out.println(ruta);
			resourceResponse.setContentType("application/pdf");
			OutputStream out = resourceResponse.getPortletOutputStream();
			InputStream in = new FileInputStream(new File(ruta));
			IOUtils.copy(in, out);
			HttpServletResponse res = PortalUtil.getHttpServletResponse(resourceResponse);
			res.setHeader("Content-disposition","attachment; filename=formulario_bienes.pdf");
			out.flush();
			in.close();
			out.close();
        }
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
        if (cmd.equals("verificarArchivo")) {
        	String ruta = ParamUtil.getString(resourceRequest, "ruta");
        	resourceResponse.setContentType("application/pdf");
			OutputStream out = resourceResponse.getPortletOutputStream();
			InputStream in = new FileInputStream(new File(ruta));
			IOUtils.copy(in, out);
			HttpServletResponse res = PortalUtil.getHttpServletResponse(resourceResponse);
			res.setHeader("Content-disposition","attachment; filename=hoja_vida.pdf");
			out.flush();
			in.close();
			out.close();
        }
        if (cmd.equals("municipiosNombre")) {
        	String departamento = ParamUtil.getString((HttpServletRequest)request, (String)"departamento");
            List<modeloBasico> despacho = consultas.getMunicipiosNombre(departamento);
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

	public void guardarDatosPersonales(ActionRequest actionRequest, ActionResponse actionResponse){
//		long editorId = (long) actionRequest.getPortletSession().getAttribute("editorId");
		editores editor = null;
		try {
			editor = editoresLocalServiceUtil.getPorUserid(actionRequest.getRemoteUser());
		} catch (PortalException | SystemException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
		}
		
		
		planificacion ano = new planificacionClp();
		try {
			ano = planificacionLocalServiceUtil.PorEstado("ACTIVO");
		} catch (SystemException e1) {}
		
		String sexo = ParamUtil.getString(actionRequest, "sexo");
		String nacionalidad = ParamUtil.getString(actionRequest, "nacionalidad");
		String pais = ParamUtil.getString(actionRequest, "pais");
		String tipoLibretaMilitar = ParamUtil.getString(actionRequest, "tipoLibretaMilitar");
		String numeroLibretaMilitar = ParamUtil.getString(actionRequest, "numero");
		String dmLibretaMilitar = ParamUtil.getString(actionRequest, "dm");
		String fechaNacimiento = ParamUtil.getString(actionRequest, "fechaNacimiento");
		String paisNacimiento = ParamUtil.getString(actionRequest, "paisNacimiento");
		String departamentoNacimiento = ParamUtil.getString(actionRequest, "depNacimiento");
		String municipioNacimiento = ParamUtil.getString(actionRequest, "munNacimiento");
		String direccionCorrespondencia = ParamUtil.getString(actionRequest, "direccionCorrespondencia");
		String paisCorrespondencia = ParamUtil.getString(actionRequest, "paisCorrespondencia");
		String departamentoCorrespondencia = ParamUtil.getString(actionRequest, "depCorrespondencia");
		String municipioCorrespondencia = ParamUtil.getString(actionRequest, "munCorrespondencia");
		String telefonoCorrespondencia = ParamUtil.getString(actionRequest, "telCorrespondencia");
		String emailCorrespondencia = ParamUtil.getString(actionRequest, "emailCorrespondencia");
		
		
//		String usuarioId = (String) actionRequest.getPortletSession().getAttribute("usuarioId");
		usuario_data usuario = null;
		try {
			usuario = usuario_dataLocalServiceUtil.getusuario_data(editor.getNumero_documento_edita());
		} catch (PortalException | SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		usuario.setFechaModificacion(new Date());
		
		double porcentaje = 0.0;
		
		if(!sexo.isEmpty())
			porcentaje+=3.333333333;
		if(!nacionalidad.isEmpty())
			porcentaje+=3.333333333;
		if(sexo.equals("FEMENINO"))
			porcentaje+=10;
		if(!tipoLibretaMilitar.isEmpty())
			porcentaje+=3.333333333;
		if(!numeroLibretaMilitar.isEmpty())
			porcentaje+=3.333333333;
		if(!dmLibretaMilitar.isEmpty())
			porcentaje+=3.333333333;
		if(!fechaNacimiento.isEmpty())
			porcentaje+=3.333333333;
		if(!paisNacimiento.isEmpty())
			porcentaje+=3.333333333;
		if(!departamentoNacimiento.isEmpty())
			porcentaje+=3.333333333;
		if(!municipioNacimiento.isEmpty())
			porcentaje+=3.333333333;
		if(!direccionCorrespondencia.isEmpty())
			porcentaje+=3.333333333;
		if(!paisCorrespondencia.isEmpty())
			porcentaje+=3.333333333;
		if(!departamentoCorrespondencia.isEmpty())
			porcentaje+=3.333333333;
		if(!municipioCorrespondencia.isEmpty())
			porcentaje+=3.333333333;
		if(!telefonoCorrespondencia.isEmpty())
			porcentaje+=3.333333333;
		if(!emailCorrespondencia.isEmpty())
			porcentaje+=3.333333333;
		
		JSONObject datos_personales = JSONFactoryUtil.createJSONObject();
		datos_personales.put("sexo", sexo);
		datos_personales.put("nacionalidad", nacionalidad);
		datos_personales.put("pais", pais);
		datos_personales.put("tipoLibretaMilitar", tipoLibretaMilitar);
		datos_personales.put("numeroLibretaMilitar", numeroLibretaMilitar);
		datos_personales.put("dmLibretaMilitar", dmLibretaMilitar);
		datos_personales.put("fechaNacimiento", fechaNacimiento);
		datos_personales.put("paisNacimiento", paisNacimiento);
		datos_personales.put("departamentoNacimiento", departamentoNacimiento);
		datos_personales.put("municipioNacimiento", municipioNacimiento);
		datos_personales.put("direccionCorrespondencia", direccionCorrespondencia);
		datos_personales.put("paisCorrespondencia", paisCorrespondencia);
		datos_personales.put("departamentoCorrespondencia", departamentoCorrespondencia);
		datos_personales.put("municipioCorrespondencia", municipioCorrespondencia);
		datos_personales.put("telefonoCorrespondencia", telefonoCorrespondencia);
		datos_personales.put("emailCorrespondencia", emailCorrespondencia);
		
		String anterior = usuario.getDatos_personales();
		
		auditoria audi = auditoriaLocalServiceUtil.createauditoria(0L);
		try {
			audi.setModificado_por(UserLocalServiceUtil.getUser(Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
		} catch (NumberFormatException | PortalException | SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(anterior.isEmpty()){
			audi.setAccion("Creación");
		}else{
			audi.setAccion("Modificación");
		}
		audi.setCampo_modifico("Datos Personales");
		audi.setFecha(new Date());
		audi.setAno_vigencia(ano.getAnhio());
		audi.setCedula_funcionario(usuario.getNumeroDocumento());
		audi.setLog_anterior(usuario.getDatos_personales());
		audi.setLog_nuevo(datos_personales.toString());
		
		usuario.setDatos_personales(datos_personales.toString());
		usuario.setPorcentaje_dp(redondear(porcentaje,2));
		
		try {
			usuario_dataLocalServiceUtil.updateusuario_data(usuario);
			auditoriaLocalServiceUtil.addauditoria(audi);
//			actionRequest.getPortletSession().setAttribute("usuarioId", usuario.getNumeroDocumento());
			SessionMessages.add(actionRequest, "guardoDatosPersonales");
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, "noGuardoDatosPersonales");
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
		}
		
		
		
		
	}

	public void guardarDespachoAsignado(ActionRequest actionRequest, ActionResponse actionResponse){
//		long editorId = (long) actionRequest.getPortletSession().getAttribute("editorId");
		editores editor = null;
		try {
			editor = editoresLocalServiceUtil.getPorUserid(actionRequest.getRemoteUser());
		} catch (PortalException | SystemException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
		}
		
		planificacion ano = new planificacionClp();
		try {
			ano = planificacionLocalServiceUtil.PorEstado("ACTIVO");
		} catch (SystemException e1) {}
		
		String despacho = ParamUtil.getString(actionRequest, "despacho");
		String cargo = ParamUtil.getString(actionRequest, "cargo");
		
		
//		String usuarioId = (String) actionRequest.getPortletSession().getAttribute("usuarioId");
		usuario_data usuario = null;
		try {
			usuario = usuario_dataLocalServiceUtil.getusuario_data(editor.getNumero_documento_edita());
		} catch (PortalException | SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		usuario.setFechaModificacion(new Date());
		
		String anterior = usuario.getDespacho();
		String anterior2 = usuario.getCargo();
		
		auditoria audi = auditoriaLocalServiceUtil.createauditoria(0L);
		try {
			audi.setModificado_por(UserLocalServiceUtil.getUser(Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
		} catch (NumberFormatException | PortalException | SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(anterior.isEmpty()){
			audi.setAccion("Creación");
		}else{
			audi.setAccion("Modificación");
		}
		audi.setCampo_modifico("Despacho Asignado");
		audi.setFecha(new Date());
		audi.setAno_vigencia(ano.getAnhio());
		audi.setCedula_funcionario(usuario.getNumeroDocumento());
		audi.setLog_anterior(usuario.getDespacho());
		audi.setLog_nuevo(despacho);
		
		auditoria audi2 = auditoriaLocalServiceUtil.createauditoria(0L);
		try {
			audi2.setModificado_por(UserLocalServiceUtil.getUser(Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
		} catch (NumberFormatException | PortalException | SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(anterior2.isEmpty()){
			audi2.setAccion("Creación");
		}else{
			audi2.setAccion("Modificación");
		}
		audi2.setCampo_modifico("Cargo");
		audi2.setFecha(new Date());
		audi2.setAno_vigencia(ano.getAnhio());
		audi2.setCedula_funcionario(usuario.getNumeroDocumento());
		audi2.setLog_anterior(usuario.getCargo());
		audi2.setLog_nuevo(cargo);
		
		usuario.setDespacho(despacho);
		usuario.setCargo(cargo);
		
		editor.setDespacho_edita(despacho);
		editor.setCargo_edita(cargo);
		
		try {
			usuario_dataLocalServiceUtil.updateusuario_data(usuario);
			editoresLocalServiceUtil.updateeditores(editor);
			auditoriaLocalServiceUtil.addauditoria(audi);
			auditoriaLocalServiceUtil.addauditoria(audi2);
//			actionRequest.getPortletSession().setAttribute("usuarioId", usuario.getNumeroDocumento());
			SessionMessages.add(actionRequest, "guardoDespacho");
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, "noGuardoDespacho");
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
		}
	}
	
	public void guardarFormacionAcademica(ActionRequest actionRequest, ActionResponse actionResponse){
//		long editorId = (long) actionRequest.getPortletSession().getAttribute("editorId");
		editores editor = null;
		try {
			editor = editoresLocalServiceUtil.getPorUserid(actionRequest.getRemoteUser());
		} catch (PortalException | SystemException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
		}
		
		double porcentaje = 0.0;
		
		planificacion ano = new planificacionClp();
		try {
			ano = planificacionLocalServiceUtil.PorEstado("ACTIVO");
		} catch (SystemException e1) {}
		
		JSONObject formacion_academica = JSONFactoryUtil.createJSONObject();
		String educacionMedia = ParamUtil.getString(actionRequest, "educacionMedia");
		String tituloEB = ParamUtil.getString(actionRequest, "tituloEB");
		String mesEM = ParamUtil.getString(actionRequest, "mesEM");
		String anhioEM = ParamUtil.getString(actionRequest, "anhioEM");
		
		if(!educacionMedia.isEmpty() || !tituloEB.isEmpty() || !mesEM.isEmpty() || !anhioEM.isEmpty())
			porcentaje+=3.333333333;
		
		formacion_academica.put("educacionMedia", educacionMedia);
		formacion_academica.put("tituloEducacionMedia", tituloEB);
		formacion_academica.put("mesEducacionMedia", mesEM);
		formacion_academica.put("anhioEducacionMedia", anhioEM);
		
		String idsES = ParamUtil.getString(actionRequest, "idsES");
		String [] ii = idsES.split(",");
		int cantidadES = ii.length;
		
		
		JSONArray formacion = JSONFactoryUtil.createJSONArray();
		
		boolean entraPorcentaje = true;
		
		for(String i : ii){
			JSONObject f = JSONFactoryUtil.createJSONObject();
			boolean entra = true;			
			
			String modalidadES = ParamUtil.getString(actionRequest, "modalidadES"+i);
			String semestresES = ParamUtil.getString(actionRequest, "semestresES"+i);
			String graduadoES = ParamUtil.getString(actionRequest, "graduadoES"+i);
			String tituloES = ParamUtil.getString(actionRequest, "tituloES"+i);
			String mesES = ParamUtil.getString(actionRequest, "mesES"+i);
			String anhioES = ParamUtil.getString(actionRequest, "anhioES"+i);
			String tarjetaES = ParamUtil.getString(actionRequest, "tarjetaES"+i);
			
			if(!modalidadES.isEmpty() || !semestresES.isEmpty() || !graduadoES.isEmpty() || !tituloES.isEmpty() || !mesES.isEmpty() || !anhioES.isEmpty() || !tarjetaES.isEmpty()){
				if(entraPorcentaje){
					porcentaje+=3.333333333;
					entraPorcentaje = false;
				}
				
			}else{
				entra = false;
				cantidadES--;
			}
			
			f.put("modalidadEducacionSuperior", modalidadES);
			f.put("semestresEducacionSuperior", semestresES);
			f.put("graduadoEducacionSuperior", graduadoES);
			f.put("tituloEducacionSuperior", tituloES);
			f.put("mesEducacionSuperior", mesES);
			f.put("anhioEducacionSuperior", anhioES);
			f.put("tarjetaEducacionSuperior", tarjetaES);
			if(entra)
				formacion.put(f);
		}
		
		String idsI = ParamUtil.getString(actionRequest, "idsI");
		String [] jj = idsI.split(",");
		int cantidadI = jj.length;
		
		
		JSONArray idioma = JSONFactoryUtil.createJSONArray();
		
		entraPorcentaje = true;
		
		for(String i : jj){
			JSONObject f = JSONFactoryUtil.createJSONObject();
			boolean entra = true;			
			
			String idiom = ParamUtil.getString(actionRequest, "idioma"+i);
			String hi = ParamUtil.getString(actionRequest, "hi"+i);
			String li = ParamUtil.getString(actionRequest, "li"+i);
			String ei = ParamUtil.getString(actionRequest, "ei"+i);
			
			if(!idiom.isEmpty() || !hi.isEmpty() || !li.isEmpty() || !ei.isEmpty()){
				if(entraPorcentaje){
					porcentaje+=3.333333333;
					entraPorcentaje = false;
				}
				
			}else{
				entra = false;
				cantidadI--;
			}
			
			f.put("idioma", ParamUtil.getString(actionRequest, "idioma"+i));
			f.put("habla", ParamUtil.getString(actionRequest, "hi"+i));
			f.put("lee", ParamUtil.getString(actionRequest, "li"+i));
			f.put("escribe", ParamUtil.getString(actionRequest, "ei"+i));
			if(entra)
				idioma.put(f);
		}
		
		formacion_academica.put("formacion", formacion);
		formacion_academica.put("cantidadES", cantidadES);
		formacion_academica.put("idiomas", idioma);
		formacion_academica.put("cantidadI", cantidadI);
		
//		String usuarioId = (String) actionRequest.getPortletSession().getAttribute("usuarioId");
		usuario_data usuario = null;
		try {
			usuario = usuario_dataLocalServiceUtil.getusuario_data(editor.getNumero_documento_edita());
		} catch (PortalException | SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		usuario.setFechaModificacion(new Date());
		
		String anterior = usuario.getFormacion_academica();
		
		auditoria audi = auditoriaLocalServiceUtil.createauditoria(0L);
		try {
			audi.setModificado_por(UserLocalServiceUtil.getUser(Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
		} catch (NumberFormatException | PortalException | SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(anterior.isEmpty()){
			audi.setAccion("Creación");
		}else{
			audi.setAccion("Modificación");
		}
		audi.setCampo_modifico("Formación Académica");
		audi.setFecha(new Date());
		audi.setAno_vigencia(ano.getAnhio());
		audi.setCedula_funcionario(usuario.getNumeroDocumento());
		audi.setLog_anterior(usuario.getFormacion_academica());
		audi.setLog_nuevo(formacion_academica.toString());
		
		usuario.setFormacion_academica(formacion_academica.toString());
		usuario.setPorcentaje_fa(redondear(porcentaje,2));
		
		try {
			usuario_dataLocalServiceUtil.updateusuario_data(usuario);
			auditoriaLocalServiceUtil.addauditoria(audi);
//			actionRequest.getPortletSession().setAttribute("usuarioId", usuario.getNumeroDocumento());
			SessionMessages.add(actionRequest, "guardoFormacionAcademica");
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, "noGuardoFormacionAcademica");
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
		}
		
	}
	
	public void guardarExperienciaLaboral(ActionRequest actionRequest, ActionResponse actionResponse){
//		long editorId = (long) actionRequest.getPortletSession().getAttribute("editorId");
		editores editor = null;
		try {
			editor = editoresLocalServiceUtil.getPorUserid(actionRequest.getRemoteUser());
		} catch (PortalException | SystemException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
		}
		
		double porcentaje = 0.0;
		
		planificacion ano = new planificacionClp();
		try {
			ano = planificacionLocalServiceUtil.PorEstado("ACTIVO");
		} catch (SystemException e1) {}
		
		JSONObject experiencia_laboral = JSONFactoryUtil.createJSONObject();
		
		String ids = ParamUtil.getString(actionRequest, "ids");
		String [] ii = ids.split(",");
		int cantidadEL = ii.length;
		
		boolean entraPorcentaje = true;
		
		JSONArray expe = JSONFactoryUtil.createJSONArray();
		for(String i : ii){
			JSONObject f = JSONFactoryUtil.createJSONObject();
			boolean entra = true;			
			
			String empresa = ParamUtil.getString(actionRequest, "empresa"+i);
			String sector = ParamUtil.getString(actionRequest, "sector"+i);
			String pais = ParamUtil.getString(actionRequest, "pais"+i);
			String departamento = ParamUtil.getString(actionRequest, "departamento"+i);
			String municipio = ParamUtil.getString(actionRequest, "municipio"+i);
			String correo = ParamUtil.getString(actionRequest, "correo"+i);
			String telefono = ParamUtil.getString(actionRequest, "telefono"+i);
			String fechai = ParamUtil.getString(actionRequest, "fechai"+i);
			String fechar = ParamUtil.getString(actionRequest, "fechar"+i);
			String cargo = ParamUtil.getString(actionRequest, "cargo"+i);
			String dependencia = ParamUtil.getString(actionRequest, "dependencia"+i);
			String direccion = ParamUtil.getString(actionRequest, "direccion"+i);
			
			if(!empresa.isEmpty() || !sector.isEmpty() || !pais.isEmpty() || !departamento.isEmpty() || !municipio.isEmpty() || !correo.isEmpty() || !telefono.isEmpty() || !fechai.isEmpty() || !fechar.isEmpty() || !cargo.isEmpty() || !dependencia.isEmpty() || !direccion.isEmpty()){
				if(entraPorcentaje){
					porcentaje+=3.0;
					entraPorcentaje = false;
				}
				
			}else{
				entra = false;
				cantidadEL--;
			}
			f.put("empresa", empresa);
			f.put("sector", sector);
			f.put("pais", pais);
			f.put("departamento", departamento);
			f.put("municipio", municipio);
			f.put("correo", correo);
			f.put("telefono", telefono);
			f.put("fechaIngreso", fechai);
			f.put("fechaRetiro", fechar);
			f.put("cargo", cargo);
			f.put("dependencia", dependencia);
			f.put("direccion", direccion);
			
			if(entra)
				expe.put(f);
		}
		
		experiencia_laboral.put("experiencia", expe);
		experiencia_laboral.put("cantidadEL", cantidadEL);
		
//		String usuarioId = (String) actionRequest.getPortletSession().getAttribute("usuarioId");
		usuario_data usuario = null;
		try {
			usuario = usuario_dataLocalServiceUtil.getusuario_data(editor.getNumero_documento_edita());
		} catch (PortalException | SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		usuario.setFechaModificacion(new Date());
		
		String anterior = usuario.getExperiencia_laboral();
		
		auditoria audi = auditoriaLocalServiceUtil.createauditoria(0L);
		try {
			audi.setModificado_por(UserLocalServiceUtil.getUser(Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
		} catch (NumberFormatException | PortalException | SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(anterior.isEmpty()){
			audi.setAccion("Creación");
		}else{
			audi.setAccion("Modificación");
		}
		audi.setCampo_modifico("Experiencia Laboral");
		audi.setFecha(new Date());
		audi.setAno_vigencia(ano.getAnhio());
		audi.setCedula_funcionario(usuario.getNumeroDocumento());
		audi.setLog_anterior(usuario.getExperiencia_laboral());
		audi.setLog_nuevo(experiencia_laboral.toString());
		
		usuario.setExperiencia_laboral(experiencia_laboral.toString());
		usuario.setPorcentaje_el(redondear(porcentaje,2));
		
		try {
			usuario_dataLocalServiceUtil.updateusuario_data(usuario);
			auditoriaLocalServiceUtil.addauditoria(audi);
//			actionRequest.getPortletSession().setAttribute("usuarioId", usuario.getNumeroDocumento());
			SessionMessages.add(actionRequest, "guardoExperienciaLaboral");
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, "noGuardoExperienciaLaboral");
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
		}
		
	}
	
	public void guardarBienesRentas(ActionRequest actionRequest, ActionResponse actionResponse){
//		long editorId = (long) actionRequest.getPortletSession().getAttribute("editorId");
		editores editor = null;
		try {
			editor = editoresLocalServiceUtil.getPorUserid(actionRequest.getRemoteUser());
		} catch (PortalException | SystemException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
		}
		
		double porcentaje = 0.0;
		
		planificacion ano = new planificacionClp();
		try {
			ano = planificacionLocalServiceUtil.PorEstado("ACTIVO");
		} catch (SystemException e1) {}
		
		JSONObject bienes_y_rentas = JSONFactoryUtil.createJSONObject();
		
		String idsB = ParamUtil.getString(actionRequest, "idsB");
		String [] ii = idsB.split(",");
		int cantidadB = ii.length;
		
		boolean entraPorcentaje = true;
		
		JSONArray bienes = JSONFactoryUtil.createJSONArray();
		for(String i : ii){
			JSONObject f = JSONFactoryUtil.createJSONObject();
			
			boolean entra = true;			
			
			String tipoBien = ParamUtil.getString(actionRequest, "tipoBien"+i);
			String descripcionBien = ParamUtil.getString(actionRequest, "descripcionBien"+i);
			String valorBien = ParamUtil.getString(actionRequest, "valorBien"+i);
			
			if(!tipoBien.isEmpty() || !descripcionBien.isEmpty() || !valorBien.isEmpty()){
				if(entraPorcentaje){
					porcentaje+=3.5;
					entraPorcentaje = false;
				}
				
			}else{
				entra = false;
				cantidadB--;
			}
			
			f.put("tipo_bien", tipoBien);
			f.put("descripcionBien", descripcionBien);
			f.put("valorBien", valorBien);
			
			if(entra)
				bienes.put(f);
		}
		
		String idsO = ParamUtil.getString(actionRequest, "idsO");
		String [] jj = idsO.split(",");
		int cantidadO = jj.length;
		
		entraPorcentaje = true;
		
		JSONArray obligaciones = JSONFactoryUtil.createJSONArray();
		for(String i : jj){
			JSONObject f = JSONFactoryUtil.createJSONObject();
			
			boolean entra = true;			
			
			String tipoObligacion = ParamUtil.getString(actionRequest, "tipoObligacion"+i);
			String valorObligacion = ParamUtil.getString(actionRequest, "valorObligacion"+i);
			
			if(!tipoObligacion.isEmpty() || !valorObligacion.isEmpty()){
				if(entraPorcentaje){
					porcentaje+=3.5;
					entraPorcentaje = false;
				}
				
			}else{
				entra = false;
				cantidadO--;
			}
			
			f.put("tipoObligacion", tipoObligacion);
			f.put("valorObligacion", valorObligacion);
			if(entra)
				obligaciones.put(f);
		}
		bienes_y_rentas.put("bienes", bienes);
		bienes_y_rentas.put("cantidadB", cantidadB);
		
		bienes_y_rentas.put("obligaciones", obligaciones);
		bienes_y_rentas.put("cantidadO", cantidadO);
		
//		String usuarioId = (String) actionRequest.getPortletSession().getAttribute("usuarioId");
		usuario_data usuario = null;
		try {
			usuario = usuario_dataLocalServiceUtil.getusuario_data(editor.getNumero_documento_edita());
		} catch (PortalException | SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		usuario.setFechaModificacion(new Date());
		
		String anterior = usuario.getBienes_y_rentas();
		
		auditoria audi = auditoriaLocalServiceUtil.createauditoria(0L);
		try {
			audi.setModificado_por(UserLocalServiceUtil.getUser(Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
		} catch (NumberFormatException | PortalException | SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(anterior.isEmpty()){
			audi.setAccion("Creación");
		}else{
			audi.setAccion("Modificación");
		}
		audi.setCampo_modifico("Bienes y Rentas");
		audi.setFecha(new Date());
		audi.setAno_vigencia(ano.getAnhio());
		audi.setCedula_funcionario(usuario.getNumeroDocumento());
		audi.setLog_anterior(usuario.getBienes_y_rentas());
		audi.setLog_nuevo(bienes_y_rentas.toString());
		
		usuario.setBienes_y_rentas(bienes_y_rentas.toString());
		usuario.setPorcentaje_br(redondear(porcentaje,2));
		
		try {
			usuario_dataLocalServiceUtil.updateusuario_data(usuario);
			auditoriaLocalServiceUtil.addauditoria(audi);
//			actionRequest.getPortletSession().setAttribute("usuarioId", usuario.getNumeroDocumento());
			SessionMessages.add(actionRequest, "guardoBienesRentas");
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, "noGuardoBienesRentas");
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
		}
		
	}
	
	public void guardarInformacionComplementaria(ActionRequest actionRequest, ActionResponse actionResponse){
//		long editorId = (long) actionRequest.getPortletSession().getAttribute("editorId");
		editores editor = null;
		try {
			editor = editoresLocalServiceUtil.getPorUserid(actionRequest.getRemoteUser());
		} catch (PortalException | SystemException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
		}
		
		double porcentaje = 0.0;
		
		planificacion ano = new planificacionClp();
		try {
			ano = planificacionLocalServiceUtil.PorEstado("ACTIVO");
		} catch (SystemException e1) {}		
		
		JSONObject informacion_complementaria = JSONFactoryUtil.createJSONObject();
		
		String idsRR = ParamUtil.getString(actionRequest, "idsRR");
		String [] ii = idsRR.split(",");
		int cantidadRR = ii.length;
		
		boolean entraPorcentaje = true;
		
		JSONArray relacion_recusaciones = JSONFactoryUtil.createJSONArray();
		for(String i : ii){
			JSONObject f = JSONFactoryUtil.createJSONObject();
			
			boolean entra = true;			
			
			String quien_recusaRR = ParamUtil.getString(actionRequest, "quien_recusaRR"+i);
			String causalRR = ParamUtil.getString(actionRequest, "causalRR"+i);
			String recusadoRR = ParamUtil.getString(actionRequest, "recusadoRR"+i);
			String decision_tomadaRR = ParamUtil.getString(actionRequest, "decision_tomadaRR"+i);
			
			if(!quien_recusaRR.isEmpty() || !causalRR.isEmpty() || !recusadoRR.isEmpty() || !decision_tomadaRR.isEmpty()){
				if(entraPorcentaje){
					porcentaje+=3.333333333;
					entraPorcentaje = false;
				}
				
			}else{
				entra = false;
				cantidadRR--;
			}
			
			f.put("quien_recusa", quien_recusaRR);
			f.put("causal", causalRR);
			f.put("recusado", recusadoRR);
			f.put("decision_tomada", decision_tomadaRR);
			if(entra)
				relacion_recusaciones.put(f);
		}
		
		String idsRI = ParamUtil.getString(actionRequest, "idsRI");
		String [] jj = idsRI.split(",");
		int cantidadRI = jj.length;
		
		entraPorcentaje = true;
		
		JSONArray relacion_impedimentos = JSONFactoryUtil.createJSONArray();
		for(String i : jj){
			JSONObject f = JSONFactoryUtil.createJSONObject();
			
			boolean entra = true;			
			
			String quien_impedidori = ParamUtil.getString(actionRequest, "quien_impedidori"+i);
			String fechari = ParamUtil.getString(actionRequest, "fechari"+i);
			String causalri = ParamUtil.getString(actionRequest, "causalri"+i);
			String decision_tomadari = ParamUtil.getString(actionRequest, "decision_tomadari"+i);
			
			if(!quien_impedidori.isEmpty() || !fechari.isEmpty() || !causalri.isEmpty() || !decision_tomadari.isEmpty()){
				if(entraPorcentaje){
					porcentaje+=3.333333333;
					entraPorcentaje = false;
				}
				
			}else{
				entra = false;
				cantidadRI--;
			}
			
			f.put("quien_impedido", quien_impedidori);
			f.put("fecha", fechari);
			f.put("causal", causalri);
			f.put("decision_tomada", decision_tomadari);
			
			if(entra)
				relacion_impedimentos.put(f);
		}
		
		String idsIP = ParamUtil.getString(actionRequest, "idsIP");
		String [] kk = idsIP.split(",");
		int cantidadIP = kk.length;
		
		entraPorcentaje = true;
		
		JSONArray comision_interior = JSONFactoryUtil.createJSONArray();
		for(String i : kk){
			JSONObject f = JSONFactoryUtil.createJSONObject();
			
			boolean entra = true;			
			
			String resolucionip = ParamUtil.getString(actionRequest, "resolucionip"+i);
			String destinoip = ParamUtil.getString(actionRequest, "destinoip"+i);
			String objetoip = ParamUtil.getString(actionRequest, "objetoip"+i);
			String viaticosip = ParamUtil.getString(actionRequest, "viaticosip"+i);
			String diasip = ParamUtil.getString(actionRequest, "diasip"+i);
			String entidadip = ParamUtil.getString(actionRequest, "entidadip"+i);
			String observacionesip = ParamUtil.getString(actionRequest, "observacionesip"+i);
			
			if(!resolucionip.isEmpty() || !destinoip.isEmpty() || !objetoip.isEmpty() || !viaticosip.isEmpty() || !diasip.isEmpty() || !entidadip.isEmpty() || !observacionesip.isEmpty()){
				if(entraPorcentaje){
					porcentaje+=3.333333333;
					entraPorcentaje = false;
				}
				
			}else{
				entra = false;
				cantidadIP--;
			}
			
			f.put("numero_resolucion", resolucionip);
			f.put("destino", destinoip);
			f.put("objeto_comision", objetoip);
			f.put("viaticos", viaticosip);
			f.put("dias", diasip);
			f.put("entidad", entidadip);
			f.put("observaciones", observacionesip);
			
			if(entra)
				comision_interior.put(f);
		}
		
		String idsEP = ParamUtil.getString(actionRequest, "idsEP");
		String [] ll = idsEP.split(",");
		int cantidadEP = ll.length;
		
		entraPorcentaje = true;
		
		JSONArray comision_exterior = JSONFactoryUtil.createJSONArray();
		for(String i : ll){
			JSONObject f = JSONFactoryUtil.createJSONObject();
			
			boolean entra = true;			
			
			String resolucionep = ParamUtil.getString(actionRequest, "resolucionep"+i);
			String destinoep = ParamUtil.getString(actionRequest, "destinoep"+i);
			String objetoep = ParamUtil.getString(actionRequest, "objetoep"+i);
			String viaticosep = ParamUtil.getString(actionRequest, "viaticosep"+i);
			String diasep = ParamUtil.getString(actionRequest, "diasep"+i);
			String entidadep = ParamUtil.getString(actionRequest, "entidadep"+i);
			String observacionesep = ParamUtil.getString(actionRequest, "observacionesep"+i);
			
			if(!resolucionep.isEmpty() || !destinoep.isEmpty() || !objetoep.isEmpty() || !viaticosep.isEmpty() || !diasep.isEmpty() || !entidadep.isEmpty() || !observacionesep.isEmpty()){
				if(entraPorcentaje){
					porcentaje+=3.333333333;
					entraPorcentaje = false;
				}
				
			}else{
				entra = false;
				cantidadEP--;
			}
			
			f.put("numero_resolucion", resolucionep);
			f.put("destino", destinoep);
			f.put("objeto_comision", objetoep);
			f.put("viaticos", viaticosep);
			f.put("dias", diasep);
			f.put("entidad", entidadep);
			f.put("observaciones", observacionesep);
			
			if(entra)
				comision_exterior.put(f);
		}
		
		String idsIS = ParamUtil.getString(actionRequest, "idsIS");
		String [] oo = idsIS.split(",");
		int cantidadIS = oo.length;
		
		entraPorcentaje = true;
		
		JSONArray inasistencia_sesiones_ordinarias = JSONFactoryUtil.createJSONArray();
		for(String i : oo){
			JSONObject f = JSONFactoryUtil.createJSONObject();
			
			boolean entra = true;			
			
			String inasistencia = ParamUtil.getString(actionRequest, "inasistencia"+i);
			String causa = ParamUtil.getString(actionRequest, "causa"+i);
			
			if(!inasistencia.isEmpty() || !causa.isEmpty()){
				if(entraPorcentaje){
					porcentaje+=3.333333333;
					entraPorcentaje = false;
				}
				
			}else{
				entra = false;
				cantidadIS--;
			}
			
			f.put("inasistencia", inasistencia);
			f.put("causa", causa);
			
			if(entra)
				inasistencia_sesiones_ordinarias.put(f);
		}
		
		String idsDU = ParamUtil.getString(actionRequest, "idsDU");
		String [] pp = idsDU.split(",");
		int cantidadDU = pp.length;
		
		entraPorcentaje = true;
		
		JSONArray docencia_universitarias = JSONFactoryUtil.createJSONArray();
		for(String i : pp){
			JSONObject f = JSONFactoryUtil.createJSONObject();

			
			boolean entra = true;			
			
			String semestre = ParamUtil.getString(actionRequest, "semestre"+i);
			String universidad = ParamUtil.getString(actionRequest, "universidad"+i);
			String facultad = ParamUtil.getString(actionRequest, "facultad"+i);
			String catedra = ParamUtil.getString(actionRequest, "catedra"+i);
			String horario = ParamUtil.getString(actionRequest, "horario"+i);
			String horas = ParamUtil.getString(actionRequest, "horas"+i);
			
			if(!semestre.isEmpty() || !universidad.isEmpty() || !facultad.isEmpty() || !catedra.isEmpty() || !horario.isEmpty() || !horas.isEmpty()){
				if(entraPorcentaje){
					porcentaje+=3.333333333;
					entraPorcentaje = false;
				}
				
			}else{
				entra = false;
				cantidadDU--;
			}
			
			f.put("semestre", semestre);
			f.put("universidad", universidad);
			f.put("facultad", facultad);
			f.put("catedra", catedra);
			f.put("horario", horario);
			f.put("horas", horas);
			
			if(entra)
				docencia_universitarias.put(f);
		}
		
		informacion_complementaria.put("relacion_recusaciones", relacion_recusaciones);
		informacion_complementaria.put("cantidadRR", cantidadRR);
		informacion_complementaria.put("relacion_impedimentos", relacion_impedimentos);
		informacion_complementaria.put("cantidadRI", cantidadRI);
		informacion_complementaria.put("comision_interior", comision_interior);
		informacion_complementaria.put("cantidadIP", cantidadIP);
		informacion_complementaria.put("comision_exterior", comision_exterior);
		informacion_complementaria.put("cantidadEP", cantidadEP);
		informacion_complementaria.put("inasistencia_sesiones_ordinarias", inasistencia_sesiones_ordinarias);
		informacion_complementaria.put("cantidadIS", cantidadIS);
		informacion_complementaria.put("docencia_universitarias", docencia_universitarias);
		informacion_complementaria.put("cantidadDU", cantidadDU);
		
//		String usuarioId = (String) actionRequest.getPortletSession().getAttribute("usuarioId");
		usuario_data usuario = null;
		try {
			usuario = usuario_dataLocalServiceUtil.getusuario_data(editor.getNumero_documento_edita());
		} catch (PortalException | SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		usuario.setFechaModificacion(new Date());
		
		String anterior = usuario.getInformacion_complementaria();
		
		auditoria audi = auditoriaLocalServiceUtil.createauditoria(0L);
		try {
			audi.setModificado_por(UserLocalServiceUtil.getUser(Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
		} catch (NumberFormatException | PortalException | SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(anterior.isEmpty()){
			audi.setAccion("Creación");
		}else{
			audi.setAccion("Modificación");
		}
		audi.setCampo_modifico("Información Complementaria");
		audi.setFecha(new Date());
		audi.setAno_vigencia(ano.getAnhio());
		audi.setCedula_funcionario(usuario.getNumeroDocumento());
		audi.setLog_anterior(usuario.getInformacion_complementaria());
		audi.setLog_nuevo(informacion_complementaria.toString());
		
		usuario.setInformacion_complementaria(informacion_complementaria.toString());
		usuario.setPorcentaje_ic(redondear(porcentaje,2));
		
		try {
			usuario_dataLocalServiceUtil.updateusuario_data(usuario);
			auditoriaLocalServiceUtil.addauditoria(audi);
//			actionRequest.getPortletSession().setAttribute("usuarioId", usuario.getNumeroDocumento());
			SessionMessages.add(actionRequest, "guardoInformacionComplementaria");
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, "noGuardoInformacionComplementaria");
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
		}
	}

	public void guardarConfictoInteres(ActionRequest actionRequest, ActionResponse actionResponse){
		editores editor = null;
		try {
			editor = editoresLocalServiceUtil.getPorUserid(actionRequest.getRemoteUser());
		} catch (PortalException | SystemException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
		}
		
		double porcentaje = 0.0;
		
		planificacion ano = new planificacionClp();
		try {
			ano = planificacionLocalServiceUtil.PorEstado("ACTIVO");
		} catch (SystemException e1) {}		
		
		JSONObject conflicto_intereses = JSONFactoryUtil.createJSONObject();
		
		String respuesta = ParamUtil.getString(actionRequest, "sociedadconyugal");
		
		if(respuesta.equals("no")){
			porcentaje+=2.0;
		}else if(respuesta.equals("si")){
			porcentaje+=1.0;
		}
		
		String idsConyuge = ParamUtil.getString(actionRequest, "idsConyuge");
		String [] ii = idsConyuge.split(",");
		int cantidadConyuge = ii.length;
		
		boolean entraPorcentaje = true;
		
		JSONArray informacion_coyuge = JSONFactoryUtil.createJSONArray();
		for(String i : ii){
			JSONObject c = JSONFactoryUtil.createJSONObject();
			
			boolean entra = true;			
			
			String nombreConyuge = ParamUtil.getString(actionRequest, "nombreConyuge"+i);
			String tipoSociedad = ParamUtil.getString(actionRequest, "tipoSociedad"+i);
			String numeroDocumentoConyuge = ParamUtil.getString(actionRequest, "numeroDocumentoConyuge"+i);
			
			if(!nombreConyuge.isEmpty() || !tipoSociedad.isEmpty() || !numeroDocumentoConyuge.isEmpty()){
				if(entraPorcentaje){
					porcentaje+=1.0;
					entraPorcentaje = false;
				}
				
			}else{
				entra = false;
				cantidadConyuge--;
			}
			
			c.put("nombreConyuge", nombreConyuge);
			c.put("tipoSociedad", tipoSociedad);
			c.put("numeroDocumentoConyuge", numeroDocumentoConyuge);
			if(entra)
				informacion_coyuge.put(c);
		}
		
		String idsPariente = ParamUtil.getString(actionRequest, "idsPariente");
		String [] jj = idsPariente.split(",");
		int cantidadPariente = jj.length;
		
		entraPorcentaje = true;
		
		JSONArray informacion_parientes = JSONFactoryUtil.createJSONArray();
		for(String i : jj){
			JSONObject f = JSONFactoryUtil.createJSONObject();
			
			boolean entra = true;			
			
			String parentesco = ParamUtil.getString(actionRequest, "parentesco"+i);
			String primerNombre = ParamUtil.getString(actionRequest, "primerNombre"+i);
			String segundoNombre = ParamUtil.getString(actionRequest, "segundoNombre"+i);
			String primerApellido = ParamUtil.getString(actionRequest, "primerApellido"+i);
			String segundoApellido = ParamUtil.getString(actionRequest, "segundoApellido"+i);
			String numeroDocumentoParentesco = ParamUtil.getString(actionRequest, "numeroDocumentoParentesco"+i);
			
			if(!parentesco.isEmpty() || !primerNombre.isEmpty() || !primerApellido.isEmpty() || !numeroDocumentoParentesco.isEmpty() ){
				if(entraPorcentaje){
					porcentaje+=1.0;
					entraPorcentaje = false;
				}
				
			}else{
				entra = false;
				cantidadPariente--;
			}
			
			f.put("parentesco", parentesco);
			f.put("primerNombre", primerNombre);
			f.put("segundoNombre", segundoNombre);
			f.put("primerApellido", primerApellido);
			f.put("segundoApellido", segundoApellido);
			f.put("numeroDocumentoParentesco", numeroDocumentoParentesco);
			
			if(entra)
				informacion_parientes.put(f);
		}
		
		String idsGremios = ParamUtil.getString(actionRequest, "idsGremios");
		String [] kk = idsGremios.split(",");
		int cantidadGremios = kk.length;
		
		entraPorcentaje = true;
		
		JSONArray participacion_gremios = JSONFactoryUtil.createJSONArray();
		for(String i : kk){
			JSONObject f = JSONFactoryUtil.createJSONObject();
			
			boolean entra = true;			
			
			String gremio = ParamUtil.getString(actionRequest, "gremio"+i);
			String calidadMiembro = ParamUtil.getString(actionRequest, "calidadMiembro"+i);
			String paisGremio = ParamUtil.getString(actionRequest, "paisGremio"+i);
			
			if(!gremio.isEmpty() || !calidadMiembro.isEmpty() || !paisGremio.isEmpty() ){
				if(entraPorcentaje){
					porcentaje+=1.0;
					entraPorcentaje = false;
				}
				
			}else{
				entra = false;
				cantidadGremios--;
			}
			
			f.put("gremio", gremio);
			f.put("calidadMiembro", calidadMiembro);
			f.put("paisGremio", paisGremio);
			
			if(entra)
				participacion_gremios.put(f);
		}
		
		String idsFideicomisos = ParamUtil.getString(actionRequest, "idsFideicomisos");
		String [] ll = idsFideicomisos.split(",");
		int cantidadFideicomiso = ll.length;
		
		entraPorcentaje = true;
		
		JSONArray otras_inversiones_fideicomiso = JSONFactoryUtil.createJSONArray();
		for(String i : ll){
			JSONObject f = JSONFactoryUtil.createJSONObject();
			
			boolean entra = true;			
			
			String nombreFideicomiso = ParamUtil.getString(actionRequest, "nombreFideicomiso"+i);
			String calidadFideicomiso = ParamUtil.getString(actionRequest, "calidadFideicomiso"+i);
			String valorFideicomiso = ParamUtil.getString(actionRequest, "valorFideicomiso"+i);
			String paisFideicomiso = ParamUtil.getString(actionRequest, "paisFideicomiso"+i);
			
			if(!nombreFideicomiso.isEmpty() || !calidadFideicomiso.isEmpty() || !valorFideicomiso.isEmpty() || !paisFideicomiso.isEmpty() ){
				if(entraPorcentaje){
					porcentaje+=1.0;
					entraPorcentaje = false;
				}
				
			}else{
				entra = false;
				cantidadFideicomiso--;
			}
			
			f.put("nombreFideicomiso", nombreFideicomiso);
			f.put("calidadFideicomiso", calidadFideicomiso);
			f.put("valorFideicomiso", valorFideicomiso);
			f.put("paisFideicomiso", paisFideicomiso);
			
			if(entra)
				otras_inversiones_fideicomiso.put(f);
		}
		
		String idsInversiones = ParamUtil.getString(actionRequest, "idsInversiones");
		String [] oo = idsInversiones.split(",");
		int cantidadInversiones = oo.length;
		
		entraPorcentaje = true;
		
		JSONArray otras_inversiones_inversiones = JSONFactoryUtil.createJSONArray();
		for(String i : oo){
			JSONObject f = JSONFactoryUtil.createJSONObject();
			
			boolean entra = true;			
			
			String tipoInversion = ParamUtil.getString(actionRequest, "tipoInversion"+i);
			String valorInversion = ParamUtil.getString(actionRequest, "valorInversion"+i);
			String paisInversion = ParamUtil.getString(actionRequest, "paisInversion"+i);
			
			if(!tipoInversion.isEmpty() || !valorInversion.isEmpty() || !paisInversion.isEmpty()){
				if(entraPorcentaje){
					porcentaje+=1.0;
					entraPorcentaje = false;
				}
				
			}else{
				entra = false;
				cantidadInversiones--;
			}
			
			f.put("tipoInversion", tipoInversion);
			f.put("valorInversion", valorInversion);
			f.put("paisInversion", paisInversion);
			
			if(entra)
				otras_inversiones_inversiones.put(f);
		}
		
		String idsDonaciones = ParamUtil.getString(actionRequest, "idsDonaciones");
		String [] pp = idsDonaciones.split(",");
		int cantidadDonaciones = pp.length;
		
		entraPorcentaje = true;
		
		JSONArray donaciones = JSONFactoryUtil.createJSONArray();
		for(String i : pp){
			JSONObject f = JSONFactoryUtil.createJSONObject();

			
			boolean entra = true;			
			
			String nombreDonacion = ParamUtil.getString(actionRequest, "nombreDonacion"+i);
			String valorDonacion = ParamUtil.getString(actionRequest, "valorDonacion"+i);
			
			if(!nombreDonacion.isEmpty() || !valorDonacion.isEmpty() ){
				if(entraPorcentaje){
					porcentaje+=1.0;
					entraPorcentaje = false;
				}
				
			}else{
				entra = false;
				cantidadDonaciones--;
			}
			
			f.put("nombreDonacion", nombreDonacion);
			f.put("valorDonacion", valorDonacion);
			
			if(entra)
				donaciones.put(f);
		}
		
		String idsPotenciales = ParamUtil.getString(actionRequest, "idsPotenciales");
		String [] ff = idsPotenciales.split(",");
		int cantidadPotenciales = ff.length;
		
		entraPorcentaje = true;
		
		JSONArray potenciales = JSONFactoryUtil.createJSONArray();
		for(String i : ff){
			JSONObject f = JSONFactoryUtil.createJSONObject();

			
			boolean entra = true;			
			
			String descripcionPotenciales = ParamUtil.getString(actionRequest, "descripcionPotenciales"+i);
			
			if(!descripcionPotenciales.isEmpty() ){
				if(entraPorcentaje){
					porcentaje+=1.0;
					entraPorcentaje = false;
				}
				
			}else{
				entra = false;
				cantidadPotenciales--;
			}
			
			f.put("descripcionPotenciales", descripcionPotenciales);
			
			if(entra)
				potenciales.put(f);
		}
		
		conflicto_intereses.put("respuesta", respuesta);
		conflicto_intereses.put("informacion_coyuge", informacion_coyuge);
		conflicto_intereses.put("cantidadConyuge", cantidadConyuge);
		conflicto_intereses.put("informacion_parientes", informacion_parientes);
		conflicto_intereses.put("cantidadPariente", cantidadPariente);
		conflicto_intereses.put("participacion_gremios", participacion_gremios);
		conflicto_intereses.put("cantidadGremios", cantidadGremios);
		conflicto_intereses.put("otras_inversiones_fideicomiso", otras_inversiones_fideicomiso);
		conflicto_intereses.put("cantidadFideicomiso", cantidadFideicomiso);
		conflicto_intereses.put("otras_inversiones_inversiones", otras_inversiones_inversiones);
		conflicto_intereses.put("cantidadInversiones", cantidadInversiones);
		conflicto_intereses.put("donaciones", donaciones);
		conflicto_intereses.put("cantidadDonaciones", cantidadDonaciones);
		conflicto_intereses.put("potenciales", potenciales);
		conflicto_intereses.put("cantidadPotenciales", cantidadPotenciales);
		
		usuario_data usuario = null;
		try {
			usuario = usuario_dataLocalServiceUtil.getusuario_data(editor.getNumero_documento_edita());
		} catch (PortalException | SystemException e1) {
			e1.printStackTrace();
		}
		usuario.setFechaModificacion(new Date());
		
		String anterior = usuario.getInformacion_complementaria();
		
		auditoria audi = auditoriaLocalServiceUtil.createauditoria(0L);
		try {
			audi.setModificado_por(UserLocalServiceUtil.getUser(Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
		} catch (NumberFormatException | PortalException | SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(anterior.isEmpty()){
			audi.setAccion("Creación");
		}else{
			audi.setAccion("Modificación");
		}
		audi.setCampo_modifico("Conflicto de Intereses");
		audi.setFecha(new Date());
		audi.setAno_vigencia(ano.getAnhio());
		audi.setCedula_funcionario(usuario.getNumeroDocumento());
		audi.setLog_anterior(usuario.getInformacion_complementaria());
		audi.setLog_nuevo(conflicto_intereses.toString());
		
		usuario.setConflicto_intereses(conflicto_intereses.toString());
		usuario.setPorcentaje_ci(redondear(porcentaje,2));
		
		try {
			usuario_dataLocalServiceUtil.updateusuario_data(usuario);
			auditoriaLocalServiceUtil.addauditoria(audi);
			SessionMessages.add(actionRequest, "guardoConflicto");
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, "noGuardoConflicto");
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
		}
	}
	
	public void guardarTiempoExperiencia(ActionRequest actionRequest, ActionResponse actionResponse){
//		long editorId = (long) actionRequest.getPortletSession().getAttribute("editorId");
		editores editor = null;
		try {
			editor = editoresLocalServiceUtil.getPorUserid(actionRequest.getRemoteUser());
		} catch (PortalException | SystemException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
		}
		
		double porcentaje = 0.0;
		
		planificacion ano = new planificacionClp();
		try {
			ano = planificacionLocalServiceUtil.PorEstado("ACTIVO");
		} catch (SystemException e1) {}		
		
		JSONObject tiempo_experiencia = JSONFactoryUtil.createJSONObject();
		
		String anosSP = ParamUtil.getString(actionRequest, "anosSP");
		String mesesSP = ParamUtil.getString(actionRequest, "mesesSP");
		String anosESP = ParamUtil.getString(actionRequest, "anosESP");
		String mesesESP = ParamUtil.getString(actionRequest, "mesesESP");
		String anosTI = ParamUtil.getString(actionRequest, "anosTI");
		String mesesTI = ParamUtil.getString(actionRequest, "mesesTI");
		String anosM = ParamUtil.getString(actionRequest, "anosM");
		String anosTotal = ParamUtil.getString(actionRequest, "anosTotal");
		String mesesTotal = ParamUtil.getString(actionRequest, "mesesTotal");
		
		if(!mesesSP.isEmpty() || !anosSP.isEmpty() || !mesesESP.isEmpty() || !anosESP.isEmpty() || !mesesTI.isEmpty() || !anosTI.isEmpty() || !mesesTotal.isEmpty() || !anosTotal.isEmpty())
			porcentaje+=3.0;
		
		tiempo_experiencia.put("anosServidorPublico", anosSP);
		tiempo_experiencia.put("mesesServidorPublico", mesesSP);
		tiempo_experiencia.put("anosSectorPrivado", anosESP);
		tiempo_experiencia.put("mesesSectorPrivado", mesesESP);
		tiempo_experiencia.put("anosTrabajadorIndependiente", anosTI);
		tiempo_experiencia.put("mesesTrabajadorIndependiente", mesesTI);
		tiempo_experiencia.put("anosM", anosM);
		tiempo_experiencia.put("anosTotales", anosTotal);
		tiempo_experiencia.put("mesesTotales", mesesTotal);
		
//		String usuarioId = (String) actionRequest.getPortletSession().getAttribute("usuarioId");
		usuario_data usuario = null;
		try {
			usuario = usuario_dataLocalServiceUtil.getusuario_data(editor.getNumero_documento_edita());
		} catch (PortalException | SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		usuario.setFechaModificacion(new Date());
		
		String anterior = usuario.getTiempo_experiencia();
		
		auditoria audi = auditoriaLocalServiceUtil.createauditoria(0L);
		try {
			audi.setModificado_por(UserLocalServiceUtil.getUser(Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
		} catch (NumberFormatException | PortalException | SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(anterior.isEmpty()){
			audi.setAccion("Creación");
		}else{
			audi.setAccion("Modificación");
		}
		audi.setCampo_modifico("Tiempo Total de Experiencia");
		audi.setFecha(new Date());
		audi.setAno_vigencia(ano.getAnhio());
		audi.setCedula_funcionario(usuario.getNumeroDocumento());
		audi.setLog_anterior(usuario.getTiempo_experiencia());
		audi.setLog_nuevo(tiempo_experiencia.toString());
		
		usuario.setTiempo_experiencia(tiempo_experiencia.toString());
		usuario.setPorcentaje_te(redondear(porcentaje,2));
		
		try {
			usuario_dataLocalServiceUtil.updateusuario_data(usuario);
			auditoriaLocalServiceUtil.addauditoria(audi);
//			actionRequest.getPortletSession().setAttribute("usuarioId", usuario.getNumeroDocumento());
			SessionMessages.add(actionRequest, "guardoTiempoExperiencia");
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, "noGuardoTiempoExperiencia");
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
		}
		
	}
	
	public void guardarArchivoDR(ActionRequest actionRequest, ActionResponse actionResponse){
//		long editorId = (long) actionRequest.getPortletSession().getAttribute("editorId");
		editores editor = null;
		try {
			editor = editoresLocalServiceUtil.getPorUserid(actionRequest.getRemoteUser());
		} catch (PortalException | SystemException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
		}
		
		planificacion ano = new planificacionClp();
		try {
			ano = planificacionLocalServiceUtil.PorEstado("ACTIVO");
		} catch (SystemException e1) {}	
		
		
		if(PortletFileUpload.isMultipartContent(actionRequest)){
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(20000000); // bytes

			File repositoryPath = new File("/tmp");
			factory.setRepository(repositoryPath);
			PortletFileUpload upload = new PortletFileUpload(factory);
			upload.setSizeMax(20000000); // bytes
			
//			String usuarioId = (String) actionRequest.getPortletSession().getAttribute("usuarioId");
			usuario_data usuario = null;
			try {
				usuario = usuario_dataLocalServiceUtil.getusuario_data(editor.getNumero_documento_edita());
			} catch (PortalException | SystemException e1) {
				e1.printStackTrace();
			}
			usuario.setFechaModificacion(new Date());
			
			String anterior = usuario.getArchivo_declaracion_renta();
			
			auditoria audi = auditoriaLocalServiceUtil.createauditoria(0L);
			try {
				audi.setModificado_por(UserLocalServiceUtil.getUser(Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
			} catch (NumberFormatException | PortalException | SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(anterior.isEmpty()){
				audi.setAccion("Creación");
			}else{
				audi.setAccion("Modificación");
			}
			audi.setCampo_modifico("Archivo de Declaración de Renta");
			audi.setFecha(new Date());
			audi.setAno_vigencia(ano.getAnhio());
			audi.setCedula_funcionario(usuario.getNumeroDocumento());
			audi.setLog_anterior(anterior);
			
			try {
				List fileItemsList = upload.parseRequest(actionRequest);
				FileItem fileItem = (FileItem) fileItemsList.get(0);
				String nombreArchivo = fileItem.getName();
				if(!nombreArchivo.isEmpty()){
					
//					String archivo = "C:/ley_transparencia/"+usuario.getNumeroDocumento()+"-"+formatoNombreArchivos.format(new Date())+"-Declaracion-Renta.pdf";
					String archivo = "//csjportalrep01/portal_repository/ley-transparencia/"+usuario.getNumeroDocumento()+"-"+formatoNombreArchivos.format(new Date())+"-Declaracion-Renta.pdf";
//					String archivo = "//172.28.146.22/h/portal_repository_pruebas/ley-transparencia/"+usuario.getNumeroDocumento()+"-"+formatoNombreArchivos.format(new Date())+"-Declaracion-Renta.pdf";
					File file = new File(archivo);
					fileItem.write(file);
					if ( file.exists() ) {
						usuario.setArchivo_declaracion_renta(archivo);
					}
				}				
				
				audi.setLog_nuevo(usuario.getArchivo_declaracion_renta());
				
				usuario_dataLocalServiceUtil.updateusuario_data(usuario);
				auditoriaLocalServiceUtil.addauditoria(audi);
//				actionRequest.getPortletSession().setAttribute("usuarioId", usuario.getNumeroDocumento());
				SessionMessages.add(actionRequest, "guardoDeclaracionRenta");
				actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
			} catch (FileUploadException e) {
				e.printStackTrace();
				SessionErrors.add(actionRequest, "noGuardoDeclaracionRenta");
				actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
			} catch (Exception e) {
				e.printStackTrace();
				SessionErrors.add(actionRequest, "noGuardoDeclaracionRenta");
				actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
			}
		}
	}
	
	public void guardarArchivoFB(ActionRequest actionRequest, ActionResponse actionResponse){
//		long editorId = (long) actionRequest.getPortletSession().getAttribute("editorId");
		editores editor = null;
		try {
			editor = editoresLocalServiceUtil.getPorUserid(actionRequest.getRemoteUser());
		} catch (PortalException | SystemException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
		}
		
		planificacion ano = new planificacionClp();
		try {
			ano = planificacionLocalServiceUtil.PorEstado("ACTIVO");
		} catch (SystemException e1) {}	
		
		if(PortletFileUpload.isMultipartContent(actionRequest)){
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(20000000); // bytes

			File repositoryPath = new File("/tmp");
			factory.setRepository(repositoryPath);
			PortletFileUpload upload = new PortletFileUpload(factory);
			upload.setSizeMax(20000000); // bytes
			
//			String usuarioId = (String) actionRequest.getPortletSession().getAttribute("usuarioId");
			usuario_data usuario = null;
			try {
				usuario = usuario_dataLocalServiceUtil.getusuario_data(editor.getNumero_documento_edita());
			} catch (PortalException | SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			usuario.setFechaModificacion(new Date());
			
			String anterior = usuario.getArchivo_formulario_bienes();
			
			auditoria audi = auditoriaLocalServiceUtil.createauditoria(0L);
			try {
				audi.setModificado_por(UserLocalServiceUtil.getUser(Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
			} catch (NumberFormatException | PortalException | SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(anterior.isEmpty()){
				audi.setAccion("Creación");
			}else{
				audi.setAccion("Modificación");
			}
			audi.setCampo_modifico("Archivo de Formulario de Bienes");
			audi.setFecha(new Date());
			audi.setAno_vigencia(ano.getAnhio());
			audi.setCedula_funcionario(usuario.getNumeroDocumento());
			audi.setLog_anterior(anterior);
			
			try {
				List fileItemsList = upload.parseRequest(actionRequest);
				FileItem fileItem = (FileItem) fileItemsList.get(0);
				String nombreArchivo = fileItem.getName();
				if(!nombreArchivo.isEmpty()){
					
//					String archivo = "C:/ley_transparencia/"+usuario.getNumeroDocumento()+"-"+formatoNombreArchivos.format(new Date())+"-Formulario-Bienes.pdf";
					String archivo = "//csjportalrep01/portal_repository/ley-transparencia/"+usuario.getNumeroDocumento()+"-"+formatoNombreArchivos.format(new Date())+"-Formulario-Bienes.pdf";
//					String archivo = "//172.28.146.22/h/portal_repository_pruebas/ley-transparencia/"+usuario.getNumeroDocumento()+"-"+formatoNombreArchivos.format(new Date())+"-Formulario-Bienes.pdf";
					File file = new File(archivo);
					fileItem.write(file);
					if ( file.exists() ) {
						usuario.setArchivo_formulario_bienes(archivo);
					}
				}
				
				audi.setLog_nuevo(usuario.getArchivo_formulario_bienes());
				
				usuario_dataLocalServiceUtil.updateusuario_data(usuario);
				auditoriaLocalServiceUtil.addauditoria(audi);
//				actionRequest.getPortletSession().setAttribute("usuarioId", usuario.getNumeroDocumento());
				SessionMessages.add(actionRequest, "guardoFormularioBienes");
				actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
			} catch (FileUploadException e) {
				e.printStackTrace();
				SessionErrors.add(actionRequest, "noGuardoFormularioBienes");
				actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
			} catch (Exception e) {
				e.printStackTrace();
				SessionErrors.add(actionRequest, "noGuardoFormularioBienes");
				actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
			}
		}
	}
	
	public void solicitarPublicacion(ActionRequest actionRequest, ActionResponse actionResponse){
//		long editorId = (long) actionRequest.getPortletSession().getAttribute("editorId");
		editores editor = null;
		try {
			editor = editoresLocalServiceUtil.getPorUserid(actionRequest.getRemoteUser());
		} catch (PortalException | SystemException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
		}
		
//		String usuarioId = (String) actionRequest.getPortletSession().getAttribute("usuarioId");
		usuario_data usuario = null;
		try {
			usuario = usuario_dataLocalServiceUtil.getusuario_data(editor.getNumero_documento_edita());
		} catch (PortalException | SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		planificacion ano = null;
		try {
			ano = planificacionLocalServiceUtil.PorEstado("ACTIVO");
		} catch (SystemException e1) {}
		
		String retiro = ParamUtil.getString(actionRequest, "retiro");
		
		
		long validarModificacion = consultas.getValidarSolicitud(usuario.getNumeroDocumento(), String.valueOf(ano.getAnhio()));
		
//		String anterior = usuario.getArchivo_formulario_bienes();
		
		auditoria audi = auditoriaLocalServiceUtil.createauditoria(0L);
		try {
			audi.setModificado_por(UserLocalServiceUtil.getUser(Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
		} catch (NumberFormatException | PortalException | SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		audi.setAccion("Publicar Información");
		audi.setCampo_modifico("");
		audi.setFecha(new Date());
		audi.setAno_vigencia(ano.getAnhio());
		audi.setCedula_funcionario(usuario.getNumeroDocumento());
		audi.setLog_anterior("");
		audi.setLog_nuevo("");
		
		if(validarModificacion==0L){
			publicaciones solicitud = publicacionesLocalServiceUtil.createpublicaciones(0L);
			solicitud.setFk_usuario(usuario.getNumeroDocumento());
			solicitud.setCargo(usuario.getCargo());
			solicitud.setDespacho_usuario(usuario.getDespacho());
			solicitud.setArchivo_hoja_vida(usuario.getArchivo_hoja_vida());
			solicitud.setArchivo_declaracion_renta(usuario.getArchivo_declaracion_renta());
			solicitud.setArchivo_formulario_bienes(usuario.getArchivo_formulario_bienes());
			solicitud.setFecha_publicacion(new Date());
			solicitud.setEstatus("PUBLICADO");
			solicitud.setAnhio_publicacion(ano.getAnhio());
			solicitud.setRetirado(retiro);
			try {
				usuario.setRetirado(retiro);
				solicitud = publicacionesLocalServiceUtil.addpublicaciones(solicitud);
				usuario_dataLocalServiceUtil.updateusuario_data(usuario);
				audi.setLog_anterior(String.valueOf(solicitud.getId()));
				auditoriaLocalServiceUtil.addauditoria(audi);
				SessionMessages.add(actionRequest, "generoSolicitud");
				actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
			} catch (SystemException e) {
				e.printStackTrace();
				SessionErrors.add(actionRequest, "noGeneroSolicitud");
				actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/solicitarPublicacion.jsp");
			}
			
		}else{
			try {
				publicaciones publicacionModifico = publicacionesLocalServiceUtil.getpublicaciones(validarModificacion);
				publicacionModifico.setFecha_modificado(new Date());
				publicacionModifico.setEstatus("ACTUALIZADO");
				publicacionesLocalServiceUtil.updatepublicaciones(publicacionModifico);
				audi.setLog_anterior(String.valueOf(publicacionModifico.getId()));
				
				publicaciones solicitud = publicacionesLocalServiceUtil.createpublicaciones(0L);
				solicitud.setFk_usuario(usuario.getNumeroDocumento());
				solicitud.setDespacho_usuario(usuario.getDespacho());
				solicitud.setCargo(usuario.getCargo());
				solicitud.setArchivo_hoja_vida(usuario.getArchivo_hoja_vida());
				solicitud.setArchivo_declaracion_renta(usuario.getArchivo_declaracion_renta());
				solicitud.setArchivo_formulario_bienes(usuario.getArchivo_formulario_bienes());
				solicitud.setFecha_publicacion(new Date());
				solicitud.setEstatus("PUBLICADO");
				solicitud.setAnhio_publicacion(ano.getAnhio());
				solicitud.setRetirado(retiro);
				usuario.setRetirado(retiro);
				solicitud = publicacionesLocalServiceUtil.addpublicaciones(solicitud);
				usuario_dataLocalServiceUtil.updateusuario_data(usuario);
				audi.setLog_nuevo(String.valueOf(solicitud.getId()));
				auditoriaLocalServiceUtil.addauditoria(audi);
				SessionMessages.add(actionRequest, "generoSolicitud");
				actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
			} catch (PortalException | SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				SessionErrors.add(actionRequest, "noGeneroSolicitud");
				actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/solicitarPublicacion.jsp");
			}
		}
	}

	public void generarHojaVida(ActionRequest actionRequest, ActionResponse actionResponse) {
//		long editorId = (long) actionRequest.getPortletSession().getAttribute("editorId");
		editores editor = null;
		try {
			editor = editoresLocalServiceUtil.getPorUserid(actionRequest.getRemoteUser());
		} catch (PortalException | SystemException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/funcionario.jsp");
		}
		
		planificacion ano = new planificacionClp();
		try {
			ano = planificacionLocalServiceUtil.PorEstado("ACTIVO");
		} catch (SystemException e1) {}	
		
//		String usuarioId = (String) actionRequest.getPortletSession().getAttribute("usuarioId");
		usuario_data usuario = null;
		try {
			usuario = usuario_dataLocalServiceUtil.getusuario_data(editor.getNumero_documento_edita());
		} catch (PortalException | SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		usuario_data usuario = null;
//		try {
//			usuario = usuario_dataLocalServiceUtil.getusuario_data("19597869");
//			usuario = usuario_dataLocalServiceUtil.getusuario_data("1234567");
//		} catch (PortalException | SystemException e1) {}
		
		
		
		String servidor = actionRequest.getServerName();
		String fecha = formatoNombreArchivos.format(new Date());
		String cedula = usuario.getNumeroDocumento();
//		String rutaHojaVida = "C:/ley_transparencia/"+cedula+"-"+fecha+"-hoja_vida.pdf";
//		String rutaLogo = "C:/ley_transparencia/logo.jpeg";
//		String rutaQr = "C:/ley_transparencia/"+cedula+"-"+fecha+"-QR.png";
		
		String rutaHojaVida = "//csjportalrep01/portal_repository/ley-transparencia/"+cedula+"-"+fecha+"-hoja_vida.pdf";
		String rutaLogo = "//csjportalrep01/portal_repository/ley-transparencia/logo.jpeg";
		String rutaQr = "//csjportalrep01/portal_repository/ley-transparencia/"+cedula+"-"+fecha+"-QR.png";
		
//		String rutaHojaVida = "//172.28.146.22/h/portal_repository_pruebas/ley-transparencia/"+cedula+"-"+fecha+"-hoja_vida.pdf";
//		String rutaLogo = "//172.28.146.22/h/portal_repository_pruebas/ley-transparencia/logo.jpeg";
//		String rutaQr = "//172.28.146.22/h/portal_repository_pruebas/ley-transparencia/"+cedula+"-"+fecha+"-QR.png";
		
		boolean banderaQr = UtilidadesPdf.generarQR(rutaQr,rutaHojaVida,servidor);
		
		if(banderaQr){
			try {
				PdfWriter pw = new PdfWriter(rutaHojaVida);
				PdfDocument pdfDocument = new PdfDocument(pw);
				Document doc = new Document(pdfDocument,PageSize.LETTER);
				doc.setMargins(115, 20, 40, 20);
				
				Image imgLogo = null;
				Image imgQr = null;
				try {
					imgLogo = new Image(ImageDataFactory.create(rutaLogo));
					imgQr = new Image(ImageDataFactory.create(rutaQr));
				} catch (MalformedURLException e) {}
				pdfDocument.addEventHandler(PdfDocumentEvent.START_PAGE	, new HeaderEventHandler(imgLogo,imgQr));
				
				
				doc.add(UtilidadesPdf.getTablaDatosPersonales(usuario));
				doc.add(new Paragraph("\n"));
				doc.add(UtilidadesPdf.getTablaFormacionAcademica(usuario));
				doc.add(new Paragraph("\n"));
				doc.add(UtilidadesPdf.getTablaExperienciaLaboral(usuario));
				doc.add(new Paragraph("\n"));
				doc.add(UtilidadesPdf.getTablaTiempoTotal(usuario));
				doc.add(new Paragraph("\n"));
				doc.add(UtilidadesPdf.getBienesRentas(usuario));
				doc.add(new Paragraph("\n"));
				doc.add(UtilidadesPdf.getInformacionComplementaria(usuario));
				doc.add(new Paragraph("\n"));
				doc.add(UtilidadesPdf.getConflictoIntereses(usuario));
				doc.add(new Paragraph("\n"));
				
				
				doc.close();
				UtilidadesPdf.eliminarQr(rutaQr);
				
				String anterior = usuario.getArchivo_hoja_vida();
				
				auditoria audi = auditoriaLocalServiceUtil.createauditoria(0L);
				try {
					audi.setModificado_por(UserLocalServiceUtil.getUser(Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
				} catch (NumberFormatException | PortalException
						| SystemException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(anterior.isEmpty()){
					audi.setAccion("Creación");
				}else{
					audi.setAccion("Modificación");
				}
				audi.setCampo_modifico("Generar Hoja de Vida");
				audi.setFecha(new Date());
				audi.setAno_vigencia(ano.getAnhio());
				audi.setCedula_funcionario(usuario.getNumeroDocumento());
				audi.setLog_anterior(anterior);
				audi.setLog_nuevo(rutaHojaVida);
				
				usuario.setArchivo_hoja_vida(rutaHojaVida);
				try {
					usuario_dataLocalServiceUtil.updateusuario_data(usuario);
//					auditoriaLocalServiceUtil.addauditoria(audi);
//					actionRequest.getPortletSession().setAttribute("usuarioId", usuario.getNumeroDocumento());
					SessionMessages.add(actionRequest, "generoHojaVida");
					actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/generarHojaVida.jsp");
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					SessionErrors.add(actionRequest, "noGeneroHojaVida");
					actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/generarHojaVida.jsp");
				}
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				SessionErrors.add(actionRequest, "noGeneroHojaVida");
				actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/generarHojaVida.jsp");
			}
		}
		
	}

	public class HeaderEventHandler implements IEventHandler{

		Image ImgLogo;
		Image ImgQr;
		public HeaderEventHandler( Image imgLogo, Image imgQr){
			ImgLogo = imgLogo;
			ImgQr = imgQr;
		}
		
		@Override
		public void handleEvent(Event arg0) {

			PdfDocumentEvent docEvent = (PdfDocumentEvent)arg0;
			PdfDocument pdfDoc = docEvent.getDocument();
			PdfPage page = docEvent.getPage();
			
			Rectangle rootArea = new Rectangle(20 ,page.getPageSize().getTop() - 115 ,page.getPageSize().getRight() - 40, 115);
			PdfCanvas pdfCanvas = new PdfCanvas(page);
			Canvas canvas = new Canvas(pdfCanvas, pdfDoc, rootArea);
			
			try {
				canvas.add(getCabecera(docEvent)).close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public Table getCabecera(PdfDocumentEvent docEvent) throws IOException{
			float [] cellWidth = {25f, 50f, 10f, 15f};
			Table tableEvent = new Table(UnitValue.createPercentArray(cellWidth)).useAllAvailableWidth();
			
			Style styleCell = new Style().setBorder(Border.NO_BORDER);
			Style styleText = new Style().setTextAlignment(TextAlignment.CENTER).setFontSize(10f);
			
			Cell cell = new Cell().add(ImgLogo.setAutoScale(true))
					.setVerticalAlignment(VerticalAlignment.MIDDLE)
					.addStyle(styleCell);
			
			tableEvent.addCell(cell);
			
			PdfFont bold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
			
			cell = new Cell().add(new Paragraph("Rama Judicial del Poder Publico\n").setFont(bold))
					.add(new Paragraph("Consejo Superior de la Judicatura\n").setFont(bold))
					.add(new Paragraph("\nFORMATO DE HOJA DE VIDA").setFont(bold))
					.addStyle(styleText).addStyle(styleCell)
					.setVerticalAlignment(VerticalAlignment.MIDDLE);
			
			tableEvent.addCell(cell);
			
			cell = new Cell().addStyle(styleCell);
			tableEvent.addCell(cell);
			
			cell = new Cell().add(ImgQr.setAutoScale(true))
					.addStyle(styleCell)
					.setVerticalAlignment(VerticalAlignment.MIDDLE);
			
			tableEvent.addCell(cell);
			
			return tableEvent;
		}
		
	}

	public double redondear(double numero, int digitos) {
        double resultado;
        resultado = numero * Math.pow(10, digitos);
        resultado = Math.round(resultado);
        resultado = resultado/Math.pow(10, digitos);
        return resultado;
    }

	public void irDatosPersonales(ActionRequest actionRequest, ActionResponse actionResponse){
		actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/datosPersonales.jsp");
        SessionMessages.add(actionRequest, "no_tiene");
	}
	
	public void irDeclaracionRenta(ActionRequest actionRequest, ActionResponse actionResponse){
		actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/declaracionRenta.jsp");
        SessionMessages.add(actionRequest, "no_tiene");
	}
	
	public void irFormularioBienes(ActionRequest actionRequest, ActionResponse actionResponse){
		actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/formularioBienes.jsp");
        SessionMessages.add(actionRequest, "no_tiene");
	}
	
	public void irDespachoAsignado(ActionRequest actionRequest, ActionResponse actionResponse){
		actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/despachoAsignado.jsp");
        SessionMessages.add(actionRequest, "no_tiene");
	}
	
	public void irTiempoExperiencia(ActionRequest actionRequest, ActionResponse actionResponse){
		actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/tiempoExperiencia.jsp");
        SessionMessages.add(actionRequest, "no_tiene");
	}
	
	public void irFormacionAcademica(ActionRequest actionRequest, ActionResponse actionResponse){
		actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/formacionAcademica.jsp");
        SessionMessages.add(actionRequest, "no_tiene");
	}
	
	public void irExperienciaLaboral(ActionRequest actionRequest, ActionResponse actionResponse){
		actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/experienciaLaboral.jsp");
        SessionMessages.add(actionRequest, "no_tiene");
	}
	
	public void irGenerarHojaVida(ActionRequest actionRequest, ActionResponse actionResponse){
		actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/generarHojaVida.jsp");
        SessionMessages.add(actionRequest, "no_tiene");
	}
	
	public void irSolicitarPublicacion(ActionRequest actionRequest, ActionResponse actionResponse){
		actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/solicitarPublicacion.jsp");
        SessionMessages.add(actionRequest, "no_tiene");
	}
	
	public void irInicio(ActionRequest actionRequest, ActionResponse actionResponse){
		actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/principal.jsp");
        SessionMessages.add(actionRequest, "no_tiene");
	}
	
	public void irBienesYRentas(ActionRequest actionRequest, ActionResponse actionResponse){
		actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/bienesYRentas.jsp");
        SessionMessages.add(actionRequest, "no_tiene");
	}
	
	public void irInformacionComplementaria(ActionRequest actionRequest, ActionResponse actionResponse){
		actionResponse.setRenderParameter("mvcPath", "/html/formulario_publico/InformacionComplementaria.jsp");
        SessionMessages.add(actionRequest, "no_tiene");
	}

	public String cleanString(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return texto;
    }
	
	
}
<%@page import="com.co.csj.service.service.planificacionLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.planificacion"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.co.csj.service.service.usuario_dataLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.usuario_data"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="java.util.List"%>
<%@page import="com.co.csj.service.service.publicacionesLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.publicaciones"%>
<%@ include file="/html/init-panel-control.jsp"%>

<%
	planificacion anhio = planificacionLocalServiceUtil.PorEstado("ACTIVO");
	List<publicaciones> solicitudes = publicacionesLocalServiceUtil.getPorEstadoSolicitudes("PUBLICADO",anhio.getAnhio());
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/administracion/solicitudesAprobadas.jsp"/>
</liferay-portlet:renderURL>

<div class="container-fluid">
	<liferay-ui:success key="solicitudAprobada" message="Solicitud aprobada exitosamente" />
	<liferay-ui:error key="errorAprobando" message="Error aprobando la solicitud" />
	<liferay-ui:success key="solicitudNegada" message="Solicitud negada exitosamente" />
	<liferay-ui:error key="errorAprobando" message="Error negando la solicitud" />
	<div style="display: inline-block; vertical-align: top; width: 14%; min-height: 430px">
		<jsp:include page="/html/administracion/menu.jsp"></jsp:include>
	</div>
	<div style="display: inline-block; vertical-align: top; width: 85%;">
		<div class="container-fluid">
			<div class="row text-center">
				<h2>PUBLICACIONES ACTIVAS</h2>
				<h3>Año en curso <%= anhio.getAnhio() %></h3>
			</div>
			<div class="row">
				<div class="col-md-12">
					<liferay-ui:search-container   delta="10" deltaConfigurable="true"  emptyResultsMessage="No hay Solicitudes" iteratorURL="<%=iteratorURL%>">
			    			<liferay-ui:search-container-results>
			        			<%				
								 	String keywords = ParamUtil.getString(request, "keywords");		
									results = ListUtil.subList(solicitudes, searchContainer.getStart(), searchContainer.getEnd());
									total = solicitudes.size();
									searchContainer.setTotal(solicitudes.size());
									pageContext.setAttribute("results", results);
									pageContext.setAttribute("total", total);			
								%>
			    			</liferay-ui:search-container-results>    
							<liferay-ui:search-container-row className="com.co.csj.service.model.publicaciones" keyProperty="id" modelVar="sol">
								<%
									usuario_data usuario = usuario_dataLocalServiceUtil.getusuario_data(sol.getFk_usuario());
									JSONObject datos_personales = JSONFactoryUtil.createJSONObject(usuario.getDatos_personales());
									String nombre = usuario.getNombres()+" "+usuario.getApellidos();
									nombre = nombre.replace("  ", " ");
								%>          	
							    <liferay-ui:search-container-column-text name="Funcionario" 		value="<%=nombre  %>"/>
							    <liferay-ui:search-container-column-text name="Código Despacho" 		value="<%=sol.getDespacho_usuario()  %>"/>
					       		<liferay-ui:search-container-column-text name="Fecha Aprobada" 		value="<%=formato.format(sol.getFecha_publicacion())  %>"/>
					       		<%
							    	String archivos = 	"<a href='?p_p_id=administracion_WAR_ley_transparenciaportlet&p_p_lifecycle=2&p_p_state=maximized&p_p_mode=view&p_p_cacheability=cacheLevelPage&doAsGroupId=19&refererPlid=10169&pagina=obtenerArchivo&id="+sol.getId()+"&archivo_solicitado=hoja_vida' target='_blank'>Hoja de Vida</a><br>"+
							    						"<a href='?p_p_id=administracion_WAR_ley_transparenciaportlet&p_p_lifecycle=2&p_p_state=maximized&p_p_mode=view&p_p_cacheability=cacheLevelPage&doAsGroupId=19&refererPlid=10169&pagina=obtenerArchivo&id="+sol.getId()+"&archivo_solicitado=declaracion_renta' target='_blank'>Declaración de Renta</a><br>"+
							    						"<a href='?p_p_id=administracion_WAR_ley_transparenciaportlet&p_p_lifecycle=2&p_p_state=maximized&p_p_mode=view&p_p_cacheability=cacheLevelPage&doAsGroupId=19&refererPlid=10169&pagina=obtenerArchivo&id="+sol.getId()+"&archivo_solicitado=formulario_bienes' target='_blank'>Formulario de Bienes</a>";
							    %>
							    <liferay-ui:search-container-column-text name="Archivos" 				value="<%=archivos  %>"/>		     
					  		</liferay-ui:search-container-row>
				  			<liferay-ui:search-iterator />
						</liferay-ui:search-container>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
$('#collapse1').addClass("in");
$('#solicitudesAprobadas').addClass("active");
</script>
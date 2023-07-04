<%@page import="com.co.csj.service.model.editores"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.co.csj.registro.consultas"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file="/html/init-panel-control.jsp"%>

<%
	List<editores> usuariosEditores = new ArrayList<editores>();
	String cedula = "";
	String correo = "";
	String nombres = "";
	
	if(renderRequest.getPortletSession().getAttribute("correoR")!=null)
		correo = (String) renderRequest.getPortletSession().getAttribute("correoR"); 
	if(renderRequest.getPortletSession().getAttribute("cedulaR")!=null)
		cedula = (String) renderRequest.getPortletSession().getAttribute("cedulaR");
	if(renderRequest.getPortletSession().getAttribute("nombresR")!=null)
		nombres = (String) renderRequest.getPortletSession().getAttribute("nombresR");
	
	usuariosEditores = consultas.getBusquedaEditores(correo, cedula, nombres);
%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/administracion/funcionarios.jsp"/>
</liferay-portlet:renderURL>

<portlet:actionURL var="buscarFuncionarioR" name="buscarFuncionarioR"></portlet:actionURL>

<portlet:renderURL var="agregar">
	<portlet:param name="mvcPath" value="/html/administracion/nuevoFuncionario.jsp"/>
</portlet:renderURL>

<div class="container-fluid">

	<div style="display: inline-block; vertical-align: top; width: 14%; min-height: 430px">
		<jsp:include page="/html/administracion/menu.jsp"></jsp:include>
	</div>
	<div style="display: inline-block; vertical-align: top; width: 85%;">
		<liferay-ui:error key="errorModificarFuncionarioR" message="Error al modificar el despacho del funcionario"></liferay-ui:error>
		<liferay-ui:success key="okModificarFuncionarioR" message="Despacho del funcionario modificado correctamente"></liferay-ui:success>
		<div class="container-fluid">
			<div class="row text-center">
				<h2>FUNCIONARIOS REGISTRADOS</h2>
			</div>
			<br>
			<form action="<%=buscarFuncionarioR %>" method="post">
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label for="accion">Correo</label>
							<input name="correo" class="anchoCompleto select-option inputsPanel" value="<%= correo %>" >
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="campo">Numero Documento</label>
							<input name="cedula" class="anchoCompleto select-option inputsPanel" value="<%= cedula%>">
						</div>
					</div>		
					<div class="col-md-4">
						<div class="form-group">
							<label for="campo">Nombres</label>
							<input name="nombres" class="anchoCompleto select-option inputsPanel" value="<%= nombres%>">
						</div>
					</div>			
					<div class="col-md-12 text-center">
						<button type="submit" class="btn " >Buscar</button>
					</div>				
				</div>
			</form>
			<br>
			<div class="row">
				<div class="col-md-12">
					<liferay-ui:search-container   delta="10" deltaConfigurable="true"  emptyResultsMessage="No hay registros o no ha realizado una busqueda" iteratorURL="<%=iteratorURL%>">
			    			<liferay-ui:search-container-results>
			        			<%				
								 	String keywords = ParamUtil.getString(request, "keywords");		
									results = ListUtil.subList(usuariosEditores, searchContainer.getStart(), searchContainer.getEnd());
									total = usuariosEditores.size();
									searchContainer.setTotal(usuariosEditores.size());
									pageContext.setAttribute("results", results);
									pageContext.setAttribute("total", total);			
								%>
			    			</liferay-ui:search-container-results>    
							<liferay-ui:search-container-row className="com.co.csj.service.model.editores" keyProperty="id" modelVar="edit">
								         	
							    <liferay-ui:search-container-column-text name="Correo" 		value="<%=edit.getCorreo()  %>"/>
							    <liferay-ui:search-container-column-text name="Numero Documento" 		value="<%=edit.getNumero_documento_edita() %>"/>
							    <% String nombress = edit.getNombres_edita()+" "+edit.getApellidos_edita(); %>
							    <liferay-ui:search-container-column-text name="Nombres" 		value="<%=nombress %>"/>
					       		<liferay-ui:search-container-column-text name="Cargo" 		value="<%=edit.getCargo_edita()  %>"/>
					       		<liferay-ui:search-container-column-text name="Despacho" 		value="<%=edit.getDespacho_edita()  %>"/>
					       		<liferay-ui:search-container-column-jsp  name="Modificar" 	path="/html/administracion/actionFuncionarioR.jsp"></liferay-ui:search-container-column-jsp>		     
					  		</liferay-ui:search-container-row>
				  			<liferay-ui:search-iterator />
						</liferay-ui:search-container>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
$('#collapse0').addClass("in");
$('#funcionariosR').addClass("active");


function ir(){
	location.href ='<%=agregar %>';
}
</script>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.co.csj.registro.consultas"%>
<%@page import="com.co.csj.service.model.correos"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file="/html/init-panel-control.jsp"%>

<%
	List<correos> Correos = new ArrayList<correos>();
	String cedula = "";
	String correo = "";
	
	if(renderRequest.getPortletSession().getAttribute("correo")!=null)
		correo = (String) renderRequest.getPortletSession().getAttribute("correo"); 
	if(renderRequest.getPortletSession().getAttribute("cedula")!=null)
		cedula = (String) renderRequest.getPortletSession().getAttribute("cedula");
	
	Correos = consultas.getBusquedaFuncionarios(correo, cedula);
%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/administracion/funcionarios.jsp"/>
</liferay-portlet:renderURL>

<portlet:actionURL var="buscarFuncionario" name="buscarFuncionario"></portlet:actionURL>

<portlet:renderURL var="agregar">
	<portlet:param name="mvcPath" value="/html/administracion/nuevoFuncionario.jsp"/>
</portlet:renderURL>

<div class="container-fluid">

	<div style="display: inline-block; vertical-align: top; width: 14%; min-height: 430px">
		<jsp:include page="/html/administracion/menu.jsp"></jsp:include>
	</div>
	<div style="display: inline-block; vertical-align: top; width: 85%;">
		<liferay-ui:error key="errorCrearFuncionario" message="Error al registrar al funcionario el correo electronico o el numero de documento ya existen en la base de datos"></liferay-ui:error>
		<liferay-ui:error key="errorModificarFuncionario" message="Error al modificar al funcionario el correo electronico o el numero de documento ya existen en la base de datos"></liferay-ui:error>
		<liferay-ui:success key="okCrearFuncionario" message="Funcionario registrado correctamente"></liferay-ui:success>
		<liferay-ui:success key="okModificarFuncionario" message="Funcionario modificado correctamente"></liferay-ui:success>
		<div class="container-fluid">
			<div class="row text-center">
				<h2>FUNCIONARIOS SIN REGISTRAR</h2>
			</div>
			<br>
			<div class="row">
				<div class="col-md-12">
					<button class="btn" type="button" onclick="ir()">Agregar nuevo funcionario</button>
				</div>
			</div>
			<br>
			<form action="<%=buscarFuncionario %>" method="post">
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label for="accion">Correo</label>
							<input name="correo" class="anchoCompleto select-option inputsPanel" value="<%=correo %>" >
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="campo">Numero Documento</label>
							<input name="cedula" class="anchoCompleto select-option inputsPanel" value="<%= cedula %>" >
						</div>
					</div>					
					<div class="col-md-2 text-center">
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
									results = ListUtil.subList(Correos, searchContainer.getStart(), searchContainer.getEnd());
									total = Correos.size();
									searchContainer.setTotal(Correos.size());
									pageContext.setAttribute("results", results);
									pageContext.setAttribute("total", total);			
								%>
			    			</liferay-ui:search-container-results>    
							<liferay-ui:search-container-row className="com.co.csj.service.model.correos" keyProperty="id" modelVar="corre">
								         	
							    <liferay-ui:search-container-column-text name="Correo" 		value="<%=corre.getCuentaCorreo()  %>"/>
							    <liferay-ui:search-container-column-text name="Numero Documento" 		value="<%=corre.getCedulaResponsable() %>"/>
							    <% String nombres = corre.getNombre1()+" "+corre.getApellido(); %>
							    <liferay-ui:search-container-column-text name="Nombres" 		value="<%=nombres %>"/>
					       		<liferay-ui:search-container-column-text name="Cargo" 		value="<%=corre.getCargo()  %>"/>
					       		<liferay-ui:search-container-column-text name="Despacho" 		value="<%=corre.getCodigoDespacho()  %>"/>
					       		<liferay-ui:search-container-column-jsp  name="Modificar" 	path="/html/administracion/actionFuncionario.jsp"></liferay-ui:search-container-column-jsp>		     
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
$('#funcionarios').addClass("active");


function ir(){
	location.href ='<%=agregar %>';
}
</script>
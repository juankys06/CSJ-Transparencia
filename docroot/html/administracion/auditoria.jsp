<%@page import="com.co.csj.registro.consultas"%>
<%@page import="com.co.csj.registro.modeloBasico"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.co.csj.service.service.auditoriaLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.auditoria"%>
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
	List<auditoria> auditoria = new ArrayList<auditoria>();
	if(renderRequest.getPortletSession().getAttribute("auditoria")!=null){
		auditoria = (List<auditoria>) renderRequest.getPortletSession().getAttribute("auditoria"); 
	}
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
	List<modeloBasico> acciones = consultas.getAcciones();
	List<modeloBasico> campos = consultas.getCampos();
	List<modeloBasico> anos = consultas.getAnosVigencia();
%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/administracion/auditoria.jsp"/>
</liferay-portlet:renderURL>

<portlet:actionURL var="buscarAudi" name="buscarAuditoria"></portlet:actionURL>

<div class="container-fluid">

	<div style="display: inline-block; vertical-align: top; width: 14%; min-height: 430px">
		<jsp:include page="/html/administracion/menu.jsp"></jsp:include>
	</div>
	<div style="display: inline-block; vertical-align: top; width: 85%;">
		<div class="container-fluid">
			<div class="row text-center">
				<h2>AUDITORIA</h2>
			</div>
			<br>
			<form action="<%=buscarAudi %>" method="post">
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<label for="accion">Acción</label>
							<select name="accion" class="anchoCompleto select-option inputsPanel" >
								<option value="">Seleccione</option>
								<% for(modeloBasico m : acciones){ %>
									<option value="<%=m.getNombre() %>"><%=m.getNombre() %></option>
								<% } %>
							</select>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label for="campo">Campo</label>
							<select name="campo" class="anchoCompleto select-option inputsPanel" >
								<option value="">Seleccione</option>
								<% for(modeloBasico m : campos){ %>
									<option value="<%=m.getNombre() %>"><%=m.getNombre() %></option>
								<% } %>
							</select>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label for="fechaI">Fecha de Inicio</label>
							<input type="date" name="fechaI" class="anchoCompleto select-option inputsPanel" >
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label for="fechaF">Fecha de Fin</label>
							<input type="date" name="fechaF" class="anchoCompleto select-option inputsPanel" >
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<label for="cedula">Cedula</label>
							<input type="text" class="anchoCompleto select-option" style="border: none; border-radius: 0px; box-shadow: none;" name="cedula" pattern="\d*" placeholder="123456789" >
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label for="ano">Año de Vigencia</label>
							<select name="ano" class="anchoCompleto select-option inputsPanel" >
								<option value="">Seleccione</option>
								<% for(modeloBasico m : anos){ %>
									<option value="<%=m.getNombre() %>"><%=m.getNombre() %></option>
								<% } %>
							</select>
						</div>
					</div>
					<div class="col-md-6 text-center">
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
									results = ListUtil.subList(auditoria, searchContainer.getStart(), searchContainer.getEnd());
									total = auditoria.size();
									searchContainer.setTotal(auditoria.size());
									pageContext.setAttribute("results", results);
									pageContext.setAttribute("total", total);			
								%>
			    			</liferay-ui:search-container-results>    
							<liferay-ui:search-container-row className="com.co.csj.service.model.auditoria" keyProperty="id" modelVar="audi">
								         	
							    <liferay-ui:search-container-column-text name="Acción" 		value="<%=audi.getAccion()  %>"/>
							    <liferay-ui:search-container-column-text name="Campo" 		value="<%=audi.getCampo_modifico() %>"/>
					       		<liferay-ui:search-container-column-text name="Fecha" 		value="<%=formato.format(audi.getFecha())  %>"/>
					       		<%
					       			String ano = "";
					       			if(audi.getAno_vigencia()!=0)
					       				ano = String.valueOf(audi.getAno_vigencia());
					       		%>
					       		<liferay-ui:search-container-column-text name="Año de vigencia" 		value="<%=ano  %>"/>
					       		<%
					       			String CN = "";
					       			if( !audi.getCedula_funcionario().isEmpty() ){
					       				CN += audi.getCedula_funcionario();
					       				usuario_data usu = usuario_dataLocalServiceUtil.getusuario_data(audi.getCedula_funcionario());
					       				if(usu != null){
					       					CN += " / "+usu.getNombres()+" "+usu.getApellidos();
					       				}
					       			}
					       			if( audi.getCampo_modifico().equals("Funcionario sin registrar") ){
					       				JSONObject json = JSONFactoryUtil.createJSONObject(audi.getLog_nuevo());
					       				CN = json.getString("numero_documento")+" / "+json.getString("nombres")+" "+json.getString("apellidos");
					       			}
					       		%>
					       		<liferay-ui:search-container-column-text name="Cedula y nombres del funcionario" 				value="<%=CN  %>"/>
					       		<liferay-ui:search-container-column-jsp  name="Detalle de cambio" 	path="/html/administracion/actionAuditoria.jsp"></liferay-ui:search-container-column-jsp>		     
					  		</liferay-ui:search-container-row>
				  			<liferay-ui:search-iterator />
						</liferay-ui:search-container>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
$('#collapse4').addClass("in");
$('#auditoria').addClass("active");
</script>
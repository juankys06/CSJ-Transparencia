<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.co.csj.service.service.usuario_dataLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.usuario_data"%>
<%@page import="com.co.csj.service.service.editoresLocalServiceUtil"%>
<%@page import="com.co.csj.service.model.impl.editoresImpl"%>
<%@page import="com.co.csj.service.model.editores"%>
<%@page import="com.co.csj.registro.modeloBasico"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.co.csj.registro.consultas"%>
<%@page import="com.co.csj.service.model.correos"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file="/html/init-panel-control.jsp"%>

<%
	editores edit = new editoresImpl();
	String id = (String) renderRequest.getAttribute("id");
	if(id != null){
		edit = editoresLocalServiceUtil.geteditores(Long.parseLong(id));
	}
	
	List<modeloBasico> users = consultas.getUsuariosDisponiblesCambio();
	List<modeloBasico> depa = consultas.getDepartamentos();
	List<modeloBasico> enti = consultas.getEntidad();
	List<modeloBasico> espe = consultas.getEspecialidad();
	List<modeloBasico> muni = new ArrayList<modeloBasico>();
	List<modeloBasico> despa = new ArrayList<modeloBasico>();
	String departamento = "";
	String municipio = "";
	String entidad = "";
	String especialidad = "";
	if(edit.getCorreo().length()>10){
		if(edit.getDespacho_edita().length()==12){
			departamento = edit.getDespacho_edita().substring(0, 2);
			municipio = edit.getDespacho_edita().substring(0, 5);
			entidad = edit.getDespacho_edita().substring(5, 7);
			especialidad = edit.getDespacho_edita().substring(7, 9);
			muni = consultas.getMunicipios(departamento);
			despa = consultas.getDespachos(municipio, entidad, especialidad);
		}		
	}
	User u = null;
	String correoU = "Usuario eliminado del portal";
	try{
		u = UserLocalServiceUtil.getUser(Long.parseLong(edit.getUserid()));
	}catch(Exception e){}
	if(u!=null)
		correoU=u.getEmailAddress();
	
%>

<portlet:actionURL var="editarFuncionarioR" name="editarFuncionarioR"></portlet:actionURL>
<portlet:actionURL var="editarUsuarioFuncionarioR" name="editarUsuarioFuncionarioR"></portlet:actionURL>

<div class="container-fluid">

	<div style="display: inline-block; vertical-align: top; width: 14%; min-height: 430px">
		<jsp:include page="/html/administracion/menu.jsp"></jsp:include>
	</div>
	<div style="display: inline-block; vertical-align: top; width: 85%;">
		<div class="container-fluid">
			<div class="row text-center">
				<h2>FUNCIONARIOS REGISTRADOS</h2>
				<h3>Modificar despacho</h3>
			</div>
			<br>
			<form action="<%=editarFuncionarioR %>" method="post">
				<div class="row">
					<input type="hidden" name="id" value="<%=id%>">
					<div class="col-md-4">
						<div class="form-group">
							<label for="accion">Correo</label>
							<div><%=correoU %></div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="campo">Numero Documento</label>
							<div><%=edit.getNumero_documento_edita() %></div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="campo">Cargo</label>
							<div><%=edit.getCargo_edita() %></div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="campo">Nombres</label>
							<div><%=edit.getNombres_edita() %></div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="campo">Apellidos</label>
							<div><%=edit.getApellidos_edita() %></div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="campo">Código Despacho</label>
							<input name="codigoDespacho" id="codigoDespacho" class="anchoCompleto select-option inputsPanel" readonly="readonly" required="required">
						</div>
					</div>					
					<div class="col-md-12 text-center">
						<button type="submit" class="btn " ><%=id==null?"Agregar":"Modificar" %></button>
					</div>				
				</div>
				<br>
				<div class="row">
					<div class="col-md-12">
						<p>Para agregar el código de despacho a los datos del funcionario debe seleccionar el despacho desde los siguientes filtros</p>
					</div>
					<div class="form-group col-md-4">
						<label for="departamento" >Departamento:</label>
		      			<select class="anchoCompleto select-option inputsPanel" name="departamento" id="departamento" onchange="municipiofiltro()">
		      				<option value="">Seleccione un departamento</option>
		      				<% for(modeloBasico m : depa){ 
		      					if(departamento.equalsIgnoreCase(m.getCodigo())){
		      				%>
		      					<option value="<%=m.getCodigo() %>" selected="selected"><%=m.getNombre() %></option>
		      				<%	}else{ %>
		      					<option value="<%=m.getCodigo() %>"><%=m.getNombre() %></option>
		      				<% }} %>
		      			</select>
					</div>
					<div class="form-group col-md-4">
						<label for="municipio" >Municipio:</label>
			    		<select class="anchoCompleto select-option inputsPanel" name="municipio" id="municipio" onchange="despachofiltro()">
			      			<option value="">Seleccione un municipio</option>
			      			<% for(modeloBasico m : muni){ 
		      					if(municipio.equalsIgnoreCase(m.getCodigo())){
		      				%>
		      					<option value="<%=m.getCodigo() %>" selected="selected"><%=m.getNombre() %></option>
		      				<%	}else{ %>
		      					<option value="<%=m.getCodigo() %>"><%=m.getNombre() %></option>
		      				<% }} %>
			      		</select>
					</div>
					<div class="form-group col-md-4">
						<label for="entidad" >Entidad:</label>
		      			<select class="anchoCompleto select-option inputsPanel" name="entidad" id="entidad" onchange="despachofiltro()">
		      				<option value="">Seleccione una entidad</option>
		      				<% for(modeloBasico m : enti){ 
		      					if(entidad.equalsIgnoreCase(m.getCodigo())){
		      				%>
		      					<option value="<%=m.getCodigo() %>" selected="selected"><%=m.getNombre() %></option>
		      				<%	}else{ %>
		      					<option value="<%=m.getCodigo() %>"><%=m.getNombre() %></option>
		      				<% }} %>
		      			</select>
		      		</div>
		      		<div class="form-group col-md-4">
			    		<label for="especialidad" >Especialidad:</label>
		      			<select class="anchoCompleto select-option inputsPanel" name="especialidad" id="especialidad" onchange="despachofiltro()">
		      				<option value="">Seleccione una especialidad</option>
		      				<% for(modeloBasico m : espe){ 
			      				if(especialidad.equalsIgnoreCase(m.getCodigo())){
		      				%>
		      					<option value="<%=m.getCodigo() %>" selected="selected"><%=m.getNombre() %></option>
		      				<%	}else{ %>
		      					<option value="<%=m.getCodigo() %>"><%=m.getNombre() %></option>
		      				<% }} %>
		      			</select>
		      		</div>
		      		<div class="form-group col-md-4">
			    		<label for="despacho" >Despacho:</label>
		      			<select class="anchoCompleto select-option inputsPanel" name="despacho" id="despacho" required="required" onchange="agregarCodigoDespacho()">
		      				<option value="">Seleccione un Despacho</option>
		      				<% for(modeloBasico m : despa){ 
		      					if(edit.getDespacho_edita().equalsIgnoreCase(m.getCodigo())){
		      				%>
		      					<option value="<%=m.getCodigo() %>" selected="selected"><%=m.getNombre() %></option>
		      				<%	}else{ %>
		      					<option value="<%=m.getCodigo() %>"><%=m.getNombre() %></option>
		      				<% }} %>
		      			</select>
		      		</div>
				</div>
			</form>
			<br>
			<div class="row text-center">
				<h3>Modificar Usuario Asociado</h3>
			</div>
			<br>
			<form action="<%=editarUsuarioFuncionarioR %>" method="post">
				<div class="row">
					<input type="hidden" name="id" value="<%=id%>">
					<div class="col-md-6">
						<div class="form-group">
							<label for="accion">Correo Usuario Actual</label>
							<div><%=correoU %></div>
						</div>
					</div>
					<div class="form-group col-md-6">
						<label for="userNew" >Usuarios disponibles para el cambio:</label>
		      			<select class="anchoCompleto select-option inputsPanel" name="userId" id="userNew">
		      				<option value="">Seleccione un nuevo usuario</option>
		      				<% for(modeloBasico uu : users){ %>
		      					<option value="<%=uu.getCodigo() %>"><%=uu.getNombre() %></option>
		      				<% } %>
		      			</select>
					</div>					
					<div class="col-md-12 text-center">
						<button type="submit" class="btn " ><%=id==null?"Agregar":"Modificar" %></button>
					</div>				
				</div>
			</form>
		</div>
	</div>
</div>

<portlet:resourceURL var="filtro">
	<portlet:param name="pagina" value="despachoAsignado"/>
</portlet:resourceURL>

<script type="text/javascript">
$('#collapse0').addClass("in");
$('#funcionariosR').addClass("active");

function municipiofiltro(){
	var departamento = document.getElementById('departamento').value;

	$.ajax({
		url: '<%=filtro%>',
	    type:  'post',
	    dataType: 'json',
	    data:  {tipo_sol : 2 ,departamento : departamento },
	    success:  function (response) {
	    	var data = response;
	    	$('#municipio').html('');
	    	$('#municipio').append(new Option('Seleccione un municipio', ""));
	    	$.each(data, function(i, des) {
	    		$('#municipio').append(new Option(des.nombre, des.id));
	        });
	    }
	});
	}

	function despachofiltro(){
	var municipio = document.getElementById('municipio').value;
	var entidad = document.getElementById('entidad').value;
	var especialidad = document.getElementById('especialidad').value;

	$.ajax({
		url: '<%=filtro%>',
	    type:  'post',
	    dataType: 'json',
	    data:  {tipo_sol : 1 ,municipio : municipio, entidad : entidad, especialidad : especialidad },
	    success:  function (response) {
	    	var data = response;
	    	$('#despacho').html('');
	    	$('#despacho').append(new Option('Seleccione un Despacho', ""));
	    	$.each(data, function(i, des) {
	    		$('#despacho').append(new Option(des.nombre, des.id));
	        });
	    }
	});
	}

	function agregarCodigoDespacho(){
		document.getElementById('codigoDespacho').value = document.getElementById('despacho').value;
	}
	
	$( document ).ready(function() {
		document.getElementById('codigoDespacho').value = document.getElementById('despacho').value;
	});
	
	$(document).ajaxStart(function() {
	    // show loader on start
	    $('#progreso').show();
	}).ajaxSuccess(function() {
	    // hide loader on success
		$('#progreso').hide();
	}).ajaxError(function() {
	    // hide loader on success
		$('#progreso').hide();
	});

</script>
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

<portlet:resourceURL var="home">
	<portlet:param name="mvcPath" value="/html/administracion/solicitudesDenegadas.jsp"/>
</portlet:resourceURL>

<%
	if(renderRequest.getAttribute("id")!=null){
		String id = (String) renderRequest.getAttribute("id");
%>

<portlet:actionURL name="denegarSolicitud" var="denegarSolicitud">
	<portlet:param name="id" value="<%=id %>"/>
</portlet:actionURL>
<%=id %>
<div class="container-fluid">
	<div style="display: inline-block; vertical-align: top; width: 14%; min-height: 430px">
		<jsp:include page="/html/administracion/menu.jsp"></jsp:include>
	</div>
	<div style="display: inline-block; vertical-align: top; width: 85%;">
		<form action="<%=denegarSolicitud %>" method="post">
			<div class="container-fluid">
				<div class="row text-center">
					<h2>Solicitudes Pendientes</h2>
					<h3><strong>Denegar</strong></h3>
				</div>
				<div class="row">
					<div class="col-md-12 text-center">
						<strong>Causa</strong>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-offset-2 col-md-8">
						<textarea rows="10" style="width: 100%;" name="causa" id="causa" required="required"></textarea>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-offset-2 col-md-8 text-center">
						<button type="submit" class="btn">Denegar</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
$('#collapse1').addClass("in");
$('#solicitudesPendientes').addClass("active");
</script>
<% }else{%>
<script type="text/javascript">
$(document).ready( function(){
	window.location.href = '<%=home%>';
});
</script>
<% }%>
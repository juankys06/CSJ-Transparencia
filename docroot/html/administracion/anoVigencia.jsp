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
	planificacion anoVigente = planificacionLocalServiceUtil.PorEstado("ACTIVO");
%>

<portlet:actionURL name="siguienteAno" var="siguienteAno"/>
<liferay-ui:success key="okPlanificacion" message="Se a cambiado el año de vigencia de los documentos satisfactoriamente"></liferay-ui:success>
<liferay-ui:error key="errorPlanificacion" message="Error cambiando el año de vigencia de los documentos"></liferay-ui:error>
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
				<h2>Planificación de Años</h2>
			</div>
			<form id="planificacionFrom" action="<%= siguienteAno %>" method="post">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center">
						Todas las publicaciones realizadas hasta la fecha son para el año en vigencia
						<br>
						<strong style="color: red; font-size: 16px;"><%=anoVigente.getAnhio() %></strong> 
						<br>
						<br>
						<button type="button" onclick="validar()" class="btn">Siguiente Año de Vigencia</button>
						<br>
						<br>
						Al hacer clic en el botón siguiente año todas las publicaciones hasta la fecha se dejarán de mostrar y de deberá proceder a realizar nuevas publicaciones para el nuevo año de vigencia de los documentos

					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
$('#collapse2').addClass("in");
$('#anoVigencia').addClass("active");

function validar(){
	
	bootbox.confirm({
	    message: 	"<strong style='color: red; font-size: 16px;' >ESTE PROCESO ES IRREBERSIBLE</strong>"+
	    			"<br><br>Esta seguro que desea continuar",
	    buttons: {
	    	cancel: {
	            label: '<i class="fa fa-times"></i> Cancel'
	        },
	        confirm: {
	            label: '<i class="fa fa-check"></i> Continuar'
	        }
	    },
	    callback: function (result) {
	        if(result)
	        	$('#planificacionFrom').submit();
	    }
	});
	
}
</script>
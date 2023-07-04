<%@page import="com.co.csj.service.model.auditoria"%>
<%@page import="com.co.csj.service.model.publicaciones"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/html/init-panel-control.jsp"%>

<%	
	ResultRow row=( ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	auditoria audi= (auditoria)row.getObject();
	String id = String.valueOf(audi.getId());
%>

<liferay-ui:icon-menu>	
	
	<portlet:actionURL  name="irDetalle" var="irDetalle">
	       <portlet:param name="id" value="<%=id%>"/>	    
    </portlet:actionURL>
    <liferay-ui:icon image="page"  message="Detalles" url="<%=irDetalle %>"/>	

</liferay-ui:icon-menu>
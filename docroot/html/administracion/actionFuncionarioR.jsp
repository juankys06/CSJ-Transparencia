<%@page import="com.co.csj.service.model.editores"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/html/init-panel-control.jsp"%>

<%	
	ResultRow row=( ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	editores corr= (editores)row.getObject();
	String id = String.valueOf(corr.getId());
%>

<liferay-ui:icon-menu>	
	
	<portlet:actionURL  name="irModificarFuncionarioR" var="irModificarFuncionarioR">
	       <portlet:param name="id" value="<%=id%>"/>	    
    </portlet:actionURL>
    <liferay-ui:icon image="edit"  message="Modificar" url="<%=irModificarFuncionarioR %>"/>	

</liferay-ui:icon-menu>
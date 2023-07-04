<%@page import="com.co.csj.service.model.publicaciones"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="/html/init.jsp"%>

<%	ResultRow row=( ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	publicaciones publi= (publicaciones)row.getObject();
	String cod=String.valueOf(publi.getId());
%>

<liferay-ui:icon-menu>	
	
	<portlet:actionURL  name="aprobarSolicitud" var="aprobarSolicitud">
	       <portlet:param name="id" value="<%=cod%>"/>	    
    </portlet:actionURL>
    <liferay-ui:icon image="check"  message="Aprobar" url="<%=aprobarSolicitud %>"/>
    
    <portlet:actionURL  name="irDenegarSolicitud" var="irDenegarSolicitud">
	       <portlet:param name="id" value="<%=cod%>"/>	    
    </portlet:actionURL>
    <liferay-ui:icon image="close"  message="Denegar" url="<%=irDenegarSolicitud %>"/>	

</liferay-ui:icon-menu>
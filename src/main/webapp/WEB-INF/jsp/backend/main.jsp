<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@include file="common/header.jsp" %>
<div class="page-title">
	<div class="title_left">
		<h3>
			<h3>
			欢迎你：${userSession.userName }<strong> | 角色：${userSession.data_dictionary.typeName }</strong>
			</h3>
		</h3>
	</div>
</div>
<div class="clearfix"></div>        
<%@include file="common/footer.jsp" %>  
     
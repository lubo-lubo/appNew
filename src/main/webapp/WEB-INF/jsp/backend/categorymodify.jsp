<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>修改app分类信息 <i class="fa fa-user"></i><small>${userSession.userName}</small></h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <div class="clearfix"></div>
                <form class="form-horizontal form-label-left" action="/appcategory/savemodify " method="post">
                    <input type="hidden" name="id" value="${category.id}" />
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="categoryName">类型名称 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="categoryName" class="form-control col-md-7 col-xs-12"
                                   data-validate-length-range="20" data-validate-words="1" name="categoryName"  required="required"
                                   placeholder="${category.categoryName}" type="text">
                        </div>
                    </div>

                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">上级分类 <span class="required"></span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <select id="parentId" name="parentId" class="form-control">
                                <c:if test="${category.parentId==null}">
                                    <option value="" selected="selected">根类型</option>
                                    <c:if test="${categorylist!=null}">
                                        <c:forEach var="cl" items="${categorylist}">
                                            <option value="${cl.id}" <c:if test="${category.parentId==cl.id}"> selected="selected"</c:if>>${cl.categoryName}</option>
                                        </c:forEach>
                                    </c:if>
                                </c:if>
                                <c:if test="${category.parentId!=null}">
                                    <c:if test="${categorylist!=null}">
                                        <option value="">根类型</option>
                                        <c:forEach var="cl" items="${categorylist}">
                                            <option value="${cl.id}" <c:if test="${category.parentId==cl.id}"> selected="selected"</c:if>>${cl.categoryName}</option>
                                        </c:forEach>
                                    </c:if>
                                </c:if>
                            </select>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="categoryCode">类型码 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="categoryCode" class="form-control col-md-7 col-xs-12" name="categoryCode"
                                   data-validate-length-range="20" data-validate-words="1"   required="required"
                                   placeholder="${category.categoryCode}" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                            <a href="/appcategory/savemodify">
                                <button id="send" type="submit" class="btn btn-success">保存</button>
                            </a>
                            <button type="button" class="btn btn-primary" id="back">返回</button>
                            <br/><br/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/categorymodify.js"></script>

</html>


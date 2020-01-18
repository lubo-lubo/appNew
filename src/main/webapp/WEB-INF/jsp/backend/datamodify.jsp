<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>修改数据字典基础信息 <i class="fa fa-user"></i><small>${userSession.userName}</small></h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <form class="form-horizontal form-label-left" action="/data/savemodify" method="post">
                    <input type="hidden" name="id" id="id" value="${baseData.id}">
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="typeCode">数据类型码 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="typeCode" class="form-control col-md-7 col-xs-12"
                                   data-validate-length-range="20" data-validate-words="1"
                                   name="typeCode" value="${baseData.typeCode}" required="required"
                                   placeholder="请输入数据类型码" type="text">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="typeName">数据类型 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="typeName" type="text" class="form-control col-md-7 col-xs-12"
                                   name="typeName" value="${baseData.typeName}" readonly="readonly">
                        </div>
                    </div>

                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="valueId">数据类型ID <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="valueId" class="form-control col-md-7 col-xs-12"
                                   name="valueId" value="${baseData.valueId}" required="required"
                                   data-validate-length-range="20" data-validate-words="1"
                                   placeholder="请输入数据类型ID" type="text">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="valueName">基本数据 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="valueName" class="form-control col-md-7 col-xs-12"
                                   data-validate-length-range="20" data-validate-words="1"  required="required"
                                   name="valueName" value="${baseData.valueName}"
                                   placeholder="请输入基本数据" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                            <button id="send" type="submit" class="btn btn-success">保存</button>
                            <button type="button" class="btn btn-primary" id="back">返回</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/datamodify.js"></script>
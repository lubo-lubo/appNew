<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">

    <div class="col-md-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>
                    APP 数据字典列表 <i class="fa fa-user"></i><small>${userSession.userName}
                    - 您可以通过搜索或者其他的筛选项对APP的数据字典进行操作。^_^</small>
                </h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <form method="post" action="/data/search">
                    <input type="hidden" name="pageNo" value="1" />
                    <ul>
                        <li>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">基本数据</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input name="queryValueName" type="text" class="form-control col-md-7 col-xs-12" value="${queryValueName }">
                                </div>
                            </div>
                        </li>

                        <li>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">数据类型</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <select name="queryTypeCode" id="queryTypeCode" class="form-control">
                                        <c:if test="${typeList != null }">
                                            <option value="">--请选择--</option>
                                            <c:forEach var="basicData" items="${typeList}">
                                                <option <c:if test="${basicData.typeCode == queryTypeCode }">selected="selected"</c:if>
                                                        value="${basicData.typeCode}">${basicData.typeName}</option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <select id="queryValueId" name="queryValueId" class="form-control">
                                        <c:if test="${valueIdList != null }">
                                            <option value="">--请选择--</option>
                                            <c:forEach var="basicData" items="${valueIdList}">
                                                <option <c:if test="${basicData.valueId == queryValueId }">selected="selected"</c:if>
                                                        value="${basicData.valueId}">${basicData.valueName}</option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                        </li>

                        <li>
                            <button type="submit" class="btn btn-primary"> 查 &nbsp;&nbsp;&nbsp;&nbsp;询 </button>
                            <a href="/data/add"><button type="button" class="btn btn-primary">添    加</button> </a>
                        </li>
                    </ul>
                </form>
            </div>
        </div>
    </div>
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_content">
                <p class="text-muted font-13 m-b-30"></p>
                <div id="datatable-responsive_wrapper"
                     class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                    <div class="row">
                        <div class="col-sm-12">
                            <table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed"
                                   cellspacing="0" width="100%" role="grid" aria-describedby="datatable-responsive_info" style="width: 100%;">
                                <thead>
                                <tr role="row">
                                    <th class="sorting_asc" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        style="width: 70px;" aria-label="First name: activate to sort column descending"
                                        aria-sort="ascending">数据类型码</th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        style="width: 10px;"
                                        aria-label="Last name: activate to sort column ascending">
                                        数据类型</th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        style="width: 90px;"
                                        aria-label="Last name: activate to sort column ascending">
                                        数据类型Id</th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        style="width: 50px;"
                                        aria-label="Last name: activate to sort column ascending">
                                        基本数据</th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        style="width: 50px;"
                                        aria-label="Last name: activate to sort column ascending">
                                        操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="baseData" items="${dataList }" varStatus="status">
                                    <tr role="row" class="odd">
                                        <td tabindex="0" class="sorting_1">${baseData.typeCode}</td>
                                        <td>${baseData.typeName }</td>
                                        <td>${baseData.valueId }</td>
                                        <td>${baseData.valueName }</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/data/modify?did=${baseData.id}">
                                                <button type="button" class="btn btn-default checkApp" did="${baseData.id }" data-toggle="tooltip" data-placement="top" title="" data-original-title="修改基本数据">修改</button>
                                            </a>
                                            <a href="${pageContext.request.contextPath}/data/delete?did=${baseData.id}">
                                                <button type="button" class="btn btn-default checkApp" did="${baseData.id }" data-toggle="tooltip" data-placement="top" title="" data-original-title="删除基本数据">删除</button>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-5">
                            <div class="dataTables_info" id="datatable-responsive_info"
                                 role="status" aria-live="polite">共${page.totalCount }条记录
                                ${page.pageNo }/${page.maxPage }页</div>
                        </div>
                        <div class="col-sm-7">
                            <div class="dataTables_paginate paging_simple_numbers"
                                 id="datatable-responsive_paginate">
                                <ul class="pagination">
                                    <c:if test="${page.pageNo > 1}">
                                        <li class="paginate_button previous"><a
                                                href="javascript:page_nav(document.forms[0],1);"
                                                aria-controls="datatable-responsive" data-dt-idx="0"
                                                tabindex="0">首页</a>
                                        </li>
                                        <li class="paginate_button "><a
                                                href="javascript:page_nav(document.forms[0],${page.pageNo-1});"
                                                aria-controls="datatable-responsive" data-dt-idx="1"
                                                tabindex="0">上一页</a>
                                        </li>
                                    </c:if>
                                    <c:if test="${page.pageNo < page.maxPage }">
                                        <li class="paginate_button "><a
                                                href="javascript:page_nav(document.forms[0],${page.pageNo+1 });"
                                                aria-controls="datatable-responsive" data-dt-idx="1"
                                                tabindex="0">下一页</a>
                                        </li>
                                        <li class="paginate_button next"><a
                                                href="javascript:page_nav(document.forms[0],${page.maxPage });"
                                                aria-controls="datatable-responsive" data-dt-idx="7"
                                                tabindex="0">最后一页</a>
                                        </li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/rollpage.js"></script>
<script src="${pageContext.request.contextPath }/statics/localjs/datalist.js"></script>

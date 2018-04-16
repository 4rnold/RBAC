<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>

<%--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>--%>


<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>菜单列表</title>
    <%@ include file="/WEB-INF/jsp/include/static-head.jsp" %>
</head>

<body class="no-skin">
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    </script>

    <%--<tiles:insertAttribute name="side" />--%>
    <%@ include file="/WEB-INF/jsp/include/side.jsp"%>


    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Home</a>
                    </li>
<%--                    <c:set var="crumbs" value="${fns:getCrumbs(requestScope.get('pagePath'))}"/>
                    <c:forEach var="item" items="${crumbs}" varStatus="itemStatus">
                        <li <c:if test="${itemStatus.last}">class="active"</c:if>>
                            <c:if test="${itemStatus.last}">
                                ${item.name}
                            </c:if>
                            <c:if test="${!itemStatus.last}">
                                <a href="#">${item.name}</a>
                            </c:if>
                        </li>
                    </c:forEach>--%>
                </ul><!-- /.breadcrumb -->

            </div>

            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <%--<tiles:insertAttribute name="content" />--%>

                        <div class="col-sm-6">
                            <div class="widget-box widget-color-blue2">
                                <div class="widget-header">
                                    <h4 class="widget-title lighter smaller">Choose Categories</h4>
                                </div>

                                <div class="widget-body">
                                    <div class="widget-main padding-8">
                                        bbbbb
                                        <ul id="tree1"></ul>
                                    </div>
                                </div>
                            </div>
                        </div>



                        <!-- PAGE CONTENT ENDS -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content -->
        </div>

        <SCRIPT LANGUAGE="JavaScript">
            /*function doPage() {
                alert("role");
            }*/
            /*alert("1");

            //第一次刷新的页面有这个，则执行，第一个页面没有，以后都没有
            $(document).on('pjax:end', function() {
                alert("2");
            });*/
        </SCRIPT>

    </div><!-- /.main-content -->



    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div>



</body>
</html>

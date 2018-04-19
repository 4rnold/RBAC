<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

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
<%@ include file="/WEB-INF/jsp/include/header.jsp" %>


<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>

    <%--<tiles:insertAttribute name="side" />--%>
    <%@ include file="/WEB-INF/jsp/include/side.jsp" %>


    <div class="main-content">
        <link rel="stylesheet" href="${ctx}/assets/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">

        <div class="main-content-inner">
            <div class="breadcrumbs" id="breadcrumbs">


                <script type="text/javascript">
                    try {
                        ace.settings.check('breadcrumbs', 'fixed')
                    } catch (e) {
                    }
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
                        <div class="col-xs-12">
                            <button id="addMenuBtn" class="btn btn-sm btn-info">
                                <i class="ace-icon fa fa-folder-open bigger-110 icon-only"></i>
                                新增页面
                            </button>
                            <button id="addEleBtn" class="btn btn-sm btn-success">
                                <i class="ace-icon fa fa-wrench  bigger-110 icon-only"></i>
                                新增页面元素
                            </button>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <%--<tiles:insertAttribute name="content" />--%>
                        ${message}
                        <div class="col-sm-6">
                            <div class="widget-box widget-color-blue2">
                                <div class="widget-header">
                                    <h4 class="widget-title lighter smaller">编辑菜单</h4>
                                    <div class="widget-toolbar">

                                        <%--<a href="#" id="">
                                            <i class="ace-icon fa-x glyphicon glyphicon-plus white"></i>
                                        </a>--%>

                                        <a href="#" id="deleteBtn">
                                            <i class="ace-icon fa-x glyphicon glyphicon-trash white"></i>
                                        </a>
                                    </div>
                                </div>

                                <div class="widget-body">
                                    <div class="widget-main padding-8">

                                        <ul id="treeDemo" class="ztree"></ul>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div id="menuFormDiv" style="display:none;" class="col-sm-6">
                            <div class="widget-box widget-color-green2">
                                <div class="widget-header">
                                    <h4 class="widget-title">编辑菜单信息</h4>
                                </div>
                                <div class="widget-body">
                                    <div class="widget-main no-padding">
                                        <form data-pjax action="${ctx}/rbac/menu/editMenu" id="editMenuForm"
                                              class="form-horizontal" role="form">
                                            <input type="hidden" class="form-control" name="id">
                                            <input type="hidden" class="form-control" name="pId">


                                            <fieldset>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label no-padding-right"
                                                           for="form-field-1"> 菜单名称 </label>

                                                    <div class="col-sm-9">
                                                        <input type="text" name="name"  placeholder=""
                                                               class="col-xs-10 col-sm-5 form-control"/>

                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label no-padding-right"
                                                           for="form-field-1"> url</label>

                                                    <div class="col-sm-9">
                                                        <input type="text" name="url" placeholder=""
                                                               class="col-xs-10 col-sm-5 form-control"/>
                                                    </div>
                                                </div>

                                                <%--permission--%>
                                                <input type="hidden" class="form-control" name="permissionId">
                                                <%--<input type="hidden" class="form-control" name="permission_name" value="">--%>

                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label no-padding-right"
                                                           for="form-field-1"> permission</label>

                                                    <div class="col-sm-9">
                                                        <input type="text" name="permissionStr" placeholder=""
                                                               class="col-xs-10 col-sm-5 form-control"/>
                                                    </div>
                                                </div>

                                            </fieldset>


                                            <div class="form-actions center">
                                                <button id="saveMenubtn" type="submit" class="btn btn-sm btn-success">
                                                    保存
                                                </button>

                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div id="elementFormDiv" style="display:none;" class="col-sm-6">
                            <div class="widget-box widget-color-green2">
                                <div class="widget-header">
                                    <h4 class="widget-title">编辑菜单信息</h4>
                                </div>
                                <div class="widget-body">
                                    <div class="widget-main no-padding">
                                        <form data-pjax action="${ctx}/rbac/menu/editElement" id="editElementForm"
                                              class="form-horizontal" role="form">
                                            <input type="hidden" class="form-control" name="id">
                                            <input type="hidden" class="form-control" name="menu_id">
                                            <input type="hidden" class="form-control" name="permission_id">


                                            <fieldset>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label no-padding-right"
                                                           for="form-field-1"> 菜单名称 </label>

                                                    <div class="col-sm-9">
                                                        <input type="text" name="name" id="form-field-1" placeholder=""
                                                               class="col-xs-10 col-sm-5 form-control"/>

                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label no-padding-right"
                                                           for="form-field-1"> permission</label>

                                                    <div class="col-sm-9">
                                                        <input type="text" name="permission_str" placeholder=""
                                                               class="col-xs-10 col-sm-5 form-control"/>
                                                    </div>
                                                </div>

                                            </fieldset>


                                            <div class="form-actions center">
                                                <button id="saveElementbtn" type="submit"
                                                        class="btn btn-sm btn-success">
                                                    保存
                                                </button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%--element-form--%>

                        <!-- PAGE CONTENT ENDS -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content -->
        </div>


        <script src="${ctx}/assets/zTree_v3/js/jquery.ztree.core.js"></script>

        <script src="${ctx}/assets/js/jquery.validate.min.js"></script>
        <script src="${ctx}/assets/js/additional-methods.min.js"></script>
        <script src="${ctx}/assets/js/bootbox.min.js"></script>


        <SCRIPT LANGUAGE="JavaScript">



            function addCookie(name,value,expireHours){
                var cookieString=name+"="+escape(value);
                //判断是否设置过期时间
                if(expireHours>0){
                    var date=new Date();
                    date.setTime(date.getTime+expireHours*3600*1000);
                    cookieString=cookieString+"; expire="+date.toGMTString();
                }
                document.cookie=cookieString;
            }

            function getCookie(cookie_name){
                var results = document.cookie.match('(^|;) ?' + cookie_name + '=([^;]*)(;|$)');

                if (results)
                    return (unescape(results[2]));
                else
                    return null;
            }

            function deleteCookie(name){
                var date=new Date();
                date.setTime(date.getTime()-10000);
                document.cookie=name+"=v; expire="+date.toGMTString();
            }

            $("#deleteBtn").on(ace.click_event, function() {
                bootbox.confirm("Are you sure?", function(result) {
                    if(result) {
                        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                        var parentNodes = zTree.getSelectedNodes();
                        if (parentNodes.length === 0) {
                            alert("请先选择一个节点");
                            return;
                        }
                        var pNode = parentNodes[0];
                        if (pNode.id == 0) {
                            alert("根节点无法删除");
                            return;
                        }
                        var url;
                        if (pNode.isMenu == true) {
                            url = '${ctx}/rbac/menu/deleteMenu';
                        } else {
                            url = '${ctx}/rbac/menu/deleteElement';
                        }

                        $.ajax({
                            url: url,
                            type: 'POST',
                            data: {id: pNode.id},
                            dataType: 'json',
                            timeout: 100000,
                            error: function () {
                                alert("网络延时，请重试.");
                            },
                            success: function (res) {
                                //initEditMenuForm();
                                if (res.code == 0) {
                                    alert("删除成功");
                                    $.pjax({
                                        timeout: 20000,
                                        url: "${ctx}/rbac/menu/list",
                                        container: '.main-content',
                                        fragment: '.main-content'
                                    });
                                } else {
                                    alert(res.message);
                                }
                            }
                        });
                    }
                });
            });

            /*$("#deleteBtn").click(function (e) {
                var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                var parentNodes = zTree.getSelectedNodes();
                if (parentNodes.length === 0) {
                    alert("请先选择一个节点");
                    return;
                }
                var pNode = parentNodes[0];
                if (pNode.id == 0) {
                    alert("根节点无法删除");
                    return;
                }
                var url;
                if (pNode.isMenu == true) {
                    url = '${ctx}/rbac/menu/deleteMenu';
                } else {
                    url = '${ctx}/rbac/menu/deleteElement';
                }

                $.ajax({
                    url: url,
                    type: 'POST',
                    data: {id: pNode.id},
                    dataType: 'json',
                    timeout: 100000,
                    error: function () {
                        alert("网络延时，请重试.");
                    },
                    success: function (res) {
                        //initEditMenuForm();
                        if (res.code == 0) {
                            alert("删除成功");
                            $.pjax({
                                timeout: 20000,
                                url: "${ctx}/rbac/menu/list",
                                container: '.main-content',
                                fragment: '.main-content'
                            });
                        } else {
                            alert(res.message);
                        }
                    }
                });
                /!*initAddMenuForm();
                $("#editMenuForm").find("input[name='pId']").val(pNode.id);*!/
            });*/


            $("#addMenuBtn").click(function (e) {
                var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                var parentNodes = zTree.getSelectedNodes();
                if (parentNodes.length === 0) {
                    alert("请先选择一个节点");
                    return;
                }
                var pNode = parentNodes[0];
                initAddMenuForm();
                $("#editMenuForm").find("input[name='pId']").val(pNode.id);
            });

            $("#addEleBtn").click(function (e) {
                var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                parentNodes = zTree.getSelectedNodes();
                if (parentNodes.length == 0) {
                    alert("请先选择一个节点");
                    return;
                }
                pNode = parentNodes[0];
                if (pNode.id == 0) {
                    alert("无法在根节点下添加元素");
                    return;
                }
                initAddElementForm();
                if (pNode.isMenu == true) {
                    $("#editElementForm input[name='menu_id']").val(pNode.id);
                } else {
                    $("#editElementForm input[name='menu_id']").val(pNode.pId);
                }
            });

            function initAddMenuForm() {
                $("#menuFormDiv .widget-title").text("添加菜单");
                $("#menuFormDiv .widget-box").attr("class","widget-box widget-color-orange");
                $("#menuFormDiv .btn").attr("class","btn btn-sm btn-warning").text("添加菜单");
                $("#editMenuForm")[0].reset();
                $("#editMenuForm input[type='hidden']").val("");
                $("#menuFormDiv").show();
                $("#elementFormDiv").hide();
            }

            function initEditMenuForm() {
                $("#menuFormDiv .widget-title").text("编辑菜单");
                $("#menuFormDiv .widget-box").attr("class","widget-box widget-color-green2");
                $("#menuFormDiv .btn").attr("class","btn btn-sm btn-success").text("编辑菜单");
                $("#editMenuForm")[0].reset();
                $("#editMenuForm input[type='hidden']").val("");
                $("#menuFormDiv").show();
                $("#elementFormDiv").hide();
            }

            function initAddElementForm() {
                $("#elementFormDiv .widget-title").text("添加元素");
                $("#elementFormDiv .widget-box").attr("class","widget-box widget-color-red");
                $("#elementFormDiv .btn").attr("class","btn btn-sm btn-danger").text("添加元素");
                $("#editElementForm")[0].reset();
                $("#editElementForm input[type='hidden']").val("");
                $("#menuFormDiv").hide();
                $("#elementFormDiv").show();
            }

            function initEditElementForm() {
                $("#elementFormDiv .widget-title").text("编辑元素");
                $("#elementFormDiv .widget-box").attr("class","widget-box widget-color-green2");
                $("#elementFormDiv .btn").attr("class","btn btn-sm btn-success").text("编辑元素");
                $("#editElementForm")[0].reset();
                $("#editElementForm input[type='hidden']").val("");
                $("#menuFormDiv").hide();
                $("#elementFormDiv").show();
            }

            //ztree点击方法
            function onClick(event, treeId, treeNode, clickFlag) {
                if (treeNode.id == 0)
                    return;
                if (treeNode.isMenu == true) {
                    $.ajax({
                        url: '${ctx}/rbac/menu/getMenuById',
                        type: 'POST',
                        data: {id: treeNode.id},
                        dataType: 'json',
                        timeout: 100000,
                        error: function () {
                            alert("网络延时，请重试.");
                        },
                        success: function (res) {
                            initEditMenuForm();
                            if (res.code == 0) {
                                $("#editMenuForm .form-control").each(function () {
                                    var name = $(this).attr("name");
                                    //alert(name);
                                    $(this).val(res.object[name]);
                                });
                            } else {
                                alert(res.message);
                            }
                        }
                    });
                } else {
                    $.ajax({
                        url: '${ctx}/rbac/menu/getElementById',
                        type: 'POST',
                        data: {id: treeNode.id},
                        dataType: 'json',
                        timeout: 100000,
                        error: function () {
                            alert("网络延时，请重试.");
                        },
                        success: function (res) {
                            initEditElementForm();
                            if (res.code == 0) {
                                $("#editElementForm .form-control").each(function () {
                                    var name = $(this).attr("name");
                                    //alert(name);
                                    $(this).val(res.object[name]);
                                });
                            } else {
                                alert(res.message);
                            }
                        }
                    });
                }
            }




            $(document).ready(function () {
                $("#menuFormDiv").hide();
                $("#elementFormDiv").hide();

                $("#editMenuForm").validate({
                    debug: true,
                    rules: {
                        name: {
                            required: true,
                            rangelength: [3, 5]
                        },
                        url: {
                            /*remote:{
                                url:"<c:url value='/pms/permission/checkPermission'/>",
                                type:"post"
                            }*/
                        }
                    },
                    messages: {
                        name: {
                            required: "请输入"//,
                            //rangelength:"长度3-5"
                        }
                    },
                    submitHandler: function (form) {
                        saveMenuSubmit();
                    }
                });

                $("#editElementForm").validate({
                    debug: true,
                    rules: {
                        name: {
                            required: true,
                            rangelength: [3, 5]
                        },
                        url: {
                            /*remote:{
                                url:"<c:url value='/pms/permission/checkPermission'/>",
                                type:"post"
                            }*/
                        }
                    },
                    messages: {
                        name: {
                            required: "请输入"//,
                            //rangelength:"长度3-5"
                        }
                    },
                    submitHandler: function (form) {
                        saveElementSubmit();
                    }
                });


                /*通过ajax来做submit*/
                function saveMenuSubmit() {
                    //e.preventDefault();
                    dataString = $("#editMenuForm").serialize();

                    $.ajax({
                        type: "POST",
                        url: $("#editMenuForm").attr("action"),
                        data: dataString,
                        /*dataType: "json",*/
                        success: function (data) {
                            // Handle the server response (display errors if necessary)
                            if (data.code == 0) {
                                alert("修改成功");
                                $.pjax({
                                    timeout: 20000,
                                    url: "${ctx}/rbac/menu/list",
                                    container: '.main-content',
                                    fragment: '.main-content'
                                });
                            } else {
                                alert("参数错误");
                                $.pjax({
                                    timeout: 20000,
                                    url: "${ctx}/rbac/menu/list",
                                    container: '.main-content',
                                    fragment: '.main-content'
                                });
                            }


                        },
                        error: function (data) {
                            var jsonStr = JSON.stringify(data.responseJSON)
                            alert(jsonStr);
                        }
                    });
                }

                function saveElementSubmit() {
                    //e.preventDefault();
                    dataString = $("#editElementForm").serialize();

                    $.ajax({
                        type: "POST",
                        url: $("#editElementForm").attr("action"),
                        data: dataString,
                        /*dataType: "json",*/
                        success: function (data) {
                            // Handle the server response (display errors if necessary)
                            if (data.code == 0) {
                                alert("修改成功");
                                $.pjax({
                                    timeout: 20000,
                                    url: "${ctx}/rbac/menu/list",
                                    container: '.main-content',
                                    fragment: '.main-content'
                                });
                            } else {
                                alert("参数错误");
                                $.pjax({
                                    timeout: 20000,
                                    url: "${ctx}/rbac/menu/list",
                                    container: '.main-content',
                                    fragment: '.main-content'
                                });
                            }


                        },
                        error: function (data) {
                            var jsonStr = JSON.stringify(data.responseJSON)
                            alert(jsonStr);
                        }
                    });
                }



                var zTreeObj;
                // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
                var setting = {
                    data: {
                        simpleData: {
                            enable: true
                        },
                        key: {
                            url: "xxurl"
                        }
                    },
                    view: {
                        selectedMulti: true
                    },
                    callback: {
                        onClick: onClick
                    }
                };
                $.ajax({
                    url: '${ctx}/rbac/menu/getZtreeNodes',
                    type: 'get',
                    dataType: 'json',
                    timeout: 10000,
                    error: function () {
                        alert("网络延时，请重试.");
                    },
                    success: function (res) {
                        treeNodes = res.object;
                        treeNodes.unshift({id: 0, pId: 0, name: "", open: true});
                        for (var idx in treeNodes) {

                            if (treeNodes[idx].isMenu == true) {
                                treeNodes[idx].iconOpen = "${ctx}/assets/zTree_v3/css/zTreeStyle/img/diy/12.png";
                                treeNodes[idx].iconClose = "${ctx}/assets/zTree_v3/css/zTreeStyle/img/diy/11.png";
                                treeNodes[idx].isParent = true;
                            } else if (treeNodes[idx].id == 0) {
                                treeNodes[idx].icon = "${ctx}/assets/zTree_v3/css/zTreeStyle/img/diy/1_open.png";
                            } else {
                                treeNodes[idx].icon = "${ctx}/assets/zTree_v3/css/zTreeStyle/img/diy/13.png";
                            }
                        }

                        $.getScript("${ctx}/assets/zTree_v3/js/jquery.ztree.core.js", function () {
                            zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, treeNodes);
                            zTreeObj.expandAll(true);
                        });
                    }
                });
            });

            /*
            function showEditForm(data) {
                if (data == "menu") {
                    initEditMenuForm();
                    $("#menuFormDiv").show();
                    $("#elementFormDiv").hide();
                } else {
                    initEditElementForm();
                    $("#menuFormDiv").hide();
                    $("#elementFormDiv").show();
                }
            }

            function hideEditForm() {
                $("#menuFormDiv").hide();
                $("#elementFormDiv").hide();
            }
*/
            /* $("#saveMenubtn").click(function(e) {

     e.preventDefault();
     dataString = $("#editMenuForm").serialize();

     $.ajax({
         type: "POST",
         url: $("#editMenuForm").attr("action"),
         data: dataString,
         /!*dataType: "json",*!/
         success: function(data)
         {
             // Handle the server response (display errors if necessary)
             if(data.code == 0) {
                 alert("修改成功");
                 $.pjax({
                     timeout: 20000,
                     url: "


${ctx}/rbac/menu/list",
                                    container: '.main-content',
                                    fragment: '.main-content'
                                });
                            } else {
                                alert("参数错误");
                                $.pjax({
                                    timeout: 20000,
                                    url: "


                ${ctx}/rbac/menu/list",
                                    container: '.main-content',
                                    fragment: '.main-content'
                                });
                            }


                        }
                    });
                });*/

            /*$(document).on('submit', 'form[data-pjax]', function(event) {
                event.preventDefault();
                $.pjax.submit(event, '.main-content', {type: "POST"})
                /!*$.pjax.submit(event, '.main-content', {
                    'push': true,
                    'replace': false,
                    'timeout': 5000,
                    'scrollTo': 0,
                    'maxCacheLength': 0
                });*!/
            });*/


            /*通过pjax提交form，问题：无法得到callback*/
            /*$(document).on('submit', '#editMenuForm', function (event) {
                event.preventDefault(); // stop default submit behavior

                $.pjax.submit(event, '.main-content',
                    {
                        fragment: '.main-content',
                        push: false,//不改变url，
                        timeout:20000,
                        replace: false
                    });
            });*/
        </SCRIPT>

    </div><!-- /.main-content -->


    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div>


</body>
</html>

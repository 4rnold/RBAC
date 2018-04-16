<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
    <script src="${ctx}/assets/js/jquery.pjax-1.8.2.min.js"></script>


</head>
<body>
<div id="main">
    <a href="/test/pjax1">p1</a>
    <a href="/test/pjax2">p2</a>
    111111111111111111111111111111

    <%--ztree--%>
    <ul id="treeDemo" class="ztree"></ul>


    <script src="${ctx}/assets/zTree_v3/js/jquery.ztree.core.js"></script>
    <link rel="stylesheet" href="${ctx}/assets/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">

    <SCRIPT LANGUAGE="JavaScript">
        var zTreeObj;
        // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
        var setting = {};
        // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
        var zNodes = [
            {name:"test1", open:true, children:[
                {name:"test1_1"}, {name:"test1_2"}]},
            {name:"test2", open:true, children:[
                {name:"test2_1"}, {name:"test2_2"}]}
        ];

        $(document).on('pjax:end', function() {
            // 这里的调用 **只有** 在「局部刷新」时才会运行
            zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        });


        zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);

    </SCRIPT>
</div>

<script type="text/javascript">
    $(document).pjax('a[target!=_blank]', '#main', {
        fragment: '#main',
        timeout: 8000
    });

</script>
</body>
</html>

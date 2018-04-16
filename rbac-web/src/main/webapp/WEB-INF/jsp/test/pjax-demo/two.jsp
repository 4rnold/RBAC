<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Arnold
  Date: 2018/3/11
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <meta charset="utf-8">
    <title>Two</title>
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
    <link rel="shortcut icon" href="img/favicon/rtaImage.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="img/favicon/rtaImage.ico">
    <link rel="apple-touch-icon" sizes="72x72" href="img/favicon/icon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="img/favicon/icon-114x114.png">

</head>
<body>
<div class="header pjax-container">
    <div class="b2 two"><h1>Title Two</h1><a data-pjax href="/test/three">
        <button>Перейти на другую страницу</button>
    </a>
        <ul id="treeDemo" class="ztree"></ul>

        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus accusantium ad amet, animi asperiores
            commodi consequatur debitis dolore enim esse fugit ipsam itaque libero magnam magni modi molestias odit
            pariatur, porro quasi ratione reprehenderit similique tempora unde veniam vero voluptas?</p></div>
</div>
<!--[if lt IE 9]>
<script src="${ctx}/assets/pjax-test/scripts/html5shiv/es5-shim.min.js"></script>
<script src="${ctx}/assets/pjax-test/scripts/html5shiv/html5shiv.min.js"></script>
<script src="${ctx}/assets/pjax-test/scripts/html5shiv/html5shiv-printshiv.min.js"></script>
<script src="${ctx}/assets/pjax-test/scripts/respond/respond.min.js"></script>
<![endif]-->
<!-- Load CSS -->
<script>
    function loadCSS(hf) {var ms=document.createElement("link");
        ms.rel="stylesheet";ms.href=hf;document.getElementsByTagName("head")[0].appendChild(ms);}
    loadCSS("${ctx}/assets/pjax-test/style.css");
    loadCSS("${ctx}/assets/zTree_v3/css/zTreeStyle/zTreeStyle.css");

</script>
<!-- Load Scripts -->
<script>var scr = {
    "scripts": [
        {"src": "${ctx}/assets/pjax-test/vendor/jquery/dist/jquery.min.js", "async": false},
        {"src": "${ctx}/assets/js/jquery.pjax.js", "async": false},
        {"src": "${ctx}/assets/pjax-test/scripts/modernizr/modernizr.js", "async": false},
        {"src": "${ctx}/assets/zTree_v3/js/jquery.ztree.core.js", "async": false},
        {"src": "${ctx}/assets/pjax-test/scripts/main.js", "async": false}
    ]
};
!function (t, n, r) {
    "use strict";
    var c = function (t) {
        if ("[object Array]" !== Object.prototype.toString.call(t))return !1;
        for (var r = 0; r < t.length; r++) {
            var c = n.createElement("script"), e = t[r];
            c.src = e.src, c.async = e.async, n.body.appendChild(c)
        }
        return !0
    };
    t.addEventListener ? t.addEventListener("load", function () {
        c(r.scripts);
    }, !1) : t.attachEvent ? t.attachEvent("onload", function () {
        c(r.scripts)
    }) : t.onload = function () {
        c(r.scripts)
    }
}(window, document, scr);

/*$(function () {
    $(document).pjax('a[data-pjax]', '.pjax-container', {fragment: '.pjax-container'});
});*/

</script>
</body>
</html>

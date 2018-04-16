<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Arnold
  Date: 2018/3/11
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <meta charset="utf-8">
    <title>Index</title>
    <meta name="description" content="">
    <!-- Header CSS (First Sections of Website: compress & paste after release from _header.css here) -->
    <style></style><!-- Fonts Loader from fonts.css (HTML5 LocalStorage) -->
    <script>!function () {
        function e(e, t, n) {
            e.addEventListener ? e.addEventListener(t, n, !1) : e.attachEvent && e.attachEvent("on" + t, n)
        }

        function t(e) {
            return window.localStorage && localStorage.font_css_cache && localStorage.font_css_cache_file === e
        }

        function n() {
            if (window.localStorage && window.XMLHttpRequest) if (t(o)) a(localStorage.font_css_cache); else {
                var n = new XMLHttpRequest;
                n.open("GET", o, !0), e(n, "load", function () {
                    4 === n.readyState && (a(n.responseText), localStorage.font_css_cache = n.responseText, localStorage.font_css_cache_file = o)
                }), n.send()
            } else {
                var c = document.createElement("link");
                c.href = o, c.rel = "stylesheet", c.type = "text/css", document.getElementsByTagName("head")[0].appendChild(c), document.cookie = "font_css_cache"
            }
        }

        function a(e) {
            var t = document.createElement("style");
            t.innerHTML = e, document.getElementsByTagName("head")[0].appendChild(t)
        }

        var o = "fonts.css";
        window.localStorage && localStorage.font_css_cache || document.cookie.indexOf("font_css_cache") > -1 ? n() : e(window, "load", n)
    }();</script><!-- Load CSS Compilled without JS -->
    <noscript>
        <link rel="stylesheet" href="style.css">
    </noscript>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
    <link rel="shortcut icon" href="img/favicon/rtaImage.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="img/favicon/rtaImage.ico">
    <link rel="apple-touch-icon" sizes="72x72" href="img/favicon/icon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="img/favicon/icon-114x114.png">
</head>
<body>
<div class="header pjax-container">
    <div class="b1 one"><h1>Title One</h1><a href="test/two">
        <button>Перейти на другую страницу</button>
    </a>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Animi debitis dolore dolores dolorum ducimus
            explicabo impedit ipsa libero magnam omnis pariatur porro quia reprehenderit sed sequi, similique unde ut.
            Autem commodi error incidunt nulla quaerat repellendus, similique totam vitae voluptatem.</p></div>
    <div class="b2 two"><h1>Title Two</h1><a href="three.html">
        <button>Перейти на другую страницу</button>
    </a>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Animi debitis dolore dolores dolorum ducimus
            explicabo impedit ipsa libero magnam omnis pariatur porro quia reprehenderit sed sequi, similique unde ut.
            Autem commodi error incidunt nulla quaerat repellendus, similique totam vitae voluptatem.</p></div>
    <div class="b3 three"><h1>Title Three</h1><a href="index.html">
        <button>Перейти на другую страницу</button>
    </a>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Animi debitis dolore dolores dolorum ducimus
            explicabo impedit ipsa libero magnam omnis pariatur porro quia reprehenderit sed sequi, similique unde ut.
            Autem commodi error incidunt nulla quaerat repellendus, similique totam vitae voluptatem.</p></div>
</div><!-- Preloader --><!-- <style type="text/css">#hellopreloader>p{display:none;}#hellopreloader_preload{display: block;position:fixed;z-index: 99999;top:0;left:0;right:0;bottom:0;background:#22313F url(http://hello-site.ru//main/images/preloads/rings.svg) center center no-repeat;background-size:124px;}</style>
<div id="hellopreloader"><div id="hellopreloader_preload"></div></div>
<script type="text/javascript">var hellopreloader = document.getElementById("hellopreloader_preload");function fadeOutnojquery(el){el.style.opacity = 1;var interhellopreloader = setInterval(function(){el.style.opacity = el.style.opacity - 0.05;if (el.style.opacity <=0.05){ clearInterval(interhellopreloader);hellopreloader.style.display = "none";}},16);}window.onload = function(){setTimeout(function(){fadeOutnojquery(hellopreloader);},1000);};</script> -->
<!--[if lt IE 9]>
<script src="${ctx}/assets/pjax-test/scripts/html5shiv/es5-shim.min.js"></script>
<script src="${ctx}/assets/pjax-test/scripts/html5shiv/html5shiv.min.js"></script>
<script src="${ctx}/assets/pjax-test/scripts/html5shiv/html5shiv-printshiv.min.js"></script>
<script src="${ctx}/assets/pjax-test/scripts/respond/respond.min.js"></script>
<![endif]--><!-- Load CSS -->
<script>function loadCSS(hf) {
    var ms = document.createElement("link");
    ms.rel = "stylesheet";
    ms.href = hf;
    document.getElementsByTagName("head")[0].appendChild(ms);
}

loadCSS("style.css");</script><!-- Load CSS compiled without Bootstrap & Header styles (after release) -->
<script>var ms = document.createElement("link");
ms.rel = "stylesheet";
ms.href = "style.css";
document.getElementsByTagName("head")[0].appendChild(ms);</script><!-- Load Scripts -->
<script>var scr = {
    "scripts": [
        {"src": "${ctx}/assets/pjax-test/vendor/jquery/dist/jquery.min.js", "async": false},
        {"src": "${ctx}/assets/pjax-test/vendor/jquery-pjax/jquery.pjax.js", "async": false},
        {"src": "${ctx}/assets/pjax-test/scripts/modernizr/modernizr.js", "async": false},
        {"src": "${ctx}/assets/pjax-test/scripts/waypoints/waypoints.min.js", "async": false},
        {"src": "${ctx}/assets/pjax-test/scripts/main.min.js", "async": false}
    ]
};
!function (t, n, r) {
    "use strict";
    var c = function (t) {
        if ("[object Array]" !== Object.prototype.toString.call(t)) return !1;
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
}(window, document, scr);</script>
</body>
</html>

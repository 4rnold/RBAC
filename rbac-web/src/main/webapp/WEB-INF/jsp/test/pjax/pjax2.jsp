<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    aaa2222222222222
</div>

<script type="text/javascript">
    $(document).pjax('a[target!=_blank]', '#main', {
        fragment: '#main',
        timeout: 8000
    });
</script>
</body>
</html>

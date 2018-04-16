<%--
  Created by IntelliJ IDEA.
  User: Arnold
  Date: 2018/3/1
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>Buttons &amp; Icon - Ace Admin</title>

<meta name="description" content="Common Buttons &amp; Icons" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="shortcut icon" type="image/x-icon" href="${ctx}/assets/favicon.ico"  media="screen"/>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="${ctx}/assets/font-awesome/4.2.0/css/font-awesome.min.css" />

<!-- page specific plugin styles -->

<!-- text fonts -->
<link rel="stylesheet" href="${ctx}/assets/fonts/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet" href="${ctx}/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

<!--[if lte IE 9]>
<link rel="stylesheet" href="${ctx}/assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
<![endif]-->

<!--[if lte IE 9]>
<link rel="stylesheet" href="${ctx}/assets/css/ace-ie.min.css" />
<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="${ctx}/assets/js/ace-extra.min.js"></script>

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
<script src="${ctx}/assets/js/html5shiv.min.js"></script>
<script src="${ctx}/assets/js/respond.min.js"></script>
<![endif]-->


<!-- basic scripts -->

<!--[if !IE]> -->
<%--
<script src="${ctx}/assets/js/jquery.2.1.1.min.js"></script>

--%>
<script src="${ctx}/assets/js/jquery.1.11.1.min.js"></script>


<!-- <![endif]-->

<!--[if IE]>
<script src="${ctx}/assets/js/jquery.1.11.1.min.js"></script>
<![endif]-->

<!--[if !IE]> -->
<script type="text/javascript">
    window.jQuery || document.write("<script src='${ctx}/assets/js/jquery.min.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->
<%--
<script src="${ctx}/assets/js/jquery.pjax.js"></script>
--%>
<script src="https://cdn.bootcss.com/jquery.pjax/1.9.6/jquery.pjax.min.js"></script>
<script src="https://unpkg.com/nprogress@0.2.0/nprogress.js"></script>
<link rel="stylesheet" href="https://unpkg.com/nprogress@0.2.0/nprogress.css" />

<script src="${ctx}/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->
<script src="${ctx}/assets/js/jquery-ui.min.js"></script>
<script src="${ctx}/assets/js/jquery.ui.touch-punch.min.js"></script>

<!-- ace scripts -->
<script src="${ctx}/assets/js/ace-elements.min.js"></script>
<script src="${ctx}/assets/js/ace.min.js"></script>

<script type="text/javascript">
    $(document).ready(function(){
        NProgress.configure({ parent: '.main-content' });
        $(document).on('pjax:start', NProgress.start).on('pjax:end', NProgress.done);
        $(document).pjax('a[data-pjax]', '.main-content', {fragment: '.main-content',timeout:20000});
        $(document).on('pjax:timeout', function() {
            alert("timeout");
        })
        /*$(document).on('pjax:end', function() {
            doPage();
            //zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        });*/
    });
    
    /*function doPage() {
        
    }*/

</script>
'use strict';

$(function () {
    /*$(document).pjax('.b1 a, .b1 a, b3 a', '.pjax-container', {fragment: '.pjax-container'})*/
    $(document).pjax('a[data-pjax]', '.pjax-container', {fragment: '.pjax-container'});

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
});
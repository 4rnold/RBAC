'use strict';

$(function () {
    /*$(document).pjax('.b1 a, .b1 a, b3 a', '.pjax-container', {fragment: '.pjax-container'})*/
    $(document).pjax('a[data-pjax]', '.pjax-container', {fragment: '.pjax-container'});

});
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Arnold
  Date: 2017/12/29
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<div id="sidebar" class="sidebar                  responsive" data-sidebar="true" data-sidebar-scroll="true"
     data-sidebar-hover="true">
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="sidebar-shortcuts" id="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>

        <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div><!-- /.sidebar-shortcuts -->


    <ul class="nav nav-list" style="top: 0px;">

        <c:set var="menuList" value="${fns:getMenuVoList()}"/>


        <c:forEach items="${menuList}" var="menu" varStatus="idx">
            <li>
                <a href="#" class="dropdown-toggle">
                    <span class="menu-text"> ${menu.name} </span>
                    <b class="arrow fa fa-angle-down"></b>

                </a>

                <c:forEach items="${menu.subMenus}" var="childMenu">
                    <ul class="submenu">
                        <li>
                            <a data-pjax href="${ctx}/${childMenu.url}">
                                <i class="menu-icon fa fa-caret-right"></i>
                                    ${childMenu.name}
                            </a>
                        </li>
                    </ul>
                </c:forEach>
            </li>
        </c:forEach>





    </ul>



        <%--<c:forEach items="${menuList}" var="menu" varStatus="idx">
            <li>
                <a href="#" class="dropdown-toggle">
                    <i class="icon-edit"></i>
                    <span class="menu-text"> ${menu.name} </span>
                    <b class="arrow icon-angle-down"></b>
                </a>

                <c:forEach items="${menu.subMenus}" var="childMenu">
                    <ul class="submenu">
                        <li>
                            <a href="${childMenu.url}">
                                <i class="menu-icon fa fa-caret-right"></i>
                                    ${childMenu.name}
                            </a>
                        </li>
                    </ul>
                </c:forEach>
            </li>
        </c:forEach>--%>


<%--        <c:set var="menuList" value="${fns:getMenus(requestScope.get('pagePath'))}"/>
        <c:forEach items="${menuList}" var="menu" varStatus="idx">
            <li class="${menu.isActive?"active open":""}">
                <a href="#" class="dropdown-toggle">
                    <i class="icon-edit"></i>
                    <span class="menu-text"> ${menu.name} </span>
                    <b class="arrow icon-angle-down"></b>
                </a>
                <c:if test="${menu.leafMenus != null}">
                    <ul class="submenu">
                        <c:forEach items="${menu.leafMenus}" var="childMenu" varStatus="subIdx">
                            <li class="${childMenu.isActive?"active":""}">
                                <a href="${childMenu.url}">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                        ${childMenu.name}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </c:if>

            </li>
        </c:forEach>--%>


    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left"
           data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>

    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'collapsed')
        } catch (e) {
        }
    </script>
</div>




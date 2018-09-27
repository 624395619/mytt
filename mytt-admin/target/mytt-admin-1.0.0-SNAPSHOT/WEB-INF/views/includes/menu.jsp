<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar" style="height: auto">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/static/assets/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <a href="/user/view?id=${user.id}">
                    <p>${user.username}</p>
                    <i class="fa fa-circle text-success"></i> Online
                </a>
            </div>

        </div>
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">导航菜单</li>
            <%--用户管理--%>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-user"></i> <span>用户管理</span>
                    <span class="pull-right-container">
                     <i class="fa fa-angle-left pull-right"></i>
                     </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/user/list"><i class="fa fa-circle-o"></i>用户列表</a></li>
                </ul>
            </li>

            <%--内容管理--%>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-book"></i> <span>内容管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/category/list"><i class="fa fa-circle-o"></i>内容分类</a></li>
                    <li><a href="/content/list"><i class="fa fa-circle-o"></i>内容列表</a></li>
                </ul>
            </li>

            <%--内容管理--%>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-book"></i> <span>评论管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/comment/list"><i class="fa fa-circle-o"></i>评论列表</a></li>
                    <li><a href="/report/list"><i class="fa fa-circle-o"></i>回复列表</a></li>
                </ul>
            </li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>

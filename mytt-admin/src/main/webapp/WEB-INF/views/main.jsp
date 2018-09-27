<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/includes/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>今日头条</title>
    <jsp:include page="${ctxPath}/head.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="${ctxPath}/header.jsp"/>
        <!-- Left side column. contains the logo and sidebar -->
    <jsp:include page="${ctxPath}/menu.jsp"/>
        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    <small id="small"></small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="/main"><i class="fa fa-dashboard"></i> 主页</a></li>
                    <li class="active" id="menuName"></li>
                </ol>
            </section>
            <section class="content">
            </section>
        </div>
    <jsp:include page="${ctxPath}/footer.jsp"/>
</div>
    <jsp:include page="${ctxPath}/foot.jsp"/>
    <script>
        $(function () {
            $(".treeview").removeClass("menu-open");
            $(".treeview-menu").hide();
        })
    </script>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/includes/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户信息</title>
    <jsp:include page="${ctxPath}/head.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="${ctxPath}/header.jsp"/>
    <jsp:include page="${ctxPath}/menu.jsp"/>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1 >用户管理
                <small id="small">用户信息</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/main"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li class="active" id="menuName">用户管理</li>
            </ol>
        </section>

            <div class="alert alert-danger alert-dismissible ${empty message?"hidden":""}">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h5><i class="icon fa fa-ban"></i> ${message}</h5>
            </div>
        <section class="content">
            <div class="box box-primary" >
                <div class="box-header with-border">
                    <div class="box-header">
                        <h3 class="box-title">${tbUser.id==0?"新增用户":"修改用户"}</h3>
                    </div>
                </div>
                <!-- /.box-header -->

                <!-- form start -->
                <form:form class="form-horizontal" action="/user/save" id="commentForm" method="post" modelAttribute="tbUser">
                    <form:hidden path="id" />
                    <div class="box-body">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">用户名</label>
                            <div class="col-sm-8">
                                <form:input path="username"   rangelength="6,20" class="form-control" placeholder="用户名" required="true"/>
                            </div>
                        </div>
                        <div class="form-group ${tbUser.id==0?"":"hidden"}" id="pwdDiv">
                            <label class="col-sm-2 control-label">密码</label>

                            <div class="col-sm-8">
                                <form:password  path="password" rangelength="6,20" class="form-control"  placeholder="密码" required="true" />
                            </div>
                        </div>
                        <div class="form-group ${tbUser.id==0?"":"hidden"}" id="confirmPwdDiv">
                            <label class="col-sm-2 control-label">确认密码</label>

                            <div class="col-sm-8">
                                <form:password  path="" equalTo="#password" rangelength="6,20" class="form-control"  placeholder="确认密码" required="true" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label  class="col-sm-2 control-label">联系方式</label>

                            <div class="col-sm-8">
                                <form:input  path="phone"   class="form-control"  placeholder="手机" required="true" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label  class="col-sm-2 control-label">邮箱</label>

                            <div class="col-sm-8">
                                <form:input path="email"  email="true" class="form-control"  placeholder="邮箱" required="true" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-9 control-label"></label>
                            <div class="col-sm-3">
                                <button type="submit"  class="btn btn-info">保存</button>
                            </div>
                        </div>
                    </div>
                    <!-- /.box-body -->
                    <%--<div class="box-footer">--%>
                    <%--</div>--%>
                    <!-- /.box-footer -->
                </form:form>
            </div>
        </section>
    </div>
    <jsp:include page="${ctxPath}/footer.jsp"/>
</div>
<jsp:include page="${ctxPath}/foot.jsp"/>
</body>
</html>
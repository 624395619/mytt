<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/includes/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>分类信息</title>
    <jsp:include page="${ctxPath}/head.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="${ctxPath}/header.jsp"/>
    <jsp:include page="${ctxPath}/menu.jsp"/>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1 >分类管理
                <small id="small">分类信息</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/main"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li class="active" id="menuName">分类管理</li>
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
                        <h3 class="box-title">${tbContentCategory.id==0?"新增分类":"修改分类"}</h3>
                    </div>
                </div>
                <!-- /.box-header -->

                <!-- form start -->
                <form:form class="form-horizontal" action="/category/save" id="commentForm" method="post" modelAttribute="tbContentCategory">
                    <form:hidden path="id" />

                    <div class="box-body">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">所属分类</label>
                            <div class="col-sm-9">
                                <form:hidden id="parentId" path="parentCategory.id" class="required" />
                                <input id="parentName" type="text" class="form-control required" data-toggle="modal" data-target="#modal-default" placeholder="请选择" readonly="true" value="${tbContentCategory.parentCategory.name}" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">分类名称</label>
                            <div class="col-sm-9">
                                <form:input path="name" class="form-control required" placeholder="分类名称" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">排序</label>
                            <div class="col-sm-9">
                                <form:input path="sortOrder" class="form-control digits" placeholder="排序" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">跳转地址</label>
                            <div class="col-sm-9">
                                <form:input path="address" class="form-control" placeholder="跳转地址" />
                            </div>
                        </div>
                    </div>

                    <div class="box-footer">
                        <button type="submit" class="btn btn-primary pull-right">提交</button>
                    </div>
                    <!-- /.box-body -->
                    <!-- /.box-footer -->
                </form:form>
            </div>
        </section>
    </div>
    <jsp:include page="${ctxPath}/footer.jsp"/>
</div>
<jsp:include page="${ctxPath}/foot.jsp"/>
<sys:modal title="请选择" message="<ul id='myTree' class='ztree'></ul>"/>
<script>
    $(function () {
        Myshop.initZTree("/category/treeData","#parentName");
    });
</script>
</body>
</html>
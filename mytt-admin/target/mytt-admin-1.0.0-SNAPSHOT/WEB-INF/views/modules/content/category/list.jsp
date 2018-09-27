<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/includes/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>内容分类</title>
    <jsp:include page="${ctxPath}/head.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="${ctxPath}/header.jsp"/>
    <jsp:include page="${ctxPath}/menu.jsp"/>
    <div class="content-wrapper">

        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>分类管理
                <small id="small">分类列表</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/main"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li class="active" id="menuName">分类管理</li>
            </ol>


        </section>
        <div class="alert alert-success alert-dismissible ${empty message?"hidden":""}">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            <h5><i class="icon fa fa-check"></i> ${message}</h5>
        </div>
        <section class="content">
            <div class="row">
                <div class="col-sm-12">
                    <!-- box -->
                    <div class="box box-primary">

                        <!-- /.box-header -->
                        <div class="box-header with-border">
                            <div class="box-header">
                                <h3 class="box-title">分类列表</h3>
                            </div>
                                <ul class="nav nav-pills pull-left">
                                    <li><a href="/category/form"><i class="fa fa-fw fa-plus text-primary"></i> 新增</a></li>
                                </ul>
                        </div>
                        <!-- /.box-header -->

                        <!-- box-body -->
                        <div class="box-body">
                            <div class="table-responsive">

                                <table id="treeTable" class="table table-bordered table-striped table-hover nowrap">
                                    <thead>
                                    <tr>
                                        <th>类目id</th>
                                        <th>分类名称</th>
                                        <th>排序</th>
                                        <th>更新时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${list}" var="tbContentCategory">
                                        <tr id="${tbContentCategory.id}" pId="${tbContentCategory.parentCategory.id}">
                                            <td>${tbContentCategory.id}</td>
                                            <td>${tbContentCategory.name}</td>
                                            <td>${tbContentCategory.sortOrder}</td>
                                            <td><fmt:formatDate value="${tbContentCategory.updated}" pattern="yyyy-MM-dd HH:mm:ss" /> </td>
                                            <td>
                                                <a href='/category/form?id=${tbContentCategory.id}' class='btn btn-sm btn-info'><i class='fa fa-fw fa-edit' title='编辑'></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
                                                <a href='javascript:void(0)' onclick='Myshop.initDelete("/category/delete?ids=${tbContentCategory.id}","温馨提示","确定要删除该笔数据吗")' class='btn btn-sm btn-danger'><i class='fa fa-fw fa-trash-o' title='删除'></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
                                                <a href='/category/form?parentCategory.id=${tbContentCategory.id}&parentCategory.name=${tbContentCategory.name}' class='btn btn-sm btn-primary'><i class='fa fa-fw fa-plus' title='添加下级目录'></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- box -->
        </section>
    </div>
    <jsp:include page="${ctxPath}/footer.jsp"/>
</div>
<jsp:include page="${ctxPath}/foot.jsp"/>
<sys:modal/>
<script>

    $(function () {
        $("#treeTable").treeTable({
            expandLevel: 2,
            column: 1
        });
    })
</script>
</body>
</html>
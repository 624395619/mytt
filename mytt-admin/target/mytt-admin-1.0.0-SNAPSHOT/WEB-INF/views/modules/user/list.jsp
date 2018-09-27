<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/includes/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户列表</title>
    <jsp:include page="${ctxPath}/head.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="${ctxPath}/header.jsp"/>
    <jsp:include page="${ctxPath}/menu.jsp"/>
    <div class="content-wrapper">

        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>用户管理
                <small id="small">用户列表</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/main"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li class="active" id="menuName">用户管理</li>
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
                                <h3 class="box-title">用户列表</h3>
                            </div>
                                <ul class="nav nav-pills pull-left">
                                    <li><a href="/user/form"><i class="fa fa-fw fa-plus text-primary"></i> 新增</a></li>
                                    <li onclick="Myshop.editInfo('/user/form')"><a href="javascript:void(0)"><i class="fa fa-fw fa-edit text-info"></i> 编辑</a></li>
                                    <li onclick="Myshop.initDelete('/user/del','温馨提示','确定删除已选数据吗？')"><a href="javascript:void(0)"><i class="fa fa-fw fa-trash text-danger"></i> 删除</a></li>
                                </ul>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                       <%-- <div class="form-horizontal">--%>
                            <div class="box-body">
                                <div class="form-group ">
                                    <label class="col-sm-3 control-label text-right " style="line-height:36px;font-size: 16px">筛选条件:</label>
                                    <div class="col-sm-2">
                                        <input name="username" type="text" class="form-control" placeholder="用户名">
                                    </div>

                                    <div class="col-sm-2">
                                        <input name="email" type="text" class="form-control" placeholder="邮箱">
                                    </div>

                                    <div class="col-sm-2">
                                        <input name="phone" type="text" class="form-control" placeholder="手机">
                                    </div>
                                    <label class="col-sm-1 control-label"></label>
                                    <div class="col-sm-2">
                                        <button id="btnDataTableReset" type="button" class="btn btn-default">重置</button>
                                        <button id="btnDataTableSearch" type="button" class="btn btn-primary">搜索</button>
                                    </div>
                                </div>
                            </div>

                       <%-- </div>--%>
                        <!-- form end -->
                        <!-- box-body -->
                        <div class="box-body">
                            <div class="table-responsive">

                                <table id="dataTable" class="table table-bordered table-striped table-hover nowrap text-center">
                                    <thead>
                                    <tr>
                                        <th><input type="checkbox" class="minimal chk_master"></th>
                                        <th>用户名</th>
                                        <th>手机</th>
                                        <th>邮箱</th>
                                        <th>更新时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
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

        var dataTable = Myshop.initDataTables("/user/data",
            [
                {
                    data: function (row, type, set, meta) {
                        return "<input id='" + row.id + "' type='checkbox' class='minimal' />";
                    }
                },
                {data: 'username'},
                {data: 'phone'},
                {data: 'email'},
                {
                    data: function (row, type, set, meta) {
                        return DateTime.format(row.updated, "yyyy-MM-dd hh:mm:ss");
                    }
                },
                {
                    data: function (row, type, set, meta) {
                        return "<a href='javascript:void(0)' class='btn btn-sm btn-default' onclick='Myshop.selectInfo(\"/user/detail?id=\"+"+row.id+",\"用户个人信息\")'><i class='fa fa-fw fa-search' title='查看'></i></a>&nbsp;&nbsp;&nbsp;&nbsp;" +
                            "<a href='/user/form?id=" + row.id + "' class='btn btn-sm btn-info'><i class='fa fa-fw fa-edit' title='编辑'></i></a>&nbsp;&nbsp;&nbsp;&nbsp;" +
                            "<a href='javascript:void(0)' onclick='Myshop.initDelete(\"/user/del?ids=\"+"+row.id+",\"温馨提示\",\"确定要删除该笔数据吗？\")' class='btn btn-sm btn-danger'><i class='fa fa-fw fa-trash-o' title='删除'></i></a>";
                    }
                }
            ]);

    })
</script>
</body>
</html>
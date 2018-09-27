<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/includes/taglib.jsp" %>
<%@taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户信息</title>
    <jsp:include page="${ctxPath}/head.jsp"/>
    <link href="https://cdn.bootcss.com/dropzone/5.4.0/min/dropzone.min.css" rel="stylesheet">
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
                        <h3 class="box-title">${tbUser.id==0?"新增内容":"修改内容"}</h3>
                    </div>
                </div>
                <!-- /.box-header -->

                <!-- form start -->
                <form:form class="form-horizontal" action="/comment/save" id="commentForm" method="post" modelAttribute="tbComment">
                    <form:hidden path="id" />
                    <div class="box-body">

                        <div class="form-group">
                            <label class="col-sm-2 control-label">评论者的id</label>
                        <div class="col-sm-8">
                            <form:input path="tbUser.id"  class="form-control digits required" placeholder="作者的id" required="true"/>
                        </div>
                    </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">评论内容</label>
                            <div class="col-sm-8">
                                <form:input path="comContent"   rangelength="3,20" class="form-control" placeholder="评论内容" required="true"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">评论状态</label>
                            <div class="col-sm-8">
                                <form:input path="status"   rangelength="1,1" class="form-control digits" placeholder="评论状态" required="true"/>
                            </div>
                        </div>



                        <div class="form-group">
                            <label class="col-sm-2 control-label">点赞数</label>
                            <div class="col-sm-8">
                                <form:input path="praiseNum"   class="form-control digits" placeholder="点赞数" required="true"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">评论的内容id</label>
                            <div class="col-sm-8">
                                <form:input path="tbContent.id"   class="form-control" placeholder="点赞数" required="true"/>
                            </div>
                        </div>
                 <%--       <div class="form-group">
                            <label class="col-sm-2 control-label">封面地址</label>
                            <div class="col-sm-8">
                                <form:input path="coverPic"   class="form-control" placeholder="封面地址" required="true"/>
                            </div>
                        </div>--%>

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
<sys:modal title="请选择" message="<ul id='myTree' class='ztree'></ul>"/>
<script src="https://cdn.bootcss.com/zTree.v3/3.5.33/js/jquery.ztree.core.js"></script>
<script src="https://cdn.bootcss.com/dropzone/5.4.0/min/dropzone.min.js"></script>
<script type="text/javascript" charset="utf-8" src="/static/assets/ueditor/ueditor.config.js"> </script>
<script type="text/javascript" charset="utf-8" src="/static/assets/ueditor/ueditor.all.js"></script>

<script>
        UE.getEditor('container', {autoHeightEnabled: false, autoFloatEnabled:true});
    $(function () {
        Myshop.initZTree("/category/treeData","#categoryPid");
        Myshop.initDropZone("/upload/image","#dropzoneUpload","#coverPic");
    })
</script>
</body>
</html>
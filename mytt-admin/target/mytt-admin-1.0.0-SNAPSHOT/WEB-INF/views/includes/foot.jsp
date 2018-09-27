<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!-- jQuery 3 -->
<script src="/static/assets/bower_components/jquery/dist/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="/static/assets/bower_components/jquery-ui/jquery-ui.min.js"></script>

<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>



<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<!--jQuery validate 1.14.0 -->

<script src="/static/assets/app/jquery_vaoidate/jquery.js"></script>
<script src="/static/assets/app/jquery_vaoidate/jquery.validate.min.js"></script>
<script src="/static/assets/app/jquery_vaoidate/messages_zh.js"></script>

<%-- treeTable--%>
<script src="/static/assets/tree_table/jquery.treeTable.min.js"></script>
<%--ztree--%>
<script type="text/javascript" src="/static/assets/ztree/js/jquery.ztree.core-3.5.js"></script>

<!-- Bootstrap 3.3.7 -->
<script src="/static/assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="/static/assets/plugins/iCheck/icheck.min.js"></script>
<!-- DataTables -->
<script src="/static/assets/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="/static/assets/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- Slimscroll -->
<script src="/static/assets/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/static/assets/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/static/assets/dist/js/adminlte.min.js"></script>

<script src="/static/assets/app/DateTimeUtils.js"></script>
<script src="/static/assets/app/myshop.js"></script>

<script>
    $(function(){
            //展开下拉菜单
        $(".treeview").each(function(){
                if($("#small").parent().text().startsWith($("span:first",this).text())){
                    $(this).addClass("menu-open");
                    $(".treeview-menu",this).css("display","block");
                }
        })

            $(".user-menu").click(function(){
                    location.href="/user/view?id="+$("img",this).attr("alt");
            })
    })

    $.validator.setDefaults({
        submitHandler: function () {
            return true;
        }
    });
    $().ready(function () {
        $("#commentForm").validate();
    });

</script>

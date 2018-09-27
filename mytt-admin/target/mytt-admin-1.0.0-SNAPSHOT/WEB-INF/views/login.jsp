<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>登录</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="../../static/assets/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../static/assets/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../../static/assets/bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../static/assets/dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="../../static/assets/plugins/iCheck/square/blue.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    [endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.lug.ustc.edu.cn/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="#"><b>我的后台</b></a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">欢迎登录</p>

        <div class="form-group has-error">
            <label class="control-label"><i class="fa ${empty message?"":"fa-times-circle-o"}"></i>${message}</label>
        </div>

        <form action="/login" method="post">
            <div class="form-group has-feedback">
                <input type="email" id="email" name="email" value="${user.email}" class="form-control"
                       placeholder="邮箱">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" id="showPwd" name="password" value="${user.password}" class="form-control"
                       placeholder="密码" style="display: none">
                <input type="password" id="pwd" name="password" value="${user.password}" class="form-control"
                       placeholder="密码">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input name="remember" type="checkbox"> 记住我
                            <input name="autoLogin" type="checkbox"> 自动登录
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

    </div>
</div>
<!-- /.login-box -->

<!-- jQuery 3 -->
<script src="../../static/assets/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../../static/assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="../../static/assets/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {

        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' /* optional */
        });

        $.ajax({
            type: "POST", url: "/autoLogin", data: "",
            success: function (user) {

                if (user != "") {
                    //var u = eval("("+JSON.stringify(user)+")");
                    var u = JSON.parse(JSON.stringify(user));
                   // alert(JSON.stringify(user)+"========"+JSON.parse(JSON.stringify(user)).username);
                    if($("#email").val()==""){
                        $("#email").val(u.email);
                        $("#pwd").val(u.password);
                        $("#showPwd").val("******");
                    }

                    $("#pwd").hide();
                    $("#showPwd").show();

                    $("input:checkbox:first").iCheck("check");
                    if (u.autoLogin != null) {


                        $("input:checkbox:last").iCheck("check");
                        setTimeout(function () {
                           /* $("#pwd").show();
                            $("#showPwd").remove();*/
                            $("form").submit();
                        }, 2000)
                    }
                }

            }
        })


        $("form").submit(function(){
            if("******"!=$("#showPwd").val() && $("input:checkbox:last").is("checked")){
                $("#pwd").remove();
            }else{
                $("#showPwd").remove();
            }
            return true;
        })

        $("input:checkbox:last").on("ifChecked", function () {
            $("input:checkbox:first").iCheck("check");
        });
        $("input:checkbox:first").on("ifUnchecked", function () {
            $("input:checkbox:last").iCheck("uncheck");
        });
    })
</script>
</body>
</html>

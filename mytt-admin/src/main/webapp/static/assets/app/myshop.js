/**
 *
 * @type {{initDataTables}}
 */

var Myshop = function () {

    // 初始化 iCheck
    var handlerInitICheck = function () {
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass: 'iradio_minimal-blue'
        });
    };

    //初始化dataTables相关功能
    var handlerInitDataTables = function (url, columns) {

        //调用iCheck的初始化方法
        handlerInitICheck();

        var dataTable = $('#dataTable').DataTable({
            paging: true,
            processing: true,
            serverSide: true,
            searching: false,
            ordering: false,
            lengthChange: false,
            ajax: {
                url: url,
                type: "GET"
            },
            columns: columns,
            language: {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            drawCallback: function (settings) {
                //调用iCheck的初始化方法
                handlerInitICheck();

                // 全选
                $(".chk_master").iCheck("uncheck");
                $(".chk_master").on("ifClicked", function (event) {
                    if (!$(this).is(':checked')) {
                        $("#dataTable input[type='checkbox']").iCheck('check');
                    }

                    else {
                        $("#dataTable input[type='checkbox']").iCheck('uncheck');
                    }
                });
            }
        });
        bindEvent(dataTable);
        return dataTable;

        /**
         * 绑定事件
         *
         */
        function bindEvent(dataTable) {
            // 搜索
            $("#btnDataTableSearch").on("click", function () {
                var params = {};
                $(this).parents(".form-group").find("input").each(function () {
                    params[$(this).attr("name")] = $(this).val();
                })
                // 动态传参数
                dataTable.settings()[0].ajax.data = params;
                dataTable.ajax.reload();
            });

            // 搜索重置
            $("#btnDataTableReset").on("click", function () {
                window.location.reload();
            });

        }
    };

    //信息批量删除
    var handlerDelete = function (url,title,message) {
        var ids = "?";
        $(":checkbox:not(:first):checked").each(function () {
            ids += "ids=" + $(this).attr("id") + "&"
        })
        ids = ids.substring(0, ids.length - 1);
        if (ids == "" && url.split("?")[1]==undefined) {
            alert("请选中您要操作的数据项");
            return;
        } else {
            $("#modal-default .modal-title").text(title);
            $("#message").text(message);
            $("#modal-default").modal("show");
            $("#btnConfirmOK").click(function () {
                location.href = url.split("?")[1]!=undefined?url:url + ids;
                $("#modal-default").hide();
                return;
            })

        }
    };

    //信息编辑
    var handlerEdit = function (url) {
        if ($(":checkbox:not(:first):checked").length != 1) {
            alert("请选中一条数据项");
            $(":checkbox").iCheck("uncheck");
        } else {
            location.href = url + "?id=" + $(":checkbox:not(:first):checked")[0].id;
        }
    }
    //查看信息
    var handlerSelectInfo = function (url,title) {

        $("#modal-default .modal-title").text(title);
        $("#modal-default .modal-footer").hide();
        $("#modal-default").modal("show");
        $.ajax({
            type: "GET", url: url, dataType: "html",
            success: function (msg) {
                $("#modal-default #message").html(msg);
            }
        })
    }

    //初始化zTree控件
    var handlerInitZTree = function(url,clickInputId){
        var setting = {
            async: {
                enable: true,
                url: url,
                type:"GET",
                autoParam: ["id"]
            }
        };
        $.fn.zTree.init($("#myTree"), setting);

        $("#btnConfirmOK").bind("click", function () {
            var zTree = $.fn.zTree.getZTreeObj("myTree");
            var nodes = zTree.getSelectedNodes();

            //未选择
            if (nodes.length == 0) {
                alert("请选择一个节点");
            }

            //已选择
            else {
                $(clickInputId).val(nodes[0].name);
                $(clickInputId).prev().val(nodes[0].id);
                $("#modal-default").modal("hide");
            }

        })
    };


    //初始化treeTable
    var handlerInitTreeTable = function (ajax) {

        $('#treeTable').treeTable(ajax);
        $("#treeTable").treeTable({
            beforeClick: function ($treeTable, id) {
                //异步获取数据 这里模拟替换处理
                $treeTable.refreshPoint(id);
            }
        })
    };


    /**
     *初始化dropzone
     */
    var handlerInitDropZone = function (url,myDropZoneId,imageId) {

        $("div"+myDropZoneId).dropzone({
            paramName: "dropFile",
            maxFiles: 1,
            maxFilesize: 1,
            url: url,
            accept: function (file, done) {
                if (file.name.indexOf(".jpg") == -1 && file.name.indexOf(".png") == -1 &&
                    file.name.indexOf(".gif") == -1){
                    done("仅支持.jpg .png .gif ");
                }
                else {
                    done();
                }
            },
            init: function () {
                this.on("success", function (event, data) {
                    $(imageId).val(data.imageUrl);
                });
            }
        });
    };

    /**
     *
     * 初始化ueditor富文本编辑器
     */
    var handlerInitUeditor = function (editorId,contentId) {

        var myeditor = UE.getEditor(editorId, {
            autoHeightEnabled: true,
            //关闭自动保存功能
            //enableAutoSave: true,
            //,allHtmlEnabled:false //提交到后台的数据是否包含整个html字符串
            initialFrameWidth: null,
            initialFrameHeight: 100
        });

        //给输入框赋值
        myeditor.ready(function(){
            myeditor.setContent($(contentId).val());
            myeditor.addListener("contentChange",function(){
                window.setTimeout(function(){
                    $(contentId).val(myeditor.getContent());
                },300);
            })
        })
    }

    return {

        initDataTables: function (url, columns) {
            return handlerInitDataTables(url, columns);
        },
        initZTree:function(url,clickInputId){
            handlerInitZTree(url,clickInputId);
        },
        initTreeTable:function(ajax){
            handlerInitTreeTable(ajax);
        },
        initDropZone:function(url,myDropZoneId,imageId){
            handlerInitDropZone(url,myDropZoneId,imageId);
        },
        initUeditor:function(editorId,contentId){
            handlerInitUeditor(editorId,contentId);
        },
        initDelete: function (url,title,message) {
            return handlerDelete(url,title,message);
        },
        selectInfo: function (url,title) {
            handlerSelectInfo(url,title);
        },
        editInfo: function (url) {
            handlerEdit(url);
        }
    }
}();

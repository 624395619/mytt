<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" type="java.lang.String"  description="字典code"%>
<%@ attribute name="message" type="java.lang.String"  description="默认选中"%>

<div class="modal fade" id="modal-default" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span></button>
                <h4 class="modal-title" id="title">${title}</h4>
            </div>
            <div class="modal-body">
                <p id="message">${message}</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">取消</button>
                <button type="button" id="btnConfirmOK" class="btn btn-primary">确定</button>
            </div>
        </div>
    </div>
</div>


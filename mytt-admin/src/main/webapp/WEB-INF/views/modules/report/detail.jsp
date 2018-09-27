<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/includes/taglib.jsp" %>
<div class="box-body no-padding">
    <table class="table table-striped">
        <tbody>
        <tr>
            <th>id</th>
            <th>
                ${tbReport.id}
            </th>
            <th colspan="2"></th>
        </tr>

        <tr>
            <th>回复人</th>
            <th>
                ${tbReport.reporter.username}
            </th>
            <th colspan="2"></th>
        </tr>

        <tr>
            <th>被回复人</th>
            <th>
                ${tbReport.toReporter.username}
            </th>
            <th colspan="2"></th>
        </tr>

        <tr>
            <th>回复评论id</th>
            <th>
                ${tbReport.tbComment.id}
            </th>
            <th colspan="2"></th>
        </tr>
        <tr>
            <th>回复内容</th>
            <th>
                ${tbReport.reportContent}
            </th>
            <th colspan="2"></th>
        </tr>
        <tr>
            <th>处理状态</th>
            <th>
            ${tbReport.isDeal}
            </th>
            <th colspan="2"></th>
        </tr>

        <tr>
            <th>创建时间</th>
            <th>
                <fmt:formatDate value="${tbReport.created}" pattern="yyyy-MM-dd hh:mm:ss"/>
            </th>
            <th colspan="2"></th>
        </tr>
        <tr>
            <th>更新时间</th>
            <th>
                <fmt:formatDate value="${tbReport.updated}" pattern="yyyy-MM-dd hh:mm:ss"/>
            </th>
            <th colspan="2"></th>
        </tr>

        </tbody>
</div>

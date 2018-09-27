<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/includes/taglib.jsp" %>
<div class="box-body no-padding">
    <table class="table table-striped">
        <tbody>
        <tr>
            <th>id</th>
            <th>
                ${tbComment.id}
            </th>
            <th colspan="2"></th>
        </tr>

        <tr>
            <th>评论人</th>
            <th>
                ${tbComment.tbUser.username}
            </th>
            <th colspan="2"></th>
        </tr>

        <tr>
            <th>评论内容</th>
            <th>
                ${tbComment.comContent}
            </th>
            <th colspan="2"></th>
        </tr>

        <tr>
            <th>评论点数</th>
            <th>
                ${tbComment.praiseNum}
            </th>
            <th colspan="2"></th>
        </tr>
        <tr>
            <th>评论内容标题</th>
            <th>
                ${tbComment.tbContent.title}
            </th>
            <th colspan="2"></th>
        </tr>

        <tr>
            <th>创建时间</th>
            <th>
                <fmt:formatDate value="${tbComment.created}" pattern="yyyy-MM-dd hh:mm:ss"/>
            </th>
            <th colspan="2"></th>
        </tr>
        <tr>
            <th>更新时间</th>
            <th>
                <fmt:formatDate value="${tbComment.updated}" pattern="yyyy-MM-dd hh:mm:ss"/>
            </th>
            <th colspan="2"></th>
        </tr>

        </tbody>
    </table>
</div>

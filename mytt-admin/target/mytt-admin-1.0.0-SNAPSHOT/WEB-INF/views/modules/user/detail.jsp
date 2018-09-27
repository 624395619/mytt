<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/includes/taglib.jsp" %>
<div class="box-body no-padding">
    <table class="table table-striped">
        <tbody>
        <tr>
            <th>用户名</th>
            <th>
                ${tbUser.username}
            </th>
            <th colspan="2"></th>
        </tr>

        <tr>
            <th>手机</th>
            <th>
                ${tbUser.phone}
            </th>
            <th colspan="2"></th>
        </tr>

        <tr>
            <th>邮箱</th>
            <th>
                ${tbUser.email}
            </th>
            <th colspan="2"></th>
        </tr>

        <tr>
            <th>更新时间</th>
            <th>
                <fmt:formatDate value="${tbUser.updated}" pattern="yyyy-MM-dd hh:mm:ss"/>
            </th>
            <th colspan="2"></th>
        </tr>

        <tr>
            <th>创建时间</th>
            <th>
                <fmt:formatDate value="${tbUser.created}" pattern="yyyy-MM-dd hh:mm:ss"/>
            </th>
            <th colspan="2"></th>
        </tr>

        </tbody>
    </table>
</div>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/includes/taglib.jsp" %>
<div class="box-body no-padding">
    <table class="table table-striped">
        <tbody>
        <tr>
            <th>标题</th>
            <th>
                ${tbContent.title}
            </th>
            <th colspan="2"></th>
        </tr>

        <tr>
            <th>作者</th>
            <th>
                ${tbContent.tbUser.username}
            </th>
            <th colspan="2"></th>
        </tr>

        <tr>
            <th>父类</th>
            <th>
                ${tbContent.tbContentCategory.name}
            </th>
            <th colspan="2"></th>
        </tr>

        <tr>
            <th>地址</th>
            <th>
                ${tbContent.url}
            </th>
            <th colspan="2"></th>
        </tr>
        <tr>
            <th>封面地址</th>
            <th>
                ${tbContent.coverPic}
            </th>
            <th colspan="2"></th>
        </tr>
        <tr>
            <th>关键字</th>
            <th>
                ${tbContent.tagInfo}
            </th>
            <th colspan="2"></th>
        </tr>


        <tr>
            <th>创建时间</th>
            <th>
                <fmt:formatDate value="${tbContent.created}" pattern="yyyy-MM-dd hh:mm:ss"/>
            </th>
            <th colspan="2"></th>
        </tr>
        <tr>
            <th>更新时间</th>
            <th>
                <fmt:formatDate value="${tbContent.updated}" pattern="yyyy-MM-dd hh:mm:ss"/>
            </th>
            <th colspan="2"></th>
        </tr>

        </tbody>
    </table>
    <table>
        <tr>
            <th >内容</th>
        </tr>
        <div class="form-group "></div>
        <tr>
            <td>
                <div id="Myeditor"> ${tbContent.content}</div>
                <%--<textarea id="container" name="container" style="width: 850px; height: 400px; margin: 0 auto;"></textarea>--%>
            </td>
        </tr>
    </table>
</div>

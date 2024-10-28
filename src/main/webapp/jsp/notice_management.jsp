<%--
  Created by IntelliJ IDEA.
  User: stone
  Date: 2019-06-11
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="panel panel-default" style="margin-top: -8px;height: 790px; margin-left: 20px; margin-right: 40px">
    <div class="panel-heading" style="background-color: #fff">
        <h3 class="panel-title">
            公告列表
        </h3>
    </div>
    <div class="panel-body">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>内容</th>
                <th>时间</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${noticeList}" var="notice">
                <tr>
                    <td><c:out value="${notice.notice}"></c:out></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${notice.releaseTime}" timeZone="GMT+8"/></td>
                    <td>
                        <a href="#">
                            <button onclick="editNotice(${notice.serNum})" type="button" class="btn btn-success btn-sm">
                                编辑
                            </button>
                        </a>
                    </td>
                    <td>
                        <a href="#">
                            <button onclick="deleteNotice(${notice.serNum})" type="button" class="btn btn-danger btn-sm">
                                删除
                            </button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript">

    function editNotice(serNum) {
        $.ajax({
            type: 'post',
            url: 'getEditNotice',
            data: {
                serNum: serNum,
            },
            dataType: 'json',
            success: function () {
                //$("#display").html("");
                $("#display").load('notice_edit.html');
            }
        })
    }

    function deleteNotice(serNum){
        $.ajax({
            type: 'post',
            url: 'deleteNotice',
            data: {
                serNum: serNum
            },
            dataType: 'json',
            success: function (data) {
                if (data.stateCode.trim() === '0'){
                    alert("系统错误，删除失败！");
                } else if (data.stateCode.trim() === '1'){
                    alert("已删除！");
                    //$("#display").html("");
                    $("#display").load('notice_management.html');
                }
            }
        })
    }
</script>
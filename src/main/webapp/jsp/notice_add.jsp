<%--
  Created by IntelliJ IDEA.
  User: stone
  Date: 2019-06-12
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <script type="text/javascript" src="../js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
</head>
<body>
<div style="position: relative;padding-top: 20px; width: 40%;margin-left: 2%; font-size: 20px">
    <form  id="addRoom">
        <div class="form-group">
            <label for="notice">公告内容</label>
            <textarea class="form-control" rows="3" name="notice" id="notice"
                      placeholder="请输入公告内容"></textarea>
        </div>

        <input type="button" id="addRoomButton" value="添加" class="btn btn-success btn-sm" class="text-left">
        <input type="text" hidden id="adminId" class="text-left" value="${admin.adminId}">
        <script>
            $("#addRoomButton").click(function () {
                if ($("#notice").val() == '') {
                    alert("请填入完整公告信息！");
                } else {
                    var notice = $("#notice").val();
                    var adminId = $("#adminId").val();
                    $.ajax({
                        type: 'post',
                        url: 'doNoticeAdd',
                        data: {
                            adminId: adminId,
                            notice: notice,
                        },
                        dataType: 'json',
                        success: function (data) {
                            if (data.stateCode.trim() === '1'){
                                alert("添加成功！");
                                $("#display").load('notice_management.html');
                            } else if (data.stateCode.trim() === '0'){
                                alert("添加失败！");
                            }
                        }
                    })
                }

            })
        </script>
    </form>
</div>
</body>
</html>

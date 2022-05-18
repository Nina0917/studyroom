<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="keywords"  content = "studyroom java jsp"/>
    <meta http-equiv="author" content="phenix"/>
    <script src="./Js/prototype.lite.js" type="text/javascript"></script>
    <script src="./Js/moo.fx.js" type="text/javascript"></script>
    <script src="./Js/moo.fx.pack.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="./Style/skin.css" />
    <script type="text/javascript">
        window.onload = function () {
            var contents = document.getElementsByClassName('content');
            var toggles = document.getElementsByClassName('type');

            var myAccordion = new fx.Accordion(
            toggles, contents, {opacity: true, duration: 400}
            );
            myAccordion.showThisHideOpen(contents[0]);
            for(var i=0; i<document .getElementsByTagName("a").length; i++){
                var dl_a = document.getElementsByTagName("a")[i];
                    dl_a.onfocus=function(){
                        this.blur();
                    }
            }
        }
    </script>
</head>

<body>
    <table width="100%" height="200" border="0" cellpadding="0" cellspacing="0" >
        <tr>
            <td width="182" valign="top">
                <div id="container">
                    <%--会员管理界面，只有管理员登录才显示此界面--%>

                   <%-- <h1 class="type"><a href="javascript:void(0)">会员管理</a></h1>
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="./Images/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                        </table>
                        <ul class="RM">
                            <li><a href="./mem_add.jsp" target="main">会员开卡</a></li>
                            <li><a href="./mem_list.jsp" target="main">会员管理</a></li>
                            <li><a href="./mem_recharge.jsp" target="main">会员充值</a></li>
                        </ul>
                    </div>--%>



                        <%--图书管理界面，暂时用不到--%>

                    <%--<h1 class="type"><a href="javascript:void(0)">图书管理</a></h1>--%>
                    <%--<div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="./Images/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                        </table>
                        <ul class="RM">
                            <li><a href="./book_add.jsp" target="main">添加图书</a></li>
                            <li><a href="./book_list.jsp" target="main">图书列表</a></li>
                        </ul>
                    </div>--%>

                        <%--预约座位界面--%>
                    <h1 class="type"><a href="javascript:void(0)">Reserve Seats</a></h1>
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="./Images/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                        </table>
                        <%--这里需要从数据库拿数据动态展示有多少房间--%>
                        <ul class="RM">
                            <c:forEach items="${rooms}" var="r">
                                <li>
                                    <a href="./seat.let?roomId=${r.id}" target="main">Room${r.id}</a>
                                </li>
                            </c:forEach>
                            <%--<li><a href="./seat.let?" target="main">房间一</a></li>
                            <li><a href="./seat_list.jsp" target="main">房间二</a></li>--%>
                        </ul>
                    </div>


                        <%--用户已有预约界面，可以取消预约--%>
                    <h1 class="type"><a href="javascript:void(0)">My Reservation</a></h1>
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="./Images/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                        </table>
                        <ul class="RM">
                            <li><a href="./appointment.let?type=getAll" target="main">Unused</a></li>
                            <li><a href="./record.let?type=getAll" target="main">Record</a></li>
                            <li><a href="./book_rent.jsp" target="main">Balance</a></li>
                        </ul>
                    </div>

                    <!-- 个人中心 -->
                    <h1 class="type"><a href="javascript:void(0)">User Center</a></h1>
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="./Images/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                        </table>
                        <ul class="RM">
                            <li><a href="./set_pwd.jsp" target="main">Reset Password</a></li>
                        
                        </ul>
                    </div>
                   
                    <!-- *********** -->
                   
                    <div class="content">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><img src="./Images/menu_top_line.gif" width="182" height="5" /></td>
                            </tr>
                        </table>
                        <ul class="RM">
                            <li><a href="javascript:void(0)" target="main">友情连接</a></li>
                            <li><a href="javascript:void(0)" target="main">在线留言</a></li>
                            <li><a href="javascript:void(0)" target="main">网站投票</a></li>
                            <li><a href="javascript:void(0)" target="main">邮箱设置</a></li>
                            <li><a href="javascript:void(0)" target="main">图片上传</a></li>
                        </ul>
                    </div>
                    <!-- *********** -->
                </div>
            </td>
        </tr>
    </table>
</body>
</html>

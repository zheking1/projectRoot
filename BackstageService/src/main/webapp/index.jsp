<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/WEB-INF/js/index.js"></script>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%--IE兼容--%>
<body style="height: 100%">
<div style="height: 30%; width: 100%; border: 1px solid #000;">111</div>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-6 column">
        </div>
        <div class="col-md-4 column">
            <div class="container" id="container">
                <div class="row clearfix">
                    <form class="form-horizontal" id="form" role="form"
                          action="${pageContext.request.contextPath }/user/login" method="post">
                        <div class="form-group">
                            <label for="inputUsernamel3" class="col-sm-2 control-label">用户名</label>
                            <div class="col-sm-4">
                                <input type="text" name="username" onblur="usernameChacke()"
                                       onclick="closeUsernameWarning()" class="form-control" id="inputUsernamel3"/>
                            </div>

                        </div>
                        <div id="noUserName" class="alert alert-warning" style="display: none">
                            <a href="#" class="close" data-dismiss="alert">&times;</a>
                            <strong>警告！</strong>用户名错误，请重新输入。
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-4">
                                <input type="password" name="password" onclick="closePasswordWraning()"
                                       onblur="passwordChacke()" class="form-control" id="inputPassword3"/>
                            </div>
                        </div>
                        <div id="noPassword" class="alert alert-warning">
                            <a href="#" class="close" data-dismiss="alert">&times;</a>
                            <strong>警告！</strong>密码错误。
                        </div>
                        <div class="form-group">
                            <label for="imageContent" class="col-sm-2 control-label">验证码</label>
                            <div class="col-sm-4">
                                <input id="imageContent" style="width:120px; float: left;" name="imageContent"
                                       type="text" placeholder="验证码" maxlength="4" class="form-control">
                                <img id="imgObj" style="float: left;margin-left: 20px;" alt="验证码"
                                     src="${pageContext.request.contextPath }/captcha/getCaptchaImage"
                                     onclick="changeImg()">
                            </div>
                            <input id="timestamp" name="timestamp" value="${timestamp }" type="hidden">
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="button" onclick="clickeBut()" class="btn btn-default">登陆</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-2 column">
        </div>
    </div>
</div>
</body>
</html>

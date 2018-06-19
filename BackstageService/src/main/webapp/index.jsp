<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>
<script src="${pageContext.request.contextPath }/js/index.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<%--IE兼容--%>
<body style="height: 100%">
<input type="hidden" id="contextPath" value=<%=request.getContextPath() %> >
<div class="container">
    <div class="row clearfix">
        <div class="col-md-6 column">
        </div>
        <div class="col-md-4 column">
            <div class="container" id="container">
                <div class="row clearfix">
                    <form class="form-horizontal" id="form" role="form"
                          action="${pageContext.request.contextPath }/user/login.do" method="post">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">用户名</label>
                            <div class="col-sm-4">
                                <input type="text" name="username" class="form-control" />
                            </div>

                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-4">
                                <input type="password" name="password" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="imageContent" class="col-sm-2 control-label">验证码</label>
                            <img id="imgObj" style="float: left;margin-left: 20px;" alt="验证码" title="点击更换"
                                 src="${pageContext.request.contextPath }/captcha/getCaptchaImage.do"
                                 onclick="changeImg()">
                            <div class="col-sm-4">
                                <input id="imageContent" style="width:120px; float: left;" name="imageContent"
                                       type="text" placeholder="验证码" maxlength="4" class="form-control">
                            </div>
                            <input id="timestamp" name="timestamp" value="${timestamp }" type="hidden">
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" name="submit" id="login_from" class="btn btn-primary">登陆</button>
                                <div id="message" class="alert alert-warning" style="display: none; ">
                                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                                    <strong>警告！</strong><span id="warning"></span>
                                </div>
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

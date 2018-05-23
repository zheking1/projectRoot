// /**
//  * Created by Asus on 2018/3/29.
//  */
function usernameChacke() {
    var context =$("#contextPath").val();
    var username = $("#inputUsernamel3").val();
    if (username.length < 6) {
        $("#message").show();
        $("#warning").text("用户名错误，请重新输入。");
        return false;
    }
    $.ajax({
        type: "POST",
        url: context +"/check/usernameCheck.do",//请求的后台地址
        data: "username=" + username,//前台传给后台的参数
        success: function (msg) {//msg:返回值
            var data = JSON.parse(msg).msg;
            if (data == 2) {
                $("#noUserName").show();
                return false;
            }
        }

    });

}
/**
 * 更换验证码
 */
function changeImg() {
    var imgSrc = $("#imgObj");
    var src = imgSrc.attr("src");
    imgSrc.attr("src", chgUrl(src));
}
/**
 * 时间戳
 * 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
 */
function chgUrl(url) {
    var timestamp = (new Date()).valueOf();
    var stamp = $("#timestamp");
    url = url.substring(0, 60);
    if ((url.indexOf("$") >= 0 )) {
        url = url + "?tamp=" + timestamp;
    } else {
        url = url + "?timestamp=" + timestamp;
        stamp.val(timestamp);
    }
    return url;
}
/**
 * 提交
 */
function clickeBut() {
    //帐号
    var userName = $("#inputUsernamel3").val().trim();
    //密码
    var password = $("#inputPassword3").val().trim();
    //验证码
    var imageContent = $("#imageContent").val().trim();
    if (userName.length == 0) {
        $("#message").show();
        $("#warning").text("请输入帐号");
        return false;
    }
//  console.log(password);

    if (password.length == 0) {
        $("#message").show();
        $("#warning").text("请输入密码");
        return false;
    }
    if (imageContent.length == 0) {
        $("#message").show();
        $("#warning").text("请输入验证码");
        return false;
    } else if (imageContent.length < 4) {
        $("#message").show();
        $("#warning").text("验证码错误");
        return false;
    }
    usernameChacke();
    if(checkImageCode(imageContent) != true){
        $("#message").show();
        $("#warning").text("验证码错误");
        return false;
    }
    var context =$("#contextPath").val();

    $.ajax({
        type:"post",
        url:  context + '/user/login.do',
        data:"username="+userName+"&password="+ password,
        processData: false,
        success: function (msg) {
            var data = JSON.parse(msg).msg;
            if (data == 1) {
                $("#message").className="alert alert-success";
                $("#warning").text("登陆成功,即将跳转");
                $("#message").show();
                $.ajax({
                    type:"post",
                    url:  context + '/user/getRole.do',
                    data:"username="+userName
                });
            }else{
                $("#message").show();
                $("#warning").text("密码错误！");
            }
        },
        error:function(){
            $("#message").show();
            $("#warning").text("服务器出错！");
        }
    });

}
/**
 * 验证码校验
 */
function checkImageCode(s) {
    var context =$("#contextPath").val();
    //验证码
    var code = s.trim();
    var timestamp = $("#timestamp").val().trim();
//    console.log(code + " " + timestamp);
    var status = "";
    var boo = false;
    if (code.length != 0) {
        $.ajax({
            type: 'post',
            async: false,
            url: context+'/captcha/checkCaptcha.do',
            data: {
                "code": code
            },
            success: function (data) {
                status = data;
            }
        });
        if (status.indexOf("true") >= 0) {
            $("#imagCheck").val("true");
            $("#message").text("");
            boo = true;
        } else {
            changeImg();
            $("#message").show();
            $("#warning").text("验证码错误");
            return false;
        }
    } else {
        $("#message").show();
        $("#warning").text("请输入验证码");
        return;
    }
    return boo;
}
//密码检查
function passwordChacke() {
    if ($("#noPassword").length < 6) {
        $("#message").show();
        $("#warning").text("密码错误。");
        return false;
    }
}
/*
 关闭警告
 */
function closeUsernameWarning() {
    $("#message").hide();
}

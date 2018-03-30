// /**
//  * Created by Asus on 2018/3/29.
//  */
$("#noUserName").hide();
$("#noPassword").hide();
function usernameChacke() {
    var username = $("#inputUsernamel3").val();
    if (usernaem.length < 6) {
        $("#noUserName").show();
        return false;
    }
    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath }/check/usernameCheck",//请求的后台地址
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
        $("#message").text("请输入帐号");
        return false;
    }
//  console.log(password);

    if (password.length == 0) {
        $("#message").text("请输入密码");
        return false;
    }
    if (imageContent.length == 0) {
        $("#message").text("请输入验证码");
        return false;
    } else if (imageContent.length < 4) {
        $("#message").text("验证码错误");
        return false;
    }
    usernameChacke();

}
/**
 * 验证码校验
 */
function checkImageCode(s) {
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
            url: '${pageContext.request.contextPath }/check/checkCaptcha',
            data: {
                "code": code
            },
            success: function (data) {
                status = data;
            }
        });
        if (status.indexOf("true") >= 0) {
            document.getElementById("imgObj111").style.display = "block";
            $("#imagCheck").val("true");
            $("#message").text("");
            boo = true;
        } else {
            changeImg();
            document.getElementById("imgObj111").style.display = "none";
            $("#message").text("验证码错误");
            return false;
        }
    } else {
        $("#message").text("请输入验证码");
        return;
    }
    return boo;
}
//密码检查
function passwordChacke() {
    if ($("#noPassword").length < 6) {
        $("#noPassword").show();
        return false;
    }
}
/*
 关闭警告
 */
function closeUsernameWarning() {
    $("#noUserName").hide();
}
function closePasswordWraning() {
    $("#noPassword").hide();
}
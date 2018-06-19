// /**
//  * Created by Asus on 2018/3/29.
//  */
// function usernameChacke() {
//     var context =$("#contextPath").val();
//     var username = $("#inputUsernamel3").val();
//     if (username.length < 6) {
//         $("#message").show();
//         $("#warning").text("用户名错误，请重新输入。");
//         return false;
//     }
//     $.ajax({
//         type: "POST",
//         url: context +"/check/usernameCheck.do",//请求的后台地址
//         data: "username=" + username,//前台传给后台的参数
//         success: function (msg) {//msg:返回值
//             var data = JSON.parse(msg).msg;
//             if (data == 2) {
//                 $("#message").show();
//                 $("#warning").text("无此用户。");
//                 return false;
//             }
//         }
//
//     });
//
// }
//form验证规则
$(function (){
    $("#form").bootstrapValidator({
        message:'This value is not valid',
        feddbackIcons:{//提示图标
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields:{
            username:{//用户名校验
                message:'用户名格式不正确',
                validators:{//验证条件
                    notEmpty:{
                        message:'用户名不能为空'
                    },
                    stringLength:{
                        min:6,
                        max:14,
                        message:'用户名格式不正确'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: '用户名只能包含大写、小写、数字和下划线'
                    },
                    threshold:4,
                    remote:{
                        url:"/BackstageService/check/usernameCheck.do",
                        data:function(validator){
                            return{
                                username:$("#username").val()
                            };
                        },
                        message:'用户不存在',
                        delay:2000
                    }
                }

            },
            password:{
                message:'密码格式不正确',
                validators:{//验证条件
                    notEmpty:{
                        message:'密码不能为空'
                    },
                    stringLength:{
                        min:6,
                        max:14,
                        message:'密码长度为6-14字符'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: '用户名只能包含大写、小写、数字和下划线'
                    }
                }
            },
            imageContent:{
                message:'验证码不能为空',
                validators:{//验证条件
                    notEmpty:{
                        message:'验证码不能为空'
                    }
                }
            }
        }
    });
});
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
    $('#form').data('bootstrapValidator').validate();
    var flag = $('#appendant_form').data('bootstrapValidator').isValid()
    var context =$("#contextPath").val();
    if(flag&&checkImageCode()){
        $('#form').submit;
    }
}
/**
 * 验证码校验
 */
function checkImageCode() {
    var context =$("#contextPath").val();
    //验证码
    var code = $("#imageContent").val().trim();
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

/*
 关闭警告
 */
function closeUsernameWarning() {
    $("#message").hide();
}

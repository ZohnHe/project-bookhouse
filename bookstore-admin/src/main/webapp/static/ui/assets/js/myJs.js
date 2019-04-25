$(function () {
    $.ajax({
        type: "GET",
        url: "/user/getSession",
        success: function (data) {
            $(".my_thisName").text(data.uname);
        }
    });
    if ($.cookie("emailphone") == null) {
        $(".loginBox").removeClass("loginBox");
    } else {
        $(".bookCart").removeClass("bookCart");
        $(".loginName").removeClass("loginName");
    }
});

// 退出登录
$(".out_login").click(function () {
    $.cookie("emailphone",null,{expired:-1});
    $.cookie("password",null,{expired:-1});
    $.cookie("remember",null,{expired:-1});
    $.cookie("JSESSIONID",null,{expired:-1});
    location.reload();
});

// 展示书
$(".my_click").click(function () {
    location.href='toProduct';
});
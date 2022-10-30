var userName = $('.userName');
var email = $('.email');
var password = $('.password');
var rePassword = $('.re-password');
var errUserName = $('.errUserName');
var errEmail = $('.errEmail');
var errPassword = $('.errPassword');
var errRePassword = $('.errRePassword');


function submitFormRegister(){
    var chekForm = true;
    if (!checkUserName()){
        chekForm = false;
    }
    if (!checkEmail()){
        chekForm = false;
    }
    if (!checkPassword()){
        chekForm = false;
    }
    if (!checkRePassword()){
        chekForm = false;
    }
    return chekForm;
}

userName.blur(function (){
    checkUserName();
})
email.blur(function () {
    checkEmail();
})
password.blur(function () {
    checkPassword();
})
rePassword.blur(function () {
    checkRePassword();
})

userName.keydown(function () {
    userName.addClass("is-valid");
    userName.removeClass("is-invalid");
    errUserName.text("")
})

email.keydown(function () {
    email.addClass("is-valid");
    email.removeClass("is-invalid");
    errEmail.text("")
})

password.keydown(function () {
    password.addClass("is-valid");
    password.removeClass("is-invalid");
    errPassword.text("")
})

rePassword.keydown(function (){
    rePassword.addClass("is-valid");
    rePassword.removeClass("is-invalid")
    errRePassword.text("")
})

function checkUserName(){
    var userNameValue = userName.val().trim();
    if (userNameValue.length<3 || userNameValue.length>30){
        userName.addClass("is-invalid");
        userName.removeClass("is-valid");
        errUserName.text("Do dai userName tu 3-30 ky tu")
        return false;
    }
    userName.addClass("is-valid");
    userName.removeClass("is-invalid");
    errUserName.text("")
    return true;
}

function checkEmail(){
    var emailValue = email.val().trim();
    var regEmail = /^[a-z]+[0-9]*@([a-z0-9]+[.])+([a-z]{2,})$/i
    if (!regEmail.test(emailValue)){
        email.addClass("is-invalid");
        email.removeClass("is-valid")
        errEmail.text("Sai dinh dang email")
        return false;
    }
    email.addClass("is-valid");
    email.removeClass("is-invalid");
    errEmail.text("")
    return true;
}

function checkPassword(){
    var valuePassword = password.val().trim();
    if (valuePassword.length<6 || valuePassword.length>30){
        password.addClass("is-invalid");
        password.removeClass("is-valid");
        errPassword.text("Mat khau phai tu 6-30 ky tu")
        return false;
    }
    password.addClass("is-valid");
    password.removeClass("is-invalid");
    errPassword.text("")
    return true;
}

function checkRePassword(){
    var valueRePass = rePassword.val().trim();
    if (valueRePass!=password.val().trim() || valueRePass.trim().length == 0){
        rePassword.addClass("is-invalid");
        rePassword.removeClass("is-valid")
        errRePassword.text("Mat khau xac nhan phai trung voi mat khau chinh")
        return false;
    }
    rePassword.addClass("is-valid");
    rePassword.removeClass("is-invalid")
    errRePassword.text("")
    return true;
}


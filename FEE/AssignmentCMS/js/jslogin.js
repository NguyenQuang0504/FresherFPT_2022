    var emailElement = $('.email');
    var passwordElement = $('.password');
    var messEmail = $('.messageEmail');
    var messPass = $('.messagePassword');

    // function submit
    function submitFormLogin(){
        var checkSubmit = true;
        if (!checkEmail()){
            checkSubmit = false;
        }
        if (!checkPassword()){
            checkSubmit = false;
        }
        return checkSubmit;
    }

    //check blur
    emailElement.blur(function (){
        checkEmail();
    })
    passwordElement.blur(function (){
        checkPassword();
    })

    //check keydown
    emailElement.keydown(function () {
       emailElement.addClass("is-valid");
        emailElement.removeClass("is-invalid");
        messEmail.text('');
    })

    passwordElement.keydown(function () {
        passwordElement.addClass("is-valid");
        passwordElement.removeClass("is-invalid");
        messPass.text('');
    })

    //check validate
    function checkPassword(){
        var valuePass = passwordElement.val();
        if (valuePass.length < 8 || valuePass.length>30){
            passwordElement.addClass("is-invalid");
            passwordElement.removeClass("is-valid");
            messPass.text("Mat khau phai co do dai 8-30 ky tu");
            return false;
        }
        passwordElement.addClass("is-valid");
        passwordElement.removeClass("is-invalid");
        return true;
    }
    function checkEmail(){
        var value = emailElement.val();
        var regEmail = /^[a-z]+[0-9]*@([a-z0-9]+[.])+([a-z]{2,})$/i
        if (!regEmail.test(value)||value.length<5||value.length>50){
            emailElement.addClass('is-invalid');
            emailElement.removeClass('is-valid')
            messEmail.text("Sai dinh dang email");
            return false;
        }
        emailElement.addClass('is-valid');
        emailElement.removeClass('is-invalid')
        return true
    }

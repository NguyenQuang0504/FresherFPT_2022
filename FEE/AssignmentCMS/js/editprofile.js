$(document).ready(function (){
    var viewContent = $('.view-content-option');
    viewContent.click(function () {
        $.ajax({
            url: "/AssignmentCMS/viewcontent.html",
            dataType: "html"
        }).done(function(data){
            $("#profile").html('<h1>Loading</h1>')
            setTimeout(function(){
                var viewContent = $(data).find('.view-content');
                $("#profile").html(viewContent);
            },3000)
        })
    })
})
var firstName = $('.firstName');
var lastName = $('.lastName');
var phone = $('.phone');
var description = $('.description');
var errFirstName = $('.errFirstName');
var errLastName = $('.errLastName');
var errPhone = $('.errPhone');
var errDescription = $('.errDescription');

// check form edit profile
function submitFormEditProfile(){
    var checkForm = true;
    if (!checkFirstName()){
        checkForm = false;
    }
    if (!checkLastName()){
        checkForm = false;
    }
    // if (!checkEmail()){
    //     checkForm = false;
    // }
    if (!checkPhone()){
        checkForm = false;
    }
    if (!checkDescript()){
        checkForm = false;
    }
    return checkForm;
}

firstName.blur(function () {
    checkFirstName();
})
lastName.blur(function () {
    checkLastName()
})
phone.blur(function () {
    checkPhone();
})
description.blur(function () {
    checkDescript();
})
firstName.keydown(function () {
    firstName.addClass("is-valid");
    firstName.removeClass('is-invalid');
    errFirstName.text("");
})
lastName.keydown(function () {
    lastName.addClass("is-valid");
    lastName.removeClass("is-invalid");
    errLastName.text('');
})
phone.keydown(function () {
    phone.addClass("is-valid");
    phone.removeClass("is-invalid");
    errPhone.text('');
})
description.keydown(function () {
    description.addClass("is-valid");
    description.removeClass("is-invalid");
    errDescription.text('');
})
function checkFirstName(){
    var valueFirstName = firstName.val().trim();
    var regFirstName = /^[a-zA-Z ]{3,30}$/i
    if (!regFirstName.test(valueFirstName)){
        firstName.addClass("is-invalid");
        firstName.removeClass('is-valid');
        errFirstName.text("Sai dinh dang first Name");
        return false;
    }
    firstName.addClass("is-valid");
    firstName.removeClass('is-invalid');
    errFirstName.text("");
    return true;
}


function checkLastName(){
    var valueLastName = lastName.val().trim();
    var regLastName =  /^[a-zA-Z ]{3,30}$/i
    if (!regLastName.test(valueLastName)){
        lastName.addClass("is-invalid")
        lastName.removeClass("is-valid");
        errLastName.text("Sai dinh dang Last Name");
        return false;
    }
    lastName.addClass("is-valid");
    lastName.removeClass("is-invalid");
    errLastName.text('');
    return true;
}

function checkPhone(){
    var valuePhone = phone.val().trim();
    var regPhone =  /^[0-9]{9,13}$/i
    if (!regPhone.test(valuePhone)){
        phone.addClass("is-invalid")
        phone.removeClass("is-valid");
        errPhone.text("Phone gom 9-13 so");
        return false;
    }
    phone.addClass("is-valid");
    phone.removeClass("is-invalid");
    errPhone.text('');
    return true;
}

function checkDescript(){
    var valueDescription = description.val().trim();
    if (valueDescription.length > 200){
        description.addClass("is-invalid")
        description.removeClass("is-valid");
        errDescription.text("Description co do dai < 200 ky tu");
        return false;
    }
    description.addClass("is-valid");
    description.removeClass("is-invalid");
    errDescription.text('');
    return true;
}
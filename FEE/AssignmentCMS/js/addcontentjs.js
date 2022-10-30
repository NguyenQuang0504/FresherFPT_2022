$(document).ready(function () {
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

var title = $('.title');
var brief = $('.brief')
var content = $('.content');
var errTitle = $('.errTitle');
var errBrief = $('.errBrief');
var errContent = $('.errContent');
function submitContent(){
    var checkSubmit = true;
    if (!checkTitle()){
        checkSubmit = false;
    }
    if (!checkBrief()){
        checkSubmit = false;
    }
    if (!checkContent()){
        checkSubmit = false;
    }
    return checkSubmit;
}

title.blur(function () {
    checkTitle();
})
content.blur(function () {
    checkContent();
})
brief.blur(function () {
    checkBrief();
})
title.keydown(function () {
    title.addClass("is-valid");
    title.removeClass("is-invalid");
    errTitle.text("");
})
content.keydown(function () {
    content.addClass("is-valid");
    content.removeClass("is-invalid");
    errContent.text("");
})
brief.keydown(function () {
    brief.addClass("is-valid");
    brief.removeClass("is-invalid");
    errBrief.text("");
})
function checkTitle(){
    var valueTitle = title.val().trim();
    if (valueTitle.length <10 || valueTitle.length > 200){
        title.addClass("is-invalid");
        title.removeClass("is-valid");
        errTitle.text("Title co do dai 10-200");
        return false;
    }
    title.addClass("is-valid");
    title.removeClass("is-invalid");
    errTitle.text("");
    return true;
}
function checkBrief(){
    var valueBrief = brief.val().trim();
    if (valueBrief.length <30 || valueBrief.length > 150){
        brief.addClass("is-invalid");
        brief.removeClass("is-valid");
        errBrief.text("Brief co do dai 30-150");
        return false;
    }
    brief.addClass("is-valid");
    brief.removeClass("is-invalid");
    errBrief.text("");
    return true;
}
function checkContent(){
    var valueContent = content.val().trim();
    if (valueContent.length <50 || valueContent.length >1000){
        content.addClass("is-invalid");
        content.removeClass("is-valid");
        errContent.text("Content co do dai 50-200");
        return false;
    }
    content.addClass("is-valid");
    content.removeClass("is-invalid");
    errContent.text("");
    return true;
}

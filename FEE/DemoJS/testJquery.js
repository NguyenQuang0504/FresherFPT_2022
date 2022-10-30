$(document).ready(function () {
    let buttonElement = $(".button");
    let wrapperElement = $(".wraper");
    let mess = $('.message');
    const regex = /^[0-9]$/
    var input1 = $('.inputTest');
    input1.blur(function () {
        if (regex.test(input1.val())){
            mess.text('');
        }
        else {
            mess.text('Sai dinh dang input');
        }
    });
    input1.keydown(function (){
        mess.text('');
    })

    function check() {
        if (regex.test(input1.val())){
            mess.text('');
        }
        else {
            mess.text('Sai dinh dang input');
        }
    }

    buttonElement.bind("click",function () {
        alert($("img").attr("src"));
        $("img").attr("src", "https://vcdn1-vnexpress.vnecdn.net/2022/02/09/rose-3044-1632474432-7692-1644390109.jpg?w=0&h=0&q=100&dpr=1&fit=crop&s=VvudQbTWU2GCMeL87WTLGg");
        $('.mn').append("<div><p>Add item</p><button class='remove'>Remove</button></div>");
    });

    $("body").on("click", ".remove", function(){
        // remove the div la cha cua the button remove
        $(this).parent("div").remove();
        // lay ra text the p
        alert($(this).parent("div").children("p").html());
    });

})
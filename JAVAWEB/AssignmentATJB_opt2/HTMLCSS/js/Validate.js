function getSubmit(){
    document.getElementById("messageMaKH").innerText = "";
    document.getElementById("messageEmail").innerText = "";
    document.getElementById("messageSDT").innerText = "";
    document.getElementById("messageDV").innerText = ""
    if (!checkMaDV()){
        document.getElementById("messageDV").innerText = "MaDV invalid"
    }
    if (!checkMaKH()){
       document.getElementById("messageMaKH").innerText = "MaKH invalid";
   }
    if (!checkPhone()){
        document.getElementById("messageSDT").innerText = "SDT invalid";
    }
    if (!checkEmail()){
        document.getElementById("messageEmail").innerText = "Email invalid";
    }
}

function checkPhone(){
    var REG_PHONE = /^(090|091|(84)+90|(84)+91)[0-9]{7}$/
    var sdt = document.getElementById("phone").value;
    if (!sdt || !REG_PHONE.test(sdt)){
        console.log("false")
        return false;
    }
    console.log("true");
    return  true;
}

function checkEmail(){
    var REG_EMAIL = /^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\.[A-Za-z0-9]+)$/
    var email = document.getElementById("email").value;
    if (!email || !REG_EMAIL.test(email)){
        return false;
    }
    return true;
}
function checkMaKH(){
    var REG_MAKH = /^(KH)[0-9]{4}$/
    var maKH = document.getElementById("maKH").value;
    if (!maKH || !REG_MAKH.test(maKH)){
        return false;
    }
    return true;
}

function checkMaDV(){
    var REG_DV = /^(DV)[0-9]{4}$/
    var maDV = document.getElementById("maDV").value;
    if (!maDV || !REG_DV.test(maDV)){
        return false;
    }
    return  true;
}
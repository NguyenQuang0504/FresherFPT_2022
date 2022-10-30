function validateLogin() {
    var userName = document.getElementById("userName");
    var password = document.getElementById("password");
    if (userName.value !== "" && password.value !== ""){
        return true;
    }
    if (userName.value == ""){
        userName.style.borderColor = "red";
    }
    if (password.value == ""){
        password.style.borderColor = "red";
    }
    return false;
}

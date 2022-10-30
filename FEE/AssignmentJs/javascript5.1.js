
function showUser(){
    let user = {
        fullName : document.getElementById("name").value,
        date: document.getElementById("date").value,
        gender : document.querySelector('input[name="gender"]:checked').value
    }
    let date = new Date();
    let date1 = new Date(user.date);
    user.date = (date.getFullYear() - date1.getFullYear());
    console.log("User vua nhap: " +user.fullName +" : " +user.date+ " : " +user.gender)
    alert("User vua nhap Name:" +user.fullName +" Age: " +user.date+ " Gender: " +user.gender);
}
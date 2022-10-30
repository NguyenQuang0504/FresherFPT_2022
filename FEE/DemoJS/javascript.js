// validateFormES6 = (a, b) => {
//
//     //1. Design layout: use bootstrap
//
//     //2. validate.
//
//     //REGEX JAVASCRIPT:
//
//     // Name:(chỉ cho phép nhập số và khoảng trắng)
//
//     // Email: nhập theo định dạng email,
//
//     // Phone: chỉ cho phép nhập đầu số 09, và cho phép 10 số
//
//     // Date: yyyy/MM/dd
//
//     // Number(tiền, tuổi, số lượng): chỉ cho phép nhập số
//
//     // textbox, radio box, selectbox,
//
//     //3.  Thêm row vào table:
//
//     //4.  Delete row
//
//
//     //document.getElementsByClassName("messsage")[1].innerHTML = "<b>Update values for Element By Class Name from Element Id:</b>";
//     validateForm(a,b);
//     let x = document.forms["myForm"]["fname"].value;
//
//
//     if (x == "") {
//
//         alert("Name must be filled out");
//
//         error.innerHTML += 'Name is required';
//
//         return false;
//
//     }
//
// }
const regexSdt = /^(03|09|01)[0-9]{8}$/;
let elementNode =  document.getElementById("fname");
function validateSdt(){
    var err = document.getElementById("errorFName");
    if (elementNode.value == ""){
        err.innerHTML = "<p>Khong duoc de trong</p>";
    }
    else if(!regexSdt.test(elementNode.value)) {
        err.innerHTML = "<p>phone sai dinh dang</p>"
    }else {
        err.innerHTML = "";
    };
}
function nocheck(){
    var err = document.getElementById("errorFName");
    err.innerHTML = "";
}

//test map
let arr = [1,2,3,4,5,6,7];
let arr2 = arr.map(function (element, index) {
  return element+1  ;
})
console.log(arr2);

//test update
arr.splice(1,0,1,2,3,4,5);
console.log(arr);
let sumOld=0;
let sumEven = 0;
function testReduce(value, element, index, arr){
    if (element % 2==0){
        sumOld += element;
        return value + element;
    }
    sumEven+=element;
    return value;
}
var arr1 = arr.reduce(testReduce, 0)
console.log(arr1);
console.log(sumEven);
console.log(sumOld);
console.log(arr.filter(function (element, index){
    console.log(index)
    return element%2==0;
})
)
console.log(arr.slice(2,3));
var add = new Function("num1", "num2", "return num1 + num2");
console.log(add(2,5))
// Online Javascript Editor for free
// Write, Edit and Run your Javascript code using JS Online Compiler

var numbers = ['a','a','a','b','c','c','a','b']

// i = 0, j = 1-7 =>

var result = deduplicate(numbers);

console.log("ok" +result);

function deduplicate(arr){
    let arrLength = arr.length;
    for(let i = 0; i < arrLength; i++){
        for(var j = i + 1; j < arrLength ; j++){
            if(arr[i] === arr[j]){
                for(let k = j; k < arrLength; k++){
                    arr[k] = arr[k+1];
                }
            }
        }
    }
    return arr;
}



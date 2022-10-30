import {object} from "./exportJs.js";

var {name: nameObj, age: ageObj, major: majorObj} = object;
console.log(nameObj + ageObj + majorObj)
var arr = [1,2,3,4,5,6,7,8];
var [a,b,c,...rest] = arr;
console.log(rest);
var arr2 = ["Quang", "Yeu", "Thuy"];
var arr3 = [rest, ...arr2];
console.log("arr3 la" +arr3);
var log = (arr) => {
    let sum = 0;
    for (let element of arr){
        sum+=element;
    }
    return sum;
}
arr.forEach(
(element, index) => {
    console.log(element);
})
console.log(log(arr));
var arr5 = arr.map((value, index, arr1) => {
    return value+index;
})
console.log(arr5);
var totalLe = arr.reduce((total, arr) => {
    if (arr %2 ==0 ){
        total = total+arr
    }
    return total
},0)
var arrLe = arr.filter(((element, index) => {
    if (element % 2 ===0){
        return element
    }
}))
var arrChan = arr.filter((element, index) => {
    if (element %2 !==0){
        return element;
    }
})
console.log("mang la: " +arr)
console.log("Tong cac so chan cua mang la: "+totalLe)
console.log("Mang chan la: " +arrLe)
console.log("mang le la: " +arrChan.sort((first, second) => {
    return second - first;
}))
console.log(arr.findIndex((element, index) => {
    if (element === 8){
        return index;
    }
}))
arr.splice(1,2,3,4,5)
console.log(arr)
console.log(
arr.find((element, index) => {
    if (element === 3){
        return element;
    }
})
)
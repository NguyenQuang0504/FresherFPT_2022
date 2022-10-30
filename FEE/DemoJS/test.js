function check(){
    var input1 = document.getElementById('input-date1');
    var input2 = document.getElementById('input-date2');
    console.log(input2.value)
    var date1  = new Date(input1.value);
    var date2 = new Date(input2.value)
    console.log(date2, date1)
    console.log(date1.getTime()-date2.getTime());
    compare_date(date1, date2); //both are equal
    compare_date(d1, d2); //date1 is greater than date2
}
function compare_date (date1, date2){
    if (date1.getTime() < date2.getTime())
        console.log("date1 is lesser than date2");
    else if (date1.getTime() > date2.getTime())
        console.log("date1 is greater than date2");
    else
        console.log("both are equal");

}

let d1 = new Date('2021-10-23');
let d2 = new Date('2021-10-22');



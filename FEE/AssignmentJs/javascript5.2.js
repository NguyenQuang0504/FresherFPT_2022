alert("Test alert")
class User{
    constructor(id, firstName, lastName, email, gender, age, salary) {
        this._id = id;
        this._firstName = firstName;
        this._lastName = lastName;
        this._email = email;
        this._gender = gender;
        this._age = age;
        this._salary = salary;
    }

    get id() {
        return this._id;
    }

    set id(value) {
        this._id = value;
    }

    get firstName() {
        return this._firstName;
    }

    set firstName(value) {
        this._firstName = value;
    }

    get lastName() {
        return this._lastName;
    }

    set lastName(value) {
        this._lastName = value;
    }

    get email() {
        return this._email;
    }

    set email(value) {
        this._email = value;
    }

    get gender() {
        return this._gender;
    }

    set gender(value) {
        this._gender = value;
    }

    get age() {
        return this._age;
    }

    set age(value) {
        this._age = value;
    }

    get salary() {
        return this._salary;
    }

    set salary(value) {
        this._salary = value;
    }
}
let user1 = new User(1, "Eamon", "Harhoff", "eharhoff0@imageshack.us", "Male",76, 18888);
let user2 = new User(2,"Laney", "Whittam", "lwhittam1@issuu.com", "Female", 42, 15018);
let user3 = new User(3, "Lynett", "Twinberrow", "ltwinberrow2@gov.uk", "Female", 99, 13343 );

let arrUser = [user1, user2, user3];
for (let i = 0 ; i< arrUser.length;i++){
    document.writeln(arrUser[i].firstName);
}

 // Yeu cau 1: Dung filter hien thi user co age>40 va la male
let arrUserFilter = arrUser.filter(function (user) {
    return (user.age>40 && user.gender == "Male");
})
console.log("List user: " +arrUserFilter.toString());

// Yeu cau 2: Dung map hien thi userName
let arrFullName = arrUser.map(function (user) {
    return user.firstName+ " " +user.lastName;
})
console.log("List Full Name: " +arrFullName);

//Yeu cau 3: Dung recude tinh tuoi trung binh
function avgFunction(value, currentArr, currentIndex, arr){
    value = value + currentArr.age;
    if (currentIndex == arr.length-1){
        return (value / arr.length + 1);
    }
   return value;
}
var avgAge = arrUser.reduce(avgFunction, 0);
console.log("Total Age: " +avgAge);
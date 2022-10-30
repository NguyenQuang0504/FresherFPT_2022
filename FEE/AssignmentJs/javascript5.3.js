var arrList = ["Nguyen van Quang", "Duong Thi Thuy"];
var html;
var indexUpdate;

//function show list
function showList() {
    html = "";
    for (var i = 0; i < arrList.length; i++) {
        html = html + `<tr>
                <td class="column1"><p>`+arrList[i] +`</p></td>
                <td><button type="button" class="btn btn-primary" onclick=update(`+i+`)>Update</button></td>
                <td><button type="button" class="btn btn-danger" onclick=delete1(`+i+`)>Delete</button></td>
            </tr>`;
    }
    // debugger;
    document.getElementById("table").innerHTML = html;
}

// function add new item
function addItem(){
    var todo = document.getElementById("todolist").value;
    if (todo!= "") {
        html = "";
        if (indexUpdate==undefined) {
            arrList.unshift(todo);
            showList();
            document.getElementById("todolist").value = "";
            document.getElementById("validate").innerHTML = "";
        }
        else {
            arrList.splice(indexUpdate, 0, todo);
            showList()
            document.getElementById("todolist").value = "";
            document.getElementById("validate").innerHTML = "";
        }
    }
    else {
        document.getElementById("message").innerText = "Không được để trống trường này";
    }
}

// method clear
let clearElement = document.getElementById("clear");
clearElement.onclick =function (){
    html = "";
    arrList = [];
    showList();
}

// function delete item
function delete1(index){
    arrList.splice(index, 1);
    showList();
}

// function update
function update(index){
    if (document.getElementById("todolist").value==""){
        indexUpdate = index;
        var elementPop = arrList.splice(index, 1);
        document.getElementById("todolist").value = elementPop;
        showList();
    }else {
        alert("Ban dang update item " +document.getElementById("todolist").value)
    }

}
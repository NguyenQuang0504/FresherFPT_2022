$(document).ready(function() {
    $("#btn-addEmp").click(function() {
        var employeeName = $("#employeeName").val();
        var gender = $("input[name=gender]:checked").val();
        var dateOfBirth = $("#dateOfBirth").val();
        var deptId = $("#dept").val();
        alert(employeeName);
        $.post({
            url : "/add-emp",
            data : {
                employeeName : employeeName,
                gender : gender,
                dateOfBirth : dateOfBirth,
                deptId : deptId
            },
            success : function(response) {
                $(".container").html(response);
            }
        });
    });
});
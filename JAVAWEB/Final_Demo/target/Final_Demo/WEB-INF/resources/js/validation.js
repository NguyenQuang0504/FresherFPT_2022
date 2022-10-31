function handlerSubmit(){
	if (checkHours() && checkNgay()){
		return true;
	}else {
		return false;
	}
}

// method doi gio sang giay
function convertTime(time){
	const [hours, minutes] = time.split(':');
	const totalSeconds = (+hours) * 60 * 60 + (+minutes) * 60;
	return totalSeconds;
}

//method check gio
function checkHours(){
	document.getElementById('messageTime').innerText = "";
	let timeBD = convertTime(document.getElementById("timeBD").value);
	let timeKT = convertTime(document.getElementById("timeKT").value);
	if (timeKT-timeBD<=0){
		document.getElementById('messageTime').innerText = "Sai rồi!!!"
		return false;
	}
	document.getElementById('messageTime').innerText = "";
	return true;
}

function checkNgay(){
	document.getElementById("messageDate").innerText = "";
	let date = new Date(document.getElementById("date").value);
	alert(date-new Date())
	if (date - new Date()<0){
		document.getElementById("messageDate").innerText = "Lỗi ngày";
		return false;
	}else {
		return  true;
	}
}
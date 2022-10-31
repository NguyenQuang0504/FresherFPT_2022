function handlerSubmit(){
	let check = true;
	if (!checkSDT()){
		check = false;
	}
	if (!checkNgay()){
		check = false;
	}
		return check;
}

function checkSDT(){
	let sdt = document.getElementById('sdt1').value;
	document.getElementById('messageSDT').innerText = "";
	let REG = /^[0-9]{10,11}$/
	if (!REG.test(sdt)){
		document.getElementById('messageSDT').innerText = "So dien thoai phai bao gom 10 hoac 11 so";
		return false;
	}
	return true;
}


// check ngay đăng ký
function checkNgay(){
	document.getElementById("messageDk").innerText = "";
	let date = new Date(document.getElementById("ngayDK").value);
	if (date - new Date()<=0){
		document.getElementById("messageDk").innerText = "Ngay dk phai lon hon ngay hien tai!!!";
		return false;
	}else {
		return  true;
	}
}
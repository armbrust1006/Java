function idCheckForm() {
	window.open("idCheck", "중복 검사", "width=500, height=200, top=100, left=100");
}

function idCheck() {
	var id = document.getElementById("custid").value;

	var checkId = document.location.href = "idCheck";

	if (checkId != '') {
		document.getElementById("custid").value = id;
	}
}

function joinCheck() {
	var custid = document.getElementById("custid").value;
	var pw1 = document.getElementById("password1").value;
	var pw2 = document.getElementById("password2").value;
	var name = document.getElementById("name").value;

	if (custid.length == 0) {
		alert("id 를 입력해주세요");
		return false;
	}
	if (pw1.length == 0) {
		alert("password 를 입력해주세요");
		return false;
	}
	if (pw2.length == 0) {
		alert("password 확인을 입력해주세요");
		return false;
	}
	if (name.length == 0) {
		alert("name 을 입력해주세요");
		return false;
	}
	if (pw1 != pw2) {
		alert("비밀번호가 다릅니다.");
		return false;
	}
	if (custidid.length < 3 || id.length > 10) {
		alert("ID는 3~10 자리로 입력해주세요");
		return false;
	}
	if (pw1.length < 3 || pw1.length > 10) {
		alert("PW는 3~10 자리로 입력해주세요");
		return false;
	}

	return true;
}

function updateCheck() {
	var pw1 = document.getElementById("password1").value;
	var pw2 = document.getElementById("password2").value;
	var name = document.getElementById("name").value;
	
	if (pw1.length == 0) {
		alert("password를 입력해주세요");
		return false;
	}
	if (pw2.length == 0) {
		alert("password확인을 입력해주세요");
		return false;
	}
	if (name.length == 0) {
		alert("name을 입력해주세요");
		return false;
	}
	if (pw1 != pw2) {
		alert("비밀번호가 다릅니다.");
		return false;
	}
	if (pw1.length < 3 || pw1.length > 10) {
		alert("PW는 3~10 자리로 입력해주세요");
		return false;
	}

	return true;
}
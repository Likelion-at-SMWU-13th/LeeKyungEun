function modifyPassword() {
    let currentPw = prompt("현재 비밀번호를 입력하세요");
    let pw1, pw2;
    if (currentPw != "" && currentPw != null) {
        pw1 = prompt("변경할 비밀번호를 입력하세요");
        if (pw1 != "" && pw1 != null) {
            pw2 = prompt("비밀번호 확인을 위해 다시 입력해주세요.")
            while (true) {
                if (pw1 == pw2 || pw2 == null) {
                    confirm("비밀번호 변경 성공!");
                    break;
                }
                else {
                    pw2 = prompt("비밀번호가 일치하지 않습니다. 다시 입력하세요.")
                }
            }
        }
    }
}

const img = document.getElementById("profileImg");
img.addEventListener("mouseover", function() {
    img.src = "./images/프로필사진2.png";
})
img.addEventListener("mouseout", function() {
    img.src = "./images/프로필사진.png"
})


const add_insertFile = () => {
	const box = document.getElementById('fileBox');
	const newP = document.createElement('p');
	newP.innerHTML = "<input id='#' type='file' name='saveGoodsImage' accept='.jpg,.jpeg,.png,.gif' />";
	box.appendChild(newP);
}


const add_updateFile = () => {
	const box = document.getElementById('fileBox');
	const newP = document.createElement('p');
	newP.innerHTML = "<input id='#' type='file' name='plusGoodsImage' accept='.jpg,.jpeg,.png,.gif' />";
	box.appendChild(newP);
}


function checkForm() {
	if (document.getElementByClass('essential') == "") {
		window.alert("상품에는 상품명, 상품가격, 상품설명 및 상품관련 이미지(1개 이상) (이)가 반드시 입력되어야 합니다.");
		return false;
	}
}

const changeMainIma = () => {
	var bigPic = document.querySelector("#mimg");
	var smallPics = document.querySelectorAll(".arimg");
	for(var i = 0; i < smallPics.length; i++){
		smallPics[i].addEventListener("click", changePic);	//이벤트 처리
		/*
		onclick으로 하면 하나의 요소에 하나의 이벤트만 사용 가능 > 여러 이벤트를 처리해야할 경우 사용 불가
		smallPics[i].onclick = changePic;
		 */
	}
	function changePic(){
		var smallPicAttribute = this.getAttribute("src");
		bigPic.setAttribute("src", smallPicAttribute);
	}
}



document.getElementById("salesbtn").onclick =  function orderCheck(){
/*	var pop = window.open("/orderPopup.html", "주문확인", "left=10, top=10, width=500, height=500");*/
			if(confirm("주문을 하시겠습니까?") == true){
				return true;
			}else{
				return false;
			}
}
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
	if (document.getElementById('essential') == "") {
		window.alert("상품에는 상품명, 상품가격, 상품설명 및 상품관련 이미지(1개 이상) (이)가 반드시 입력되어야 합니다.");
		return false;
	}
}

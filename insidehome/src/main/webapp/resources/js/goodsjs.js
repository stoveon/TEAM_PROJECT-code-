const add_insert = () => {
	const box = document.getElementById("fileBox");
	const newP = document.createElement('p');
	newP.innerHTML = "<input type='file' name='saveGoodsImages' accept='.jpg,.jpeg,.png,.gif'>";
	box.appendChild(newP);
}

const add_file = () => {
	const box = document.getElementById("fileBox");
	const newP = document.createElement('p');
	newP.innerHTML = "<input type='file' name='plusGoodsImages' accept='.jpg,.jpeg,.png,.gif'>";
	box.appendChild(newP);
}

function checkForm(){
	if(document.getElementById("essential") == ""){
		alert("상품에는 상품명, 상품가격, 상품설명 및 상품관련 이미지(1개 이상) (이)가 반드시 입력되어야 합니다.");
		return false;
	}
}




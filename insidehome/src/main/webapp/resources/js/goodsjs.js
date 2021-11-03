function getContextPath(){
    var offset=location.href.indexOf(location.host)+location.host.length;
    var ctxPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
    return ctxPath;
}

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


function checkForm(){
			if(document.goodsForm.goodsName.value == "" || document.goodsForm.content.value == "" || document.goodsForm.stock.value == ""){
		if(document.goodsForm.goodsName.value == ""){
			alert("상품 이름이 입력되지 않았습니다.");
			document.goodsForm.goodsName.focus();
			return false;
		}
		if(document.goodsForm.content.value == ""){
			alert("내용이 입력되지 않았습니다.");
			document.goodsForm.content.focus();
			return false;
		}
		if(document.goodsForm.stock.value == ""){
			alert("수량을 선택해주세요.");
			return false;
		}
		}else{
			if(confirm("상품을 등록하시겠습니까?") == true){
				return true;
			}else{
				return false;
			}
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
	if(confirm("구매 하시겠습니까?") == true){
		var pop = window.open("orderPopup", "_blank", "left=300px, top=200px, width=300px, height=200px");
		pop.document.getElementById("orderOk").value = opener.document.getElementById("goodsName").value;
	}else{
		return false;
	}
	
}

document.getElementById("addrChange").onclick = function addrChange(){
	if(confirm("배송지변경은 [마이페이지-내정보수정]에서만 가능합니다.                           변경하시겠습니까?") == true){
		return window.location.href = getContextPath()+'/user/mypage/main.do';
	}else{
		return false;
	}
}
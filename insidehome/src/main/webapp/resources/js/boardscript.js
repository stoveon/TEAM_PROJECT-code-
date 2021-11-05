function getContextPath(){
    let offset=location.href.indexOf(location.host)+location.host.length;
    let ctxPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
    return ctxPath;
}

const add_inFile = () => {
	const box = document.getElementById('boardFileBox');
	const newP = document.createElement('p');
	newP.innerHTML = "<input type='file' name='saveBoardImage' accept='.jpg,.jpeg,.png,.gif' />";
	box.appendChild(newP);
}

const add_upFile = () => {
	const box = document.getElementById('boardFileBox');
	const newP = document.createElement('p');
	newP.innerHTML = "<input type='file' name='plusBoardImage' accept='.jpg,.jpeg,.png,.gif' />";
	box.appendChild(newP);
}

function boardCheckForm(){
	if(document.boardForm.title.value == "" || document.boardForm.content.value == ""){
		if(document.boardForm.title.value == ""){
			alert("제목이 입력되지 않았습니다.");
			document.boardForm.title.focus();
			event.preventDefault();
			return false;
		}
		if(document.boardForm.content.value == ""){
			alert("내용이 입력되지 않았습니다.");
			document.boardForm.content.focus();
			event.preventDefault();
			return false;
		}
	}else{
		if(confirm("게시글을 등록하시겠습니까?") == true){
			return true;
		}else{
			event.preventDefault();
			return false;
		}
	}
}

function warnClick(){
	if(confirm("해당 게시글을 신고하시겠습니까?") == true){
		alert("신고가 되었습니다.");
		return window.location.href = getContextPath()+'/user/inside/main.do';
	}else{
		return false;
	}
}
		
/*function sendCHK(){
	let salesNum = event.target.value;
	if(confirm("발송을  취소하시겠습니까?") == true){
		return document.orderForm.action=getContextPath()+'/manager/main/order.do?state=YET&num='+salesNum;
}else{
	return false;
	}
}*/
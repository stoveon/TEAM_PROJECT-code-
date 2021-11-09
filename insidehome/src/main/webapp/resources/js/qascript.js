function getContextPath(){
    let offset=location.href.indexOf(location.host)+location.host.length;
    let ctxPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
    return ctxPath;
}


function qaCheckForm(){
   if(document.qaForm.title.value == "" || document.qaForm.content.value == ""){
      if(document.qaForm.title.value == ""){
         alert("제목이 입력되지 않았습니다.");
         document.boardForm.title.focus();
         event.preventDefault();
         return false;
      }
      if(document.qaForm.content.value == ""){
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
   let boardNum = event.target.value;
   if(confirm("해당 게시글을 신고하시겠습니까?") == true){
      return window.location.href = getContextPath()+'/user/warning/insertForm.do?boardNum='+boardNum;
   }else{
      event.preventDefault();
      return false;
   }
}
   
function heartClick(){
   let boardNum = event.target.value;
   if(confirm("해당 게시글을 추천하시겠습니까?") == true){
      alert("추천이 되었습니다.");
      return window.location.href = getContextPath()+'/user/board/updateHit.do/'+boardNum;
   }else{
      event.preventDefault();      
      return false;
   }
}
      
function editCHK(){
   let boardNum = event.target.value;
   if(confirm("게시글을  수정 하시겠습니까?") == true){
      return window.location.href=getContextPath()+'/user/board/updateForm.do/'+boardNum;
   }else{
      event.preventDefault();   
   return false;
   }
}

function delCHK(){
   let boardNum = event.target.value;
   if(confirm("게시글을 삭제 하시겠습니까?") == true){
      return window.location.href=getContextPath()+'/user/board/delete.do/'+boardNum;
   }else{
      event.preventDefault();   
   return false;
   }
}

function reeditCHK(){
   let boardNum = event.target.value;
      console.log(boardNum);
   if(confirm("댓글을 수정 하시겠습니까?") == true){
      return window.location.href=getContextPath()+'/user/board/delete.do/'+boardNum;
   }else{
      event.preventDefault();   
   return false;
   }
}

function redelCHK(){
   var rbn = event.target.value;
   console.log(rbn);
   if(confirm("댓글을 삭제 하시겠습니까?") == true){
      window.location.href=getContextPath()+'/user/ref/delete.do?num='+rbn;

   }else{
      event.preventDefault();   
   return false;
   }
}

function refCHK(){
   if(document.ref-Form.content.value == ""){
      if(document.boardForm.content.value == ""){
         alert("댓글을 입력해주세요.");
         document.ref-Form.content.focus();
         event.preventDefault();
         return false;
      }
   }else{
      if(confirm("댓글을 등록하시겠습니까?") == true){
         return true;
      }else{
         event.preventDefault();
         return false;
      }
   }
}
function btnActive(num)  {
   const refNum = 'refcon'+num;
   const target = document.getElementById(refNum);
   target.disabled = false;
   const safNum = 'sabtn'+num;
   const target1 = document.getElementById(safNum);
   target1.disabled = false;
   const edfNum = 'edbtn'+num;
   const target2 = document.getElementById(edfNum);
   target2.disabled = true;
}

const reply = () => {
    const box = document.getElementById("reply");
    box.innerHTML = "<textarea rows='3' style='width: 90%; resize: none;' name='content'></textarea> <input type='button' value='저장' onclick='btn(this)'>";
}

   
   const add_reply = () => {
      let renum = event.target.value;
      var name = 'add_reply'+renum;
      alert(name);
       const box = document.getElementById(name);
       box.innerHTML = "<textarea rows='3' style='width: 90%; resize: none;' name='content'></textarea> <input type='button' value='저장' onclick='btn(this)'>";
       
   }
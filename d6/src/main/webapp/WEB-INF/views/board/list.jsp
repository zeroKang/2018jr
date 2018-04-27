<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<hr>
<script>
var str = '${msg}';

if( str === 'success'){
	alert("작업이 처리되었습니다.");
}

</script>

<hr>
<style>
.board {
 display:flex;
 justify-content: center;
 text-align: center;
 border: 1px solid blue;
}
ul li {
 list-style: none;
}
.board div {
 padding: 3px;
 background-color: gray;
}
</style>
<ul>
  <li>
    <div class='board'>
      <div>BNO</div>
      <div>TITLE</div>
      <div>WRITER</div>
      <div>REGDATE</div>
    </div>
  </li>
  <c:forEach items="${list}" var="board">
  <li>
    <div class='board'>
     <div>${board.bno }</div>
      <div data-bno='${board.bno}' class="target">${board.title }</div>
      <div>${board.writer }</div>
      <div>${board.regdate }</div>
    </div>
  </li>    
  </c:forEach>
  
</ul>


<style>

.paging {
  display: flex;
  flex-flow: row;
  justify-content: center; 
}

.paging li { 
 list-style: none;
 margin: 3px;
 background-color: blue;
 border-radius: 2px;
 color: red; 
 }

</style>

<ul class='paging'>

 <c:if test="${pageMaker.prev}">
 <li data-page=${pageMaker.start - 1}>
   이전
 </li>  
 </c:if>

<c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="idx">
  <li data-page=${idx}>
    ${idx}
  </li>
</c:forEach>
 <c:if test="${pageMaker.next}">
 <li data-page=${pageMaker.end + 1}>
  다음
 </li>  
 </c:if>

</ul>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script>
$(document).ready(function(){
	console.log("ready....");
	
	$(".paging li").on("click", function(e){
		
		var pageNum = $(this).attr("data-page");
		
		
		self.location="/board/list?page="+pageNum;
		
		
	});
	
	$(".target").on("click", function(e){
		
		var page = <c:out value="${cri.page}"/>;
		
		self.location="/board/view?page="+page+"&bno="+ $(this).attr("data-bno");
		
	});
	
});

</script>
</body>
</html>













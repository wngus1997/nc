<%--
  Created by IntelliJ IDEA.
  User: se
  Date: 2023-02-11
  Time: 오후 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
    <title>공지사항</title>
    <STYLE>
        hr{
            width: 100%;
            height: 2px;
            background: #00DBAF;
            border: 0;
        }

    </STYLE>
</head>
<body>
<c:import url="/WEB-INF/views/layout/header.jsp"/>
<c:import url="/WEB-INF/views/member/chat.jsp"/>

<div class=" container">
    <div class ="heading mt-5">
        <h3> 공지사항 </h3>
        <hr>
    </div>

    <table class="table  table-hover ">
        <colgroup>
            <col width="20%"/>
            <col width="*"/>
            <col width="20%"/>
            <col width="10%"/>
        </colgroup>
        <thead class="table table-light" <%--style="background: #00DBAF; color: #FFFFFF;"--%>>
        <tr>
            <th> </th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성 날짜</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
        <c:when test="${empty boardList}">
        <tr>
            <td colspan="3" style="text-align: center;">조회된 결과가 없습니다.</td>
        </tr>
        </c:when>
        <c:otherwise>
        <c:forEach var="list" items="${boardList}">
        <tr onclick="location.href='/board/${list.boNo}'"
            style="cursor: pointer">
            <td>[공지사항]</td>
            <td>${list.boTitle}</td>
            <td>${list.boNickname} <span style="font-size: 12px; color: #888888;">(${list.boWriter})</span></td>
            <td>${list.boTime}</td>
        </tr>
        </c:forEach>
        </c:otherwise>
        </c:choose>
    </table>
    <div class=" d-flex justify-content-center" style="position: relative;">
        <ul class="pagination" style="text-align: center;">
            <c:forEach var="i" begin="1" end="${pageCount}" step="1">
                <li class="page-item"><a class="page-link"href="/board/noticeboardlist/?pageNum=${i}"  id="pageNum${i}"><c:out value="${i}" /></a></li>
            </c:forEach>
        </ul>
    </div>
    <c:if test="${sid == 'admin'}">
<div>
    <a onclick="location.href='/board/noticeregister'" class="btn m-3" style="background: #00DBAF; color: #Ffffff; float: right;" >공지 작성</a>
</div>
    </c:if>
</div>
<c:import url="/WEB-INF/views/layout/footer.jsp"/>
<script>
        // 페이지 로딩 후, 현재 페이지 번호 스타일 변경 - 밑줄 + Bold
        window.onload = function(){
        var pageNum = window.location.search.substr(9); // 현제 페이지 번호
        if(pageNum == '')
        pageNum = 1; // 특별히 지정된 페이지 번호가 없으면 그냥 페이지 1이라고 간주

        document.getElementById('pageNum'+pageNum).style.fontWeight = 'bold'
    }

</script>
</body>
</html>

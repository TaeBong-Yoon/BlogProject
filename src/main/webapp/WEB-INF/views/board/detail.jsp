<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<button class="btn btn-secondary" onclick="history.back()">List</button>
	<c:if test="${board.user.id == principal.user.id}">
		<a href="/board/${board.id}/updateForm" class="btn btn-warning">Update</a>
		<button id="btn-delete" class="btn btn-danger">Delete</button>
	</c:if>
	<br /> <br />
	<div>
		Number : <span id="id"><i>${board.id} </i></span> Writer : <span><i>${board.user.username} </i></span>
	</div>
	<br />
	<div>
		<h3>${board.title}</h3>
	</div>
	<hr />
	<div>
		<div>${board.content}</div>
	</div>
	<hr />
</div>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>

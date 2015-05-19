<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body style="background-color:#FFFFFF; ">

<table cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td valign="top" align="center" id="top"><!----------------header--------------->
					<table  cellpadding="0" cellspacing="0" width="1300">
						<%@ include file="./commons/_head.jspf" %>
	<tr>
		<td colspan="2" valign="top" style="padding-top:30px">
		
		<%@ include file="./commons/_top.jspf" %> 
<!--//네비--></td>
						</tr>
					</table>
			</td>
		</tr>
		<tr>
			<td valign="baseline" align="left"><!----------------main이미지--------------->
				<div style="padding-top:30px; padding-bottom:30px">
					<h1>회원가입</h1>
				</div>
				
				<form class="form-horizontal" action="/users/CreateUserServlet" method="post">
					<%
						Object errorMessage = request.getAttribute("errorMessage");
						if(errorMessage != null) {
					%>
					<div class="control-group">
						<label class="error"> <%= errorMessage %></label>
					</div>						
					<% 		
						} 
					%>
					<div></div>
					<br>
					<div class="control-group">
						<label class="control-label" for="userId">사용자 아이디</label>
						<div class="controls">
							<input type="text" name="userId" value="${user.userId}" />							
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password">비밀번호</label>
						<div class="controls">
							<input type="password" id="password" name="password" value="${user.password}"placeholder="" />							
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="name">이름</label>
						<div class="controls">
							<input type="text" id="name" name="name" value="${user.name}"placeholder="" />							
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="email">이메일</label>
						<div class="controls">
							<input type="text" id="email" name="email" value="${user.email}" placeholder="" />								
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<button type="submit">회원가입</button>								
						</div>
					</div>				
				</form>
				
					
							<td class="m_right"></td>
						</tr>
					</table>
					
				
			</td>
		</tr>
	</table>  
</body>
</html>
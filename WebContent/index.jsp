<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>네오인테라</title>
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
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td valign="baseline" align="center"><!----------------main이미지--------------->
				<div style="padding-top:30px; padding-bottom:30px">
					info text
				</div>
					<table cellpadding="0" cellspacing="0">
						<tr>
							<td class="m_left"></td>
							<td align="center"><!--메인-->
<div id="main"> <img src="./images/bg_full.jpg"></div>
<!--//메인--></td>
							<td class="m_right"></td>
						</tr>
					</table>
			</td>
		</tr>
		<tr>
			<td valign="top" align="center" ><!---------------body--------------->
				<style type="text/css">
#contents {width:900px; overflow:hidden; margin:20px auto;}
.notice { width:276px; height:106px; float:left; }
.notice li { /*background:url(/images/basic_blue/common/bu_dot.gif) no-repeat left center; padding-left:7px;*/ line-height:20px; }
.notice dt { height:35px; }
.notice dd { margin:0; padding:0; }

.product {width:296px; float:left; margin-left:77px;}
.customer {width:179px; float:right;}
</style>


</div>
			</td>
		</tr>		
		<tr>
			<td valign="top" align="center" id="footer"><!----------------footer--------------->
					<style type="text/css">
.footer { padding:10px;}
.footer td {line-height:18px;}
.footer_info { font:11px dotum; color:#868686; padding-top:10px;}
</style>


		</td>
		</tr>
	</table>  
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>babasport-position-add</title>
<script type="text/javascript">
	
function uploadPic(){
	// 构建jquery.form.js需要参数信息
	var options = {
			url:"/upload/uploadPic.do",
			type:"post",
			dataType:"json",
			success:function(data){
				// 1、图片回显
				$("#allUrl").attr("src",data.allUrl);
				// 2、设置图片的url的隐藏域用于保存到数据库imgUrl
				$("#imgUrl").val(data.allUrl);
			}
	}
	// 通过jquery.form.js构建表单提交
	$("#jvForm").ajaxSubmit(options);
}

</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 广告管理 - 添加</div>
	<form class="ropt">
		<input type="submit" onclick="this.form.action='v_list.shtml';" value="返回列表" class="return-button"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box" style="float:right">
	<form id="jvForm" action="save.do" method="post">
		<table cellspacing="1" cellpadding="2" width="100%" border="0" class="pn-ftable">
			<tbody>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						广告位置:</td><td width="80%" class="pn-fcontent">
						<input type="hidden" value="${positionId }" name="positionId"/>
						大广告
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						广告标题:
					</td>
					<td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="title" maxlength="100"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						链接:
					</td>
					<td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="url" maxlength="400" size="130" value="javascript:;"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						上传商品图片(90x150尺寸):</td>
						<td width="80%" class="pn-fcontent">
						注:该尺寸图片必须为90x150。
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h"></td>
						<td width="80%" class="pn-fcontent">
						<img width="100" height="100" id="allUrl"/>
						<input type="hidden" name="picture" id="imgUrl"/>
						<input type="file" name="pic" onchange="uploadPic()"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						宽:
					</td>
					<td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="width" maxlength="100" value="670"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						高:
					</td>
					<td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="height" maxlength="100" value="399"/>
					</td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td class="pn-fbutton" colspan="2">
						<input type="submit" class="submit" value="提交"/> &nbsp; <input type="reset" class="reset" value="重置"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>
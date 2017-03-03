<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>babasport-edit</title>
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
					$("#imgUrl").val(data.imgUrl);
				}
		}
		// 通过jquery.form.js构建表单提交
		$("#jvForm").ajaxSubmit(options);
	}
</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 品牌管理 - 添加</div>
	<form class="ropt">
		<input type="submit" onclick="javascript:window.location.href='add.do'" value="返回列表" class="return-button"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box" style="float:right">
	<form id="jvForm" >
		<input type="hidden" name="id" value="${brand.id }"/>
		<table cellspacing="1" cellpadding="2" width="100%" border="0" class="pn-ftable">
			<tbody>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						品牌名称:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="name" value="${brand.name }" maxlength="100"/>
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
						<img width="100" height="100" id="allUrl" src="${brand.imgUrl }"/>
						<input type="hidden" name="imgUrl" id="imgUrl"/>
						<input type="file" name="pic" onchange="uploadPic()"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						品牌描述:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="description" value="${brand.description }" maxlength="80"  size="60"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						排序:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="sort" value="${brand.sort }" maxlength="80"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						是否可用:</td><td width="80%" class="pn-fcontent">
						<input type="radio" name="isDisplay" value="1" <c:if test="${brand.isDisplay == 1 }">checked="checked"</c:if>/>可用
						<input type="radio" name="isDisplay" value="0" <c:if test="${brand.isDisplay == 0 }">checked="checked"</c:if>/>不可用
					</td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td class="pn-fbutton" colspan="2">
						<button class="submit" id="submit" value="提交"/> &nbsp; <input type="reset" class="reset" value="重置"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
<script>
	$(function(){
		/** 点击提交 */
		$("#submit").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath }/brand/update.do",
				type:"post",
				data:$('#jvForm').serialize(),
				async: false,
				dataType:"json",
				success:function(data){
					if(data.result=="1"){
						alert("修改成功");	
					};
					if(data.result=="2"){
						alert("失败");
					}
					if(data.result=="3"){
						alert("保存成功");
					}
				}
			});
		});
		
		//加载完
	})
	
</script>

</html>
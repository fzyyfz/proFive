<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 使用taglib指令引入JSTL核心标签库描述文件 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>地址管理</title>

		<link href="${ pageContext.request.contextPath }/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="${ pageContext.request.contextPath }/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="${ pageContext.request.contextPath }/css/personal.css" rel="stylesheet" type="text/css">
		<link href="${ pageContext.request.contextPath }/css/addstyle.css" rel="stylesheet" type="text/css">
		<script src="${ pageContext.request.contextPath }/AmazeUI-2.4.2/assets/js/jquery.min.js" type="text/javascript"></script>
		<script src="${ pageContext.request.contextPath }/AmazeUI-2.4.2/assets/js/amazeui.js"></script>
		<script src="${ pageContext.request.contextPath }/js/jquery-1.7.2.min.js"></script>
		
	</head>
	<body>
		<!--头 -->
		<jsp:include page="../home/header.jsp"></jsp:include>

		<div class="nav-table">
			<div class="long-title"><span class="all-goods">全部分类</span></div>
			<div class="nav-cont">
				<ul>
					<li class="index"><a href="#">首页</a></li>
					<li class="qc"><a href="#">闪购</a></li>
					<li class="qc"><a href="#">限时抢</a></li>
					<li class="qc"><a href="#">团购</a></li>
					<li class="qc last"><a href="#">大包装</a></li>
				</ul>
				<div class="nav-extra">
					<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利
					<i class="am-icon-angle-right" style="padding-left: 10px;"></i>
				</div>
			</div>
		</div>
		<b class="line"></b>

		<div class="center">
			<div class="col-main">
				<div class="main-wrap">

					<div class="user-address">
						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">地址管理</strong> / <small>Address&nbsp;list</small></div>
						</div>
						<hr/>
						<ul class="am-avg-sm-1 am-avg-md-3 am-thumbnails" id="addUl">
<!-- 
							<li class="user-addresslist defaultAddr">
								<span class="new-option-r"><i class="am-icon-check-circle"></i>默认地址</span>
								<p class="new-tit new-p-re">
									<span class="new-txt">大雄</span>
									<span class="new-txt-rd2">159****1622</span>
								</p>
								<div class="new-mu_l2a new-p-re">
									<p class="new-mu_l2cw">
										<span class="title">地址：</span>
										<span class="province">湖北</span>省
										<span class="city">武汉</span>市
										<span class="dist">洪山</span>区
										<span class="street">雄楚大道666号(中南财经政法大学)</span></p>
								</div>
								<div class="new-addr-btn">
									<a href="#"><i class="am-icon-edit"></i>编辑</a>
									<span class="new-addr-bar">|</span>
									<a href="javascript:void(0);" onclick="delClick(this);"><i class="am-icon-trash"></i>删除</a>
								</div>
							</li>
					

							<li class="user-addresslist">
								<span class="new-option-r"><i class="am-icon-check-circle"></i>设为默认</span>
								<p class="new-tit new-p-re">
									<span class="new-txt">小叮当</span>
									<span class="new-txt-rd2">159****1622</span>
								</p>
								<div class="new-mu_l2a new-p-re">
									<p class="new-mu_l2cw">
										<span class="title">地址：</span>
										<span class="province">湖北</span>省
										<span class="city">武汉</span>市
										<span class="dist">洪山</span>区
										<span class="street">雄楚大道666号(中南财经政法大学)</span></p>
								</div>
								<div class="new-addr-btn">
									<a href="#"><i class="am-icon-edit"></i>编辑</a>
									<span class="new-addr-bar">|</span>
									<a href="javascript:void(0);" onclick="delClick(this);"><i class="am-icon-trash"></i>删除</a>
								</div>
							</li>
	-->						 
							
							
							
						</ul>
						<div class="clear"></div>
						<a class="new-abtn-type" data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0}">添加新地址</a>
						<!--例子-->
						<div class="am-modal am-modal-no-btn" id="doc-modal-1">

							<div class="add-dress">

								<!--标题 -->
								<div class="am-cf am-padding">
									<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add&nbsp;address</small></div>
								</div>
								<hr/>

								<div id="addDiv" class="am-u-md-12 am-u-lg-8" style="margin-top: 20px;">
									<form class="am-form am-form-horizontal" id="addForm" method="post">

										<div class="am-form-group">
											<label for="user-name" class="am-form-label">收货人</label>
											<div class="am-form-content">
												<input type="text" id="user_name" value="" name="user_name" placeholder="收货人">
											</div>
										</div>

										<div class="am-form-group">
											<label for="user-phone" class="am-form-label">手机号码</label>
											<div class="am-form-content">
												<input id="user_phone" name="user_phone" placeholder="手机号必填" type="email">
											</div>
										</div>
										<div class="am-form-group">
											<label for="user-address" class="am-form-label">所在地</label>
											<div class="am-form-content address">
												<select data-am-selected name="country" id="country">
													<option value="美国">美国</option>
													<option value="德国">德国</option>
													<option value="法国">法国</option>
													<option value="英国">英国</option>
													<option value="中国" selected>中国</option>
												</select>
												<select data-am-selected name="province" id="province">
													<option value="广东">广东</option>
													<option value="湖南">湖南</option>
													<option value="广西">广西</option>
													<option value="江苏">江苏</option>
													<option value="福建" selected>福建</option>
												</select>
												<select data-am-selected name="city" id="city">
													<option value="广州">广州</option>
													<option value="东莞">东莞</option>
													<option value="惠州">惠州</option>
													<option value="汕尾">汕尾</option>
													<option value="深圳" selected>深圳</option>
												</select>
											</div>
										</div>

										<div class="am-form-group">
											<label for="user-intro" class="am-form-label">详细地址</label>
											<div class="am-form-content">
												<textarea class="" id="detail" name="detail" rows="3" id="user-intro" placeholder="输入详细地址"></textarea>
												<small>100字以内写出你的详细地址...</small>
											</div>
										</div>

										<div class="am-form-group">
											<div class="am-u-sm-9 am-u-sm-push-3">
												<a class="am-btn am-btn-danger" style="color:white" href="javaScript:submitForm();">保存</a>
												<a href="javascript: void(0)" class="am-close am-btn am-btn-danger" data-am-modal-close>取消</a>
											</div>
										</div>
									</form>
								</div>
								
								<div id="editDiv" class="am-u-md-12 am-u-lg-8" style="margin-top: 20px;float:left;display:none">
									<form class="am-form am-form-horizontal" id="editForm" method="post">

										<div class="am-form-group">
											<label for="user-name" class="am-form-label">收货人</label>
											<div class="am-form-content">
												<input type="text" id="euser_name" value="" name="user_name" placeholder="收货人">
											</div>
										</div>

										<div class="am-form-group">
											<label for="user-phone" class="am-form-label">手机号码</label>
											<div class="am-form-content">
												<input id="euser_phone" name="user_phone" placeholder="手机号必填" type="email">
											</div>
										</div>
										<div class="am-form-group">
											<label for="user-address" class="am-form-label">所在地</label>
											<div class="am-form-content address">
												<select data-am-selected name="country" id="ecountry">
													<option value="美国">美国</option>
													<option value="德国">德国</option>
													<option value="法国">法国</option>
													<option value="英国">英国</option>
													<option value="中国" selected>中国</option>
												</select>
												<select data-am-selected name="province" id="eprovince">
													<option value="广东">广东</option>
													<option value="湖南">湖南</option>
													<option value="广西">广西</option>
													<option value="江苏">江苏</option>
													<option value="福建" selected>福建</option>
												</select>
												<select data-am-selected name="city" id="ecity">
													<option value="广州">广州</option>
													<option value="东莞">东莞</option>
													<option value="惠州">惠州</option>
													<option value="汕尾">汕尾</option>
													<option value="深圳" selected>深圳</option>
												</select>
											</div>
										</div>

										<div class="am-form-group">
											<label for="user-intro" class="am-form-label">详细地址</label>
											<div class="am-form-content">
												<textarea class="" id="edetail" name="detail" rows="3" id="user-intro" placeholder="输入详细地址"></textarea>
												<small>100字以内写出你的详细地址...</small>
											</div>
										</div>

										<div class="am-form-group">
											<div class="am-u-sm-9 am-u-sm-push-3">
												<a class="am-btn am-btn-danger" style="color:white" href="javaScript:editForm();">修改</a>
												<a href="javascript: cancelEdit();" class="am-close am-btn am-btn-danger" data-am-modal-close>取消</a>
											</div>
										</div>
									</form>
								</div>

							</div>

						</div>

					</div>

					<script type="text/javascript">
						$(document).ready(function() {							
							$(".new-option-r").click(function() {
								$(this).parent('.user-addresslist').addClass("defaultAddr").siblings().removeClass("defaultAddr");
							});
							
							var $ww = $(window).width();
							if($ww>640) {
								$("#doc-modal-1").removeClass("am-modal am-modal-no-btn")
							}
							
						})
					</script>

					<div class="clear"></div>

				</div>
				<!--底部-->
				<div class="footer">
					<div class="footer-hd">
						<p>
							<a href="#">恒望科技</a>
							<b>|</b>
							<a href="#">商城首页</a>
							<b>|</b>
							<a href="#">支付宝</a>
							<b>|</b>
							<a href="#">物流</a>
						</p>
					</div>
					<div class="footer-bd">
						<p>
							<a href="#">关于恒望</a>
							<a href="#">合作伙伴</a>
							<a href="#">联系我们</a>
							<a href="#">网站地图</a>
							<em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
						</p>
					</div>
				</div>
			</div>

			<aside class="menu">
				<ul>
					<li class="person active">
						<a href="${ pageContext.request.contextPath }/person/PersonPageServlet?method=personalUI">个人中心</a>
					</li>
					<li class="person">
						<a href="${ pageContext.request.contextPath }/person/PersonPageServlet?method=informationUI">个人资料</a>
						<ul>
							<li> <a href="${ pageContext.request.contextPath }/person/PersonPageServlet?method=informationUI">个人信息</a></li>
							<li> <a href="${ pageContext.request.contextPath }/person/PersonPageServlet?method=safetyUI">安全设置</a></li>
							<li> <a href="${ pageContext.request.contextPath }/person/PersonPageServlet?method=addressUI">收货地址</a></li>
						</ul>
					</li>
					<li class="person">
						<a href="${ pageContext.request.contextPath }/person/PersonPageServlet?method=orderUI">我的交易</a>
						<ul>
							<li><a href="${ pageContext.request.contextPath }/person/PersonPageServlet?method=orderUI">订单管理</a></li>
							<li> <a href="${ pageContext.request.contextPath }/person/PersonPageServlet?method=changeUI">退款售后</a></li>
						</ul>
					</li>
					<li class="person">
						<a href="${ pageContext.request.contextPath }/person/PersonPageServlet?method=couponUI">我的资产</a>
						<ul>
							<li> <a href="${ pageContext.request.contextPath }/person/PersonPageServlet?method=couponUI">优惠券 </a></li>
							<li> <a href="${ pageContext.request.contextPath }/person/PersonPageServlet?method=bonusUI">红包</a></li>
							<li> <a href="${ pageContext.request.contextPath }/person/PersonPageServlet?method=billUI">账单明细</a></li>
						</ul>
					</li>

					<li class="person">
						<a href="${ pageContext.request.contextPath }/person/PersonPageServlet?method=collectionUI">我的小窝</a>
						<ul>
							<li> <a href="${ pageContext.request.contextPath }/person/PersonPageServlet?method=collectionUI">收藏</a></li>
							<li> <a href="${ pageContext.request.contextPath }/person/PersonPageServlet?method=footUI">足迹</a></li>
							<li> <a href="${ pageContext.request.contextPath }/person/PersonPageServlet?method=commentUI">评价</a></li>
							<li> <a href="${ pageContext.request.contextPath }/person/PersonPageServlet?method=newsUI">消息</a></li>
						</ul>
					</li>

				</ul>

			</aside>
		</div>

	</body>
	<script src="${ pageContext.request.contextPath }/js/addAddress.js"></script>
	<script src="${ pageContext.request.contextPath }/js/cpc.js"></script>
</html>
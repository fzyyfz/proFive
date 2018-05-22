<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 使用taglib指令引入JSTL核心标签库描述文件 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	
	HttpSession ses = request.getSession(false);
	String name = (String)ses.getAttribute("name");
//	Cookie[] cookie = request.getCookies();
//	for(int i=0;i<cookie.length;i++){
//		String username = account.getClass().getName();
//		if(cookie[i].equals(username)){
//			
//		}
//	}
%>
<div class="hmtop">
			<!--顶部导航条 -->
			<div class="am-container header">
				<ul class="message-l">
					<div class="topMessage">
						<div class="menu-hd">
						<c:choose>
							<c:when test="${not empty name}">
								欢迎您! ${name}&nbsp;&nbsp;&nbsp; 
								<a href="${ pageContext.request.contextPath }/home/do_logout.jsp" target="_top">退出</a>
							</c:when>
							<c:otherwise>
								<a href="${ pageContext.request.contextPath }/home/HomePageServlet?method=loginUI" target="_top" style="color:#E35718" class="h">亲，请登录</a>
								<a href="${ pageContext.request.contextPath }/home/HomePageServlet?method=registUI" target="_top">免费注册</a>
							</c:otherwise>
						</c:choose>
						</div>
					</div>
				</ul>
				<ul class="message-r">
					<div class="topMessage home">
						<div class="menu-hd"><a href="${ pageContext.request.contextPath }/home/HomePageServlet?method=homeUI" target="_top" class="h">商城首页</a></div>
					</div>
					<div class="topMessage my-shangcheng">
						<div class="menu-hd MyShangcheng"><a href="${ pageContext.request.contextPath }/home/HomePageServlet?method=personalUI" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
					</div>
					<div class="topMessage mini-cart">
						<div class="menu-hd"><a id="mc-menu-hd" href="${ pageContext.request.contextPath }/home/HomePageServlet?method=shopcartUI" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
					</div>
					<div class="topMessage favorite">
						<div class="menu-hd"><a href="${ pageContext.request.contextPath }/person/PersonPageServlet?method=collectionUI" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
				</ul>
				</div>

				<!--悬浮搜索框-->

				<div class="nav white">
					<div class="logo"></div>
					<div class="logoBig">
						<li><img src="${ pageContext.request.contextPath }/images/logobig.png" /></li>
					</div>

					<div class="search-bar pr">
						<a name="index_none_header_sysc" href="#"></a>
						<form>
							<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
							<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
						</form>
					</div>
				</div>

				<div class="clear"></div>
			</div>
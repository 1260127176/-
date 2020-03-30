<%--
  Created by IntelliJ IDEA.
  User: 12601
  Date: 2020/3/23
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%
    pageContext.setAttribute("ctp",request.getContextPath());
    %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="${ctp}/static/layuiadmin/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<script src="${ctp}/static/layuiadmin/layui/layui.js"></script>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">若鱼博客</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="${ctp}/page/front/FrontIndex.jsp" id="toIndex">博客首页</a></li>
            <%
                if (session.getAttribute("userBean")!=null && !"".equals(session.getAttribute("userBean"))){
            %>
            <li class="layui-nav-item">
                <a href="">博文管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">类型管理</a></li>
            <li class="layui-nav-item"><a href="">链接管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="${ctp}/user/tologin">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <%
            }
        %>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    <%
                        if (session.getAttribute("userBean")!=null && !"".equals(session.getAttribute("userBean"))){
                    %>
                    ${userBean.getUserName}
                    <%
                        }else{
                    %>
                    未登录
                    <%
                        }
                    %>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">修改密码</a></dd>
                    <dd><a href="">退出登录</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="${ctp}/page/admin/login/login.jsp">切换账号</a></li>
        </ul>

    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">站点搜索</a>
                    <dl class="layui-nav-child">
                        <dd><input type="text" name="keyword"><a href="${ctp}/page/admin/siteInfo.jsp" id="">站点搜索</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">文章排行</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;"></a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">类型搜索</a>
                </li>
                <li class="layui-nav-item"><a href="">链接</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">内容主体区域</div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
//页面跳转的同时发送请求
    function viewArticle() {
        document.getElementById("toIndex").click();
        $.ajax({
            url:  '${ctp}/ruoyu',
            type:'POST',
            dataType:'json',
            success:function(data){
            alert("6666");
            },
        });
    }
</script>
</body>
</html>

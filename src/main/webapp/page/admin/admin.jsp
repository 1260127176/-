<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ruoyu.bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>管理界面</title>
    <link href="<%=basePath%>/static/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=basePath%>/static/js/js.js"></script>
</head>

<%
    XbloUserBean validXbloUserBean = (XbloUserBean) session
            .getAttribute("userBean");
    String src = (String) request.getAttribute("src");
    request.removeAttribute("src");
    if (src==null || src.equals("")){
        src="admin/siteInfo";
    }
        src= "/page/" +src+".jsp";
%>

<body id="index">
<h1>欢迎你，<%=validXbloUserBean.getXbloUsername() %>
</h1>

<ul id="globalNav">
    <li>
        <form action="/pageInfo" method="post">
        <a href="#" target="frameBord">
            <input type="hidden" name="src" value="admin/siteInfo"/>
            <input class="button" type="submit" value="站点信息"/>
        </a>
        </form>
    </li>
    <li>
        <form action="/pageInfo" method="post">
        <a href="/#" target="frameBord">
            <input type="hidden" name="src" value="admin/article/addArticle"/>
            <input class="button" type="submit" value="发表文章"/>
        </a>
        </form>
    </li>

    <li>
        <form action="/pageInfo" method="post">
        <a href="/#" target="frameBord">
            <input type="hidden" name="src" value="admin/article/mgrArticle"/>
            <input class="button" type="submit" value="管理文章"/>
        </a>
        </form>
    </li>

    <li>
        <form action="/pageInfo" method="post">
            <a href="/#" target="frameBord">
                <input type="hidden" name="src" value="admin/articleType/mgrArticleType"/>
                <input class="button" type="submit" value="管理类别"/>
            </a>
        </form>
    </li>

    <li>
        <form action="/pageInfo" method="post">
            <a href="/#" target="frameBord">
                <input type="hidden" name="src" value="admin/xbloLink/mgrXbloLink"/>
                <input class="button" type="submit" value="管理链接"/>
            </a>
        </form>
    </li>

    <li>
        <form action="/pageInfo" method="post">
            <a href="/#" target="frameBord">
                <input type="hidden" name="src" value="admin/xbloUser/mgrXbloUser"/>
                <input class="button" type="submit" value="管理用户"/>
            </a>
        </form>
    </li>

    <li><a href="/user/loginout"><input class="button" type="submit" value="退出"/></a></li>
</ul>

<iframe id="frameBord" name="frameBord" style="height: 100%;width: 100%;border: 0" src="<%=src%>"></iframe>
</body>
</html>
<script>
    //根据浏览器大小调整iframe高度
    reSetSize();
    window.onresize = reSetSize;
    function reSetSize() {
        var windowsHeight = window.innerHeight;
        document.getElementById("frameBord").style.height = (windowsHeight) + "px";
    }

</script>
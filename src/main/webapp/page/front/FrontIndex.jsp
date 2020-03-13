<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ruoyu.bean.*" %>
<%@ page import="com.github.pagehelper.PageInfo" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>若鱼Blog首页</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="<%=basePath%>/static/css/default.css" rel="stylesheet" type="text/css" media="screen"/>
</head>
<body>
<jsp:include page="view/FrontHead.jsp" flush="true"/>
<!-- start content -->
<div id="page">
    <div id="content">
        <%
//                    List<ArticleCommentBean> articleCommentList = (List<ArticleCommentBean>) request.getAttribute("commentBeanList");
            PageInfo<ArticleMessage> articleList= (PageInfo<ArticleMessage>) session.getAttribute("pageInfo");
            if (articleList == null || articleList.getSize() == 0) {
        %>
        <div class="post">
            <h1 class="title">欢迎使用若鱼blog!</h1>
            <p class="meta"><small>当前类别下博主还未发表文章</small></p>
            <div class="entry">
                <p>精彩即将来临...</p>
                <p class="more"><a href="#">阅读全文&hellip;</a></p>
            </div>
        </div>

        <%
        } else {
            int i = 0;
            String username = "";
            int commentCount = 0;
            while (i < articleList.getSize()) {
                String articleTypeName = (String) articleList.getList().get(i).getArticleTypeName();
                if (articleTypeName == null || articleTypeName.equals(""))
                    articleTypeName = "未分类";
        %>
        <div class="post">
            <h2 class="title">[<%=articleList.getList().get(i).getArticleTypeName()%>]<%=articleList.getList().get(i).getArticleTitle()%>
            </h2>
            <p class="meta">
                <small><%=articleTypeName%>
                    发布于 <%=articleList.getList().get(i).getCreateDate()%>
                    <b>&nbsp;|&nbsp;</b>
                    阅读 (<%=articleList.getList().get(i).getVisitCount()%>) <b>&nbsp;|&nbsp;</b>
                    <a  href="comment/select" >
                        <input type="hidden" name="articleId" value="<%=articleList.getList().get(i).getArticleId()%>"/>
                    </a></small></p>
            <div class="entry">
                <p><%=articleList.getList().get(i).getArticleSummary()%>
                </p>
                <form action="/article/findById/find" method="post">
                    <p class="more"><a  href="#" >
                        <input type="hidden" name="articleId" value="<%=articleList.getList().get(i).getArticleId()%>"/>
                        <input type="submit" value="阅读全文..."/></a>
                    </p>
                </form>
            </div>
        </div>
        <%
                    i++;
                }
            }
        %>
        <div style="padding:10px;text-align: center" >
            <c:if test="<%=!articleList.isIsFirstPage()%>">
                <form action="/ruoyu" style="float: left ; align-content: center" method="post">
                    <input type="hidden" name="src" value="admin/article/mgrArticle"/>
                    <input type="hidden" name="pageNum" value="<%=articleList.getNavigateFirstPage()%>"/>
                    <input type="image" src="<%=basePath%>/static/images/first.png" onClick="document.name.submit()" style="text-align: center" />&nbsp;&nbsp;|
                </form>
            </c:if>

            <c:if test="<%=articleList.isHasPreviousPage()%>">
                <form action="/ruoyu" style="float: left;align-content: center" method="post">
                    <input type="hidden" name="src" value="admin/article/mgrArticle"/>
                    <input type="hidden" name="pageNum" value="<%=articleList.getPrePage()%>"/>
                    <input type="image" src="<%=basePath%>/static/images/pre.png" onclick="document.name.submit()" style="text-align: center" />&nbsp;&nbsp;|
                </form>
            </c:if>

            <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                <form action="/ruoyu" style="float: left;color:${num eq pageInfo.pageNum?"red":""};align-content: center " method="post">
                    <input type="hidden" name="src" value="admin/article/mgrArticle"/>
                    <input type="hidden" name="pageNum" value="${num}"/>
                    <input type="submit" value="${num}" style="text-align: center"/>&nbsp;&nbsp;|
                </form>
            </c:forEach>

            <c:if test="<%=articleList.isHasNextPage()%>">
                <form action="/ruoyu" style="float: left;align-content: center" method="post">
                    <input type="hidden" name="src" value="admin/article/mgrArticle"/>
                    <input type="hidden" name="pageNum" value="<%=articleList.getNextPage()%>"/>
                    <input type="image" src="<%=basePath%>/static/images/next.png" onclick="document.name.submit()" style="text-align: center"/>&nbsp;&nbsp;|
                </form>
            </c:if>
            <c:if test="<%=!articleList.isIsLastPage()%>">
                <form action="/ruoyu" style="float: left;align-content: center" method="post">
                    <input type="hidden" name="src" value="admin/article/mgrArticle"/>
                    <input type="hidden" name="pageNum" value="<%=articleList.getNavigateLastPage()%>"/>
                    <input type="image" src="<%=basePath%>/static/images/last.png" onclick="document.name.submit()" style="text-align: center"/>
                </form>
            </c:if>
            当前第<%=articleList.getPageNum()%>/<%=articleList.getPages()%>
        </div>
    </div>
    <!-- end content -->
    <div id="sidebar">
        <ul>
            <li id="search">
                <h2>搜索</h2>
                <!-- Google站内搜索开始 -->
                <form method="get" action="/article/selectAll">
                    <fieldset><input type=text name=q>
                        <input type=submit name=btnG value="搜索">
                    </fieldset>
                </form>
                <!-- Google 站内搜索结束 --></li>
            <li>
                <h2>排行</h2>
                <ul>
                    <%
                        List<ArticleBean> articleListTop = (List<ArticleBean>) session.getAttribute("top10");
                        if (articleListTop.size() > 0) {
                            for (int i = 0; i < articleListTop.size(); i++) {
                                ArticleBean articleBean = (ArticleBean) articleListTop
                                        .get(i);
                    %>
                    <li><a  href="/article/findById/find">
                        <input type="hidden" name="articleId" value="<%=articleBean.getArticleId()%>">
                        <%=articleBean.getArticleTitle()%></a>(<%=articleBean.getVisitCount()%>)
                    </li>
                    <%
                            }
                        }
                    %>
                </ul>
            </li>
            <li>
                <h2>分类</h2>
                <ul>
                    <%
                        List<ArticleTypeBean> articleTypeList = (List<ArticleTypeBean>) session.getAttribute("typeBeanList");
                        List<ArticleBean> articleBeanList = (List<ArticleBean>) session.getAttribute("articleBeanList");
                        if (articleTypeList.size() > 0) {
                            for (int i = 0; i < articleTypeList.size(); i++) {
                                ArticleTypeBean articleTypeBean = (ArticleTypeBean) articleTypeList.get(i);
                    %>
                    <li><a
                            href="/type/selectByTypeId" methods="post">
                        <input type="hidden" name="articleTypeId" value="<%=articleTypeBean.getArticleTypeId()%>">

                        <%=articleTypeBean.getArticleTypeName()%>
                    </a>
                        <%
                            int size=0;
                            for (ArticleBean articleBean : articleBeanList) {
                                while (articleBean.getArticleTypeId()==articleTypeBean.getArticleTypeId()){
                                    size += 1;
                                }
                            }
                        %>
                        (<%=size%>)
                    </li>
                    <%
                            }
                        }
                    %>
                </ul>
            </li>
            <li>
                <h2>链接</h2>
                <ul>
                    <%
                        List<XbloLinkBean> xbloLinkList = (List<XbloLinkBean>) session.getAttribute("linkBeanList");
                        if (xbloLinkList.size() > 0) {
                            for (int i = 0; i < xbloLinkList.size(); i++) {
                                XbloLinkBean xbloLinkBean = (XbloLinkBean) xbloLinkList
                                        .get(i);
                    %>
                    <li><a href="http://<%=xbloLinkBean.getXbloLinkUrl()%>"
                           target=_blank><%=xbloLinkBean.getXbloLinkName()%>
                    </a></li>
                    <%
                            }
                        }
                    %>
                </ul>
            </li>
        </ul>
    </div>
<%--    <%@ include file="view/FrontLeft.jsp" %>--%>
    <div style="clear: both;">&nbsp;</div>
</div>
<!-- start footer -->
<jsp:include page="view/FrontFoot.jsp" flush="true"/>
<!-- end footer -->
<%
    session.removeAttribute("pageInfo");
    session.removeAttribute("top10");
    session.removeAttribute("typeBeanList");
    session.removeAttribute("articleBeanList");
    session.removeAttribute("linkBeanList");
%>
</body>
</html>
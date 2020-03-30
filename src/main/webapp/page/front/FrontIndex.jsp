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
<body>
<jsp:include page="view/FrontHead.jsp" flush="true"/>
<!-- start content -->
<div id="page">
    <div id="content">
        <%
            List<ArticleCommentBean> articleCommentList = (List<ArticleCommentBean>) request.getSession().getAttribute("commentBeanList");
//            List<ArticleBean> articleBeanList = (List<ArticleBean>) request.getSession().getAttribute("articleBeanList");
            PageInfo<ArticleBean> articleList= (PageInfo<ArticleBean>) request.getSession().getAttribute("pageInfo");
            List<ArticleTypeBean> typeBeanList = (List<ArticleTypeBean>) request.getSession().getAttribute("typeBeanList");
            List<XbloUserBean> userBeanList = (List<XbloUserBean>) request.getSession().getAttribute("userBeanList");
            String requestUrl = (String) session.getAttribute("requestUrl");
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
                String articleTypeName=null;
                String creteUserName=null;
            List<ArticleBean> articleBeanList=articleList.getList();
            for (int i=0;i < articleList.getSize();i++) {
                for (ArticleTypeBean articleTypeBean : typeBeanList) {
                    Integer articleTypeId = articleBeanList.get(i).getArticleTypeId();
                    if (articleTypeId == articleTypeBean.getArticleTypeId()) {
                        articleTypeName = articleTypeBean.getArticleTypeName();
                    } else if (articleTypeId.equals("") || articleTypeId == null)
                        articleTypeName = "未分类";
                }
                for (XbloUserBean xbloUserBean : userBeanList) {
                    if (articleBeanList.get(i).getCreateUserId()==xbloUserBean.getXbloUserId()){
                        creteUserName=xbloUserBean.getXbloUsername();
                    }

                }
        %>
        <div class="post">
            <h2 class="title">[<%=articleTypeName%>]<%=articleList.getList().get(i).getArticleTitle()%>
            </h2>
            <p class="meta">
                <small><%=creteUserName%>
                    发布于 <%=articleList.getList().get(i).getCreateDate()%>
                    <b>&nbsp;|&nbsp;</b>
                    阅读 (<%=articleList.getList().get(i).getVisitCount()%>) <b>&nbsp;|&nbsp;</b>评论
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
                }
            }
        %>
        <div style="padding:10px;text-align: center" >
            <c:if test="<%=!articleList.isIsFirstPage()%>">
                <form action="<%=path%>/<%=requestUrl%>" style="float: left ; align-content: center" method="post">
                    <input type="hidden" name="articleTypeId" value="${sessionScope.get("articleTypeId")}"/>
                    <input type="hidden" name="pageNum" value="<%=articleList.getNavigateFirstPage()%>"/>
                    <input type="image" src="<%=basePath%>/static/images/first.png" onClick="document.name.submit()" style="text-align: center" />&nbsp;&nbsp;|
                </form>
            </c:if>

            <c:if test="<%=articleList.isHasPreviousPage()%>">
                <form action="<%=path%>/<%=requestUrl%>" style="float: left;align-content: center" method="post">
                    <input type="hidden" name="articleTypeId" value="${sessionScope.get("articleTypeId")}"/>
                    <input type="hidden" name="pageNum" value="<%=articleList.getPrePage()%>"/>
                    <input type="image" src="<%=basePath%>/static/images/pre.png" onclick="document.name.submit()" style="text-align: center" />&nbsp;&nbsp;|
                </form>
            </c:if>

            <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                <form action="<%=path%>/<%=requestUrl%>" style="float: left;color:${num eq pageInfo.pageNum?"red":""};align-content: center " method="post">
                    <input type="hidden" name="articleTypeId" value="${sessionScope.get("articleTypeId")}"/>
                    <input type="hidden" name="pageNum" value="${num}"/>
                    <input type="submit" value="${num}" style="text-align: center"/>&nbsp;&nbsp;|
                </form>
            </c:forEach>

            <c:if test="<%=articleList.isHasNextPage()%>">
                <form action="<%=path%>/<%=requestUrl%>" style="float: left;align-content: center" method="post">
                    <input type="hidden" name="articleTypeId" value="${sessionScope.get("articleTypeId")}"/>
                    <input type="hidden" name="pageNum" value="<%=articleList.getNextPage()%>"/>
                    <input type="image" src="<%=basePath%>/static/images/next.png" onclick="document.name.submit()" style="text-align: center"/>&nbsp;&nbsp;|
                </form>
            </c:if>
            <c:if test="<%=!articleList.isIsLastPage()%>">
                <form action="<%=path%>/<%=requestUrl%>" style="float: left;align-content: center" method="post">
                    <input type="hidden" name="articleTypeId" value="${sessionScope.get("articleTypeId")}"/>
                    <input type="hidden" name="pageNum" value="<%=articleList.getNavigateLastPage()%>"/>
                    <input type="image" src="<%=basePath%>/static/images/last.png" onclick="document.name.submit()" style="text-align: center"/>
                </form>
            </c:if>
            当前第<%=articleList.getPageNum()%>/<%=articleList.getPages()%>
        </div>
    </div>
    <!-- end content -->
    <jsp:include page="view/FrontLeft.jsp" flush="true" />
    <div style="clear: both;">&nbsp;</div>
</div>
<!-- start footer -->
<jsp:include page="view/FrontFoot.jsp" flush="true"/>
<!-- end footer -->
<%
    session.removeAttribute("pageInfo");
    session.removeAttribute("requestUrl");
    session.removeAttribute("commentBeanList");
    session.removeAttribute("typeBeanList");
    session.removeAttribute("userBeanList");
%>
</body>
</html>
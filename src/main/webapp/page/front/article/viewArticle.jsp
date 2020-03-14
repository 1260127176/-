<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ruoyu.bean.*" %>
<%@ page import="java.util.Iterator" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>阅读博客</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="${pageContext.request.contextPath}/static/css/default.css" rel="stylesheet"
          type="text/css" media="screen"/>
</head>
<body>

<!-- start header -->
<jsp:include page="/page/front/view/FrontHead.jsp"/>
<!-- end header -->

<!-- start page -->
<div id="page"><!-- start content -->
    <div id="content">
        <%
            ArticleBean articleSingle = (ArticleBean) session.getAttribute("articleBean");
            session.removeAttribute("articleBean");
            XbloUserBean xbloUser= (XbloUserBean) session.getAttribute("userBean");
            List<ArticleCommentBean> articleCommentList= (List<ArticleCommentBean>) session.getAttribute("commentBeanList");
            session.removeAttribute("commentBeanList");
            String xbloUsername = "";
            int commentCount = 0;
            xbloUsername = xbloUser.getXbloUsername();
            commentCount = articleCommentList.size();
        %>
        <div class="post">
            <h2 class="title"><%=articleSingle.getArticleTitle()%>
            </h2>
            <p class="meta"><small><a href="#"><%=xbloUsername%></a> 发布于 <%=articleSingle.getCreateDate()%>
                <b>&nbsp;|&nbsp;</b> 阅读 (<%=articleSingle.getVisitCount()%>) <b>&nbsp;|&nbsp;</b>
                <a href="#FeedBack">评论 (<%=commentCount%>)</a></small></p>
            <div class="entry">
                <textarea name="content" rows="10" cols="61" readonly style="background: #ffab3f"><%=articleSingle.getArticleContent()%></textarea>
                <p><%=articleSingle.getArticleContent()%>
                </p>
            </div>
        </div>

        <fieldset style="border: #DD691D">
            <legend style="font-size: 20px">评论文章</legend>
            <form action="/comment/insert" method="post">
                姓名：
                <input type="text" name="articleCommentUser" size="60" placeholder="匿名用户"
                       class="easyui-textbox"  data-options="required:true"/><br/>
                邮件：
                <input type="text" class="easyui-textbox" name="articleCommentEmail"  size="60"
                       placeholder="user@domain.com" data-options="required:true,validType:'email'"/><br/>
                内容：
                <textarea name="articleCommentContent" rows="10" cols="61" placeholder="这里输入文字"></textarea><br/>

                <input type="hidden" name="articleId" value="<%=articleSingle.getArticleId()%>"/>

                <input type="submit" value="提交" style="width: 50px" />
                <input type="reset" value="重置" style="width:50px" />
            </form>
        </fieldset>
        <!-- 评论开始 -->
        <div class="comment">
            <%
                for (Iterator<ArticleCommentBean> iter = articleCommentList
                        .iterator(); iter.hasNext(); ) {
                    ArticleCommentBean articleCommentBean = (ArticleCommentBean) iter
                            .next();
            %>
            <p class="title"><%=articleCommentBean.getArticleCommentUser()%>
                发表于：<%=articleCommentBean.getArticleCommentDate()%>
            </p>
            <p><%=articleCommentBean.getArticleCommentContent()%>
            </p>
            <%
                }
            %> <a name="FeedBack"></a>
        </div>
        <!-- 评论结束 -->
    </div>


    <!-- end content --> <!-- start sidebar -->
    <jsp:include
            page="/page/front/view/FrontLeft.jsp"/> <!-- end sidebar -->

    <div style="clear: both;">&nbsp;</div>
</div>
<!-- end page -->

<!-- start footer -->
<jsp:include page="/page/front/view/FrontFoot.jsp"/>
<!-- end footer -->

</body>
</html>

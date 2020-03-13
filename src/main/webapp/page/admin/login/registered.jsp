<%@ page language="java" contentType="text/html; charset=UTF-8"
%>
<%
    String path = request.getContextPath();        //返回站点根目录
    String basePath = request.getScheme() + "://"    //得到协议名称“http”
            + request.getServerName() + ":" + request.getServerPort()//获取配置文件中配置的服务器名，端口号
            + path;//http://localhost:8080/
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>管理界面</title>
    <link rel="stylesheet" type="text/css" href="../easyui.css">
    <link rel="stylesheet" type="text/css" href="../icon.css">
    <link rel="stylesheet" type="text/css" href="../demo.css">
    <script type="text/javascript" src="../jquery.min.js"></script>
    <script type="text/javascript" src="../jquery.easyui.min.js"></script>

    <link href="<%=basePath%>/static/css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<h2>Basic Form</h2>
<p>Fill the form and submit it.</p>
<div style="margin:20px 0;"></div>
<div class="easyui-panel" title="New Topic" style="width:100%;max-width:400px;padding:30px 60px;">
    <form id="ff" method="post">
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="name" style="width:100%" data-options="label:'用户名:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="email" style="width:100%" data-options="label:'Email:',required:true,validType:'email'">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="subject" style="width:100%" data-options="label:'Subject:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="message" style="width:100%;height:60px" data-options="label:'Message:',multiline:true">
        </div>
        <div style="margin-bottom:20px">
            <select class="easyui-combobox" name="language" label="Language" style="width:100%">
                <option value="ar">Arabic</option>
                <option value="bg">Bulgarian</option>
                <option value="ca">Catalan</option>
                <option value="zh-cht">Chinese Traditional</option>
                <option value="cs">Czech</option>
                <option value="da">Danish</option>
            </select>
        </div>
    </form>
    <div style="text-align:center;padding:5px 0">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a>
    </div>
</div>
<script>
    function submitForm(){
        $('#ff').form('submit');
    }
    function clearForm(){
        $('#ff').form('clear');
    }
</script>

</body>
</html>


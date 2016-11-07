<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>send message</title>
<script type="text/javascript" src="js/client.js"></script>
</head>
<body>
<div style="text-align:left">  
    <form action="#">  
        <input type="text"  id="message" placeholder="Please enter your name."/>  
        <input type="button" id="sender" value="发送消息" onclick="sayHello()"/>  
    </form>  
</div>  
<div id="output">  
</div>
</body>
</html>

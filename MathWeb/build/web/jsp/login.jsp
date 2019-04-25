<%-- 
    Document   : login
    Created on : Apr 21, 2019, 11:07:52 AM
    Author     : Nghĩa Phan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
    </head>
    <body>
        <f:form action="login.htm" commandName="userLogin">
            User Name:<f:input path="userName"/><br>
            Password:<f:password path="passWord"/><br>
            <input type="submit" value="Login"/>
        </f:form>
    </body>
</html>

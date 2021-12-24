<%@include file="index.jsp" %>

<hr/>

<h1>This is login page</h1>

<%
    String profile_msg = (String)request.getAttribute("profile_msg");
    
    if(profile_msg != null)
        out.println(profile_msg);
    
    String login_msg = (String)request.getAttribute("login_msg");
    
    if(login_msg != null)
        out.println(login_msg);
%>

<br/>
<br/>

<form action="loginProcess.jsp" method="POST">
    <table border="0">
        <tbody>
            <tr>
                <td>Enter Name:</td>
                <td><input type="text" name="name" value="" /></td>
            </tr>
            <tr>
                <td>Enter Username:</td>
                <td><input type="text" name="uname" value="" /></td>
            </tr>
            <tr>
                <td>Enter Password:</td>
                <td><input type="password" name="pass" value="" /></td>
            </tr>
        </tbody>
        <tr>
            <td><input type="submit" value="Submit" /></td>
            <td><input type="reset" value="Reset" /></td>
        </tr>
    </table>

</form>

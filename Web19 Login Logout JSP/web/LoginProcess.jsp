<%@page import="bean.LoginDao" %>

<jsp:useBean id="obj" class="bean.LoginBean" />

<jsp:setProperty name="obj" property="*" value="" />

<%
    Boolean status = LoginDao.validate(obj);

    if (status) {
        out.println("You are Successfully Logged in");
        session.setAttribute("session", "TRUE");
    } else {
        out.print("Invalid Email or Passord");
%>
<jsp:include page="index.jsp"></jsp:include>
<%
    }
%>

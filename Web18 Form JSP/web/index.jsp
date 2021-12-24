<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Registration Form</h1>
        <form action="process.jsp">
            <table cellspacing="2">
                <tbody>
                    <tr>
                        <td><input type="text" name="uname" placeholder="Username" /></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="email" placeholder="Email" /></td>
                    </tr>
                    <tr>
                        <td><input type="password" name="upass" placeholder="Password" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Register" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>

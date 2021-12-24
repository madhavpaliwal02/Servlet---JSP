package com;

import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CustomTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {

        try {
            JspWriter out = pageContext.getOut();

            out.println("<h1>This is my Custom Tag </h1>");
            out.println(new Date().toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

}

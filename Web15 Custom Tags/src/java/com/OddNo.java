package com;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class OddNo extends TagSupport {

    int num;

    public void setNum(int num) {
        this.num = num;
    }
    
    
    @Override
    public int doStartTag() throws JspException {
        try{
            JspWriter out = pageContext.getOut();
            
            int i=1;
            while(i<=num){
                if(i%2!=0){
                    out.println(i + " ");
                }
                i++;
            }
        }catch(Exception e){
            
        }
        
        return SKIP_BODY;
    }
    
}

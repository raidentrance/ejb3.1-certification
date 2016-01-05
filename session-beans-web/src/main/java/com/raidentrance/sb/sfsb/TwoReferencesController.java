/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidentrance.sb.sfsb;

import com.raidentrance.session.beans.sfsb.StudentBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author alejandrobautista
 */
@ManagedBean
@SessionScoped
public class TwoReferencesController {

    @EJB
    private StudentBean studentBean;
    @EJB
    private StudentBean studentBean2;
    
    public boolean getEqualityUsingOperator(){
        return (studentBean==studentBean2);
    }
    
     public boolean getEqualityUsingEquals(){
        return (studentBean.equals(studentBean2));
    }
}

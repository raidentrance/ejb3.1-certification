/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidentrance.sb.slsb;

import com.raidentrance.session.beans.slsb.MathHelperBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author alejandrobautista
 */
@ManagedBean
@RequestScoped
public class TwoStatelessReferencesController {

    @EJB
    private MathHelperBean mathHelperBean;
    @EJB
    private MathHelperBean mathHelperBean2;

    public boolean getEqualityUsingOperator() {
        return (mathHelperBean == mathHelperBean2);
    }

    public boolean getEqualityUsingEquals() {
        return (mathHelperBean.equals(mathHelperBean2));
    }
}

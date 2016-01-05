/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidentrance.sb.singleton;

import com.raidentrance.session.beans.singleton.SingletonStudentBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author alejandrobautista
 */
@ManagedBean
@RequestScoped
public class TwoSingletonReferencesEqualityController {

    @EJB
    private SingletonStudentBean singletonStudentBean;
    @EJB
    private SingletonStudentBean singletonStudentBean2;

    public boolean getEqualityUsingOperator() {
        return (singletonStudentBean == singletonStudentBean2);
    }

    public boolean getEqualityUsingEquals() {
        return (singletonStudentBean.equals(singletonStudentBean2));
    }

}

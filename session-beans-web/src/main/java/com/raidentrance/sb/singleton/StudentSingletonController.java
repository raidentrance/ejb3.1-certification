/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidentrance.sb.singleton;

import com.raidentrance.session.beans.singleton.SingletonStudentBean;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author alejandrobautista
 */
@ManagedBean
@SessionScoped
public class StudentSingletonController {
    
    private String name;
    @EJB
    private SingletonStudentBean studentBean;

    public List<String> getNames() {
        return studentBean.getNames();
    }

    public void addStudent() throws Exception {
        studentBean.addName(name);
        name = new String();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidentrance.sb.sfsb;

import com.raidentrance.session.beans.sfsb.StudentBean;
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
public class StudentController {

    private String name;
    @EJB
    private StudentBean studentBean;

    public List<String> getNames() {
        return studentBean.getNames();
    }

    public void clean() {
        studentBean.end();
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

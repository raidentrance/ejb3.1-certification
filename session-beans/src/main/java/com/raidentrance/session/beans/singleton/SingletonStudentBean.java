/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidentrance.session.beans.singleton;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author alejandrobautista
 */
@Singleton
@Startup
@DependsOn(value = "ListManagerBean")
public class SingletonStudentBean {

    @EJB
    private ListManagerBean listManagerBean;

    @PostConstruct
    public void init() {
        System.out.println("Initializing SingletonStudentBean");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying SingletonStudentBean");
    }

    public void addName(String name) {
        listManagerBean.addName(name);
    }

    public List<String> getNames() {
        return listManagerBean.getNames();
    }

}

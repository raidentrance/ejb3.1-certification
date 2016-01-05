/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidentrance.session.beans.singleton;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author alejandrobautista
 */
@Singleton
@Startup
public class ListManagerBean {

    private List<String> names;

    @PostConstruct
    public void init() {
        System.out.println("Initializing ListManagerBean");
        names = new ArrayList<>();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying ListManagerBean");
    }

    public void addName(String name) {
        names.add(name);
    }

    public List<String> getNames() {
        return names;
    }
}

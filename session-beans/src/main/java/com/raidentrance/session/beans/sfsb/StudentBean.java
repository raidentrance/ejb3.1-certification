/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidentrance.session.beans.sfsb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author alejandrobautista
 */
@Stateful
public class StudentBean {

    private List<String> names;

    @PostConstruct
    public void init() {
        System.out.println("Initializing StudentBean");
        names = new ArrayList<>();
    }

    public void addName(String name) {
        names.add(name);
    }

    public List<String> getNames() {
        return names;
    }
    
    @Remove
    public void end(){
    }
}

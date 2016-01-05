package com.raidentrance.session.beans.slsb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

/**
 *
 * @author alejandrobautista
 */
@Stateless
public class MathHelperBean {

    @PostConstruct
    public void init() {
        System.out.println("Initializing MathHelperBean");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying MathHelperBean");
    }

    public double areaCalulator(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }
}

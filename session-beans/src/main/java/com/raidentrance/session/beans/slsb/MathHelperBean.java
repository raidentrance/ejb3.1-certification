package com.raidentrance.session.beans.slsb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author alejandrobautista
 */
@Stateless
@LocalBean
public class MathHelperBean {

    public double areaCalulator(double radius) {
        return Math.PI*Math.pow(radius, 2);
    }
}

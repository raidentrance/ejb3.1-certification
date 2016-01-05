package com.raidentrance.sb.slsb;

import com.raidentrance.session.beans.slsb.MathHelperBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author alejandrobautista
 */
@ManagedBean
@RequestScoped
public class MathHelperController {

    private Double radius;
    private Double result;
    @EJB
    private MathHelperBean mathHelperBean;

    public void calculate() {
       result= mathHelperBean.areaCalulator(radius);
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

}

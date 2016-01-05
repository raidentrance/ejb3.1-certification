/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidentrance.sb.miltipleinterfaces;

import com.raidentrance.session.beans.multipleinterfaces.AccountBeanLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author alejandrobautista
 */
@ManagedBean
@RequestScoped
public class MultipleInterfacesController {
    
    private float corporateDiscount;
    private float nonProfitDiscount;
    
    @EJB
    private AccountBeanLocal accountBean;
    
    public void updateValues(){
        accountBean.setCorporateDiscount(corporateDiscount);
        accountBean.setNonProfitDiscount(nonProfitDiscount);
    }
    
    public float getCorporateDiscount() {
        return accountBean.getCorporateDiscount();
    }

    public float getNonProfitDiscount() {
        return accountBean.getNonProfitDiscount();
    }

    public void setCorporateDiscount(float corporateDiscount) {
        this.corporateDiscount = corporateDiscount;
    }

    public void setNonProfitDiscount(float nonProfitDiscount) {
        this.nonProfitDiscount = nonProfitDiscount;
    }
    
    
}

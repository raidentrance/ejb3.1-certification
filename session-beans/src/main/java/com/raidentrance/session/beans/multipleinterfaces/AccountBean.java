/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidentrance.session.beans.multipleinterfaces;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 *
 * @author alejandrobautista
 */
@Singleton
public class AccountBean implements AccountBeanRemote,
        AccountBeanLocal {

    private float corporateDiscount;
    private float nonProfitDiscount;

    @PostConstruct
    public void initialize() {
        corporateDiscount = 0.15f;
        nonProfitDiscount = 0.25f;
    }

    @Override
    public float getCorporateDiscount() {
        return corporateDiscount;
    }

    @Override
    public float getNonProfitDiscount() {
        return nonProfitDiscount;
    }

    @Override
    public void setCorporateDiscount(float corporateDiscount) {
        this.corporateDiscount = corporateDiscount;
    }

    @Override
    public void setNonProfitDiscount(float nonProfitDiscount) {
        this.nonProfitDiscount = nonProfitDiscount;
    }

}

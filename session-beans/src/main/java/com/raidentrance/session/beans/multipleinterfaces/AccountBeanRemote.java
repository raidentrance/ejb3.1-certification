/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidentrance.session.beans.multipleinterfaces;

import javax.ejb.Remote;

/**
 *
 * @author alejandrobautista
 */
@Remote
public interface AccountBeanRemote {

    public float getCorporateDiscount();

    public float getNonProfitDiscount();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidentrance.sb.singleton;

import com.raidentrance.session.beans.singleton.concurrency.SimulationContainerManaged;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author alejandrobautista
 */
@ManagedBean
@RequestScoped
public class ConcurrencyManagementController {

    @EJB
    private SimulationContainerManaged simulationContainerManaged;

    @PostConstruct
    public void init() {
        simulationContainerManaged.setState(SimulationContainerManaged.State.PAUSED);
    }

    public String getState() {
        return simulationContainerManaged.getState().toString();
    }
}

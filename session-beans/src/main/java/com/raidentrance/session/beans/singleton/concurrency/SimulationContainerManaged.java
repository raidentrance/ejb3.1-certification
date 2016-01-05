/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidentrance.session.beans.singleton.concurrency;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

/**
 *
 * @author alejandrobautista
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class SimulationContainerManaged {

    public enum State {
        PAUSED, RUNNING, TERMINATED
    }
    
    private State state;

    @Lock(LockType.READ)
    public State getState() {
        return state;
    }

    @Lock(LockType.WRITE)
    public void setState(State state) {
        this.state = state;
    }
}

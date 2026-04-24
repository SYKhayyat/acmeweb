package com.acme.statusmgr.beans.decorators;

import com.acme.statusmgr.beans.I_ServerDetails;

public class FreeJVMMemoryDecorator implements I_ServerDetails {
    private final Integer requestCost = 7;
    private I_ServerDetails thingIAmWrapping;
    public FreeJVMMemoryDecorator(I_ServerDetails thingIAmWrapping) {
        this.thingIAmWrapping = thingIAmWrapping;
    }
    @Override
    public long getId() {
        return thingIAmWrapping.getId();
    }

    @Override
    public String getContentHeader() {
        return thingIAmWrapping.getContentHeader();
    }

    @Override
    public String getStatusDesc() {
        String base =  thingIAmWrapping.getStatusDesc();
        String added = ", and there are " + Runtime.getRuntime().freeMemory() + " bytes of JVM memory free" ;
        return base + added;
    }

    @Override
    public Integer getRequestCost() {
        return requestCost + thingIAmWrapping.getRequestCost();
    }
}

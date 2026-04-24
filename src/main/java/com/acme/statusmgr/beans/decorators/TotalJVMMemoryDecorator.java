package com.acme.statusmgr.beans.decorators;

import com.acme.statusmgr.beans.I_ServerDetails;

public class TotalJVMMemoryDecorator implements I_ServerDetails {
    private final Integer requestCost = 13;
    private I_ServerDetails thingIAmWrapping;
    public TotalJVMMemoryDecorator(I_ServerDetails thingIAmWrapping) {
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
        String added = ", and there is a total of 159383552 bytes of JVM memory";
        return base + added;
    }

    @Override
    public Integer getRequestCost() {
        return requestCost + thingIAmWrapping.getRequestCost();
    }
}

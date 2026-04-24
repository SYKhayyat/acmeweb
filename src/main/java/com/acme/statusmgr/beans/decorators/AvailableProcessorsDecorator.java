package com.acme.statusmgr.beans.decorators;

import com.acme.statusmgr.beans.I_ServerDetails;

public class AvailableProcessorsDecorator implements I_ServerDetails {
    private final Integer requestCost = 3;
    private I_ServerDetails thingIAmWrapping;
    public AvailableProcessorsDecorator(I_ServerDetails thingIAmWrapping) {
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
        String added = ", and there are 4 processors available";
        return base + added;
    }

    @Override
    public Integer getRequestCost() {
        return requestCost + thingIAmWrapping.getRequestCost();
    }
}

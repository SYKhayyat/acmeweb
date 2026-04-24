package com.acme.statusmgr.beans.decorators;

import com.acme.statusmgr.beans.I_ServerDetails;

public class JREVersionDecorator implements I_ServerDetails {
    private final Integer requestCost = 19;
    private I_ServerDetails thingIAmWrapping;
    public JREVersionDecorator(I_ServerDetails thingIAmWrapping) {
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
        String added = ", and the JRE version is 15.0.2+7-27";
        return base + added;
    }

    @Override
    public Integer getRequestCost() {
        return requestCost + thingIAmWrapping.getRequestCost();
    }
}

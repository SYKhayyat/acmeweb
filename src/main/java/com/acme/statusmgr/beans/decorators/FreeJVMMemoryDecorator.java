package com.acme.statusmgr.beans.decorators;

import com.acme.statusmgr.beans.I_ServerDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is a decorator class of the base ServerStatus class, implementing I_ServerDetails.
 * It adds in the details of free JVM memory, and calculates a new cost.
 */
public class FreeJVMMemoryDecorator implements I_ServerDetails {
    private final Integer requestCost = 7;
    private I_ServerDetails thingIAmWrapping;
    private static final Logger logger = LoggerFactory.getLogger(FreeJVMMemoryDecorator.class);
    public FreeJVMMemoryDecorator(I_ServerDetails thingIAmWrapping) {
        this.thingIAmWrapping = thingIAmWrapping;
        logger.info("Applying decorator: freeJVMMemory, cost=" + requestCost);
    }
    @Override
    public long getId() {
        return thingIAmWrapping.getId();
    }

    @Override
    public String getContentHeader() {
        return thingIAmWrapping.getContentHeader();
    }
    /**
     * A decorator method, adding details functionality.
     * @return the detailed server status string.
     */
    @Override
    public String getStatusDesc() {
        String base =  thingIAmWrapping.getStatusDesc();
        String added = ", and there are 127268272 bytes of JVM memory free" ;
        return base + added;
    }
    /**
     * A decorator method, returning a new cost.
     * @return the cost, given the request for additional detail.
     */
    @Override
    public Integer getRequestCost() {
        return requestCost + thingIAmWrapping.getRequestCost();
    }
}

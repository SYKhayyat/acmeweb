package com.acme.statusmgr.beans.decorators;

import com.acme.statusmgr.beans.BaseServerStatus;
import com.acme.statusmgr.beans.I_ServerDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is a decorator class of the base ServerStatus class,
 * extending BaseServerStatus, and thus implementing I_ServerDetails.
 * It adds in the details of total JVM memory, and calculates a new cost.
 */
public class TotalJVMMemoryDecorator extends BaseServerStatus {
    private I_ServerDetails thingIAmWrapping;
    private static final Logger logger = LoggerFactory.getLogger(TotalJVMMemoryDecorator.class);
    public TotalJVMMemoryDecorator(I_ServerDetails thingIAmWrapping) {
        super(0, null); // These are dummy values that will not be used.
        this.thingIAmWrapping = thingIAmWrapping;
        logger.info("Applying decorator: totalJVMMemory");
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
     * It calculates the amount of processors by delegating calls to a SystemInfo object,
     * which has real and fake implementations.
     * @return the detailed server status string.
     */
    @Override
    public String getStatusDesc() {
        String base =  thingIAmWrapping.getStatusDesc();
        long totalMemory = getProvider().getTotalJVMMemory();
        logger.info("Recomputed totalJVMMemory: {} memory", totalMemory);
        String added = ", and there is a total of " + totalMemory + " bytes of JVM memory" ;
        return base + added;
    }
    /**
     * A decorator method, returning a new cost.
     * @return the cost, given the request for additional detail.
     */
    @Override
    public Integer getRequestCost() {
        Integer requestCost = 13;
        logger.info("Additional Cost:{}", requestCost);
        return requestCost + thingIAmWrapping.getRequestCost();    }
}

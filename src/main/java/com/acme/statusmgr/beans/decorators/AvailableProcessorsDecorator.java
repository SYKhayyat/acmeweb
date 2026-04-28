package com.acme.statusmgr.beans.decorators;

import com.acme.statusmgr.beans.BaseServerStatus;
import com.acme.statusmgr.beans.I_ServerDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is a decorator class of the base ServerStatus class,
 * extending BaseServerStatus, and, thus, implementing I_ServerDetails.
 * It adds in the details of available processors, and calculates a new cost.
 */
public class AvailableProcessorsDecorator extends BaseServerStatus {
    private final Integer requestCost = 3;
    private I_ServerDetails thingIAmWrapping;
    private static final Logger logger = LoggerFactory.getLogger(AvailableProcessorsDecorator.class);
    public AvailableProcessorsDecorator(I_ServerDetails thingIAmWrapping) {
        super(0, null); // These are dummy values that will not be used.
        this.thingIAmWrapping = thingIAmWrapping;
        logger.info("Applying decorator: availableProcessors, cost=" + requestCost);
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
        int processors = getProvider().getAvailableProcessors();
        logger.info("Recomputed availableProcessors: {} processors", processors);
        String added = ", and there are " +  processors + " processors available";
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

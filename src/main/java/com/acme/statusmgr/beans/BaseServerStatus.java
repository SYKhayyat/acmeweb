package com.acme.statusmgr.beans;

import com.acme.statusmgr.facade.I_SystemInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is an abstract class which will hold a system info provider
 * and which will be inherited by all the ServerStatus children.
 * It calls the basic methods of ServerStatus, and provides them with a provider.
 */
public abstract class BaseServerStatus implements I_ServerDetails{
    private long id;                // Unique identifier of request, sequential number
    private String contentHeader;   // Some info about the request
    private static I_SystemInfo provider;
    private static final Logger logger = LoggerFactory.getLogger(BaseServerStatus.class);

    public BaseServerStatus(long id, String contentHeader) {
        this.id = id;
        this.contentHeader = contentHeader;
    }

    /**
     * This sets the SystemInfo to the specified object, allowing for real and mock calls to the info.
     * @param p An implementation if the I_SystemInfo interface, returning real or fake system information.
     */
    public static void setProvider(I_SystemInfo p){
        provider = p;
        logger.info("Provider set to: {}", p.getClass().getSimpleName());
    }

    /**
     * get the SystemInfo provider
     * @return the provider of system information (real or fake)
     */
    protected static I_SystemInfo getProvider(){
        return provider;
    }
    /**
     * get the id of this request
     *
     * @return a numeric id that increases during life of server for each request .
     */
    public long getId() {
        return id;
    }
    /**
     * Get the content header that was specified by the request
     *
     * @return some string
     */
    public String getContentHeader() {
        return contentHeader;
    }

    public abstract String getStatusDesc();
    public abstract Integer getRequestCost();

}

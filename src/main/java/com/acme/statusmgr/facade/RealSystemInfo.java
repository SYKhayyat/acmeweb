package com.acme.statusmgr.facade;

/**
 * This class is the single class which can be called in order to find any system value.
 * It acts as a facade and hides calls to Runtime and System.
 */
public class RealSystemInfo implements I_SystemInfo{
    public int getAvailableProcessors(){
        return Runtime.getRuntime().availableProcessors();
    }
    public long getFreeJVMMemory(){
        return Runtime.getRuntime().freeMemory();
    }
    public long getTotalJVMMemory(){
        return Runtime.getRuntime().totalMemory();
    }
    public String getJREVersion(){
        return System.getProperty("java.version");
    }
    public String getTempLocation(){
        return System.getenv("TEMP");
    }
}

package com.acme.statusmgr.facade;

/**
 * This class is the single class which can be called in order to find any system value.
 * It acts as a facade and hides calls to Runtime and System.
 */
public class RealSystemInfo {
    int getAvailableProcessors(){
        return Runtime.getRuntime().availableProcessors();
    }
    long getFreeJVMMemory(){
        return Runtime.getRuntime().freeMemory();
    }
    long getTotalJVMMemory(){
        return Runtime.getRuntime().totalMemory();
    }
    String getJREVersion(){
        return System.getProperty("java.version");
    }
    String getTempLocation(){
        return System.getenv("TEMP");
    }
}

package com.acme.statusmgr.facade;

public class realSystemInfo {
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

package com.acme.statusmgr.facade;

/**
 * This class is a mock facade.
 * It returns predetermined (fake) values for system calls, to satisfy tests.
 */
public class MockSystemInfo implements I_SystemInfo{
    public int getAvailableProcessors(){
        return 4;
    }
    public long getFreeJVMMemory(){
        return 127268272L;
    }
    public long getTotalJVMMemory(){
        return 159383552L;
    }
    public String getJREVersion(){
        return "15.0.2+7-27";
    }
    public String getTempLocation(){
        return "M:\\\\AppData\\\\Local\\\\Temp";
    }
}

package com.acme.statusmgr.facade;

/**
 * This class is a mock facade.
 * It returns predetermined (fake) values for system calls, to satisfy tests.
 */
public class MockSystemInfo {
    int getAvailableProcessors(){
        return 4;
    }
    long getFreeJVMMemory(){
        return 127268272L;
    }
    long getTotalJVMMemory(){
        return 159383552L;
    }
    String getJREVersion(){
        return "15.0.2+7-27";
    }
    String getTempLocation(){
        return "M:\\AppData\\Local\\Temp";
    }
}

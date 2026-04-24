package com.acme.statusmgr.facade;

public interface I_SystemInfo {
    int getAvailableProcessors();
    long getFreeJVMMemory();
    long getTotalJVMMemory();
    String getJREVersion();
    String getTempLocation();
}

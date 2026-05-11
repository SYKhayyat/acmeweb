package com.acme.statusmgr.facade;

/**
 * This is a facade interface.
 * It will be implemented by various methods (real and mocked) of returning these system values.
 */

public interface I_SystemInfo {
    int getAvailableProcessors();
    long getFreeJVMMemory();
    long getTotalJVMMemory();
    String getJREVersion();
    String getTempLocation();
}

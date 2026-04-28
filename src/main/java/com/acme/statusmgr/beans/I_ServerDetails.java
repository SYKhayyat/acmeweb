package com.acme.statusmgr.beans;

/**
 * This is an interface which every class returning serverDetails must implement.
 * It is written to help them provide decorator functionality.
 * It defines that they must return the ID (as a long),
 * the contentHeader, the statusDescription, and the requestCost.
 */

public interface I_ServerDetails {
    long getId();
    String getContentHeader();
    String getStatusDesc();
    Integer getRequestCost();
}

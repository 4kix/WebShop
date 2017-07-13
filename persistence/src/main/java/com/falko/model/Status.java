package com.falko.model;


public enum Status {

    NEW("New"), WAIT("Await"), PAID("Paid");
    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}

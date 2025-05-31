package com.npo.login;

public enum UserRole {
    SUPER_ADMIN(1, "Has superuser privileges"),
    ADMIN(2, "Has full access"),
    LEADERSHIP(2, "Handles strategic decisions"),
    LEAD(4, "Leads a team"),
    COMMS(5, "Manages communications"),
    COORDINATOR(6, "Coordinates events"),
    WORKER(7, "Performs assigned tasks");

    private final long id;
    private final String description;

    UserRole(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
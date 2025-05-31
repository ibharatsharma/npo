package com.npo.login;

public enum UserRole {
    ADMIN(1, "Has full access"),
    COMMS(2, "Manages communications"),
    COORDINATOR(3, "Coordinates events"),
    LEAD(4, "Leads a team"),
    LEADERSHIP(5, "Handles strategic decisions"),
    SUPER_ADMIN(6, "Has superuser privileges"),
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
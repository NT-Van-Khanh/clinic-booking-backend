package com.ptithcm.clinic_booking.dto;

public class RoleDTO {
    private Short id;
    private String name;
    private String status;

    public RoleDTO() {
    }

    public RoleDTO(Short id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

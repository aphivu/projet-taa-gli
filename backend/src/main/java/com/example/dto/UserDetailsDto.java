package com.example.dto;


import java.util.ArrayList;
import java.util.List;

public class UserDetailsDto {

    private UserDTO details;
    private List<ActiviteDTO> activities;

    public UserDetailsDto(){
        this.details = new UserDTO();
        this.activities = new ArrayList<>();
    }

    public UserDetailsDto(UserDTO dto){
        this.activities = new ArrayList<>();
        this.details = dto;
    }

    public List<ActiviteDTO> getActivities() {
        return activities;
    }

    public void setActivities(List<ActiviteDTO> activities) {
        this.activities = activities;
    }

    public UserDTO getDto() {
        return details;
    }

    public void setDto(UserDTO dto) {
        this.details = dto;
    }
}

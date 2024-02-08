package com.infocert.schoolsystem.dto;

import lombok.Data;
@Data
public class AddressDTO {
    private String country;
    private String city;
    private String street;
    private String houseNumber;
    private String postalCode;
}
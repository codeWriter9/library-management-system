package com.ghosh.sanjay.beans;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Address {

    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;

}

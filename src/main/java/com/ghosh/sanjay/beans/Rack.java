package com.ghosh.sanjay.beans;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Data
@Entity
public class Rack {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private int number;
    private String locationIdentifier;
}

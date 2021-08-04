package com.ghosh.sanjay.beans;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Rack {
    private int number;
    private String locationIdentifier;
}

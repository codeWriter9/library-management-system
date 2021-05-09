package com.ghosh.sanjay.enums;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Person {
  private String name;
  private Address address;
  private String email;
  private String phone;
}

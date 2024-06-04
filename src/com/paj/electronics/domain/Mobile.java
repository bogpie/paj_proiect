package com.paj.electronics.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class Mobile extends Product {
  private String displayResolution;
  private String aspectRatio;
  private boolean screenProtector;
}

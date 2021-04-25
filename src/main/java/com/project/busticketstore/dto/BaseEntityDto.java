package com.project.busticketstore.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public abstract class BaseEntityDto<T> {
    private T id;
}

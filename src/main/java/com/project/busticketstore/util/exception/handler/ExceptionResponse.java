package com.project.busticketstore.util.exception.handler;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExceptionResponse {
    private Date timeStamp;
    private String message;
    private String details;
}

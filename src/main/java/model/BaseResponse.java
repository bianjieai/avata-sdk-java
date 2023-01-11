package model;

import lombok.Data;

@Data
public class BaseResponse {
    private int code;
    private String message;
}

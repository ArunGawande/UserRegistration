package com.bridgelabz.userregistration.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {

    public Response(int i, String string, String token2) {
        this.errorCode=i;
        this.message=string;
        this.token=token2;
    }
    public Response() {
        // TODO Auto-generated constructor stub
    }
    public Response(String string) {
        this.message=string;
    }
    private String message;
    private int errorCode;
    private Object token;


}

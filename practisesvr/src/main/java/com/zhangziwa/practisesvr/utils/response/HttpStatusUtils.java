package com.zhangziwa.practisesvr.utils.response;

import org.springframework.http.HttpStatus;

public class HttpStatusUtils {

    public static HttpStatus num2HttpStatus(String num) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        for (HttpStatus status : HttpStatus.values()) {
            if (Integer.parseInt(num) == status.value()) {
                return status;
            }
        }
        return httpStatus;
    }
}

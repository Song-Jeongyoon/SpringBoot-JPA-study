package com.springboot.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {

    // @PathVariable과 @RequestParam을 활용한 DELETE 메서드 구현
    @DeleteMapping(value = "/{variable}")
    public String deleteVariable(@PathVariable String variable) {
        return variable;
    }

    @DeleteMapping(value = "/request1")
    public String deleteRequestParam(@RequestParam String age) {
        return "age : " + age;
    }
}


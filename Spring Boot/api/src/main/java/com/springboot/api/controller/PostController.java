package com.springboot.api.controller;


import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    // @RequestMapping으로 구현
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "This is Post API!";
    }

    // @RequestBody를 활용한 POST 메서드 구현
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData) {

        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // DTO를 활용한 POST 메서드 구현
    @PostMapping(value = "/dto")
    public String postDto(@RequestBody MemberDto mDto) {
        return mDto.toString();
    }


}

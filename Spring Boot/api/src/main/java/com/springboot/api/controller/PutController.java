package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    // @RequestBody를 활용한 PUT 메서드 구현 - 서버에 어떤 값이 들어올지 모를 경우
    @RequestMapping(value = "/member")
    public String putMember(@RequestBody Map<String, Object> putData) {

        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // DTO 객체를 활용한 PUT 메서드 구현 - 서버에 들어오는 요청의 값이 정해져 있는 경우
    @PutMapping(value = "/dto1")
    public String putMemberDto1(@RequestBody MemberDto mDto) {
        return mDto.toString();
    }

    @PutMapping(value = "/dto2")
    public MemberDto putMemberDto2(@RequestBody MemberDto mDto) {
        return mDto;
    }

    // ResponseEntity를 활용한 PUT 메서드 구현
    @PutMapping(value = "/member1")
    public ResponseEntity<MemberDto> putMemberDto3(@RequestBody MemberDto mDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mDto);
    }
}

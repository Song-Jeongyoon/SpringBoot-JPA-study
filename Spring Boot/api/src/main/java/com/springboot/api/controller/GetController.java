package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {


    // LOGGER 전역 변수로 객체 생성
    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);


    // @RequestMapping으로 구현하기
    // 로깅 추가
    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String getHello() {
        LOGGER.info("getHello 메서드 호출");
        return "Hello world";
    }

    // 매개변수 없는 GET 메서드 구현
    @GetMapping(value = "/name")
    public String getName() {
        LOGGER.info("getName 메서드 호출");
        return "Jeongyoon";
    }

    // @PathVariable을 활용한 메서드 구현
    // 로깅 추가
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        LOGGER.info("@PathVariable을 통해 틀어온 값 {}", variable);
        return variable;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    // Swagger 추가
    //@RequestParam을 활용한 GET 메서드 구현
    @ApiOperation(value = "GET 메서드 예제", notes = "@RequestParam을 활용한 GET 메서드 구현")
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @ApiParam(value = "이름", required = true) @RequestParam String name,
            @ApiParam(value = "이메일", required = true) @RequestParam String email) {
        return name + " " + email;
    }

    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {

        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // DTO를 활용한 GET메서드 구현
    @GetMapping(value = "/dto")
    public String getDto(MemberDto mDto) {
        return mDto.toString();
    }

}

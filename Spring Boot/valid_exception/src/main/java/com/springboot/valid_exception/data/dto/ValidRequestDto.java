package com.springboot.valid_exception.data.dto;

import lombok.*;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ValidRequestDto {

    // null, "", " " 허용하지 않음
    @NotBlank
    String name;

    // 이메일 형식 검증
    @Email
    String email;

    // 정규식 검증
    @Pattern(regexp = "01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$")
    String phoneNumber;

    // 최소값, 최대값 검증
    @Min(value=20) @Max(value=40)
    int age;

    // 문자열 길이 검증
    @Size(min=0, max=40)
    String description;

    // 양수 허용
    @Positive
    int count;

    // true인지 체크, null은 체크 안함
    @AssertTrue
    boolean booleanCheck;
}

package com.springboot.valid_exception.data.dto;

import com.springboot.valid_exception.config.annotation.Telephone;
import com.springboot.valid_exception.data.group.ValidationGroup1;
import com.springboot.valid_exception.data.group.ValidationGroup2;
import lombok.*;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ValidatedRequestDto {

    // null, "", " " 허용하지 않음
    @NotBlank
    String name;

    // 이메일 형식 검증
    @Email
    String email;

    // 정규식 검증
    @Telephone
    String phoneNumber;

    // 최소값, 최대값 검증
    @Min(value=20, groups = ValidationGroup1.class)
    @Max(value=40, groups = ValidationGroup1.class)
    int age;

    // 문자열 길이 검증
    @Size(min=0, max=40)
    String description;

    // 양수 허용
    @Positive(groups = ValidationGroup2.class)
    int count;

    // true인지 체크, null은 체크 안함
    @AssertTrue
    boolean booleanCheck;
}

package com.springboot.test.controller;

import com.google.gson.Gson;
import com.springboot.test.data.dto.ProductDto;
import com.springboot.test.data.dto.ProductResponseDto;
import com.springboot.test.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;            // 컨트롤러의 API 테스트를 위한 객체

    @MockBean
    ProductServiceImpl productService;  // ProductController가 의존성을 갖는 ProductService 객체에 가짜객체 주입

    @Test
    @DisplayName("MockMvc를 통한 Product 데이터 가져오기 Test")
    void getProductTest() throws Exception {

        // 호출될 메소드와 파라미터 가정 후 어떤 결과를 리턴할 것인지 정의
        given(productService.getProduct(123L)).willReturn(
                new ProductResponseDto(123L, "응원봉", 10000, 3000));

        String productId = "123";

        // 통신 테스트 코드를 작성. HTTP 메서드로 URL 작성
        mockMvc.perform(
                get("/product?number=" + productId))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.number").exists())
                        .andExpect(jsonPath("$.name").exists())
                        .andExpect(jsonPath("$.price").exists())
                        .andExpect(jsonPath("$.stock").exists())
                                .andDo(print());

        // 지정된 메소드가 실행되었는지 검증
        verify(productService).getProduct(123L);
    }

    @Test
    @DisplayName("Product 데이터 생성 테스트")
    void createProductTest() throws Exception {

        // 메서드의 동작 규칙 설정
        // 특정 메소드 실행 시 실제 return을 줄 수 없으므로 아래와 같이 가정사항을 만듦
        given(productService.saveProduct(new ProductDto("응원봉", 10000, 3000)))
                .willReturn(new ProductResponseDto(12315L, "웅원봉", 10000, 3000));

        // 테스트에 필요한 객체 생성
        ProductDto productDto = ProductDto.builder()
                .name("웅원봉").price(10000).stock(2000).build();

        Gson gson = new Gson(); // JSON 파싱 라이브러리
        String content = gson.toJson(productDto);

        // 실제 테스트 수행
        mockMvc.perform(
                post("/post").content(content).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.number").exists())
                    .andExpect(jsonPath("$.name").exists())
                    .andExpect(jsonPath("$.price").exists())
                    .andExpect(jsonPath("$.stock").exists())
                        .andDo(print());

        verify(productService).saveProduct(new ProductDto("응원봉", 10000, 3000));
    }
}

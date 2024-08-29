package com.sist.config;
/*
 * 	코딩은 단순
 * 	그러나
 * 	스프링 라이브러리 연결 => XML, Annotation
 * 	프레임워크는 기본 틀을 제작 (틀에 맞게 소스 코딩)
 */
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// 클래스 등록 파일 => application-context.xml
@Configuration
@ComponentScan(basePackages = {"com.sist.*"}) // <context:component-scan base-package="com.sist.*"/>와 같다
public class MusicConfig {

}

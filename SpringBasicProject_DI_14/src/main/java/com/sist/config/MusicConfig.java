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
/*
 * 	기능 처리 클래스 : 데이터베이스 연동 (DAO), Jsoup (Component)
 * 							Model
 * 	@Component
 * 	@Repository
 * 	@Service
 * 	==============
 * 	@Controller
 * 	@RestController
 * 	@ControllerAdvice
 * 	============== Web
 * 	=> 클래스 위에 설정된 경우면 메모리 할당 (객체 생성)
 * 		선택적인 메모리 할당
 * 
 * 	일반 스프링
 * 	========
 * 	1) DI : 클래스 설정 (등록)
 * 	2) AOP : 공통 모듈 설정 => CommonsModel => 자동 호출 (콜백)
 * 		AOP와 인터셉트의 차이점
 * 	3) MVC => ORM (MyBatis)
 * 	---------------------------------------------------------------------------
 * 	1) Security
 * 	2) Batch
 * 	=======
 * 	3) Cloud => MSA
 * 	4) AI
 */
@Configuration // bean configuration file로부터 ...
@ComponentScan(basePackages = {"com.sist.*"}) // <context:component-scan base-package="com.sist.*"/>와 같다
public class MusicConfig {

}

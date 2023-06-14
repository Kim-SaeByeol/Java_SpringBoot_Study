package kopo.java_springboot_study.service.impl;

/*
 * servic 패키지는 SpringBoot Framework 에서 중요 핵심 로직을 작성하는 영역임.
 * @service 이노테이션을 추가함으로써, 클래스를 서비스 빈(Service Bean)으로 등록하는데 사용함.
 * 서비스 빈(Service Bean)은 하나의 규칙이며, Service Bean으로 지정된 클래스는
 * 기본 생성자, 멤버변수, getter, setter 메서드를 가지게 됨.
 *
 * 기본 생성자는 생성자를 지정하지 않았을 경우 자바 컴파일러가 자동으로 만드는 생성자.
 * 생성자는 클래스 이름을 띄고 있으며 다음 예시와 같음. public class Ex { pcucblic Ex() { }}
 *
 * 멤버변수는 메인 클래스 밖에서 생성된 변수로, 기본적으로 Heap 영역에 속하며, static 키워드를 통해 Stack 영역에 속하기도 함.
 *
 * getter 와 setter 를 사용하기 위해서는 Lombok 라이브러리를 사용해야하지만,
 * @service 로 지정된 클래스는 Lombok 없이 getter 와 setter 를 사용할 수 있음.
 * 또한, Service를 지정하면 SpringBootFrameWork 가 실행될때 함께 메모리에 올라감.
 * 즉슨 Service 는 메모리 관리를 개발자가 할 필요가 없어짐.
 */

import kopo.java_springboot_study.dto.OcrDTO;
import kopo.java_springboot_study.service.IOcrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OcrService implements IOcrService {
    /*
     * implements 는 인터페이스의 객체들을 사용하기 위해 쓰는 것임.
     * extends 와 implements 는 상당히 비슷하면서 다른데,
     * extends 는 class - class / interface - interface.
     * 즉 서로 상속을 하는 의미이며,
     * implements 는 interface - class 만 가능하다.
     * implements 는 class 에서 interface에 내용을 사용할 수 있게 해주는 역할을 한다.
     */


    /*
    * 이미지 파일로부터 문자 읽어 오기.
    * @param pDTO 이미지 파일 정보
    * @return pDTO 이미지로부터 읽은 문자열
     */
    @Override
    public String getReadforImageText(OcrDTO pDTO) throws Exception {
        //log 는 해당 클래스가 @Slf4j 를 사용함에 따라 쓰는 것이며,
        //log 는 print 와 같은 역할을 함.
        // this.getClass().getName() 는 현재 객체의 클래스 이름을 반환하는 코드이다.
        // this.getClass() 는 현재 객체의 클래스를 나타내며
        // getclass().getName()는 Class 객체의 메소드로 클래스의 이름을 문자열로 반환합니다.
        log.info(this.getClass().getName() + "getReadforImageText start!");
        return null;
    }


}

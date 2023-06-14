package kopo.java_springboot_study.service;


import kopo.java_springboot_study.dto.OcrDTO;

public interface IOcrService {

    //인터페이스에서 관리할 변수 생성.
    //인터페이스에서는 기본값으로 final 값이기에 객체들이 상수가 됨.
    String modelFile = "C:\\model\\tessdata";
    //tessdata 는 pom에서 다운받은 tess4j를 사용하기 위한 프로그램으로 보면 됨.

    String getReadforImageText(OcrDTO pDTO) throws Exception;
}

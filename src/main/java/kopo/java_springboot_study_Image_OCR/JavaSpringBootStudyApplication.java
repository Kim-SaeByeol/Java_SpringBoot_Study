package kopo.java_springboot_study_Image_OCR;

import kopo.java_springboot_study_Image_OCR.dto.OcrDTO;
import kopo.java_springboot_study_Image_OCR.service.IOcrService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class JavaSpringBootStudyApplication implements CommandLineRunner {

    //@RequiredArgsConstructor 을 함으로써
    // RequiredArgsConstructor가 자동으로 생성자를 만들어줘
    // 인터페이스 객체를 지정할 수 있음.
    // 올라갈 파일은 @Service 가 정의된 Service 인터페이스임.
    // @Service 이노테이션은 메모리에 바로 올리기에 메모리에 올라간 OcrService 객체를 ocrService에 저장함.
    private final IOcrService ocrService;   // 이미지 인식

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringBootStudyApplication.class, args);
    }

    //CommandLineRunner 인터페이스에서 run() 객체를 받음.
    //메인 메소드는 실행시 run 객체를 실행하기에 코딩을 run 객체에 함.
    @Override
    public void run(String... args) throws Exception {
        log.info("자바 프로그래밍 시작!");

        String filePath = "image"; //문자열로 추출할 이미지가 있는 파일 경로
        String fileName = "news01.jpg"; //추출할 이미지 명
        //다른 이미지를 추출하고 싶다면 혹은 중복으로 추출하고 싶다면
        //해당 변수에 이름을 추가하거나 수정하면 됨.

        // 파라미터의 값을 OcrDTO 에 전달하기 위해 pDTO 객체를 생성함.
        // 파라미터 값을 넘겨주는 경우 변수 이름 앞에 p 를 붙임.
        OcrDTO pDTO = new OcrDTO(); // OcrService의 함수에 정보를 전달할 DTO를 메모리에 올리기.

        //OcrDTO에 생성된 변수에 값을 넣어줌.
        pDTO.setFilePath(filePath);
        pDTO.setFileName(fileName);

        //rDTO 는 result 값을 넣는 변수임.
        //보통 result 값을 넣는 변수 이름 앞에는 r 을 붙임.
        // rDTO 는 getReadforImageText() 메소드의 매개변수 pDTO를 result 값으로 받게 됨.
        // 해당 result 값은 ocrService에서 이미지 추출을 위해 기능한 문자열 추출한 결과물임.
        OcrDTO rDTO = ocrService.getReadforImageText(pDTO);

        //OctDTO 에 저장된 result 변수의 값을 불러옴.
        //이미지 추출을 한 문자열의 값이 rDTO 를 통해 전달되었음.
        String result = rDTO.getResult();   //인식된 문자열

        /*
        * 정리)
        * pDTO 는 OcrDTO 를 불러오기 위한 객체임.
        * pDTO 는 paramiter 값을 OcrDTO에 전달하기 위해 생성함
        * pDTO 는 filePath 와 fileName을 OcrDTO 에 전달하였고,
        * getReadforImageText() 객체의 파라미터 값(result 값) 을 받아
        * OcrDTO 에 전달하였음.
        *
        * rDTO 는 OcrDTO 를 불러오기 위한 또 다른 객체임.
        * OcrDTO 가 받은 result 값을 rDTO 에 전달받기 위해 생성하였으며,
        * 생성되자마자 OcrDTO로 부터 result 값을 받아
        * 해당 값을 String result 에 저장하여
        * 해당 클래스에서 사용할 수 있도록 하였음.
         */

        log.info("인식된 문자열");
        //result 값은 OcrDTO에서 받아온 rDTO의 값임.
//        log.info(rDTO.getResult());
        log.info(result);

        log.info("자바 프로그래밍 종료!");

        /*
        * 정리)
        * 이미지 혹은 문서에서 문자열을 추출할 수 있는 기능을 하는 자바용 Tess4J Tesseract
        * 해당 라이브러리를 사용하기 위해 pom에서 marven 라이브러리를 다운로드 받아 사용하였으며,
        * 이미지추출을 위한 클래스를 DTO 클래스와 Service 클래스, 메인 클래스로 나누었고
        * IService 인터페이스를 만들어 혹시나 모를 기능들을 다중상속 받을 수 있도록 하였음.
        * DTO 에는 자주 사용되는 변수들을 저장할 용도로 만들어 재사용성을 높였고
        * Service 에는 추출하는 기능을 기술하여 메인 클래스에서 코드 가독성을 높임.
        * 메인 클래스에서는 CommandLineRunner 인터페이스의 run() 를 참조 받아 실행할 환경을 만들었으며,
        * DTO 와 Service 에서 필요한 부분을 객체로 생성하여 받아와 짧은 코드로 가독성 좋게 프로그램을 실행함.
         */

    }
}
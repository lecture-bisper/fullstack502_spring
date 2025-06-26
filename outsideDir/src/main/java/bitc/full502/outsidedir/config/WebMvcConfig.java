package bitc.full502.outsidedir.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

//  @Value : application.properties 설정 파일에 존재하는 내용을 가져와서 지정한 변수에 저장하여 사용하도록 하는 어노테이션
//  application.properties 설정 파일에 외부 폴더 경로를 입력하고, config 파일에서 경로 값을 불러와서 사용
  @Value("${resources.img.location1}")
  private String dogImageLocation;

  @Value("${resources.img.location2}")
  private String animalsImageLocation;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//    addResourceHandler(경로) : 스프링 프레임워크 외부에 존재하는 폴더를 스프링 프레임워크 안에 있는 폴더인 것으로 인식 시킴, 매개변수로 스프링 프레임워크 내부에서 사용할 경로(패턴방식)를 입력
//    addResourceLocations(경로) : 실제 디스크의 폴더 경로를 입력
//    macOS, linux 는 'file://경로명', windows 는 'file:///경로명' 형태로 사용
//    외부 경로의 마지막에 '/' 반드시 입력

//    외부 경로는 여러개를 입력하여 사용할 수 있음
//    registry.addResourceHandler("/outsideimgs/**")
//        .addResourceLocations("file:///C:/fullstack502/img/");
//
//    registry.addResourceHandler("/animals/**")
//        .addResourceLocations("file:///C:/fullstack502/images/animals/");

    String path1 = "file:///" + dogImageLocation;
    String path2 = "file:///" + animalsImageLocation;

//    한번에 하나씩 외부 경로를 등록
    registry.addResourceHandler("/outsideimgs/**")
        .addResourceLocations(path1);
    registry.addResourceHandler("/animals/**")
        .addResourceLocations(path2);

//    한번에 같은 내부 폴더명으로 외부 경로 여러개를 등록하여 사용
//    registry.addResourceHandler("/animals/**")
//        .addResourceLocations(path1, path2);
  }
}















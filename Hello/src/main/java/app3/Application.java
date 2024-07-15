package app3;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication //выполняет сканирование
@RestController//1 @Controller vs @RestController
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,
                args);
    }
}


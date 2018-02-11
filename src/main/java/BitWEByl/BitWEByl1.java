package BitWEByl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BitWEByl1 {

    @RequestMapping("/hello")
    public String hei() {
        return "Hello World!";
    }
}
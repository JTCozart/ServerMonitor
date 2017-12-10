package hello;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class IndexController implements ErrorController{

    private static final String template = "ERROR:, %s!";
    private final AtomicLong counter = new AtomicLong();

 @RequestMapping("/error")
    public Index error(@RequestParam(value="error", defaultValue = "unknown") String error){
        return new Index(counter.incrementAndGet(),
                String.format(template, error));
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}


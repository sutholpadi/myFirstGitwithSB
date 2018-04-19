package hello;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/RESTfulSP")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/greeting",method=RequestMethod.POST)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name,
    		@RequestParam(value="names") ArrayList<String> names) {
    	for(String s: names) {
    		System.out.println("name "+s);
    	}
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
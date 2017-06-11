package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="Greetings",tags={"Greeting Controller"})
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    @ApiOperation(value="Greet a user", consumes="application/json", produces="application/json", response=Greeting.class)
    @ApiResponses(value={
    		@ApiResponse(code=200,message="Successful Execution"),
    		@ApiResponse(code=401,message="Unauthorized Access"),
    		@ApiResponse(code=403,message="Forbidden Access"),
    		@ApiResponse(code=404,message="Resource not found"),
    		@ApiResponse(code=500,message="Internal Server Error")
    })
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}

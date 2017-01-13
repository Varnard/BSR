package bsr.bank2;

import com.squareup.okhttp.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GreetingController {

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Response greetsasd(@RequestParam(value="name", defaultValue="World") String name) throws IOException {
        Transfer t = new Transfer(500,"123","231","xdlol");
        Response r = TransferExecutor.execute(t,"http://localhost:8080/transfer");
        System.out.println(r);
        return r;
    }

}
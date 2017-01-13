package bsr.bank2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class TransferController {


    @RequestMapping(value = "/transfer", method =POST)
    public ResponseEntity transfer(@RequestBody Transfer transfer, @RequestHeader("Authorization") String auth ) {
        ResponseEntity response;

        if (!BasicAuth.authorize(auth)){
            response = new ResponseEntity(new Error("ACCESS DENIED"), HttpStatus.UNAUTHORIZED);
        } else {

            if (transfer.getTitle()==null || transfer.getReceiver_account()==null ||
                    transfer.getSender_account()==null || transfer.getAmount()<=0){
                response = new ResponseEntity(new Error("Do you even JSON?!?"), HttpStatus.BAD_REQUEST);
            } else {
                try {
                    Database.updateSaldo(transfer.getReceiver_account(),transfer.getAmount());
                } catch (AccountNotFoundException e) {
                    response = new ResponseEntity(new Error("Odbiorca jest w innym zamku"),HttpStatus.NOT_FOUND);
                }

                //Database.updateOperation
                response  = new ResponseEntity(HttpStatus.OK);
            }

        }

        return response;
    }
}
package bsr.bank2;

import bsr.bank.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class BankEndpoint {
    private static final String NAMESPACE_URI = "http://bank.bsr";


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLoginRequest")
    @ResponsePayload
    public GetLoginResponse getLogin(@RequestPayload GetLoginRequest request) {
        GetLoginResponse response = new GetLoginResponse();
        String login = request.getAuthentication().getLogin();
        String password = request.getAuthentication().getPassword();

        response.setLoginSuccess(Database.checkLogin(login, password));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccountRequest")
    @ResponsePayload
    public GetAccountResponse getAccount(@RequestPayload GetAccountRequest request) {
        GetAccountResponse response = new GetAccountResponse();

        Account account = Database.getAccount(request.getAccount());
        response.setAccount(account);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOperationsRequest")
    @ResponsePayload
    public GetOperationsResponse getOperations(@RequestPayload GetOperationsRequest request) {
        GetOperationsResponse response = new GetOperationsResponse();

        List<Operation> operations = Database.getOperations(request.getAccount());
        response.getOperations().addAll(operations);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "depositRequest")
    @ResponsePayload
    public DepositResponse deposit(@RequestPayload DepositRequest request) {
        DepositResponse response = new DepositResponse();
        double amount = request.getAmount();
        String number = request.getAccount();

        boolean success = Database.updateSaldo(number,amount);

        if (success){
            //Database.addOperation(number)
        }

        response.setSuccess(success);

        return response;
        
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "withdrawalRequest")
    @ResponsePayload
    public WithdrawalResponse withdrawal(@RequestPayload WithdrawalRequest request) {
        WithdrawalResponse response = new WithdrawalResponse();
        double amount = request.getAmount();
        String number = request.getAccount();

        boolean success = Database.updateSaldo(number,amount);

        if (success){
            //Database.addOperation(number)
        }

        response.setSuccess(success);

        return response;

    }
}


//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.07 at 05:38:59 PM CET 
//


package bsr.bank;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the bsr.bank package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: bsr.bank
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DepositResponse }
     * 
     */
    public DepositResponse createDepositResponse() {
        return new DepositResponse();
    }

    /**
     * Create an instance of {@link WithdrawalRequest }
     * 
     */
    public WithdrawalRequest createWithdrawalRequest() {
        return new WithdrawalRequest();
    }

    /**
     * Create an instance of {@link WithdrawalResponse }
     * 
     */
    public WithdrawalResponse createWithdrawalResponse() {
        return new WithdrawalResponse();
    }

    /**
     * Create an instance of {@link DepositRequest }
     * 
     */
    public DepositRequest createDepositRequest() {
        return new DepositRequest();
    }

    /**
     * Create an instance of {@link GetLoginRequest }
     * 
     */
    public GetLoginRequest createGetLoginRequest() {
        return new GetLoginRequest();
    }

    /**
     * Create an instance of {@link Authenticator }
     * 
     */
    public Authenticator createAuthenticator() {
        return new Authenticator();
    }

    /**
     * Create an instance of {@link GetAccountRequest }
     * 
     */
    public GetAccountRequest createGetAccountRequest() {
        return new GetAccountRequest();
    }

    /**
     * Create an instance of {@link GetAccountResponse }
     * 
     */
    public GetAccountResponse createGetAccountResponse() {
        return new GetAccountResponse();
    }

    /**
     * Create an instance of {@link Account }
     * 
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link GetOperationsRequest }
     * 
     */
    public GetOperationsRequest createGetOperationsRequest() {
        return new GetOperationsRequest();
    }

    /**
     * Create an instance of {@link GetLoginResponse }
     * 
     */
    public GetLoginResponse createGetLoginResponse() {
        return new GetLoginResponse();
    }

    /**
     * Create an instance of {@link GetOperationsResponse }
     * 
     */
    public GetOperationsResponse createGetOperationsResponse() {
        return new GetOperationsResponse();
    }

    /**
     * Create an instance of {@link Operation }
     * 
     */
    public Operation createOperation() {
        return new Operation();
    }

}

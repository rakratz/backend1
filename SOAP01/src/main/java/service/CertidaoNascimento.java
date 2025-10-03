package service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

//Service Endpoint Interface(SEI)
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CertidaoNascimento {

    @WebMethod
    int calcularIdade(String idade);

    @WebMethod
    String diaSemanaNascimento(String idade);
}

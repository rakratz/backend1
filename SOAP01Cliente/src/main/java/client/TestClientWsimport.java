package client;

import client.stub.CertidaoNascimento;
import client.stub.CertidaoNascimentoImplService;
import java.net.URL;

public class TestClientWsimport {
  public static void main(String[] args) throws Exception {
    URL wsdl = new URL("http://localhost:8085/service/certidao?wsdl");
    CertidaoNascimentoImplService svc = new CertidaoNascimentoImplService(wsdl);
    CertidaoNascimento port = svc.getCertidaoNascimentoImplPort();

    System.out.println("Idade: " + port.calcularIdade("15/10/2000"));
    System.out.println("Dia da semana: " + port.diaSemanaNascimento("15/10/2000"));
  }
}

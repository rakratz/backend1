package app;

import jakarta.xml.ws.Endpoint;
import service.CertidaoNascimentoImpl;

public class App {

	public static void main(String[] args) {

    	CertidaoNascimentoImpl certidaoNascimento = new CertidaoNascimentoImpl();
        Endpoint.publish("http://localhost:8085/service/certidao", certidaoNascimento);
        System.out.println("Serviço publicado com sucesso");

	}

}

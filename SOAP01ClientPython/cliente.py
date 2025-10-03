from zeep import Client

WSDL = "http://localhost:8085/service/certidao?wsdl"
client = Client(
    wsdl=WSDL,
    service_name="CertidaoNascimentoImplService",
    port_name="CertidaoNascimentoImplPort",
)

idade = client.service.calcularIdade("15/10/2000")          # int
dia   = client.service.diaSemanaNascimento("15/10/2000")    # str

print(f"Idade: {idade}\n")
print(f"Dia da semana: {dia}")
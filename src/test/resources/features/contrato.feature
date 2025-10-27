# language: pt

Funcionalidade: Validação de Contrato da API de Dispositivos

  Cenario: Cadastrar novo dispositivo IoT com sucesso
    Dado que a API está disponível e os seguintes dados do dispositivo:
      | campo   | valor              |
      | nome    | SP-01              |
      | tipo    | Sensor de presença |
      | consumo | 0,1 KW             |
    Quando eu envio um POST para "/api/dispositivo" com os dados do dispositivo
    Então o status code deve ser 201
    E o contrato vai ser "contrato dispositivo com sucesso"
    Então o corpo da resposta deve estar de acordo com o contrato
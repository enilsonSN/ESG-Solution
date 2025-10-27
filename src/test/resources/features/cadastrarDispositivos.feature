# language: pt

Funcionalidade: : Gestão de dispositivos IoT sustentáveis
  Como administrador do sistema ESG
  Quero cadastrar os dispositivos para o monitoramento futuro

  Cenario: Cadastrar novo dispositivo IoT com sucesso
    Dado que a API está disponível e os seguintes dados do dispositivo:
      | campo   | valor              |
      | nome    | SP-01              |
      | tipo    | Sensor de presença |
      | consumo | 0,1 KW             |
    Quando eu envio um POST para "/api/dispositivo" com os dados do dispositivo
    Então o status code deve ser 201

  Cenario: Tentar cadastrar um dispositivo sem nome
    Dado que a API está disponível e os seguintes dados do dispositivo:
      | campo   | valor              |
      | nome    |                    |
      | tipo    | Sensor de presença |
      | consumo | 0,2 KW             |
    Quando eu envio um POST para "/api/dispositivo" com os dados do dispositivo
    Então o status code deve ser 400
    E a resposta de erro deve ser "Dados com campos nulos"

  Cenario: Consultar a lista de dispositivos cadastrados
    Quando eu envio um GET para "/api/dispositivo"
    Então o status code deve ser 200
    E a resposta deve conter uma lista de dispositivos
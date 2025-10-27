package steps;

import br.com.fiap.atividadeCap7.model.DispositivoIOT;
import br.com.fiap.atividadeCap7.service.DispositivoIOTService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.*;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Então;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CadastroDispositivoSteps {

    private DispositivoIOT dispositivo;
    private DispositivoIOTService service;
    private Response response;
    private Response lastResponse = given().get("algum endpoint de teste");

    @Autowired
    public CadastroDispositivoSteps() {
        this.service = new DispositivoIOTService();
    }

    @Dado("que a API está disponível e os seguintes dados do dispositivo:")
    public void queAAPIEstáDisponívelEOsSeguintesDadosDoDispositivo(DataTable dataTable) {
        Map<String, String> dados = dataTable.asMap(String.class, String.class);

        dispositivo = new DispositivoIOT();
        dispositivo.setNome(dados.get("nome"));
        dispositivo.setTipo(dados.get("tipo"));
        dispositivo.setConsumo("consumo");
    }

    @Quando("eu envio um POST para {string} com os dados do dispositivo")
    public void euEnvioUmPOSTParaComOsDadosDoDispositivo(String endpoint) {
        String baseUrl = "http://localhost:8081";
        String fullUrl = baseUrl + endpoint;
        response = RestAssured.given()
                .contentType("application/json")
                .body(dispositivo)
                .when()
                .post(fullUrl);
    }

    @Então("o status code deve ser {int}")
    public void oStatusCodeDeveSer(int statusCode) {
        assertEquals(statusCode, response.statusCode());
    }

    @E("a resposta de erro deve ser {string}")
    public void aRespostaDeErroDeveSer(String arg0) {
    }

    @E("o contrato vai ser {string}")
    public void oContratoVaiSer(String contrato) {
        this.service.selecionaContrato(contrato);
    }

    @Então("o corpo da resposta deve estar de acordo com o contrato")
    public void oCorpoDaRespostaDeveEstarDeAcordoComOContrato() {

        String schemaPath = "schemas/cadastro-dispositivo-com-sucesso.json";

        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath));

        System.out.println("O corpo da resposta validou o Schema JSON com sucesso!");
    }

    @Quando("eu envio um GET para {string}")
    public void euEnvioUmGETPara(String endpoint) {
        String baseUrl = "http://localhost:8081";
        String fullUrl = baseUrl + endpoint;
        Response currentResponse = RestAssured.given()
                .contentType("application/json")
                .when()
                .get(fullUrl);

        this.response = currentResponse;
    }

    @E("a resposta deve conter uma lista de dispositivos")
    public void aRespostaDeveConterUmaListaDeDispositivos() {
        List<?> lista = this.response.getBody().as(List.class);

        Assert.assertFalse("A lista de dispositivos retornada está vazia.", lista.isEmpty());
        System.out.println("Lista de dispositivos não vazia verificada. Tamanho: " + lista.size());
    }
}
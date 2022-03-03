package com.basis.sgcproject;

import com.basis.sgcproject.domain.*;
import com.basis.sgcproject.repository.ColaboradorRepository;
import com.basis.sgcproject.repository.CompetenciaRepository;
import com.basis.sgcproject.repository.TurmaFormacaoRepository;
import com.basis.sgcproject.service.TurmaFormacaoService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
 public class ColaboradorIT {

    @LocalServerPort
    private int port;
    @Autowired
    private TurmaFormacaoService turmaFormacaoService;
    @Autowired
    private TurmaFormacaoRepository turmaFormacaoRepository;
    @Autowired
    private CompetenciaRepository competenciaRepository;
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @BeforeAll
    public void setUp() {
        RestAssured.port = port;
        RestAssured.basePath = "/api/colaboradores";
        inserirCompetencias();
        inserirColaboradores();
    }

    @Test
    public void deveRetornarStatus200_QuandoListarColaboradores() {
        RestAssured.given()
                .accept(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void deveRetornarStatus200_QuandoBuscarColaboradorPorId() {
        RestAssured.given()
                .pathParam("id", 1)
                .accept(ContentType.JSON)
                .when()
                .get("/{id}")
                .then()
                .statusCode(200);
    }

    @Test
    public void deveRetornarStatus201_QuandoCriarNovoColaborador() {
        RestAssured.given()
                .body("{\n" +
                        "    \"nome\": \"Marllon\",\n" +
                        "    \"sobrenome\": \"Zucolotto\",\n" +
                        "    \"cpf\": \"85968574589\",\n" +
                        "    \"email\": \"marlonzucolotto@gmail.cm\",\n" +
                        "    \"senioridadeID\": \"1\",\n" +
                        "    \"dataNascimento\": \"2022-03-15T00:00:00\",\n" +
                        "    \"dataAdmissao\": \"2022-04-20T00:00:00\",\n" +
                        "    \"competenciasColaboradores\": [\n" +
                        "        {\n" +
                        "            \"competenciaId\": 1,\n" +
                        "            \"colaboradorId\": 1\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"competenciaId\": 2,\n" +
                        "            \"colaboradorId\": 2\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post()
                .then()
                .statusCode(201);
    }

    @Test
    public void deveRetornarStatus200_QuandoAtualizarColaborador() {
        RestAssured.given()
                .pathParam("turmaId", 1)
                .body("{\n" +
                        "    \"nome\": \"Turma 10\",\n" +
                        "    \"descricao\": \"Sera ensinado Angular avançado\",\n" +
                        "    \"dataInicio\": \"2022-03-10T00:00:00\",\n" +
                        "    \"dataTermino\": \"2022-05-20T00:00:00\",\n" +
                        "    \"statusId\": 1,\n" +
                        "    \"competenciasColaboradores\": [\n" +
                        "        {\n" +
                        "            \"competenciaId\": 1,\n" +
                        "            \"colaboradorId\": 3\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"competenciaId\": 2,\n" +
                        "            \"colaboradorId\": 2\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .put("/{turmaId}")
                .then()
                .statusCode(200);
    }

    @Test
    public void deverRetornarStatus204_QuandoExcluirColaborador() {
        RestAssured.given()
                .pathParam("turmaId", 1)
                .when()
                .delete("/{turmaId}")
                .then()
                .statusCode(204);
    }

    @Test
    public void deveFalharAoSalvarColaborador_SemNome() {
        RestAssured.given()
                .body("{\n" +
                        "    \"nome\": \"\",\n" +
                        "    \"descricao\": \"Sera ensinado Angular\",\n" +
                        "    \"dataInicio\": \"2022-03-15T00:00:00\",\n" +
                        "    \"dataTermino\": \"2022-04-20T00:00:00\",\n" +
                        "    \"statusId\": 1,\n" +
                        "    \"competenciasColaboradores\": [\n" +
                        "        {\n" +
                        "            \"competenciaId\": 1,\n" +
                        "            \"colaboradorId\": 1\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"competenciaId\": 2,\n" +
                        "            \"colaboradorId\": 2\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());

    }



    //  Preparacao ambiente de testes
    private void inserirCompetencias() {
        Categoria categoria = new Categoria();

        Competencia competencia1 = new Competencia();
        competencia1.setNome("Spring");
        competencia1.setDescricao("Framework para desenvolvimento Java");
        categoria.setId(1);
        competencia1.setCategoria(categoria);
        competenciaRepository.save(competencia1);

        Competencia competencia2 = new Competencia();
        competencia2.setNome("Angular");
        competencia2.setDescricao("Framework para desenvolvimento frontend");
        categoria.setId(2);
        competencia2.setCategoria(categoria);
        competenciaRepository.save(competencia2);

        Competencia competencia3 = new Competencia();
        competencia3.setNome("Git");
        competencia3.setDescricao("Versionamento de codigo");
        categoria.setId(3);
        competencia3.setCategoria(categoria);
        competenciaRepository.save(competencia3);
    }

    private void inserirColaboradores() {
        Senioridade senioridade = new Senioridade();

        Colaborador colaborador1 = new Colaborador();
        colaborador1.setNome("Joao");
        colaborador1.setSobrenome("Silva");
        colaborador1.setCpf("12345678911");
        colaborador1.setEmail("joao@gmail.com");
        colaborador1.setDataNascimento(LocalDateTime.parse("2005-06-05T00:00:00"));
        colaborador1.setDataAdmissao(LocalDateTime.parse("2022-05-20T00:00:00"));
        senioridade.setId(1);
        colaborador1.setSenioridade(senioridade);
        colaboradorRepository.save(colaborador1);

        Colaborador colaborador2 = new Colaborador();
        colaborador2.setNome("Maria");
        colaborador2.setSobrenome("Souza");
        colaborador2.setCpf("78945612311");
        colaborador2.setEmail("maria@gmail.com");
        colaborador2.setDataNascimento(LocalDateTime.parse("2001-04-05T00:00:00"));
        colaborador2.setDataAdmissao(LocalDateTime.parse("2022-04-20T00:00:00"));
        senioridade.setId(2);
        colaborador2.setSenioridade(senioridade);
        colaboradorRepository.save(colaborador2);

        Colaborador colaborador3 = new Colaborador();
        colaborador3.setNome("Pedro");
        colaborador3.setSobrenome("Martins");
        colaborador3.setCpf("45612378911");
        colaborador3.setEmail("pedro@gmail.com");
        colaborador3.setDataNascimento(LocalDateTime.parse("2003-01-07T00:00:00"));
        colaborador3.setDataAdmissao(LocalDateTime.parse("2022-06-02T00:00:00"));
        senioridade.setId(3);
        colaborador3.setSenioridade(senioridade);
        colaboradorRepository.save(colaborador3);
    }
}

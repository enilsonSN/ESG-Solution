package br.com.fiap.atividadeCap10.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_dispositivo_IOT")
public class DispositivoIOT {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "DISPOSITIVO_IOT_SEQ"
    )
    @SequenceGenerator(
            name = "DISPOSITIVO_IOT_SEQ",
            sequenceName = "DISPOSITIVO_IOT_SEQ",
            allocationSize = 1
    )

    private Long id;
    private String nome;
    public String modelo;
    public String fabricante;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }


}

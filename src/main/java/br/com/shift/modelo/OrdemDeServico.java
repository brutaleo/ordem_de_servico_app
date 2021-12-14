package br.com.shift.modelo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class OrdemDeServico extends PanacheEntity {

    @CreationTimestamp
    private LocalDate dataCadastro;

    @UpdateTimestamp
    private LocalDate dataAtualizacao;

    private String convenio;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "posto_coleta_id")
    private PostoColeta postoColeta;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

}

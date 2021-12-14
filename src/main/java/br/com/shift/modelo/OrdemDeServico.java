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
    public LocalDate dataCadastro;

    @UpdateTimestamp
    public LocalDate dataAtualizacao;

    public String convenio;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    public Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "posto_coleta_id")
    public PostoColeta postoColeta;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    public Medico medico;

}

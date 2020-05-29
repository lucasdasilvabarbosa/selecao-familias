package br.selecao.familias.resources.dto;

import java.util.Calendar;
import java.util.Date;

public class PessoaDTO {
    private String id;
    private String nome;
    private String tipo;
    private Date dataDeNascimento;

    public PessoaDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public int getIdade() {
        if (this.dataDeNascimento != null) {
            Calendar dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(this.dataDeNascimento);
            Calendar hoje = Calendar.getInstance();

            int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);

            if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
                idade--;
            } else {
                if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
                    idade--;
                }
            }
            return idade;
        } else {
            return 0;
        }
    }
}

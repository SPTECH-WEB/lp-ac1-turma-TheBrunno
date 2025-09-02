package school.sptech;

public class Turma {
    private String nome;
    private Double mensalidade;
    private Integer qtdAluno;
    private Boolean ativa;

    public Turma(String nome, Double mensalidade){
        this.nome = nome;
        this.mensalidade = mensalidade;
        this.qtdAluno = 0;
        this.ativa = true;
    }

    public void matricular(Integer qtd){
        if(qtd != null && qtd > 0 && ativa){
            qtdAluno += qtd;
        }
    }

    public Integer cancelar(Integer qtd){
        if(qtd != null && qtd > 0 && ativa && qtdAluno >= qtd) {
            qtdAluno -= qtd;
            return qtd;
        }
        return null;
    }

    public Integer desativar(){
        if(ativa){
            this.ativa = false;
            Integer qtdAlunosAnterior = this.qtdAluno;
            this.qtdAluno = 0;

            return qtdAlunosAnterior;
        }
        return null;
    }

    public void transferir(Turma destino, Integer qtdATransferir){
        if(destino != null
        && qtdATransferir != null
        && destino.ativa
        && this.ativa
        && this.qtdAluno >= qtdATransferir
        && qtdATransferir > 0){
            destino.qtdAluno += qtdATransferir;
            this.qtdAluno -= qtdATransferir;
        }
    }

    public Boolean reajustarMensalidade(Double reajuste){
        if(reajuste != null && reajuste > 0){
            mensalidade += mensalidade * reajuste;
            return true;
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getMensalidade() {
        return mensalidade;
    }

    public Integer getQtdAluno() {
        return qtdAluno;
    }

    public Boolean getAtiva() {
        return ativa;
    }
}

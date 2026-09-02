package school.sptech.api.model;

public class Cliente {

    private Integer id;
    private String nome;
    private Double peso;
    private String objetivo;
    private Integer frequenciaMusculacao;
    private Integer percentualGordura;
    private Integer proteinaDiaria;

    public Cliente() {
    }

    public Cliente(Integer id, String nome, Double peso, String objetivo, Integer frequenciaMusculacao, Integer percentualGordura, Integer proteinaDiaria) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.objetivo = objetivo;
        this.frequenciaMusculacao = frequenciaMusculacao;
        this.percentualGordura = percentualGordura;
        this.proteinaDiaria = proteinaDiaria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Integer getFrequenciaMusculacao() {
        return frequenciaMusculacao;
    }

    public void setFrequenciaMusculacao(Integer frequenciaMusculacao) {
        this.frequenciaMusculacao = frequenciaMusculacao;
    }

    public Integer getPercentualGordura() {
        return percentualGordura;
    }

    public void setPercentualGordura(Integer percentualGordura) {
        this.percentualGordura = percentualGordura;
    }

    public Integer getProteinaDiaria() {
        return proteinaDiaria;
    }

    public void setProteinaDiaria(Integer proteinaDiaria) {
        this.proteinaDiaria = proteinaDiaria;
    }
}

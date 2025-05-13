/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etapa3.beans;

/**
 *
 * @author HEARTHLONELY
 */
public class Produto {
    private int id;
    private String nome;
    private Fornecedor fornecedor;
    private int volumetria;
    private String origem;
    private double valorUnitario;
    private String informacoesAdicionais;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getVolumetria() {
        return volumetria;
    }

    public void setVolumetria(int volumetria) {
        this.volumetria = volumetria;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
    
    public double getValorUnitario(){
        return valorUnitario;
    }
    
    public void setValorUnitario(double valorUnitario){
        this.valorUnitario = valorUnitario;
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }
      @Override
      public String toString()
                {
      return this.nome;
                }   
}

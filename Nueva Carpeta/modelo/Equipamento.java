/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import armazenamento.Meio_Armazenamento;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Edgar
 */
public class Equipamento {
    private String nome, patrimonio;
    private Date dataAquisicao, dataTerminoGarantia;
    private float valor;
    private ArrayList<Manutencao> listaManutencoes;
    
    public Equipamento(){
        this.listaManutencoes = new ArrayList();
    }
    
    
    public static Equipamento obterPeloNumero(String numeroPatrimonio){
        for( Equipamento objDaVez : Equipamento.obterLista() ){
            if( objDaVez.getPatrimonio().equals(numeroPatrimonio) ){
                return objDaVez;
            }
        }
        return null;
    }
    
    public static ArrayList<Equipamento> obterLista(){
        return Meio_Armazenamento.MEIO_ARMAZENAMENTO_EQUIPAMENTOS;
    }
    
    public void salvar(){
        Meio_Armazenamento.MEIO_ARMAZENAMENTO_EQUIPAMENTOS.add(this);
    }
    
    public ArrayList<Manutencao> getListManutencoes(){
        return this.listaManutencoes;
    }
    
    public void adicionaManutencao(Manutencao manutencao){
        this.listaManutencoes.add(manutencao);
    }
    
    public float getTotalGastoManutencoes(){
        float total = 0;
        
        for(Manutencao atual : this.listaManutencoes){
            total += atual.getValor();
        }
        
        return total;
    }
    
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the patrimonio
     */
    public String getPatrimonio() {
        return patrimonio;
    }

    /**
     * @param patrimonio the patrimonio to set
     */
    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    /**
     * @return the dataAquisicao
     */
    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    /**
     * @param dataAquisicao the dataAquisicao to set
     */
    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    /**
     * @return the dataTerminoGarantia
     */
    public Date getDataTerminoGarantia() {
        return dataTerminoGarantia;
    }

    /**
     * @param dataTerminoGarantia the dataTerminoGarantia to set
     */
    public void setDataTerminoGarantia(Date dataTerminoGarantia) {
        this.dataTerminoGarantia = dataTerminoGarantia;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import java.util.Date;
import modelo.Equipamento;
import modelo.EquipamentoDao;

/**
 *
 * @author Edgar
 */
public class Equipamento_Controle {
    
    public static void receberDadosCadastroEquipamento( String nome, String patrimonio, Date dataAquisicao, Date dataTerminoGarantia, float valor){
        Equipamento objetoEquipamento = new Equipamento();
        objetoEquipamento.setNome(nome);
        objetoEquipamento.setPatrimonio(patrimonio);
        objetoEquipamento.setDataAquisicao(dataAquisicao);
        objetoEquipamento.setDataTerminoGarantia(dataTerminoGarantia);
        objetoEquipamento.setValor(valor);
        EquipamentoDao.salvar(objetoEquipamento);
    }
    
    public static ArrayList<Equipamento> obterListaEquipamento(){
        return EquipamentoDao.obterLista();
    }
    
    public static Equipamento obterEquipamentoPeloNumeroPatrimonio(String numeroPatrimonio){
        return EquipamentoDao.obterPeloNumero(numeroPatrimonio);
    }
    
}

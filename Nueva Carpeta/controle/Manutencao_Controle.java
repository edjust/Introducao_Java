/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.Date;
import modelo.Equipamento;
import modelo.EquipamentoDao;
import modelo.Manutencao;

/**
 *
 * @author Edgar
 */
public class Manutencao_Controle {
    public static void receberDadosNovaManutencao(String numeroPatrimonio, String descricao, Date data, float valor){
        Equipamento encontrado = EquipamentoDao.obterPeloNumero(numeroPatrimonio);
        Manutencao novaManutencao = new Manutencao();
        novaManutencao.setData(data);
        novaManutencao.setDescricao(descricao);
        novaManutencao.setValor(valor);
        
        encontrado.adicionaManutencao(novaManutencao);
    }
}

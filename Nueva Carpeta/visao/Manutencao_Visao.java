/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.Manutencao_Controle;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Edgar
 */
public class Manutencao_Visao {
    public static void exibirFormularioManutencao(String numeroPatrimonio){
        Scanner entrada = new Scanner(System.in);
        String descricao;
        Date data;
        float valor;
        System.out.println("-----TELA DE CADASTRO DE MANUTENÇÃO-----");
        System.out.println("Informe a manutenção feita no equipamento: ");
        descricao = entrada.nextLine();
        System.out.println("Informe a data da manutenção: ");
        SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
        formatadorData.setLenient(false);
        do{
            try{
                data = formatadorData.parse(entrada.nextLine());
                break;
            }catch(Exception  e){
                System.out.println("Data inválida!!! Digite novamente!");
            }
        }while(true);
        
        System.out.println("Informe o valor da manutenção: ");
        do{
            try{
                valor = Float.parseFloat(entrada.nextLine());
                break;
            }catch(Exception e){
                System.out.println("Valor inválido!!! Digite novamente!");
            }
            
        }while(true);
        
        Manutencao_Controle.receberDadosNovaManutencao(numeroPatrimonio, descricao, data, valor);
    }
}

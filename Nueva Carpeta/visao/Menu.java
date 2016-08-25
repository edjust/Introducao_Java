/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.util.Scanner;

/**
 *
 * @author Edgar
 */
public class Menu {
    public static void exibirMenu(){
        System.out.println("-----MENU PRINCIPAL-----");
        System.out.println("Seleciona a opção: ");
        System.out.println("1- Cadastro equipamento");
        System.out.println("2- Listagem de equipamentos");
        System.out.println("\nO que você deseja fazer?");
        
        Scanner entrada = new Scanner(System.in);
        int op = 0;
        do{    
            try{
                op = Integer.parseInt(entrada.nextLine());
                System.out.println("O usuario digitou "+op);
                break;

            }catch(Exception e){
                System.out.println("Nao deu certo, informe novamente.");
            }
            
        }while(op != 1 && op != 2);
        if( op == 1 ){
            Equipamento_Visao.exibirFormularioCadastroEquipamento();
        }
    }
}

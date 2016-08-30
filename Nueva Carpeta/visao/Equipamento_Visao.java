/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import armazenamento.Meio_Armazenamento;
import controle.Equipamento_Controle;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import modelo.Equipamento;

/**
 *
 * @author Edgar
 */
public class Equipamento_Visao {
    
    public static void exibirFormularioCadastroEquipamento(){
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("-----TELA DE CADASTRO DE EQUIPAMENTO-----");
        System.out.println("Numero de equipamentos: "+Meio_Armazenamento.MEIO_ARMAZENAMENTO_EQUIPAMENTOS.size());
        
        String nome, patrimonio;
        Date dataAquisicao, dataTerminoGarantia;
        float valor;
        
        System.out.println("\nInforme o nome: ");
        nome = entrada.nextLine();
        
        System.out.println("\nInforme o numero do predominio: ");
        patrimonio = entrada.nextLine();
        
        System.out.println("\nInforme a data de aquisição: ");
        SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
        formatadorData.setLenient(false);
        do{
            try{
                dataAquisicao = formatadorData.parse(entrada.nextLine());
                System.out.println("Data lida: "+dataAquisicao);
                break;
                
            }catch(Exception e){
                System.out.println("Data Invalida, digite novamente.");
            }
            
        }while(true);
        
        System.out.println("\nInforme a data de termino de garantia: ");
        do{
            try{
                dataTerminoGarantia = formatadorData.parse(entrada.nextLine());
                if( dataTerminoGarantia.after(dataAquisicao) ){
                    break;
                    
                }else System.out.println("Data lida: "+dataTerminoGarantia+". Data de termino de garantia deve ser depois da data de aquisição.");
                
            }catch(Exception e){
                System.out.println("Data Invalida, digite novamente.");
            }
            
        }while(true);
        
        System.out.println("\nInforme o valor: ");
        do{
            try{
                valor = Float.parseFloat(entrada.nextLine());
                System.out.println("Valor lido: "+valor+"\n");
                break;
                
            }catch(Exception e){
                System.out.println("Valor Invalido, digite novamente.");
            }
            
        }while(true);
        
        Equipamento_Controle.receberDadosCadastroEquipamento(nome, patrimonio, dataAquisicao, dataTerminoGarantia, valor);
        Menu.exibirMenu();
        
    }
    
    public static void exibirListagemEquipamentos(){
        System.out.println("-----TELA LISTAGEM DE EQUIPAMENTOS-----");
        System.out.println("Equipamento \t Data aquisição \t Nº Manutenções\n");
        
//        ArrayList<Equipamento> lista = Equipamento_Controle.obterListaEquipamento();
//       for( int i = 0; i < lista.size(); i++ ){
//            System.out.println(lista.get(i).getNome()+" \t "+lista.get(i).getDataAquisicao());
//        }
        
        for(Equipamento obj : Equipamento_Controle.obterListaEquipamento()){
            System.out.println(obj.getNome()+" \t "+obj.getDataAquisicao()+" \t "+obj.getListManutencoes().size());
        }
        
        System.out.println("O que você deseja fazer ?");
        System.out.println("\n0 - Voltar ao menu");
        System.out.println("(Nº de patrimonio) - Cadastrar manutenção para o equipamento\n");
        
        Scanner entrada = new Scanner(System.in);
        String valorDigitado = entrada.nextLine();
        if( entrada.equals("0") ){
            Menu.exibirMenu();
        
        }else{
            Equipamento encontrado = Equipamento_Controle.obterEquipamentoPeloNumeroPatrimonio(valorDigitado);
            if( encontrado == null ){
                System.out.println("ERRO: Não encontrado");
                Menu.exibirMenu();
            
            }else{
                
            }
        }
    }
}

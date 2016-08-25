/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Edgar
 */
public class Equipamento_Visao {
    
    public static void exibirFormularioCadastroEquipamento(){
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("-----TELA DE CADASTRO DE EQUIPAMENTO-----");
        
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
                System.out.println("Valor lido: "+valor);
                break;
                
            }catch(Exception e){
                System.out.println("Valor Invalido, digite novamente.");
            }
            
        }while(true);
    }
}

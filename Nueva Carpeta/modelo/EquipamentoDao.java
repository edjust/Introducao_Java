/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author Edgar
 */
public class EquipamentoDao {
    
    public static Equipamento obterPeloNumero(String numeroPatrimonio){
        for( Equipamento objDaVez : EquipamentoDao.obterLista() ){
            if( objDaVez.getPatrimonio().equals(numeroPatrimonio) ){
                return objDaVez;
            }
        }
        return null;
    }
    
    public static ArrayList<Equipamento> obterLista(){
        ArrayList<Equipamento> retorno = new ArrayList<>();
        try{
            Path caminhoArquivo = Paths.get("dados.txt");
            for( String linha : Files.readAllLines(caminhoArquivo) ){
                String[] parts = linha.split(";");
                Equipamento objetoDaVez = new Equipamento();
                objetoDaVez.setNome(parts[0]);
                objetoDaVez.setPatrimonio(parts[1]);
                
                SimpleDateFormat formatadorData = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
                
                objetoDaVez.setDataAquisicao(formatadorData.parse(parts[2]));
                objetoDaVez.setDataTerminoGarantia(formatadorData.parse(parts[3]));
                objetoDaVez.setValor(Float.parseFloat(parts[4]));
                retorno.add(objetoDaVez);
            }
            
        }catch(Exception e){}
        
        return retorno;
        //return Meio_Armazenamento.MEIO_ARMAZENAMENTO_EQUIPAMENTOS;
    }
    
    public static void salvar(Equipamento paraSalvar){
        try{
            Path caminhoArquivo = Paths.get("dados.txt");
            String separador = System.lineSeparator();
            //ou
            //String separador = System.getProperty("line.separator");
            String dadosEquipamento = paraSalvar.getNome()+";"+paraSalvar.getPatrimonio()+";"+paraSalvar.getDataAquisicao().toString()+";"+paraSalvar.getDataTerminoGarantia().toString()+";"+paraSalvar.getValor()+separador;
            Files.write(caminhoArquivo, dadosEquipamento.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            //Meio_Armazenamento.MEIO_ARMAZENAMENTO_EQUIPAMENTOS.add(this);
    
        }catch(Exception e){}
    }
}

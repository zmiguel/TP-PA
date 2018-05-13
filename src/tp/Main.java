/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp;


import Estados.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ricardo Marques
 */
public class Main {
    Mundo m;
    boolean sair;
    private Scanner sc;
    
    public Main(){
        m = new Mundo();
        sair = false;
        sc = new Scanner(System.in);
    }
    
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
    
    private void run(){
        while(!sair){
            IEstados estado = m.getEstado();
            
            if(estado instanceof EsperaInicio){
                jogoNovo();
            }else if(estado instanceof EsperaCarta){
                cartaVirada();      
            }else if(estado instanceof AguardaAcao){
                processaAcoes();
            }else if(estado instanceof FinalDoDia){
                fimDoDia();
            }else if(estado instanceof JogoTerminado){
                fimDoJogo();
                sair = true;
            }
        } 
    }
    
    public void jogoNovo(){
        showMenu();
        
        if(sc.hasNextInt()){
            int n = sc.nextInt();
            sc.nextLine();
            
            switch(n){
                case 1: m.jogo();
                    break;
                case 2: continuar();
                    break;
                case 3: System.exit(0);    
                    return;
            }
        }else{
            sc.next();
        }
    }
    
    public void cartaVirada(){
        m.verificaTunel();
        m.viraCarta();     
    }
    
    public void processaAcoes(){
        m.acoes();
    }
    
    public void fimDoDia(){
        
        boolean valido = false;
        int resposta = 0;
        String nomeDoFicheiro;
        
            do{
                System.out.println("[1] Continuar para o novo dia\n[2] Sair e Guardar");
                System.out.print("> ");
                if(sc.hasNextInt()){
                    resposta = sc.nextInt();
                    sc.nextLine(); //  Para limpar o buffer do resto da linha
                    if(resposta == 1 || resposta == 2){
                        valido = true;
                    }
                }else{
                    sc.next();
                }
        } while(!valido);
        
            if(resposta == 1){
                m.fimDoDia();
            }else if(resposta == 2){
                System.out.print("Escolha o nome para o ficheiro de backup: ");
                nomeDoFicheiro = sc.next();
                guardarJogo(nomeDoFicheiro);
            }
    }
    
    public void fimDoJogo(){
        System.out.println("O JOGO TERMINOU!");
    }

    private void guardarJogo(String nomeDoFicheiro) { 
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(nomeDoFicheiro));
            os.writeObject(m);
            os.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Erro");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Jogo guardado no ficheiro " + nomeDoFicheiro + ". Esperamos voltar a vê-lo em breve!");
        System.exit(0);
    }
    
    private void continuar(){
        String nomeDoFicheiro;
        System.out.print("Insira o nome do ficheiro de recuperação: ");
        nomeDoFicheiro = sc.next();
        boolean valido = false;
        
        while(!valido){
            try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(nomeDoFicheiro));
            m = (Mundo)is.readObject();
            valido = true;
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a abrir ficheiro de recuperação...");
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Erro a abrir ficheiro de recuperação...");
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
                System.out.println("Erro a recuperar dados do jogo...");
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
            run();     
        }   
    }

    public void showMenu(){
        System.out.println("9 CARD SIEGE!!!");
        System.out.println("[1] - Novo Jogo");
        System.out.println("[2] - Continuar Save");
        System.out.println("[3] - Sair");
        System.out.println("> ");
    }
    
    private static int getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}

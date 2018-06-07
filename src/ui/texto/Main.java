/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.texto;


import Estados.*;
import Logica.Mundo;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ricardo Marques
 */
public class Main implements Serializable {
    Mundo m;
    boolean sair;
    private Scanner sc;

    public Main() {
        m = new Mundo();
        sair = false;
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        while (!sair) {
            IEstados estado = m.getEstado();

            if (estado instanceof EsperaInicio) {
                jogoNovo();
            } else if (estado instanceof EsperaCarta) {
                cartaVirada();
            } else if (estado instanceof AguardaAcao) {
                processaAcoes();
            } else if (estado instanceof FinalDoDia) {
                fimDoDia();
            } else if (estado instanceof JogoTerminado) {
                fimDoJogo();
                sair = true;
            }
        }
    }

    public void jogoNovo() {
        showMenu();

        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            sc.nextLine();

            switch (n) {
                case 1:
                    m.jogo();
                    break;
                case 2:
                    continuar();
                    break;
                case 3:
                    System.exit(0);
                    return;
            }
        } else {
            sc.next();
        }
    }

    public void cartaVirada() {
        m.viraCarta();
    }

    public void processaAcoes() {
        Scanner scan = new Scanner(System.in);
        int choice = 0, choice2 = 0;
        char c3 = 'n';
        boolean verificaAcao = false;
        boolean verificaAlvo = false;

        if(m.isClose()){
            System.out.println("\nTens dois inimigos no close combat, és obrigado a lutar!!");
        }

        m.showStatus();
        System.out.println("\nAÇÕES POR REALIZAR: " + (m.getAccoes()));
        System.out.println("[1] - Archers Attack");
        System.out.println("[2] - Boiling Water Attack");
        System.out.println("[3] - Close Combat Attack");
        System.out.println("[4] - Coupure");
        System.out.println("[5] - Rally Troops");
        System.out.println("[6] - Tunnel Movement");
        System.out.println("[7] - Supply Raid");
        System.out.println("[8] - Sabotage");
        System.out.println("[9] - Passo (nao fazer nada)");
        System.out.print("> ");

        while (!verificaAcao) {
            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                scan.nextLine();//limpa cenas
                verificaAcao = m.verificaAcao(choice);

                if(m.isClose()){
                    if(choice == 3){
                        verificaAcao = true;
                        while (!verificaAlvo) {
                            System.out.println("Fight! What target?\n");
                            System.out.println("[1] - Ladders\n");
                            System.out.println("[2] - Battering Ram\n");
                            System.out.println("[3] - Siege Tower\n");
                            System.out.println("> ");
                            if (scan.hasNextInt()) {
                                choice2 = scan.nextInt();
                                scan.nextLine();
                                verificaAlvo = m.verificaAlvo(choice, choice2);
                            }
                        }
                    }else{
                        verificaAcao = false;
                    }
                }else{
                    if (verificaAcao && (choice == 1 || choice == 2 || choice == 3)) {
                        while (!verificaAlvo) {
                            System.out.println("What target?\n");
                            System.out.println("[1] - Ladders\n");
                            System.out.println("[2] - Battering Ram\n");
                            System.out.println("[3] - Siege Tower\n");
                            System.out.println("> ");
                            if (scan.hasNextInt()) {
                                choice2 = scan.nextInt();
                                scan.nextLine();
                                verificaAlvo = m.verificaAlvo(choice, choice2);
                            }
                        }
                    }
                    if(verificaAcao && choice == 5){
                        System.out.println("Spend 1 Supply for +1 DRM?? (you have " + m.getSupplies() + " supplies) [N/y]");
                        c3 = scan.next().charAt(0);
                        if(c3 == 'Y' || c3 == 'y'){
                            choice2 = 1;
                        }else{
                            choice2 = 0;
                        }
                    }
                }
            }
        }
        m.acoes(choice, choice2);
    }
    
    public void fimDoDia(){
        if(!m.ultimoDia()){
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
        }else{
            m.fimDoDia();
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
            //Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Erro a abrir ficheiro de recuperação...");
            //Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
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
        System.out.print("> ");
    }

}

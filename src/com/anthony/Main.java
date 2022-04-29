package com.anthony;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class Main {

    interface motor {
        void incrementTurno();
        int getTurno();
        int lanzarDados();
        boolean isEjecutado();
        void detenerEjecucion();
        int getConfirm();
        void setConfirm(int a);
    }

    interface jugadores {
        int getPuntaje();
        void setPuntaje(int a);
        void setNombre(String name);
        String getNombre();
    }


    public static class MotorJuego implements motor {
        protected int turno = 1;
        protected boolean ejecutado = true;
        protected int confirm = 0;
        Random ranNum = new Random();
        public void incrementTurno() {
            turno = turno + 1;
        }
        public int getTurno(){
            return turno;
        }
        public int lanzarDados(){
                return ranNum.nextInt(6) + 1;
        }
        public boolean isEjecutado(){
            return ejecutado;
        }

        public void detenerEjecucion(){
            ejecutado = false;
        }


        public int getConfirm() {
            return confirm;
        }

        public void setConfirm(int a){
            confirm = a;
        }
    }

    public static class Jugador implements jugadores {
        protected int puntaje = 0;
        protected String nombreJugador = "";
        public int getPuntaje() {
            return puntaje;
        }
        public void setPuntaje(int a) {
            puntaje =  puntaje + a;
        }
        public void setNombre(String name) { nombreJugador = name;}
        public String getNombre(){return nombreJugador;}
    }

    public static void main(String[] args) {
        MotorJuego juego = new MotorJuego();
        Jugador player1 = new Jugador();
        Jugador player2 = new Jugador();
        Scanner sc = new Scanner(System.in);
        int buffer;

        System.out.println("---- Juegos de azar ----");
        while(!(player1.nombreJugador.length() > 0)){
            System.out.println("Ingrese el nombre del jugador 1: ");
            player1.setNombre(sc.nextLine());
        }
        System.out.println("---------------------------------------------------------------");
        while(!(player2.nombreJugador.length() > 0)){
            System.out.println("Ingrese el nombre del jugador 2: ");
            player2.setNombre(sc.nextLine());
        }
        System.out.println("---------------------------------------------------------------");
        while(juego.isEjecutado()){
            System.out.println("turno # " + juego.getTurno());
            System.out.println("---------------------------------------------------------------");
            juego.incrementTurno();

            if(juego.getTurno() % 2 == 0 && juego.getTurno() != 1){
                buffer = juego.lanzarDados();
                player1.setPuntaje(buffer);
                System.out.println("Jugando dados.... ");
                System.out.println("salio: " + buffer);
            }else{
                buffer = juego.lanzarDados();
                player2.setPuntaje(buffer);
                System.out.println("Jugando dados.... ");
                System.out.println("salio: " + buffer);
            }
            System.out.println("---------------------------------------------------------------");
            System.out.println("Puntaje de Jugador 1: "+ player1.getNombre() + " | " + player1.getPuntaje());
            System.out.println("Puntaje de Jugador 2: "+ player2.getNombre() + " | " + player2.getPuntaje());
            System.out.println("---------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------");
            System.out.println("Desea seguir jugado? 1 para continuar, 2 para detenerse");
            System.out.println("---------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------");
            juego.setConfirm(sc.nextInt());

            if(juego.getConfirm() == 2){
                juego.detenerEjecucion();
            }
        }

        if(player1.getPuntaje() == player2.getPuntaje()){
            System.out.println("Es un empate.");
        }else if (player1.getPuntaje() > player2.getPuntaje()){
            System.out.println("El ganador es: " + player1.getNombre());
        }else{
            System.out.println("El ganador es: " + player2.getNombre());
        }

        System.out.println("---- Muchas gracias ----");

    }
}

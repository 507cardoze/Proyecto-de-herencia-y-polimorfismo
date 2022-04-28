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
    }


    public static class MotorJuego implements motor {
        protected int turno = 0;
        protected boolean ejecutado = true;
        protected int confirm = 0;
        Random ranNum = new Random();
        public void incrementTurno() {
            turno = turno++;
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
            puntaje = a;
        }
        public void setNombre(String name) { nombreJugador = name;}
    }

    public static void main(String[] args) throws IOException {
        MotorJuego juego = new MotorJuego();
        Jugador player1 = new Jugador();
        Jugador player2 = new Jugador();
        Scanner sc = new Scanner(System.in);
        int confirm = 0;

        System.out.println("---- Juegos de azar ----");
        while(!(player1.nombreJugador.length() > 0)){
            System.out.println("Ingrese el nombre del jugador 1: ");
            player1.setNombre(sc.nextLine());
        }

        while(!(player2.nombreJugador.length() > 0)){
            System.out.println("Ingrese el nombre del jugador 2: ");
            player2.setNombre(sc.nextLine());
        }

        while(juego.isEjecutado() == true){
            System.out.println("turno # " + juego.getTurno());
            switch(juego.getTurno() % 2){

                case 0: {

                }

                default: break;
            }

            if(juego.getTurno() % 2 == 0){

                System.out.println("Desea seguir jugado? 1 para continuar, 2 para detenerse");
                confirm = sc.nextInt();

                if(confirm == 2){
                    juego.detenerEjecucion();
                }
            }else{
                juego.incrementTurno();
            }
        }

        System.out.println("---- Muchas gracias ----");

    }
}

package br.com.crescer.aula1;

import br.com.crescer.aula1.CalendarUtils.DiaSemana;
import java.util.Date;

public class Testes {
   public static void main(String[] args) {
        String testeString = "Bruno Aguiar", inverter;
        boolean test;
        int numero;
        StringManipulation sm = new StringManipulation();
        MeuCalendario mc = new MeuCalendario();
        
        //Primeiro método
        test = sm.isEmpty(testeString);
        System.out.println(test);
        test = sm.isEmpty("  ");
        System.out.println(test);
        
        // Segundo método
        inverter = sm.inverter(testeString);
        System.out.println(inverter);   
        inverter = sm.inverter("   ");
        System.out.println(inverter);
        
        // Terceiro Método
        numero = sm.contaVogais(testeString);
        System.out.println(numero);
        numero = sm.contaVogais("casáá");
        System.out.println(numero);
        
        // Quarto Método
        
        test = sm.isPalindromo(testeString);
        System.out.println(test);
        
        test = sm.isPalindromo("ovo");
        System.out.println(test);
        
        //Exercício 2
        //A
        DiaSemana dia = mc.diaSemana(new Date());
        System.out.println(dia);
        
        //B
        String diferenca = mc.tempoDecorrido(new Date(96,00,01));
        System.out.println(diferenca);
    }
}
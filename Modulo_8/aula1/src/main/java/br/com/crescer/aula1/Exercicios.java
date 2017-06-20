package br.com.crescer.aula1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Exercicios {
    public static void main(String[] args){
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println("Informe uma data no formato 'dd/MM/yyy'!");
            String data = scanner.nextLine();
            
            System.out.println("Informe os dias!");
            int numero = scanner.nextInt();
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(data));
            calendar.add(Calendar.DAY_OF_YEAR, numero);

            System.out.println("A data é " + data);
        } catch (Exception e) {
            //...
        }
    }
}

package br.com.crescer.aula1;

import java.text.Normalizer;

public class StringManipulation implements StringUtils{
    
    public boolean isEmpty(String string) {
         return string == null || string.trim().isEmpty();
    }

    public String inverter(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public int contaVogais(String string) {
        int numeroDeVogais=0;
        string = normalize(string);
        string.toLowerCase();
        for (int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                numeroDeVogais++;
            }
        }
        return numeroDeVogais;
    }

    public boolean isPalindromo(String string) {
        string = string.replaceAll(" ", "");
        string = string.toUpperCase();
        String stringInvertida = inverter(string);
        return string.equals(stringInvertida);        
    }
    
    private static String normalize(String nome) {
        return Normalizer.normalize(nome, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}

package br.com.crescer.aula1;

import java.text.Normalizer;

public class StringManipulation implements StringUtils{
    
    public boolean isEmpty(String string) {
         if (string.isEmpty() == false && string.trim().length()>0){
             return false;
         }
         else{
             return true;
         }   
    }

    public String inverter(String string) {
        if (this.isEmpty(string) == false){
            return new StringBuilder(string).reverse().toString();
        }
        else return "Não foi possível inverter.";
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
        String palavraInvertida;
        palavraInvertida = new StringBuilder(string).reverse().toString().trim();
        palavraInvertida = normalize(palavraInvertida);
        
        string = normalize(string);
        
        if(string.trim() == palavraInvertida){
            return true;
        }
        else{
            return false;
        }
    }
    
    private static String normalize(String nome) {
        return Normalizer.normalize(nome, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}

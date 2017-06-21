package br.com.crescer.aula1;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MeuCalendario implements CalendarUtils{
    
    public DiaSemana diaSemana(Date date) {
       Calendar calendar = Calendar.getInstance();
       calendar.setTime(date);
       int dia = calendar.get(Calendar.DAY_OF_WEEK);
       if(dia == 1){
           return CalendarUtils.DiaSemana.DOMINGO;
       }
       
       if(dia == 2){
           return CalendarUtils.DiaSemana.SEGUNDA_FEIRA;
       }
       
       if(dia == 3){
           return CalendarUtils.DiaSemana.TERCA_FEIRA;
       }
       
       if(dia == 4){
           return CalendarUtils.DiaSemana.QUARTA_FEIRA;
       }
       
       if(dia == 5){
           return CalendarUtils.DiaSemana.QUINTA_FEIRA;
       }
       
       if(dia == 6){
           return CalendarUtils.DiaSemana.SEXTA_FEIRA;
       }
       
       if(dia == 7){
           return CalendarUtils.DiaSemana.SABADO;
       }
      
       else return null;
    }

    public String tempoDecorrido(Date date) {
        
       String diferenca;
       Calendar diaAtual = new GregorianCalendar();
       Calendar dataInformada = new GregorianCalendar();
       dataInformada.setTime(date);
       diaAtual.setTime(new Date());
    
       int dia = diaAtual.get(diaAtual.DAY_OF_MONTH) - dataInformada.get(dataInformada.DAY_OF_MONTH);
       int mes = diaAtual.get(diaAtual.MONTH) - dataInformada.get(dataInformada.MONTH);
       int ano = diaAtual.get(diaAtual.YEAR) - dataInformada.get(dataInformada.YEAR);
       
       return diferenca = "dias de diferença: " + dia + " Meses de diferença: " +mes+ " Anos de diferença: "+ano;
       
    }
    
}

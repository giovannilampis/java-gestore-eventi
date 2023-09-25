package com.gestore.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//Creo la classe ProgrammEventi ...
public class ProgrammEventi {

	// ... con gli attributi titolo e eventi ...
    private String titolo;
    private List<Evento> eventi;

    // inizializzo eventi come una nuova ArrayList nel costruttore
    public ProgrammEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }
    
    // Creo un metodo per aggiungere un Evento alla lista:
    public void aggiungiEvento(Evento evento) {
        eventi.add(evento);
    }
    
    // Creo un metodo per restituire una lista di eventi in una data specifica:
    public List<Evento> eventiInData(LocalDate data) {
        List<Evento> eventiInData = new ArrayList<>();
        for (Evento evento : eventi) {
            if (evento.getData().equals(data)) {
                eventiInData.add(evento);
            }
        }
        return eventiInData;
    }
    
    // Implemento un metodo per restituire il numero di eventi nel programma:
    public int numeroEventi() {
        return eventi.size();
    }
    
    // Implemento un metodo per svuotare la lista di eventi:
    public void svuotaEventi() {
        eventi.clear();
    }
    
    // Implementa un metodo per generare una stringa ...
    public String toString() {
    	
        StringBuilder result = new StringBuilder();
        
    	// ... che mostra il titolo del programma ... 

        result.append(titolo).append("\n");
        
        // e tutti gli eventi ordinati per data nel formato richiesto:

        eventi.sort((evento1, evento2) -> evento1.getData().compareTo(evento2.getData()));
        
        for (Evento evento : eventi) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            result.append("- ").append(evento.getData().format(formatter)).append(" - ").append(evento.getTitolo()).append("\n");
        }
        
        return result.toString();
    }


}

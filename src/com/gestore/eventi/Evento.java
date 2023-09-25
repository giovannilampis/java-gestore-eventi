package com.gestore.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	// La classe Evento ha le proprietà richieste: titolo, data, numero di posti in totale, numero di posti prenotati. 
	private String titolo;
    private LocalDate data;
    private int numeroPostiTotali;
    private int numeroPostiPrenotati;

    //  Il costruttore inizializza tutti gli attributi tranne numero di posti prenotati che viene impostato a 0.
    public Evento(String titolo, LocalDate data, int numeroPostiTotali) throws Exception {
        if (data.isBefore(LocalDate.now())) {
            throw new Exception("La data dell'evento non può essere nel passato.");
        }
        if (numeroPostiTotali <= 0) {
            throw new Exception("Il numero di posti totali deve essere positivo.");
        }
        this.titolo = titolo;
        this.data = data;
        this.numeroPostiTotali = numeroPostiTotali;
        this.numeroPostiPrenotati = 0;
    }
    
    // Vengono implementati i metodi getter e setter per le proprietà richieste.
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) throws Exception {
        if (data.isBefore(LocalDate.now())) {
            throw new Exception("La data dell'evento non può essere nel passato.");
        }
        this.data = data;
    }
    
    public int getNumeroPostiTotali() {
        return numeroPostiTotali;
    }

    public int getNumeroPostiPrenotati() {
        return numeroPostiPrenotati;
    }

    // viene implementato il metodo prenota che aggiunge un posto prenotato, sollevando eccezioni se l’evento è già passato o non ci sono posti disponibili.
    public void prenota() throws Exception {
        if (data.isBefore(LocalDate.now())) {
            throw new Exception("L'evento è già passato.");
        }
        if (numeroPostiPrenotati >= numeroPostiTotali) {
            throw new Exception("Non ci sono posti disponibili per l'evento.");
        }
        numeroPostiPrenotati++;
    }

    // viene implementato il metodo disdici, che rimuove un posto prenotato, sollevando eccezioni se l’evento è già passato o non ci sono prenotazioni..
    public void disdici() throws Exception {
        if (data.isBefore(LocalDate.now())) {
            throw new Exception("L'evento è già passato.");
        }
        if (numeroPostiPrenotati <= 0) {
            throw new Exception("Non ci sono prenotazioni per l'evento.");
        }
        numeroPostiPrenotati--;
    }

    // l’override del metodo toString restituisce una stringa formattata, contenente data e titolo dell’evento.
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter) + " - " + titolo;
    }
}


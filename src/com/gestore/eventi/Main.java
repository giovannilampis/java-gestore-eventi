package com.gestore.eventi;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);

        try {
            // Chiedi all'utente di inserire i dettagli per il nuovo evento
            System.out.println("Inserisci il titolo dell'evento:");
            String titolo = scanner.nextLine();

            System.out.println("Inserisci la data dell'evento (formato: dd/MM/yyyy):");
            String dataStr = scanner.nextLine();
            LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.println("Inserisci il numero di posti totali disponibili:");
            int numeroPostiTotali = Integer.parseInt(scanner.nextLine());

            // Crea un nuovo evento
            Evento evento = new Evento(titolo, data, numeroPostiTotali);
            
            // Stampa Evento
            System.out.println("Evento:");
            System.out.println(evento.toString());

            // Chiedi all'utente di effettuare prenotazioni
            System.out.println("Vuoi effettuare delle prenotazioni? (Sì/No)");
            String risposta = scanner.nextLine().toLowerCase();
            
            while (risposta.equals("sì")) {
                try {
                    evento.prenota();
                    System.out.println("Prenotazione effettuata con successo.");
                } catch (Exception e) {
                    System.out.println("Impossibile effettuare la prenotazione: " + e.getMessage());
                }

                System.out.println("Vuoi effettuare un'altra prenotazione? (Sì/No)");
                risposta = scanner.nextLine().toLowerCase();
            }

            // Stampa il numero di posti prenotati e disponibili
            System.out.println("Numero di posti prenotati: " + evento.getNumeroPostiPrenotati());
            System.out.println("Numero di posti disponibili: " + (evento.getNumeroPostiTotali() - evento.getNumeroPostiPrenotati()));

            // Chiedi all'utente se vuole disdire posti
            System.out.println("Vuoi disdire dei posti? (Sì/No)");
            risposta = scanner.nextLine().toLowerCase();

            while (risposta.equals("sì")) {
                try {
                    evento.disdici();
                    System.out.println("Disdetta effettuata con successo.");
                } catch (Exception e) {
                    System.out.println("Impossibile effettuare la disdetta: " + e.getMessage());
                }

                System.out.println("Vuoi effettuare un'altra disdetta? (Sì/No)");
                risposta = scanner.nextLine().toLowerCase();
            }

            // Stampa nuovamente il numero di posti prenotati e disponibili
            System.out.println("Numero di posti prenotati: " + evento.getNumeroPostiPrenotati());
            System.out.println("Numero di posti disponibili: " + (evento.getNumeroPostiTotali() - evento.getNumeroPostiPrenotati()));
            
            
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        } finally {
            scanner.close();
        }
        
	}
}

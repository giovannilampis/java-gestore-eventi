package com.gestore.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Inserisci il titolo del concerto:");
            String titolo = scanner.nextLine();

            System.out.println("Inserisci la data del concerto (formato: dd/MM/yyyy):");
            String dataStr = scanner.nextLine();
            LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            
            System.out.println("Inserisci il numero di posti totali disponibili:");
            int numeroPostiTotali = Integer.parseInt(scanner.nextLine());

            System.out.println("Inserisci l'ora del concerto (formato: HH:mm):");
            String oraStr = scanner.nextLine();
            LocalTime ora = LocalTime.parse(oraStr, DateTimeFormatter.ofPattern("HH:mm"));

            System.out.println("Inserisci il prezzo del concerto:");
            BigDecimal prezzo = new BigDecimal(scanner.nextLine());

            // Crea un nuovo concerto
            Concerto concerto = new Concerto(titolo, data, numeroPostiTotali, ora, prezzo);
            
            // Stampa concerto
            System.out.println("Concerto:");
            System.out.println(concerto.toString());

            // Continua con il codice per prenotazioni e disdette se necessario
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}


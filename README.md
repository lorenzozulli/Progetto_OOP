# Progetto di Programmazione a oggetti di Lorenzo Zulli e Giovanni Prati
Lo scopo del progetto è quello di sviluppare un'applicazione Java per analizzare i freelancer aventi la skill "java".

# L'applicazione
Il programma prende e processa, tramite l'API di Upwork gli utenti con la skill java, poi resituisce a noi Statistiche o Filtri in base alla rotta scelta.

## Rotte Disponibili
| Rotta     | Metodo | Funzione                      |
|-----------|--------|-------------------------------|
| /search   | POST   | Avvia la ricerca degli utenti |
| /stats    | POST   | Restituisce le statistiche    |
| /filters  | POST   | Restituisce i filtri          |

## /search

## /stats
Tramite questa rotta andiamo a generare le seguenti statistiche:
* media e varianza di numero di oggetti nel portfolio (**portfolio_items_count**)
* media e varianza del numero di skill (**skills**)
  
Esempio di risultato:
// da inserire il JSON

## /filters
Tramite questa rotta andiamo a generare i seguenti filtri:
* feedback in ordine crescente (**feedback**)
* dimensione portfolio in ordine crescente (**portfolio_items_count**)

Esempio di risultato: 
// da inserire il JSON

# Software utilizzati
* [Eclipse](https://www.eclipse.org/downloads/) - Ambiente di sviluppo (Giovanni Prati)
* [Visual studio Code](https://code.visualstudio.com/Download) - Ambiente di sviluppo (Lorenzo Zulli)
* [Maven](https://maven.apache.org/) - software di gestione di progetti e librerie
* [Spring Boot](https://spring.io/projects/spring-boot) - framework per sviluppo di applicazioni in Java
* [Postman](https://www.postman.com/) - ambiente di sviluppo API per effettuare richieste
# Progetto di Programmazione a oggetti di Lorenzo Zulli e Giovanni Prati
## Macro tema: Upwork

Upwork è una piattaforma Americana per effettuare freelancing online e/o intervistare, assumere e collaborare con freelancers.

Per maggiori informazioni: 
* [Sito ufficiale di Upwork](https://www.upwork.com/)
* [Pagina Wikipedia](https://en.wikipedia.org/wiki/Upwork).

Lo scopo del progetto è quello di sviluppare un'applicazione in linguaggio Java per analizzare i freelancer appartenenti al sito, con la skill *java*.

### Scopo originario
Il programma prende e processa, tramite **l'API di Upwork** gli utenti con la skill *java*, poi resituisce a noi statistiche e/o filtri in base alla rotta scelta.

### Scopo aggiornato in quanto problemi con l'API
Il programma prende e processa, tramite il file **DB.json** gli utenti con la skill *java*, poi resituisce a noi statistiche e/o filtri in base alla rotta scelta.

## Rotte Disponibili
Vengono rese disponibili le seguenti rotte su [https://localhost:8080](https://localhost:8080).
|Rotta               |Metodo|Funzione                     |
|--------------------|------|-----------------------------|
|[/search](#search)  |GET   |Avvia la ricerca degli utenti|
|[/stats](#stats)    |GET   |Restituisce le statistiche   |
|[/filters](#filters)|GET   |Restituisce i filtri         |

## /search
Tramite questa rotta andiamo ad effettuare ricerca degli utenti con la skill *java*.

Esempio di risultato:
```json
[
 {"categories2": ["Legal",
                  "Web & Mobile Development",
                  "Admin Support"],
  "country": "Italy",
  "description": "I do ...",
  "feedback": "4.8424790960452",
  "id": "~aaaa9999d3f394624e",
  "last_activity": "March 17, 2022",
  "member_since": "July 21, 2012",
  "name": "Cristina Vallese",
  "portfolio_items_count": "13",
  "portrait_50": "https:...",
  "profile_type": "Independent",
  "rate": "22.22",
  "skills": ["java",
              "django-framework",
              "mongodb",
              "jquery",
              "html5",
              "postgresql"],
 "test_passed_count": "4",
 "title": "Java Developer"},
 {
    "...Another freelancer..."
 },
    "..."
]
```

## /stats
Tramite questa rotta andiamo a generare le seguenti statistiche:
* media e varianza di numero di oggetti nel portfolio (**portfolio_items_count**)
* media e varianza del numero di skill (**skills**)
  
Esempio di risultato:
```json
{
   "average portfolio_items_count": "3.44543456567",
   "variance portfolio_items_count": "4.342345665657",
   "average skills": "2.4343566",
   "variance skills": "3.5546656767",
}
```

## /filters
Tramite questa rotta andiamo a generare i seguenti filtri attraverso le seguenti keywords:
* **/feedback**: feedback in ordine crescente<br> 
   Esempio di risultato: 
```json
[
   {
      "...ohter things about the user..."
      "feedback": "1.6655474896789",
      "...ohter things about the user..."
   },
   {
      "...ohter things about the user..."
      "feedback": "2.56785904954805",
      "...ohter things about the user..."
   },
   {
      "...ohter things about the user..."
      "feedback": "3.56787346023946",
      "...ohter things about the user..."
   },
   "..."
]
```
* **/portfolio**: dimensione portfolio in ordine crescente<br>
   Esempio di risultato: 
```json
[
   {
      "...ohter things about the user..."
      "portfolio_items_count": "1",
      "...ohter things about the user..."
   },
   {
      "...ohter things about the user..."
      "portfolio_items_count": "2",
      "...ohter things about the user..."
   },
   {
      "...ohter things about the user..."
      "portfolio_items_count": "3",
      "...ohter things about the user..."
   },
   "..."
]
```

# Eccezioni
Il programma riesce all'occorrenza, a lanciare eccezioni personalizzate:
* **MyFileNotFoundException** Eccezione nel caso in cui il file non venisse trovato e/o il percorso del file fosse sbagliato<br>
```java
"ERRORE: non e' stato possibile trovare il file!"
```
* **BodyIsEmptyException** Eccezione nel caso in cui il Database è vuoto<br>
```java
"ERRORE: Il file non contiene un JSONArray!"
```

# JUNIT
Nella sezione *test* del progetto abbiamo implementato:
* **TestStats** Test per verificare la correttezza dei metodi inerenti alla classe Stats.java
* **TestFilters** Test per verificare la correttezza dei metodi inerenti alla classe Filters.java
* **TestFreelancersParser** Test per verificare la correttezza del parsing dei dati

# Javadoc
Attraverso i commenti speciali **Javadoc**, che mette a disposizione Java stesso siamo riusciti a creare una documentazione dettagliata di tutte le classi e di diversi metodi, di seguito il link: [Javadoc del progetto](https://www.youtube.com/watch?v=dQw4w9WgXcQ)

# Software utilizzati
* [Eclipse](https://www.eclipse.org/downloads/) - Ambiente di sviluppo (Giovanni Prati).
* [Visual studio Code](https://code.visualstudio.com/Download) - Ambiente di sviluppo (Lorenzo Zulli).
* [Maven](https://maven.apache.org/) - Gestione del progetto.
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework per lo sviluppo dell'applicazione Java.

# Autori
|Nome          |Links                                    |Contributo(%)|Focus su                          |
|--------------|-----------------------------------------|-------------|----------------------------------|
|Lorenzo Zulli |[Github](https://github.com/lorenzozulli)|50%          |Fase di modellazione delle classi |
|Giovanni Prati|[Github](https://github.com/jjohnnyUtah) |50%          |Fase di implementazione dei metodi|
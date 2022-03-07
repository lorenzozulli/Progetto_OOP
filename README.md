# Progetto di Programmazione a oggetti di Lorenzo Zulli e Giovanni Prati
Lo scopo del progetto è quello di sviluppare un"applicazione Java per analizzare i freelancer aventi la skill *"java"*.

Il programma prende e processa, tramite l"API di Upwork gli utenti aventi la skill *"java"*, poi resituisce a noi Statistiche e/o Filtri in base alla rotta scelta.

## Rotte Disponibili
| Rotta     | Metodo | Funzione                      |
|-----------|--------|-------------------------------|
| /search   | POST   | Avvia la ricerca degli utenti |
| /stats    | POST   | Restituisce le statistiche    |
| /filters  | POST   | Restituisce i filtri          |

## /search
Tramite questa rotta andiamo ad effettuare la vera e propra ricerca degli utenti

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
//JSON here
```

## /filters
Tramite questa rotta andiamo a generare i seguenti filtri:
* feedback in ordine crescente (**feedback**)
* dimensione portfolio in ordine crescente (**portfolio_items_count**)

Esempio di risultato: 
```json
//JSON here
```

# Software utilizzati
* [Eclipse](https://www.eclipse.org/downloads/) - Ambiente di sviluppo (Giovanni Prati).
* [Visual studio Code](https://code.visualstudio.com/Download) - Ambiente di sviluppo (Lorenzo Zulli).
* [Maven](https://maven.apache.org/) - Gestione del progetto.
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework per lo sviluppo dell"applicazione Java.
* [Postman](https://www.postman.com/) - Ambiente per effettuare richieste API.
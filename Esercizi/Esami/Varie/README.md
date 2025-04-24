Definire la classe Studente i cui campi sono genere di tipo stringa, numeroEsami di tipo intero e mediaVoti di tipo reale.  

(a) Indicare il Contenitore Java considerato più idoneo per la modellazione di una collezione di Studenti (sono possibili duplicati) tenendo conto che e l'operazione richiesta con maggiore frequenza è la stampa di un elemento in una specifica posizione della collezione. Motivare la scelta e scrivere le classi Studente e Collezione.  Commentare il codice scritto.   

(b) In Collezione modellare il metodo Studente max(Comparator c) che individua lo Studente massimo nella collezione rispetto ad uno specifico criterio. Mostrare l’uso dello stesso prima per ricercare lo studente con mediaVoti più alta e poi per ricercare lo studente con numeroEsami più alto. Commentare il codice scritto.   

(c )Modificare il codice scritto per realizzare la serializzazione delle istanze di collezione, facendo in modo che l’attributo genere sia non serializzabile. Scrivere i metodi di serializzazione e deserializzazione nella classe Collezione. Commentare il codice scritto.

• Descrivere l’operazione di riduzione reduce nella estensione funzionale di Java. Considerare la classi definite nell’esercizio 4 e scrivere il metodo di Collezione che usi una pipeline con reduce per restituire lo studente di genere “female” nella collezione che ha sostenuto il più alto numero di esami. Commentare il codice scritto

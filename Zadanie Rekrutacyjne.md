# Zadania rekrutacyjne ILS

## Zanim rozpoczniesz

* Zrob fork tego repozytorium (prywatny) 🙂 - po zrobieniu zadań będziesz wystawiać PR w celu review kodu.  
* Dodaj jako kolaboratorów użytkowników `mpiasta` oraz `bigSAS` do swojego repozytorium. 

## Krótki wstęp

Celem zadań jest stworzenie `mini (minimalistycznego - im mniej dependency tym lepiej)` repozytorium z testami z użyciem następujących technologii:

* Cucumber 
* Java
* Selenium
* Maven  
* (dowolne inne biblioteki/narzędzia/technologie które umożliwią wykonanie zadań)
 

## Uwagi

* Scenariusze w języku Gherkin powinny zostać napisane po polsku
* każdy test (api , gui) powinien je mieć: krótkie (min 2 step'y) - **chodzi tylko o demonstrację znajomości konstrukcji testów w użyciem Gherkin'a**
* Readme mile widziane  
* Raport z testów mile widziany

## Zadania

### 1. GUI - Sprawdzenie stanu paczki w GUI  

Ekran początkowy na stronie https://inpost.pl/  

Numery paczek do użycia (jeśli nie podane przez rekrutera): 

* 620811598235082024114611
* 661872598244266119104467
* 661872598226500126589260
* 561872598244266119104467

**Assert statusu**  
**Na ostatnim ekranie powinien zapisać się screenshot**
 

### 2. API
Endpointy odpowiedzialne za szukanie paczkomatów czy paczek do znalezienia samodzielnie za pomocą narzędzi do inspekcji ruchu sieciowego  

**Wybierz jedno, lub zrób obydwa;)**  

### - 2.A Wyszukiwanie stanu paczki  

Numery paczek do użycia (jeśli nie podane przez rekrutera):  

* 620811598235082024114611
* 661872598244266119104467
* 661872598226500126589260
* 561872598244266119104467

1. **Assert statusu**  
1. **Zapis wyników do pliku (jeden z formatów [csv|json|yaml])**

Plik powinien zawierać:  

* numer paczki
* typ usługi (service)
* nazwa paczkomatu ODBIORCZEGO (jeśli istnieje )

**Jeśli przy wywoływaniu zapytania pojawi się błąd 403 należy poszukać jak go obejść😉 Da się w taki sposób spreparować zapytanie, aby 403 nie leciał**
 
### - 2.B Wyszukiwanie paczkomatów

Endpoint do znalezienia samodzielnie. Podpowiedź - w nazwie ma `points`. Można skorzystać ze strony https://szybkienadania.pl

Zbuduj test, który zwróci do pliku listę 10 paczkomatów w Opolu.
1. **Zapis wyników do pliku (jeden z formatów [csv|json|yaml])**  
   * Plik powinien zawierać:
      * nazwę paczkomatu
      * pełny adres paczkomatu (ulica, numer, kod pocztowy, miasto)
1. **Assert poprawności formatu adresu**
   * Wartości z pola `$..address.line2` powinny zawierać:
     * poprawny format kodu pocztowego
     * poprawne miasto
    
### 3. OOP (opcjonalne - dla zainteresowanych) 

Utwórz DOWOLNY program / aplikację / pakiet , w JAVA (lub dowolnym innym języku obiektowym), który zademonstruje użycie 4 filarów programowania obiektowego.
Chhodzi o proste klasy np animal/building/car - pokazanie bardzo prostej demonstracji praktycznego użycia OOP.
 

### 4. Test Ops (opcjonalne - dla zainteresowanych zaawansowanych)
Przygotuj `Jenkinsfile` z przykładowym pipeline do uruchomienia testów + krótkie readme jak powinien działać  

* `Dockerfile` / `docker-compose` mile widziany 😉

## Na koniec

Po wykonaniu zadań wystaw Pull Request i przypisz/oznacz `mpiasta` oraz `bigSAS` w celu review 👀  

Powodzenia 🚀

# language: pl
Funkcja: Pobranie statusu paczki

  @selenium @gui
  Szablon scenariusza: Użytkownik pobiera status paczki
    Kiedy użytkownik wejdzie na strone inpost
    Oraz wprowadzi numer paczki "<numerPaczki>" w pole wyszukiwania
    Oraz kliknie przycisk 'ZNAJDZ'
    Wtedy status paczki powinen miec wartosc "<status>"

    Przykłady:
    | numerPaczki              | status                    |
    | 620811598235082024114611 | Dostarczona.              |
    | 661872598244266119104467 | Przekazano do doręczenia. |
    | 620811598235082024114611 | Dostarczona.              |
    | 561872598244266119104467 | Dostarczona.              |

# language: pl
Funkcja: Pobranie statusu paczki REST API

  @api
  Szablon scenariusza: Użytkownik pobiera status paczki REST API
    Jeśli wyśle zapytanie o status paczki o numerze "<numerPaczki>"
    Wtedy paczka powinna miec status "<status>"

    Przykłady:
    | numerPaczki              | status          |
    | 620811598235082024114611 | delivered       |
    | 661872598244266119104467 | ready_to_pickup |
    | 620811598235082024114611 | delivered       |
    | 561872598244266119104467 | delivered       |

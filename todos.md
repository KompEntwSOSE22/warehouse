# Warehouse

1. Git Repository erstellen
    - ReadMe
      - Anweisungen zur Konfiguration 
      - Installationsanweisungen
      - Anweisung zur Bedienung
2. CSV - Importer
    ~~- Components: 10 Komponenten~~ 
    - Products: id, name, komponenten, amount of komponenten?
~~3. Endpoints~~
    ~~/components~~
    ~~/components/id~~
    ~~/products~~
    ~~/products/id~~
~~4. Swagger + OpenAPI~~
5. Fehlerbehandlung -> RFC 2616, 10.04
6. Datenbank Integration
   1. Maven: Treiber + Spring Data
   2. Erstellung Relationale Datenbank 
      1. Heroku
      2. Repository enthält nicht Anmeldeinfo der Datenbank -> Passwort aus Umgebungsvariable löschen
      3. H2 Datenbank -> Dummy-Daten initialisierung
   3. Schema Validator

## Test
-> erfolgreicher CSV imput
https://www.baeldung.com/spring-data-crud-repository-save

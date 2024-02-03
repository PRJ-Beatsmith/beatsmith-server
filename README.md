# Beatsmith - Server
## _Ein Java-basierter Application Server für das Beatsmith Projekt_

Der Beatsmith-Server ist ein leistungsstarker Java-Application-Server, der auf dem [Spring-Boot Framework](https://spring.io) basiert. Dieser Server bietet eine robuste und skalierbare Plattform für die Entwicklung von Webanwendungen, APIs und Microservices im Rahmen des Beatsmith-Projekts. Einige der implementierten Service-Funktionalitäten umfassen:

- **Benutzerauthentifizierung:** Gewährleistet die sichere Authentifizierung von Benutzern.
- **Datenbankinformationen:** Bereitet Datenbankinformationen auf und stellt sie bereit.
- **Grafische Benutzeroberfläche:** Bietet eine benutzerfreundliche Oberfläche für die Interaktion mit dem Beatsmith-Projekt.
- **Weitere Funktionen:** und vieles mehr.

## Inhaltsverzeichnis
1. [Voraussetzungen](#voraussetzungen)
   - [Ausführung](#ausführung)
   - [Kompilieren der Anwendung](#kompilieren-der-anwendung)
2. [Ausführung](#ausführung)
2. [Generieren der Dokumentation](#generieren-der-dokumentation)
   - [Voraussetzungen](#voraussetzungen-1)
   - [Generieren der API-Dokumentation](#generieren-der-api-dokumentation)
      - [Die Anwendung generiert die Dokumentation während der Laufzeit](#1-die-anwendung-generiert-die-dokumentation-während-der-laufzeit)
      - [Die Dokumentation wird mittels Maven als openapi.json Datei erstellt](#2-die-dokumentation-wird-mittels-maven-als-openapijson-datei-erstellt)
   - [Generierung der Quellcode-Dokumentation](#generierung-der-quellcode-dokumentation)
   - [Kompilieren der Anwendung](#kompilieren-der-anwendung-1)

## Voraussetzungen
Die Softwareanforderungen für die Ausführung oder Entwicklung des Beatsmith-Servers sind wie folgt.

### Ausführung
- **Java JRE (Java Runtime Environment) Version 21**
  - Empfohlen: [Java Temurin JRE 21](https://adoptium.net/de/temurin/releases/)

### Kompilieren der Anwendung
- **Java JDK (Java Development Kit) Version 21**
  - Empfohlen: [Java Temurin JDK 21](https://adoptium.net/de/temurin/releases/)
- **Apache Maven**
- **Node.js** *(Optional für die Kompilierung der grafischen Benutzeroberfläche)*.

## Ausführung
Die Anwendung wird mittels Java gestartet und beansprucht anschließend den Port 8080.

``` java -jar Beatsmith.jar ```

## Generieren der Dokumentation
In dieser Sektion wird beschrieben, wie die API (Application Programming Interface)-Dokumentation und die Quellcode-Dokumentation erstellt werden können.

### Voraussetzungen
- Alle Anwendungen der übergeordneten Vorraussetzungen der Sektion [Kompilieren der Anwendung].
- Für die Generierung mittels Runtime wird lediglich die Sektion [Ausführung] benötigt.

### Generieren der API-Dokumentation
Es gibt zwei Methoden für die Generierung der API-Dokumentation.

#### 1. Die Anwendung generiert die Dokumentation während der Laufzeit.
1. Lade die neueste Veröffentlichung des Beatsmith-Servers herunter. ([Aktuellste Veröffentlichung](https://github.com/PRJ-Beatsmith/beatsmith-server/releases/latest)).
2. Starte den Beatsmith-Server mit Java: `java -jar Beatsmith.jar`
3. Navigiere zu folgender Domain, um eine OpenAPI-Dokumentation im JSON-Format abzurufen: http://localhost:8080/v3/api-docs

#### 2. Die Dokumentation wird mittels Maven als openapi.json Datei erstellt.
1. Klone das Repository: `git clone https://github.com/PRJ-Beatsmith/beatsmith-server`
2. Navigiere in das Repository: `cd beatsmith-server`
3. Kompiliere die Anwendung mit Maven: `mvn clean install`
4. Die erstellte Datei befindet sich im Ordner /target: `beatsmith-server/target/openapi.json`

### Generierung der Quellcode-Dokumentation.
1. Klone das Repository: `git clone https://github.com/PRJ-Beatsmith/beatsmith-server`
2. Navigiere in das Repository: `cd beatsmith-server`
3. Kompiliere die Anwendung mit Maven: `mvn javadoc:javadoc`
4. Die erstellten Dateien sind im Ordner /docs zu finden.

### Kompilieren der Anwendung
1. Klone das Repository: `git clone https://github.com/PRJ-Beatsmith/beatsmith-server`
2. Navigiere in das Repository: `cd beatsmith-server`
3. Kompiliere die Anwendung mit Maven: `mvn clean install`
4. Die erstellten Dateien sind im Ordner /target zu finden: `beatsmith-server/target/Beatsmith.jar`

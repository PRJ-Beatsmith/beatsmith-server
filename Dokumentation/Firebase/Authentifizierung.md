# Firebase authentifizierung
## Wie funktioniert die Authentifizierung?
Die Authentifizierung wird mittels Googles Firebase Authentication abgewickelt.
Dabei meldet sich der Nutzer der Anwendung an der Client Anwendung an.
Die Anmeldung erfolgt mittels der Google Identity Toolkit API.
Der Client bekommt ein [JWT](https://jwt.io). 
Dieser JWT Token wird bei jeden, authentifizierten Request gegen den Server als Bearer Token übermittelt.
### Wie validiert der Server das JWT?
Google Firebase bietet eine Schnittstelle für Backend Anwendungen, mit welcher der übergebene JWT validiert werden kann.
Bei jeder Anfrage erwartet der Server einen solches JWT.
Welches mittels der Google Server validiert werden kann.
Dabei ist zu beachten, dass alle Schnittstellen des Servers abgesichert sind. Nur Schnittstellen mit einer gesonderten WhiteList sind auch ohne Authentifizierung aufrufbar.
## Wie werden dem Nutzer Rollen zugewiesen?
Google Firebase unterstützt keine Unterscheidung von Benutzer.
Ein solches Konzept wie Rollen oder Benutzerberechtigungen muss mittels des Servers umgesetzt werden.
Google Firebase bietet daher sogenannte "custom_claims" innerhalb eines Nutzers und seines JWT.
Diese "custom_claims" sind mit Daten befüllbar, welche eine maximale Länge von 1000 Byte (1 Kilobyte) aufweisen.
Hier können Informationen wie die Benutzerrolle und sonstige extra Informationen zum Benutzer untergebracht werden.
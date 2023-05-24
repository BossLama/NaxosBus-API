# NaxosBus-API
Ist eine API um Busrouten auf Naxos abzurufen

## HTTP-REQUESTS
Es können nur Daten aus der API abgegriffen werden. Derzeit besteht keine Möglichkeit
Daten via API zu ändern oder hinzuzufügen.

### Routen abfragen:
``` javascript
http://localhost:8321/api/routes?key=YOUR_KEY&depature=DEPATURE_NAME&destination=DESTINATION_NAME
```

``` json
[
  { "lineID":10,
    "distance":5.0,
    "busStop":{
      "latitude":37.101555,
      "longitude":25.380589,
      "name":"Elli's Park",
      "isAttraction":false}
   },
  { "lineID":10,
    "distance":5.0,
    "busStop":{
      "latitude":37.097427,
      "longitude":25.379929,
      "name":"Cinema Naxos",
      "isAttraction":false}
  }
]
``` 

### Bushaltestellen abfragen:
``` javascript
http://localhost:8321/api/stops?key=YOUR_KEY
```

## Geplante Funktionen:

- GET-REQUEST für einzelne Bushaltestellen
- GET-REQUEST für Sehenswürdigkeiten

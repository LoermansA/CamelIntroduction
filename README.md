# Camel Introductie

Introductie presentatie/workshop voor Make IT Work

## Benodigdheden

- Laptop/computer
- Java >= 1.8
- Recente Maven
- Recente git
- Jouw favoriete editor (Visual Studio Code, bijv)

## Voorbereidingen

- `git clone <https://github.com/LoermansA/CamelIntroduction.git>`

## My First CamelProject (resultaat: stap1)

- `mvn archetype:generate`
- Gebruik het filter: `camel-archetype`
- Kies de variant: `camel-archetype-spring-boot` (25 ten tijde van schrijven)
- Kies de laatste productie versie: `2.24.2` (50 ten tijde van schrijven)
- GroupID mag je zelf invullen (nl.enshore.makeitwork)
- ArtifactID mag je zelf weten (camel-introductie)
- De rest is default prima

Na genereren:

- `cd camel-introductie`
- Opstarten met: `mvn spring-boot:run`

## FileIO (resultaat: stap2)

- Pas de route aan:

```java
    from("file:./in").routeId("fileIO")
    .to("log:fileIO")
    .to("file:./out");
```

- Opstarten met: `mvn spring-boot:run`

### Routeren gebaseerd op inhoud (resultaat: stap3)

- Pas de route aan:

```java
    from("file:./in").routeId("fileIO-met-xpath")
    .to("log:fileIO")
    .choice().when().xpath("//for = 'makeitwork'")
        .to("file:./out/special")
    .otherwise()
        .to("file:./out/regular")
    .end();
```

- Opstarten met: `mvn spring-boot:run`

### Zelfde maar nu met een REST endpoint en routes (resultaat: stap 4)

- Pas de route aan:

```java
    from("restlet:http://localhost:8888/greeting?restletMethod=POST").routeId("restEndpoint")
    .to("log:restlet")
    .choice().when().xpath("//for = 'makeitwork'")
        .to("direct:special")
    .otherwise()
        .to("direct:regular")
    .end();

    from("direct:special")
    .to("file:./out/special");

    from("direct:regular")
    .to("file:./out/regular");
```

- Testen met:

```bash
$ curl -X POST -d '<greeting><message>Hello, Class of MakeItWork!</message><for>makeitwork</for></greeting>' http://localhost:8888/greeting
```
en

```bash
$ curl -X POST -d '<greeting><message>Hello, Class of MakeItWork!</message><for>other</for></greeting>' http://localhost:8888/greeting
```

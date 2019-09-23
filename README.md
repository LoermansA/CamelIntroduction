# CamelIntroduction

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

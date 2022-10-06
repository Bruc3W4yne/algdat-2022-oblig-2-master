# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Isak Midtvedt, s350289, s350289@oslomet.no


# Arbeidsfordeling

Alle oppgaver gjort på egenhånd av undertegnende, i noe sporadisk tempo vel å merke.

# Oppgavebeskrivelse
**Oblig 2** tar for seg toveis lister eller bedre kjent som *Dobbelt Lenket Lister.*\
Navnet kommer av at hvert innlegg i listen peker både til forrige og neste posisjon ergo er de lenket sammen.\
Dette gjør at vi kan enklere traversere oss igjennom en liste samt at man enkelt kan gå begge veier **$\color{orange} node.neste $** og **$\color{orange} node.forrige $**\
En dobbelt lenket liste har også fordelen med at det er enklere og allokere og **$\color{orange} reallokere $** minne.

## Oppgave 1
**Oppgave 1** tar for seg instansiering av konstruktøren <a href ="https://github.com/Bruc3W4yne/algdat-2022-oblig-2-master/blob/master/src/main/java/no/oslomet/cs/algdat/Oblig2/DobbeltLenketListe.java#:~:text=public%20dobbeltlenketliste(t%5B%5D%20a)%20%7B">*DobbeltLenketListe*</a> samt konstruksjonen av metodene **$\color{orange} antall $** og **$\color{orange} tom $**.
- $\color{orange} antall $: Antall er metoden som brukes for å telle mengden verdier i en gitt liste. Da vi øker antall inne i de andre metodene kan vi gjøre det ganske enkelt med å bare ha:
```java
return antall;
```
- $\color{orange} tom $: Tom er metoden som brukes for å sjekke om listen er tom (duh)\
Dette gjør det enklere å vite hva man skal gjøre ved våre andre metoder.\
Vi kan sjekke om listen er tom ved å se om hode (*første posisjon*) er lik reel $\color{purple} null$ verdi;
```java
return hode == null;
```
- $\color{orange} DobbeltLenketListe(T [ ] a) $: Dette er konstruktøren vi bruker for å lage en ny instans av klassen DobbeltLenketListe.\
Den henter verdier fra tabell *a* og putter de inn i en ny dobbelt lenket liste.\
Den sørger for at verdiene havner i samme posisjon og at det blir deklarert både et $\color{orange} hode$ og en $\color{orange} hale$\
\
Ved hjelp av en **$\color{orange} for-løkke $** sørger vi også for at vi ikke tar med **$\color{orange} null $** verdier og kun reele verdier fra tabell *a*.

## Oppgave 2
**Oppgave 2** tar for seg to ulike problemer; \
Første del av problemet løser vi ved å lage metodene **$\color{orange} String toString $** og **$\color{orange} String omvendtString $** \
Disse sørger for at vi henter ut verdiene i listen for så å returnere de som en tegnstreng, enten i riktig rekkefølge eller baklengs\
- **$\color{orange} toString $**: Denne metoden benytter seg av en *stringbuilder* **$\color{orange} ts (toString) $** og dens metode **$\color{orange} .append $**\
Ved hjelp av *stringbuilder* og *node.neste*/*node.forrige* kan vi enkelt traversere igjennom listen (så sant den ikke er tom) og legge til verdien ved nåværende node inn i **$\color{orange} ts $**\
\
Det samme gjelder for **$\color{orange} omvendtString $**, bare at vi nå må gå gjennom listen baklengs.\
Dette gjør vi ved å sette nåværende node / *start* node til å være hale istedenfor.\
Da kan vi enkelt gå bakover ved å benytte oss av *node.forrige* og fortløpende legge til verdiene i **$\color{orange} ts $**





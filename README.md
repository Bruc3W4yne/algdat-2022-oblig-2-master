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
Ved hjelp av en **$\color{orange} for-løkke $** sørger vi også for at vi ikke tar med **$\color{purple} null $** verdier og kun reele verdier fra tabell *a*.

## Oppgave 2
**Oppgave 2** tar for seg to ulike problemer; \
Første del av problemet løser vi ved å lage metodene **$\color{orange} \mathit {String toString} $** og **$\color{orange} String omvendtString $** \
Disse sørger for at vi henter ut verdiene i listen for så å returnere de som en tegnstreng, enten i riktig rekkefølge eller baklengs
- **$\color{orange} toString $**: Denne metoden benytter seg av en *stringbuilder* **$\color{orange} ts (toString) $** og dens metode **$\color{orange} .append $**\
Ved hjelp av *stringbuilder* og *node.neste*/*node.forrige* kan vi enkelt traversere igjennom listen (så sant den ikke er tom) og legge til verdien ved nåværende node inn i **$\color{orange} ts $**

- **$\color{orange} \mathit{omvendtString} $**: Vi gjør det samme her bare at vi nå må gå gjennom listen baklengs.\
Dette gjør vi ved å sette nåværende node / *start* node til å være hale istedenfor.\
Da kan vi enkelt gå bakover ved å benytte oss av *node.forrige* og fortløpende legge til verdiene i **$\color{orange} ts $**\

Andre Del av problemet er metoden **$\color{orange} leggInn $**. Denne metoden skal legge inn en gitt verdi *bakerst* i listen og må da også oppdatere ny hale og forrige hale.
- **$\color{orange} leggInn $**: Her lager vi to nye instanser av **Node**, en for tom liste og en for liste med verdier.\
Noden for liste med verdier får da verdien: *verdi* og settes som hale.
\
Er listen tom setter vi hode og hale til å være samme node og de får begge samme verdi (T verdi) og pekere (0).\
\
Er listen ikke tom setter vi hale til å være lik hale.neste (ergo peker til neste node) som igjen settes lik til vår node med verdi.\
Dette gjør at vi oppdaterer både **$\color{red} hale(gamle) $** og **$\color{green} hale(ny) $** samtidig og at de peker til riktig node.\
Etter dette oppdaterer vi både antall og endringer, da vi har **lagt til** en ny verdi samt **endret plass til en gammel**


## Oppgave 3
**Oppgave 3** går ut på å lage metoder for å *finne en nodes indeks*, *hente en nodes verdi*, *oppdatere node verdi ved gitt indeks* **OG** en metode for å *returnere en liste ved gitt intervall (fra:til)*\
Det er altså en god del som må gjøres i oppgave 3. Vi begynner med finnNode
- **$\color{orange} finnNode $**: Denne metoden skal returnere noden ved gitt indeks. Er indeks mindre enn $\frac{antall, 2}$ skal vi begynne letingen fra hode og gå mot høyre.





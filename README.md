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
- $\color{orange} \text{DobbeltLenketListe(T [] a)} $: Dette er konstruktøren vi bruker for å lage en ny instans av klassen DobbeltLenketListe.\
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
Da kan vi enkelt gå bakover ved å benytte oss av *node.forrige* og fortløpende legge til verdiene i **$\color{orange} ts $**

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
- **$\color{orange} finnNode $**: Denne metoden skal returnere noden ved gitt indeks. Er indeks mindre enn $\{antall\over 2}$ skal vi begynne letingen fra hode og gå mot høyre.\
Hvis ikke skal vi begynne å lete fra hale og gå bakover, mot venstre!\
\
Vi begynner først med å lage en node, *nodeIndex* som skal funke som en *placeholder* noden vi leter etter.\
Ved å så iterere over listen (enten fra hode --> hale, eller hode <-- hale) kan vi sette *nodeIndex* til å være nåværende node helt til vi kommer til riktig indeks.\
Dette gjelder både ved søk fra hode eller hale, eneste forskjell er om vi bruker **$\color{orange} node.neste $** eller **$\color{orange} node.forrige $**.

Neste metode vi trenger er:
- **$\color{orange} \text{T hent} $**: Hent metoden benytter seg av **__finnNode__** og returnerer nodens verdi ved gitt indeks.
- **$\color{orange} \text{T oppdater} $**: Denne metoden gjør et enkelt bytte ved hjelp av en temp variabel og returnerer så tidligere verdi ved gitt indeks.

Det siste som gjennstår å gjøre nå er å lage subliste metoden, denne metoden skal ta inn et intervall for så å returnere en liste med verdier innefor gitt intervall.
- **$\color{orange} \text{subliste} $**: Vi sjekker først om intervallet er lovlig, dvs. er $\mathbf{fra} \lt \mathbf{til}$ og om $\mathbf{til} \gt \mathbf{antall}$\
Hvis indeksKontroll går igjennom så lager vi først en ny liste og en ny node(hode). Vi tar så å itererer over intervallet fra : til og legger inn nye verdier så lenge $\mathbf{i} \lt \mathbf{til}$.


## Oppgave 4
**Oppgave 4** tar for seg to ulike metoder; *indeksTil* og *inneholder*.
- **$\color{orange} indeksTil $**: Skal returnere indeksen/posisjonen til *verdi* hvis den finnes i listen og returnere -1 hvis den ikke gjør det.\
Vi begynner først med en sjekk for å se om listen evt er tom. En tom liste vil aldri inneholde verdien vi søker etter og vi kan dermed returnere -1.\
\
Etter dette lager vi en ny node, *indeks* og setter den lik *hode*. Dette gjør vi så vi kan begynne å lete fra starten av listen.\
Vi tar så å itererer over listen og setter *indeks* til å være lik neste node i listen.\
Hvis verdien til *indeks* er lik *verdi* stopper vi og returnerer i (ergo indeks) ved gitt node.
- **$\color{orange} inneholder $**: Skal returnere true om verdien finnes i listen og false om den ikke gjør det.\
Dette løser vi relativt enkelt ved å bruke metoden vi nettopp lagde og setter så en return statement som sjekker om indeks til *verdi* **IKKE** er lik -1.\
Det vil si at om *verdi* finnes vil inneholder returnere true og hvis ikke vil *indeksTil.verdi* bli lik -1 og metoden returnerer false.

## Oppgave 5
**Oppgave 5** går igjen utpå å legge inn en verdi i listen. Denne gangen har vi derimot ikke luksusen av at vi kun trenger å bekymre oss om å putte inn en ny verdi bakerst, da vi også nå skal kunne legge til en verdi hvor som helst i listen og sørge for at pekere blir oppdatert riktig.\
Her er det et par ting vi må passe på:
- Er listen tom?
- Skal verdi legges først?
- Skal verdi legges bakerst?
- Skal verdien legges imellom to ulike noder?

Det betyr at vi må ha med tester / checks for alle disse tilfellene.\

- Vi begynner med å sjekke om listen er tom:
    ```java
      if (antall == 0) {
          hode = hale = new Node<T>(verdi, null, null);
      }
    ```
- Hvis antall er lik null må det bety at listen ikke har noen verdier ergo er den tom.\
<br>
Skal verdien legges først?
  ```java
    if (indeks == 0) {
        hode = new Node<T>(verdi,h ale, null);
        hale.forrige.neste = hale;
    }
    ```
    Her sjekker vi først om indeks, altså plassen vi skal legge verdien inn på er lik 0. Hvis den er det så betyr det at den skal inn først.\
    Vi oppdaterer deretter *hode* til å være vår nye verdi og vi sørger for at *hale* sin forrige (*nest siste verdi*) sin neste er lik *hale*.
<br>
<br>
Skal verdien legges bakerst?
  ```java
    if (indeks == antall) {
        hale = new Node<T>(verdi, node.forrige, null);
        hale.forrige.neste = hale;
    }
    ```
    Her sjekker vi om indeks er lik antall, dvs. at *verdi* skal inn bakerst. Hvis den er det lager vi en ny hale med verdi *verdi* og *forrige* = *hale* og *neste* = null.\
    Vi oppdaterer deretter nest siste indeks (hale.forrige.neste = hale sin forrige (nest siste) sin neste (i dette tilfelle hale)) slik at pekere blir korrekt.\
<br>
Til slutt må vi sjekke om verdien skal legges imellom to andre verdier.
  ```java
    else () {
        for (int i = 0; i < indeks; i++) {
            node = node.neste;
        }
        
        Node<T> nyNode = new Node<T>(verdi, node.forrige, node);
        nyNode.neste.forrige = nyNode.forrige.neste = nyNode;
    }
    ```
    Her trenger vi ikke å kjøre en sjekk, da vi vet om denne koden utføres så har alle andre sjekker over ikke vært sant.\
    Vi begynner først med å iterere over nodene helt til vi kommer til riktig *indeks*\
    Med en gang vi når riktig indeks setter vi inn en ny node, *nyNode* med riktig *verdi* og setter forrige peker til å være noden rett før og neste peker til å være nåværende node i iterasjonen.\
    Deretter oppdaterer vi pekere til både forrige og neste node til å være lik *nyNode*
## Oppgave 6
**Oppgave 6** Handler om å fjerne elementer fra listen vår. Dette skal gjøres ved hjelp av metoden **T Fjern (int indeks)** som skal ta å fjerne (og returnere) verdien på posisjon *indeks*. Og booleanen **fjern (T verdi)** som skal fjerne *verdi* fra listen og så returnere true.\
Finnes ikke *verdi* i listen skal den returnere false.
- **$\color{orange} \text{T fjern} $**: Her sjekker vi først om indeks er lovlig, vi går så videre med å lage en ny node, *node* og setter den lik *hode*.\
Vi deklarerer også variabelen *T verdi*.\
Her er det igjen en liten sjekkliste vi må igjennom før vi kan fjerne verdiene.
- Den første skal fjernes
- Den siste skal fjernes
- En verdi imellom to andre fjernes.

- Vi begynner med å sjekke om det er den første som skal fjernes.
  - ```java
    if (indeks == 0) {
        verdi = node.verdi;
    
        if (node.neste != null) {
            hode = node.neste;
            hode.forrige = null;
        } else {
            hode = null;
            hale = null;
        }   
    }
    ```
    Her sjekker vi først om indeks er 0, ergo at det er første verdi som skal fjernes. Vi sjekker så om det er flere verdier i listen eller ikke.\
    Ved flere verdier setter vi hode til å være lik node til høyre og hode.forrige til å være lik null.\
  <br>
- Hvis indeks ikke er lik 0 sjekker vi så om indeks er lik antall - 1, eller da siste verdi. Er den det setter vi node til å være lik hale og verdi til å være verdien til halen.\
Vi oppdaterer så pekere til halen på samme måte som ved hode.\
<br>
- Hvis indeks hverken er lik 0 eller siste verdi itererer vi over listen helt til vi kommer til riktig posisjon som skal fjernes.\
For hver iterasjon hopper vi til neste node.\
Når vi til slutt når riktig node oppdaterer vi pekere for noden til høyre og noden til venstre til å peke på hverandre istendefor noden vi fjernet. 
Vi oppdaterer antall og endringer hele veien.\

Booleanen fjern er mer eller mindre det samme, men denne gangen får vi oppgitt en verdi som skal fjernes istedenfor posisjon.
- Vi begynner først med å sjekke om verdi er lik **$\color{purple} null $**, og om den er det returnerer vi false. En *null* verdi vil aldri finnes i listen og vi trenger derfor heller ikke lete.\
<br>
- Deretter sjekker vi om det er første verdi som skal fjernes ved å sjekke om verdi av *hode* er lik oppgitt *verdi*\
Er den det oppdaterer vi pekere på samme måte som ved metoden **$\color{orange} fjern $**.\
<br>
- Vi setter så node til å være lik *hale* og sjekker om verdi er like *hale.verdi* er den det vet vi at det er siste verdi som skal fjernes.\
Dette gjøres igjen på samme måte som i metoden **$\color{orange} fjern $**.\
<br>
- Hvis ingen av de tidligere testene stemmer setter vi node lik hode.neste (da vi allerede har sett at hode ikke har samme verdi) og itererer over listen.\
For hver iterasjon setter vi node til å være like node.neste.\
Vi utfører deretter en sammenligning for å se om verdi av node er lik *verdi*. Er den det fjerner vi noden på samme måte som i metoden **$\color{orange} fjern $**.\
<br>
- Skulle ingenting av dette stemme betyr det at verdien ikke finnes i listen og vi returnerer false.

## Oppgave 8
**Oppgave 8** går ut på å lage ulike metoder så vi kan senere bruke de til å itererer over listen uten bruk av vanlig for-løkke.\

- Vi begynner med å lage **$\color{orange} \text{T next} $**: som er selve "telleren" vår. Denne skal sørge for at vi flytter oss til neste verdi.\
Vi setter først fjernOK til true for å markere at vi har fjernet en verdi og oppdaterer så pekeren til denne til neste node.
<br>
- Etter dette lager vi metoden **$\color{orange} \text{Iterator<T> iterator()} $**: som skal sørge for at vi lager et iteratorobjekt og lager da en instans av iteratorklassen.\
<br>
- Vi lager så **$\color{orange} \text{DobbeltLenketListeIterator (int indeks)} $**: som setter pekeren *denne* til noden ved gitt *indeks*, setter fjernOK til false (da vi ikke har fjernet noen verdi), og setter iteratorendringer lik endringer.\
<br>
- Til slutt gjennstår bare **$\color{orange} \text{Iterator<T> iterator(int indeks)} $**: Denne returnerer en instans av iteratorklassen og vi kan nå iterere over listen, ved hjelp av i.next()

<footer class="footer">Isak Midtvedt 2022</footer>
<style>
.footer {
    display: flex;
    justify-content: center;
}
</style>
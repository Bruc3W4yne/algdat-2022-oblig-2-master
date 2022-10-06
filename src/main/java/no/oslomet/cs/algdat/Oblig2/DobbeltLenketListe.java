package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.*;


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen


    ////// Oppgave 1 //////
    public DobbeltLenketListe() {
        hode = hale = null;

        antall = 0;
        endringer = 0;
    }

    public DobbeltLenketListe(T[] a) {
        Objects.requireNonNull(a, "Tabell a er null!");

        int i = 0;
        for (; i < a.length; i++) {
            if (a[i] != null) {
                hode = new Node<>(a[i]);
                antall++;
                break;
            }
        }

        hale = hode;

        if (hode != null) {
            i++;
            for (; i < a.length; i++) {
                if (a[i] != null) {
                    hale.neste = new Node<>(a[i], hale, null);
                    hale = hale.neste;
                    antall++;
                }
            }
        }
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return hode == null;
    }

    ////// Oppgave 2 //////

    @Override
    public String toString() {
        StringBuilder ts = new StringBuilder();
        ts.append("[");

        if (!tom()) {
            Node<T> node = hode;
            ts.append(node.verdi);
            node = node.neste;

            while (node != null) {
                ts.append(",").append(" ").append(node.verdi);
                node = node.neste;
            }
        }
        ts.append("]");
        return ts.toString();
    }

    public String omvendtString() {
        StringBuilder os = new StringBuilder();
        os.append("[");

        if (!tom()) {
            Node<T> node = hale;
            os.append(node.verdi);
            node = node.forrige;

            while (node != null) {
                os.append(",").append(" ").append(node.verdi);
                node = node.forrige;
            }
        }
        os.append("]");
        return os.toString();
    }

    @Override
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Null-verdi ikke tillatt");

        Node<T> nodeTom = new Node<T>(verdi);
        Node<T> node = new Node<T>(verdi, hale, null);

        if (tom()) {
            hode = nodeTom;
            hale = hode;
            antall++;
        } else {
            hale = hale.neste = node;
            antall++;
            endringer++;
        }
        return true;
    }

    ////// Oppgave 3 //////

    private Node<T> finnNode(int indeks) {

        Node<T> nodeIndex;

        if (indeks < antall / 2) {
            nodeIndex = hode;
            for (int i = 0; i < indeks; i++) {
                nodeIndex = nodeIndex.neste;
            }
        } else {
            nodeIndex = hale;
            for (int i = antall - 1; i > indeks; i--) {
                nodeIndex = nodeIndex.forrige;
            }
        }
        return nodeIndex;
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);

        return finnNode(indeks).verdi;
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        indeksKontroll(indeks, false);

        Objects.requireNonNull(nyverdi, "Null verdi er ikke tilatt");

        Node<T> node = finnNode(indeks);

        T temp = node.verdi;
        node.verdi = nyverdi;
        endringer++;

        return temp;
    }

    public Liste<T> subliste(int fra, int til) {
        fratilKontroll(antall, fra, til);

        Liste<T> subliste = new DobbeltLenketListe<T>();
        Node<T> node = finnNode(fra);

        for (int i = fra; i < til; i++) {
            subliste.leggInn(node.verdi);
            node = node.neste;
        }
        return subliste;
    }

    ////// Oppgave 4 //////
    @Override
    public int indeksTil(T verdi) {
        if (verdi == null) return -1;

        Node<T> indeks = hode;

        for (int i = 0; i< antall; i++, indeks = indeks.neste)
        {
            if (indeks.verdi.equals(verdi)) return i;
        }

        return -1;
    }

    @Override
    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1;
    }

    ////// Oppgave 5 //////

    @Override
    public void leggInn(int indeks, T verdi) {
        Objects.requireNonNull(verdi, "Verdi kan ikke være null");
        //fratilKontroll(antall, indeks, antall); Gir IllegalArgumentException istedenfor, hvis ikke hadde jeg brukt denne istedenfor.

        if (indeks < 0) {
            throw new IndexOutOfBoundsException(indeks + " er mindre en null");
        } else if (indeks > antall) {
            throw new IndexOutOfBoundsException(indeks + " er større enn antall " + antall);
        }

        if (antall == 0) {
            hode = hale = new Node<T>(verdi, null, null);
        } else if (indeks == 0) {
            hode = new Node<T>(verdi, null, hode);
            hode.neste.forrige = hode;
        } else if (indeks == antall) {
            hale = new Node<T>(verdi, hale, null);
            hale.forrige.neste = hale;
        } else {
            Node<T> node = hode;

            for (int i = 0; i < indeks; i++) {
                node = node.neste;
            }
            Node<T> nyNode = new Node<T>(verdi, node.forrige, node);
            nyNode.neste.forrige = nyNode.forrige.neste = nyNode;
        }
        antall++;
        endringer++;
    }

    ////// Oppgave 6 //////

    @Override
    public T fjern(int indeks) {
        indeksKontroll(indeks, false);

        Node<T> node = hode;
        T verdi;

        if (indeks == 0) {
            verdi = node.verdi;

            if (node.neste != null) {
                hode = node.neste;
                hode.forrige = null;
            } else {
                hode = null;
                hale = null;
            }
        } else if (indeks == antall - 1) {
            node = hale;
            verdi = hale.verdi;

            hale = node.forrige;
            hale.neste = null;
        } else {
            for (int i = 0; i < indeks; i++) {
                node = node.neste;
            }

            verdi = node.verdi;

            node.forrige.neste = node.neste;
            node.neste.forrige = node.forrige;
        }
        antall--;
        endringer++;
        return verdi;
    }

    @Override
    public boolean fjern(T verdi) {

        if(verdi == null) {
            return false;
        }

        Node<T> node = hode;

        if (verdi.equals(node.verdi)) {
            if(node.neste != null) {
                hode = node.neste;
                hode.forrige = null;
            } else {
                hode = null;
                hale = null;
            }
            antall--;
            endringer++;
            return true;
        }

        node = hale;
        if (verdi.equals(node.verdi)) {
            hale = node.forrige;
            hale.neste = null;
            antall--;
            endringer++;
            return true;
        }

        node = hode.neste;
        for (; node != null; node = node.neste) {
            if (verdi.equals(node.verdi)) {
                node.forrige.neste = node.neste;
                node.neste.forrige = node.forrige;
                antall--;
                endringer++;
                return true;
            }
        }
        return false;
    }

    @Override
    public void nullstill() {
        int temp = antall;
        for (int i = 0; i < temp ; i++) {
            fjern(0);
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new DobbeltLenketListeIterator();
    }

    public Iterator<T> iterator(int indeks) {
        indeksKontroll(indeks, false);

        return new DobbeltLenketListeIterator(indeks);
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            denne = finnNode(indeks);
            fjernOK = false;
            iteratorendringer = endringer;
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        ////// Oppgave 8 //////
        @Override
        public T next() {
            if (iteratorendringer != endringer) {
                throw new ConcurrentModificationException("Endringer er feil");
            }
            if (!hasNext()) {
                throw new NoSuchElementException("Ingen flere igjen i liste");
            }

            fjernOK = true;

            T temp = denne.verdi;
            denne = denne.neste;

            return temp;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    //hjelpemetoder
    private void fratilKontroll (int antall, int fra, int til) {
        if (fra < 0 || til > antall) {
            throw new IndexOutOfBoundsException();
        }
        if (fra > til) {
            throw new IllegalArgumentException();
        }
    }


} // class DobbeltLenketListe



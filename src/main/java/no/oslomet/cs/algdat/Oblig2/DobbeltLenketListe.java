package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;


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

    public static void main(String[] args) {
        Character[] c = {'A','B','C','D','E','F','G','H','I','J',};
        DobbeltLenketListe<Character> liste = new DobbeltLenketListe<>(c);
        System.out.println(liste.subliste(3,8));  // [D, E, F, G, H]
        System.out.println(liste.subliste(5,5));  // []
        System.out.println(liste.subliste(8,liste.antall()));  // [I, J]
    }

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
        throw new UnsupportedOperationException();
    }



    @Override
    public void leggInn(int indeks, T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }


    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
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
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

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



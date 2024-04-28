package com.cleanCode.CCJen.ejercicio5;

import java.util.Set;

public class Euromillones {
    private Set<Integer> numerosPrincipal;
    private Set<Integer> numerosEstrella;

    public Euromillones() {
    }

    public Euromillones(Set<Integer> numerosPrincipal, Set<Integer> numerosEstrella) {
        this.numerosPrincipal = numerosPrincipal;
        this.numerosEstrella = numerosEstrella;
    }

    public Set<Integer> getNumerosPrincipal() {
        return numerosPrincipal;
    }

    public void setNumerosPrincipal(Set<Integer> numerosPrincipal) {
        this.numerosPrincipal = numerosPrincipal;
    }

    public Set<Integer> getNumerosEstrella() {
        return numerosEstrella;
    }

    public void setNumerosEstrella(Set<Integer> numerosEstrella) {
        this.numerosEstrella = numerosEstrella;
    }

    @Override
    public String toString() {
        return "Euromillones{" +
                "numerosPrincipal=" + numerosPrincipal +
                ", numerosEstrella=" + numerosEstrella +
                '}';
    }
}

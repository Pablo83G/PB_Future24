package com.cleanCode.CCJen.ejercicio3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticEqTest {

    @Test
    void calcQuadraticEqNoRoots() {
    QuadraticEq eq = new QuadraticEq();
        eq.calcQuadraticEq(1,-6,12);
        //La salida deberá ser "Equation has no roots"
    }
    @Test
    void calcQuadraticEqDistincRoots() {
        QuadraticEq eq = new QuadraticEq();
        eq.calcQuadraticEq(-2,8,-5);
        // La salida deberá ser x1 =0.78 x2=3.22

    }
    @Test
    void calcQuadraticEqRepeatRoot() {
        QuadraticEq eq = new QuadraticEq();
        eq.calcQuadraticEq(6,-24,24);
       // La salida deberá ser x= 2.0
    }



}
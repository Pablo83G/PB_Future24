<<<<<<< HEAD
package com.cleanCode.CCJen.ejercicio3;

public class QuadraticEq {
    public QuadraticEq() {
    }

    public void calcQuadraticEq(double a, double b, double c) {
        double discriminant = getDiscriminant(a,b,c);
        if (discriminant > 0) {
            getDistincRealRoots(a,b,discriminant);
        }else if (discriminant == 0) {
            getRepeatedRoot( a, b);
        }else {
            System.out.println("Equation has no roots");
        }
    }
    public void getDistincRealRoots(double a, double b, double discriminant){
        double x1= (-b - Math.sqrt(discriminant)) / (2 * a);
        double x2 = (-b + Math.sqrt(discriminant)) / (2 * a);
        System.out.println("x1 = " + x1 + ", x2 = " + x2);
    }
    public void getRepeatedRoot(double a, double b){
        double x = -b / (2 * a);
        System.out.println("x = " + x);
    }
    public double getDiscriminant(double a, double b, double c){
       return (b * b) - (4 * a * c);
    }

}
/**La importancia del discriminante radica en que nos dirá si la función cuadrática tiene o no raíces reales. Pueden darse tres casos:

 Si el discriminante es positivo, la función tiene dos raíces reales diferentes.
 Si el discriminante es cero, la función tiene una raíz real de multiplicidad 2.
 Si el discriminante es negativo, la función no tiene raíces reales.*/

=======
package com.cleanCode.CCJen.ejercicio3;

public class QuadraticEq {
    public QuadraticEq() {
    }

    public void calcQuadraticEq(double a, double b, double c) {
        double discriminant = getDiscriminant(a,b,c);
        if (discriminant > 0) {
            getDistincRealRoots(a,b,discriminant);
        }else if (discriminant == 0) {
            getRepeatedRoot( a, b);
        }else {
            System.out.println("Equation has no roots");
        }
    }
    public void getDistincRealRoots(double a, double b, double discriminant){
        double x1= (-b - Math.sqrt(discriminant)) / (2 * a);
        double x2 = (-b + Math.sqrt(discriminant)) / (2 * a);
        System.out.println("x1 = " + x1 + ", x2 = " + x2);
    }
    public void getRepeatedRoot(double a, double b){
        double x = -b / (2 * a);
        System.out.println("x = " + x);
    }
    public double getDiscriminant(double a, double b, double c){
       return (b * b) - (4 * a * c);
    }

}
/**La importancia del discriminante radica en que nos dirá si la función cuadrática tiene o no raíces reales. Pueden darse tres casos:

 Si el discriminante es positivo, la función tiene dos raíces reales diferentes.
 Si el discriminante es cero, la función tiene una raíz real de multiplicidad 2.
 Si el discriminante es negativo, la función no tiene raíces reales.*/

>>>>>>> origin/main

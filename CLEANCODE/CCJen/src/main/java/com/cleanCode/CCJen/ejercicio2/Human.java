<<<<<<< HEAD
package com.cleanCode.CCJen.ejercicio2;

class Human {
    private String name;
    private String age;
    private Address address;
    public String getFullAddress() {
       return this.address.formatAddress();
    }

}

/*En este caso aplicando el principio: Una clase debe tener una razón para cambiar es mejor crear dos clases
una con los datos propios de la persona y otra clase con los de la dirección
y de esta manera hacer que ambas clases colaboren y resulte más simple el mantenimiento del código
=======
package com.cleanCode.CCJen.ejercicio2;

class Human {
    private String name;
    private String age;
    private Address address;
    public String getFullAddress() {
       return this.address.formatAddress();
    }

}

/*En este caso aplicando el principio: Una clase debe tener una razón para cambiar es mejor crear dos clases
una con los datos propios de la persona y otra clase con los de la dirección
y de esta manera hacer que ambas clases colaboren y resulte más simple el mantenimiento del código
>>>>>>> origin/main
 */
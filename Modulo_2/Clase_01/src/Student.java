public class Student {
    private String nombre;
    private int age;
    private double prom;

    public Student(String nombre, int age, double prom) {
        this.nombre = nombre;
        this.age = age;
        this.prom = prom;
    }

    public void showDetails(){
        String details = String.format("""

                =======================================
                Nombre del Estudiante: %s.
                Edad del Estudiante: %d.
                Promedio de notas del Estudiante: %.2f.
                =======================================
                """, nombre, age, prom);
        System.out.print(details);
    }

    public boolean isAprobated(){
        boolean isAprobated = prom >= 3.0 ? true : false;
        return isAprobated;
    }
}

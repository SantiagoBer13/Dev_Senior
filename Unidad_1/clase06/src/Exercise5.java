import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise5 {
  static List<String> productos = Arrays.asList(
      "TabletX,LoteA,8",
      "SmartphoneY,LoteB,7",
      "SmartwatchZ,LoteC,6",
      "LaptopW,LoteD,9",
      "TabletX,LoteE,8");
  static List<String> inspecciones = Arrays.asList(
      "LoteA, funcionalidad, 85",
      "LoteB, seguridad, 92",
      "LoteC, funcionalidad, 75",
      "LoteD, seguridad, 60",
      "LoteA, seguridad, 88",
      "LoteC, seguridad, 82",
      "LoteB, funcionalidad, 80");

  static List<String> fallos = Arrays.asList(
      "LoteA, sobrecalentamiento, 3",
      "LoteB, pantalla, 5",
      "LoteC, batería, 2",
      "LoteD, sobrecalentamiento, 7",
      "LoteA, pantalla, 2");
  static Map<String, Double> indiceAprobacionLote;
  static Map<String, Map<String, List<Double>>> indiceAprobacionInspection;
  static Map<String, Map<String, Long>> failesFrecuentes;
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("\nControl de Calidad en una Fábrica de Electrónica (Avanzado)");
    String menu = """

        Menú
        1) Calcular el Índice de Aprobación por Lote.
        2) Identificar Lotes con Complejidad Alta y Baja Aprobación.
        3) Analizar los Tipos de Fallos Frecuentes.
        4) Obtener el Lote con Mayor Incidencia de Fallos.
        5) Evaluar la Calidad Promedio por Tipo de Inspección.
        6) Identificar Lotes con Fallos Críticos en Inspecciones Clave.
        7) Simulación de Mejora de Procesos.
        8) Salir.
        """;
    while (true) {
      System.out.print(menu);
      String option = sc.nextLine();
      switch (option) {
        case "1" -> showIndiceAprobationLote();
        case "2" -> ideLoComAltaBajaApro();
        case "3" -> showFailFrecuently();
        case "4" -> getLoteMayorFallos();
        case "5" -> calPromTypeInspection();
        case "6" -> ideLotFalCriticInspeccion();
        case "7" -> simulateImproveProcess();
        case "8" -> {
          System.out.println("Saliendo...");
          sc.close();
          return;
        }
        default -> System.out.println("Opción inválida. Intenta de nuevo.");
      }
    }
  }

  public static void calculateIndiceAprobationLote() {
    indiceAprobacionLote = inspecciones.stream()
        .map(registro -> registro.split(","))
        .collect(Collectors.groupingBy(
            inspeccion -> inspeccion[0],
            Collectors.averagingDouble(
                inspeccion -> Double.parseDouble(inspeccion[2]))));
  }

  public static void showIndiceAprobationLote() {
    calculateIndiceAprobationLote();
    System.out.println("\nÍndice de Aprobación por Lote");
    indiceAprobacionLote.entrySet().stream()
        .forEach(entry -> {
          System.out.printf("Lote: %s, Promedio de índice de aprobación: %.2f",
              entry.getKey(), entry.getValue());
          System.out.print(entry.getValue() < 80 ? " Atención Inmediata\n" : "\n");
        });
  }

  // ideLoComAltaBajaApro = Identificar Lotes con Complejidad Alta y Baja
  // Aprobación
  public static void ideLoComAltaBajaApro() {
    calculateIndiceAprobationLote();
    Map<String, Double> lotesComplejidadAlta = productos.stream()
        .map(registro -> registro.split(","))
        .filter(producto -> Integer.parseInt(producto[2]) > 7)
        .collect(Collectors.toMap(
            lote -> lote[1],
            lote -> Double.parseDouble(lote[2])));
    Map<String, Double> lotesIndiceBajo = indiceAprobacionLote.entrySet().stream()
        .filter(entry -> entry.getValue() < 85)
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue));

    System.out.println("\nLotes con alto riesgo de fallos:\n");
    lotesComplejidadAlta.entrySet().stream()
        .filter(entry -> lotesIndiceBajo.containsKey(entry.getKey()))
        .forEach(entry -> {
          String lote = entry.getKey();
          Double complejidad = entry.getValue();
          Double indice = lotesIndiceBajo.get(lote);
          System.out.printf(
              "Lote: %s, Complejidad: %.2f, Índice de aprobación: %.2f (Prioridad alta en control de calidad)%n",
              lote, complejidad, indice);
        });
  }

  public static void calculateFailFrecuently() {
    failesFrecuentes = fallos.stream()
        .map(registro -> registro.split(","))
        .collect(Collectors.groupingBy(
            fallo -> fallo[0],
            Collectors.groupingBy(
                fallo -> fallo[1],
                Collectors.counting())));
  }

  public static void showFailFrecuently() {
    calculateFailFrecuently();
    System.out.println("\nTipos de Fallos Frecuentes:\n");
    failesFrecuentes.forEach((lote, fallosPorTipo) -> {
      System.out.printf("Lote: %s%n", lote);
      fallosPorTipo.forEach((tipoFallo, cantidad) -> System.out.printf(
          "  Tipo de fallo: %s, cantidad: %d%n",
          tipoFallo, cantidad));
    });
  }

  public static void getLoteMayorFallos() {
    System.out.println("\nLote con Mayor Incidencia de Fallos:\n");

    Map<String, Map<String, Integer>> lotCountInci = fallos.stream()
        .map(registro -> registro.split(","))
        .collect(Collectors.groupingBy(
            fallo -> fallo[0],
            Collectors.groupingBy(
                fallo -> fallo[1],
                Collectors.summingInt(fallo -> Integer
                    .parseInt(fallo[2].trim())))));

    // lotCountInci.forEach((lote, fallosPorLote) -> {
    // System.out.printf("Lote: %s%n", lote);
    // fallosPorLote
    // .forEach((fallo, cantidad) -> System.out.printf(" Fallo: %s, Cantidad: %d%n",
    // fallo, cantidad));
    // });

    Map.Entry<String, Map<String, Integer>> loteMayor = lotCountInci.entrySet().stream()
        .max(Comparator
            .comparingInt(entry -> entry.getValue().values().stream()
                .mapToInt(Integer::intValue).sum()))
        .orElse(null);

    String lote = loteMayor.getKey();
    Map<String, Integer> fallosPorLote = loteMayor.getValue();

    System.out.printf("Lote con Mayor Incidencia: %s%n", lote);
    fallosPorLote
        .forEach((fallo, cantidad) -> System.out.printf("    Fallo: %s, Cantidad: %d%n", fallo,
            cantidad));

    int totalIncidencias = fallosPorLote.values().stream().mapToInt(Integer::intValue).sum();
    System.out.printf("Total de incidencias: %d%n", totalIncidencias);
  }

  public static void calPromTypeInspection() {
    System.out.println("\nCalidad Promedio por Tipo de Inspección:\n");
    Map<String, Double> promTypeInspection = inspecciones.stream().map(row -> row.split(","))
        .collect(Collectors.groupingBy(
            inspection -> inspection[1],
            Collectors.averagingDouble(
                inspection -> Double
                    .parseDouble(inspection[2].trim()))));
    promTypeInspection.entrySet().forEach(entry -> {
      String typeInspection = entry.getKey();
      Double prom = entry.getValue();
      System.out.printf(
          "Inspection: %s, Promedio de aprobación: %.2f.%n",
          typeInspection, prom);
    });

    Map.Entry<String, Double> inspeccionConPromedioMasBajo = promTypeInspection.entrySet().stream()
        .min(Comparator.comparingDouble(Map.Entry::getValue))
        .orElse(null);

    if (inspeccionConPromedioMasBajo != null) {
      System.out.printf(
          "El tipo de inspección con el promedio más bajo es '%s' con un promedio de %.2f.%n",
          inspeccionConPromedioMasBajo.getKey(),
          inspeccionConPromedioMasBajo.getValue());

      System.out.println(
          "puede necesitar ajustes en los criterios de prueba o procesos de inspección.");
    }
  }

  public static void ideLotFalCriticInspeccion() {
    calculateFailFrecuently();
    Map<String, Double> lotFallCritic = inspecciones.stream()
        .map(row -> row.split(","))
        .filter(row -> Double.parseDouble(row[2].trim()) < 75)
        .collect(Collectors.toMap(
            lote -> lote[0],
            lote -> Double.parseDouble(lote[2])));

    System.out.println("\nLotes con Fallos Críticos en Inspecciones de Seguridad:\n");

    lotFallCritic.forEach((lote, aprobacion) -> {
      System.out.printf("Lote: %s, Aprobación: %.2f%% - Fallo Crítico%n", lote, aprobacion);

      Map<String, Long> fallosAsociados = failesFrecuentes.get(lote);

      if (fallosAsociados != null && !fallosAsociados.isEmpty()) {
        fallosAsociados.forEach((fallo, cantidad) -> System.out
            .printf("    Tipo de Fallo: %s.%n", fallo));
      } else {
        System.out.println("    No se encontraron fallos asociados para este lote.");
      }
    });
  }

  public static void calculateIndiceAprobationInspection() {
    indiceAprobacionInspection = inspecciones.stream()
        .map(registro -> registro.split(","))
        .collect(Collectors.groupingBy(
            registro -> registro[0].trim(),
            Collectors.groupingBy(
                registro -> registro[1].trim(),
                Collectors.mapping(
                    registro -> Double.parseDouble(
                        registro[2].trim()),
                    Collectors.toList()))));
  }

  public static void simulateImproveProcess() {
    calculateIndiceAprobationInspection();

    List<String> lotes = productos.stream()
        .map(row -> row.split(","))
        .filter(row -> Double.parseDouble(row[2].trim()) > 7)
        .map(row -> row[1].trim())
        .collect(Collectors.toList());

    System.out.println("\nSimulación de Mejora de Procesos:\n");

    lotes.forEach(lote -> {
      if (indiceAprobacionInspection.containsKey(lote)) {
        Map<String, List<Double>> inspeccionesPorLote = indiceAprobacionInspection.get(lote);

        inspeccionesPorLote.forEach((tipoInspeccion, aprobaciones) -> {
          double promedioAprobacion = aprobaciones.stream()
              .mapToDouble(Double::doubleValue)
              .average()
              .orElse(0.0);

          double nuevaAprobacion = promedioAprobacion + 5;

          System.out.printf(
              "Lote: %s, Inspección: %s, Porcentaje Aprobación anterior: %.2f, Nuevo Porcentaje Aprobación: %.2f.%n",
              lote, tipoInspeccion, promedioAprobacion, nuevaAprobacion);
        });
      } else {
        System.out.printf("Lote: %s no tiene inspecciones registradas.%n", lote);
      }
    });
  }
}
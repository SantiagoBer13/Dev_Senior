package Exercise_2;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<MonitoringSystem> monitoringSystems = Arrays.asList(
            createMonitoringSystem("Iniciando monitoreo de rendimiento..."),
            createMonitoringSystem("Iniciando monitoreo de errores..."),
            createMonitoringSystem("Iniciando monitoreo de seguridad...")
        );

        monitoringSystems.forEach(MonitoringSystem::startMonitoring);
    }

    private static MonitoringSystem createMonitoringSystem(String message) {
        return new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println(message);
            }
        };
    }
}

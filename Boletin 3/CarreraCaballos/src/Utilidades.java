public class Utilidades {
        /*
        limpiarConsola()
        ANALISIS: Limpiara la consola para facilitar la lectura.
        PRECONDICIONES: -
        ENTRADAS: -
        SALIDAS: -
        POSTCONDICIONES: - //Thread.sleep(2000);
        */
        public static void limpiarConsola() {
            try {
                final String sistemaOperativo = System.getProperty("os.name");

                if (sistemaOperativo.contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    Runtime.getRuntime().exec("clear");
                }
            } catch (final Exception e) {
                System.out.println("Error: No se pudo limpiar la consola. "+e);
            }

        }
    }
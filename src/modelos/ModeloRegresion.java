package modelos;

import datos.Dataset;


public class ModeloRegresion extends Modelo {

    private int grado;

    public ModeloRegresion(String nombre, int maxEpocas, int grado) {
        super(nombre, maxEpocas);
        this.grado = grado;
    }

    @Override
    public double entrenar(Dataset dataset) {
        // Obtenemos la cantidad máxima de épocas
        int maxEpocas = getLossPorEpoca().length;

        // Simulamos un loss inicial que dependa del grado del polinomio
        int lossSimulado = grado * 50;

        for (int i = 0; i < maxEpocas; i++) {

            registrarEpoca(lossSimulado);

            lossSimulado -= 5;
        }

        // Retornamos el mejor loss alcanzado que calculó la clase padre
        return mejorLoss();
    }

    public int getGrado() { return grado; }
}
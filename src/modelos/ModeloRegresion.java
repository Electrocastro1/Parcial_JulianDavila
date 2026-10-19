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

        int maxEpocas = getLossPorEpoca().length;

        int lossSimulado = grado * 50;

        for (int i = 0; i < maxEpocas; i++) {

            registrarEpoca(lossSimulado);

            lossSimulado -= 5;
        }


        return mejorLoss();
    }

    public int getGrado() { return grado; }
}
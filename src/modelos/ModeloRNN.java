package modelos;

import datos.Dataset;

/**
 * Modelo RNN. Hiperparámetro: número de capas.
 */
public class ModeloRNN extends Modelo {

    private int numCapas;

    public ModeloRNN(String nombre, int maxEpocas, int numCapas) {
        super(nombre, maxEpocas);
        this.numCapas = numCapas;
    }

    @Override
    public double entrenar(Dataset dataset) {
        int maxEpocas = getLossPorEpoca().length;

        int lossSimulado = numCapas * 75;

        for (int i = 0; i < maxEpocas; i++) {
            registrarEpoca(lossSimulado);

            lossSimulado -= 8;
        }

        return mejorLoss();
    }

    public int getNumCapas() { return numCapas; }
}

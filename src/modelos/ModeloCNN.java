package modelos;

import datos.Dataset;


public class ModeloCNN extends Modelo {

    private int numFiltros;

    public ModeloCNN(String nombre, int maxEpocas, int numFiltros) {
        super(nombre, maxEpocas);
        this.numFiltros = numFiltros;
    }


    @Override
    public double entrenar(Dataset dataset) {

        int maxEpocas = getLossPorEpoca().length;


        int lossSimulado = numFiltros * 100;

        for (int i = 0; i < maxEpocas; i++) {

            registrarEpoca(lossSimulado);


            lossSimulado -= 10;
        }


        return mejorLoss();
    }

    public int getNumFiltros() { return numFiltros; }
}
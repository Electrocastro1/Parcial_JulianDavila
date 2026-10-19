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
        // Obtenemos la cantidad máxima de épocas de la longitud del arreglo
        int maxEpocas = getLossPorEpoca().length;

        // Simulamos un loss inicial proporcional al número de filtros
        int lossSimulado = numFiltros * 100;

        for (int i = 0; i < maxEpocas; i++) {
            // Registramos el loss en la clase padre
            registrarEpoca(lossSimulado);

            // Decrementamos el loss para simular el aprendizaje (mejora) del modelo
            lossSimulado -= 10;
        }

        // Retornamos el mejor loss alcanzado que se calculó en el padre
        return mejorLoss();
    }

    public int getNumFiltros() { return numFiltros; }
}
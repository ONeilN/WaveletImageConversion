package com.nugumanov.wavelettransform.transforms;

public interface Transform {

    void FWT(double[] data);

    void FWT(double[][] data, int iterations, int width, int height);

    void IWT(double[] data);

    void IWT(double[][] data, int iterations, int width, int height);
}

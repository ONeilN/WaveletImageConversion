package com.nugumanov.wavelettransform;

import com.nugumanov.wavelettransform.transforms.WaveletType;
import com.nugumanov.wavelettransform.transforms.HaarWaveletTransform;
import com.nugumanov.wavelettransform.transforms.WaveletTransform;

public class WaveletFactory {

    public static WaveletTransform getTransform(WaveletType wavelet) {
        switch (wavelet) {
            case HAAR : return new HaarWaveletTransform();
            default : return null;
        }
    }
}

package com.nugumanov.wavelettransform;

import com.nugumanov.wavelettransform.transforms.HaarTransform;
import com.nugumanov.wavelettransform.transforms.Transform;

public class WaveletFactory {

    public static Transform getTransform(WaveletType wavelet) {
        switch (wavelet) {
            case HAAR : return new HaarTransform();
            default : return null;
        }
    }
}

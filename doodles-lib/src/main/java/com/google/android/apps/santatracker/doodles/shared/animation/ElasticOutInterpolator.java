/*
 * Copyright 2019. Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.apps.santatracker.doodles.shared.animation;

import android.view.animation.Interpolator;

/**
 * An interpolator which has a rubber bound effect around its end point, bouncing back and forth
 * before settling at its final value.
 *
 * <p>Implementation copied from outElastic here: https://goo.gl/SJZllG
 */
public class ElasticOutInterpolator implements Interpolator {

    private final float period;

    public ElasticOutInterpolator() {
        period = 0.4f;
    }

    public ElasticOutInterpolator(float period) {
        this.period = period;
    }

    @Override
    public float getInterpolation(float value) {
        return (float)
                (Math.pow(2, -10 * value) * Math.sin((value - period / 4) * (2 * Math.PI) / period)
                        + 1);
    }
}

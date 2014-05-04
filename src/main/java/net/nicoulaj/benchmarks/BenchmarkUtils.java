/*
 * Copyright (c) 2012-2014 Julien Nicoulaud <julien.nicoulaud@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.nicoulaj.benchmarks;

import java.util.Random;

public final class BenchmarkUtils {

    private static final Random RANDOM = new Random();

    public static int rndInt() {
        return RANDOM.nextInt();
    }

    public static long rndLong() {
        return RANDOM.nextLong();
    }

    public static float rndFloat() {
        while (true) {
            final float f = Float.intBitsToFloat(RANDOM.nextInt());
            if (f < Float.POSITIVE_INFINITY && f > Float.NEGATIVE_INFINITY)
                return f;
        }
    }

    public static double rndDouble() {
        while (true) {
            final double d = Double.longBitsToDouble(RANDOM.nextLong());
            if (d < Double.POSITIVE_INFINITY && d > Double.NEGATIVE_INFINITY)
                return d;
        }
    }

    public static int[] rndIntArray(int length) {
        final int[] data = new int[length];
        for (int i = 0; i < data.length - 1; i++)
            data[i] = rndInt();
        return data;
    }

    public static long[] rndLongArray(int length) {
        final long[] data = new long[length];
        for (int i = 0; i < data.length - 1; i++)
            data[i] = rndLong();
        return data;
    }

    public static float[] rndFloatArray(int length) {
        final float[] data = new float[length];
        for (int i = 0; i < data.length - 1; i++)
            data[i] = rndFloat();
        return data;
    }

    public static double[] rndDoubleArray(int length) {
        final double[] data = new double[length];
        for (int i = 0; i < data.length - 1; i++)
            data[i] = rndDouble();
        return data;
    }
}

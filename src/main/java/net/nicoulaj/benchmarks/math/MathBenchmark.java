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
package net.nicoulaj.benchmarks.math;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.logic.BlackHole;

import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static net.nicoulaj.benchmarks.BenchmarkUtils.rndDoubleArray;
import static org.openjdk.jmh.annotations.Level.Iteration;
import static org.openjdk.jmh.annotations.Mode.AverageTime;
import static org.openjdk.jmh.annotations.Scope.Thread;

@State(Thread)
@BenchmarkMode(AverageTime)
@OutputTimeUnit(NANOSECONDS)
@Warmup(iterations = 3, time = 2, timeUnit = SECONDS)
@Measurement(iterations = 5, time = 4, timeUnit = SECONDS)
@Fork(1)
@Threads(1)
public abstract class MathBenchmark {

    protected static final int DATA_SIZE = 1024 * 1024;

    @State(Thread)
    @OperationsPerInvocation(DATA_SIZE)
    public static class Calibration extends MathBenchmark {

        private double[] data;

        @Setup(Iteration)
        public void setup() {
            data = rndDoubleArray(DATA_SIZE);
        }

        @GenerateMicroBenchmark
        public void calibration(BlackHole hole) {
            for (int i = 0; i < data.length - 1; i++)
                hole.consume(data[i]);
        }
    }
}

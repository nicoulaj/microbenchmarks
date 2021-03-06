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

import org.apache.commons.math3.util.FastMath;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OperationsPerInvocation;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.logic.BlackHole;

import static net.nicoulaj.benchmarks.math.MathBenchmark.DATA_SIZE;
import static org.openjdk.jmh.annotations.Level.Iteration;
import static net.nicoulaj.benchmarks.BenchmarkUtils.*;

@OperationsPerInvocation(DATA_SIZE / 2)
public class IntMin extends MathBenchmark {

    private int[] data;

    @Setup(Iteration)
    public void setup() {
        data = rndIntArray(DATA_SIZE);
    }

    @GenerateMicroBenchmark
    public void math(BlackHole hole) {
        for (int i = 1; i < data.length - 1; i += 2)
            hole.consume(Math.min(data[i - 1], data[i]));
    }

    @GenerateMicroBenchmark
    public void strictmath(BlackHole hole) {
        for (int i = 1; i < data.length - 1; i += 2)
            hole.consume(StrictMath.min(data[i - 1], data[i]));
    }

    @GenerateMicroBenchmark
    public void commonsmath(BlackHole hole) {
        for (int i = 1; i < data.length - 1; i += 2)
            hole.consume(FastMath.min(data[i - 1], data[i]));
    }
}

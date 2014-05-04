microbenchmarks [![Build Status](https://travis-ci.org/nicoulaj/microbenchmarks.svg)](https://travis-ci.org/nicoulaj/microbenchmarks)
===============

**Java microbenchmarks sandbox.**


<table>
  <tr>
    <th>Package</th>
    <th>Description</th>
    <th>To run</th>
  </tr>
  <tr>
    <td><code>collections</code></td>
    <td>Collections benchmark.</td>
    <td><code>mvn verify -Dbenchmarks='*.collections.*'</code></td>
  </tr>
  <tr>
    <td><code>iterators</code></td>
    <td>Fastest way to iterate array benchmark.</td>
    <td><code>mvn verify -Dbenchmarks='*.iterators.*'</code></td>
  </tr>
  <tr>
    <td><code>lambdas</code></td>
    <td>Lambdas vs anonymous classes benchmark.</td>
    <td><code>mvn verify -Dbenchmarks='*.lambdas.*'</code></td>
  </tr>
  <tr>
    <td><code>math</code></td>
    <td><code>java.lang.Math</code> benchmark.</td>
    <td><code>mvn verify -Dbenchmarks='*.math.*'</code></td>
  </tr>
</table>

See notes in each `package-info.java`.

Results go to `target/microbenchmarks.csv`.

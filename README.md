# advent-of-code-2022

This repository contains the solutions for the challenges found under the Advent of Code 2022 project.

My goal was not to find the fastest solution, but rather to simulate some challenges one has to
solve in a production-ready software.

Production-ready attributes:

* TDD
* Module reusability
* Clean-code principles

Missing production-ready attributes:

* Proper error handling & testing the non-happy path
* Modules are not always easily extendable
* Separate text-based configuration

I put a comment where I thought there would be place for improvement if the code were used in production.

## Prerequisites

* OpenJDK 17.0.5
* Apache Maven 3.8.6

## Run

In order to calculate the results, run the command below:

```
mvn exec:java
```

## Test
Run the below command to run the tests:
```
mvn test
```

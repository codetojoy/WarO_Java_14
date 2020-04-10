<!--
[![Build Status](https://travis-ci.org/peidevs/WarO_Java.svg?branch=master)](https://travis-ci.org/peidevs/WarO_Java)
-->

WarO_Java
=========

a Java submission for War-O as a code exercise

* this project uses Java 8 streams, Java 10 `var`, and Java 14 (preview) `record`
* goals include: a functional style, immutable objects, minimal use of for-loops
* Spring's Java configuration is used to configure players

To Build:
---------

* requires JDK 14

useful commands:

* `./gradlew clean test`
    - on Windows, use `gradlew.bat`
* `./gradlew run`
* `./gradlew build`

See test output in `~/build/reports/tests/index.html`

See executable zip in `~/build/distributions`

To Run:
---------

* configure `src/main/java/org/peidevs/waro/config/Config.java`
* `./gradlew run`
    - on Windows, use `gradlew.bat`

Rules:
---------

Rules are [here](Rules.md).

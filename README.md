# quarkus-spi-test-dependency
reproduce issue logged [https://github.com/quarkusio/quarkus/issues/8242](https://github.com/quarkusio/quarkus/issues/8242)

To test the app

```
run mvn clean install
```
This will fail with `Exception: java.lang.RuntimeException: More than one IGreeter implementation found, verify classpath, only one IGreeter implementation should exist`

if you change the quarkus version to 1.2.0-Final in the `sample-quarkus-app` pom, the test will succeed.
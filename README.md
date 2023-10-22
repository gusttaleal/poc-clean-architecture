## Mutation test

To run PITest, mutation test tool, run:

```shell
mvn test-compile org.pitest:pitest-maven:mutationCoverage
```

## Shell command

To make sure things are clear, run:

```shell
mvn clean && mvn install && mvn package
```
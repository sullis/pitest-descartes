# How to...?

This file contains configuration snippets for Maven and Gradle using different configurations.

## Maven

### Minimal configuration

```xml
<plugin>
  <groupId>org.pitest</groupId>
  <artifactId>pitest-maven</artifactId>
  <version>1.5.2</version>
  <configuration>
    <mutationEngine>descartes</mutationEngine>
  </configuration>
  <dependencies>
    <dependency>
      <groupId>eu.stamp-project</groupId>
      <artifactId>descartes</artifactId>
      <version>1.3</version>
    </dependency>
  </dependencies>
</plugin>
```

### Using JUnit 5

```xml
<plugin>
  <groupId>org.pitest</groupId>
  <artifactId>pitest-maven</artifactId>
  <version>1.5.2</version>
  <configuration>
    <mutationEngine>descartes</mutationEngine>
  </configuration>
  <dependencies>
    <dependency>
      <groupId>eu.stamp-project</groupId>
      <artifactId>descartes</artifactId>
      <version>1.3</version>
    </dependency>
    <dependency>
        <groupId>org.pitest</groupId>
        <artifactId>pitest-junit5-plugin</artifactId>
        <version>0.12</version>
    </dependency>
  </dependencies>
</plugin>
```

### Using TestNG

```xml
<plugin>
  <groupId>org.pitest</groupId>
  <artifactId>pitest-maven</artifactId>
  <version>1.5.2</version>
  <configuration>
    <mutationEngine>descartes</mutationEngine>
    <testPlugin>testng</testPlugin>
  </configuration>
  <dependencies>
    <dependency>
      <groupId>eu.stamp-project</groupId>
      <artifactId>descartes</artifactId>
      <version>1.3</version>
    </dependency>
  </dependencies>
</plugin>
```

### Using a custom selection of operators

```xml
<plugin>
  <groupId>org.pitest</groupId>
  <artifactId>pitest-maven</artifactId>
  <version>1.5.2</version>
  <configuration>
    <mutationEngine>descartes</mutationEngine>
    <mutators>
        <mutator>void</mutator>
        <mutator>4</mutator>
        <mutator>"some string"</mutator>
    <mutator>false</mutator>
</mutators>
  </configuration>
  <dependencies>
    <dependency>
      <groupId>eu.stamp-project</groupId>
      <artifactId>descartes</artifactId>
      <version>1.3</version>
    </dependency>
  </dependencies>
</plugin>
```

### Output formats

<plugin>
  <groupId>org.pitest</groupId>
  <artifactId>pitest-maven</artifactId>
  <version>1.5.2</version>
  <configuration>
    <outputFormats>
      <value>JSON</value>
      <value>METHODS</value>
      <value>ISSUES</value>
    </outputFormats>
    <mutationEngine>descartes</mutationEngine>
  </configuration>
    <dependencies>
    <dependency>
      <groupId>eu.stamp-project</groupId>
      <artifactId>descartes</artifactId>
      <version>1.3</version>
    </dependency>
  </dependencies>
</plugin>

### Including some stops methods in the analysis

<plugin>
  <groupId>org.pitest</groupId>
  <artifactId>pitest-maven</artifactId>
  <version>1.5.2</version>
  <configuration>
    <features>
        <feature>
            +STOP_METHODS(except[to_string] except[enum])
        </feature>
    </features>
    <mutationEngine>descartes</mutationEngine>
  </configuration>
    <dependencies>
    <dependency>
      <groupId>eu.stamp-project</groupId>
      <artifactId>descartes</artifactId>
      <version>1.3</version>
    </dependency>
  </dependencies>
</plugin>

### Disabling `DO_NOT_MUTATE`

<plugin>
  <groupId>org.pitest</groupId>
  <artifactId>pitest-maven</artifactId>
  <version>1.5.2</version>
  <configuration>
    <features>
        <feature>
            -DO_NOT_MUTATE()
        </feature>
    </features>
    <mutationEngine>descartes</mutationEngine>
  </configuration>
    <dependencies>
    <dependency>
      <groupId>eu.stamp-project</groupId>
      <artifactId>descartes</artifactId>
      <version>1.3</version>
    </dependency>
  </dependencies>
</plugin>

## Gradle

### Minimal configuration

```
plugins {
    id 'java'
    id 'info.solidsoft.pitest' version '1.5.1'
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation group: 'junit', name: 'junit', version: '4.13.1'
    pitest 'eu.stamp-project:descartes:1.3'
}

pitest {
  mutationEngine = "descartes"
  pitestVersion = "1.5.2"
}
```

### Using JUnit 5
```
plugins {
    id 'java'
    id 'info.solidsoft.pitest' version '1.5.1'
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation group: 'junit', name: 'junit', version: '4.13.1'
    pitest 'eu.stamp-project:descartes:1.3'
}

pitest {
  mutationEngine = "descartes"
  pitestVersion = "1.5.2"
  junit5PluginVersion = '0.12'
}
```

### Using TestNG

```
plugins {
    id 'java'
    id 'info.solidsoft.pitest' version '1.5.1'
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation group: 'junit', name: 'junit', version: '4.13.1'
    pitest 'eu.stamp-project:descartes:1.3'
}

pitest {
  mutationEngine = "descartes"
  pitestVersion = "1.5.2"
  testPlugin = "testng"
}
```

### Using a custom selection of operators

```
plugins {
    id 'java'
    id 'info.solidsoft.pitest' version '1.5.1'
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation group: 'junit', name: 'junit', version: '4.13.1'
    pitest 'eu.stamp-project:descartes:1.3'
}

pitest {
  mutationEngine = "descartes"
  pitestVersion = "1.5.2"
  mutators = [ '1.2', 'true', 'optional', '"a"' ]
}
```

### Including some stops methods in the analysis

```
plugins {
    id 'java'
    id 'info.solidsoft.pitest' version '1.5.1'
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation group: 'junit', name: 'junit', version: '4.13.1'
    pitest 'eu.stamp-project:descartes:1.3'
}

pitest {
  mutationEngine = "descartes"
  pitestVersion = "1.5.2"
  features = ['+STOP_METHODS()']
}
```

### Disabling `DO_NOT_MUTATE`

```
plugins {
    id 'java'
    id 'info.solidsoft.pitest' version '1.5.1'
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation group: 'junit', name: 'junit', version: '4.13.1'
    pitest 'eu.stamp-project:descartes:1.3'
}

pitest {
  mutationEngine = "descartes"
  pitestVersion = "1.5.2"
  features = ['-DO_NOT_MUTATE()']
}
```

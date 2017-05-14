## Maven Fitnesse Integration

- For launching fitnesse from mvn

```
mvn -Pfitnesse test
```


- Add Fitnesse jar as project dependency

```xml
<!-- https://mvnrepository.com/artifact/org.fitnesse/fitnesse -->
<dependency>
  <groupId>org.fitnesse</groupId>
  <artifactId>fitnesse</artifactId>
  <version>20161106</version>
</dependency>
```


- add profile to launch fitnesse from mvn. Also add `maven-classpath-plugin` dependency so that you dont have add individual dependency to fitnesse

```xml
  <profiles>
    <profile>
      <id>fitnesse</id>
      <build>
        <plugins>
          <plugin>
            <artifactId>maven-antrun-plugin</artifactId>
            <version>1.6</version>
            <executions>
              <execution>
                <id>start-fitnesse</id>
                <phase>test</phase>
                <configuration>
                  <tasks>
                    <echo taskname="fitnesse" message="Starting FitNesse..." />
                    <java classname="fitnesseMain.FitNesseMain" classpathref="maven.runtime.classpath" fork="true">
                      <arg line="-p 8000" />
                      <arg line="-d ." />
                    </java>
                  </tasks>
                </configuration>
                <goals>
                  <goal>run</goal>
                </goals>
              </execution>
            </executions>
          </plugin>
        </plugins>
      </build>
      <dependencies>
        <dependency>
          <groupId>org.fitnesse.plugins</groupId>
          <artifactId>maven-classpath-plugin</artifactId>
          <version>1.9</version>
          <scope>runtime</scope>
        </dependency>
      </dependencies>
    </profile>
  </profiles>
```

- add plugins.properties

```
# plugins.properties: Configuration for FitNesse
SymbolTypes = fitnesse.wikitext.widgets.MavenClasspathSymbolType
```

- add dependency to wiki file by just adding one line

```
!pomFile pom.xml
```

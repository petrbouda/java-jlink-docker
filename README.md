- `maven-jlink-plugin` can be also used but needs to be packaged on the same platform or use targeting:
- at the time of writing this example plugin does not support targeting other platforms (not easily at least)

https://stackoverflow.com/questions/47593409/create-java-runtime-image-on-one-platform-for-another-using-jlink

```
java -p module-a/target/module-a-1.0-SNAPSHOT.jar:module-b/target/module-b-1.0-SNAPSHOT.jar -m moduleb/pbouda.Printer
```

Local jLink execution:
```bash
jlink --module-path module-docker/target/dependency/:$JAVA_HOME/jmods \
        --add-modules moduleb \
        --launcher run=moduleb/pbouda.Printer \
        --output dist \
        --compress 2 \
        --strip-debug \
        --no-header-files \
        --no-man-pages
```

Inspect docker container (Linux-based): 
```bash
docker run -it --entrypoint /bin/bash modules-test
```



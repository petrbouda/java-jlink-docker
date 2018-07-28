FROM openjdk:10-jdk AS builder

WORKDIR /app

COPY maven .

RUN jlink --module-path modules/:$JAVA_HOME/jmods \
        --add-modules moduleb \
        --launcher run=moduleb/pbouda.Printer \
        --output dist \
        --compress 2 \
        --strip-debug \
        --no-header-files \
        --no-man-pages

FROM openjdk:10-jre

WORKDIR /app

COPY --from=builder /app/dist/ ./

ENTRYPOINT ["bin/run"]
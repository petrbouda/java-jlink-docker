#FROM openjdk:12-alpine AS builder
FROM dperezcabrera/openjdk11-alpine AS builder

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

FROM alpine:3.8

WORKDIR /app

COPY --from=builder /app/dist/ ./

ENTRYPOINT ["bin/run"]
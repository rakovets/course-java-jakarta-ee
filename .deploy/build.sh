#!/bin/sh
echo "Build *.war for web-application"
# shellcheck disable=SC2038
find . -name "*.java" -print | xargs javac -cp lib/javax.servlet-api-4.0.1.jar
jar -cvf web-static-app.war -C 01-web-static-app .
jar -cvf web-dynamic-app.war -C 02-web-dynamic-app .
jar -cvf web-dynamic-modern-app.war -C 02-web-dynamic-modern-app .
find . -name '*.class' -delete

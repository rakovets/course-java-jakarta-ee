#!/bin/sh
echo "Build *.war for web-application"
# shellcheck disable=SC2038
find . -name "*.java" -print | xargs javac -cp web-dynamic-app/WEB-INF/lib/javax.servlet-api-4.0.1.jar
jar -cvf web-static-app.war -C web-static-app .
jar -cvf web-dynamic-app.war -C web-dynamic-app .
jar -cvf web-dynamic-modern-app.war -C web-dynamic-modern-app .

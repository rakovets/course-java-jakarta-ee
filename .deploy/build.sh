#!/bin/sh
echo "Build *.war for web-application"
jar -cvf web-static-app.war -C web-static-app .
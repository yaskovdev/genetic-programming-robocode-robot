mvn clean compile assembly:single
rm "$env:ROBOCODE_HOME\robots\*.jar" -r -force
rm "$env:ROBOCODE_HOME\robots\robot.database" -r -force
cp "target\robocode-push-*.jar" "$env:ROBOCODE_HOME\robots"

mvn clean compile assembly:single
$Robots = "$env:ROBOCODE_HOME\robots"
rm "$Robots\*.jar" -r -force
if (Test-Path "$Robots\robot.database")
{
    rm "$Robots\robot.database" -r -force
}
cp "target\robocode-push-*.jar" $Robots

echo "Installed robot to $Robots"
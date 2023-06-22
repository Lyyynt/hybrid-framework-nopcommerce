cd ..
cd libraries
set ProjectPath=%~dp0
java -jar selenium-server-standalone-3.141.59.jar -port 4444 -role hub -hubConfig "%ProjectPath%\hub.json"
pause
cd ..
cd libraries
set ProjectPath=%~dp0
java -jar libraries\webdrivermanager-5.3.1-fat.jar resolveDriverFor chrome
java -jar libraries\webdrivermanager-5.3.1-fat.jar resolveDriverFor firefox
java -jar -Dwebdriver.chrome.driver="%ProjectPath%\chromedriver.exe" -Dwebdriver.gecko.driver="%ProjectPath%\geckodriver.exe" selenium-server-standalone-3.141.59.jar -role node -nodeConfig "%ProjectPath%\node.json" -port 5555
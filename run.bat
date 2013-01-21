@ECHO OFF
color 02
title IRCBot
java -Xmx250M -Xms50M -Djava.net.preferIPv4Stack=true -Djava.net.preferIPv6Addresses=false -jar "dist/IRC.jar"
pause
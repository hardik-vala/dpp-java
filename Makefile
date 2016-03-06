compile: reset
	javac -d bin src/problems/*.java

reset:
	rm -rf bin/*.class

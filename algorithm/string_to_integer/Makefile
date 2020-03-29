title := StringToInteger
all: $(title).class

$(title).class: *.java
	javac *.java

again:
	javac *.java

edit:
	emacs -nw $(title).java

run: $(title).class
	java $(title)

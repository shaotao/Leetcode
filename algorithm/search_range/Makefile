title := SearchRange

all: $(title).class

$(title).class: *.java
	javac *.java

again:
	javac *.java

edit:
	emacs SearchRange.java

run: $(title).class
	java $(title)


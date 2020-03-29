title := ShortestCompletingWord
all: $(title).class

$(title).class: *.java
	javac *.java

again:
	javac *.java

edit:
	emacs $(title).java

run: $(title).class
	java $(title)

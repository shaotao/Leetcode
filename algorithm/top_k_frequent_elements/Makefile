title := TopKFrequentElements
all: $(title).class

$(title).class: *.java
	javac -Xdiags:verbose *.java

again:
	javac -Xdiags:verbose *.java

edit:
	emacs $(title).java

run: $(title).class
	java $(title)

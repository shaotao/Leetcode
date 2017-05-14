title := FlattenNestedListIterator
all: $(title).class

flags=-Xlint:unchecked -Xdiags:verbose

$(title).class: *.java
	javac $(flags) *.java

again:
	javac $(flags) *.java

edit:
	emacs $(title).java

run: $(title).class
	java $(title)

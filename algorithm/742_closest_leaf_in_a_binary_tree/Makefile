title := ClosestLeafInABinaryTree
all: $(title).class

$(title).class: *.java
	javac *.java

again:
	javac -Xlint:unchecked *.java

edit:
	emacs $(title).java

run: $(title).class
	java $(title)

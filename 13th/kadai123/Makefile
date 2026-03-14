.SUFFIXES: .java .class

JAVAC	= javac
JAVA	= java
SRC	= $(wildcard *.java)
CLASS	= $(SRC:.java=.class)
PROGRAM	= $(shell pwd)

all: $(CLASS)

test:;
	@echo 今回は make test は使用できません。make kadai1, make kadai2, make kadai3 で課題チェックが動くようMakefileを編集してください。
	
kadai1: GraphTester.java
	$(JAVA) GraphTester sample.txt
kadai2: DijkstraTester.java
	$(JAVA) DijkstraTester sample.txt
kadai3: PQDijkstraTester.java
	$(JAVA) PQDijkstraTester sample.txt

.java.class:
	$(JAVAC) $<

clean:;	\rm -f *.class

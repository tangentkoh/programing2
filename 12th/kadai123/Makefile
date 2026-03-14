.SUFFIXES: .java .class

JAVAC	= javac
JAVA	= java
SRC	= $(wildcard *.java)
CLASS	= $(SRC:.java=.class)
PROGRAM	= $(shell pwd)

all: $(CLASS)

test:;
	@echo 今回は make test は使用できません

kadai1: GraphTester.java
	sh kadai1.sh
kadai2: DFSTester.java
	sh kadai2.sh
kadai3: BFSTester.java
	sh kadai3.sh

.java.class:
	$(JAVAC) $<

clean:;	\rm -f *.class

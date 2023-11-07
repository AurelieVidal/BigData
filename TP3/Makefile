# Makefile pour compiler et lancer les projets HDFS de Eclipse

run:    projet.jar
	hadoop jar $<

SOURCES=$(shell find src -name *.java)

projet.jar:     $(shell fgrep -l 'void main' $(SOURCES)) $(SOURCES)
	@mkdir -p bin
	javac -cp $(subst $(eval) ,:,$(wildcard ~/TP_Hadoop/*.jar)) $^ -d bin
	jar cfe $@ $(subst /,.,$(basename $(<:src/%=%))) -C bin $(dir $(<:src/%=%))

clean:
	rm -fr projet.jar bin


#alias antlr4='java -Xmx500M -cp "/usr/local/lib/antlr-4.13.2-complete.jar:$CLASSPATH" org.antlr.v4.Tool'
antlr4 C2105131Lexer.g4 C2105131Parser.g4
javac -cp .:/usr/local/lib/antlr-4.13.2-complete.jar  C2105131*.java Main.java
java -cp .:/usr/local/lib/antlr-4.13.2-complete.jar Main $1

SET JAVA_HOME="C:\Program Files\Java\jdk1.8.0_91\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
cd E:\chato\Documents\NetBeansProjects\IDECompi2_Proyecto1\src\com\CompiladorHaskellPlusPlus\Gramaticas
java -classpath C:\Fuentes\ java_cup.Main -parser Analisis_Sintactico -symbols Simbolo sintactico.cup
pause
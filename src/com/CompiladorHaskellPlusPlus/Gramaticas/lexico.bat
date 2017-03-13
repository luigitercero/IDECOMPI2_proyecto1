SET JAVA_HOME="C:\Program Files\Java\jdk1.8.0_91\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
SET JFLEX_HOME= C:\Fuentes\jflex-1.6.1
cd E:\chato\Documents\NetBeansProjects\IDECompi2_Proyecto1\src\com\CompiladorHaskellPlusPlus\Gramaticas
java -jar %JFLEX_HOME%\lib\JFlex.Jar lexico.jflex
pause
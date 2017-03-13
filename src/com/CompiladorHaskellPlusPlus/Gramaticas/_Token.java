/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CompiladorHaskellPlusPlus.Gramaticas;

/**
 *
 * @author luigitercero
 */
public  interface _Token {
    public static final String  mas ="+",
menos  	= "-",
por 	= "*",
div 	= "/",
mod     = "'mod'",
sqrt    = "'sqrt'",
pot     = "'pot'",
para    = "(",
parc    = ")",
dolar   =	"$",
let     =	"let",
corcha  =	"[",
corchc  =	"]",
porcentaje  =	"%",
calcular =	"calcular",
succ    =	"succ",
decc    =       "decc",
min     =	"min",
max     =	"max",
sum 	=	"sum",
product =	"product",
revers  =	"revers",
impr    =	"impr",
par 	=	"par",
asc 	=	"asc",
desc    =	"desc",
length  =	"length",
llv1    =	"{",
llv2    =	"}",
masmas	=	"++",
si  	=	"if",
entonces=	"then",
coma    =	",",
t_else  =	"else",
end 	=	"end",
igual   =	"=",
igualigual=	"==",
dosp    =	":",
caso    =	"case",
menorque=	"<",
menorIgual=	"<=",
mayorque=	">",
mayorIgual=	">=",
diferente =	"!=",
andd      =	"&&",
orr       =	"||",
admiracionadmiracion    = "!!",
 num = "num",
 cadena = "cadena",
 caracter= "caracter",        
  lista = "lista", ID = "Id";
 
 
 
 public final int _string = 0, _double = 1, _int = 2, _char =3, _bool  =3;

}

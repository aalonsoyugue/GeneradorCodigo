#include <stdio.h>
#include <stdlib.h>
#include <Repetir.py>
#include <Suma.py>
#include <Suma.pyc>
#include <LeerB.py>
#include <Multiplicacion.c>
#include <Multiplicacion.py>
#include <LeerA.py>



int main(int argc, char *argv[]){
printf("Introducir el valor para A:");
int A,B;scanf("%d", A);
print("Introducir el valor para B:");
scanf("%d", B);
C = Multiplicacion(A, B);
print("El resultado es: %d", C);

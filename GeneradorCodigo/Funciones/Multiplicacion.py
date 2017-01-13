from ./ import *


def Multiplicacion(A, B):
	aux = 0
	for i in range(B):
		aux=Suma(aux,B)
	return aux


print("Introducir el valor para A:")
A = input()
print("Introducir el valor para B:")
B = input()
C = Multiplicacion(int(A), int(B))
print("El resultado es: ", C)

import Suma


def Multiplicar(A, B):
	aux = 0
	print(aux)
	for i in range(A):
		aux = Suma(aux,int(B))
		print(aux)

	return aux


print("Introducir el valor para A:")
A = input()
print("Introducir el valor para B:")
B = input()
C = Multiplicar(int(A), int(B))
print("El resultado es: ", C)
H=input()
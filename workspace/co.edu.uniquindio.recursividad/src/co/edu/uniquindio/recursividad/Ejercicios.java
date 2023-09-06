package co.edu.uniquindio.recursividad;

import java.util.Arrays;

public class Ejercicios {
	public static void main(String[] args) {
		int[] a = { 15, 3, 0, 100, 90, 2, 5, 17};

		//ordernarDescendente(a);

		//esPerfectoAux(28);
		
		//System.out.println(normaDelVictor(a, 0, 0));
		//System.out.println(sumarArreglo(a, 0, 0));
		
        int tamaño = 3; // Cambia el tamaño de la matriz aquí
        int[][] matriz = new int[tamaño][tamaño];

        // Llena la matriz con valores predefinidos
        matriz[0] = new int[]{1, 2, 3};
        matriz[1] = new int[]{4, 5, 6};
        matriz[2] = new int[]{7, 8, 9};

       System.out.println(promDiagonal(matriz, 0, 0, 0));
        
        System.out.println(sumarPrimos(a, 0, 0));
        System.out.println(buscarMenor(a, 0, a.length-1));
	}

	public static int factorial(int n) {
		if (n <= 1)
			return 1;
		return n * factorial(--n);
	}

	public static int buscarMayor(int[] a, int i, int j) {
		if (i == j) return a[i];
		return Math.max(buscarMayor(a, i, (i + j) / 2), buscarMayor(a, ((i + j) / 2) + 1, j));
	}

	public static boolean esPotencia(int n, int b) {
		if ((n % 2) != 0)
			return false;
		if (n == b)
			return true;
		if (n < b)
			return false;
		return esPotencia(n / b, b);
	}

	public static void ordernarDescendente(int[] a) {
		int b[] = ordernarDescendente(a, 0, 0);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}

	public static int[] ordernarDescendente(int[] a, int i, int j) {
		if (i == a.length)
			return a;
		if (j == a.length - 1)
			return ordernarDescendente(a, i + 1, 0);
		if (a[j] > a[j + 1])
			return ordernarDescendente(a, i, j + 1);
		int[] b = Arrays.copyOf(a, a.length);
		b[j] = a[j + 1];
		b[j + 1] = a[j];
		return ordernarDescendente(b, i, j + 1);
	}

	public static void esPerfectoAux(int n) {
		System.out.println(esPerfecto(n, n - 1, 0));
	}

	public static boolean esPerfecto(int n, int b, int sum) {
		if (sum == n)
			return true;
		if (b <= 0 && sum != n)
			return false;
		if ((n % b) == 0)
			return esPerfecto(n, b - 1, sum + b);
		return esPerfecto(n, --b, sum);
	}

	public static int normaDelVictor(int[] a, int i, int sum) {
		if (i == a.length)
			return (int) Math.sqrt(sum);
		return normaDelVictor(a, i + 1, sum + (a[i] * a[i]));
	}

	public static int sumarArreglo(int[] a, int i, int sum) {
		if (i == a.length) return sum;
		return sumarArreglo(a, i + 1, sum + a[i]);
	}
	
	//Cambiar
	public static int sumarPrimos(int []a, int i, int cont) {
		if(i == a.length) return cont;
		if(!(isPrimo(a[i], a[i]-1))) return sumarPrimos(a, ++i, cont);
		return sumarPrimos(a, ++i, ++cont);
	}
	
	public static boolean isPrimo(int n, int b) {
		if(b == 0) {
			return true;
		}
		if((n%b) ==0  && b != 1) return false;
		return isPrimo(n, --b);
	}
	
	public static String sumaPosPares(int []a, int i, String c) {
		if(i == a.length) return c;
		if((i%2)==0) return sumaPosPares(a, i+1, c + " " +  a[i]);
		return sumaPosPares(a, i+1, c);
	}
	
	public static String empiezanPor(String[]a, int i, String c, char l) {
		if(i== a.length) return c;
		char aux = a[i].charAt((a[i].length()/2)+1);
		if(aux == l) return empiezanPor(a, ++i, c + aux, l);
		return empiezanPor(a, ++i, c, l);
	}
	
	//-------------
	public static int contarSupPromedio(double[]a, int i, int sup) {
		if(i == a.length) return sup;
		if(a[i] > prom(a)) return contarSupPromedio(a, ++i, ++sup);
		return contarSupPromedio(a, ++i, sup);
	}
	
	public static int contarMinPromedio(double[]a, int i, int sup) {
		if(i == a.length) return sup;
		if(a[i] < prom(a)) return contarSupPromedio(a, ++i, ++sup);
		return contarSupPromedio(a, ++i, sup);
	}
	
	public static double prom(double[]a) {
		return sacarProm(a, 0, 0);
	}
	
	public static double sacarProm(double [] a, int i, double sum) {
		if(i == a.length) return sum/a.length;
		return sacarProm(a, i+1, sum + a[i]);
	}
	
	public static int[] obtenerCuentaProm(double [] a) {
		int [] b = {contarSupPromedio(a, 0, 0), contarMinPromedio(a, 0, 0)};
		return b;
	}
	//-------------
	
	public static double promDiagonal(int [][] a, int i, int j, double sum) {
		if(i == a.length) return sum/a.length;
		return promDiagonal(a, i+1, j+1, sum+ a[i][j]);
				
				
	}
	
	/*
	public static int buscarMenorMatriz(int [][]a, int i, int j) {
		if(i == a.length)
		if(j == a[i].length) return buscarMenorMatriz(a, ++i, 0);
	}
	
	/*
	public static int compararMatriz(int []a, int []b, int) {
		if()
	}
	*/
	
	public static int buscarMenor(int [] a, int i, int j) {
		if(i ==j) return a[i];
		return Math.min(buscarMenor(a, i, (i + j) / 2), buscarMenor(a, ((i + j) / 2) + 1, j));
	}
}

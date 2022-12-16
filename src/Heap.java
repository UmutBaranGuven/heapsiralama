//UMUT BARAN GÜVEN 02195076017
import java.util.Scanner;


public class Heap {
private static int n;

private int left(int i)
{
return (2 * i) + 1;
}

private int right(int i)
{
return (2 * i) + 2;
}

public int minimum(int [] array)
{
return array[array.length - 1]; // o(1)
}

public int maximum(int [] array)
{
return array[0]; // o(1)
}

public void sort(int [] array)
{
n = array.length-1;

heapify(array); // O(n) tüm diziyi düzenle
// tüm sort işlemi => O(n log(n))

for(int i = n; i >= 0; i --)
{
int temp = array[0];
array[0] = array[i];
array[i] = temp;

n = n - 1;
heap(array,0);
}
}

private void heapify(int [] array)
{
for(int i = n; i >= 0; i--) heap(array,i); // her heap sorgusu => O (log(n))
}

private void heap(int [] array, int i)
{
int left = left(i); // şuanki indisin sol çocuğu
int right= right(i);// şuanki indisin sağ çocuğunun indisi
int largest = i; // kendisini büyükmüş gibi görüyoruz

if((left <= n) && (array[left] > array[largest]) ) // sol çocuğu büyükse en büyük sol oluyor
largest = left;

if((right <= n) && (array[right] > array[largest]) ) // sağ ile büyüğü karşılaştırıyoruz
largest = right; // büyükse en büyük sağ çocuk oluyor

if(largest != i) // iki indis aynı olana kadar
{
// indisler arası değiştirme, swap işlemi yapıyoruz
int temp = array[i];
array[i] = array[largest];
array[largest] = temp;

heap(array,largest); // değiştirilen indisleri kontrol ediyoruz
}
}

public void print(int [] array)
{
for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
}

public static void main(String[] args)
{
Heap h = new Heap();
int i, s = 0;
        int dizi[] = new int[5];
        Scanner sc = new Scanner(System.in);
 
        System.out.print("5 tane sayı girin :");
 
        for (i = 0; i < dizi.length; i++) {
            dizi[i] = sc.nextInt();
System.out.println("Siralanmamis hali");
h.print(dizi);

h.sort(dizi); // sırala

System.out.println("\nSiralanmis hali");
h.print(dizi);
System.out.println("\nMinimum : " + h.maximum(dizi));
System.out.println("Maksimum : " + h.minimum(dizi));
}
}
}
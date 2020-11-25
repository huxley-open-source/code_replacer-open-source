#include <stdio.h>
#define MAX 100

${begin_visible}
/**
    a : array que deve ser ordenado
    tamanho: número de elementos do array a
*/
void ordenar(int a[], int tamanho)
{
    ${code1}
}
${end_visible}

int main()
{
    int x[MAX], i;
    for (i=0; i< MAX; i++)
    {
        scanf("%d", &x[i]);
    }
    ordenar(x, MAX);
    for (i=0; i< MAX; i++)
    {
        printf("%d ", x[i]);
    }

    return 0;
}
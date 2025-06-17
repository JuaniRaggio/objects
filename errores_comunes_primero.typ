_Nota_ algunas parecen ser boludeces pero al no tener ide son muy olvidables

= Orden y ArrayList
- No confundir `ArrayList<>()` con el arreglo vanilla de Java $->$ `[]`

- El arreglo vanilla de Java tiene el metodo `length` para obtener la longitud,
no existe el metodo `size()`

- No olvidarse de checkear idx > 0 si se consulta

- Cuando se ordena el arreglo vanilla, hay que hacer una copia con su dimension
real porque sino estarias desreferenciando NULLs y va a arrojar una 
`NullPoiinterException`

De la siguiente forma (en pseudo)

```java

private static final int DIM_INICIAL = 10;
private Cosa[] arrCosas = new Cosa[DIM_INICIAL];
private int dim_real = 0;

static Cosa[] getCopy(int dim) {
  return Arrays.copyOf(arrCosas, dim);
}

add(Cosa cosa) {
  if (arrCosas.legth == dim_real) {
    arrCosas = getCopy(dim_real + DIM_INICIAL);
  }
  arrCosas[dim_real++] = cosa;
}

sorter() {
  Cosa[] cosasOrdenadas = Arrays.copyOf(arrCosas);
  // Suponiendo que Cosa es comparable
  Arrays.sort(cosasOrdenadas, Comparator.naturalOrder());
  // Notemos que el .sort no retorna un arreglo
  return cosasOrdenadas;
}

```

= Generales

- Checkear de retornar bien los valores

- No olvidarse de implementar metodos aunque sean getters prestarle mucha
atencion a los metodos que se llaman en el test



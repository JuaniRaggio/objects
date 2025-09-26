= Analogias

En realidad en C++, la STL no implementa los contenedores a travez de herencia. Sino que organizan los contenedores a travez de _familias de plantillas_

= Categorias de contenedores:

== Sequence containers

- `vector` $->$ ArrayList
- `deque` $->$ double entry queue
- `array` $->$ tamaño fijo como T[]
- `forward_list` $->$ simple linked list

\

== Associative containers

- `set` $->$ `TreeSet`
- `map` $->$ `TreeMap`
- `multiset` / `multimap` $->$ permiten duplicados

\

== Unordered containers

_Funcionan con la *funcion hash* por defecto_

- `unordered_set` $->$ `HashSet`
- `unordered_map` $->$ `HashMap`
- `unordered_multiset` / `unordered_multimap`

\

== Container adapters
_No son estructuras nuevas, sino que vistas con otra interfaz_

- `stack` $->$ usa `deque` por default
- `queue` $->$ usa deque
- `priority_queue` $->$ heap, como `PriorityQueue` en Java


= Clases concretas

_Las clases STL son directamente utilizables, no derivan de una superclase_

= Iteradores
- `Iterator`
- `ListIterator`

== Iteradores STL

- `begin()`
- `end()`

= Algoritmos

_En C++ son funciones que estan dentro de_ `<algorithm>`

- `sort`
- `find`
- `accumulate`

\

= Diferencias clave con Java

- En vez de usar jerarquia de herencia con interfaces, usa *plantillas* y a partir de C++20, usa *concepts* que son especificaciones para clases.

- Se usan algoritmos desacoplados

_Java_
```java

list.sort();

```

_C++_
```cpp

std::sort(v.begin(), v.end());

```



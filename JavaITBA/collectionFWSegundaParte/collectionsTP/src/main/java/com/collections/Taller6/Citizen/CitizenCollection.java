package com.collections.Taller6.Citizen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CitizenCollection {

  // Sin repetidos, sin orden:
  private Set <Citizen> noOrderNoRepeted = new HashSet<>();
  // Ademas Citizen tiene que implementar equals y hashCode

  // Sin repetidos, con orden:
  private Set <Citizen> orderedNoRepeted = new TreeSet<>(/* Implementar aca un Comparator<Citizen> */);
  // O bien pedirle a Citizen que sea comparable de el mismo, en tal caso tendriamos un TreeSet<>() y un TreeSet<>(Comparator.reverseOrder())
  // para orden natural e inverso respectivamente

  // Busqueda por dni
  private Map <String, Citizen> dniAccess = new HashMap<>();
  // No tiene ninguna limitacion, ya que sabemos que String implementa correctamente equals y hashCode

  // Busqueda por nombre / Nombre y Apellido
  // Tener en cuenta que se pueden tener dos Citizens con mismo nombre y apellido pero que sean dos personas distintas
  private Map<String, Map<String, List<Citizen>>> nameSurnameAccess = new HashMap<>();
  
  // Busqueda por dni ordenada
  private Map<String, Citizen> dniOrderedAccess = new TreeMap<>();
  // Tampoco tiene limitaciones pues sabemos que String es comparable

}

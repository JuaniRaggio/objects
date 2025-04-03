package com.talleres.tallerComparable;

public class PhoneNumber implements Comparable<PhoneNumber> {

  private int areaCode, prefix, lineNumber;

  public int getAreaCode() { return areaCode; }
  public int getPrefix() { return prefix; }
  public int getLineNumber() { return lineNumber; }

  public int compareTo(PhoneNumber that) {

    int result = Integer.compare(this.areaCode, that.getAreaCode());
    if (result == 0) result = Integer.compare(this.prefix, that.getPrefix());
    if (result == 0) result = Integer.compare(this.lineNumber, that.getLineNumber());
    return result;

  }

}


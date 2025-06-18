package com.talleres.tallerComparable;

public class PhoneNumber implements Comparable<PhoneNumber> {

  private int areaCode, prefix, lineNumber;

  public PhoneNumber(int areaCode, int prefix, int lineNumber) {
    this.areaCode = areaCode;
    this.prefix = prefix;
    this.lineNumber = lineNumber;
  }

  public int getAreaCode() { return areaCode; }
  public int getPrefix() { return prefix; }
  public int getLineNumber() { return lineNumber; }
  @Override
  public String toString() { 
    return String.format("+%d %d %d", prefix, areaCode, lineNumber);
  }
  public int compareTo(PhoneNumber that) {
    int result = Integer.compare(this.areaCode, that.getAreaCode());
    if (result == 0) result = Integer.compare(this.prefix, that.prefix);
    if (result == 0) result = Integer.compare(this.lineNumber, that.lineNumber);
    return result;
  }

}


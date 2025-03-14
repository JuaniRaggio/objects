class ComplexNumber {

  private double real;
  private double imaginary;

  public ComplexNumber(double real, double imaginary) {
    this.real = real;
    this.imaginary = imaginary;
  }

  public ComplexNumber(double real) {
    this.real = real;
  }

  public ComplexNumber(ComplexNumber n1, ComplexNumber n2) {
    this.real = n1.get_real() + n2.get_real();
    this.imaginary = n1.get_imaginary() + n2.get_imaginary();
  }

  public double get_real() {
    return real;
  }

  public double get_imaginary() {
    return imaginary;
  }

}


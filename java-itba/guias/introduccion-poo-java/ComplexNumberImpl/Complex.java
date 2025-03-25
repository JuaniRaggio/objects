package ComplexNumberImpl;

public class Complex {
  private double real, imaginary;

  public Complex(double real, double imaginary) {
    this.real = real;
    this.imaginary = imaginary;
  }

  public Complex(double real) {
    this(real, 0.0);
  }

  public double getReal() { return real; }

  public double getImaginary() { return imaginary; }

  public boolean equals(Complex a) {
    try {
      return this.real == a.getReal() && this.imaginary == a.getImaginary();
    } catch (NullPointerException e) {
      System.err.println("Null parameter");
    }
    return false;
  }

  public Complex plus(double a) {
    return new Complex(this.real + a, this.imaginary);
  }

  public Complex plus(Complex a) {
    try {
      return new Complex(this.real + a.getReal(), this.imaginary + a.getImaginary());
    } catch (NullPointerException e) {
      System.err.println("Null parameter");
    }
    return null;
  }

  @Override
  public String toString() {
    return real + " + " + imaginary;
  }

}


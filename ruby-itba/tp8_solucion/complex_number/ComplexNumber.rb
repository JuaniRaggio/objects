# La clase debe permitir que dos instancias de números complejos puedan sumarse retornado
# una nueva instancia con el resultado de la operación.
class ComplexNumber
  def initialize(real, imaginary)
    @real = real
    @imaginary = imaginary
  end

  def to_s
    "#{@real} + #{@imaginary}"
  end

  def +(other)
    return nil if other.nil? || !other.is_a?(ComplexNumber)

    ComplexNumber.new(@real + other.real, @imaginary + other.imaginary)
  end

  attr_reader :real, :imaginary
end

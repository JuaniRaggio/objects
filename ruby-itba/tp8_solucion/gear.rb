require_relative 'wheel'

class Gear
  # Yo antes habia creado el siguiente constructor extra
  # pero en ruby no hay sobrecarga parametrica
  # def initialize(chainring, cog)
  #   @chainring = chainring
  #   @cog = cog
  #   @ratio = @chainring, @cog
  # end
  def initialize(chainring, cog, wheel = nil)
    @chainring = chainring
    @cog = cog
    @wheel = wheel
  end

  def ratio
    raise ZeroDivisionError unless @cog.nonzero?

    @chainring / @cog.to_f
  end

  def gear_inches
    @wheel.wheel_diameter * ratio
  end

  attr_writer :chainring, :cog
end

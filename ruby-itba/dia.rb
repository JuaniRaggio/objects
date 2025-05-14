class Date
  def initialize(day, mont, year)
    # variables de instancia
    @day = day
    @month = month
    @year = year
  end

  def day
    @day
  end

  def day=(day)
    @day = day
  end

  # Esto me genera los getters automaticamente
  # attr_reader :day, :month, :year

  # Esto me genera los setters automaticamente
  # attr_writer :day, :month, :year

  # Esto me genera los getters y setters de lo que le esto pidiendo
  attr_accessor :day, :month, :year

end

today = Date.new(14, 5, 2025)
# Se pone solo el toString
puts today
today.day = 20
puts today.day

class Wheel
  def initialize(rim, tire)
    @rim = rim
    @tire = tire
  end

  def wheel_diameter
    @rim + 2 * @tire
  end
end

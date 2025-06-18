class Ticket
  @@number = 1000

  def initialize
    @items = {}
    @current_number = @@number
    @@number += 1
  end

  def add(prod, amount)
    # Es lo mismo que hacer @items.add(Item.new(prod, amount))
    @items[prod.description] = Item.new(prod, 0) unless @items.key?(prod.description)
    @items[prod.description].amount += amount
  end

  def total
    @items.values.map { it.total }.reduce { |accum, e| accum + e }
  end

  def to_s
    s = "N: #{@@number}\n"
    s += "###############\n"
    @items.each { s += it.to_s }
    s += "###############\n"
    s += "Total: #{total}"
  end
end

class Item
  include Comparable

  def initialize(prod, amount)
    @product = prod
    @amount = amount
  end

  def <=>(other)
    return nil unless other.is_a?(Item)

    @product <=> other.product
  end

  def ==(other)
    @product == other.product
  end

  def total
    @product.unit_prize * @amount
  end

  def hash
    [@product].hash
  end

  def to_s
    "#{@product.description} #{@amount} $#{@product.unit_prize}\n"
  end

  attr_accessor :amount

  protected

  attr_reader :product
end

class Product
  include Comparable

  def initialize(description, prize)
    @description = description
    @unit_prize = prize
  end

  def <=>(other)
    return nil unless other.is_a?(Product)

    [@description, @unit_prize] <=> [other.description, other.unit_prize]
  end

  def ==(other)
    return nil unless other is_a?(Product)

    @description == other.description
  end

  def hash
    [@description, @unit_prize].hash
  end

  attr_reader :description, :unit_prize
  alias eql? ==
end

bayaspirina = Product.new('Bayaspirina', 99.99)
cafiaspirina = Product.new('Cafiaspirina', 79.99)
aspirinetas = Product.new('Aspirinetas', 49.99)

first_ticket = Ticket.new
first_ticket.add(bayaspirina, 2)
first_ticket.add(cafiaspirina, 1)
puts first_ticket

# TICKET Nº 1000
# ####################
# Cafiaspirina    1  $79.99
# Bayaspirina     2  $99.99
# ####################
# TOTAL $279.97

puts

second_ticket = Ticket.new
second_ticket.add(bayaspirina, 1)
second_ticket.add(cafiaspirina, 1)
second_ticket.add(aspirinetas, 1)
puts second_ticket

# TICKET Nº 1001
# ####################
# Aspirinetas     1  $49.99
# Cafiaspirina    1  $79.99
# Bayaspirina     1  $99.99
# ####################
# TOTAL $229.97

puts

third_ticket = Ticket.new
third_ticket.add(Product.new('Aspirinetas', 49.99), 1)
third_ticket.add(aspirinetas, 1)
puts third_ticket

# TICKET Nº 1002
# ####################
# Aspirinetas     1  $49.99
# ####################
# TOTAL $49.99

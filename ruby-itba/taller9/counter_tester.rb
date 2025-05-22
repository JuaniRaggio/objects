class MultipleCounter
  def initialize(s)
    @step = s
    @count = 0
  end

  def increment()
    @count += @step
  end

  def decrement()
    @count -= @step
  end

  def to_s()
    @count.to_s
  end

  attr_accessor :count
end

class Counter < MultipleCounter
  def initialize()
    super(1)
  end
end

# Ej 4
my_counter = Counter.new
puts my_counter.count
my_counter.increment
my_counter.increment
puts my_counter.count
my_counter.decrement
puts my_counter.count

# Ej 3
my_counter.count = 10
my_counter.increment
puts my_counter.count # Imprime 11
puts my_counter

# Ej 4
double_counter = MultipleCounter.new(2)
puts double_counter # Imprime 0
double_counter.increment # Aumenta en 2
double_counter.increment
puts double_counter # Imprime 4
double_counter.decrement # Disminuye en 2
puts double_counter # Imprime 2
double_counter.count = 10
double_counter.increment
puts double_counter # Imprime 12

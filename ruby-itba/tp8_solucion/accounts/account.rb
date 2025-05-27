class Account
  # Esto es un error conceptual ya que queremos que esta clase sea
  # abstracta, por lo que no podemos tener un initialize
  # Igualmente yo lo habia pensado como que Account era una clase concreta
  # pero bueno
  # def initialize(account_id)
  #   @id = account_id
  #   @balance = 0
  # end

  # Esque igual haciendo esto me tira warnings en el otro archivo que hereda esta clase
  # justamente porque no lo voy a llamar a este metodo
  def initialize
    raise 'Este metodo debe sobreescribirse'
  end

  def create(account_id)
    @id = account_id
    @balance = 0
  end

  def deposit(amount)
    @balance += amount
  end

  # TODO En la solucion esta asi no entiendo porque
  # def extract?(_amount)
  #   raise 'Debe sobreescribir este método'
  # end

  def can_extract?(amount)
    # Esta mal hacer esto? entiendo que no
    raise NotImplementedError
  end

  def extract(amount)
    raise RuntimeError unless can_extract?(amount)

    @balance -= amount
  end

  def to_s
    "Cuenta #{@id} con saldo #{@balance}"
  end

  private :can_extract?, :create
  attr_reader :id, :balance
end

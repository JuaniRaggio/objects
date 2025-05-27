class Account
  def initialize(account_id)
    @id = account_id
    @balance = 0
  end

  def deposit(amount)
    @balance += amount
  end

  def can_extract?(amount)
    raise NotImplementedError
  end

  def extract(amount)
    raise RuntimeError unless can_extract?(amount)

    @balance -= amount
  end

  def to_s
    "Cuenta #{@id} con saldo #{@balance}"
  end

  attr_reader :id, :balance
end

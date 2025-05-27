require_relative 'account'
class SavingsAccount < Account
  def can_extract?(amount)
    @balance > amount
  end
end

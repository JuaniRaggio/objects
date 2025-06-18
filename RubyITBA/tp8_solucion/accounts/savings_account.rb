require_relative 'account'
class SavingsAccount < Account
  def initialize(account_id)
    create(account_id)
  end

  private

  def can_extract?(amount)
    @balance > amount
  end
end

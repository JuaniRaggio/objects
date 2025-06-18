require_relative 'account'

class CheckingAccount < Account
  def initialize(account_id, extra)
    create(account_id)
    @extra = extra
  end

  private

  def can_extract?(amount)
    @extra > @balance - amount
  end
end

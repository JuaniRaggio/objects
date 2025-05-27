require_relative 'account'
class CheckingAccount < Account
  def initialize(account_id, extra)
    super(account_id)
    @extra = extra
  end

  def can_extract?(amount)
    @extra > @balance - amount
  end
end

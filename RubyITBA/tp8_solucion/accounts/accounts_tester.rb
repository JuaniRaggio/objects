require_relative 'checking_account'
require_relative 'savings_account'

my_checking_account = CheckingAccount.new(1001, 50)
my_checking_account.deposit(100.0)
puts my_checking_account
my_checking_account.extract(150.0)
puts my_checking_account

my_savings_account = SavingsAccount.new(1002)
my_savings_account.deposit(100.0)
puts my_savings_account
my_savings_account.extract(150.0)

# Salida esperada:
# Cuenta 1001 con saldo 100.0
# Cuenta 1001 con saldo -50.0
# Cuenta 1002 con saldo 100.0
# ...
# No cuenta con los fondos necesarios (RuntimeError)

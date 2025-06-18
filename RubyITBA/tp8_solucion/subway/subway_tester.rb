# require_relative 'subway_central'
# require_relative 'rechargeable_subway_card'
# require_relative 'fixed_subway_card'
# require_relative 'discount_rechargeable_subway_card'


subway_central = SubwayCentral.new(7.5)

rechargeable_card = RechargeableSubwayCard.new(subway_central)
rechargeable_card.recharge(15)
rechargeable_card.ride
puts rechargeable_card # Rechargeable Subway Card [Central: Subway Central [$7.5]] [Balance: $7.5]
subway_central.ride_cost = 8.00
puts rechargeable_card # Rechargeable Subway Card [Central: Subway Central [$8.0]] [Balance: $7.5]
# rechargeable_card.ride # Not enough funds (RuntimeError)

fixed_card = FixedSubwayCard.new(subway_central, 3)
fixed_card.ride
fixed_card.ride
puts fixed_card # Fixed Subway Card [Central: Subway Central [$8.0]] [Rides: 1]
fixed_card.ride
# fixed_card.ride # No rides available (RuntimeError)

discount_card = DiscountRechargeableSubwayCard.new(subway_central, 0.5)
discount_card.recharge(10)
discount_card.ride
puts discount_card # Rechargeable Subway Card [Central: Subway Central [$8.0]] [Balance: $6.0]

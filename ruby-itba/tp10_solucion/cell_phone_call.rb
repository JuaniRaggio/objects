#!/usr/bin/env ruby
class Call
  COST_PER_SECOND = 0.01

  def initialize(from, to, duration)
    @from = from
    @to = to
    @duration = duration
  end

  def cost
    @duration * COST_PER_SECOND
  end
end

class CellPhoneBill
  def initialize(number)
    @number = number
    @calls = []
  end

  def register_call(to_number, duration)
    @calls.push(Call.new(@number, to_number, duration))
  end

  def process_bill
    @calls.map{ |c| c.cost }.reduce(:+)
  end
end

class FriendBill < CellPhoneBill
  attr_writer :discount

  def initialize(number, friends_limit, discount)
    super(number)
    @friends = Set.new
    @limit = friends_limit
    @discount = discount
  end

  def add_friend(friend_number)
    if @friends.size == @limit
      raise 'Friend limit reached'
    end
    @friends << friend_number
  end

  def delete_friend(friend_number)
    @friends.delete(friend_number)
  end

  def is_friend?(number)
    @friends.include? number
  end

  def cost_multiplier = 1 - @discount

  def process_bill
    @calls.map {
      |c| @friends.is_friend?(c) ? c.cost * @friends.cost_multiplier : c.cost
    }.reduce {
      :+
    }
  end

  def discount=(discount_overwriter)
    @friends.discount = discount_overwriter
  end
end

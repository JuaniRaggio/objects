package com.ejercicios.guiaGenerics.Ejercicio10;

public class FriendsPromotion extends CellPhoneBill {

  private final String[] friends;
  private int totalAmountOfFriends;
  private double costPerSecond;

  public FriendsPromotion(String number, int totalFriends) {
    super(number);
    // Es seguro esto?
    totalAmountOfFriends = totalFriends;
    friends = new String[totalAmountOfFriends];
  }

  public void setCost(double costPerSecond) {
    this.costPerSecond = costPerSecond;
  }

  public void addFriend(String friend) throws TooManyFriendsException,
                                              AlreadyExistsFriendException{
    for (int i = 0; i < totalAmountOfFriends; ++i) {
      if (friends[i] == null) {
        friends[i] = friend;
        return;
      } else if (friends[i] == friend) {
        throw new AlreadyExistsFriendException(friend);
      }
    }
    throw new TooManyFriendsException(friend);
  }

  public void removeFriend(String friend) throws FriendNotFoundException {
    for (int i = 0; i < totalAmountOfFriends; ++i) {
      if (friends[i] == friend) {
        friends[i] = null;
        totalAmountOfFriends--;
        return;
      }
    }
    throw new FriendNotFoundException(friend);
  }

  @Override
  public double processBill() {
    double total = 0;
    for (int i = 0; i < callsIndex; i++) {
      total += 
      isFriend(calls[i].getDestination()) ?
      calls[i].getDuration() * costPerSecond
      :calls[i].getCost();
    }
    return total;
  }

  private boolean isFriend(String person) {
    for (String friend : friends) {
      if (friend == person) return true;
    }
    return false;
  }

}

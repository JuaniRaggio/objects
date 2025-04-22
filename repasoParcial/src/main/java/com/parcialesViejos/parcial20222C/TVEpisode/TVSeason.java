package com.parcialesViejos.parcial20222C.TVEpisode;

import java.util.Arrays;
import java.util.Comparator;

public class TVSeason {

  private TVEpisode[] episodes;

  public TVSeason(TVEpisode[] episodes) {
    this.episodes = episodes;
  }

  public TVEpisode[] getOrderedEpisodes(Comparator<TVEpisode> condition) {
    TVEpisode[] returnValue = Arrays.copyOf(episodes, episodes.length);
    Arrays.sort(returnValue, condition);
    return returnValue;
  }

  public TVEpisode[] getDateOrderCopy() {
    return getOrderedEpisodes((ep1, ep2) -> TVEpisode.dateAscendingOrder(ep1, ep2));
  }

  public TVEpisode[] getNameOrderCopy() {
    return getOrderedEpisodes((ep1, ep2) -> TVEpisode.nameAscendingOrder(ep1, ep2));
  }

  public TVEpisode[] getRatingOrderCopy() {
    return getOrderedEpisodes((ep1, ep2) -> TVEpisode.ratingDescendingOrder(ep1, ep2));
  }

}

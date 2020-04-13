package org.peidevs.waro.table;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.Lists;

import org.peidevs.waro.player.*;

public class Dealer {

    public Table deal(int numCards, List<Player> players) {
        var hands = deal(numCards, players.size()).collect(toList());
        var kitty = hands.remove(0);
        var index = 0;

        // TODO: is there a zip function in JDK ?
        var newPlayers = StreamUtils.zip(players.stream(), hands.stream(),
                                         (player, hand) -> player.reset(hand)).collect(toList());

        var table = new Table(newPlayers, kitty);

        return table;
    }

    // ------- internal

    protected Stream<Hand> deal(int numCards, int numPlayers) {
        int numGroups = numPlayers + 1; // include kitty
        assertEvenNumberOfCards(numCards, numGroups);

        var deck = buildShuffledDeck(numCards);
        int numCardsPerHand = numCards / numGroups;

        // TODO: is there a way to partition using Java 8 ?
        var hands = Lists.partition(deck, numCardsPerHand).stream().map(cards -> new Hand(cards));

        return hands;
    }

    protected List<Integer> buildShuffledDeck(int numCards) {
        var cards = IntStream.range(1,numCards+1).boxed().collect(toList());
        Collections.shuffle(cards, new Random(new Date().getTime()));
        return cards;
    }

    protected void assertEvenNumberOfCards(int numCards, int numGroups) {
        if ((numCards % numGroups) != 0) {
            throw new IllegalArgumentException("uneven # of cards");
        }
    }
}

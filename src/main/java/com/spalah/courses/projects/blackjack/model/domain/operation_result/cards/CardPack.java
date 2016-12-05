package com.spalah.courses.projects.blackjack.model.domain.operation_result.cards;


import com.spalah.courses.projects.blackjack.exception.AllCardsWereUsedException;

import java.util.*;

/**
 * @author ukevgen on 03.06.2016.
 * @author Dima Zasuha on 05.06.2016
 */
public class CardPack {
    private static final int NUMBER_OF_CARDS = 208; // 4 packs = 4 * 52 = 208 cards
    private List<Card> cards;

    public CardPack() {
        cards = new ArrayList<>(NUMBER_OF_CARDS);
        initPack();
    }

    public static void main(String[] args) {
        CardPack cardPack = new CardPack();
        Set<Card> usedCards = new HashSet<>();
        for (int i = 0; i < 49; i++) {
            try {
                Card nextCard = cardPack.nextCard(usedCards);
                System.out.println(nextCard);
                usedCards.add(nextCard);
            } catch (AllCardsWereUsedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(usedCards.size());
    }

    private void initPack() {
        CardType[] cardTypes = CardType.values();
        CardColor[] cardColors = CardColor.values();
        for (CardType cardType : cardTypes) {
            for (CardColor cardColor : cardColors) {
                cards.add(new Card(cardColor, cardType));
            }
        }
        Collections.shuffle(cards); // должны шафлить или можно предугадать
    }

    /*
    * Return card that was not used before
    * @param usedCards cards that are already in the game
    */
    public Card nextCard(Collection usedCards) throws AllCardsWereUsedException {
        for (Card card : cards) {
            if (!usedCards.contains(card)) {
                return card;
            }
        }
        throw new AllCardsWereUsedException();
    }

    public List<Card> getCards() {
        return cards;
    }
}

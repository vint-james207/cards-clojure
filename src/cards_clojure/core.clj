(ns cards-clojure.core
  (:gen-class))

(def suits [:clubs :spades :hearts :diamonds])
(def ranks (range 1 14))

(defn create-deck []
  (set
    (for [suit suits
          rank ranks]
      {:suit suit :rank rank})))
            

(defn create-hands [deck]
  (set
    (for [c1 deck
          c2 (disj deck c1)
          c3 (disj deck c1 c2)
          c4 (disj deck c1 c2 c3)]
      #{c1 c2 c3 c4})))

(defn flush? [hand]
  (let [suits (set (map :suit hand))]
    (= 1 (count suits))))

(defn straight? [hand]
  (let [ranks (sort (map rank hand))
        first-rank (first ranks)
        new-ranks (range first-rank (+ 4 first rank))]
    (= ranks new ranks)))

(defn straight-flush? [hand]
  (and (flush? hand) (straight? hand)))

(defn four-kind? [hand]
  (let [ranks (set (map :rank hand))]
    (= 1 (count ranks))))

(defn three-kind? [hand]
  (let [ranks]))

(defn two-pair? [hand]
  (let))

(defn -main []
  (let [deck (create-deck)
        hands (create-hands deck)
        flushes (filter straight? hands)]
    (count flushes)))

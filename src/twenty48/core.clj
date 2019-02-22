(ns twenty48.core
  (:gen-class))

(def remove-zeroes (partial filter (comp not zero?)))

(def group-2-consecutive (comp (partial mapcat (partial partition-all 2)) (comp (partial partition-by identity) remove-zeroes)))

(def add-consecutive (partial map (partial apply +)))

(def prepend-zeroes (comp (partial take-last 4) (partial concat '(0 0 0 0))))

(def move-right (comp prepend-zeroes add-consecutive group-2-consecutive))

(def postpend-zeroes (comp (partial take 4) flatten (partial conj '(0 0 0 0))))

(def move-left (comp postpend-zeroes add-consecutive group-2-consecutive))

(def move-grid-right(partial map move-right))

(def move-grid-left(partial map move-left))

(def move-grid-down (comp (partial apply map list) move-grid-right (partial apply map list)))

(def move-grid-up (comp (partial apply map list) move-grid-left (partial apply map list)))

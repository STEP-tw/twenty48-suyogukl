(ns twenty48.core
  (:gen-class))


(def remove-zeroes (partial filter (comp not zero?)))

(def group-2-consecutive (comp (partial mapcat (partial partition-all 2)) (comp (partial partition-by identity) remove-zeroes)))

(def add-consecutive (partial map (partial apply +)))

(def prepend-zeroes (comp (partial take-last 4) (partial concat '(0 0 0 0))))

(def move-right (comp prepend-zeroes add-consecutive group-2-consecutive))

(defn move-grid-right
  "Moves an entire grid to the right"
  [grid]
  (map move-right grid))

(defn move-grid-left
  "Moves an entire grid to the left"
  [grid]
  grid)

(defn move-grid-down
  "Moves an entire grid down"
  [grid]
  grid)

(defn move-grid-up
  "Moves an entire grid up"
  [grid]
  grid)

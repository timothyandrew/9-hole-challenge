(ns code.golf
  (:require [clojure.string :as s]))

(defn greenway [c n]
  (s/join (repeat n c)))

(defn somewhere-in-the-rough [t s n])

(defn curry-for-dinner [x y]
  (let [n (x)]
    (fn [] (dotimes [n n] (y)))))

(defn spew [f]
  (let [x (rand-int 500)
        y (rand-int 500)]
    (spit f (s/join (repeatedly y #(str (random-line x) "\n"))))))

(defn treasure-hunt [p c]
  (let [text (slurp p)
        rows (s/split text #"\n")
        grid-width (count (first rows))
        xy (.indexOf (s/join rows) c)
        x (rem xy grid-width)
        y (int (/ xy grid-width))]
    (map inc [x y])))

(defn- random-line [length]
  (s/join (repeatedly length #(char (rand-nth (range 65 91))))))

(ns sicp.chapter01.1-03)

;; Define a procedure that takes three numbers as arguments and returns the sum of the squares of the two larger numbers.

(defn max-number [a b c]
  (cond
    (and (> a b) (> a c)) a
    (and (> b a) (> b c)) b
    :else c))

;; (println (max-number -1 0 99))
;; Value => 99


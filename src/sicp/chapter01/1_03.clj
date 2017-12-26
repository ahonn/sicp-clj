(ns sicp.chapter01.1-03)

;; Define a procedure that takes three numbers as arguments and returns the sum of the squares of the two larger numbers.

(defn max-number [a b c]
  (cond
    (and (> a b) (> a c)) a
    (and (> b a) (> b c)) b
    :else c))

; (println (max-number 1 3 5))
; (println (max-number 5 1 3))
; (println (max-number 3 5 1))


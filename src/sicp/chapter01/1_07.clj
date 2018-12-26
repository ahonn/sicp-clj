(ns sicp.chapter01.1_07)

 ;; The good-enough? test used in computing square roots will not be very effective for finding the square roots of very small numbers. Also, in real computers, arithmetic operations are almost always performed with limited precision. This makes our test inadequate for very large numbers. Explain these statements, with examples showing how the test fails for small and large numbers. An alternative strategy for implementing good-enough? is to watch how guess changes from one iteration to the next and to stop when the change is a very small fraction of the guess. Design a square-root procedure that uses this kind of end test. Does this work better for small and large numbers?)

(defn abs [x]
  (if (>= x 0)
    x
    (- x)))

(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn good-enough? [old-guess new-guess]
  (< (/ (abs (- new-guess old-guess))
        old-guess)
     0.001))

(defn sqrt-iter [guess x]
  (if (good-enough? guess (improve guess x))
      (improve guess x)
      (sqrt-iter (improve guess x)
                 x)))

(defn sqrt [x]
  (sqrt-iter 1.0 x))

;; (println (sqrt 0.00009))
;; Value => 0.009486833049684392

;; (println (sqrt 900000000000000000000000000000000000000000000000000000000000000000000000000000000000))
;; Value => 9.48683298167779E41

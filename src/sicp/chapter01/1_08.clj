(ns sicp.chapter01.1_08)

;; Newton's method for cube roots is based on the fact that if y is an approximation to the cube root of x, then a better approximation is given by the value:

;; (/ (+ (/ x
         ;; (* y y))
      ;; (* 2 y))
 ;; 3)

;; Use this formula to implement a cube-root procedure analogous to the square-root procedure. (In section 1.3.4 we will see how to implement Newton's method in general as an abstraction of these square-root and cube-root procedures.)

(defn abs [x]
  (if (>= x 0)
    x
    (- x)))

(defn cube [x]
  (* x x x))

(defn good-enough? [old-guess new-guess]
  (< (/ (abs (- new-guess old-guess))
        old-guess)
     0.001))

(defn improve [guess x]
  (/ (+ (/ x
           (* guess guess))
        (* 2 guess))
     3))

(defn cube-root-iter [guess x]
  (if (good-enough? guess (improve guess x))
    (improve guess x)
    (cube-root-iter (improve guess x)
                    x)))

(defn cube-root [x]
  (cube-root-iter 1.0 x))

;; (println (cube-root 64))
;; Value => 4.000000000076121

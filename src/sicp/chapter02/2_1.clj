;; Define a better version of make-rat that handles both positive and negative arguments.
;; Make-rat should normalize the sign so that if the rational number is positive,
;; both the numerator and denominator are positive, and if the rational number is negative,
;; only the numerator is negative.

(ns sicp.chapter02.2_1)

(defn abs
  "get absolute value of a number"
  [n]
  (if (neg? n) (- n) n))

(defn gcd
  "Greatest Common Divisor"
  [a b]
  (if (zero? b)
    a
    (recur b (mod a b))))

(defn make-rat
  "make rat by number and denom"
  [n d]
  (let [g (abs (gcd n d))
        both-pos (and (pos? n) (pos? d))
        sign (if both-pos 1 -1)
        x (abs (/ n g))
        y (abs (/ d g))]
    (seq [(* sign x) y])))

(defn number
  "get rat number"
  [rat]
  (first rat))

(defn denom
  "get rat denom"
  [rat]
  (last rat))

(defn add-or-sub-rat
  "addition of substruction of two rat"
  [is-add]
  (let [sign (if (true? is-add) 1 -1)]
    (fn [rat1 rat2]
      (let [n1 (number rat1)
            d1 (denom rat1)
            n2 (number rat2)
            d2 (denom rat2)]
        (make-rat
          (+ (* n1 d2)
             (* (* n2 d1) sign))
          (* d1 d2))))))

(def add-rat (add-or-sub-rat true))

(def sub-rat (add-or-sub-rat false))

(defn mul-rat
  "multiplication of two rat"
  [rat1 rat2]
  (let [n1 (number rat1)
        d1 (denom rat1)
        n2 (number rat2)
        d2 (denom rat2)]
    (make-rat (* n1 n2)
              (* d1 d2))))

(defn div-rat
  "division of two rat"
  [rat1 rat2]
  (let [n1 (number rat1)
        d1 (denom rat1)
        n2 (number rat2)
        d2 (denom rat2)]
    (make-rat (* n1 d2)
              (* d1 n2))))
(defn equal-rat
  "equal of two rat"
  [rat1 rat2]
  (let [n1 (number rat1)
        d1 (denom rat1)
        n2 (number rat2)
        d2 (denom rat2)]
    (= (* n1 d2)
       (* n2 d1))))

(defn print-rat
  "print rat"
  [rat]
  (let [n (number rat)
        d (denom rat)]
    (str n "/" d)))


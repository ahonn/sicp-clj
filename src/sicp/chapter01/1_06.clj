(ns sicp.chapter01.1-06)

;; Alyssa P. Hacker doesn't see why if needs to be provided as a special form. ``Why can't I just define it as an ordinary procedure in terms of cond?'' she asks. Alyssa's friend Eva Lu Ator claims this can indeed be done, and she defines a new version of if:

;; (define (new-if predicate then-clause else-clause)
  ;; (cond (predicate then-clause)
        ;; (else else-clause)))

;; Eva demonstrates the program for Alyssa:

;; (new-if (= 2 3) 0 5)
;; 5

;; (new-if (= 1 1) 0 5)
;; 0

;; Delighted, Alyssa uses new-if to rewrite the square-root program:

;; (define (sqrt-iter guess x)
  ;; (new-if (good-enough? guess x)
          ;; guess
          ;; (sqrt-iter (improve guess x)
                     ;; x)))

;; What happens when Alyssa attempts to use this to compute square roots? Explain.

(defn abs [x]
  (if (>= x 0)
    x
    (- x)))

(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn good-enough? [guess x]
  (< (abs (- (* guess guess)
             x))
     0.001))

(defn new-if [predicate then-clause else-clause]
  (cond
    predicate then-clause
    :else else-clause))

(defn sqrt-iter [guess x]
  (new-if (good-enough? guess x)
      guess
      (sqrt-iter (improve guess x)
                 x)))

;; (defn sqrt-iter [guess x]
  ;; (if (good-enough? guess x)
      ;; guess
      ;; (sqrt-iter (improve guess x)
                 ;; x)))

(defn sqrt [x]
  (sqrt-iter 1 x))

;; (println (sqrt 9))
;; Exception in thread "main" java.lang.StackOverflowError when use new-if, just like 1-05

;; e.g.
;; (defn test-if []
  ;; (if true
    ;; (print 1)
    ;; (print 0)))

;; (test-if)
;; Value => 1

;; (defn test-new-if []
  ;; (new-if true
    ;; (print 1)
    ;; (print 0)))

;; (test-new-if)
;; Value => 10

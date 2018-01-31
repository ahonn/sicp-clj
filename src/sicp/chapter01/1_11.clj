(ns sicp.chapter01.1-11)

;;A function f is defined by the rule that f(n) = n if n<3 and f(n) = f(n - 1) + 2f(n - 2) + 3f(n - 3) if n> 3. Write a procedure that computes f by means of a recursive process. Write a procedure that computes f by means of an iterative process.

;; Recursive process
(defn f [n]
  (if (< n 3)
    n
    (+ (f (- n 1))
       (* 2 (f (- n 2)))
       (* 3 (f (- n 3))))))

;; (println (f 4))

;; Iterative process
(defn f-iter [a b c n]
  (if (< n 3)
    a
    (f-iter (+ a (* 2 b) (* 3 c))
            a
            b
            (- n 1))))

(defn f [n]
 (if (< n 3)
    n
    (f-iter 2 1 0 n)))

;; (println (f 4))

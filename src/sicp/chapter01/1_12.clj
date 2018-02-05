(ns sicp.chapter01.1-12)

;; The following pattern of numbers is called Pascal's triangle.

;;     1
;;    1 1
;;   1 2 1
;;  1 3 3 1
;; 1 4 6 4 1

;; The numbers at the edge of the triangle are all 1, and each number inside the triangle is the sum of the two numbers above it.35 Write a procedure that computes elements of Pascal's triangle by means of a recursive process.

(defn pascal [row col]
  (if (or (= col 1) (= col row))
    1
    (+
     (pascal (dec row) (dec col))
     (pascal (dec row) col))))

;; Recursive process can't faster!!
;; (println (pascal 1024 512))

;; Iterative process
;; clojure: use the *' operator which supports arbitrary precision by automatically promoting the result to BigInt in case it would overflow
(defn factorial [n]
  (reduce *' (range 1 (inc n))))

;; https://en.wikipedia.org/wiki/Pascal's_triangle#Combinations
(defn pascal [row col]
  (/ (factorial row)
     (* (factorial col)
        (factorial (- row col)))))

;; (println (pascal 1024 512))


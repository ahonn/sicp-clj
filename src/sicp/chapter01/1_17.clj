(ns sicp.chapter01.1_17)

;;The exponentiation algorithms in this section are based on performing exponentiation by means of repeated multiplication. In a similar way, one can perform integer multiplication by means of repeated addition. The following multiplication procedure (in which it is assumed that our language can only add, not multiply) is analogous to the expt procedure:

;; (define (* a b)
  ;; (if (= b 0)
      ;; 0
      ;; (+ a (* a (- b 1)))))

;; This algorithm takes a number of steps that is linear in b. Now suppose we include, together with addition, operations double, which doubles an integer, and halve, which divides an (even) integer by 2. Using these, design a multiplication procedure analogous to fast-expt that uses a logarithmic number of steps.

(defn double! [n]
  (* n 2))

(defn halve! [n]
  (/ n 2))

(defn multi [a b]
  (cond
    (= a 1) b
    (= b 1) a
    (even? b) (double! (multi a (halve! b)))
    :else (+ a (multi a (dec b)))))

;; (println (multi 4 9))

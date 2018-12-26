(ns sicp.chapter01.1_02)

;; Translate the following expression into prefix form (5 + 4 + (2 - (3 - (6 + 4/5)))) / (3 * (6 - 2) * (2 - 7))

(defn calc []
  (/ (+ 5 4
        (- 2
           (- 3
              (+ 6
                 (/ 4 5)))))
     (* 3
        (- 6 2)
        (- 2 7))))

;; (println (calc))
;; Value => -37/150

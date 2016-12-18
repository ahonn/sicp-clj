(define (>= a b)
  (or (> a b) (= a b)))

(define (add-max-two x y z) 
  (cond ((and (>= x z) (>= y z)) (+ x y))
        ((and (>= x y) (>= z y)) (+ x z))
        ((and (>= y x) (>= z x)) (+ y z))))
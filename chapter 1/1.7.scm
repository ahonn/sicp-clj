(define (good-enough? old-guess new-guess)
  (< (/ (abs (- new-guess old-guess)) old-guess) 0.01))

(define (average x y)
  (/ (+ x y) 2))

(define (improve guess x)
  (average guess (/ x guess)))

(define (sqrt-iter guess x)
  (if (good-enough? guess (improve guess x))
      (improve guess x)
      (sqrt-iter (improve guess x)
                  x)))

(define (sqrt x)
  (sqrt-iter 1 x))
;; Consider the problem of representing line segments in a plane. Each segment is represented as a pair of points: a starting point and an ending point. Define a constructor make-segment and selectors start-segment and end-segment that define the representation of segments in terms of points. Furthermore, a point can be represented as a pair of numbers: the x coordinate and the y coordinate. Accordingly, specify a constructor make-point and selectors x-point and y-point that define this representation. Finally, using your selectors and constructors, define a procedure midpoint-segment that takes a line segment as argument and returns its midpoint (the point whose coordinates are the average of the coordinates of the endpoints). To try your procedures, you'll need a way to print points:

;; (define (print-point p)
;;   (newline)
;;   (display "(")
;;   (display (x-point p))
;;   (display ",")
;;   (display (y-point p))
;;   (display ")"))

(ns sicp.chapter02.2_2)

(defn make-segment
  "make segment by two point"
  [point1 point2]
  (seq [point1 point2]))

(defn start-segment
  "get segment start point"
  [segment]
  (first segment))

(defn end-segment
  "get segment end point"
  [segment]
  (last segment))

(defn make-point
  "make point by x and y"
  [x y]
  (seq [x y]))

(defn x-point
  "get point x coordinate"
  [point]
  (first point))

(defn y-point
  "get point y coordinate"
  [point]
  (last point))

(defn midpoint-segment
  "get the point whose coordinates are the average of the coordinates of the endpoints"
  [segment]
  (let [average2 #(/ (+ %1 %2) 2)
        start (start-segment segment)
        end (end-segment segment)
        x (average2 (x-point start) (x-point end))
        y (average2 (y-point start) (y-point end))]
    (make-point x y)))

(defn print-point
  "ptint point"
  [point]
  (let [x (x-point point)
        y (y-point point)]
    (str "(" x ", " y ")")))


(ns cl.add
  (:gen-class :methods [^:static [add [int int] int]]))

(defn -add [a b]
  (+ a b))
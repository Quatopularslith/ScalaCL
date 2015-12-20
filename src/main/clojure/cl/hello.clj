(ns cl.hello
  (:gen-class
    :name cl.hello
    :methods [
              #^:static [printhello [] void]
              #^:static [printhi [] void]
              #^:static [gutentag [] void]
              ]))

(defn -printhello []
  (println "Hello from clojure!"))

(defn -printhi []
  (println "Hi from clojure!"))

(defn -gutentag []
  (println "Guten Tag aus clojure!"))

(defn printhi [] (printhi))

(printhi)
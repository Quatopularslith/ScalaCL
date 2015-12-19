(ns cl.bye
  (:gen-class :methods [^:static [printBye [] void]]))

(defn -printBye [] (println "Bye"))
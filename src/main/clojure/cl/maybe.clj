(ns cl.maybe
  (:gen-class :methods [^:static [printMaybe [] void]]))

(defn -printMaybe [] (println "Maybe"))
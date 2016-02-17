(ns stox.core
  (:gen-class))

(def account [{:base_url "https://api.stockfighter.io/ob/api"
             :apikey "e4df4c339dff311d0e1482c26b4192ac328e666a"
             :venue "EUADEX"
             :stock "PBC"}])

(defn -main
  "Main method for gettin' stoxxx"
  [& args]
  (println "ello, World!"))

(println "Cleanliness!!!!!!!!!!!")

(defn limit
  "Place a limit order."
  [{:keys [base_url apikey venue stock]}]
  ())

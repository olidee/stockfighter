(ns stox.core
  (:require [clj-http.client :as client])
  (:gen-class))

(def auth {:headers {"X-Starfighter-Authorization" "83f6b1097a2d892d24c81cc3329816425bc16e5e"}})
(def creds {:account "GFS20083343"
            :venue "PDEPEX"
            :stock "LWIM"})

(defn req
  [endpoint]
  (str "https://api.stockfighter.io/ob/api/venues/" (:venue creds) "/stocks/" (:stock creds) "/" endpoint))

(defn get-quote
  "Get quote for stock."
  []
  (client/get (req "quote") auth))

(defn order
  "Place an order."
  [type dir qty price]
  (client/post (req "orders") (conj auth {:content-type :json
                                          :form-params {:account (:account creds)
                                                        :venue (:venue creds)
                                                        :symbol (:stock creds)
                                                        :orderType type
                                                        :direction dir
                                                        :price price
                                                        :qty qty}})))

(def limit (partial order :limit))
(def fok (partial order :fill-or-kill))
(def ioc (partial order :immediate-or-cancel))

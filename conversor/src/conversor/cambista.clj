(ns conversor.cambista
  (:require [clj-http.client :as http-client]
            [cheshire.core :refer [parse-string]]))

(def chave "9e35b76c78aa95255f0f")

(def api-url "https://free.currconv.com/api/v7/convert")

(defn- parametrizar-moedas [de para]
  (nu/tap(str de "_" para)))

(defn obter-cotacao [de para]
  (let [moedas (parametrizar-moedas de para)]
    (-> (:body (http-client/get api-url
                                {:query-params { "q" moedas
                                                "apiKey" chave}}))
        (parse-string)
        (get-in ["results" moedas "val"]))))

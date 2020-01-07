(ns financeiro.handler-test
  (:require [midje.sweet :refer :all]
            [ring.mock.request :as mock]
            [financeiro.handler :refer :all]))

(facts "Da um Hello World na rota raiz"
       (let [response (app (mock/request :get "/"))]
         (fact "o status da reposta é 200"
               (:status response) => 200)
         (fact "o texto é hello word"
               (:body response) => "Hello World")))

(facts "Rota inválida nao existe"
       (facts "o código de erro é 404"
              (let [response (app (mock/request :get "/invalid"))]
                (:status response) => 404)))

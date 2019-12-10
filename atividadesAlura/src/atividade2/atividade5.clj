(ns atividade2.atividade5)

(def estoque { "Mochila" 10, "Camiseta" 5})
(println estoque)

(println "Tempos" (count estoque) "elementos")
(println "Chaves são:" (keys estoque))


;keyword
(def estoque {:mochila 10
              :camiseta 5})

(println (assoc estoque :cadeira 3))

(println estoque)
(println (update estoque :mochila inc))



(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(def pedido (assoc pedido :chaveiro {:quantidade 1, :preco 10}))

(println pedido)
(println (pedido :mochila))                                 ; mapa como funcao

; THREADING
(println (-> pedido
             :mochila
             :quantidade))

;Dado o mapa a seguir:
(def clientes { :15 { :nome "Guilherme" :certificados ["Clojure" "Java" "Machine Learning"] } })

;Como extrair o total de certificados que o Guilherme tem?
(-> clientes :15 :certificados count)
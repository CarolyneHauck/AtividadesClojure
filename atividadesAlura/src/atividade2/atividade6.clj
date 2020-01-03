(ns atividade2.atividade6)


(def pedido {:mochila { :quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(defn imprime-e-15 [valor]
  (println "valor" valor)
  15)

(println (map imprime-e-15 pedido))


; Calcular o valor dos pedidos
(defn preco-dos-produtos [[chave valor]]
  ( * (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))

; Resultado da soma de todos os pedidos
(println (reduce + (map preco-dos-produtos pedido)))

; Final:

(def pedido {:mochila { :quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(defn preco-total-do-produto [produto]
  (* (:quantidade produto) (:preco produto)))

(defn total-do-pedido
  [pedido]
  (->> pedido
       vals
       (map preco-total-do-produto)
       (reduce +))
  (reduce + (map preco-dos-produtos pedido)))

(println (total-do-pedido pedido))



;;


(def pedido {:mochila { :quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             :chaveiro {:quantidade 1}})

(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(println (filter (fn [[chave item]] (gratuito? item)) pedido))


;;


;Dado o vetor a seguir:

(def clientes [{:nome "Guilherme" :certificados ["Clojure" "Java" "Machine Learning"] }
               { :nome "Paulo" :certificados ["Java" "Ciência da Computação"] }
               { :nome "Daniela" :certificados ["Arquitetura" "Gastronomia"] }])

;Como calcular o total de certificados de todos os clientes?
;Extraimos os certificados, contamos e depois somamos
(->> clientes (map :certificados) (map count) (reduce +))
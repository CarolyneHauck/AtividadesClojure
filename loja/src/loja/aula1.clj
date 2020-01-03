(ns loja.aula1
  (:require [loja.db]
            [loja.logic :as loja.logic]))

(println (loja.logic/resumo-por-usuario (loja.db/todos-os-pedidos)))

(let [pedidos (loja.db/todos-os-pedidos)
      resumo (loja.logic/resumo-por-usuario pedidos)]
  (println "Resumo" resumo)
  (println "Ordenado" (sort-by :preco-total resumo))
  (println "Ordenado ao contrario" (reverse (sort-by :preco-total resumo)))
  (println "Ordrnado por id" (sort-by :usuario-id resumo))
  (println (get-in pedidos [0 :itens :mochila :quantidade])))


(defn resumo-por-usuario-ordenado [pedidos]
  (->> pedidos
       loja.logic/resumo-por-usuario
       (sort-by :preco-total)))

(let [pedidos (todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "Resumo" resumo))

;:require [loja.db :refer :all]



(println (loja.logic/total-de-camisas-vendidas (loja.db/todos-os-pedidos)))
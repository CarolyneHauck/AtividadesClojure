; Representacao de um banco em memoria.
(ns loja.db)

(def pedido1 {:usuario 15
              :itens {:mochila  {:id :mochila, :quantidade 2, :preco-unitario 80}
                      :camiseta {:id :camiseta, :quantidade 3, :preco-unitario 40}
                      :tenis    {:id :tenis, :quantidade 1, :preco-unitario 100}}})

(def pedido2 {:usuario 1
              :itens {:mochila  {:id :mochila, :quantidade 2, :preco-unitario 80}
                      :camiseta {:id :camiseta, :quantidade 3, :preco-unitario 40}
                      :tenis    {:id :tenis, :quantidade 1, :preco-unitario 100}}})

(def pedido3 {:usuario 15
              :itens {:mochila  {:id :mochila, :quantidade 2, :preco-unitario 80}
                      :camiseta {:id :camiseta, :quantidade 3, :preco-unitario 40}
                      :tenis    {:id :tenis, :quantidade 1, :preco-unitario 100}}})

(def pedido4 {:usuario 10
              :itens {:mochila  {:id :mochila, :quantidade 2, :preco-unitario 80}
                      :camiseta {:id :camiseta, :quantidade 3, :preco-unitario 40}
                      :tenis    {:id :tenis, :quantidade 1, :preco-unitario 100}}})

(def pedido5 {:usuario 19
              :itens {:mochila  {:id :mochila, :quantidade 2, :preco-unitario 80}
                      :camiseta {:id :camiseta, :quantidade 10, :preco-unitario 40}
                      :tenis    {:id :tenis, :quantidade 8, :preco-unitario 100}}})

(defn todos-os-pedidos []
  [pedido1 pedido2 pedido3 pedido4 pedido5])
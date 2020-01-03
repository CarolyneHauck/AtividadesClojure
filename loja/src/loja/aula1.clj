(ns loja.aula1
  (:require [loja.db :as loja.db]
            [loja.logic :as loja.logic]))

(println (loja.logic/resumo-por-usuario (loja.db/todos-os-pedidos)))

(ns atividade2.atividade8)

; TAIL RECURSION
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not(nil? primeiro))
      (do
        (funcao primeiro)
        (recur funcao(rest sequencia))))))

;RECUR so pode aparecer como retorno da funcao, isto é, na cauda, em um if por
;exemplo os dois caminhos podem apresentar um recur

(meu-mapa println (range 5000))
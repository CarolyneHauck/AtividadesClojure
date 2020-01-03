(ns atividade2.atividade7)

(map println ["carol" "celio" "daniel"])
(println (first ["carol" "celio" "daniel"]))

; funcao de recursao

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not(nil? primeiro))
      (do
        (funcao primeiro)
        (meu-mapa funcao(rest sequencia))))))

(meu-mapa println ["carol" "celio" "daniel"])
(meu-mapa println [])
(meu-mapa println nil)

import { useState } from "react";
import styles from "./FormularioFicha.module.css";



function FormularioFicha() {
    const [nome, setNome] = useState("");
    const [peso, setPeso] = useState("");
    const [objetivo, setObjetivo] = useState("Manutenção");
    const [frequenciaMusculacao, setFrequenciaMusculacao] = useState("");
    const [percentualGordura, setPercentualGordura] = useState("");

    async function cadastrar() {
        const cliente = {
            "nome" : nome,
            "peso" : Number(peso),
            "objetivo" : objetivo,
            "frequenciaMusculacao" : Number(frequenciaMusculacao),
            "percentualGordura" : percentualGordura === "" ? null : Number(percentualGordura) 
        }

        const resposta = await fetch("http://localhost:8080/fichas", {
            method: "POST",
            headers: {"Content-Type" : "application/json"},
            body: JSON.stringify(cliente)
            } 
        );

            if(resposta.ok) {
            alert("Ficha cadastrada");
            window.location.reload();
            }else {
            alert("Erro ao cadastrar a ficha");
            }
        }

        return (
            <div className={styles.formulario}>
                <h2>Cadastrar ficha</h2>

                <input className={styles.input} placeholder="Nome"
                value={nome}
                 type="text" 
                 onChange={(e) => setNome(e.target.value)}/>

                 <input className={styles.input} placeholder="Peso"
                 value={peso}
                  type="number" 
                  onChange={(e) => setPeso(e.target.value)}/>

                <select className={styles.input} value={objetivo} onChange={(e) => setObjetivo(e.target.value)}>
                    <option value="Cutting">Cutting</option>
                    <option value="Manutenção">Manutenção</option>
                    <option value="Bulking">Bulking</option>
                </select>

                <input className={styles.input} type="number"
                placeholder="Frequência de musculação"
                value={frequenciaMusculacao}
                onChange={(e) => setFrequenciaMusculacao(e.target.value)} />

                <input className={styles.input}  type="number"
                placeholder="% de gordura (opcional)"
                value={percentualGordura}
                onChange={(e) => setPercentualGordura(e.target.value)} />
                
                <button className={styles.botao} onClick={cadastrar}>Cadastrar</button>

            </div>
        )
    }

    export default FormularioFicha;


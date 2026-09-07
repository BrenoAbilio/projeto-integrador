import styles from "./Ficha.module.css"

function Ficha({ fichaProp }) {
    return (
        <div className={styles.card}>
            <h3>{fichaProp.nome}</h3>
            <p>Peso: {fichaProp.peso} kg</p>
            <p>Objetivo: {fichaProp.objetivo}</p>
            <p>Frequência: {fichaProp.frequenciaMusculacao} vezes por semana</p>
            <p>Percentual de gordura: {fichaProp.percentualGordura ?? "Não informado"}</p>
            <h2>Proteína diária: {fichaProp.proteinaDiaria} g de proteína</h2>
        </div>
    )
}

export default Ficha;
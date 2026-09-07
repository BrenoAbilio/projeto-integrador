    import { useEffect, useState } from "react";
    import Ficha from "./Ficha";

    import styles from "./ListaFichas.module.css";

    function ListaFichas() {
        const [fichas, setFichas] = useState([]);
        const [carregando, setCarregando] = useState(true);
        const [erro, setErro] = useState(false);

    useEffect(() => {
        async function buscarFichas() {
            try {
                const resposta = await fetch("http://localhost:8080/fichas");
                const dados = await resposta.json();
                setFichas(dados);
            } catch {
                setErro(true);
            } finally {
                setCarregando(false);
            }
        }

        buscarFichas();
    }, []);

        if (carregando) {
            return <p>Carregando fichas...</p>;
        }

        if (erro) {
            return <p>Erro ao carregar as fichas</p>
        }

        return (
            <div className={styles.lista}>
                <h2>Fichas cadastradas</h2>
        
                <div className={styles.grid}>
                    {fichas.map((fichaParam) => (
                        <Ficha
                            key={fichaParam.id}
                            fichaProp={fichaParam}
                        />
                    ))}
                </div>
            </div>
        );
    }

    export default ListaFichas;